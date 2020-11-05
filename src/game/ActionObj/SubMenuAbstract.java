package game.ActionObj;
import edu.monash.fit2099.engine.*;

public abstract class SubMenuAbstract extends Action {
    public abstract Actions printSubMenu();

    @Override
    public abstract String execute(Actor actor, GameMap map);

    @Override
    public abstract String menuDescription(Actor actor);
}
