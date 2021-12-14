package model;

import java.util.ArrayList;

public class TaskList {
	private ArrayList<Task> tasks = new ArrayList<Task>();
	private ArrayList<Task> eventsToDisplay = new ArrayList<Task>();

	/**
	 * Adds a new event to the list.
	 * 
	 * @param anEvent The new event to be added.
	 */
	public void addEvent(Task anEvent) {
		tasks.add(anEvent);
	}

	/**
	 * Deletes an event from the list.
	 * 
	 * @param eventName The name of the event to delete.
	 */
	public void removeEvent(String eventName) {
		for (Task e : tasks) {
			if (e.getName().equals(eventName)) {
				tasks.remove(e);
			}
		}
	}

	/**
	 * See how many events are scheduled.
	 * 
	 * @return The total number of events scheduled.
	 */
	public int getNumberOfEvents() {
		return tasks.size();
	}

	/**
	 * Sets the eventsToDisplay to have each event in the events list
	 */
	public void resetEventsToDisplay() {
		// updates events to display with a shallow copy of events
		eventsToDisplay = (ArrayList<Task>) tasks.clone();
	}

//	/**
//	 * 
//	 * @param filterField
//	 * @param filterValue
//	 */
//	public void filterDisplayedEvents(String filterField, String filterValue) {
//		if (eventsToDisplay.size() == 0)
//			resetEventsToDisplay();
//
//		// maybe should change the nesting to have the for loops outside
//		switch (filterField) {
//		case "subject":
//			for (ToDo eachEvent : eventsToDisplay) {
//				if (!eachEvent.getSubject().equals(filterValue))
//					removeEvent(eachEvent.getName());
//			}
//			break;
//		case "priorityLevel":
//			for (ToDo eachEvent : eventsToDisplay) {
//				if (!(eachEvent.getPriorityLevel() == Integer.parseInt(filterValue)))
//					removeEvent(eachEvent.getName());
//			}
//			break;
//		case "weekday": // idk what im doing
//			for (ToDo eachEvent : eventsToDisplay) {
//				/*
//				 * try { if (eachEvent.getStartTime().getWeekday()); }
//				 */
//			}
//		}
//
//	}
}
