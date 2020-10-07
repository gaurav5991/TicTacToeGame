package com.bridgelabz.tictactoe;

import java.util.Scanner;

public class TicTacToeGame {

    public static final Scanner sc = new Scanner(System.in);
    public static char []gameBoard = new char[10];

    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe");
        creategameBoard();

        System.out.println("Enter the Symbol: ");
        char[] input = userInput();

        System.out.println("User input " + input[0]);
        System.out.println("Computer input " + input[1]);

        System.out.println("Enter User Choice Whether its Head Or Tail");
        String toss = sc.next();
        int toss_result;
        String result = doTossToCheckTurn(toss);
        if (result.equals("USER"))
            toss_result = 1;
        else
            toss_result = 2;
        System.out.println(result + " won the toss");

        System.out.println("Enter index you want to move from 1 to 9");
        int index = sc.nextInt();

        System.out.println("Display gameBoard");
        makeAMove(index, input[0]);
    }

    /*Board Created*/

    public static char[] creategameBoard() {
        gameBoard[0]=' ';
        for (int i = 1; i < 10; i++) {
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
        System.out.println(gameBoard[1] + " | " + gameBoard[2] + " | " + gameBoard[3]);
        System.out.println("-----------");
        System.out.println(gameBoard[4] + " | " + gameBoard[5] + " | " + gameBoard[6]);
        System.out.println("-----------");
        System.out.println(gameBoard[7] + " | " + gameBoard[8] + " | " + gameBoard[9]);
    }

    /* Check Index to Make Move if its Empty*/
    public static boolean ifIndexEmptyOrNot(int index)
    {
        if (index > 0 && index <= 9 && gameBoard[index] == ' ')
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
            gameBoard[index] = moveSymbol;
            displayGameBoard();
        }else {
            System.out.println("The index is Invalid.");
            System.out.println("Enter new Position");
            int newPosition = sc.nextInt();
            makeAMove(newPosition,moveSymbol);
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
        if(tossResult==flag){
            return "Player";
        }else {
            return "Computer";
        }
    }
}