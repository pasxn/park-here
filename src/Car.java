/*
 * 
 * EN20421380 [Perera R.P.S.]
 * en20421380@my.sliit.lk
 * SLIIT | EEE 2021 
 * 
 */


public class Car extends Vehicle{
	
	private int nofDoors;
	private String color;

	public Car(String IDplate, String brand, int nofDoors, String color) {
		super(IDplate, brand);
		this.nofDoors = nofDoors;
		this.color = color;
	}
	
	public int getnofDoors(){
		return nofDoors;
	}
	
	public String getColor() {
		return color;
	}

	protected boolean getIscargo() {
		return false;
	}

	protected String isTaxi() {
		return null;
	}

	protected int getNofseats() {
		return 0;
	}

	protected int getCargocapacity() {
		return 0;
	}

}
