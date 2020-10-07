package com.bridgelabz.tictactoe;

import java.util.Scanner;

public class TicTacToeGame {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe");
        System.out.println("Enter the Symbol: ");
        char[] input = userInput();

        char[] board = creategameBoard();

        System.out.println("Enter index you want to move from 1 to 9");
        int index = sc.nextInt();

        makeAMove(index, input[0]);
        displayGameBoard();

        boolean result = isBoardHaveFreeSpaceOrNot();
        if(true){
            System.out.println("Make A Move");
            makeAMove(index,input[0]);
        }
        else{
            System.out.println("No Free Space!!");
        }

    }

    /*Board Created*/

    public static char[] creategameBoard() {
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
        System.out.println(creategameBoard()[1] + " | " + creategameBoard()[2] + " | " + creategameBoard()[3]);
        System.out.println("-----------");
        System.out.println(creategameBoard()[4] + " | " + creategameBoard()[5] + " | " + creategameBoard()[6]);
        System.out.println("-----------");
        System.out.println(creategameBoard()[7] + " | " + creategameBoard()[8] + " | " + creategameBoard()[9]);
    }

    /* Check Index to Make Move if its Empty*/
    public static boolean ifIndexEmptyOrNot(int index)
    {
        if (index > 0 && index <= 9 && creategameBoard()[index] == ' ')
        {
            return true;
        }
        else {
            return false;
        }
    }

    /*Make A Move */
    public static void makeAMove(int index,char moveSymbol){
        if(ifIndexEmptyOrNot(index)){
            creategameBoard()[index] = moveSymbol;
        }else {
            System.out.println("The index is Already Occupied.");
            System.out.println("Enter new Position");
            int newPosition = sc.nextInt();
            makeAMove(newPosition,moveSymbol);
        }
    }
    /*Check if Board Have Free Space*/

    public static boolean isBoardHaveFreeSpaceOrNot() {
        boolean flag = false;
        for (int i = 1; i < 10; i++)
            if (creategameBoard()[i] == ' ')
                flag = true;
        return flag;
    }
}