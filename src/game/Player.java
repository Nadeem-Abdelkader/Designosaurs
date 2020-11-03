package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Menu;

/**
 * Class representing the Player.
 */
public class Player extends Actor {

    private final Menu menu = new Menu();
    private int ecoPoints=0;
    /**
     * Constructor.
     *
     * @param name        Name to call the player in the UI
     * @param displayChar Character to represent the player in the UI
     * @param hitPoints   Player's starting number of hitpoints
     */
    public Player(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
    }

    @Override
    public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
        if (map.locationOf(this).getGround() instanceof Grass) {
            actions.add(new HarvestGrass(map.locationOf(this)));
            ecoPoints+=1;
        }
        if (map.locationOf(this).getGround() instanceof Tree) {
            actions.add(new PickFruit(map.locationOf(this)));
        }
        if (map.locationOf(this).getItems() instanceof Fruit) {
            actions.add(new PickFruit(map.locationOf(this)));
        }
        if (map.locationOf(this).getGround() instanceof VendingMachine){
            actions.add(new BuyStuff(map.locationOf(this)));
        }
        if (map.locationOf(this).getActor() instanceof Stegosaur){
            actions.add(new FeedAction(map.locationOf(this)));
        }
        // Handle multi-turn Actions
        if (lastAction.getNextAction() != null)
            return lastAction.getNextAction();

        return menu.showMenu(this, actions, display);
    }
}
