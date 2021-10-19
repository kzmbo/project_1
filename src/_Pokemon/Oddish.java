package _Pokemon;
import Objects.Pokemon;
import Interface.Grass;

/**
Description: This is the Grass pokemon Oddish 
*/
public class Oddish extends Pokemon implements Grass{
  public Oddish(){
    super("Oddish");
  }
  /**
   Description: special attack number 1
   @param: this is the pokemon we are attacking
   @return: returning a string that shows which pokemon was attacks and for how much damage
   */
  @Override
  public String vineWhip(Pokemon p){
    int damage = (int)(Math.random()*3)+1;
    p.takeDamage(damage);
    String userAttack = p.getName()+" is WHIPPED and takes "+damage+" damage.";
    return userAttack;
  }
  /**
   Description: special attack number 2
   @param: this is the pokemon we are attacking
   @return: returning a string that shows which pokemon was attacks and for how much damage
   */
  @Override
  public String razorLeaf(Pokemon p){
    int damage = (int)(Math.random()*4)+2;
    p.takeDamage(damage);
    String userAttack = p.getName()+" is attacked by razor"+damage+" damage.";
    return userAttack;
  }
  @Override
  /**
   Description: special attack number 3
   @param: this is the pokemon we are attacking
   @return: returning a string that shows which pokemon was attacks and for how much damage
   */
  public String solarBeam(Pokemon p){
    int damage = (int)(Math.random()*3)+0;
    p.takeDamage(damage);
    String userAttack = p.getName()+" is SLAMMED by a force of sunlight and takes "+damage+" damage.";
    return userAttack;
  }
  /**
   Description: Displays the special attack menu for grass pokemon
   @return: the special menu found in grass interface
   */
  @Override
  public String getSpecialMenu(){
    return specialMenu;
  }
  /**
   Description: getting the special menu number
   @return: the special menu number chosen from grass interface
   */
  @Override
  public int getNumSpecialMenuItems(){
    return numSpecialMenuItems;
  }
  /**
   Description: getting the special attack from grass interface
   @param: Pokemon p is the pokemon we are attacking, and move is which special attack
   @return: what attack we are doing
   */
  @Override
  public String specialAttack(Pokemon p, int move) {
    String specialAttack = "";
    switch (move){
      case 1:
        specialAttack = vineWhip(p);
        break;
      case 2:
        specialAttack = razorLeaf(p);
        break;
      case 3:
        specialAttack = solarBeam(p);
        break;
    }
    return specialAttack;
  } 

}//end of the class