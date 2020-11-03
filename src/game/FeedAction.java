package game;

import edu.monash.fit2099.engine.*;

public class FeedAction extends Action {
    private final Location location;
    private final Player player;

    public FeedAction(Location location, Player player) {
        this.player = player;
        this.location = location;
    }

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
