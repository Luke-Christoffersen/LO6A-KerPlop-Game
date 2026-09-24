package levelPieces;

import gameEngine.InteractionResult;

import java.util.Random;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.Moveable;

public class Goblin extends GamePiece implements Drawable, Moveable{

	// Private member variables
	private char symbol;
	private String label;
	private int location;
	
	/*
	 * Constructor for a Goblin moving game piece. This will be the randomly moving piece
	 * 
	 * @param symbol: Symbol that represents the duck ('G')
	 * @param label
	 * @param location: The value holding the location of the duck
	 * */
	public Goblin(char symbol, String label, int location) {
		super(symbol, label, location);
	}
	
	@Override
	/*
	 * Overridden interact method from GamePiece. The goblin does one hit the first time it interacts with the player, then will kill the player on the second interaction
	 * 
	 * @param gameBoard: An array of drawable symbols that makes up the game board
	 * @param playerLocation: Integer value representing the location of the duck
	 * */ 
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// Interaction counter
		int interactionCounter = 1;
		
		if ((getLocation() == playerLocation) && interactionCounter == 1) {
			// First interaction, hit the player
			interactionCounter = 2;
			return InteractionResult.HIT;
		}
		else if ((getLocation() == playerLocation) && interactionCounter == 2) {
			// Second interaction, kill the player
			return InteractionResult.KILL;
		}
		else {
			// Default return case
			return InteractionResult.NONE;
		}
	}
	
	@Override
	// Overridden draw method from Drawable. Prints out the symbol of the goblin
	public void draw() {
		System.out.print(this.symbol);
	}
	
	@Override
	/*
	 * Overridden move method from Moveable. The goblin moves around to the right until it hits the border, then gets reset back to index 0
	 * 
	 * @param gameBoard: An array of drawable symbols that makes up the game board
	 * @param playerLocation: Integer value representing the location of the duck
	 * */
	public void move(Drawable[] gameBoard, int playerLocation) {
		// @TODO: Have the goblin move to a random location
		// Integer to store new location
		int newLocation = 0;
		
		// If location is less than the game board, move to the right
		if (location < (GameEngine.BOARD_SIZE - 1)) {
			newLocation = location + 1;
			
			// Check if the new location is at the border of the board size
			if (newLocation > (GameEngine.BOARD_SIZE - 1)) {
				// newLocation is outside the game board, go back to index 0 of the board
				newLocation = 0;
			}
		}
	}
}
