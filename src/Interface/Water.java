package Interface;

import Objects.Pokemon;

public interface Water {
	String specialMenu = "1. Water Gun\n2. Bubble Beam\n3. Waterfall";
	int numSpecialMenuItems = 3;
	
	String watergun(Pokemon p);
	String bubblebeam(Pokemon p);
	String waterfall(Pokemon p);
}
