package game.ActorObj;

import edu.monash.fit2099.engine.*;
import game.ActionObj.UnconsciousAction;
import game.BehaviourObj.Behaviour;
import game.BehaviourObj.WanderBehaviour;
import game.EnumObj.Status;

import java.util.ArrayList;

/**
 * An abstract class for creating dinosaurs
 * initializes useful variables such as foodlevel, gender, behaviour for every type dinosaurs to use
 *
 * @author Charles Tan Wei Wen
 */
public abstract class Dinosaur extends Actor {

    private final ArrayList<Behaviour> behaviour = new ArrayList<>();
    private final String gender;
    private int foodLevel;
    private int knockdownCountdown;
    private final int maxFoodLevel=100;

    /**
     * Constructor for dinosaurs, creates a dinosaur with a random gender(50% male or female)
     * initializes staring foodlevel as 50
     *
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Dinosaur(String name, char displayChar, int hitPoints, boolean isAdult) {
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
     * Actions of what the dinosaur will do for next turn
     * foodlevel will be decremented and a warning will be printed out when it reaches
     * 20 or below, at 0 foodlevel, the dinosaur will become unconscious in 20 turns if no food is eaten/fed
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     *
     * @return the action the player will take based on the condition of the dinosaur
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

    /**
     * simple function to add foodlevel to a dinosaur
     * caps at 100 if any more food is given
     *
     * @param add the amount of foodlevel to be added
     */
    public void addFoodLevel(int add){
        foodLevel+=add;
        foodLevel=Math.min(maxFoodLevel,foodLevel);
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
