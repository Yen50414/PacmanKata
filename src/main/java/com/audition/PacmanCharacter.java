package com.audition;

public class PacmanCharacter extends Creature {
	
	private PacDirection direction;
	
	private int spawnX;
	private int spawnY;
	
	private boolean mouthOpen;
	
	public PacmanCharacter(int x, int y) {
		
		super(x, y);
		
		direction = PacDirection.LEFT; // Default to facing left
		
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
	
	public void update(char input, int gridWidth, int gridHeight) {
		super.update(input, gridWidth, gridHeight);
		
		// Close/Open mouth
		mouthOpen = !mouthOpen;
		
		// Update Pacman position
		if (input == 'w') { // Handle UP
			setDirection(PacDirection.UP);
		} else if (input == 's') { // Handle DOWN
			setDirection(PacDirection.DOWN);
		} else if (input == 'a') { // Handle LEFT
			setDirection(PacDirection.LEFT);
		} else if (input == 'd') { // Handle RIGHT
			setDirection(PacDirection.RIGHT);
		}
	}

	public boolean getMouthOpen() {
		return mouthOpen;
	}
	
	public void respawn() {
		setPosX(spawnX);
		setPosY(spawnY);
	}
}
