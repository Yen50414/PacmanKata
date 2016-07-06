package com.audition;

public class PacmanGrid {
	
	private int gridWidth;
	private int gridHeight;
	
	boolean[][] grid;
	
	public PacmanGrid(int width, int height) {
		gridWidth = width;
		gridHeight = height;
		
		grid = new boolean[gridWidth][gridHeight];
		
		for(int i = 0; i < gridWidth; i++) {
			for(int j = 0; j < gridHeight; j++) {
				grid[i][j] = true; // true if there is a dot
			}
		}
	}
	
	public int getWidth() {
		return gridWidth;
	}
	
	public int getHeight() {
		return gridHeight;
	}
	
	public boolean getCell(int x, int y) {
		return grid[x][y];
	}
}
