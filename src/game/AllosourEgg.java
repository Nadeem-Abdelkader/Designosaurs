package game;

import edu.monash.fit2099.engine.*;

public class AllosourEgg extends Item {
    private int hatchTimer = 20;

    public AllosourEgg() {
        super("Allosour Egg", 'a', true);
    }

    @Override
    public void tick(Location location) {
        hatchTimer -= 1;
        if (hatchTimer == 0) {
            Allosaur babyAllo = new Allosaur("baby allo", false);
            location.addActor(babyAllo);
            location.removeItem(this);
        }
    }
}
