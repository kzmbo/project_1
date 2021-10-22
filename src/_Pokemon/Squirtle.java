package _Pokemon;

import Objects.Pokemon;
import Interface.*;
import Controller.CheckInput;

public class Squirtle extends Pokemon implements Water {
	public Squirtle() {
		super("Squirtle");
	}

	public String watergun(Pokemon p) {
		int damage = (int) (Math.random() * 5)+2;
		if(p instanceof Fire){
			double amplified = Pokemon.battleTable[1][0];
			damage *= amplified;
		}
		else if(p instanceof Water){
			double amplified = Pokemon.battleTable[1][1];
			damage *= amplified;
		}
		else{//p instanceof Grass
			double amplified = Pokemon.battleTable[1][2];
			damage *= amplified;
		}
		p.takeDamage(damage);
		String userAttack = p.getName() + "is doused by WATERGUN and takes " + damage + " damage!";
		return userAttack;
	}
	public String bubblebeam(Pokemon p) {
		int damage = (int) (Math.random() * 3)+ 1;
		if(p instanceof Fire){
			double amplified = Pokemon.battleTable[1][0];
			damage *= amplified;
		}
		else if(p instanceof Water){
			double amplified = Pokemon.battleTable[1][1];
			damage *= amplified;
		}
		else{//p instanceof Grass
			double amplified = Pokemon.battleTable[1][2];
			damage *= amplified;
		}
		p.takeDamage(damage);
		String userAttack = p.getName() + "is sprayed by BUBBLEBEAM and takes " + damage + " damage!";
		return userAttack;
		
	}
	public String waterfall(Pokemon p) {
		int damage = (int) (Math.random() * 4)+1;
		if(p instanceof Fire){
			double amplified = Pokemon.battleTable[1][0];
			damage *= amplified;
		}
		else if(p instanceof Water){
			double amplified = Pokemon.battleTable[1][1];
			damage *= amplified;
		}
		else{//p instanceof Grass
			double amplified = Pokemon.battleTable[1][2];
			damage *= amplified;
		}
		p.takeDamage(damage);
		String userAttack = p.getName() + "is slammed to the ground by WATERFALL and takes " + damage + " damage!";
		return userAttack;
		
	}

	@Override
	public String getSpecialMenu() {
		return specialMenu;
	}

	@Override
	public int getNumSpecialMenuItems() {
		int numSpecialMenuItems = CheckInput.getIntRange(1,3);
		return numSpecialMenuItems;
	}

	@Override
	public String specialAttack(Pokemon p, int move) {
        String specialAttack = "";
        switch (move){
            case 1:
                specialAttack = watergun(p);
                break;
            case 2:
                specialAttack = bubblebeam(p);
                break;
            case 3:
                specialAttack = waterfall(p);
                break;
        }
        return specialAttack;
    }
}
