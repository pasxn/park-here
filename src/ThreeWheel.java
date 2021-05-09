/*
 * 
 * EN20421380 [Perera R.P.S.]
 * en20421380@my.sliit.lk
 * SLIIT | EEE 2021 
 * 
 */


public class ThreeWheel extends Vehicle{

	private boolean isHire;
	
	public ThreeWheel(String IDplate, String brand, boolean isHire) {
		super(IDplate, brand);
		this.isHire = isHire;
	}
	
	public String isTaxi() {
		if (isHire == true) {
			return "This three wheeler is a taxi";
		}else {
			return "This three wheeler is not a taxi";
		}
	}

	protected String getColor() {
		return null;
	}

	protected int getnofDoors() {
		return 0;
	}

	protected boolean getIscargo() {
		return false;
	}

	protected int getNofseats() {
		return 0;
	}

	protected int getCargocapacity() {
		return 0;
	}
}
