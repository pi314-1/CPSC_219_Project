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
		int index = 0;
		int counter = 0;
		boolean isDuplicate = false;
		for (Task findTask : tasks) {
			
			if (findTask.getDayInt() == aTask.getDayInt() && findTask.getTimeInt() == aTask.getTimeInt()) {
				System.out.print(aTask.toString()+"here***************************");
				index = counter;
				isDuplicate = true;
			}
			counter++;
		}
		if (isDuplicate){
			tasks.remove(index);
		}
		tasks.add(aTask);
	}

	/**
	 * Deletes an event from the list.
	 * 
	 * needs to be modified so that it works lol 
	 * 
	 * @param aDayInt 
	 * @param aTimeInt 
	 * 
	 * @param the day and time ints of the task to remove
	 */
	public void removeTask(int aDayInt, int aTimeInt) {
		for (Task aTask : tasks) {
			if (aTask.getDayInt() == aDayInt && aTask.getTimeInt() == aTimeInt) {
				tasks.remove(aTask);
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
			}
		}
		return null;
	}

}
