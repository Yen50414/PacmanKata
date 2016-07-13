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
	
	public void update(char input, int gridWidth, int gridHeight) {
		if (input == 'w') {
			pacmanPosY--;
			if (pacmanPosY < 0) {
				pacmanPosY = gridHeight-1;
			}
		} else if (input == 's') {
			pacmanPosY++;
			if (pacmanPosY >= gridHeight) {
				pacmanPosY = 0;
			}
		} else if (input == 'a') {
			pacmanPosX--;
		} else if (input == 'd') {
			pacmanPosX++;
		}
	}
}
