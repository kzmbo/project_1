package _Pokemon;

import Objects.Pokemon;
import Interface.Water;

public class Squirtle extends Pokemon implements Water {
	public Squirtle() {
		super("Squirtle");
	}

	public String watergun(Pokemon p) {
		return "Interface.Water Gun attack!";
	}
	public String bubblebeam(Pokemon p) {
		return "Bubble Beam attack!";
	}
	public String waterfall(Pokemon p) {
		return "Waterfall attack!";
	}

	@Override
	public String specialAttack(Pokemon p, int move) {
		return null;
	}
}
