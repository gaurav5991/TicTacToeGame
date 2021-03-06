package com.bridgelabz.tictactoe;

import java.util.Scanner;

public class TicTacToeGame {

    public static final Scanner scanner = new Scanner(System.in);
    public static char[] gameBoard = new char[10];

    public static void main(String[] args) {
       String choice = "yes";
        while(choice.equalsIgnoreCase("yes")){
            System.out.println("Welcome to Tic Tac Toe");
            char[] gameBoard = createGameBoard();
            System.out.println("Enter the Symbol: ");
            char playerSymbol = userInput();
            char computerSymbol = (playerSymbol == 'X' ? 'O' : 'X');
            displayGameBoard(gameBoard);
            System.out.println("Enter User Choice Whether its head/tail");
            String toss = scanner.next();
            String result = doTossToCheckTurn(toss);
            System.out.println(result + " won the toss");
            playGameTillEnd(gameBoard,playerSymbol,computerSymbol,result);
            System.out.println("Do you want to play Again");
            choice = scanner.next();
        }
    }

    /*Board Created*/
    public static char[] createGameBoard() {
        gameBoard[0] = ' ';
        for (int position = 1; position < 10; position++) {
            gameBoard[position] = ' ';
        }
        return gameBoard;
    }

    /*User and Computer Input*/
    public static char userInput() {
        System.out.println("User Input : x or o");
        char userSymbol = scanner.next().toUpperCase().charAt(0);
        System.out.println("Player Symbol: " + userSymbol);
        return userSymbol;
    }

    /*Show GameBoard*/
    public static char[] displayGameBoard(char[] gameBoard) {
        System.out.println(gameBoard[1] + " | " + gameBoard[2] + " | " + gameBoard[3]);
        System.out.println("-----------");
        System.out.println(gameBoard[4] + " | " + gameBoard[5] + " | " + gameBoard[6]);
        System.out.println("-----------");
        System.out.println(gameBoard[7] + " | " + gameBoard[8] + " | " + gameBoard[9]);

        return gameBoard;
    }

    /* Check Index to Make Move if its Empty*/
    public static boolean ifIndexEmptyOrNot(int index) {
        if (index > 0 && index <= 9 && gameBoard[index] == ' ')
            return true;
        else
            return false;
    }

    /*Check if Location is Free or Not*/
    public static boolean checkIfSpaceisFree(char[] gameBoard, int position) {
        return gameBoard[position] == ' ';
    }

    /*Make A Move */
    public static char[] makeAMove(char[] gameBoard, int index, char moveSymbol) {
        if (ifIndexEmptyOrNot(index)) {
            gameBoard[index] = moveSymbol;
        } else if (!checkIfSpaceisFree(gameBoard, index)) {
            System.out.println("The Position is Already Occupied");
            System.out.println("Enter new Position");
            int newPosition = scanner.nextInt();
            makeAMove(gameBoard, newPosition, moveSymbol);
        } else {
            System.out.println("Invalid Move");
            System.out.println("Enter new Position");
            int newPosition = scanner.nextInt();
            makeAMove(gameBoard, newPosition, moveSymbol);
        }
        return gameBoard;
    }

    /* Do A Toss*/
    public static String doTossToCheckTurn(String toss) {
        int flag;
        if (toss.equalsIgnoreCase("head"))
            flag = 0;
        else
            flag = 1;
        int tossResult = (int) Math.floor(Math.random() * 10) % 2;
        if (tossResult == flag) {
            return "Player";
        } else {
            return "Computer";
        }
    }

    public static int TakeCorner(char[] gameBoard) {
        int[] corners = {1, 3, 7, 9};
        for (int position = 0; position <= 3; position++)
            if (checkIfSpaceisFree(gameBoard, corners[position]))
                return position;
        return 0;
    }

    /*Block Opponent from Winning*/
    public static int blockOpponentFromWin(char[] gameBoard, char symbol) {
        int position = 0;
        position = winningPosition(gameBoard, symbol);
        return position;
    }

    /*Mark Winning Positions*/
    public static int winningPosition(char[] gameBoard, char symbol) {
        for (int position = 1; position <= 9; position++) {
            if (checkIfSpaceisFree(gameBoard, position)) {
                gameBoard[position] = symbol;
                if (winningCondition(gameBoard, symbol)) {
                    gameBoard[position] = ' ';
                    return position;
                }
                gameBoard[position] = ' ';
            }
        }
        return 0;
    }

    /*Condition for Winning*/

    public static boolean winningCondition(char[] gameBoard, char symbol) {
        return ((gameBoard[1] == symbol && gameBoard[2] == symbol && gameBoard[3] == symbol) || (gameBoard[4] == symbol && gameBoard[5] == symbol && gameBoard[6] == symbol)
                || (gameBoard[7] == symbol && gameBoard[8] == symbol && gameBoard[9] == symbol) || (gameBoard[1] == symbol && gameBoard[4] == symbol && gameBoard[7] == symbol)
                || (gameBoard[2] == symbol && gameBoard[5] == symbol && gameBoard[8] == symbol) || (gameBoard[3] == symbol && gameBoard[6] == symbol && gameBoard[9] == symbol)
                || (gameBoard[1] == symbol && gameBoard[5] == symbol && gameBoard[9] == symbol) || (gameBoard[3] == symbol && gameBoard[5] == symbol && gameBoard[7] == symbol));
    }

    /*Condition for Tie*/
    public static boolean toCheckForTie(char[] gameBoard) {
        for (char symbol : gameBoard) {
            if (symbol == ' ')
                return false;
        }
        return true;
    }

    /*Computer Play Like Me to Win*/
    public static boolean computerMove(char[] gameBoard, char computerSymbol,char playerSymbol) {
        int position = 0;
        position = winningPosition(gameBoard, computerSymbol);
        if (position != 0) {
            gameBoard[position] = computerSymbol;
            return true;
        }
        int blockIndex = blockOpponentFromWin(gameBoard,playerSymbol);
        if (blockIndex != 0) {
            gameBoard[blockIndex] = computerSymbol;
            return false;
        }
        position = TakeCorner(gameBoard);
        if (position == 0) {
            position = chooseCenterOrSide(gameBoard);
        }
        gameBoard[position] = computerSymbol;
        return false;
    }

    /*Ability to choose Center than Sides Respectively*/
    public static int chooseCenterOrSide(char[] gameBoard) {
        if (checkIfSpaceisFree(gameBoard, 5))
            return 5;
        int[] side = { 2, 4, 6, 8 };
        for (int position = 0; position <= 3; position++)
            if (checkIfSpaceisFree(gameBoard, side[position]))
                return position;
        return 0;
    }

    /*Play Game till End*/
    public static void playGameTillEnd(char[] gameBoard, char playerSymbol, char computerSymbol, String firstPlayer) {
        int toss;
        if(firstPlayer.equalsIgnoreCase("Player"))
            toss = 0;
        else
            toss = 1;
        while (!toCheckForTie(gameBoard)) {
            if (toss == 0) {
                System.out.println("Enter the Position from 1 to 9: ");
                int position = scanner.nextInt();
                gameBoard = makeAMove(gameBoard,position, playerSymbol);
                if (winningCondition(gameBoard, playerSymbol)) {
                    System.out.println("Player Won");
                    return;
                }
                toss = 1;
            } else {
                System.out.println("changing turn");
                if (computerMove(gameBoard, computerSymbol, playerSymbol)) {
                    displayGameBoard(gameBoard);
                    System.out.println("computer is the winner");
                    return;
                }
                toss = 0;
            }
            displayGameBoard(gameBoard);
        }
        System.out.println("its a tie");
    }
}