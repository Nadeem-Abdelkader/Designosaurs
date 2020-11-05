package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;

/**
 * class for breeding between dinosaurs
 *
 * @author Charles Tan Wei Wen
 */
public class BreedBehaviour implements Behaviour {
    /**
     * constructor for dinosaur, determine which two dinosaurs to mate with
     */
    private final Dinosaur mate;

    public BreedBehaviour(Dinosaur dino) {
        this.mate = dino;
    }

    /**
     * determines
     *
     * @param actor the Actor acting
     * @param map   the GameMap containing the Actor
     * @return a behaviour or action? not implemented yet
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        if (!map.contains(mate) || !map.contains(actor))
            return null;
        Location mate1 = map.locationOf(actor);
        Location mate2 = map.locationOf(mate);
        int distanceDiff = distance(mate1, mate2);

        List<Exit> exits=new ArrayList<Exit>(map.locationOf(actor).getExits());
        for (Exit e:exits){
            if(distanceDiff==1){
//                TODO: if dist=1 timer=10 and each turn-1
            }
        }
        return null;
    }

    private int distance(Location a, Location b) {
        return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
    }
}
