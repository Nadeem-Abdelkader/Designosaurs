package game;

import edu.monash.fit2099.engine.WeaponItem;

public class LaserGun extends WeaponItem {

    public static final char DISPLAY_CHAR='L';
    public static final String NAME="Laser Gun";
    public static final String VERB="Shoots";
    public static final int DMG=50;

    public LaserGun() {
        super(NAME,DISPLAY_CHAR,DMG,VERB);
    }

}
