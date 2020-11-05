package game;

import edu.monash.fit2099.engine.*;

/**
 * class for representing a dead stegasour as an Item object instead of an Actor object
 *
 * @author Charles Tan Wei Wen
 */
public class DeadStegasour extends Item {
    /**
     * constructor for dead stegasour
     */
    public DeadStegasour() {
        super("Dead stegasour body", 'd', false);
    }

}
