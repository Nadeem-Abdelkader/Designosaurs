package game;

import edu.monash.fit2099.engine.*;

import java.util.Arrays;

public class BuyStuff extends Action {
    private final Capabilities capabilities = new Capabilities();
    protected Location location;
    protected Item itemToBuy;

    public BuyStuff(Location location) {
        this.location = location;
        for (ListOfItems items : ListOfItems.values()) {
            capabilities.addCapability(items);
        }
    }

    @Override
    public String execute(Actor actor,GameMap map) {
        actor.addItemToInventory(itemToBuy);
        return "SUCCess";
    }


    @Override
    public String menuDescription(Actor actor) {
        return actor + " buys " + Arrays.toString(ListOfItems.values());
//        TODO: cant make it iterate like directions
    }
}
