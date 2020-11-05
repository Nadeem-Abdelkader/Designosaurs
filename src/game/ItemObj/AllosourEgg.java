package game.ItemObj;

import edu.monash.fit2099.engine.*;
import game.ActorObj.Allosaur;

/**
 * class for making a allosaur egg as an item
 *
 * @author Charles Tan Wei Wen
 */
public class AllosourEgg extends Item {
    private int hatchTimer = 20;

    /**
     * constructor for an allosaur egg
     */
    public AllosourEgg() {
        super("Allosour Egg", 'a', true);
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
            Allosaur babyAllo = new Allosaur("baby allo", false);
            location.addActor(babyAllo);
            location.removeItem(this);
        }
    }
}
