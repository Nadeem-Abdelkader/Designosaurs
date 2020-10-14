package game;


import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.DoNothingAction;
import edu.monash.fit2099.engine.GameMap;

import java.util.ArrayList;

/**
 * A herbivorous dinosaur.
 */
public class Stegosaur extends Dino {
    // Will need to change this to a collection if Stegosaur gets additional Behaviours.

    /**
     * Constructor.
     * All Stegosaurs are represented by a 'S' and have 100 hit points.
     *
     * @param name the name of this Stegosaur
     */
    public Stegosaur(String name) {
        super(name, 'S', 100);
    }
}
