package model;

/**
 * Makes events which can be added to a user's to do list or calendar. Events
 * are geared towards students. This class is extended by the Session and
 * DueDate classes, which are used to create distinct types of events.
 * 
 * @author Sebastian
 * @version 1.0
 * @since 2021/12/07
 *
 */
public class Event {

	private String name = "New Event";
	private String subject = "Add a subject";
	private int priorityLevel = 1;
	private String description = "Add a description";

	/**
	 * Creates a new Event based on name, subject, priority level, and description.
	 * 
	 * @param aName
	 * @param aSubject
	 * @param aPriorityLevel
	 * @param aDescription
	 */
	public Event(String aName, String aSubject, int aPriorityLevel, String aDescription) {
		name = aName;
		subject = aSubject;
		priorityLevel = aPriorityLevel;
		description = aDescription;
	}

	/**
	 * Sets the name of the event.
	 * 
	 * @param aName
	 */
	public void setName(String aName) {
		name = aName;
	}

	/**
	 * Setter method for the subject.
	 * 
	 * @param aSubject
	 */
	public void setSubject(String aSubject) {
		subject = aSubject;
	}

	/**
	 * Setter method for the priority level.
	 * 
	 * @param aPriorityLevel
	 */
	public void setPriorityLevel(int aPriorityLevel) {

		// Check to ensure priority level is between 1-3
		if (aPriorityLevel > 0 && aPriorityLevel <= 3) {
			priorityLevel = aPriorityLevel;
		}
	}

	/**
	 * Setter method for the description.
	 * 
	 * @param aDescription
	 */
	public void setDescrtiption(String aDescription) {
		description = aDescription;
	}

	/**
	 * This getter method returns the name of the event.
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * This getter method returns the subject of the event.
	 * 
	 * @return subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * This getter method returns the priority level of the event.
	 * 
	 * @return priorityLevel
	 */
	public int getPriorityLevel() {
		return priorityLevel;
	}

	/**
	 * This getter method returns the description of the event.
	 * 
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	public String toString() {
		return (name + "\n\t" + "Subject: " + subject + "\n\t" + "Priority: " + priorityLevel + "\n\t" + "About: "
				+ description);
	}

}