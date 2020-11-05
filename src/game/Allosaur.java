package game;

import edu.monash.fit2099.engine.*;

/**
 * class for a allosaur actor
 */
public class Allosaur extends Dinosaur {
    /**
     * Constructor.
     *
     * @param name the name of the Actor
     */
    public Allosaur(String name, boolean isAdult) {
        super(name, 'A', 100, isAdult);
    }

    /**
     * function that allows allosaurs to breed with each other
     *
     * TODO: breed for allosaur not implemented
     *
     * @return a behaviour or action?
     */
    @Override
    public Item breed() {
        return null;
    }

    /**
     * function for creating a weapon for allosaur to attack stegasour/or any other dinosaur
     *
     * @return a weapon for allosaur to use
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        if (Math.random() < 0.5) {
            return new IntrinsicWeapon(20, "bites");
        } else {
            return new IntrinsicWeapon(0, "bites but misses");
        }
    }

    /**
     * same as any dinosaur except allosaur can eat the dead stegasour if it finds one
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     *
     * @return an action of which the dinosaur will do depending on the situation
     */
    @Override
    public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
        if(map.locationOf(this).getItems() instanceof DeadStegasour){
            this.addFoodLevel(50);
            map.locationOf(this).removeItem(map.locationOf(this).getItems().get(0));
        }
        return super.playTurn(actions, lastAction, map, display);
    }
}
