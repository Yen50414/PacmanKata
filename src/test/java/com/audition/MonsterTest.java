package com.audition;

import junit.framework.TestCase;

public class MonsterTest extends TestCase {
		
	Monster testCreature;
	
	private static int defaultGridWidth = 28;
	private static int defaultGridHeight = 31;
	
	private static int defaultPosX = 14;
	private static int defaultPosY = 23;
	
	public void setUp() {
		testCreature = new Monster(defaultPosX, defaultPosY);
	}
	
	public void testInitializeCharacter() {
		assertNotNull(testCreature);
	}
	
	public void testUpdatePosKeyw() {
		// Save current pos
		int posY = testCreature.getPosY();
		
		testCreature.update('w', defaultGridWidth, defaultGridHeight);
		
		// Monster should move up
		assertEquals(posY-1, testCreature.getPosY());
	}
	
	public void testUpdatePosKeys() {
		// Save current pos
		int posY = testCreature.getPosY();
		
		testCreature.update('s', defaultGridWidth, defaultGridHeight);
		
		// Monster should move down
		assertEquals(posY+1, testCreature.getPosY());
	}
	
	public void testUpdatePosKeya() {
		// Save current pos
		int posX = testCreature.getPosX();
		
		testCreature.update('a', defaultGridWidth, defaultGridHeight);
		
		// Monster should move up
		assertEquals(posX-1, testCreature.getPosX());
	}
	
	public void testUpdatePosKeyd() {
		// Save current pos
		int posX = testCreature.getPosX();
		
		testCreature.update('d', defaultGridWidth, defaultGridHeight);
		
		// Monster should move down
		assertEquals(posX+1, testCreature.getPosX());
	}
	
	public void testPosWrapAroundUp() {
		// Start Monster up at top of grid
		testCreature = new Monster(defaultPosX, 0);
		
		testCreature.update('w', defaultGridWidth, defaultGridHeight);
		
		// Monster should be at bottom of grid
		assertEquals(defaultGridHeight-1, testCreature.getPosY());
	}
	
	public void testPosWrapAroundDown() {
		// Start Monster up at bottom of grid
		testCreature = new Monster(defaultPosX, defaultGridHeight-1);
		
		testCreature.update('s', defaultGridWidth, defaultGridHeight);
		
		// Monster should be at top of grid
		assertEquals(0, testCreature.getPosY());
	}
	
	public void testPosWrapAroundLeft() {
		// Start Monster up at left of grid
		testCreature = new Monster(0, defaultPosY);
		
		testCreature.update('a', defaultGridWidth, defaultGridHeight);
		
		// Monster should be at right of grid
		assertEquals(defaultGridWidth-1, testCreature.getPosX());
	}
	
	public void testPosWrapAroundRight() {
		// Start Monster up at right of grid
		testCreature = new Monster(defaultGridWidth-1, defaultPosY);
		
		testCreature.update('d', defaultGridWidth, defaultGridHeight);
		
		// Monster should be at left of grid
		assertEquals(0, testCreature.getPosX());
	}
	
	public void testGetPreviousObject() {
		assertEquals(PacObjects.DOT, testCreature.getPreviousObject());
	}
	
	public void testSetPreviousObject() {
		testCreature.setPreviousObject(PacObjects.EMPTY);
		assertEquals(PacObjects.EMPTY, testCreature.getPreviousObject());
	}
	
}
