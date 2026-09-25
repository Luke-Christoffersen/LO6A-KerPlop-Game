package levelPieces;

import gameEngine.InteractionResult;

import java.util.Random;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.Moveable;

public class Goblin extends GamePiece implements Drawable, Moveable{
	
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
	
	/*
	 * Overridden interact method from GamePiece. The goblin does one hit the first time it interacts with the player, then will kill the player on the second interaction
	 * 
	 * @param gameBoard: An array of drawable symbols that makes up the game board
	 * @param playerLocation: Integer value representing the location of the duck
	 * */
	@Override 
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
	
	// Overridden draw method from Drawable. Prints out the symbol of the goblin
	@Override
	public void draw() {
		System.out.print(this.symbol);
	}
	
	/*
	 * Overridden move method from Moveable. The goblin moves around to the right until it hits the border, then gets reset back to index 0
	 * 
	 * @param gameBoard: An array of drawable symbols that makes up the game board
	 * @param playerLocation: Integer value representing the location of the duck
	 * */
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		// @TODO: Have the goblin move to a random location
	    int oldLocation = this.getLocation();
	    int newLocation = oldLocation + 1;
	    if (newLocation > GameEngine.BOARD_SIZE - 1) {
	        newLocation = 0;
	    }

	    if (gameBoard[newLocation] != null) {
	        // target cell is occupied by another piece — hop over the piece if so
	    	newLocation += 1;
	    	if (newLocation > GameEngine.BOARD_SIZE - 1) {
	    		newLocation = 0;
	    	}
	    }

	    gameBoard[oldLocation] = null;
	    gameBoard[newLocation] = this;
	    this.setLocation(newLocation);
	}
}
