package game;

import edu.monash.fit2099.engine.*;

public class Egg extends Item {
    int hatchTimer = 20;

    public Egg() {
        super("Egg", 'E', true);
    }

    @Override
    public void tick(Location location) {
        hatchTimer -= 1;
        if (hatchTimer == 0) {
            Stegosaur newSte = new Stegosaur("baby stega");
            location.addActor(newSte);
            location.removeItem(this);
        }
    }
}
