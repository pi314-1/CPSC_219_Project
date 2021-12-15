package model;

import java.util.ArrayList;

public class TaskList {

	private ArrayList<Task> tasks = new ArrayList<Task>();

	/**
	 * Adds a new event to the list.
	 * 
	 * @param aTask The new event to be added.
	 */
	public void addTask(Task aTask) {
		tasks.add(aTask);
	}

	/**
	 * Deletes an event from the list.
	 * 
	 * @param taskToRemove The name of the event to delete.
	 */
	public void removeTask(String taskToRemove) {
		for (Task e : tasks) {
			if (e.getName().equals(taskToRemove)) {
				tasks.remove(e);
			}
		}
	}

	public Task[] toArray() {
		Task[] taskArray = tasks.toArray(new Task[0]);
		return taskArray;
	}

	/**
	 * See how many events are scheduled.
	 * 
	 * @return The total number of events scheduled.
	 */
	public int getNumberOfTasks() {
		return tasks.size();
	}

	/**
	 * This method returns a task as identified by its day and time ints.
	 * 
	 * @param index
	 * @return Task
	 */
	public Task getByDayTime(int aDayInt, int aTimeInt) {

		for (Task aTask : tasks) {
			if (aTask.getDayInt() == aDayInt && aTask.getTimeInt() == aTimeInt) {
				return aTask;
			} else {
				return null;

			}
		}
		return null;
	}

}
