package com.audition;

import junit.framework.TestCase;

public class PacmanCharacterTest extends TestCase {
	
	PacmanCharacter testChar;
	
	private static int defaultGridWidth = 28;
	private static int defaultGridHeight = 31;
	
	private static int defaultPacmanX = 14;
	private static int defaultPacmanY = 23;
	
	public void setUp() {
		testChar = new PacmanCharacter(defaultPacmanX, defaultPacmanY);
	}
	
	public void testInitializeCharacter() {
		assertNotNull(testChar);
	}
	
	public void testPacmanHasDirection() {
		assertNotNull(testChar.getDirection());
	}
	
	public void testPacmanDefault() {
		assertEquals(testChar.getDirection(), PacDirection.LEFT);
	}
	
	public void testPacmanLeft() {
		testChar.setDirection(PacDirection.LEFT);
		assertEquals(testChar.getDirection(), PacDirection.LEFT);
	}
	
	public void testPacmanRight() {
		testChar.setDirection(PacDirection.RIGHT);
		assertEquals(testChar.getDirection(), PacDirection.RIGHT);
	}
	
	public void testPacmanUp() {
		testChar.setDirection(PacDirection.UP);
		assertEquals(testChar.getDirection(), PacDirection.UP);
	}
	
	public void testPacmanDown() {
		testChar.setDirection(PacDirection.DOWN);
		assertEquals(testChar.getDirection(), PacDirection.DOWN);
	}
	
	public void testPacmanLRL() {
		testChar.setDirection(PacDirection.LEFT);
		testChar.setDirection(PacDirection.RIGHT);
		testChar.setDirection(PacDirection.LEFT);
		assertEquals(testChar.getDirection(), PacDirection.LEFT);
	}
	
	public void testPacmanUDU() {
		testChar.setDirection(PacDirection.UP);
		testChar.setDirection(PacDirection.DOWN);
		testChar.setDirection(PacDirection.UP);
		assertEquals(testChar.getDirection(), PacDirection.UP);
	}
	
	public void testPacmanRLR() {
		testChar.setDirection(PacDirection.RIGHT);
		testChar.setDirection(PacDirection.LEFT);
		testChar.setDirection(PacDirection.RIGHT);
		assertEquals(testChar.getDirection(), PacDirection.RIGHT);
	}
	
	public void testPacmanDUD() {
		testChar.setDirection(PacDirection.DOWN);
		testChar.setDirection(PacDirection.UP);
		testChar.setDirection(PacDirection.DOWN);
		assertEquals(testChar.getDirection(), PacDirection.DOWN);
	}
	
	public void testUpdatePosKeyw() {
		// Save current pos
		int posY = testChar.getPacmanPosY();
		
		testChar.update('w', defaultGridWidth, defaultGridHeight);
		
		// Pacman should move up
		assertEquals(posY-1, testChar.getPacmanPosY());
	}
	
	public void testUpdatePosKeys() {
		// Save current pos
		int posY = testChar.getPacmanPosY();
		
		testChar.update('s', defaultGridWidth, defaultGridHeight);
		
		// Pacman should move down
		assertEquals(posY+1, testChar.getPacmanPosY());
	}
	
	public void testUpdatePosKeya() {
		// Save current pos
		int posX = testChar.getPacmanPosX();
		
		testChar.update('a', defaultGridWidth, defaultGridHeight);
		
		// Pacman should move up
		assertEquals(posX-1, testChar.getPacmanPosX());
	}
	
	public void testUpdatePosKeyd() {
		// Save current pos
		int posX = testChar.getPacmanPosX();
		
		testChar.update('d', defaultGridWidth, defaultGridHeight);
		
		// Pacman should move down
		assertEquals(posX+1, testChar.getPacmanPosX());
	}
	
	public void testPosWrapAroundUp() {
		// Start Pacman up at top of grid
		testChar = new PacmanCharacter(defaultPacmanX, 0);
		
		testChar.update('w', defaultGridWidth, defaultGridHeight);
		
		// Pacman should be at bottom of grid
		assertEquals(defaultGridHeight-1, testChar.getPacmanPosY());
	}
	
	public void testPosWrapAroundDown() {
		// Start Pacman up at bottom of grid
		testChar = new PacmanCharacter(defaultPacmanX, defaultGridHeight-1);
		
		testChar.update('s', defaultGridWidth, defaultGridHeight);
		
		// Pacman should be at top of grid
		assertEquals(0, testChar.getPacmanPosY());
	}
}
