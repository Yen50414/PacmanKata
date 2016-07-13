package com.audition;

import junit.framework.TestCase;

public class PacmanCharacterTest extends TestCase {
	
	PacmanCharacter testChar;
	
	public void setUp() {
		testChar = new PacmanCharacter(14, 23);
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
		
		testChar.update('w');
		
		// Pacman should move up
		assertEquals(posY-1, testChar.getPacmanPosY());
	}
	
	public void testUpdatePosKeys() {
		// Save current pos
		int posY = testChar.getPacmanPosY();
		
		testChar.update('s');
		
		// Pacman should move down
		assertEquals(posY+1, testChar.getPacmanPosY());
	}
	
	public void testUpdatePosKeya() {
		// Save current pos
		int posX = testChar.getPacmanPosX();
		
		testChar.update('a');
		
		// Pacman should move up
		assertEquals(posX-1, testChar.getPacmanPosX());
	}
	
	public void testUpdatePosKeyd() {
		// Save current pos
		int posX = testChar.getPacmanPosX();
		
		testChar.update('d');
		
		// Pacman should move down
		assertEquals(posX+1, testChar.getPacmanPosX());
	}
	
}
