package game.ItemObj;

import edu.monash.fit2099.engine.*;

/**
 * class for representing a dead stegasour as an Item object instead of an Actor object
 *
 * @author Charles Tan Wei Wen
 */
public class DeadStegasour extends Item {
    /**
     * constructor for dead stegasour, represented on the map as small letter d
     */
    public DeadStegasour() {
        super("Dead stegasour body", 'd', false);
    }

}
