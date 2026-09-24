package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class SpinningTrap extends GamePiece implements Drawable {

	public SpinningTrap(char symbol, String label, int location) {
		super(symbol, label, location);
	}
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (playerLocation == getLocation() 
				|| playerLocation == getLocation()+1 
				|| playerLocation == getLocation()-1) {
			return InteractionResult.HIT;
		}
		return InteractionResult.NONE;
	}
	@Override
	public void draw() {
		System.out.print(this.symbol);
	}
}
