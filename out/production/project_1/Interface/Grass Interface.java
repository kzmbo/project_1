/**
Description: this is the special attacks for the grass pokemon
*/
public interface Grass{
  String specialMenu = "1. Vine Whip\n2. Razor Leaf\n3. Solar Beam";
  int numSpecialMenuItems = 3;
  String vineWhip(Pokemon p);
  String razorLeaf(Pokemon p);
  String solarBeam(Pokemon p);

}
