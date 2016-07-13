package com.audition;

import junit.framework.*;

public class PacmanGridTest extends TestCase {
	
	private PacmanGrid testGrid;
	
	private static int defaultGridWidth = 28;
	private static int defaultGridHeight = 31;
	
	private static int defaultPacmanX = 14;
	private static int defaultPacmanY = 23;
	
	public void setUp() {
		testGrid = new PacmanGrid(defaultGridWidth, defaultGridHeight, defaultPacmanX, defaultPacmanY);
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
		for(int i = 0; i < testGrid.getHeight(); i++) {
			for(int j = 0; j < testGrid.getWidth(); j++) {
				PacObjects curr = testGrid.getCell(j,i);
				if(curr != PacObjects.PACMAN) {
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
		assertEquals(PacObjects.PACMAN, testGrid.getCell(posX, posY-1));
	}
	
	public void testUpdateGridKeys() {
		// Save current pos
		int posX = testGrid.getPacmanPosX();
		int posY = testGrid.getPacmanPosY();
		
		testGrid.update('s');
		
		// Pacman should move down
		assertEquals(PacObjects.PACMAN, testGrid.getCell(posX, posY+1));
	}
	
	public void testUpdateGridKeya() {
		// Save current pos
		int posX = testGrid.getPacmanPosX();
		int posY = testGrid.getPacmanPosY();
		
		testGrid.update('a');
		
		// Pacman should move up
		assertEquals(PacObjects.PACMAN, testGrid.getCell(posX-1, posY));
	}
	
	public void testUpdateGridKeyd() {
		// Save current pos
		int posX = testGrid.getPacmanPosX();
		int posY = testGrid.getPacmanPosY();
		
		testGrid.update('d');
		
		// Pacman should move down
		assertEquals(PacObjects.PACMAN, testGrid.getCell(posX+1, posY));
	}
	
	public void testGridWrapAroundUp() {
		// Start Pacman up at top of grid
		testGrid = new PacmanGrid(defaultGridWidth, defaultGridHeight, defaultPacmanX, 0);
		
		testGrid.update('w');
		
		// Pacman should be at bottom of grid
		assertEquals(PacObjects.PACMAN, testGrid.getCell(defaultPacmanX, defaultGridHeight-1));
	}
	
	public void testGridWrapAroundDown() {
		// Start Pacman up at bottom of grid
		testGrid = new PacmanGrid(defaultGridWidth, defaultGridHeight, defaultPacmanX, defaultGridHeight-1);
		
		testGrid.update('s');
		
		// Pacman should be at top of grid
		assertEquals(PacObjects.PACMAN, testGrid.getCell(defaultPacmanX, 0));
	}
	
	public void testGridWrapAroundLeft() {
		// Start Pacman up at left of grid
		testGrid = new PacmanGrid(defaultGridWidth, defaultGridHeight, 0, defaultPacmanY);
		
		testGrid.update('a');
		
		// Pacman should be at right of grid
		assertEquals(PacObjects.PACMAN, testGrid.getCell(defaultGridWidth-1, defaultPacmanY));
	}
	
	public void testGridWrapAroundRight() {
		// Start Pacman up at right of grid
		testGrid = new PacmanGrid(defaultGridWidth, defaultGridHeight, defaultGridWidth-1, defaultPacmanY);
		
		testGrid.update('d');
		
		// Pacman should be at left of grid
		assertEquals(PacObjects.PACMAN, testGrid.getCell(0, defaultPacmanY));
	}
	
	public void testEatDot() {
		int pacX = testGrid.getPacmanPosX();
		int pacY = testGrid.getPacmanPosY();

		testGrid.update('d');
		
		assertEquals(PacObjects.EMPTY, testGrid.getCell(pacX, pacY));
	}
}
