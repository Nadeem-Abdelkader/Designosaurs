package game;

import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

public class ArchaeopteryxEgg extends Item {
    private int hatchTimer=20;
    /***
     * Constructor.
     */
    public ArchaeopteryxEgg() {
        super("Archaeopteryx Egg",'r',true);
    }

    /**
     * for each turn, the egg will have a timer that determines when it should hatch
     * at 20th turn it should create a new baby allosaur
     *
     * @param location location of where the egg is
     */
    @Override
    public void tick(Location location) {
        hatchTimer -= 1;
        if (hatchTimer == 0) {
            Archaeopteryx baby_arch = new Archaeopteryx("baby allo", false);
            location.addActor(baby_arch);
            location.removeItem(this);
        }
    }
}
