package com.audition;

import junit.framework.TestCase;

public class PacmanCharacterTest extends TestCase {
	
	PacmanCharacter testChar;
	
	public void setUp() {
		testChar = new PacmanCharacter();
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
	
}
