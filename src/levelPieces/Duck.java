package levelPieces;

import gameEngine.Drawable;
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
	// Overridden interact method. The duck moves around randomly and if it is in the same square as the player, it moves the player to a random location
	public InteractionResult interact(Drawable[] gameboard, int playerLocation) {
		return InteractionResult.NONE;
	}
}
