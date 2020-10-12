package game;

import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

public class Fruit extends Item
{
    /***
     * Constructor.
     *  @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */

    int rot = 0;

    public Fruit(String name, char displayChar, boolean portable)
    {
        super(name, displayChar, portable);
    }

    @Override
    public void tick(Location location)
    {
        rot = rot + 1;
        if(rot > 20)
        {
            location.removeItem(this);
        }
    }
}