package com.audition;

public class PacmanGrid {
	
	private int gridWidth;
	private int gridHeight;
	
	PacObjects[][] grid;
	
	PacmanCharacter pacman;
	
	public PacmanGrid(int width, int height) {
		gridWidth = width;
		gridHeight = height;
		
		grid = new PacObjects[gridHeight][gridWidth];
	
		// fill grid with dots
		for(int i = 0; i < gridHeight; i++) {
			for(int j = 0; j < gridWidth; j++) {
				grid[i][j] = PacObjects.DOT;
			}
		}
		
		// spawn pacman
		pacman = new PacmanCharacter();
		grid[getPacmanPosY()][getPacmanPosX()] = PacObjects.PACMAN;
	}
	
	public int getWidth() {
		return gridWidth;
	}
	
	public int getHeight() {
		return gridHeight;
	}
	
	public PacObjects getCell(int x, int y) {
		return grid[y][x];
	}
	
	public int getPacmanPosX() {
		return pacman.getPacmanPosX();
	}
	
	public int getPacmanPosY() {
		return pacman.getPacmanPosY();
	}
	
	public void update(char input) {
		
		// Update current pacman location
		grid[getPacmanPosY()][getPacmanPosX()] = PacObjects.DOT;
		
		pacman.update(input);
		
		// Update grid with new pacman location
		if (input == 'w') {
			grid[getPacmanPosY()][getPacmanPosX()] = PacObjects.PACMAN;
		} else if (input == 's') {
			grid[getPacmanPosY()][getPacmanPosX()] = PacObjects.PACMAN;
		} else {
			System.out.println("Exiting game...");
			System.exit(0);
		}
	}
}
