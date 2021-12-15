package model;

/**
 * Makes events which can be added to a user's to do list or calendar. Events
 * are geared towards students. 
 * 
 * @author Sebastian
 * @version 2.0
 * @since 2021/12/07
 *
 */
public class Task {

	private String name = "New Task";
	private String description = "Add a description";
	private int timeInt;
	private int dayInt;

	/**
	 * Creates a new Event based on the day and time,
	 * the name and the description need to be set separately
	 * 
	 * @param aTime
	 * @param aDay
	 */
	public Task(int aDay, int aTime) {
		dayInt = aDay;
		timeInt = aTime;
	}

	/**
	 * Sets the name of the task.
	 * 
	 * @param aName
	 */
	public void setName(String aName) {
		name = aName;
	}
	/**
	 * Setter method for the description.
	 * 
	 * @param aDescription
	 */
	public void setDescription(String aDescription) {
		description = aDescription;
	}

	/**
	 * This getter method returns the name of the task.
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}


	/**
	 * This getter method returns the time of the task.
	 * 
	 * @return priorityLevel
	 */
	public int getTimeInt() {
		return timeInt;
	}

	/**
	 * This getter method returns the description of the task.
	 * 
	 * @return description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * This getter method returns the day of the task.
	 * 
	 * @return priorityLevel
	 */
	public int getDayInt() {
		return dayInt;
	}

	/**
	 * a toString method for displaying the task
	 * @return String
	 */
	public String toString() {
		return (name + ":" + "\n\t" + "Day: " + dayToString(dayInt) + "\n\t" + "Time:  " + timeToString(timeInt) + "\n\t" + "About: "
				+ description + "\n");
	}
	
	/**
	 * This method converts dayInt into a day of the week
	 * @param aTask
	 * @return String
	 */
	public String dayToString(int aDayInt) {
		String[] daysOfWeek = {"", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		
		return daysOfWeek[aDayInt];
	}
	
	/**
	 * this method takes the timeInt and converts it into a time from 9:00-5:00.
	 * @param aTimeInt
	 * @return
	 */
	public String timeToString(int aTimeInt) {
		String [] timesOfDay = { "8:00", "9:00", "10:00", "11:00", "12:00", "1:00", "2:00", "3:00", "4:00", "5:00"};
		return timesOfDay[aTimeInt];
	}

}