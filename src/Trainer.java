import java.awt.*;
import java.util.ArrayList;

public class Trainer extends Entity {
    private int money;
    private int potions;
    private int pokeballs;
    Point ioc;
    Map map;
    private ArrayList<Pokemon> pokemon = new ArrayList<Pokemon>();


    //
    public Trainer(String n, Pokemon p, Map m ){
        super(n, 100); //adds the trainer's info into entity.java
        pokemon.add(p); //add the trainer's first pokemon into the arraylist
        m.loadMap(1); //creates a map with the map object passed from main.java
    }

    public int getMoney(){
        return this.money;
    }

    public boolean spendMoney(int amount){
        return true;
    }

    public boolean hasPotion(){
        return true;
    }

    public void receivePotion(){

    }

    public void usePotion(int pokeIndex){

    }

    public boolean hasPokeball(){
        return true;
    }

    public void receivePokeBall(){

    }

//    public boolean catchPokemon(Pokemon pokemon){
//        return true;
//    }

//    public Point getLocation(){
//        return Point;
//    }

    public char goNorth(){
        return 'N';
    }

    public char goSouth(){
        return 'S';
    }

    public char goEast(){
        return 'E';
    }

    public char goWest(){
        return 'W';
    }

    public int getNumPokemon(){
        return 0;
    }

    public void healAllPokemon(){

    }

//    public Pokemon getPokemon(int index){
//        return pokemons;
//    }

    public String getPokemonList(){
        return "";
    }

    public String toString(){
        return getName() + " " + pokemon.get(0).getName();
    }
}
