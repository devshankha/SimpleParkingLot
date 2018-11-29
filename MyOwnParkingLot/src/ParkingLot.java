import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
	private Level[] levels;
	private final int NUM_LEVELS = 2;
	//Maintains mapping between the level at which vehicles are parked
	Map<Vehicle,Integer> map = new HashMap<>();

	public ParkingLot(int numberSpots) {
		levels = new Level[NUM_LEVELS];
		for (int i = 0; i < NUM_LEVELS; i++) {
			levels[i] = new Level(i, numberSpots);
			System.out.println("Level " + i + " created with " + numberSpots + " " + "spots");
		}

	}
	/*
	 * The sequence for doing a park, ParkingLot ->park, Level ->parkVehicle
	 * Vehicle ->parkInSpot
	 */

	public boolean park(Vehicle vehicle) {
		for (int i = 0; i < levels.length; i++) {
			if (levels[i].parkVehicle(vehicle)) {
				map.put(vehicle, i);
				

			}

		}
		return true;
	}
	/*
	 * The sequence for doing a remove, ParkingLot ->remove, Level ->removeVehicle
	 * Vehicle ->removeFromSpot
	 */
	public boolean remove(Vehicle vehicle) {
		Integer l =map.get(vehicle);
		if (l == null)
			return false;
		boolean s = levels[l].removeVehicle(vehicle);
		
		return true;
	}

}
