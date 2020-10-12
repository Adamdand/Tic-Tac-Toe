package TicTacToe;

import java.io.*;

//STUDENTS SHOULD ADD CLASS COMMENTS, METHOD COMMENTS, FIELD COMMENTS 


public class Game implements Constants {

	private Board theBoard; // initalize the board
	private Referee theRef; // initalize the referee
	
    public Game( ) {
        theBoard  = new Board(); // Composition (game has a board) -> board is constructed in a method in "Game"
	}
    
    /**
     * appoint a referee, and then start the game
     */
    public void appointReferee(Referee r) throws IOException {
        theRef = r;
    	theRef.runTheGame(); //referee starts the game
    }
	
	public static void main(String[] args) throws IOException {
		Referee theRef;
		Player xPlayer, oPlayer;
		BufferedReader stdin;
		Game theGame = new Game();
		stdin = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\nPlease enter the name of the \'X\' player: "); // get player 1's name (X)
		String name= stdin.readLine();	// player inputs name
		while (name == null) {	// make sure player inputs valid name
			System.out.print("Please try again: ");
			name = stdin.readLine();
		}

		xPlayer = new Player(name, LETTER_X);	// set player name and mark to xPlayer type player
		xPlayer.setBoard(theGame.theBoard);
		
		System.out.print("\nPlease enter the name of the \'O\' player: ");	// get player 2's name (O)
		name = stdin.readLine();	// player inputs name
		while (name == null) {	// make sure player inputs valid name
			System.out.print("Please try again: ");
			name = stdin.readLine();
		}
		
		oPlayer = new Player(name, LETTER_O);	// set player name and mark to oPlayer, type player
		oPlayer.setBoard(theGame.theBoard);	// set the board with new attributes and players
		
		theRef = new Referee();
		theRef.setBoard(theGame.theBoard);	// set up the board with referee rules and initalization
		theRef.setoPlayer(oPlayer);	// set player 1
		theRef.setxPlayer(xPlayer); // set player 2
        
        theGame.appointReferee(theRef);
	}
	

}
