package Objects;

public abstract class Entity {
    private String name;
    private int hp;
    int maxHp;

    public Entity(String n, int mHp){
        this.name = n;
        this.maxHp = mHp;
    }

    public void heal(){
        System.out.println("Healing");
    }

    public void takeDamage(int d){

    }

    public String getName(){
        return this.name;
    }
}
