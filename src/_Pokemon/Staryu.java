package _Pokemon;

import Objects.Pokemon;
import Interface.Water;

public class Staryu extends Pokemon implements Water {
	public Staryu() {
		super("Staryu");
	}

	@Override
	public String specialAttack(Pokemon p, int move) {
		return null;
	}

	public String watergun(Pokemon p) {
		return "Gun attack!";
	}
	public String bubblebeam(Pokemon p) {
		return "Bubble Beam attack!";
	}
	public String waterfall(Pokemon p) {
		return "Waterfall attack!";
	}
}
