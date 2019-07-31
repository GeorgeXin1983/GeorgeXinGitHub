package com.Rakuten.TicTacToe;

import java.util.Random;
import java.util.Scanner;
//define the Constants used in Tic-Tac-Toe
public class Constants {
	public static final String EMPTY = "";
	   public static final String PlayerA = "A";//playerA fill A in the board,playerB fill B in the board
	   public static final String PlayerB = "B";//playerB is human or computer,bases on the mode
	   public static int MODE=0;//mode 0 is human-human play, mode 1 is human-computer play
	   // Name-constants to represent the various states of the game
	   public static final int PLAYING = 0;
	   public static final int DRAW = 1;
	   public static final int PlayerA_WON = 1;
	   public static final int PlayerB_WON = 2;
	   public static final Random random=new Random();
	   // The game board and the game status
	   public static final int ROWS = 3, COLS = 3; // number of rows and columns
	   public static String[][] board = new String[ROWS][COLS]; // game board in 2D array,containing "O" and "X"
	   public static int currentState;  // the current state of the game,including PLAYING, DRAW, PlayerA_WON, PlayerB_WON)
	   public static String currentPlayer=""; // the current Player (A/B)
	   public static Scanner in = new Scanner(System.in);
	   public static int currntRow, currentCol;
}
