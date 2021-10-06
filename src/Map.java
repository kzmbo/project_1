
public class Map {
    private char [][] map;
    private boolean [][] revealed;

    public Map(){
         this.map = map;
         this.revealed = revealed;
    }

    public void loadMap(int mapNum){
        System.out.println("Map #" + mapNum + " is loaded!");
    }
}

// Map 1 Layout:
//n w n p n
//i p w n c
//s n p i n
//w c n w w
//n w n p f

//Map 2 Layout:
//n w p f w
//c n n p i
//n w i n c
//p n p w n
//w n w n s

//Map 3 Layout:
//w n n s p
//n w n i c
//f p w w n
//p n w n n
//w c i n p


//Appendix:
//S= Start
//F = Finish
//C = City
//W = Wild pokemon encounter
//P = Random person encounter
//N = No encounter