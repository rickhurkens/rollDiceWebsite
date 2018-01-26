package nl.rickhurkens.rollDice.dice;

import java.util.Random;

public class Dice {
	private int numberOfSides;
	private int result;
	private Random rng = new Random();
	
	public Dice(int numberOfSides) {
		this.numberOfSides = numberOfSides;
	}
	
	public Dice() {
		this(6);
	}
	
	public int roll() {
		result = rng.nextInt(numberOfSides) + 1;
		return result;
	}
	
	public int getResult() {
		return result;
	}
	
	@Override
	public String toString() {
		return "dice with value " + result;
	}
}
