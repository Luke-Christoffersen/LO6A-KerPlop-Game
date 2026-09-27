package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EnumSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import levelPieces.Coin;
import levelPieces.Duck;
import levelPieces.Goal;
import levelPieces.Goblin;
import levelPieces.SpikePit;
import levelPieces.SpinningTrap;

public class TestInteraction {

	@Test
	public void testCoin() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Coin coin = new Coin('C', "Coin", 10, false);
		gameBoard[10] = coin;
		assertEquals(InteractionResult.GET_POINT, coin.interact(gameBoard, 10));
		for (int i = 0; i < 10; i++)
			assertEquals(InteractionResult.NONE, coin.interact(gameBoard, i));
		for (int i = 11; i < GameEngine.BOARD_SIZE; i++)
			assertEquals(InteractionResult.NONE, coin.interact(gameBoard, i));
	}
	
	@Test
	public void testGoal() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Goal goal= new Goal('G', "Goal", 10);
		gameBoard[10] = goal;
		assertEquals(InteractionResult.ADVANCE, goal.interact(gameBoard, 10));
		for (int i = 0; i < 10; i++)
			assertEquals(InteractionResult.NONE, goal.interact(gameBoard, i));
		for (int i = 11; i < GameEngine.BOARD_SIZE; i++)
			assertEquals(InteractionResult.NONE, goal.interact(gameBoard, i));
	}
	
	@Test
	public void testSpikePit() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		SpikePit spikePit = new SpikePit('^', "SpikePit", 10);
		gameBoard[10] = spikePit;
		assertEquals(InteractionResult.KILL, spikePit.interact(gameBoard, 10));
		for (int i = 0; i < 10; i++)
			assertEquals(InteractionResult.NONE, spikePit.interact(gameBoard, i));
		for (int i = 11; i < GameEngine.BOARD_SIZE; i++)
			assertEquals(InteractionResult.NONE, spikePit.interact(gameBoard, i));
	}
	
	@Test
	public void testSpinningTrap() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		SpinningTrap spinningTrap= new SpinningTrap('X', "Goal", 10);
		gameBoard[10] = spinningTrap;
		assertEquals(InteractionResult.HIT, spinningTrap.interact(gameBoard, 9));
		assertEquals(InteractionResult.HIT, spinningTrap.interact(gameBoard, 10));
		assertEquals(InteractionResult.HIT, spinningTrap.interact(gameBoard, 11));
		for (int i = 0; i < 9; i++)
			assertEquals(InteractionResult.NONE, spinningTrap.interact(gameBoard, i));
		for (int i = 12; i < GameEngine.BOARD_SIZE; i++)
			assertEquals(InteractionResult.NONE, spinningTrap.interact(gameBoard, i));
	}
	
	@Test
	public void testGoblin() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Goblin goblin = new Goblin('G', "Goblin", 10);
		gameBoard[10] = goblin;
		assertEquals(InteractionResult.HIT, goblin.interact(gameBoard, 10));
		assertEquals(InteractionResult.KILL, goblin.interact(gameBoard, 10));
		for (int i = 0; i < 10; i++)
			assertEquals(InteractionResult.NONE, goblin.interact(gameBoard, i));
		for (int i = 11; i < GameEngine.BOARD_SIZE; i++)
			assertEquals(InteractionResult.NONE, goblin.interact(gameBoard, i));
	}
	
	@Test
	public void testDuck() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Duck duck = new Duck('D', "Duck", 10);
		gameBoard[10] = duck;
		Set<InteractionResult> possible = EnumSet.of(
			InteractionResult.GET_POINT,
			InteractionResult.HIT,
			InteractionResult.ADVANCE,
			InteractionResult.NONE
		);
		for (int i = 0; i < 1000; i++) {
			InteractionResult result = duck.interact(gameBoard, 10);
			assertTrue(possible.contains(result));
		}
	}
	
}