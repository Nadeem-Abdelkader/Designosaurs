package game;

import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;

public class Grass extends Ground {
    private int age = 0;

    public Grass() {
        super('+');
    }

    @Override
    public void tick(Location location) {
        super.tick(location);

        age++;
        if (age == 10)
            displayChar = 'g';
        if (age == 20)
            displayChar = 'G';
    }
}
