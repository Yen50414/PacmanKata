package com.audition;

import junit.framework.*;

public class PacmanGridTest extends TestCase {
	
	public void testGenerateGrid() throws Exception {
		PacmanGrid testGrid = new PacmanGrid(5);
		assertNotNull(testGrid);
	}
	
	public void testGridWidth() throws Exception {
		PacmanGrid testGrid = new PacmanGrid(5);
		assertEquals(testGrid.getWidth(), 5);
	}
	
}
