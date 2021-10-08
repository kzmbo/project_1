package _Pokemon;//package Objects.Pokemon;
import Controller.CheckInput;
import Objects.Pokemon;
import Interface.Fire;

/*
* ember – 0-3 dmg
- fire blast – 1-4 dmg
- fire punch – 1-3 dmg
*
* */


public class Charmander extends Pokemon implements Fire {
    public Charmander() {
        super("Charmander");
    }

    public String ember(Pokemon p){
        int damage = (int) (Math.random() * 4) + 0;
        p.takeDamage(damage);
        String userAttack = p.getName() + " is encased in EMBER and takes " + damage + " damage.";
        return userAttack;
    }

    public String fireBlast(Pokemon p) {
        int damage = (int) (Math.random() * 5) + 1;
        p.takeDamage(damage);
        String userAttack = p.getName() + " got toasted by a FIRE BLAST and takes " + damage + " damage.";
        return userAttack;
    }

    public String firePunch(Pokemon p) {
        int damage = (int) (Math.random() * 4) + 1;
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
