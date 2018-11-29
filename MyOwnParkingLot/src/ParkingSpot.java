
public class ParkingSpot {
	Vehicle vehicle;
	private VehicleSize spotSize;	
	int spotNumber;

	public ParkingSpot(int n, VehicleSize s) {	

		spotNumber = n;
		spotSize = s;
	}

	void addVehicle(Vehicle v) {
		vehicle = v;

	}

	void removeVehicle(Vehicle v) {
		vehicle = null;

	}

	public VehicleSize getSize() {
		return spotSize;
	}

	public boolean isAvailable() {
		return vehicle == null;
	}

	public boolean canFitVehicle(Vehicle vehicle) {
		// check if the spot is big enough and is available
		return isAvailable() && vehicle.canFitInSpot(this);
	}

}
