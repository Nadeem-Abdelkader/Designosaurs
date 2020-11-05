package game.ItemObj;

import edu.monash.fit2099.engine.*;
import game.ActorObj.Stegosaur;

/**
 * Class for stegasour egg
 *
 * @author Charles Tan Wei Wen
 */
public class StegasourEgg extends Item {
    private int hatchTimer = 20;

    /**
     * initializes the egg as a portable item that has a display
     * character of E
     */
    public StegasourEgg() {
        super("Egg", 'E', true);
    }

    /**
     * for each turn, the egg will hatch itself and when the timer
     * has expired, a new stegasour will be born
     *
     * @param location The location of the ground on where the egg is.
     */
    @Override
    public void tick(Location location) {
        hatchTimer -= 1;
        if (hatchTimer == 0) {
            Stegosaur newSte = new Stegosaur("baby stega",false);
            location.addActor(newSte);
            location.removeItem(this);
        }
    }
}
