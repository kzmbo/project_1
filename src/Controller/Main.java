package Controller;

import Objects.*;
import _Pokemon.*;

public class Main {
    public static void main(String arg[]){
        Trainer trainer;
        Map map = new Map();

        System.out.println("Prof. Oak: Hello there new trainer!");
        System.out.println("What's your name?");
        String name = CheckInput.getString();

        System.out.println("Nice to meet you, " + name);
        System.out.println("Choose your first pokemon:");
        System.out.println("1. Charmander");
        System.out.println("2. Bulbasaur");
        System.out.println("3. Squirtle");
        int choice = CheckInput.getIntRange(1, 3);
        Pokemon playerStartingPokemon;
        switch (choice){
            case 1:
                playerStartingPokemon= new Charmander();
                trainer = new Trainer(name, playerStartingPokemon, map);
                break;
            case 2:
//                _Pokemon.Charmander charmander = new _Pokemon.Charmander("_Pokemon.Charmander");
//                Controller.Map map = new Controller.Map();
//                Objects.Trainer trainer = new Objects.Trainer(name, charmander, map);
//                System.out.println(trainer.toString());
//                mainMenu(charmander);
                break;
            case 3:
                playerStartingPokemon = new Squirtle();
                trainer = new Trainer(name, playerStartingPokemon, map);
                break;
        }

        boolean isGameRunning = true;
        while(isGameRunning){
            int playerChoice = mainMenu();
            if (playerChoice == 5){
                isGameRunning = false;
            }
            //TODO: add map logic here?
        }
    }

    /* mainMenu() will return...
    *   north = 1
    *   south = 2
    *   east = 3
    *   west = 4
    *   quit game = 5
    * */
    public static int mainMenu() {
        System.out.println();
        System.out.println("--map--");
        System.out.println();
        System.out.println("Main Menu:");
        System.out.println("1. Go North");
        System.out.println("2. Go South");
        System.out.println("3. Go East");
        System.out.println("4. Go West");
        System.out.println("5. QUIT GAME");
        int choice = CheckInput.getIntRange(1, 5);
        switch (choice) {
            case 1:
                System.out.println("Heading North!");
                return 1;
            case 2:
                System.out.println("Heading South!");
                return 2;
            case 3:
                System.out.println("Heading East!");
                return 3;
            case 4:
                System.out.println("Heading West!");
                return 4;
            case 5:
                System.out.println("Game Over!");
                return 5;
            default:
                System.out.println("Invalid input!");
                break;
        }
        return 0;
    }

        public static Pokemon chooseRandomPokemon() {
            int random = (int) (Math.random() * 6) + 1;
            System.out.println(random);
            Pokemon pokemonAI;
            switch (random) {
                case 1:
                    System.out.println("Oddish");
                    // water types
                    //pokemonAI = new Oddish();
                    //return pokemonAI;
                    break;
                case 2:
                    pokemonAI = new Charmander();
                    return pokemonAI;
                case 3:
                    System.out.println("Bulbasaur");
                    // water types
                    //pokemonAI = new Bulbasaur();
                    //return pokemonAI;
                case 4:
                    pokemonAI = new Ponyta();
                    return pokemonAI;
                case 5:
                    pokemonAI = new Staryu();
                    return pokemonAI;
                case 6:
                    pokemonAI = new Squirtle();
                    return pokemonAI;
            }
            return null;
        }

        //TODO: its just a bunch of print statements. make sure to use trainer.java and/or pokemon.java
        public static void trainerAttack (Trainer t, Pokemon wild){
            System.out.println("A wild --some wild pokemon-- has appeared");
            System.out.println("--some wild pokemon-- HP:20/20");
            System.out.println("What do you want to do?");
            System.out.println("1. Fight");
            System.out.println("2. Use Potion");
            System.out.println("3. Throw Poke Ball");
            System.out.println("4. Run Away");
            int attackChoice = CheckInput.getIntRange(1, 4);
            switch (attackChoice) {
                case 1:
                    System.out.println("Fight");
                    break;
                case 2:
                    System.out.println("Drink up some potion");
                    break;
                case 3:
                    System.out.println("throwing a poke ball");
                    break;
                case 4:
                    System.out.println("running!");
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
        }

        //TODO: its just a bunch of print statements. make sure to change use trainer.java and/or pokemon.java
        public static void store (Trainer t){
            System.out.println("Welcome to the Objects.Pokemon Center!");
            System.out.println("What can I help you with?");
            System.out.println("1. Buy Potion - $5");
            System.out.println("2. Buy Poke Ball - $3");
            System.out.println("3. EXIT SHOP");
            int storeChoice = CheckInput.getIntRange(1, 3);
            switch (storeChoice) {
                case 1:
                    System.out.println("Purchased potion!");
                    break;
                case 2:
                    System.out.println("Purchased poke ball!");
                    break;
                case 3:
                    System.out.println("*EXITING SHOP*");
                    System.out.println("Thank you! Come again next time!");
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
        }
    }



//testing if trainer.java works, keep it if u wanna know how it works, feel free to delete it.

//        System.out.println(p.getName());
//        System.out.println(t.toString());
//        t.receivePokeBall();
//        t.receiveMoney(100);
//        t.receivePotion();
//        System.out.println(t.hasPokeball());
//        System.out.println(t.hasPotion());
//        t.spendMoney(23);
//        System.out.println(t.getMoney());
//        t.usePotion(0);
//        System.out.println(t.hasPotion());
//        t.catchPokemon(p);
//        System.out.println(t.getPokemonList());
//        System.out.println(t.getNumPokemon());
