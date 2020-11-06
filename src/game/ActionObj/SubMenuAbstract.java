package game.ActionObj;
import edu.monash.fit2099.engine.*;

/**
 * abstract class for actions that invokes sub menus for more selection
 * contains an extra printSubMenu where it returns all actions for the sub menu
 */
public abstract class SubMenuAbstract extends Action {
    public abstract Actions printSubMenu();

    @Override
    public abstract String execute(Actor actor, GameMap map);

    @Override
    public abstract String menuDescription(Actor actor);
}
