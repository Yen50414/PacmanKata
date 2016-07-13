package com.audition;

import java.util.Scanner;

public class PacmanMain {
	
	private static PacmanGrid gameGrid;
	
	private static int defaultGridWidth = 28;
	private static int defaultGridHeight = 31;
	
	private static int defaultPacmanX = 14;
	private static int defaultPacmanY = 23;
	
	private static void printGrid() {
		
		// Get Line Seperator for current OS
		String eol = System.getProperty("line.separator");
		
		// Print current state of grid to screen
		for(int i = 0; i < gameGrid.getHeight(); i++) {
			for(int j = 0; j < gameGrid.getWidth(); j++) {
				PacObjects curr = gameGrid.getCell(j,i);
				if(curr == PacObjects.PACMAN) {
					System.out.print("V ");
				} else if(curr == PacObjects.DOT) {
					System.out.print(". ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.print(eol);
		}
	}

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		gameGrid = new PacmanGrid(defaultGridWidth, defaultGridHeight, defaultPacmanX, defaultPacmanY);
		
		// Print starting game state
		printGrid();
		
		try {
			while(true) {
				// Update and print new game state
				gameGrid.update(keyboard.next().charAt(0));
				printGrid();
			}
		} finally {
			keyboard.close();
		}
	}

}
