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
	
	public void testPacmanLeft() {
		assertEquals(testChar.getDirection(), PacDirection.LEFT);
	}
	
}
