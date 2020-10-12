package game;
import edu.monash.fit2099.engine.*;

/**
 * A class that represents bare dirt.
 */
public class Dirt extends Ground {


	public Dirt() {
		super('.');
	}

	@Override
	public void tick(Location location)
	{
		int chanceTree = 2;
		int chanceGrass = 10;
		int counter = 0;
		double random = Math.random() * 99 + 1;

		for (Exit exit : location.getExits())
		{
			Location destination = exit.getDestination();
			if(destination.getGround() instanceof Grass)
			{
				counter = counter + 1;
				if (counter >= 2)
				{
					if (random <= chanceGrass)
					{
						Ground grass = new Grass();
						location.setGround(grass);
					}
				}

			}
			else if(destination.getGround() instanceof Tree)
			{
				if (random<=chanceTree)
				{
					Ground grass = new Grass();
					location.setGround(grass);
				}
			}
		}
	}
}
