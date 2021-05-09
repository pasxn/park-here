/*
 * 
 * EN20421380 [Perera R.P.S.]
 * en20421380@my.sliit.lk
 * SLIIT | EEE 2021 
 * 
 */


public class DateTime {
	
	private String date;
	private String time;
	
	public DateTime() {
		//using java.time package to access the time and date from the operating system
		this.date = java.time.LocalDate.now().toString();
		this.time = java.time.LocalTime.now().toString().split("\\.", 2)[0];
		//using split method from java.lang.Sring class to slice out the unwanted parts of the String
	}
	
	public String getDate() {
		return date;
	}
	
	public String getTime() {
		return time;
	}
}
