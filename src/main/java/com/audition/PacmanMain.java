package com.audition;

import java.util.Scanner;

public class PacmanMain {
	
	private static PacmanGrid gameGrid;
	
	private static int defaultGridWidth = 28;
	private static int defaultGridHeight = 31;
	
	private static int defaultPacmanX = 14;
	private static int defaultPacmanY = 23;
	
	private static void printGrid(int level, int score) {
		
		// Print current level
		System.out.println("Level " + level);
		
		// Get Line Seperator for current OS
		String eol = System.getProperty("line.separator");
		
		// Print current state of grid to screen
		for (int i = 0; i < gameGrid.getHeight(); i++) {
			for (int j = 0; j < gameGrid.getWidth(); j++) {
				PacObjects curr = gameGrid.getCell(j,i);
				if (curr == PacObjects.PACMAN) {
					System.out.print(gameGrid.getPacDisplay() + " ");
				} else if (curr == PacObjects.DOT) {
					System.out.print(". ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.print(eol);
		}
		
		// Print score
		System.out.println("Level Score: " + score);
	}

	public static void main(String[] args) {
		
		int levelCount = 1;
		int totalScore = 0;
		Scanner keyboard = new Scanner(System.in);
		char input = ' ';
		
		try {
			while (input != 'q') {
				//gameGrid = new PacmanGrid(defaultGridWidth, defaultGridHeight, defaultPacmanX, defaultPacmanY);
				gameGrid = new PacmanGrid(2, 2, 0, 0);
				
				// Print starting game state
				printGrid(levelCount, gameGrid.getLevelScore());
				
				// Loop until level complete
				while (gameGrid.getDotCount() > 0 && input != 'q') {
					input = keyboard.next().charAt(0);
					
					// Update and print new game state
					gameGrid.update(input);
					printGrid(levelCount, gameGrid.getLevelScore());
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
