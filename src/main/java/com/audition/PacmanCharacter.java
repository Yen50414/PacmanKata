package com.audition;

public class PacmanCharacter {
	
	PacDirection direction;
	
	private int pacmanPosX;
	private int pacmanPosY;
	
	public PacmanCharacter(int x, int y) {
		direction = PacDirection.LEFT; // Default to facing left
		
		pacmanPosX = x;
		pacmanPosY = y;
	}
	
	public PacDirection getDirection() {
		return direction;
	}
	
	public void setDirection(PacDirection newDirection) {
		direction = newDirection;
	}
	
	public int getPacmanPosX() {
		return pacmanPosX;
	}
	
	public int getPacmanPosY() {
		return pacmanPosY;
	}
	
	public void update(char input) {
		if (input == 'w') {
			pacmanPosY--;
		} else if (input == 's') {
			pacmanPosY++;
		} else if (input == 'a') {
			pacmanPosX--;
		} else if (input == 'd') {
			pacmanPosX++;
		}
	}
}
