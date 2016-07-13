package com.audition;

import junit.framework.*;

public class PacmanGridTest extends TestCase {
	
	PacmanGrid testGrid;
	
	public void setUp() {
		testGrid = new PacmanGrid(28, 31);
	}
	
	public void testGenerateGrid() {
		assertNotNull(testGrid);
	}
	
	public void testGridWidth() {
		assertEquals(28, testGrid.getWidth());
	}
	
	public void testGridHeight() {
		assertEquals(31, testGrid.getHeight());
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
		assertEquals(PacObjects.PACMAN, testGrid.getCell(14, 23));
	}
	
	public void testPacmanPosX() {
		assertEquals(14, testGrid.getPacmanPosX());
	}
	
	public void testPacmanPosY() {
		assertEquals(23, testGrid.getPacmanPosY());
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
	
}
