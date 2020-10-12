package TicTacToe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Referee {
	public Player xPlayer;	// initalize player 1 (X)
	private Player oPlayer;	// initalize palyer 2 (O)
	private Board board;	// initalize board
	
	public Referee() {
		
	}
	
	/**
	 *calls the setOpponent method of class player
	 *sets opponents of the X- and O- players
	 *initiates the game, by displaying the board and calling the play method for the X-Player who is always the first player
	 */
	public void runTheGame() {

		
		xPlayer.setOpponent(oPlayer);	// set opponents
		oPlayer.setOpponent(xPlayer);	// set opponents
		board.display();	// display board
		
		
		/**
		 * forloop loops between giving player 1 and player 2 their turn to move()
		 */
		Player playerTurn = xPlayer;
		for(int turn = 1; turn >-1; turn++) {
			playerTurn.play();
			playerTurn=playerTurn.getOpponent();
			}
	}
	
	/**
	 * set board
	 */
	public void setBoard(Board board) {
		this.board = board;
	}
	
	/**
	 * set player o
	 */
	public void setoPlayer(Player oPlayer) {
		this.oPlayer = oPlayer;
	}
	
	/**
	 * set set player x
	 */
	public void setxPlayer(Player xPlayer) {
		this.xPlayer = xPlayer;
	}
	
	
	
	
}
