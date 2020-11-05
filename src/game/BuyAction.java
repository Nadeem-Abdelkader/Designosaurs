package game;

import edu.monash.fit2099.engine.*;

/**
 * class for processing the items bought from the player
 *
 * @author Charles Tan Wei Wen
 */
public class BuyAction extends Action {
    /**
     * constructor for player buying the item and the item to be bought
     */
    private final Player player;
    private final String item;

    /**
     * constructor for player and item
     * @param player player thats buying the item
     * @param item item thats player is going to buy
     */
    public BuyAction(Player player, String item) {
        this.player = player;
        this.item = item;
    }

    /**
     * depending on the item that the player wants to buy, the item will be added into
     * the player's inventory
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a string if the player buys anything
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        switch (item) {
            case "Hay" -> {
                player.addItemToInventory(new Hay());
                return "Player bought Hay";
            }
            case "Fruit" -> {
                player.addItemToInventory(new Fruit());
                return "Player bought fruit";
            }
            case "VegetarianMeal" -> {
                player.addItemToInventory(new VegetarianMeal());
                return "Player bought Vegetarian meal";
            }
            case "CarnivoreMeal" -> {
                player.addItemToInventory(new CarnivoreMeal());
                return "Player bought Carnivore meal";
            }
            case "StegasourEgg" -> {
                player.addItemToInventory(new StegasourEgg());
                return "Player bought Stegasour egg";
            }
            case "AllosourEgg" -> {
                player.addItemToInventory(new AllosourEgg());
                return "Player bought Allosaur egg";
            }
            case "LaserGun" -> {
                player.addItemToInventory(new LaserGun());
                return "Player bought Laser gun";
            }
            case "ArchaeopteryxEgg"-> {
                player.addItemToInventory(new ArchaeopteryxEgg());
                return "Player bought Archaeopteryx Egg";
            }
        }
        return "Player didnt buy anything";
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " buys " + item;
    }
}
