package com.audition;

public class PacmanGrid {
	
	private int gridWidth;
	private int gridHeight;
	
	public PacmanGrid(int width, int height) {
		gridWidth = width;
		gridHeight = height;
	}
	
	public int getWidth() {
		return gridWidth;
	}
	
	public int getHeight() {
		return gridHeight;
	}
}
