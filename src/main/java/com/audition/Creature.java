package com.audition;

public abstract class Creature {

	private int posX;
	private int posY;

	public Creature(int x, int y) {
		posX = x;
		posY = y;
	}

	public void setPosX(int x) {
		posX = x;
	}

	public void setPosY(int y) {
		posY = y;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public void update(char input, int gridWidth, int gridHeight) {

		// Update Creature position
		if (input == 'w') { // Handle UP
			posY--;
			if (posY < 0) {
				posY = gridHeight - 1;
			}
		} else if (input == 's') { // Handle DOWN
			posY++;
			if (posY >= gridHeight) {
				posY = 0;
			}
		} else if (input == 'a') { // Handle LEFT
			posX--;
			if (posX < 0) {
				posX = gridWidth - 1;
			}
		} else if (input == 'd') { // Handle RIGHT
			posX++;
			if (posX >= gridWidth) {
				posX = 0;
			}
		}
	}

}
