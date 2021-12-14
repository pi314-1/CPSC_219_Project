package model;
/**
 * 
 * @author Sebastian
 * @version 1.0
 * @since 2021/12/07
 *
 */
public class Session extends Task {

	private DayAndTime startTime;
	private DayAndTime endTime;
	private String location;
	private String sessionType;

	Session(String aName, String aSubject, int aPriorityLevel, String aDescription, DayAndTime aStartTime,
			DayAndTime anEndTime, String aLocation, String aSessionType) {

		super(aName, aSubject, aPriorityLevel, aDescription);
		startTime = aStartTime;
		endTime = anEndTime;
		location = aLocation;
		sessionType = aSessionType;
	}

	/**
	 * Getter method for the start time
	 * 
	 * @return startTime
	 */
	public DayAndTime getStartTime() {
		return startTime;
	}

	/**
	 * Getter method for the end time
	 * 
	 * @return endTime
	 */
	public DayAndTime getEndTime() {
		return endTime;
	}

	/**
	 * Getter method for the location
	 * 
	 * @return location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Getter method for the type of session
	 * 
	 * @return sessionType
	 */
	public String getSessionType() {
		return sessionType;
	}

	/**
	 * Setter method for the start time
	 * 
	 * @param aStartTime
	 */
	public void setStartime(DayAndTime aStartTime) {
		startTime = aStartTime;
	}

	/**
	 * Setter method for the end time
	 * 
	 * @param anEndTime
	 */
	public void setEndtime(DayAndTime anEndTime) {
		endTime = anEndTime;
	}

	/**
	 * Setter method for the location
	 * 
	 * @param aLocation
	 */
	public void setLocation(String aLocation) {
		location = aLocation;
	}

	/**
	 * Setter method for the type of session
	 * 
	 * @param aSessionType
	 */
	public void setSessionType(String aSessionType) {
		sessionType = aSessionType;
	}
}