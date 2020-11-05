package game.ActorObj;


import edu.monash.fit2099.engine.*;
import game.ActorObj.Dinosaur;
import game.ItemObj.DeadStegasour;

/**
 * Class of a herbivorous dinosaur.
 *
 * @author Charles Tan Wei Wen
 */
public class Stegosaur extends Dinosaur {
    // Will need to change this to a collection if Stegosaur gets additional Behaviours.
    /**
     * Constructor.
     * All Stegosaurs are represented by a 'S' and have 100 hit points.
     *
     * @param name the name of this Stegosaur
     */
    public Stegosaur(String name,boolean isAdult) {
        super(name, 'S', 100,isAdult);
    }

    @Override
    public Item breed() {
//        TODO: breed using breed behavoir class
        return null;
    }

    /**
     * Stegasour will have a foodlevel where it decrements by 1 every turn, sends out an alert
     * when foodlevel drops below 20, and sent into an unconscious state when it drops to 0,
     * if stegasour has no health, it dies and becomes a dead stegasour where allosaur can eat it
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the Action to be performed
     */
    @Override
    public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
        if(!this.isConscious() && this.hitPoints<=0){
            map.locationOf(this).addItem(new DeadStegasour());
            map.removeActor(this);
        }
        return super.playTurn(actions, lastAction, map, display);
    }
}
