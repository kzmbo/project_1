package Objects;

public abstract class Entity {
    private String name;
    private int hp;
    private int maxHp;

    public Entity(String n, int mHp){
        this.name = n;
        this.maxHp = mHp;
        hp = maxHp;
    }

    public void setName(String name) {
    	this.name = name;
    }
    
    public int getHp() {
    	return hp;
    }
    
    public int getMaxHp() {
    	return maxHp;
    }

    public void heal(){
        System.out.println("Healing");
        this.hp = maxHp;
    }

    public void takeDamage(int d){
        if ((this.hp - d) <= 0 ){
            this.hp = -1;
        }else {
            this.hp -= d;
        }
    }

    public String getName(){
        return this.name;
    }
}
