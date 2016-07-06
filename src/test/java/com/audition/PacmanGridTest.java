package com.audition;

import junit.framework.*;

public class PacmanGridTest extends TestCase {
	
	public void testGenerateGrid() throws Exception {
		PacmanGrid testGrid = new PacmanGrid(28, 31);
		assertNotNull(testGrid);
	}
	
	public void testGridWidth() throws Exception {
		PacmanGrid testGrid = new PacmanGrid(28, 31);
		assertEquals(testGrid.getWidth(), 28);
	}
	
	public void testGridHeight() throws Exception {
		PacmanGrid testGrid = new PacmanGrid(28, 31);
		assertEquals(testGrid.getHeight(), 31);
	}
	
}
