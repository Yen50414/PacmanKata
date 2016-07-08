package com.audition;

public class PacmanMain {
	
	private static PacmanGrid gameGrid;
	
	private static void printGrid() {
		String eol = System.getProperty("line.separator");
		
		for(int i = 0; i < gameGrid.getHeight(); i++) {
			for(int j = 0; j < gameGrid.getWidth(); j++) {
				PacObjects curr = gameGrid.getCell(i,j);
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
		gameGrid = new PacmanGrid(28, 31);
		printGrid();
	}

}
