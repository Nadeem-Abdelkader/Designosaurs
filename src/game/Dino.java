package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;

public abstract class Dino extends Actor {
    //    TODO: not tested
    private final ArrayList<Behaviour> behaviour = new ArrayList<>();
    private final String gender;
    private int foodLevel;
    private int knockdownCountdown;

    /**
     * Constructor.
     *
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Dino(String name, char displayChar, int hitPoints, boolean isAdult) {
        super(name, displayChar, hitPoints);
        if (Math.random() < 0.5)
            this.gender = "Male";
        else {
            this.gender = "Female";
        }

        if (!isAdult) {
            addCapability(Status.isBaby);
        }
        this.foodLevel = 50;
        this.knockdownCountdown = 0;
        behaviour.add(new WanderBehaviour());
    }

    public abstract Item breed();

    public String getGender() {
        return gender;
    }

    public int getFoodLevel() {
        return foodLevel;
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
        if (foodLevel > 20)
            foodLevel -= 1;

         else if (foodLevel > 0) {
            foodLevel -= 1;
            System.out.println(name + " at " + map.locationOf(this) + " is getting hungry ");

        } else if (foodLevel == 0) {
            knockdownCountdown += 1;
            if (knockdownCountdown == 20)
                map.removeActor(this);

            return new UnconsciousAction();
        }
        for (Behaviour value : behaviour) {
            Action wander = value.getAction(this, map);
            if (wander != null)
                return wander;
        }
        return new DoNothingAction();
    }
    public void addFoodLevel(int add){
        foodLevel+=add;
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
