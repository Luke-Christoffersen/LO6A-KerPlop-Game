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
		// Follow a similar format to that of the duck, but checks if it only visits empty spaces

		// Create a temporary game board
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];

		// Add coins at spaces 1, 4, 8, 10, and 14
		gameBoard[1] = new Coin('C', "Coin", 1, false);
		gameBoard[4] = new Coin('C', "Coin", 4, false);
		gameBoard[8] = new Coin('C', "Coin", 8, false);
		gameBoard[10] = new Coin('C', "Coin", 10, false);
		gameBoard[14] = new Coin('C', "Coin", 14, false);

		// Add a spike pit to 17 and 19
		gameBoard[17] = new SpikePit('^', "SpikePit", 17);
		gameBoard[19] = new SpikePit('^', "SpikePit", 19);

		// Assuming the player is at 13, start the goblin at 15, then add it to the board
		Goblin goblin = new Goblin('G', "Goblin", 15);
		gameBoard[15] = goblin;

		// Create counters to keep track of empty positions
		int count0 = 0;
		int count2 = 0;
		int count3 = 0;
		int count5 = 0;
		int count6 = 0;
		int count7 = 0;
		int count9 = 0;
		int count11 = 0;
		int count12 = 0;
		int count15 = 0;
		int count16 = 0;
		int count18 = 0;
		int count20 = 0;

		// Loop through rounds to test the goblins movement
		for (int i = 0; i < 1000; i++) {
			// Move the goblin
			goblin.move(gameBoard, 13);

			// Store the goblins location
			int goblinLoc = goblin.getLocation();

			// If the duck is at any space other than the desired test one, fail the test
			if (goblinLoc != 0 || goblinLoc != 2 || goblinLoc != 3 || goblinLoc != 5 || goblinLoc != 6
					|| goblinLoc != 7 || goblinLoc != 9 || goblinLoc != 11 || goblinLoc != 12 || goblinLoc != 12
					|| goblinLoc != 15 || goblinLoc != 16 || goblinLoc != 18 || goblinLoc != 20) {
				fail("Invalid square selected by goblin");
			}
			
			if (goblinLoc == 0) {count0++;}
			if (goblinLoc == 2) {count2++;}
			if (goblinLoc == 3) {count3++;}
			if (goblinLoc == 5) {count5++;}
			if (goblinLoc == 6) {count6++;}
			if (goblinLoc == 7) {count7++;}
			if (goblinLoc == 9) {count9++;}
			if (goblinLoc == 11) {count11++;}
			if (goblinLoc == 12) {count12++;}
			if (goblinLoc == 15) {count15++;}
			if (goblinLoc == 16) {count16++;}
			if (goblinLoc == 18) {count18++;}
			if (goblinLoc == 20) {count20++;}
		}
		
		// Test to see if the test locations have been visited more than once
		assert(count0 > 1);
		assert(count2 > 1);
		assert(count3 > 1);
		assert(count5 > 1);
		assert(count6 > 1);
		assert(count7 > 1);
		assert(count9 > 1);
		assert(count11 > 1);
		assert(count12 > 1);
		assert(count15 > 1);
		assert(count16 > 1);
		assert(count18 > 1);
		assert(count20 > 1);
	}
}
