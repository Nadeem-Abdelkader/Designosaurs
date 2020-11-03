package game;


import edu.monash.fit2099.engine.*;

/**
 * A herbivorous dinosaur.
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

    @Override
    public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
        if(!this.isConscious() && this.hitPoints<=0){
            map.locationOf(this).addItem(new DeadStegasour());
            map.removeActor(this);
        }
        return super.playTurn(actions, lastAction, map, display);
    }

}
