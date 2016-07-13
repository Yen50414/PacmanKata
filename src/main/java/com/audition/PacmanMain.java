package com.audition;

import java.util.Scanner;

public class PacmanMain {
	
	private static PacmanGrid gameGrid;
	
	private static void printGrid() {
		
		// Get Line Seperator for current OS
		String eol = System.getProperty("line.separator");
		
		// Print current state of grid to screen
		for(int i = 0; i < gameGrid.getHeight(); i++) {
			for(int j = 0; j < gameGrid.getWidth(); j++) {
				PacObjects curr = gameGrid.getCell(j,i);
				if(curr == PacObjects.PACMAN) {
					System.out.print("V ");
				} else {
					System.out.print(". ");
				}
			}
			System.out.print(eol);
		}
	}

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		gameGrid = new PacmanGrid(28, 31);
		
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
