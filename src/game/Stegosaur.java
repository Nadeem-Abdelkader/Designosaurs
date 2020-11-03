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
        super(name, 'S', 100,true);
    }

    @Override
    public Item breed() {
//        TODO: breed using breed behavoir class
        return null;
    }
}
