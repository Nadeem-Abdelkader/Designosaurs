package game;

import edu.monash.fit2099.engine.*;

/**
 * class for allowing players to feed to dinosaurs
 *
 * @author Charles Tan Wei Wen
 */
public class FeedAction extends Action {
    /**
     * initialize the player and location of the dinosaur
     */
    private final Location location;
    private final Player player;

    public FeedAction(Location location, Player player) {
        this.player = player;
        this.location = location;
    }

    /**
     * function for allowing the player to feed dinosaurs by using
     * a fruit or hay from its inventory
     * if a fruit or hay is fed to a dinosaur, player gains ecopoints
     * while dinosaurs gains foodlevel
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a string indicating what happened
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        Stegosaur dino = (Stegosaur) location.getActor();
        for (Item item : actor.getInventory()) {
            if (item instanceof Fruit) {
                dino.addFoodLevel(20);
                player.addEcoPoints(15);
                return "Added foodlevel 20 with fruit";
            }
            if (item instanceof Hay) {
                dino.addFoodLevel(10);
                player.addEcoPoints(10);
                return "Added foodlevel 10 with hay";
            }
        }
        return "Failed";
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " feeds stegasour ";
    }
}
