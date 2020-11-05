package game.GroundObj;
import edu.monash.fit2099.engine.*;

public class Water extends Ground {

    public Water() {
        super('~');
    }
    @Override
    public boolean canActorEnter(Actor actor){
        return false;
    }

}
