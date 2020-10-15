package game;

import edu.monash.fit2099.engine.*;

public class BuyStuff extends Action {
    private final Capabilities capabilities = new Capabilities();
    protected Location location;
    protected Item item;

    public BuyStuff(Location location, Item item) {
        this.location = location;
        this.item = item;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        for (ListOfItems items : ListOfItems.values()) {
            capabilities.addCapability(items);
        }
        return "SUCCess";
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " buys " + capabilities;
    }
}
