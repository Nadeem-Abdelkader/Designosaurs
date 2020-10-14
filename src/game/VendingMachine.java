package game;

import edu.monash.fit2099.engine.*;

public class VendingMachine extends Ground {

    public VendingMachine(){
        super('V');
    }

    @Override
    public Actions allowableActions(Actor actor, Location location, String direction) {
        return super.allowableActions(actor, location, direction);
    }


//    TODO: not done yet
}
