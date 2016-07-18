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
	
	public void testPosWrapAroundLeft() {
		// Start Pacman up at left of grid
		testChar = new PacmanCharacter(0, defaultPacmanY);
		
		testChar.update('a', defaultGridWidth, defaultGridHeight);
		
		// Pacman should be at right of grid
		assertEquals(defaultGridWidth-1, testChar.getPacmanPosX());
	}
	
	public void testPosWrapAroundRight() {
		// Start Pacman up at right of grid
		testChar = new PacmanCharacter(defaultGridWidth-1, defaultPacmanY);
		
		testChar.update('d', defaultGridWidth, defaultGridHeight);
		
		// Pacman should be at left of grid
		assertEquals(0, testChar.getPacmanPosX());
	}
	
	public void testRotateOnKeyw() {
		testChar.update('w', defaultGridWidth, defaultGridHeight);
		
		// Pacman should rotate up
		assertEquals(PacDirection.UP, testChar.getDirection());
	}
	
	public void testRotateOnKeys() {
		testChar.update('s', defaultGridWidth, defaultGridHeight);
		
		// Pacman should rotate down
		assertEquals(PacDirection.DOWN, testChar.getDirection());
	}
	
	public void testRotateOnKeya() {
		testChar.setDirection(PacDirection.UP);
		
		testChar.update('a', defaultGridWidth, defaultGridHeight);
		
		// Pacman should rotate left
		assertEquals(PacDirection.LEFT, testChar.getDirection());
	}
	
	public void testRotateOnKeyd() {
		testChar.update('d', defaultGridWidth, defaultGridHeight);
		
		// Pacman should rotate right
		assertEquals(PacDirection.RIGHT, testChar.getDirection());
	}
	
	public void testMouthCloseOnKeyw() {
		testChar.update('w', defaultGridWidth, defaultGridHeight);
		
		// Pacman mouth should be closed
		assertEquals(false, testChar.getMouthOpen());
	}
	
	public void testMouthCloseOnKeys() {
		testChar.update('s', defaultGridWidth, defaultGridHeight);
		
		// Pacman mouth should be closed
		assertEquals(false, testChar.getMouthOpen());
	}
	
	public void testMouthCloseOnKeya() {
		testChar.update('a', defaultGridWidth, defaultGridHeight);
		
		// Pacman mouth should be closed
		assertEquals(false, testChar.getMouthOpen());
	}
	
	public void testMouthCloseOnKeyd() {
		testChar.update('d', defaultGridWidth, defaultGridHeight);
		
		// Pacman mouth should be closed
		assertEquals(false, testChar.getMouthOpen());
	}
	
	public void testMouthOpenOnKeyw() {
		testChar.update('w', defaultGridWidth, defaultGridHeight);
		testChar.update('w', defaultGridWidth, defaultGridHeight);
		
		// Pacman mouth should be closed
		assertEquals(true, testChar.getMouthOpen());
	}
	
	public void testMouthOpenOnKeys() {
		testChar.update('s', defaultGridWidth, defaultGridHeight);
		testChar.update('s', defaultGridWidth, defaultGridHeight);
		
		// Pacman mouth should be closed
		assertEquals(true, testChar.getMouthOpen());
	}
	
	public void testMouthOpenOnKeya() {
		testChar.update('a', defaultGridWidth, defaultGridHeight);
		testChar.update('a', defaultGridWidth, defaultGridHeight);
		
		// Pacman mouth should be closed
		assertEquals(true, testChar.getMouthOpen());
	}
	
	public void testMouthOpenOnKeyd() {
		testChar.update('d', defaultGridWidth, defaultGridHeight);
		testChar.update('d', defaultGridWidth, defaultGridHeight);
		
		// Pacman mouth should be closed
		assertEquals(true, testChar.getMouthOpen());
	}
	
	public void testRespawnPosX() {
		testChar.respawn();
		assertEquals(defaultPacmanX, testChar.getPacmanPosX());
	}
	
	public void testRespawnPosY() {
		testChar.respawn();
		assertEquals(defaultPacmanY, testChar.getPacmanPosY());
	}
}
