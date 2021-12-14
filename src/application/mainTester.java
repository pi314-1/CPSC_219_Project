package application;

import model.Task;
import model.TaskList;
public class mainTester {

	public static void main(String[] args) {
		
		Task aTask = new Task(1, 3);
		Task aTask2 = new Task (2, 3);
		
		aTask.setDescrtiption("this project sucks");
		aTask.setName("a project");
		System.out.print(aTask.toString() + "\n");
	
		TaskList aList = new TaskList();
		
		aList.addTask(aTask);
		aList.addTask(aTask2);
		System.out.print(aList.getByDayTime(0, 0));
		System.out.print(aList.getByDayTime(1, 3));
		
	}
}
