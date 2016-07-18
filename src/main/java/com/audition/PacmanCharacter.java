package com.audition;

public class PacmanCharacter {
	
	private PacDirection direction;
	
	private int pacmanPosX;
	private int pacmanPosY;
	
	private int spawnX;
	private int spawnY;
	
	private boolean mouthOpen;
	
	public PacmanCharacter(int x, int y) {
		direction = PacDirection.LEFT; // Default to facing left
		
		pacmanPosX = x;
		pacmanPosY = y;
		
		spawnX = x;
		spawnY = y;
		
		mouthOpen = true;
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
		// Close/Open mouth
		mouthOpen = !mouthOpen;
		
		// Update Pacman position
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

	public boolean getMouthOpen() {
		return mouthOpen;
	}
	
	public void respawn() {
		pacmanPosX = spawnX;
		pacmanPosY = spawnY;
	}
}
