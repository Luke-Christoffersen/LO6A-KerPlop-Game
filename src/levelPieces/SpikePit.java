package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class SpikePit extends GamePiece {

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
}
