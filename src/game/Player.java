package game;

import edu.monash.fit2099.engine.*;

/**
 * Class representing the Player.
 *
 * @author Charles Tan Wei Wen
 */
public class Player extends Actor {
    /**
     * constructor where ecopoints system is introduced and used below
     */
    private final Menu menu = new Menu();
    private int ecoPoints = 0;

    public void addEcoPoints(int points) {
        ecoPoints += points;
    }

    private int getEcoPoints() {
        return ecoPoints;
    }

    private final Behaviour[] behaviours = {
            new BuyBehaviour()
    };

    /**
     * Constructor for a player object
     *
     * @param name        Name to call the player in the UI
     * @param displayChar Character to represent the player in the UI
     * @param hitPoints   Player's starting number of hitpoints
     */
    public Player(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
    }

    /**
     * function for checking objects that can interact with the player
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the action the player will take
     */
    @Override
    public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
        if (map.locationOf(this).getGround() instanceof Grass) {
            actions.add(new HarvestGrass(map.locationOf(this)));
            ecoPoints += 1;
        }
        if (map.locationOf(this).getGround() instanceof Tree) {
            actions.add(new PickFruit(map.locationOf(this)));
        }
        if (map.locationOf(this).getItems() instanceof Fruit) {
            actions.add(new PickFruit(map.locationOf(this)));
        }
        for (Behaviour behaviour : behaviours) {
            if (behaviour != null) {
                actions.add(behaviour.getAction(this, map));
            }
        }
        Action buyMenu = menu.showMenu(this, actions, display);
        if (buyMenu instanceof SubMenuAbstract) {
            buyMenu.execute(this, map);
            Actions submenu = ((SubMenuAbstract) buyMenu).printSubMenu();
            return menu.showMenu(this, submenu, display);
        }
        if (map.locationOf(this).getActor() instanceof Stegosaur) {
            actions.add(new FeedAction(map.locationOf(this), this));
        }
        // Handle multi-turn Actions
        if (lastAction.getNextAction() != null)
            return lastAction.getNextAction();

        return menu.showMenu(this, actions, display);
    }
}
