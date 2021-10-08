package Interface;
import Objects.Pokemon;

public interface Fire {
    String specialMenu = "1. Ember\n2. Interface.Fire Blast\n3. Interface.Fire Punch";
    int numSpecialMenuItems = 3;

    String ember(Pokemon p);
    String fireBlast(Pokemon p);
    String firePunch(Pokemon p);
}
