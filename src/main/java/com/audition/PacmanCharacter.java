package com.audition;

public class PacmanCharacter {
	
	private PacDirection direction;
	
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
		if (input == 'w') { // Handle UP
			pacmanPosY--;
			if (pacmanPosY < 0) {
				pacmanPosY = gridHeight-1;
			}
			setDirection(PacDirection.UP);
		} else if (input == 's') { // Handle DOWN
			pacmanPosY++;
			if (pacmanPosY >= gridHeight) {
				pacmanPosY = 0;
			}
			setDirection(PacDirection.DOWN);
		} else if (input == 'a') { // Handle LEFT
			pacmanPosX--;
			if (pacmanPosX < 0) {
				pacmanPosX = gridWidth-1;
			}
			setDirection(PacDirection.LEFT);
		} else if (input == 'd') { // Handle RIGHT
			pacmanPosX++;
			if (pacmanPosX >= gridWidth) {
				pacmanPosX = 0;
			}
			setDirection(PacDirection.RIGHT);
		}
	}
}
