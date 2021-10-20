package Controller;

import Objects.*;
import _Pokemon.*;

import java.awt.*;


public class Main {
    static Map currentMap = new Map();
    static Trainer player;
    static Pokemon playerStartingPokemon;
    static char currentChar;
    static int currentMapIndex = 1;

    public static void main(String arg[]){
        System.out.println("Prof. Oak: Hello there new trainer!");
        System.out.println("What's your name?");
        String name = CheckInput.getString();

        System.out.println("Nice to meet you, " + name);
        System.out.println("Choose your first pokemon:");
        System.out.println("1. Charmander");
        System.out.println("2. Bulbasaur");
        System.out.println("3. Squirtle");
        int choice = CheckInput.getIntRange(1, 3);

        switch (choice){
            case 1:
                playerStartingPokemon= new Charmander();
                player = new Trainer(name, playerStartingPokemon, currentMap);
            case 2:
                playerStartingPokemon= new Bulbasaur();
                player = new Trainer(name, playerStartingPokemon, currentMap);
            case 3:
                playerStartingPokemon = new Squirtle();
                player = new Trainer(name, playerStartingPokemon, currentMap);
        }

        currentMap.displayMap(currentMap.findStartLocation());

        boolean isGameRunning = true;
        while(isGameRunning){
            System.out.println(player.getLocation());
            int playerChoice = mainMenu();
            switch (playerChoice) {
                case 1:
                    currentChar = player.goNorth();
                    break;
                case 2:
                    currentChar = player.goSouth();
                    break;
                case 3:
                    currentChar = player.goEast();
                    break;
                case 4:
                    currentChar = player.goWest();
                    break;
                case 5:
                    isGameRunning = false;
                    System.out.println("Game Over.");
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }//end switch


            switch (currentChar){
                case 'n':
                    System.out.println("No encounter found");
                    break;
                case 'i':
                    System.out.println("I found an item!");
                    int selectRandomItem = (int) (Math.random() * 4) + 1;
                    if( selectRandomItem <=  2){
                        System.out.println("It's a potion");
                        player.receivePotion();
                    } else {
                        System.out.println("It's a pokeball");
                        player.receivePokeBall();
                    }
                    currentMap.removeOppAtLoc(player.getLocation());
                    break;
                case 'w':
                    trainerAttack(player, chooseRandomPokemon());
                    break;
                case 'p':
                    System.out.println("There's a stranger in the distance!");
                    int selectEncounter = (int) (Math.random() * 8) + 1;
                    if( selectEncounter <=  2){
                        System.out.println("Hello fellow trainer! Here's a potion!");
                        player.receivePotion();
                    } else if (selectEncounter > 2 && selectEncounter <= 4) {
                        System.out.println("Hello fellow trainer! Here, take this a pokeball!");
                        player.receivePokeBall();
                    } else if (selectEncounter > 4 && selectEncounter <= 6) {
                        System.out.println("Hello fellow trainer! Let me give you $10");
                        player.receiveMoney(10);
                    } else{
                        System.out.println("Ahhhhhh!! The stranger assaulted me for no reason");
                        player.takeDamage(10);
                    }
                    currentMap.removeOppAtLoc(player.getLocation());
                    break;
                case 'c':
                    store(player);
                    break;
                case 'f':
                    System.out.println("You have found a finish checkpoint!");
                    System.out.println("Do you want to leave the current map?");
                    boolean leaveMap = CheckInput.getYesNo();
                    if(leaveMap) {
                        if(currentMapIndex == 3){
                            currentMapIndex = 1;
                        } else{
                            currentMapIndex += 1;
                        }
                        currentMap.generateArea(currentMapIndex);
                        currentMap.displayMap(currentMap.findStartLocation());
                    }
            }
            //end switch
        }
        //end while loop
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
                    pokemonAI = new Oddish();
                    return pokemonAI;
                case 2:
                    pokemonAI = new Charmander();
                    return pokemonAI;
                case 3:
                    pokemonAI = new Bulbasaur();
                    return pokemonAI;
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
            boolean isTrainerAttackRunning = true;
            while(isTrainerAttackRunning){
                System.out.println("A wild " + wild.getName() + " has appeared");
                System.out.println( wild.getName() + " HP:" + wild.getHp() + "/" + wild.getMaxHp());
                System.out.println("What do you want to do?");
                System.out.println("1. Fight");
                System.out.println("2. Use Potion");
                System.out.println("3. Throw Poke Ball");
                System.out.println("4. Run Away");
                int attackChoice = CheckInput.getIntRange(1, 4);
                switch (attackChoice) {
                    case 1:
                        System.out.println("Fight!");
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
        }

        //TODO: its just a bunch of print statements. make sure to change use trainer.java and/or pokemon.java
        public static void store (Trainer t){
        	final int priceOfPokeball = 3;
        	final int priceOfPotion = 5;
            System.out.println("Welcome to the Objects.Pokemon Center!");
            System.out.println("What can I help you with?");
            System.out.println("1. Buy Potion - $5");
            System.out.println("2. Buy Poke Ball - $3");
            System.out.println("3. EXIT SHOP");
            int storeChoice = CheckInput.getIntRange(1, 3);
            switch (storeChoice) {
                case 1:
                	t.spendMoney(priceOfPokeball);
                    System.out.println("Purchased a potion!");
                    break;
                case 2:
                	t.spendMoney(priceOfPotion);
                    System.out.println("Purchased a poke ball!");
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
