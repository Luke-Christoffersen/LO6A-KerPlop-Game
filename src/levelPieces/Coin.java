package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Coin extends GamePiece implements Drawable {
	
	private boolean collected;

	public Coin(char symbol, String label, int location, boolean collected) {
		super(symbol, label, location);
		collected = false;
		
	}
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (playerLocation == getLocation() && !collected) {
			collected = true;
			setSymbol(' ');
			return InteractionResult.GET_POINT;
		}
		return InteractionResult.NONE;
	}
	@Override
	public void draw() {
		System.out.print(this.symbol);
	}
}
