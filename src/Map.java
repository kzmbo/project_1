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
