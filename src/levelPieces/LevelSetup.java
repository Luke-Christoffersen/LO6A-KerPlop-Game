package levelPieces;

import java.util.ArrayList;
import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.Moveable;

public class LevelSetup {
	
	// Private member variables
	private Drawable[] board;
	private ArrayList<Moveable> movingPieces;
	private ArrayList<GamePiece> interactingPieces;
	private int playerStartLoc;
	
	// Constructor for LevelSetup
	public LevelSetup() {
		board = new Drawable[GameEngine.BOARD_SIZE];
		movingPieces = new ArrayList<>();
		interactingPieces = new ArrayList<>();
		playerStartLoc = 0;
	}

	public void createLevel(int levelNum) {
		// Clear out the game board and pieces lists
		board = new Drawable[GameEngine.BOARD_SIZE];
		movingPieces = new ArrayList<>();
		interactingPieces = new ArrayList<>();
		
		if (levelNum == 1) {
			// Set the player start location
			playerStartLoc = 10;

			// Create the game pieces
			Coin coin0 = new Coin('C', "Coin", 1, false);
			Coin coin1 = new Coin('C', "Coin", 9, false);
			Goal goal = new Goal('X', "Goal", 18);
			SpikePit pit = new SpikePit('^', "Spike Pit", 7);
			Duck duck1 = new Duck('D', "Duck", 15);
			Duck duck2 = new Duck('D', "Duck", 12);
			SpinningTrap spinner = new SpinningTrap('-', "Spinning Trap", 5);
			Wind wind = new Wind();
			
			// Add the pieces to the board
			board[coin0.getLocation()] = coin0;
			board[coin1.getLocation()] = coin1;
			board[goal.getLocation()] = goal;
			board[pit.getLocation()] = pit;
			board[spinner.getLocation()] = spinner;
			board[duck1.getLocation()] = duck1;
			board[duck2.getLocation()] = duck2;
			board[12] = wind;

			// Add the interacting pieces to the list
			interactingPieces.add(coin0);
			interactingPieces.add(coin1);
			interactingPieces.add(goal);
			interactingPieces.add(pit);
			interactingPieces.add(spinner);
			
			// Add the moving pieces to the list
			movingPieces.add(duck1);
			movingPieces.add(duck2);
		}
		else if (levelNum == 2) {
			// Set the player start location
			playerStartLoc = 10;

			// Create the game pieces
			Coin coin0 = new Coin('C', "Coin", 1, false);
			Coin coin1 = new Coin('C', "Coin", 16, false);
			Goal goal = new Goal('X', "Goal", 18);
			SpikePit pit = new SpikePit('^', "Spike Pit", 7);
			Goblin goblin = new Goblin('G', "Goblin", 14);
			Duck duck = new Duck('D', "Duck", 4);
			Wind wind = new Wind();
			
			// Add each piece to the game board
			board[coin0.getLocation()] = coin0;
			board[coin1.getLocation()] = coin1;
			board[goal.getLocation()] = goal;
			board[pit.getLocation()] = pit;
			board[goblin.getLocation()] = goblin;
			board[duck.getLocation()] = duck;
			board[12] = wind;
			
			// Add the interacting pieces to the list
			interactingPieces.add(coin0);
			interactingPieces.add(coin1);
			interactingPieces.add(goal);
			interactingPieces.add(pit);
			interactingPieces.add(goblin);
			interactingPieces.add(duck);
			
			// Add the moveable pieces to the list
			movingPieces.add(duck);
			movingPieces.add(goblin);
		}
	}

	public Drawable[] getBoard() {
		// Return the game board
		return board;
	}

	public ArrayList<Moveable> getMovingPieces() {
		// Return the list of moving pieces
		return movingPieces;
	}

	public ArrayList<GamePiece> getInteractingPieces() {
		// Return the list of interactive pieces
		return interactingPieces;
	}

	public int getPlayerStartLoc() {
		// Return the player start location
		return playerStartLoc;
	}

}
