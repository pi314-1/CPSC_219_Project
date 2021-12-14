package model;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

/**
 * Used to create instances of weekday and time of day. The default constructor
 * fetches the current time in the user's time-zone, or the can enter the day
 * and time desired.
 * 
 * @author gabe
 *
 */
public class DayAndTime {

	private static String[] WEEKDAYS = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday",
			"Saturday" };
	// time variables are private to ensure they are always set to valid amounts
	private int hour = 12;
	private int min = 0;

	private String dayOfWeek = WEEKDAYS[1];

	/**
	 * By default, the weekday and time will be based on the current weekday and
	 * time in the user's time-zone.
	 */
	public DayAndTime() {
		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DAY_OF_WEEK);
		String today = WEEKDAYS[day - 1];
		setDayOfWeek(today);

		LocalTime time = LocalTime.now();
		DateTimeFormatter hoursFormat = DateTimeFormatter.ofPattern("HH");
		int hours = Integer.parseInt(time.format(hoursFormat).toString());
		setHour(hours);

		DateTimeFormatter minsFormat = DateTimeFormatter.ofPattern("mm");
		int mins = Integer.parseInt(time.format(hoursFormat).toString());
		setMin(mins);
	}

	/**
	 * Copies a given day and time.
	 * 
	 * @param aDate The day and time to copy.
	 */
	public DayAndTime(DayAndTime aDate) {
		setDayOfWeek(aDate.getDayOfWeek());
		setHour(aDate.getHour());
		setMin(aDate.getMin());
	}

	/**
	 * Creates a new day and time by user input.
	 * 
	 * @param aDayOfWeek
	 * @param anHour
	 * @param aMin
	 */
	public DayAndTime(String aDayOfWeek, int anHour) {
		setDayOfWeek(aDayOfWeek);
		setHour(anHour);
	}

	public String getDayOfWeek() {
		return new String(this.dayOfWeek);
	}

	public void setDayOfWeek(String aDayOfWeek) {
		for (String day : WEEKDAYS) {
			if (aDayOfWeek.equalsIgnoreCase(day))
				this.dayOfWeek = day;
		}
	}

	public int getHour() {
		return this.hour;
	}

	public void setHour(int anHour) {
		if (anHour >= 0 && anHour < 24) {
			this.hour = anHour;
		} else {
			invalidInput(String.valueOf(anHour));
		}
	}

	public int getMin() {
		return this.min;
	}

	public void setMin(int aMin) {
		if (aMin >= 0 && aMin < 60) {
			this.min = aMin;
		} else {
			invalidInput(String.valueOf(aMin));
		}
	}

	/**
	 * Displays the day and time as a string based on a twelve hour clock.
	 */
	public String toString() {
		int twelveHour = this.hour;
		String amOrPm = "PM";
		String minString = min + "";

		// Converts from 24 to 12 hour.
		if (this.hour == 12) {
			amOrPm = "PM";
		} else if (this.hour == 0) {
			twelveHour = 12;
			amOrPm = "AM";
		} else if (this.hour > 12) {
			twelveHour -= 12;
			amOrPm = "PM";
		}

		// Adds a 0 in front of one-digit minute values.
		if (min < 10)
			minString = "0" + min;

		return this.dayOfWeek + ", " + twelveHour + ":" + minString + " " + amOrPm;
	}

	private void invalidInput(String inputEntered) {
		System.out.print('"' + inputEntered + '"' + " is not valid input.");
	}
}
