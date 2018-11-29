import java.util.ArrayList;

public abstract class Vehicle {
	protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<ParkingSpot>();
	protected String licensePlate;
	protected int spotsNeeded;
	protected VehicleSize size;
	
	public ParkingSpot getParkingSpot() {
		return parkingSpots.get(0);
	}

	public int getSpotsNeeded() {
		return spotsNeeded;
	}

	public VehicleSize getSize() {
		return size;
	}

	public boolean parkInSpot(ParkingSpot s) {
		parkingSpots.add(s);
		s.addVehicle(this);
		return true;
	}
	
	public boolean removeFromSpot(ParkingSpot s) {
		parkingSpots.clear();
		s.removeVehicle(this);
		return true;
	}
	/*
	 * This method is abstract because each Vehicle type requires
	 * different kind of size. For simplicity, Car can fill one Car size,
	 * MotorCycle can fill one Motorcycle size
	 */
	public abstract boolean canFitInSpot(ParkingSpot spot);
	/*
	 * Two vehicle objects are equal if they are of the same type,
	 * like Car, Motorcycle and licenseplate is equal
	 * 
	 */
	public boolean equals (Object o) {
		
		if (o instanceof Vehicle) {
			if (o.getClass() == this.getClass()) {
			Vehicle v = (Vehicle)o;
			if (this.licensePlate == v.licensePlate)
				return true;
			}
			
		}
		return false;
		
	}
	  
	  

}
