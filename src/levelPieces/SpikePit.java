package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class SpikePit extends GamePiece implements Drawable {

	public SpikePit(char symbol, String label, int location) {
		super(symbol, label, location);
	}
	
	@Override
    public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
        if (playerLocation == getLocation()) {
            return InteractionResult.KILL;
        }
        return InteractionResult.NONE;
    }
	@Override
	public void draw() {
		System.out.print(this.symbol);
	}
}
