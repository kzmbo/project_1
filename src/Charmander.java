/*
* ember – 0-3 dmg
- fire blast – 1-4 dmg
- fire punch – 1-3 dmg
*
* */


public class Charmander extends Pokemon implements Fire {
    public Charmander(String n) {
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
