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
import levelPieces.Coin;
import levelPieces.SpikePit;


public class TestMovingPieces {
	
	// JUnit Test Function to test the Duck
	@Test
	public void testDuck() {
		// Follows a similar strategy to the example code provided in the assignment since duck uses random movement
		
		// Create a temporary game board
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		
		// Add coins to spaces 1 - 4
		for (int i = 1; i <= 4; i++) {
			gameBoard[i] = new Coin('C', "Coin", i, false);
		}
		
		// Leave spaces 5 and 6 open, and add more coins from spaces 7 - 12
		for (int i = 7; i <= 12; i++) {
			gameBoard[i] = new Coin('C', "Coin", i, false);
		}
		
		// Leave spaces 13 (player), 14, and 15 open, then add spike pits from 16-20
		for (int i = 16; i <= 20; i++) {
			gameBoard[i] = new SpikePit('^', "SpikePit", i);
		}
		
		// Start the duck at index 0, then add it to the game board
		Duck duck = new Duck('D', "Duck", 0);
		gameBoard[0] = duck;
		
		// Create counters to count how many times duck has moved to that spot on the board
		int count0 = 0;
		int count5 = 0;
		int count6 = 0; 
		int count14 = 0;
		int count15 = 0;
		
		// Loop through rounds and test the ducks movement
		for (int i = 0; i < 1000; i++) {
			// Move the duck
			duck.move(gameBoard, 13);
			
			// Store the ducks location
			int duckLoc = duck.getLocation();
			
			// If the duck is at any space other than the desired test one, fail the test
			if (duckLoc != 0 || duckLoc != 5 || duckLoc != 6 || duckLoc != 14 || duckLoc != 15) {
				fail("Invalid square selected by duck");
			}
			
			if (duckLoc == 0) {count0++;}
			if (duckLoc == 5) {count5++;}
			if (duckLoc == 6) {count6++;}
			if (duckLoc == 14) {count14++;}
			if (duckLoc == 15) {count15++;}
		}
		
		// Test to see if the test locations have been visited more than once
		assert(count0 > 1);
		assert(count5 > 1);
		assert(count6 > 1);
		assert(count14 > 1);
		assert(count15 > 1);
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
