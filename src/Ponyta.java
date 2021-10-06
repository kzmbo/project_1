/*
* ember – 0-4 dmg
- fire blast – 2-5 dmg
- fire punch – 1-4 dmg
* */
public class Ponyta extends Pokemon implements Fire {
    public Ponyta(String n) {
        super(n);
    }

    public String ember(Pokemon p){
        return "ember attack!";
    }

    public String fireBlast(Pokemon p) {
        return "ember attack";
    }

    public String firePunk(Pokemon p) {
        return "ember attack";
    }

    public static void main (String[] args){
        System.out.println(specialMenu);
    }
}