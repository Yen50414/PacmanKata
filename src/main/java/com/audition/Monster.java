package com.audition;

import java.util.Random;

public class Monster extends Creature {
	
	private PacObjects previousObject;
	
	public Monster(int x, int y) {
		super(x, y);
		
		previousObject = PacObjects.DOT;
	}

	public void setPreviousObject(PacObjects object) {
		previousObject = object;
	}

	public PacObjects getPreviousObject() {
		return previousObject;
	}
	
	public void update(int gridWidth, int gridHeight) {
		
		char input = 'w';
		
		// Some logic here to determine next move
		Random rn = new Random();
		int randomNumber = rn.nextInt(4);
		switch (randomNumber) {
			case 0: 
				input = 'w';
				break;
			case 1:
				input = 's';
				break;
			case 2: 
				input = 'a';
				break;
			case 3:
				input = 'd';
				break;
		}
		
		super.update(input, gridWidth, gridHeight);
	}
	
}
