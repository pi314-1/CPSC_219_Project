package model;

public class DueDate extends Event {
	private DayAndTime deadline = new DayAndTime();

	DueDate(String aName, String aSubject, int aPriorityLevel, String aDescription, DayAndTime aDate) {
		super(aName, aSubject, aPriorityLevel, aDescription);
		this.setDeadline(aDate);
	}

	public DayAndTime getDeadline() {
		return new DayAndTime(this.deadline);
	}

	public void setDeadline(DayAndTime aDeadline) {
		this.deadline = new DayAndTime(aDeadline);
	}

	public String toString() {
		// idk if this works, but basically we want to call the parent to string and add the time
		return super.toString() + "\nDeadline: " + this.getDeadline().toString();
	}
}
