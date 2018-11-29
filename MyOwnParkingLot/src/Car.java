
public class Car extends Vehicle {
	public Car(String licensePlate, String Company){
		// Car needs one CarSpt
        spotsNeeded = 1;
        size = VehicleSize.Car;
        this.licensePlate = licensePlate;
        
    }

    public boolean canFitInSpot(ParkingSpot spot){
        //checks if the spot is for a car
        return spot.getSize() == VehicleSize.Car;
    }

}
