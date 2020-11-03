package game;
import edu.monash.fit2099.engine.*;

public class UnconsciousAction extends Action{
    public UnconsciousAction(){}
    @Override
    public String execute(Actor actor, GameMap map) {
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " is unconscious";
    }
}
