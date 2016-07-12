package com.audition;

import java.util.Scanner;

public class PacmanMain {
	
	private static PacmanGrid gameGrid;
	
	private static void printGrid() {
		String eol = System.getProperty("line.separator");
		
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
		
		try {
			while(true) {
				gameGrid.update(keyboard.next().charAt(0));
				printGrid();
			}
		} finally {
			keyboard.close();
		}
	}

}
