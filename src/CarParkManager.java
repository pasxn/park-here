/*
 * 
 * EN20421380 [Perera R.P.S.]
 * en20421380@my.sliit.lk
 * SLIIT | EEE 2021 
 * 
 */


public interface CarParkManager {
	
	 final int totalVehicleSlots = 20;
	 
	 boolean vehicleEntered();
	 int vehicleLeft();
	 int getNumEmptySlots();
	 int getNumOccupiedSlots();
	 
}
