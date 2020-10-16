package game;

import edu.monash.fit2099.engine.*;

public class Allosaur extends Dino {
    /**
     * Constructor.
     *
     * @param name the name of the Actor
     */
    public Allosaur(String name) {
        super(name, 'A', 100, true);
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
}
