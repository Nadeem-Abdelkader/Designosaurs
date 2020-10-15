package game;

import edu.monash.fit2099.engine.Item;

public class Allosaur extends Dino {
    /**
     * Constructor.
     *
     * @param name the name of the Actor
     */
    public Allosaur(String name) {
        super(name, 'A', 100,true);
    }

    @Override
    public Item breed() {
        return null;
    }
}
