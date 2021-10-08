package Objects;

public abstract class Pokemon extends Entity {
    public Pokemon(String n){
        super(n, 100);
    }

    public abstract String specialAttack(Pokemon p, int move);

}
