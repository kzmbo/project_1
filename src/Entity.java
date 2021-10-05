public class Entity {
    private String name;
    private int hp;
    int maxHp;

    public Entity(String n, int mHp){
        this.name = n;
        this.maxHp = mHp;
    }

    public String getName(){
        return this.name;
    }
}
