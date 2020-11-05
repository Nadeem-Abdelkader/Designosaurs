package game.ActorObj;

import edu.monash.fit2099.engine.*;
import game.ItemObj.DeadStegasour;

public class Agilisaurus extends Dinosaur {
    /**
     * Constructor.
     *
     * @param name
     * @param isAdult
     */
    public Agilisaurus(String name,boolean isAdult) {
        super(name, 'Y', 100,isAdult);
    }

    @Override
    public Item breed() {
        return null;
    }

    @Override
    public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
        if(!this.isConscious() && this.hitPoints<=0){
            map.locationOf(this).addItem(new DeadStegasour());
            map.removeActor(this);
        }
        return super.playTurn(actions, lastAction, map, display);
    }
}
