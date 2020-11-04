package game;

import edu.monash.fit2099.engine.*;

public class StegasourEgg extends Item {
    private int hatchTimer = 20;

    public StegasourEgg() {
        super("Egg", 'E', true);
    }

    @Override
    public void tick(Location location) {
        hatchTimer -= 1;
        if (hatchTimer == 0) {
            Stegosaur newSte = new Stegosaur("baby stega",false);
            location.addActor(newSte);
            location.removeItem(this);
        }
    }
}
