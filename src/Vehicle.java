/*
 * 
 * EN20421380 [Perera R.P.S.]
 * en20421380@my.sliit.lk
 * SLIIT | EEE 2021 
 * 
 */


public abstract class Vehicle {
	
	private String IDplate;
	private String brand;
	private DateTime inDateTime;
	
	public Vehicle(String IDplate, String brand) {
		this.IDplate = IDplate; 
		this.brand = brand;
		inDateTime = new DateTime();
	}
	
	public String getIDplate() {
		return IDplate;
	}
	
	public String getBrand() {
		return brand;
	}

	public DateTime getDateTime() {
		return inDateTime;
	}

	protected abstract String getColor();
	protected abstract int getnofDoors();
	protected abstract boolean getIscargo();
	protected abstract String isTaxi();
	protected abstract int getNofseats();
	protected abstract int getCargocapacity();
	
}
