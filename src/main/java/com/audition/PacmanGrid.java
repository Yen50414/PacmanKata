package com.audition;

public class PacmanGrid {
	
	private int gridWidth;
	private int gridHeight;
	
	private PacObjects[][] grid;
	
	private PacmanCharacter pacman;
	
	private int dotsLeft;
	private int levelScore;
	
	private PacObjects lookAhead(char input) {
		
		int aheadX = getPacmanPosX();
		int aheadY = getPacmanPosY();
		
		if (input == 'w') { // Handle UP
			aheadY--;
			if (aheadY < 0) {
				aheadY = gridHeight-1;
			}
		} else if (input == 's') { // Handle DOWN
			aheadY++;
			if (aheadY >= gridHeight) {
				aheadY = 0;
			}
		} else if (input == 'a') { // Handle LEFT
			aheadX--;
			if (aheadX < 0) {
				aheadX = gridWidth-1;
			}
		} else if (input == 'd') { // Handle RIGHT
			aheadX++;
			if (aheadX >= gridWidth) {
				aheadX = 0;
			}
		}
		
		return grid[aheadY][aheadX]; // default return wall to not do anything
	}
	
	public PacmanGrid(int width, int height, int pacmanX, int pacmanY) {
		gridWidth = width;
		gridHeight = height;
		
		grid = new PacObjects[gridHeight][gridWidth];
		dotsLeft = 0;
		levelScore = 0;
	
		// fill grid with dots
		for(int i = 0; i < gridHeight; i++) {
			for(int j = 0; j < gridWidth; j++) {
				grid[i][j] = PacObjects.DOT;
				dotsLeft++;
			}
		}
		
		// Top row are walls
		for (int i = 0; i < gridWidth; i++) {
			grid[0][i] = PacObjects.WALL;
			dotsLeft--;
		}
		
		// Bottom row are walls
		for (int i = 0; i < gridWidth; i++) {
			grid[gridHeight-1][i] = PacObjects.WALL;
			dotsLeft--;
		}
		
		// Left column are walls
		for (int i = 1; i < gridHeight-1; i++) {
			grid[i][0] = PacObjects.WALL;
			dotsLeft--;
		}
		
		// Right column are walls
		for (int i = 1; i < gridHeight-1; i++) {
			grid[i][gridWidth-1] = PacObjects.WALL;
			dotsLeft--;
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
		
		// Do nothing if pacman wants to move into a wall
		if (lookAhead(input) != PacObjects.WALL) {
		
			// Update current pacman location
			grid[getPacmanPosY()][getPacmanPosX()] = PacObjects.EMPTY;
			
			pacman.update(input, gridWidth, gridHeight);
			
			// Update dot count and score if one is eaten
			if (grid[getPacmanPosY()][getPacmanPosX()] == PacObjects.DOT) {
				dotsLeft--;
				levelScore = levelScore + 10;
			}
			
			// Update grid with new pacman location
			grid[getPacmanPosY()][getPacmanPosX()] = PacObjects.PACMAN;
			
		}
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
	
	public int getLevelScore() {
		return levelScore;
	}
	
}
