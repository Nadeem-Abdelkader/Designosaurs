package game;

import edu.monash.fit2099.engine.*;

public class FeedAction extends Action {
    private final Location location;

    public FeedAction(Location location) {
        this.location = location;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        Stegosaur dino = (Stegosaur) location.getActor();
        for (Item item : actor.getInventory()) {
            if (item instanceof Fruit) {
                dino.addFoodLevel(20);
                return "Added foodlevel 20 with fruit";
            }
            if (item instanceof Hay) {
                dino.addFoodLevel(10);
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
