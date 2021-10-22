package Controller;

import Objects.*;
import _Pokemon.*;

import java.awt.*;


public class Main {
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

        Trainer player;
        Pokemon playerStartingPokemon;
        Map currentMap = new Map();
        char currentChar = 'a';
        int currentMapIndex = 1;

        if (choice == 1) {
            playerStartingPokemon = new Charmander();
            player = new Trainer(name, playerStartingPokemon, currentMap);
        } else if (choice == 2) {
            playerStartingPokemon = new Bulbasaur();
            player = new Trainer(name, playerStartingPokemon, currentMap);
        } else {
            playerStartingPokemon = new Squirtle();
            player = new Trainer(name, playerStartingPokemon, currentMap);
        }

        System.out.println(player.getPokemonList());

        boolean isGameRunning = true;
        while(isGameRunning){
            currentMap.displayMap(player.getLocation());
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
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }//end switch
            currentMap.reveal(player.getLocation());

            if(isGameRunning) {
                if (currentChar == 'n') {
                    System.out.println("No encounter found");
                } else if (currentChar == 'i') {
                    System.out.println("I found an item!");
                    int selectRandomItem = (int) (Math.random() * 4) + 1;
                    if (selectRandomItem <= 2) {
                        System.out.println("It's a potion");
                        player.receivePotion();
                    } else {
                        System.out.println("It's a pokeball");
                        player.receivePokeBall();
                    }
                    currentMap.removeOppAtLoc(player.getLocation());
                } else if (currentChar == 'w') {
                    trainerAttack(player, chooseRandomPokemon());
                } else if (currentChar == 'p') {
                    System.out.println("There's a stranger in the distance!");
                    int selectEncounter = (int) (Math.random() * 12) + 1;
                    if( selectEncounter ==  1){
                        System.out.println("Hello there! the Poke Center is having a giveaway promotion! Here's a potion!");
                        player.receivePotion();
                    } else if (selectEncounter == 2) {
                        System.out.println("Hello fellow trainer! Here, take this pokeball!");
                        player.receivePokeBall();
                    } else if (selectEncounter == 3) {
                        System.out.println("Hello! I went to the gaming corner and got a ton of money! Here let me give you $10");
                        player.receiveMoney(10);
                    } else if (selectEncounter == 4) {
                        System.out.println("Ahhhhhh!! The stranger assaulted me for no reason");
                        player.takeDamage(10);
                    } else if (selectEncounter == 5) {
                        System.out.println("That's not a stranger! That's a herd of Tauros! they knocked you around.");
                        player.takeDamage(5);
                    } else if (selectEncounter == 6) {
                        System.out.println("As you chat with the stranger, you hear in the distance 'TEAM ROCKET IS BLASTING OFF AGAIN!' those people never learn huh?");
                    } else if (selectEncounter == 7) {
                        System.out.println("It wasn't a stranger, it was a shiny pokemon! sadly it ran away before you could get close to catch it");
                    } else if (selectEncounter == 8) {
                        System.out.println("You approach the stranger, he seems to be asleep, there is a Jigglypuff on his lap holding a mic, best you walk away now.");
                    } else if (selectEncounter == 9) {
                        System.out.println("Its Professor Oak! he hands you some pokeballs to catch more pokemon.");
                        player.receivePokeBall();
                        player.receivePokeBall();
                        player.receivePokeBall();
                    } else if (selectEncounter == 10) {
                        System.out.println("It turns out to the stranger was in fact an angry pokemon!");
                        player.takeDamage(5);
                    } else if (selectEncounter == 11) {
                        System.out.println("It looks like the stranger is in a pokemon battle, you decide to watch, after the fight he notices you and gives you a potion for cheering her on.");
                        player.receivePotion();
                    } else if (selectEncounter == 12) {
                        System.out.println("It turns out its the Pokemon League Champion! they tell you they are on a stroll and ask you not to tell anyone they were there.");
                    }
                    currentMap.removeOppAtLoc(player.getLocation());
                } else if (currentChar == 'c') {
                    store(player);
                } else if (currentChar == 'f') {
                    System.out.println("You have found a finish checkpoint!");
                    System.out.println("Do you want to leave the current map?");
                    boolean leaveMap = CheckInput.getYesNo();
                    if (leaveMap) {
                        if (currentMapIndex == 3) {
                            currentMapIndex = 1;
                        } else {
                            currentMapIndex += 1;
                        }
                        currentMap.generateArea(currentMapIndex);
                        currentMap.setNextMap(true);
                    }
                }
            }//end if statement
        }//end while loop
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

        public static void trainerAttack(Trainer t, Pokemon wild){
            int pokemonChosen = 0;
            System.out.println();
            System.out.println("A wild " + wild.getName() + " has appeared.");

            boolean isTrainerAttacking = true;
            while (isTrainerAttacking){
                System.out.println(wild.getName() + " HP: " + wild.getHp() + "/" + wild.getMaxHp());
                System.out.println("What do you want to do?");
                System.out.println("1. Fight\n2. Use Potion\n3. Throw Poke Ball\n4. Run Away");
                int choice = CheckInput.getIntRange(1, 4);
                switch (choice) {
                    case 1:
                        System.out.println("Choose a Pokemon: ");
                        System.out.println(t.getPokemonList());
                        pokemonChosen = CheckInput.getIntRange(1,t.getNumPokemon());
                        Pokemon attackingPokemon = t.getPokemon(pokemonChosen - 1);
                        if(t.getPokemon(pokemonChosen - 1).getHp() <= 0){
                            System.out.println("Darn! " + t.getPokemon(pokemonChosen - 1).getName() + " is downed! Can't fight");
                            break;
                        }
                        System.out.println(attackingPokemon.getName() +" I CHOSE YOU!!!");

                        System.out.println(attackingPokemon.getAttackMenu());
                        int attack = attackingPokemon.getNumAttackMenuItems();

                        if(attack == 1){
                            System.out.println(attackingPokemon.getBasicMenu());
                            int num = attackingPokemon.getNumBasicMenuItems();
                            System.out.println(attackingPokemon.basicAttack(wild,num));
                        } else{
                            System.out.println(attackingPokemon.getSpecialMenu());
                            int num = attackingPokemon.getNumSpecialMenuItems();
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
                       break;
                    case 2:
                        System.out.println("Choose a Pokemon to heal: ");
                        System.out.println(t.getPokemonList());
                        pokemonChosen = CheckInput.getIntRange(1,t.getNumPokemon());
                        t.usePotion(pokemonChosen - 1);
                        break;
                    case 3:
                        System.out.println("Shake...Shake...Shake");
                        if (t.catchPokemon(wild)){
                            System.out.println("You caught " + wild.getName());
                            System.out.println(t.toString());
                            System.out.println(t.getPokemonList());
                            isTrainerAttacking = false;
                        } else {
                            System.out.println("Oh no! " + wild.getName() + " has escaped!");
                        }
                        break;
                    case 4:
                        System.out.println("Shucks! Let's book it!");
                        System.out.println(wild.getName() + " is running away as well!");
                        isTrainerAttacking = false;
                        break;
                }
                //end switch
            }
            //end while loop
        }//end of the trainer attack method


        public static void store (Trainer t){
        	final int priceOfPokeball = 3;
        	final int priceOfPotion = 5;
            boolean isTrainerShopping = true;
            while(isTrainerShopping){
                System.out.println("Welcome to the Objects.Pokemon Center!");
                System.out.println("What can I help you with?");
                System.out.println(t.toString());
                System.out.println("1. Buy Potion - $5");
                System.out.println("2. Buy Poke Ball - $3");
                System.out.println("3. EXIT SHOP");
                int storeChoice = CheckInput.getIntRange(1, 3);
                switch (storeChoice) {
                    case 1:
                        if (t.spendMoney(priceOfPotion)){
                            t.receivePotion();
                            System.out.println("Purchased a potion!");
                        } else {
                            System.out.println("Insufficient funds");
                        }
                        break;
                    case 2:
                        if (t.spendMoney(priceOfPokeball)){
                            t.receivePokeBall();
                            System.out.println("Purchased a pokeball");
                        } else {
                            System.out.println("Insufficient funds");
                        }
                        break;
                    case 3:
                        System.out.println("*EXITING SHOP*");
                        System.out.println("Thank you! Come again next time!");
                        isTrainerShopping = false;
                        break;
                    default:
                        System.out.println("Invalid input!");
                        break;
                }
                //end switch
            }
            //end loop
        }
        //end method
    }
