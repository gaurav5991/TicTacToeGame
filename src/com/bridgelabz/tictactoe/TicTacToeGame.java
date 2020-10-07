package com.bridgelabz.tictactoe;

import java.util.Scanner;

public class TicTacToeGame {

    public static final Scanner sc = new Scanner(System.in);
    public static char[] gameBoard = new char[10];

    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe");
        createGameBoard();
        System.out.println("Enter the Symbol: ");
        char[] input = userInput();
        System.out.println("User input " + input[0]);
        System.out.println("Computer input " + input[1]);
        System.out.println("Enter User Choice Whether its head/tail");
        String toss = sc.next();
        int toss_result;
        String result = doTossToCheckTurn(toss);
        if (result.equals("Player"))
            toss_result = 1;
        else
            toss_result = 2;
        System.out.println(result + " won the toss");

        displayGameBoard();
        boolean flag = false;
        switch (toss_result) {
            case 1: {
                while (true) {
                    System.out.println("Enter the Position of Choice");
                    int position = sc.nextInt();

                    makeAMove(position, input[0]);
                    boolean UserResult = winningCondition(input[0]);
                    if (UserResult == true) {
                        System.out.println("Player won");
                        flag = true;
                        break;
                    }
                }
            }

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
    public static char[] userInput() {
        System.out.println("User Input : x or o");
        char[] symbol = new char[2];
        symbol[0] = sc.next().charAt(0);
        symbol[1] = ' ';
        if (symbol[0] == 'x') {
            symbol[1] = 'o';
        } else {
            symbol[1] = 'x';
        }
        return symbol;
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
}