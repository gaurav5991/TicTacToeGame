package com.bridgelabz.tictactoe;

import java.util.Scanner;

public class TicTacToeGame {

    public static final Scanner sc = new Scanner(System.in);
    public static char[] gameBoard = new char[10];

    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe");
        char []gameBoard = createGameBoard();
        System.out.println("Enter the Symbol: ");

        char playerSymbol = userInput();
        char computerSymbol = (playerSymbol=='X'?'O':'X');
        displayGameBoard();
        System.out.println("Enter User Choice Whether its head/tail");
        String toss = sc.next();
        int toss_result;
        String result = doTossToCheckTurn(toss);
        if (result.equals("Player"))
            toss_result = 1;
        else
            toss_result = 2;
        System.out.println(result + " won the toss");

        boolean flag = false;
        switch (toss_result) {
            case 1: {
                while (true) {
                    System.out.println("Player's Turn");
                    System.out.println("Enter the Location where you want to make a move between 1 to 9 ");
                    int location = sc.nextInt();

                    makeAMove(location, playerSymbol);
                    boolean winningPosition = winningCondition(playerSymbol);
                    if (winningPosition) {
                        System.out.println("Player Won Game");
                        flag = true;
                        break;
                    }

                    if(!checkIfSpaceisFree())
                        break;
                    System.out.println("Computer's Turn");
                    makeComputerMove(computerSymbol);
                    boolean ComputerWinningPosition = winningCondition(computerSymbol);
                    if (ComputerWinningPosition) {
                        System.out.println("Computer Won Game");
                        flag = true;
                        break;
                    }
                    if(!checkIfSpaceisFree())
                        break;
                }
                break;
            }
            case 2: {
                while (true){
                    System.out.println("Computer's Turn");
                    makeComputerMove(computerSymbol);
                    boolean ComputerWinningPosition = winningCondition(computerSymbol);
                    if (ComputerWinningPosition) {
                        System.out.println("Computer Won Game");
                        flag = true;
                        break;
                    }
                    if(!checkIfSpaceisFree())
                        break;
                    System.out.println("Player's Turn");
                    System.out.println("Enter the Location where you want to make a move between 1 to 9 ");
                    int location = sc.nextInt();

                    makeAMove(location, playerSymbol);
                    boolean winningPosition = winningCondition(playerSymbol);
                    if (winningPosition) {
                        System.out.println("Player Won Game");
                        flag = true;
                        break;
                    }

                    if(!checkIfSpaceisFree())
                        break;
                }
                break;
            }
        }
        if(flag==false)
            System.out.println("Game Draw");
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
        char userSymbol = sc.next().toUpperCase().charAt(0);
        System.out.println("Player Symbol: "+userSymbol);
        return userSymbol;
    }

    /*Show GameBoard*/
    public static void displayGameBoard() {
        System.out.println(gameBoard[1] + " | " + gameBoard[2] + " | " + gameBoard[3]);
        System.out.println("-----------");
        System.out.println(gameBoard[4] + " | " + gameBoard[5] + " | " + gameBoard[6]);
        System.out.println("-----------");
        System.out.println(gameBoard[7] + " | " + gameBoard[8] + " | " + gameBoard[9]);
    }

    /* Check Index to Make Move if its Empty*/
    public static boolean ifIndexEmptyOrNot(int index) {
        if (index > 0 && index <= 9 && gameBoard[index] == ' ')
            return true;
        else
            return false;
    }
    /*Check if Location is Free or Not*/
    public static boolean checkIfSpaceisFree() {
        boolean flag = false;
        for (int position = 1; position < 10; position++)
            if (gameBoard[position] == ' ')
                flag = true;
        return flag;
    }

    /*Make A Move */
    public static void makeAMove(int index, char moveSymbol) {
        if (ifIndexEmptyOrNot(index)) {
            gameBoard[index] = moveSymbol;
            displayGameBoard();
        } else {
            System.out.println("The index is Invalid.");
            System.out.println("Enter new Position");
            int newPosition = sc.nextInt();
            makeAMove(newPosition, moveSymbol);
        }
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

    /*Condition for Winning*/

    public static boolean winningCondition(char symbol) {
        return ((gameBoard[1] == symbol && gameBoard[2] == symbol && gameBoard[3] == symbol) || (gameBoard[4] == symbol && gameBoard[5] == symbol && gameBoard[6] == symbol)
                || (gameBoard[7] == symbol && gameBoard[8] == symbol && gameBoard[9] == symbol) || (gameBoard[1] == symbol && gameBoard[4] == symbol && gameBoard[7] == symbol)
                || (gameBoard[2] == symbol && gameBoard[5] == symbol && gameBoard[8] == symbol) || (gameBoard[3] == symbol && gameBoard[6] == symbol && gameBoard[9] == symbol)
                || (gameBoard[1] == symbol && gameBoard[5] == symbol && gameBoard[9] == symbol) || (gameBoard[3] == symbol && gameBoard[5] == symbol && gameBoard[7] == symbol));
    }

    /* Make Computer Move Like As a User*/
    public static void makeComputerMove(char symbol) {
        int location = (int) (Math.floor(Math.random() * 9) + 1);
        if (location > 0 && location < 10 && gameBoard[location] == ' ') {
            gameBoard[location] = symbol;
            displayGameBoard();
        } else {
            System.out.println("The Location is Invalid");
            int newLocation = (int) (Math.floor(Math.random() * 9) + 1);
            makeComputerMove(symbol);
        }
    }
}