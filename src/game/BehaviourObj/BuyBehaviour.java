package game.BehaviourObj;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import game.ActionObj.BuyStuff;

/**
 * behaviour class for player buying things
 *
 * @author Charles Tan Wei Wen
 */
public class BuyBehaviour implements Behaviour {
    /**
     * at the moment the only action allowed is player buying from the vending machine
     * if any other action needs to be added it can be added from here
     *
     * @param actor the Actor acting
     * @param map   the GameMap containing the Actor
     * @return the action allowed for buying stuff
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        return new BuyStuff(actor,map);
    }
}
