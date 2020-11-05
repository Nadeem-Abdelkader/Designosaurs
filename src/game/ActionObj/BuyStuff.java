package game.ActionObj;

import edu.monash.fit2099.engine.*;
import game.ActorObj.Player;
import game.EnumObj.ListOfItems;

/**
 * class for buying stuff from vending machine
 *
 * @author Charles Tan Wei Wen
 */
public class BuyStuff extends SubMenuAbstract {
    /**
     * constructor for the map the player is currently on and the player buying the things
     */
    protected GameMap map;
    protected int pts;
    protected Player player;

    /**
     * constructor for buying stuff
     * @param actor the player currently buying the things
     * @param map the map the player is currently on
     */
    public BuyStuff(Actor actor, GameMap map) {
        this.map = map;
        this.player = (Player) actor;
    }

    /**
     * function for printing a submenu for players to choose from
     *
     * @return the actions of which the player can do with the vending machine
     */
    @Override
    public Actions printSubMenu() {
        Actions actions = new Actions();
        for (ListOfItems item : ListOfItems.values()) {
            actions.add(new BuyAction(player, item.toString()) {
                @Override
                public String menuDescription(Actor actor) {
                    return "buys" + item.toString();
                }
            });
        }
        return actions;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        return "No pre-processing required";
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " buys stuff from vending machine";
    }

}
