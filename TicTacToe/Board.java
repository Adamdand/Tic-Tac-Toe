package TicTacToe;


//STUDENTS SHOULD ADD CLASS COMMENTS, METHOD COMMENTS, FIELD COMMENTS 

/**
 *Creates a 3X3 playing board
 */
public class Board implements Constants {
	private char theBoard[][];
	private int markCount;

	public Board() {
		markCount = 0;
		setTheBoard(new char[3][]);
		for (int i = 0; i < 3; i++) {
			getTheBoard()[i] = new char[3];
			for (int j = 0; j < 3; j++)
				getTheBoard()[i][j] = SPACE_CHAR;
		}
	}
	/**
	 *Check what mark is at a location on the board
	 *I used this to make sure that a player cannot place
	 *their mark on top of another mark
	 */
	public char getMark(int row, int col) {
		return getTheBoard()[row][col];
	}

	/**
	 *checks if the 3X3 board is full (all positions are used)
	 */
	public boolean isFull() {
		return markCount == 9;
	}

	/**
	 *If last character entered was an "X"
	 *then player X wins
	 */
	public boolean xWins() {
		if (checkWinner(LETTER_X) == 1)
			return true;
		else
			return false;
	}

	/**
	 *If last character entered was an "O"
	 *then player O wins
	 */
	public boolean oWins() {
		if (checkWinner(LETTER_O) == 1)
			return true;
		else
			return false;
	}

	/**
	 * display the 3X3 board
	 * uses combinations of spaces, dashes, lines, and plus signs
	 */
	public void display() {
		displayColumnHeaders();
		addHyphens();
		for (int row = 0; row < 3; row++) {
			addSpaces();
			System.out.print("    row " + row + ' ');
			for (int col = 0; col < 3; col++)
				System.out.print("|  " + getMark(row, col) + "  ");
			System.out.println("|");
			addSpaces();
			addHyphens();
		}
	}

	/**
	 * After player "moves", place their mark at
	 * the location that they chose on the board
	 */
	public void addMark(int row, int col, char mark) {
		getTheBoard()[row][col] = mark;
		markCount++;
	}

	public void clear() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				getTheBoard()[i][j] = SPACE_CHAR;
		markCount = 0;
	}

	/**
	 * Check for game end conditions
	 *If there is a row/column of "X" or "O"'s
	 *Or if all 9 coordinates are full (tie game)
	 */
	int checkWinner(char mark) {
		int row, col;
		int result = 0;

		//check for row win
		for (row = 0; result == 0 && row < 3; row++) {
			int row_result = 1;
			for (col = 0; row_result == 1 && col < 3; col++)
				if (getTheBoard()[row][col] != mark)
					row_result = 0;
			if (row_result != 0)
				result = 1;
		}

		//check for column win
		for (col = 0; result == 0 && col < 3; col++) {
			int col_result = 1;
			for (row = 0; col_result != 0 && row < 3; row++)
				if (getTheBoard()[row][col] != mark)
					col_result = 0;
			if (col_result != 0)
				result = 1;
		}

		//check for diagonal win
		if (result == 0) {
			int diag1Result = 1;
			for (row = 0; diag1Result != 0 && row < 3; row++)
				if (getTheBoard()[row][row] != mark)
					diag1Result = 0;
			if (diag1Result != 0)
				result = 1;
		}
		//check for other diagonal win
		if (result == 0) {
			int diag2Result = 1;
			for (row = 0; diag2Result != 0 && row < 3; row++)
				if (getTheBoard()[row][3 - 1 - row] != mark)
					diag2Result = 0;
			if (diag2Result != 0)
				result = 1;
		}
		return result;
	}

	/**
	 * Displays column heads for the board visualization
	 */
	void displayColumnHeaders() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|col " + j);
		System.out.println();
	}
	
	/**
	 * adding spaces, hyphens, and pluss signs to create a visualization of the board
	 */
	//hyphens
	void addHyphens() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("+-----");
		System.out.println("+");
	}
	//spaces
	void addSpaces() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|     ");
		System.out.println("|");
	}
	
	/**
	 * Show the board
	 */
	public char[][] getTheBoard() {
		return theBoard;
	}
	
	/**
	 * I created this function to call a board location, checking if the coordiantes are already taken by a player
	 * this function is called within the move() function, to make sure the move is available
	 */
	public int getBoardLocation(int row, int col){
		if(theBoard[row][col] == 'X' || theBoard[row][col] == 'O') {
			return 1;
		}else{
			return 0;
		}
	}

	/**
	 * Set the board
	 */
	public void setTheBoard(char theBoard[][]) {
		this.theBoard = theBoard;
	}
}
