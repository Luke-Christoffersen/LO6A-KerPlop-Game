package levelPieces;

import java.util.ArrayList;
import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.Moveable;

public class LevelSetup {
	
	
	private Drawable[] board;
	private ArrayList<Moveable> movingPieces;
	private ArrayList<GamePiece> interactingPieces;
	private int playerStartLoc;
	
	public LevelSetup() {
		board = new Drawable[GameEngine.BOARD_SIZE];
		movingPieces = new ArrayList<>();
		interactingPieces = new ArrayList<>();
		playerStartLoc = 0;
	}

	public void createLevel(int levelNum) {
		board = new Drawable[GameEngine.BOARD_SIZE];
		movingPieces = new ArrayList<>();
		interactingPieces = new ArrayList<>();
		
		if (levelNum == 1) {
			playerStartLoc = 10;

			Coin coin0 = new Coin('C', "Coin", 1, false);
			Coin coin1 = new Coin('C', "Coin", 9, false);
			Goal goal = new Goal('X', "Goal", 18);
			SpikePit pit = new SpikePit('^', "Spike Pit", 7);
			SpinningTrap spinner = new SpinningTrap('-', "Spinning Trap", 5);
			Wind wind = new Wind();
			

			board[coin0.getLocation()] = coin0;
			board[coin1.getLocation()] = coin1;
			board[goal.getLocation()] = goal;
			board[pit.getLocation()] = pit;
			board[spinner.getLocation()] = spinner;
			board[12] = wind;

			interactingPieces.add(coin0);
			interactingPieces.add(coin1);
			interactingPieces.add(goal);
			interactingPieces.add(pit);
			interactingPieces.add(spinner);
		}
		else if (levelNum == 2) {
			playerStartLoc = 10;

			Coin coin0 = new Coin('C', "Coin", 1, false);
			Coin coin1 = new Coin('C', "Coin", 16, false);
			Goal goal = new Goal('X', "Goal", 18);
			SpikePit pit = new SpikePit('^', "Spike Pit", 7);
			Goblin goblin = new Goblin('G', "Goblin", 14);
			Duck duck = new Duck('D', "Duck", 4);
			Wind wind = new Wind();
			

			board[coin0.getLocation()] = coin0;
			board[coin1.getLocation()] = coin1;
			board[goal.getLocation()] = goal;
			board[pit.getLocation()] = pit;
			board[goblin.getLocation()] = goblin;
			board[duck.getLocation()] = duck;
			board[12] = wind;

			interactingPieces.add(coin0);
			interactingPieces.add(coin1);
			interactingPieces.add(goal);
			interactingPieces.add(pit);
			interactingPieces.add(goblin);
			interactingPieces.add(duck);
		}
	}

	public Drawable[] getBoard() {
		return board;
	}

	public ArrayList<Moveable> getMovingPieces() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<GamePiece> getInteractingPieces() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getPlayerStartLoc() {
		// TODO Auto-generated method stub
		return 0;
	}

}
