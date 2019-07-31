package com.Rakuten.TicTacToe;

public class PlayTicTacToe {
   
	 public static void main(String[] args) {
		// TODO Auto-generated method stub
	    // Initialize the game-board and current status
	      TicTacToeAction.initGame();
	      // Play the game once
	      do {
	    	  TicTacToeAction.move(Constants.currentPlayer,Constants.MODE); 
	    	  TicTacToeAction.updateGameStatus(Constants.currentPlayer, Constants.currntRow, Constants.currentCol); // update currentState
	    	  TicTacToeAction.printBoard();
	         // Print message if game-over
	         if (Constants.currentState == Constants.PlayerA_WON) {
	            System.out.println("'PlayerA' won! Bye!");
	         } else if (Constants.currentState == Constants.PlayerB_WON) {
	        	if(Constants.MODE==0){
	             System.out.println("'PlayerB' won! Bye!");
	        	}else{
	        	 System.out.println("Computer won! Bye!");
	        	}
	         } else if (Constants.currentState == Constants.DRAW) {
	            System.out.println("It's a Draw! Bye!");
	         }
	         //switch player,if mode is selected to 1,playerB is computer
	         Constants.currentPlayer = (Constants.currentPlayer.equals(Constants.PlayerA)) ? Constants.PlayerB : Constants.PlayerA;
	        } while (Constants.currentState == Constants.PLAYING); // repeat if not game-over
	   }
	}


