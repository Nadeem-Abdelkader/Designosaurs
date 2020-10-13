package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

public class PickFruit extends Action {
    protected Location location;

    public PickFruit(Location location) {
        this.location = location;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        int failProbability = 60;
        double random = Math.random() * 100;

        if (random >= failProbability) {
            Fruit fruit = new Fruit();
            actor.addItemToInventory(fruit);
            return "success";
        }
        return "fail";
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " pick fruit from tree";
    }


}
