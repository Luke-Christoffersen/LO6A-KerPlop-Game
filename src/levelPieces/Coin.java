package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Coin extends GamePiece implements Drawable {
	
	private boolean _collected;

	public Coin(char symbol, String label, int location, boolean collected) {
		super(symbol, label, location);
		_collected = false;
		
	}
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (playerLocation == getLocation() && !_collected) {
			_collected = true;
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
