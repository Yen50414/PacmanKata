package com.audition;

import java.util.Scanner;

public class PacmanMain {
	
	private static PacmanGrid gameGrid;
	
	private static int defaultGridWidth = 28;
	private static int defaultGridHeight = 31;
	
	private static int defaultPacmanX = 14;
	private static int defaultPacmanY = 23;
	
	private static void printGrid(int level, int score, int life) {
		
		// Print current level
		System.out.println("Level " + level);
		
		// Get Line Separator for current OS
		String eol = System.getProperty("line.separator");
		
		// Print current state of grid to screen
		for (int i = 0; i < gameGrid.getHeight(); i++) {
			for (int j = 0; j < gameGrid.getWidth(); j++) {
				PacObjects curr = gameGrid.getCell(j,i);
				if (curr == PacObjects.PACMAN) {
					System.out.print(gameGrid.getPacDisplay() + " ");
				} else if (curr == PacObjects.DOT) {
					System.out.print(". ");
				} else if (curr == PacObjects.WALL) {
					System.out.print("# ");
				} else if (curr == PacObjects.MONSTER) {
					System.out.print("M ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.print(eol);
		}
		
		// Print score
		System.out.println("Level Score: " + score);
		System.out.println("Lives Left: " + life);
	}

	public static void main(String[] args) {
		
		int levelCount = 1;
		int totalScore = 0;
		int livesLeft = 2;
		Scanner keyboard = new Scanner(System.in);
		char input = ' ';
		
		try {
			while (livesLeft > -1 && input != 'q') {
				gameGrid = new PacmanGrid(defaultGridWidth, defaultGridHeight, defaultPacmanX, defaultPacmanY, true);
				
				// Print starting game state
				printGrid(levelCount, gameGrid.getLevelScore(), livesLeft);
				
				// Loop until level complete
				while (gameGrid.getDotCount() > 0 && livesLeft > -1 && input != 'q') {
					input = keyboard.next().charAt(0);
					
					// Update and print new game state
					boolean death = gameGrid.update(input);
					if (death) {
						livesLeft--;
					}
					printGrid(levelCount, gameGrid.getLevelScore(), livesLeft);
				}
				totalScore = totalScore + gameGrid.getLevelScore();
				
				levelCount++;
			}
			
			System.out.println("Exiting game...\n");
			System.out.println("Final Level: " + levelCount);
			System.out.println("Total Score: " + totalScore);
			
		} finally {
			keyboard.close();
		}
	}

}
