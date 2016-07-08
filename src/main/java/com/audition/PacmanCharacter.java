package com.audition;

public class PacmanCharacter {
	
	PacDirection direction;
	
	public PacmanCharacter() {
		direction = PacDirection.LEFT; // Default to facing left
	}
	
	public PacDirection getDirection() {
		return direction;
	}
	
	public void setDirection(PacDirection newDirection) {
		direction = newDirection;
	}
}
