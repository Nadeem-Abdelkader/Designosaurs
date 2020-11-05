package game;
import edu.monash.fit2099.engine.*;

/**
 * Class for representing a state where an Actor is unconscious
 *
 * @author Charles Tan Wei Wen
 */
public class UnconsciousAction extends Action{
    /**
     * Constructor for class, doesnt really initialize anything
     */
    public UnconsciousAction(){}

    /**
     * Returns a description of the state of the actor
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a string contains description of state of actor
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        return menuDescription(actor);
    }

    /**
     * Constructs a simple string for description of state of actor
     *
     * @param actor The actor performing the action.
     * @return a string containing the state of actor
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " is unconscious";
    }
}
