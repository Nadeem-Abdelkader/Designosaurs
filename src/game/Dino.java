package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;

public abstract class Dino extends Actor {
    //    TODO: not tested
    private final ArrayList<Behaviour> behaviour = new ArrayList<>();
    private final String sex;
    private int foodLevel;

    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Dino(String name, char displayChar, int hitPoints, boolean isAdult) {
        super(name, displayChar, hitPoints);
        if (Math.random() < 0.5)
            this.sex = "Male";
        else {
            this.sex = "Female";
        }

        if (!isAdult) {
            addCapability(Status.isBaby);
        }
        this.foodLevel=100;
        behaviour.add(new WanderBehaviour());
    }
    public abstract Item breed();
    public String getSex() {
        return sex;
    }

    /**
     * Figure out what to do next.
     * <p>
     * FIXME: Stegosaur wanders around at random, or if no suitable MoveActions are available, it
     * just stands there.  That's boring.
     *
     * @see edu.monash.fit2099.engine.Actor#playTurn(Actions, Action, GameMap, Display)
     */
    public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
        for (Behaviour value : behaviour) {
            Action wander = value.getAction(this, map);
            if (wander != null)
                return wander;
        }
        return new DoNothingAction();
    }


//    public void breed() {
//        if (hitPoints > 50) {
//            if(sex.matches("Male")){
//                behaviour.add(new FollowBehaviour());
//            }
//            else if(sex.matches("Female")){
//            }
//        }
//    }
}
