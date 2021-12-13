package model;
import java.util.ArrayList;

public class EventList {
	private ArrayList<Event> events = new ArrayList<Event>();
	private static DayAndTime currentTime = new DayAndTime("Monday",0,0); // now calc should be put into the DayAndTime class
	private ArrayList<Event> eventsToDisplay = new ArrayList<Event>();
	
	/**
	 * Adds a new event to the list.
	 * @param anEvent The new event to be added.
	 */
	public void addEvent(Event anEvent) {
		events.add(anEvent);
	}
	
	/**
	 * Deletes an event from the list.
	 * @param eventName The name of the event to delete.
	 */
	public void removeEvent(String eventName) {
		for (Event e : events) {
			if (e.getName().equals(eventName)) {
				events.remove(e);
			}
		}
	}
	
	/**
	 * See how many events are scheduled.
	 * @return The total number of events scheduled.
	 */
	public int getNumberOfEvents() {
		return events.size();
	}
	
	/**
	 * Sets the eventsToDisplay to have each event in the events list
	 */
	public void resetEventsToDisplay() {
		// updates events to display with a shallow copy of events
		eventsToDisplay = (ArrayList<Event>) events.clone();
	}
	
	/**
	 * 
	 * @param filterField
	 * @param filterValue
	 */
	public void filterDisplayedEvents(String filterField, String filterValue) {
		if (eventsToDisplay.size() == 0) resetEventsToDisplay();
			
		// maybe should change the nesting to have the for loops outside
		switch(filterField) {
			case "subject":
				for (Event eachEvent : eventsToDisplay) {
					if (!eachEvent.getSubject().equals(filterValue)) removeEvent(eachEvent.getName());
				}
				break;
			case "priorityLevel":
				for (Event eachEvent : eventsToDisplay) {
					if (!(eachEvent.getPriorityLevel() == Integer.parseInt(filterValue))) removeEvent(eachEvent.getName());
				}
				break;
			case "weekday": // idk what im doing
				for (Event eachEvent : eventsToDisplay) {
				/*	try {
						if (eachEvent.getStartTime().getWeekday());
					}*/
				}
			}
			
	}
}
