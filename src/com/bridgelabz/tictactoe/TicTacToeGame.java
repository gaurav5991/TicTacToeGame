package com.bridgelabz.tictactoe;

public class TicTacToeGame {
    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        char[] board = game.creatgameBoard();

    }
    public char[] creatgameBoard(){
        int gameBoardSize = 10;
        char [] gameBoard = new char[gameBoardSize];
        for (int i= 0;i<gameBoardSize;i++){
            gameBoard[i] = ' ';
        }
        return gameBoard;
    }
}