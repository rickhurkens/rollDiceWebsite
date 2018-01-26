package nl.rickhurkens.rollDice.dice.test;

import nl.rickhurkens.rollDice.dice.Cup;

public class RollDiceTest {
	private Cup cup;
	
	public RollDiceTest(int numberOfDices, int numberOfSides) {
		cup = new Cup(numberOfDices, numberOfSides);
	}
	
	public RollDiceTest(int numberOfDices) {
		this(numberOfDices, 6);
	}
	
	public RollDiceTest() {
		this(1);
	}
	
	public void go() {
		cup.roll();
		System.out.println(cup.toString());
	}
}
