package game.ActionObj;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;
import game.GroundObj.Dirt;
import game.ItemObj.Hay;

public class HarvestGrass extends Action {

    private final Location location;

    public HarvestGrass(Location location) {
        this.location = location;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        location.setGround(new Dirt());
        actor.addItemToInventory(new Hay());

        return "Success";
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
