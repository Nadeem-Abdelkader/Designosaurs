package game;

import edu.monash.fit2099.engine.*;

public class Allosaur extends Dinosaur {
    /**
     * Constructor.
     *
     * @param name the name of the Actor
     */
    public Allosaur(String name, boolean isAdult) {
        super(name, 'A', 100, isAdult);
    }

    @Override
    public Item breed() {
        return null;
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        if (Math.random() < 0.5) {
            return new IntrinsicWeapon(20, "bites");
        } else {
            return new IntrinsicWeapon(0, "bites but misses");
        }
    }

    @Override
    public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
        if(map.locationOf(this).getItems() instanceof DeadStegasour){
            this.addFoodLevel(50);
            map.locationOf(this).removeItem(map.locationOf(this).getItems().get(0));
        }
        return super.playTurn(actions, lastAction, map, display);
    }
}
