
public class MotorCycle extends Vehicle {
	public MotorCycle(String licensePlate, String Company){
		//Motorcycle needs one motor spot
        spotsNeeded = 1;
        size = VehicleSize.Car;
        this.licensePlate = licensePlate;
        
    }

    public boolean canFitInSpot(ParkingSpot spot){
        //checks if the spot is for a car
        return spot.getSize() == VehicleSize.MotorCycle;
    }


}
