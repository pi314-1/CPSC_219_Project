package model;

public class DayAndTime {
	
	// time variables are private to ensure they are always set to valid amounts
	private int hour = 12;
	private int min = 0;

	private String dayOfWeek = "Monday";

	DayAndTime() {
		setDayOfWeek("Monday");
		setHour(12);
		setMin(0);	
	}
	
	DayAndTime(DayAndTime aDate) {
		setDayOfWeek(aDate.getDayOfWeek());
		setHour(aDate.getHour());
		setMin(aDate.getMin());	
	}
	
	DayAndTime(String aDayOfWeek, int anHour, int aMin) {
		setDayOfWeek(aDayOfWeek);
		setHour(anHour);
		setMin(aMin);
	}
	
	public String getDayOfWeek() {
		return new String(this.dayOfWeek);
	}
	
	public int getHour() {
		return this.hour;
	}
	
	public int getMin() {
		return this.min;
	}
	
	public String toString() {
		int twelveHour = this.hour;
		String amOrPm = "PM";
		if (this.hour == 12) {
			amOrPm = "PM";
		} else if (this.hour == 0) {
			twelveHour = 12;
			amOrPm = "AM";
		} else if (this.hour > 12) {
			twelveHour -= 12;
			amOrPm = "PM";
		}
		return this.dayOfWeek + ", " + twelveHour + ":" + this.min + " " + amOrPm;
	}
	
	public void setDayOfWeek(String aDayOfWeek) {
		// make this into a for loop
		if (aDayOfWeek.equalsIgnoreCase("Sunday") || aDayOfWeek.equalsIgnoreCase("Monday")
				|| aDayOfWeek.equalsIgnoreCase("Tuesday") || aDayOfWeek.equalsIgnoreCase("Wednesday")
				|| aDayOfWeek.equalsIgnoreCase("Thursday") || aDayOfWeek.equalsIgnoreCase("Friday")
				|| aDayOfWeek.equalsIgnoreCase("Saturday")) {

			this.dayOfWeek = aDayOfWeek.substring(0, 1).toUpperCase() + aDayOfWeek.substring(1).toLowerCase();
			// may need to adjust for privacy leaks??
			// from:
			// https://stackoverflow.com/questions/3904579/how-to-capitalize-the-first-letter-of-a-string-in-java
		} else {
			invalidInput(String.valueOf(aDayOfWeek));
		}
	}
	
	public void setHour(int anHour) {
		if (anHour >= 0 && anHour < 24) {
			this.hour = anHour;
		} else {
			invalidInput(String.valueOf(anHour));
		}
	}
	
	public void setMin(int aMin) {
		if (aMin >= 0 && aMin < 60) {
			this.min = aMin;
		} else {
			invalidInput(String.valueOf(aMin));
		}
	}
	
	private void invalidInput(String inputEntered) {
		System.out.print('"' + inputEntered + '"' + " is not valid input.");
	}
}
