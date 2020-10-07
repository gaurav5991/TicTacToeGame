package com.bridgelabz.tictactoe;

import java.util.Scanner;

public class TicTacToeGame {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe");

        TicTacToeGame game = new TicTacToeGame();
        char[] board = creatgameBoard();

        char[] input = userInput();
        System.out.println("Player Input: " + input[0]);
        System.out.println("Computer Input: " + input[1]);

        displayGameBoard();
    }

    /*Board Created*/

    public static char[] creatgameBoard() {
        int gameBoardSize = 10;
        char[] gameBoard = new char[gameBoardSize];
        for (int i = 1; i < gameBoardSize; i++) {
            gameBoard[i] = ' ';
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
        creatgameBoard();
        System.out.println(creatgameBoard()[1] + " | " + creatgameBoard()[2] + " | " + creatgameBoard()[3]);
        System.out.println("-----------");
        System.out.println(creatgameBoard()[4] + " | " + creatgameBoard()[5] + " | " + creatgameBoard()[6]);
        System.out.println("-----------");
        System.out.println(creatgameBoard()[7] + " | " + creatgameBoard()[8] + " | " + creatgameBoard()[9]);
    }
}