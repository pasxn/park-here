/*
 * 
 * EN20421380 [Perera R.P.S.]
 * en20421380@my.sliit.lk
 * SLIIT | EEE 2021 
 * 
 */


public class Van extends Vehicle{

	private int nofSeats;
	private int cargoCapacity;
	private boolean isCargo;
	
	public Van(String IDplate, String brand, int nofSeats, int cargoCapacity, boolean isCargo) {
		super(IDplate, brand);
		this.nofSeats = nofSeats;
		this.cargoCapacity = cargoCapacity;
		this.isCargo = isCargo;
	}
	
	public int getNofseats() {
		return nofSeats;
	}
	
	public int getCargocapacity() {
		return cargoCapacity;
	}
	
	public boolean getIscargo() {
		return isCargo;
	}

	protected String getColor() {
		return null;
	}

	protected int getnofDoors() {
		return 0;
	}


	protected String isTaxi() {
		return null;
	}
	
}
