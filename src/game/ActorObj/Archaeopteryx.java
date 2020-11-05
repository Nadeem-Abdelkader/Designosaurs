package game.ActorObj;

import edu.monash.fit2099.engine.IntrinsicWeapon;
import edu.monash.fit2099.engine.Item;

public class Archaeopteryx extends Dinosaur{
    /**
     * Constructor for dinosaurs, creates a dinosaur with a random gender(50% male or female)
     * initializes staring foodlevel as 50
     *
     * @param name name of dinosaur
     * @param isAdult boolean whether the dinosaur is an adult or not
     */
    public Archaeopteryx(String name, boolean isAdult) {
        super(name, 'R', 100, isAdult);
    }

    @Override
    public Item breed() {
        return null;
    }

    /**
     * function for creating a weapon for allosaur to attack stegasour/or any other dinosaur
     *
     * @return a weapon for allosaur to use
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        if (Math.random() < 0.5) {
            return new IntrinsicWeapon(20, "bites");
        } else {
            return new IntrinsicWeapon(0, "bites but misses");
        }
    }
}
