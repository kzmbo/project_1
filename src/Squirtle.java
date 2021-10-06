
public class Squirtle extends Pokemon implements Water{
	public Squirtle(String n) {
		super(n);
	}

	public String watergun(Pokemon p) {
		return "Water Gun attack!";
	}
	public String bubblebeam(Pokemon p) {
		return "Bubble Beam attack!";
	}
	public String waterfall(Pokemon p) {
		return "Waterfall attack!";
	}
}
