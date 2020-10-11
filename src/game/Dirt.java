package game;

import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;
import game.Grass;

/**
 * A class that represents bare dirt.
 */
public class Dirt extends Ground {

	Grass grass = new Grass();

	public Dirt() {
		super('.');
	}

	public void growGrass(Location location){
		grass.tick(location);
	}
}
