package Interface;
import Objects.Pokemon;

/**
 Description: this is the special attacks for the fire type pokemons
 */
public interface Fire {
    String specialMenu = "1. Ember\n2. Fire Blast\n3. Fire Punch";
    int numSpecialMenuItems = 3;

    /**
     Description: special attack number 1: ember
     @param: this is the pokemon we are attacking
     Be sure to change the damage according to the pokemon.
     */
    String ember(Pokemon p);

    /**
     Description: special attack number 2: fire blast
     @param: this is the pokemon we are attacking
     Be sure to change the damage according to the pokemon.
     */
    String fireBlast(Pokemon p);

    /**
     Description: special attack number 3: fire punch
     @param: this is the pokemon we are attacking
     Be sure to change the damage according to the pokemon.
     */
    String firePunch(Pokemon p);
}
