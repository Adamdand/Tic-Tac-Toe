package TicTacToe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Player {
	private String name; 
	private Board board;
	private Player opponent;
	private char mark; //"X" or "O"
	
	public Player(String name, char mark) {
		this.name = name;
		this.mark = mark;
		
	}

	/**
	 *calls makeMove(), as long as method xWin() and oWin(), and isFull() in the Board returns false. if any = true, announce game is over and display name of winner or if its a tie
	 *then display board after each move, checks for the winner, and then passes the turn to the other player
	 *show board
	 *check winner
	 */
	public void play() {
		
		//check for win conditions BEFORE the player can make a move
		if((board.xWins() == false) && (board.xWins() == false) && (board.isFull() == false)){
			}else if ((board.xWins() == false) && (board.xWins() == false) && (board.isFull() == true)){
				System.out.println("Game Over, TIE!!!");	// if game ends in a tie, output "tie"
				System.exit(mark);	// end game
				}else {
					System.out.println("The winner is: " + opponent.name + "!!!");	//checks AFTER each players turn, so if there is a winner, the winner was the LAST player to play
					System.exit(mark);	// end game
				}
				
		makeMove();	// otherwise if the game is not over, allow the player to make a move
		board.display();	// display the board and the players move


	}
	


	/**
	 *asks the player to make a move by entering the row and column numbers, and
	 *puts a "X" or "O" mark on the board by calling the method addMark() in class
	 *board
	 */
	public void makeMove() {

		//initalize variables used
		int error = 1;
		int rowMove = 1;
		int colMove = 1;

		while (error == 1) {	//while loop continues until "break" is hit. this way the player has to keep picking new moves until one is valid

			System.out.println(name + ", what row and column should your next " +  mark + " be placed in? (i.e. row 1 and column 2 = 1,2)"); // ask user for coordinates
			Scanner scanner = new Scanner(System.in);
			String input = scanner.next();

			String[] moves = input.split(","); // split the input string into X and Y coordinates, by splitting string
												// by comma
			rowMove = Integer.parseInt(moves[0]);	// convert input into an intiger from a string
			colMove = Integer.parseInt(moves[1]);	// convert input into an intiger from a string

			// check if the spot has already been taken
			if (board.getBoardLocation(rowMove, colMove) == 1) {
				System.out.println("This position is already taken, please choose another"); // if coordinates already taken, user goes back to beginning of loop and needs to choose again
			} else if (board.getBoardLocation(rowMove, colMove) == 0) {
				break;	// if user chooses a valid position, braek out of infinity loop
			}
		}

		board.addMark(rowMove, colMove, mark);	// as players mark to the board

	}


	/**
	 * set players opponent
	 */
	public void setOpponent(Player name) {
		opponent = name;
		
	}
	
	/**
	 * get players opponent
	 */
	public Player getOpponent() {
		return opponent;
	}
	
	/**
	 * set board
	 */
	public void setBoard(Board theBoard){
		this.board = theBoard;
	}


	
	/**
	 * I was going to give the user the option to reset the game and start again after winning/loosing
	 * however this was a busy week
	 */
	public void playAgain() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Would you like to play again? (y/n)");
		String answer;

		answer = reader.readLine();
		while (!answer.equals('y')) {
			System.out.println("Error. Would you like to play again? (y/n)");
			answer = reader.readLine();
		}
		if (answer == "n") {
			System.exit(0);
		}else if(answer =="y") {
			board.clear();
		}
		
	}
	
}
