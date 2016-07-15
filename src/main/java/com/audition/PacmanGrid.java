package com.audition;

public class PacmanGrid {
	
	private int gridWidth;
	private int gridHeight;
	
	private PacObjects[][] grid;
	
	private PacmanCharacter pacman;
	
	private int dotsLeft;
	
	public PacmanGrid(int width, int height, int pacmanX, int pacmanY) {
		gridWidth = width;
		gridHeight = height;
		
		grid = new PacObjects[gridHeight][gridWidth];
		dotsLeft = 0;
	
		// fill grid with dots
		for(int i = 0; i < gridHeight; i++) {
			for(int j = 0; j < gridWidth; j++) {
				grid[i][j] = PacObjects.DOT;
				dotsLeft++;
			}
		}
		
		// spawn pacman
		pacman = new PacmanCharacter(pacmanX, pacmanY);
		grid[getPacmanPosY()][getPacmanPosX()] = PacObjects.PACMAN;
		dotsLeft--;
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
		
		if (input == 'q') {
			System.out.println("Exiting game...");
			System.exit(0);
		}
		
		// Update current pacman location
		grid[getPacmanPosY()][getPacmanPosX()] = PacObjects.EMPTY;
		
		pacman.update(input, gridWidth, gridHeight);
		
		// Update dot count
		if (grid[getPacmanPosY()][getPacmanPosX()] == PacObjects.DOT) {
			dotsLeft--;
		}
		
		// Update grid with new pacman location
		grid[getPacmanPosY()][getPacmanPosX()] = PacObjects.PACMAN;

	}

	public String getPacDisplay() {
		boolean mouthOpen = pacman.getMouthOpen();
		PacDirection dir = pacman.getDirection();
		
		String pacDisplay = ">"; //Just default to left
		
		if (mouthOpen) {
			switch (dir) {
				case UP: 
					pacDisplay = "V";
					break;
				case DOWN:
					pacDisplay = "^";
					break;
				case LEFT: 
					pacDisplay = ">";
					break;
				case RIGHT:
					pacDisplay = "<";
					break;
			}
		} else {
			switch (dir) {
				case UP: 
					pacDisplay = "|";
					break;
				case DOWN:
					pacDisplay = "|";
					break;
				case LEFT: 
					pacDisplay = "-";
					break;
				case RIGHT:
					pacDisplay = "-";
					break;
			}
		}
		return pacDisplay;
	}

	public int getDotCount() {
		return dotsLeft;
	}
	
}
