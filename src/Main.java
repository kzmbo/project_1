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
        switch (choice){
            case 1:
                Charmander charmander = new Charmander("Charmander");
                trainer = new Trainer(name, charmander, map);
                mainMenu(charmander, trainer);
                break;
            case 2:
//                Charmander charmander = new Charmander("Charmander");
//                Map map = new Map();
//                Trainer trainer = new Trainer(name, charmander, map);
//                System.out.println(trainer.toString());
//                mainMenu(charmander);
                break;
            case 3:
                Squirtle squirtle = new Squirtle("Squirtle");
                trainer = new Trainer(name, squirtle, map);
                mainMenu(squirtle, trainer);
                break;
        }
    }

    public static int mainMenu(Pokemon p, Trainer t){
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

        boolean isGameRunning = true;
        while(isGameRunning){
            System.out.println("--map--");
            System.out.println();
            System.out.println("Main Menu:");
            System.out.println("1. Go North");
            System.out.println("2. Go South");
            System.out.println("3. Go East");
            System.out.println("4. Go West");
            System.out.println("5. QUIT GAME");
            int choice = CheckInput.getIntRange(1, 5);
            switch (choice){
                case 1:
                    System.out.println("Heading North!");
                    break;
                case 2:
                    System.out.println("Heading South!");
                    break;
                case 3:
                    System.out.println("Heading East!");
                    break;
                case 4:
                    System.out.println("Heading West!");
                    break;
                case 5:
                    System.out.println("Game Over!");
                    isGameRunning = false;
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
        }
        return 0;
    }

//    public static Pokemon chooseRandomPokemon(){
//        return Pokemon;
//    }

    public static void trainerAttack(Trainer t, Pokemon wild){
        System.out.println("A wild --some wild pokemon-- has appeared");
        System.out.println("--some wild pokemon-- HP:20/20");
        System.out.println("What do you want to do?");
        System.out.println("1. Fight");
        System.out.println("2. Use Potion");
        System.out.println("3. Throw Poke Ball");
        System.out.println("4. Run Away");
        int choice = CheckInput.getIntRange(1, 4);
        switch (choice) {
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

    public static void store(Trainer t){
        System.out.println("Welcome to the Pokemon Center!");
        System.out.println("What can I help you with?");
        System.out.println("1. Buy Potion - $5");
        System.out.println("2. Buy Poke Ball - $3");
        System.out.println("3. EXIT SHOP");
        int choice = CheckInput.getIntRange(1, 3);
        switch (choice){
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
