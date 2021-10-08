package _Pokemon;

import Objects.Pokemon;
import Interface.Fire;

/*
* ember – 0-4 dmg
- fire blast – 2-5 dmg
- fire punch – 1-4 dmg
* */
public class Ponyta extends Pokemon implements Fire {
    public Ponyta() {
        super("Ponyta");
    }

    public String ember(Pokemon p){
        int damage = (int) (Math.random() * 5) + 0;
        p.takeDamage(damage);
        String userAttack = p.getName() + " is encased in EMBER and takes " + damage + " damage.";
        return userAttack;
    }

    public String fireBlast(Pokemon p) {
        int damage = (int) (Math.random() * 6) + 2;
        p.takeDamage(damage);
        String userAttack = p.getName() + " got toasted by a FIRE BLAST and takes " + damage + " damage.";
        return userAttack;
    }

    public String firePunch(Pokemon p) {
        int damage = (int) (Math.random() * 5) + 1;
        p.takeDamage(damage);
        String userAttack = p.getName() + " got served with a FIRE PUNCH and takes " + damage + " damage.";
        return userAttack;
    }

    @Override
    public String specialAttack(Pokemon p, int move) {
        String specialAttack = "";
        switch (move){
            case 1:
                specialAttack = ember(p);
                break;
            case 2:
                specialAttack = fireBlast(p);
                break;
            case 3:
                specialAttack = firePunch(p);
                break;
        }
        return specialAttack;
    }
}