package _Pokemon;

import Objects.Pokemon;
import Interface.Water;

public class Staryu extends Pokemon implements Water {
	public Staryu() {
		super("Staryu");
	}

	@Override
	public String getSpecialMenu() {
		return specialMenu;
	}

	@Override
	public int getNumSpecialMenuItems() {
		return numSpecialMenuItems;
	}

	@Override
	public String specialAttack(Pokemon p, int move) {
		return null;
	}

	@Override
	public String watergun(Pokemon p) {
		return "Gun attack!";
	}

	@Override
	public String bubblebeam(Pokemon p) {
		return "Bubble Beam attack!";
	}

	@Override
	public String waterfall(Pokemon p) {
		return "Waterfall attack!";
	}
}
