package com.bridgelabz.tictactoe;

import java.util.Scanner;

public class TicTacToeGame {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe");

        TicTacToeGame game = new TicTacToeGame();
        char[] board = game.creatgameBoard();

        char input = TicTacToeGame.userInput();
        System.out.println("Player Input: "+input);

    }
    public char[] creatgameBoard(){
        int gameBoardSize = 10;
        char [] gameBoard = new char[gameBoardSize];
        for (int i= 0;i<gameBoardSize;i++){
            gameBoard[i] = ' ';
        }
        return gameBoard;
    }

    public static char userInput(){
        System.out.println("User Input : x or o");
        char symbol = sc.next().charAt(0);

        return  symbol;
    }
}