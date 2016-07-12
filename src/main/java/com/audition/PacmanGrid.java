package com.audition;

public class PacmanGrid {
	
	private int gridWidth;
	private int gridHeight;
	
	PacObjects[][] grid;
	
	private int pacmanPosX;
	private int pacmanPosY;
	
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
		
		pacmanPosX = 14;
		pacmanPosY = 23;
		
		// spawn pacman
		grid[pacmanPosY][pacmanPosX] = PacObjects.PACMAN;
	}
	
	public int getWidth() {
		return gridWidth;
	}
	
	public int getHeight() {
		return gridHeight;
	}
	
	public PacObjects getCell(int x, int y) {
		return grid[x][y];
	}

	public void update(char input) {
		System.out.println(input);
	}
	
	public int getPacmanPosX() {
		return pacmanPosX;
	}
	
	public int getPacmanPosY() {
		return pacmanPosY;
	}
}
