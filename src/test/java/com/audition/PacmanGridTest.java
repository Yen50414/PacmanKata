package com.audition;

import junit.framework.*;

public class PacmanGridTest extends TestCase {

	private PacmanGrid testGrid;

	private static int defaultGridWidth = 28;
	private static int defaultGridHeight = 31;

	private static int defaultPacmanX = 14;
	private static int defaultPacmanY = 23;

	public void setUp() {
		testGrid = new PacmanGrid(defaultGridWidth, defaultGridHeight, defaultPacmanX, defaultPacmanY, true);
	}

	public void testGenerateGrid() {
		assertNotNull(testGrid);
	}

	public void testGridWidth() {
		assertEquals(defaultGridWidth, testGrid.getWidth());
	}

	public void testGridHeight() {
		assertEquals(defaultGridHeight, testGrid.getHeight());
	}

	public void testGridFilledWithDots() {
		for (int i = 1; i < testGrid.getHeight() - 1; i++) {
			for (int j = 1; j < testGrid.getWidth() - 1; j++) {
				PacObjects curr = testGrid.getCell(j, i);
				if (curr != PacObjects.PACMAN && curr != PacObjects.MONSTER) {
					assertEquals(PacObjects.DOT, curr);
				}
			}
		}
	}

	public void testPacmanOnGrid() {
		assertEquals(PacObjects.PACMAN, testGrid.getCell(defaultPacmanX, defaultPacmanY));
	}

	public void testPacmanPosX() {
		assertEquals(defaultPacmanX, testGrid.getPacmanPosX());
	}

	public void testPacmanPosY() {
		assertEquals(defaultPacmanY, testGrid.getPacmanPosY());
	}

	public void testUpdateGridKeyw() {
		// Save current pos
		int posX = testGrid.getPacmanPosX();
		int posY = testGrid.getPacmanPosY();

		testGrid.update('w');

		// Pacman should move up
		assertEquals(PacObjects.PACMAN, testGrid.getCell(posX, posY - 1));
	}

	public void testUpdateGridKeys() {
		// Save current pos
		int posX = testGrid.getPacmanPosX();
		int posY = testGrid.getPacmanPosY();

		testGrid.update('s');

		// Pacman should move down
		assertEquals(PacObjects.PACMAN, testGrid.getCell(posX, posY + 1));
	}

	public void testUpdateGridKeya() {
		// Save current pos
		int posX = testGrid.getPacmanPosX();
		int posY = testGrid.getPacmanPosY();

		testGrid.update('a');

		// Pacman should move up
		assertEquals(PacObjects.PACMAN, testGrid.getCell(posX - 1, posY));
	}

	public void testUpdateGridKeyd() {
		// Save current pos
		int posX = testGrid.getPacmanPosX();
		int posY = testGrid.getPacmanPosY();

		testGrid.update('d');

		// Pacman should move down
		assertEquals(PacObjects.PACMAN, testGrid.getCell(posX + 1, posY));
	}

	public void testGridWrapAroundUp() {
		// Start Pacman up at top of grid
		testGrid = new PacmanGrid(defaultGridWidth, defaultGridHeight, defaultGridWidth / 2, 0, false);

		testGrid.update('w');

		// Pacman should be at bottom of grid
		assertEquals(PacObjects.PACMAN, testGrid.getCell(defaultGridWidth / 2, defaultGridHeight - 1));
	}

	public void testGridWrapAroundDown() {
		// Start Pacman up at bottom of grid
		testGrid = new PacmanGrid(defaultGridWidth, defaultGridHeight, defaultGridWidth / 2, defaultGridHeight - 1,
				false);

		testGrid.update('s');

		// Pacman should be at top of grid
		assertEquals(PacObjects.PACMAN, testGrid.getCell(defaultGridWidth / 2, 0));
	}

	public void testGridWrapAroundLeft() {
		// Start Pacman up at left of grid
		testGrid = new PacmanGrid(defaultGridWidth, defaultGridHeight, 0, defaultGridHeight / 2, false);

		testGrid.update('a');

		// Pacman should be at right of grid
		assertEquals(PacObjects.PACMAN, testGrid.getCell(defaultGridWidth - 1, defaultGridHeight / 2));
	}

	public void testGridWrapAroundRight() {
		// Start Pacman up at right of grid
		testGrid = new PacmanGrid(defaultGridWidth, defaultGridHeight, defaultGridWidth - 1, defaultGridHeight / 2,
				false);

		testGrid.update('d');

		// Pacman should be at left of grid
		assertEquals(PacObjects.PACMAN, testGrid.getCell(0, defaultGridHeight / 2));
	}

	public void testEatDot() {
		int pacX = testGrid.getPacmanPosX();
		int pacY = testGrid.getPacmanPosY();

		testGrid.update('d');

		assertEquals(PacObjects.EMPTY, testGrid.getCell(pacX, pacY));
	}

	public void testGetPacmanDisplay() {
		assertEquals(">", testGrid.getPacDisplay());
	}

	public void testGetPacmanDisplayKeyw() {
		testGrid.update('w');
		testGrid.update('w');
		assertEquals("V", testGrid.getPacDisplay());
	}

	public void testGetPacmanDisplayKeys() {
		testGrid.update('s');
		testGrid.update('s');
		assertEquals("^", testGrid.getPacDisplay());
	}

	public void testGetPacmanDisplayKeya() {
		testGrid.update('a');
		testGrid.update('a');
		assertEquals(">", testGrid.getPacDisplay());
	}

	public void testGetPacmanDisplayKeyd() {
		testGrid.update('d');
		testGrid.update('d');
		assertEquals("<", testGrid.getPacDisplay());
	}

	public void testGetPacmanDisplaySecondKeyw() {
		testGrid.update('w');
		assertEquals("|", testGrid.getPacDisplay());
	}

	public void testGetPacmanDisplaySecondKeys() {
		testGrid.update('s');
		assertEquals("|", testGrid.getPacDisplay());
	}

	public void testGetPacmanDisplaySecondKeya() {
		testGrid.update('a');
		assertEquals("-", testGrid.getPacDisplay());
	}

	public void testGetPacmanDisplaySecondKeyd() {
		testGrid.update('d');
		assertEquals("-", testGrid.getPacDisplay());
	}

	public void testGetDotCount() {
		// Top and Bottom wall plus Left and Right wall minus double counted
		// corners
		int wallCount = defaultGridWidth * 2 + defaultGridHeight * 2 - 4;
		int pacmanCount = 1; // Pacman's spawn point

		// Total cells - (Wall cells + Pacman spawn)
		int expectedCount = (defaultGridWidth * defaultGridHeight) - (wallCount + pacmanCount);

		assertEquals(expectedCount, testGrid.getDotCount());
	}

	public void testGetDotCountAfter1Eat() {
		int initialDotCount = testGrid.getDotCount();
		testGrid.update('a');

		assertEquals(initialDotCount - 1, testGrid.getDotCount());
	}

	public void testGetDotCountAfter5Eat() {
		int initialDotCount = testGrid.getDotCount();
		for (int i = 5; i > 0; i--) {
			testGrid.update('a');
		}

		assertEquals(initialDotCount - 5, testGrid.getDotCount());
	}

	public void testGetLevelScore() {
		assertEquals(0, testGrid.getLevelScore());
	}

	public void testGetLevelScoreAfter1Eat() {
		testGrid.update('a');

		assertEquals(10, testGrid.getLevelScore());
	}

	public void testGetLevelScoreAfter5Eat() {
		for (int i = 5; i > 0; i--) {
			testGrid.update('a');
		}

		assertEquals(50, testGrid.getLevelScore());
	}

	public void testEdgeWall() {
		// Top row are walls
		for (int i = 0; i < testGrid.getWidth(); i++) {
			if (i != testGrid.getWidth() / 2) {
				assertEquals(PacObjects.WALL, testGrid.getCell(i, 0));
			}
		}

		// Bottom row are walls
		for (int i = 0; i < testGrid.getWidth(); i++) {
			if (i != testGrid.getWidth() / 2) {
				assertEquals(PacObjects.WALL, testGrid.getCell(i, testGrid.getHeight() - 1));
			}
		}

		// Left column are walls
		for (int i = 0; i < testGrid.getHeight(); i++) {
			if (i != testGrid.getHeight() / 2) {
				assertEquals(PacObjects.WALL, testGrid.getCell(0, i));
			}
		}

		// Right column are walls
		for (int i = 0; i < testGrid.getHeight(); i++) {
			if (i != testGrid.getHeight() / 2) {
				assertEquals(PacObjects.WALL, testGrid.getCell(testGrid.getWidth() - 1, i));
			}
		}
	}

	public void testPacmanStopOnWallKeyw() {
		// Spawn pacman with wall above
		testGrid = new PacmanGrid(4, 4, 1, 1, false);

		// Save current position
		int expectedY = testGrid.getPacmanPosY();

		testGrid.update('w');

		assertEquals(expectedY, testGrid.getPacmanPosY());
	}

	public void testPacmanStopOnWallKeys() {
		// Spawn pacman with wall above
		testGrid = new PacmanGrid(5, 5, 3, 3, false);

		// Save current position
		int expectedY = testGrid.getPacmanPosY();

		testGrid.update('s');

		assertEquals(expectedY, testGrid.getPacmanPosY());
	}

	public void testPacmanStopOnWallKeya() {
		// Spawn pacman with wall above
		testGrid = new PacmanGrid(5, 5, 1, 1, false);

		// Save current position
		int expectedX = testGrid.getPacmanPosX();

		testGrid.update('a');

		assertEquals(expectedX, testGrid.getPacmanPosX());
	}

	public void testPacmanStopOnWallKeyd() {
		// Spawn pacman with wall above
		testGrid = new PacmanGrid(5, 5, 3, 3, false);

		// Save current position
		int expectedX = testGrid.getPacmanPosX();

		testGrid.update('d');

		assertEquals(expectedX, testGrid.getPacmanPosX());
	}

	public void testMonster1Spawns() {
		assertEquals(PacObjects.MONSTER, testGrid.getCell(1, 1));
	}

	public void testMonster2Spawns() {
		assertEquals(PacObjects.MONSTER, testGrid.getCell(defaultGridWidth - 2, 1));
	}

	public void testMonster3Spawns() {
		assertEquals(PacObjects.MONSTER, testGrid.getCell(1, defaultGridHeight - 2));
	}

	public void testMonster4Spawns() {
		assertEquals(PacObjects.MONSTER, testGrid.getCell(defaultGridWidth - 2, defaultGridHeight - 2));
	}

	public void testPacmanDieOnMonster() {
		// Spawn pacman next to monster
		testGrid = new PacmanGrid(5, 5, 1, 2, true);

		boolean death = testGrid.update('w');

		assertEquals(true, death);
	}

	public void testPacmanRespawnOnMonster() {
		// Spawn pacman next to monster
		testGrid = new PacmanGrid(5, 5, 1, 2, true);

		testGrid.update('w');

		assertEquals(PacObjects.PACMAN, testGrid.getCell(1, 2));
	}
}
