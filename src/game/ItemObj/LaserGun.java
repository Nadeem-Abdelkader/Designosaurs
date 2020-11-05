package game.ItemObj;

import edu.monash.fit2099.engine.WeaponItem;

/**
 * class for a laser gun capable of killing stuff
 *
 * @author Charles Tan Wei Wen
 */
public class LaserGun extends WeaponItem {
    /**
     * constructors for building a laser gun weapon
     */
    public static final char DISPLAY_CHAR='L';
    public static final String NAME="Laser Gun";
    public static final String VERB="Shoots";
    public static final int DMG=50;

    public LaserGun() {
        super(NAME,DISPLAY_CHAR,DMG,VERB);
    }

}
