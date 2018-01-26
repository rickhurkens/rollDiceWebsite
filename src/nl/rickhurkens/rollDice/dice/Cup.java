package nl.rickhurkens.rollDice.dice;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Cup {
	private List<Dice> dices = new ArrayList<>();
	
	public Cup(int numberOfDice, int numberOfEyes) {
		for (int i = 0; i < numberOfDice; i++) {
			dices.add(new Dice(numberOfEyes));
		}
	}
	
	public Cup(int numberOfDice) {
		this(numberOfDice, 6);
	}
	
	public Cup() {
		this(1);
	}
	
	public void roll() {
		for (Dice dice : dices) {
			dice.roll();
		}
	}
	
	public List<Dice> getDices() {
		return Collections.unmodifiableList(dices);
	}
	
	public int getTotal() {
		int total = 0;
		for (Dice dice : dices) {
			total += dice.getResult();
		}
		return total;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Cup containing:");
		for (Dice dice : dices) {
			sb.append("\n" + dice.toString());
		}
		return sb.toString();
	}
}
