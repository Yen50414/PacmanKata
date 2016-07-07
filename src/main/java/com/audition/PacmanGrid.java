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
		
		grid = new PacObjects[gridWidth][gridHeight];
	
		// fill grid with dots
		for(int i = 0; i < gridWidth; i++) {
			for(int j = 0; j < gridHeight; j++) {
				grid[i][j] = PacObjects.DOT;
			}
		}
		
		pacmanPosX = 14;
		pacmanPosY = 23;
		
		// spawn pacman at 14,23
		grid[pacmanPosX][pacmanPosY] = PacObjects.PACMAN;
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
}
