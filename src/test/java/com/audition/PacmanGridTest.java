package com.audition;

import junit.framework.*;

public class PacmanGridTest extends TestCase {
	
	PacmanGrid testGrid;
	
	public void setUp() {
		testGrid = new PacmanGrid(28, 31);
	}
	
	public void testGenerateGrid() throws Exception {
		assertNotNull(testGrid);
	}
	
	public void testGridWidth() throws Exception {
		assertEquals(28, testGrid.getWidth());
	}
	
	public void testGridHeight() throws Exception {
		assertEquals(31, testGrid.getHeight());
	}
	
	public void testGridFilledWithDots() throws Exception {
		for(int i = 0; i < testGrid.getHeight(); i++) {
			for(int j = 0; j < testGrid.getWidth(); j++) {
				PacObjects curr = testGrid.getCell(i,j);
				if(curr != PacObjects.PACMAN) {
					assertEquals(PacObjects.DOT, curr);
				}
			}
		}
	}
	
	public void testPacmanOnGrid() throws Exception {
		assertEquals(PacObjects.PACMAN, testGrid.getCell(23, 14));
	}
	
}
