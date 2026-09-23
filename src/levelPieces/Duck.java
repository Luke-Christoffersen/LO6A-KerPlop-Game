package levelPieces;

import gameEngine.Drawable;
import java.util.random.*;
import gameEngine.Moveable;
import gameEngine.InteractionResult;

public class Duck extends GamePiece implements Drawable, Moveable{
	
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
		// @TODO: Implement duck-player interaction. Generate a random number between 1 and 3 inclusive. 
		// If 1: The player gets a point
		// If 2: The player gets a point
		// If 3: The player gets to advance
		return InteractionResult.NONE;
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
	}
}
