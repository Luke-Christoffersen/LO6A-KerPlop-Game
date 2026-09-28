package tests;

//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.EnumSet;
import java.util.Set;

import gameEngine.Drawable;
import gameEngine.Moveable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import levelPieces.Duck;
import levelPieces.Goblin;


public class TestMovingPieces {
	
	// JUnit Test Function to test the Duck
	@Test
	public void testDuck() {
		// Follow a similar format to that of the TestInteractingPieces, except move the duck for every loop iteration
		
		// Create a temporary game board
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		
		// Create a duck object
		Duck duck = new Duck('D', "Duck", 10);
		
		// Add the duck to the game board at its starting location
		gameBoard[duck.getLocation()] = duck;
		
		// Add a Goblin to the game board to test interaction
		gameBoard[12] = new Goblin('G', "Goblin", 12);
		
		// Create a set containing all possible interactions that can be had with the duck
		Set<InteractionResult> possibleResults = EnumSet.of(InteractionResult.GET_POINT, InteractionResult.HIT, InteractionResult.ADVANCE, InteractionResult.NONE);
		
		// Loop 1000 times, move the duck each time, then test the interaction
		for (int i = 0; i < 1000; i++) {
			// Move the duck (duck moves randomly)
			duck.move(gameBoard, i);
			// Store the interaction result (if any)
			InteractionResult result = duck.interact(gameBoard, 12);
			// Check to see if the interaction is acceptable
			assertTrue(possibleResults.contains(result));
		}
	}
	
	// JUnit Test Function to test the Goblin
	public void testGoblin() {
		// Follow a similar format to that of the TestInteractingPices, except move the goblin every loop iteration
		
		// Create a temporary game board
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		
		// Create a goblin object
		Goblin goblin = new Goblin('G', "Goblin", 10);
		
		// Add the goblin to the game board at its starting location
		gameBoard[goblin.getLocation()] = goblin;
		
		// Test the two hit conditions
		assertEquals(InteractionResult.HIT, goblin.interact(gameBoard, 10));
		assertEquals(InteractionResult.HIT, goblin.interact(gameBoard, 10));
		
		// Loop through the first half of the game board and test the interact after moving the goblin
		for (int i = 0; i < 10; i++) {
			goblin.move(gameBoard, i);
			assertEquals(InteractionResult.NONE, goblin.interact(gameBoard, i));
		}
		
		// Loop through the second half of the game board and test the interaction after moving the goblin
		for (int i = 11; i < GameEngine.BOARD_SIZE; i++) {
			goblin.move(gameBoard, i);
			assertEquals(InteractionResult.NONE, goblin.interact(gameBoard, i));
		}
	}
}
