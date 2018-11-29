
public class Level {
	private int floor;
	private ParkingSpot[] spots; // number of spots in each level, including large, compact and motorcycle size
	private int availableSpots = 0; // number of free spots
	private static final int SPOT_PER_ROW = 10;

	public Level(int flr, int numberSpots) {
		floor = flr;
		availableSpots = numberSpots;
		spots = new ParkingSpot[numberSpots];


		for (int i = 0; i < numberSpots; i++) {
			VehicleSize sz = VehicleSize.MotorCycle;
			if (i > numberSpots / 2) {
				sz = VehicleSize.Car;
			}			
			spots[i] = new ParkingSpot(i, sz);
		}
	}

	public int availableSpots() {
		return availableSpots;
	}

	public boolean parkVehicle(Vehicle vehicle) {
		if (availableSpots() < vehicle.getSpotsNeeded())
			return false;

		int spotNumber = findAvailableSpots(vehicle);
		if (spotNumber < 0)
			return false;
		boolean res = vehicle.parkInSpot(spots[spotNumber]);
		if (res == true)
			availableSpots--;
		return res;

	}

	public boolean removeVehicle(Vehicle vehicle) {
		ParkingSpot spot = vehicle.getParkingSpot();
		boolean res =vehicle.removeFromSpot(spot);
		availableSpots++;
		return res;

	}

	private int findAvailableSpots(Vehicle vehicle) {
		int spotNumber = -1;
		for (int i = 0; i < spots.length; i++) {
			ParkingSpot spot = spots[i];
			if (spots[i].canFitVehicle(vehicle)) {
				spotNumber = i;
			}
		}
		return spotNumber;

	}

	/*private boolean parkStartingAtSpot(int num, Vehicle v) {
		// park a vehicle starting at the spot spotNumber, and continuing until
		// vehicle.spotsNeeded
		
		boolean success = true;
		for (int i = num; i < num + v.spotsNeeded; i++) {
			success &= spots[i].park(v);
		}
		availableSpots -= v.spotsNeeded;
		return success;

		boolean success = true;

	}*/

}
