class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
  }


  public static void trainerAttack(Trainer t, Pokemon wild){
    System.out.println(t.getPokemonList());
    int pokemonChosen = CheckInput.getIntRange(1,t.getNumPokemon()-1);

    Pokemon attackingPokemon = t.getPokemon(pokemonChosen);
    System.out.println(attackingPokemon.getAttackMenu());
    int attack = attackingPokemon.getNumBasicMenuItems();

    if(attack == 1){
      System.out.println(attackingPokemon.getBasicMenu());
      int num = attackingPokemon.getNumBasicMenuItems();
      System.out.println(attackingPokemon.basicAttack(wild,num));
    }
    else{
      System.out.println(attackingPokemon.getSpecialMenu());
      int num = attackingPokemon.getNumSpecialMenuItems;
      System.out.println(attackingPokemon.specialAttack(wild,num));
    }
    int wildAttack = (int) (Math.random() + 1) + 1;
	  if(wildAttack == 1) {
		  int wildNum = (int) (Math.random() + 2) + 1;
		  System.out.println(wild.basicAttack(attackingPokemon, wildNum));
	  }
	  else {
		  int wildNum = (int) (Math.random() + 2) + 1;
		  System.out.println(wild.specialAttack(attackingPokemon, wildNum));
	  }
  }//end of the trainer attack method
}//end of the main