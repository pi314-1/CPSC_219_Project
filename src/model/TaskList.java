package model;

import java.util.ArrayList;

/**
 * Stores Tasks into an arrayList, and allows for tasks to be found from the list by their day and time
 * 
 * @author gabe, seb
 * @version 2.0
 * @since 2021/12/07
 */
public class TaskList {

	private ArrayList<Task> tasks = new ArrayList<Task>();

	/**
	 * Adds a new event to the list, and removes any tasks that occur at the same time
	 * 
	 * @param aTask The new event to be added.
	 */
	public void addTask(Task aTask) {
		int index = 0;
		int counter = 0;
		boolean isDuplicate = false;
		
		//this loop checks whether there are any tasks at the same time as the given task
		for (Task findTask : tasks) {
			if (findTask.getDayInt() == aTask.getDayInt() && findTask.getTimeInt() == aTask.getTimeInt()) {
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
	 * converts the task arrayList to an array
	 * @return Task[]
	 */
	public Task[] toArray() {
		Task[] taskArray = tasks.toArray(new Task[0]);
		return taskArray;
	}


	/**
	 * This method returns a task, as identified by its day and time ints.
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
