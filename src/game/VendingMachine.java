package game;

import edu.monash.fit2099.engine.*;

public class VendingMachine extends Ground {

    public VendingMachine() {
        super('V');
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }

//    TODO: not done yet
}

