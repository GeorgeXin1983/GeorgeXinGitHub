package com.Rakuten.TicTacToe;

public class TicTacToeAction {
	 /** Initialize the game-board contents and the current states 
	  *  It can support two mode,0 means man-man mode,1 means man-computer node
	  */
	   public static void initGame() {
		  System.out.println("please select play mode,0 is man-man play,1 is man-computer play :");
		  Constants.MODE=Constants.in.nextInt();
	      for (int row = 0; row < Constants.ROWS; ++row) {
	         for (int col = 0; col < Constants.COLS; ++col) {
	            Constants.board[row][col] = Constants.EMPTY;  // all cells empty
	         }
	      }
	      Constants.currentState = Constants.PLAYING; // ready to play
	      Constants.currentPlayer= Constants.PlayerA;  // PlayerA plays first
	      
	   }
	   //the player select one grid to fill
	   public static void move(String currentPlayer,int mode) {
		 boolean isInput = false;  // whether player input a number or not
		 int row=0;
		 int col=0;
	      do {
	         if (currentPlayer.equals(Constants.PlayerA)) {
	            System.out.print("Player A, enter your move (row[1-3] column[1-3]),col and row is seperated by space:");
	         } else 
	        	 {
	        	  if(Constants.MODE==0){
	              System.out.print("Player B, enter your move (row[1-3] column[1-3]),col and row is seperated by space:");
	              }//only man-man mode need to type the message
	         }
	         
	         if(Constants.MODE==0||currentPlayer==Constants.PlayerA){
	           row=Constants.in.nextInt() - 1;
	           col=Constants.in.nextInt() - 1;
	         }else{
	        	//computer will fill the grid from [0-2],[0-2]
	        	row=Constants.random.nextInt(3);
	        	col=Constants.random.nextInt(3);
	         }
	         if (row >= 0 && row < Constants.ROWS && col >= 0 && col < Constants.COLS && Constants.board[row][col] == Constants.EMPTY) {
	        	 Constants.currntRow = row;
		         Constants.currentCol = col;
	        	 Constants.board[row][col] = currentPlayer;  // update game-board content
	             isInput = true;  // input okay, exit loop
	         } else {
	        	if(mode==0||(mode==1 &&currentPlayer.equals(Constants.PlayerA))){
	            System.out.println("This move at (" + (row + 1) + "," + (col + 1)
	                  + ") is not empty or invalid. Please Try again...");
	        	}
	         }
	      } while (!isInput); //repeat until input is valid
		}
	   //update status of game
	    public static void updateGameStatus(String player, int currentRow, int currentCol) {
	      if (hasWon(player, currentRow, currentCol)) {  // check if winning move
	         Constants.currentState = (player.equals(Constants.PlayerA)) ? Constants.PlayerA_WON : Constants.PlayerB_WON;
	      } else if (isDraw()) {  // check for draw
	         Constants.currentState = Constants.DRAW;
	      }
	      
	   }
	   public static boolean isDraw() {
		      for (int row = 0; row < Constants.ROWS; ++row) {
		         for (int col = 0; col < Constants.COLS; ++col) {
		            if (Constants.board[row][col].equals(Constants.EMPTY)) {
		               return false;  // an empty cell found, not draw, exit
		            }
		         }
		      }
		      return true;  // all empty cell is filled,so it is draw
		   }
	    public static boolean hasWon(String player, int currentRow, int currentCol) {
		      return (Constants.board[currentRow][0].equals(player)         // 3-in-the-row
		                   &&Constants. board[currentRow][1] == player
		                   &&Constants. board[currentRow][2] == player
		              || Constants.board[0][currentCol] == player      // 3-in-the-column
		                   && Constants.board[1][currentCol] == player
		                   && Constants.board[2][currentCol] == player
		              || currentRow == currentCol            // 3-in-the-diagonal
		                   &&Constants.board[0][0] == player
		                   &&Constants.board[1][1] == player
		                   &&Constants.board[2][2] == player
		              || currentRow + currentCol == 2  // 3-in-the-opposite-diagonal
		                   && Constants.board[0][2] == player
		                   &&Constants.board[1][1] == player
		                   && Constants.board[2][0] == player);
		   }
		 
		   /** Print the game board */
	   public static void printBoard() {
		   if(Constants.MODE==1){
			   System.out.println("It is computer's turn,the current board is:");
		   }
			  for (int row = 0; row < Constants.ROWS; ++row) {
		         for (int col = 0; col < Constants.COLS; ++col) {
		            System.out.print(Constants.board[row][col]); // print each of the cells
		            if (col != Constants.COLS - 1) {
		               System.out.print(" | ");   // print vertical partition
		            }
		         }
		         System.out.println();
		         if (row != Constants.ROWS - 1) {
		            System.out.println("-----------"); // print horizontal partition
		         }
		      }
		      System.out.println();
		   }
}
