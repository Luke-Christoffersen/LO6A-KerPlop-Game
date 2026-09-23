package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Goal extends GamePiece {

	public Goal(char symbol, String label, int location) {
		super(symbol, label, location);
	}
	
	@Override
    public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
        if (playerLocation == getLocation()) {
            return InteractionResult.ADVANCE;
        }
        return InteractionResult.NONE;
    }
}
