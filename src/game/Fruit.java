package game;

import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

public class Fruit extends Item {
    int rot = 0;

    public Fruit() {
        super("Fruit", 'F', true);
    }

    @Override
    public void tick(Location location) {
        rot = rot + 1;
        if (rot > 20) {
            location.removeItem(this);
        }
    }
}