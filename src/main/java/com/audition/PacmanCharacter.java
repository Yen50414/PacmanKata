package com.audition;

public class PacmanCharacter {
	
	PacDirection direction;
	
	public PacmanCharacter() {
		direction = PacDirection.LEFT;
	}
	
	public PacDirection getDirection() {
		return direction;
	}
}
