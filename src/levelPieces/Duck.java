package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;

import java.util.Random;
import gameEngine.Moveable;
import gameEngine.InteractionResult;

public class Duck extends GamePiece implements Drawable, Moveable{
	
	// Private member variables
	private char symbol;
	private String label;
	private int location;
	
	/*
	 * Constructor for a Duck moving game piece. This will be the randomly moving piece
	 * 
	 * @param symbol: Symbol that represents the duck ('D')
	 * @param label
	 * @param location: The value holding the location of the duck
	 * */
	public Duck(char symbol, String label, int location) {
		super(symbol, label, location);
	}
	
	@Override
	/*
	 * Overridden interact method from GamePiece. The duck moves around randomly and if it is in the same square as the player, it moves the player to a random location
	 * 
	 * @param gameBoard: An array of drawable symbols that makes up the game board
	 * @param playerLocation: Integer value representing the location of the duck
	 * */ 
	public InteractionResult interact(Drawable[] gameboard, int playerLocation) {
		
		// Random object creation
		Random randInt = new Random();
		// Generate a random number between 0-3
		int duckBehavior = randInt.nextInt(4);
		
		if ((getLocation() == playerLocation) && (duckBehavior == 1)) {
			// The player gets a point
			return InteractionResult.GET_POINT;
		}
		else if ((getLocation() == playerLocation) && (duckBehavior == 2)) {
			// The player gets hit
			return InteractionResult.HIT;
		}
		else if ((getLocation() == playerLocation) && (duckBehavior == 3)) {
			// The player advances to the next map
			return InteractionResult.ADVANCE;
		}
		else {
			// Default return case
			return InteractionResult.NONE;
		}
	}
	
	@Override
	// Overridden draw method from Drawable. Prints out the symbol of the duck
	public void draw() {
		System.out.print(this.symbol);
	}
	
	@Override
	/*
	 * Overridden move method from Moveable. Moves the duck to a random position on the board
	 * 
	 * @param gameBoard: An array of drawable symbols that makes up the game board
	 * @param playerLocation: Integer value representing the location of the duck
	 * */
	public void move(Drawable[] gameBoard, int playerLocation) {
		// @TODO: Have the duck move to a random location
		
		// Random object creation
		Random randPosition = new Random();
		
		// Generate a random game board location between 0-Board Size - 1
		int boardLocation = randPosition.nextInt(GameEngine.BOARD_SIZE);
		
		// Set the ducks location to the newly created location
		location = boardLocation;
	}
}
