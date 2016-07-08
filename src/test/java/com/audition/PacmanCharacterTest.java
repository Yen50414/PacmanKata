package com.audition;

import junit.framework.TestCase;

public class PacmanCharacterTest extends TestCase {
	
	PacmanCharacter testChar;
	
	public void setUp() {
		testChar = new PacmanCharacter();
	}
	
	public void testInitializeCharacter() throws Exception {
		assertNotNull(testChar);
	}
	
}
