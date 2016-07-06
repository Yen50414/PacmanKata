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
		assertEquals(testGrid.getWidth(), 28);
	}
	
	public void testGridHeight() throws Exception {
		assertEquals(testGrid.getHeight(), 31);
	}
	
	public void testGridFilledWithDots() throws Exception {
		for(int i = 0; i < testGrid.getWidth(); i++) {
			for(int j = 0; j < testGrid.getHeight(); j++) {
				assertEquals(testGrid.getCell(i, j), true);
			}
		}
	}
	
}
