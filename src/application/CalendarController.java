package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
//import jdk.internal.jimage.ImageReader.Node;
import javafx.scene.layout.GridPane;
import model.Task;
import model.TaskList;

public class CalendarController {

	@FXML
	private ChoiceBox<String> dayChoiceBox;

	@FXML
	private ChoiceBox<String> timeChoiceBox;

	@FXML
	private Tab displayEventTab;

	@FXML
	private Tab addEventTab;

	@FXML
	private GridPane taskGrid;

	@FXML
	private Label taskFocusLabel;

	// The list of tasks to be added to and displayed.
	public TaskList addedTasks = new TaskList();
	
	//random tasks to test stuff**************************************************
	
	public Task task1 = new Task(2,2);
	public Task task2 = new Task(2,3);
	public Task task3 = new Task(5,4);


	@FXML
	private void initialize() {

		// This initializes the dropdown menus
		String[] daysOfWeek = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
		String[] hours = { "8:00", "9:00", "10:00", "11:00", "12:00", "1:00", "2:00", "3:00", "4:00", "5:00" };
		dayChoiceBox.setItems(FXCollections.observableArrayList(daysOfWeek));
		timeChoiceBox.setItems(FXCollections.observableArrayList(hours));

		interactChoiceBox(dayChoiceBox);
		interactChoiceBox(timeChoiceBox);

	}

	/**
	 * This method allows the user to interact with the choiceboxes
	 * 
	 * @param aChoiceBox
	 */
	private void interactChoiceBox(ChoiceBox<String> aChoiceBox) {
		aChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue observable, Number oldValue, Number newValue) {
				int index = newValue.intValue();
				if (index >= 0) {

					// Event newEvent = new Event();
				}

			}
		});

	}

	public void addTask(Task aTask) {
		addedTasks.addTask(aTask);
	}

	/**
	 * Gets the column and row index of a user's click on the grid and displays the
	 * clicked task if it exists.
	 * 
	 * @param <Node>
	 * @param event
	 */
	public void clickGrid(javafx.scene.input.MouseEvent event) {
		
		addedTasks.addTask(task1);
		addedTasks.addTask(task2);
		addedTasks.addTask(task3);
		Node target = (Node) event.getTarget();
		// traverse towards root until taskGrid is the parent node
		if (target != taskGrid) {
			Node parent;
			while ((parent = target.getParent()) != taskGrid) {
				target = parent;
			}
		}
		Integer colIndex = taskGrid.getColumnIndex(target);
		Integer rowIndex = taskGrid.getRowIndex(target);
		if (colIndex == null && rowIndex == null)
			System.out.println("BOO");
		else
			
			try {
				String taskLabelText = ((Label) getNodeByRowColumnIndex(rowIndex, colIndex, taskGrid)).getText();
				Task[] taskArray = addedTasks.toArray();
				for (Task aTask : taskArray) {
					if (taskLabelText.equals(aTask.getName()))
						focusTask(aTask);
					System.out.printf(addedTasks.getByDayTime(colIndex.intValue(), rowIndex.intValue()).toString());
				}
			} catch (Exception e) {
				System.out.printf("No task at [%d, %d]%n", colIndex.intValue(), rowIndex.intValue());
			}
			// https://stackoverflow.com/questions/39178981/accessing-the-column-and-row-index-of-gridpane-in-javafx-keeps-returning-null
	}

	/**
	 * From:
	 * https://stackoverflow.com/questions/20825935/javafx-get-node-by-row-and-column
	 * Gets a node from a grid pane based on a specified row column index.
	 * 
	 * @param row
	 * @param column
	 * @param gridPane
	 * @return
	 */
	private Node getNodeByRowColumnIndex(final int row, final int column, GridPane gridPane) {
		Node result = null;
		ObservableList<Node> childrens = gridPane.getChildren();

		for (Node node : childrens) {
			if (gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
				result = node;
				break;
			}
		}

		return result;
	}

	/**
	 * Adds the name of a task to the grid as a label.
	 * 
	 * @param aTaskList The list to display on the grid.
	 */
	public void displayTasksToGrid(TaskList aTaskList) {
		Task[] taskListArray = aTaskList.toArray();
		for (Task aTask : aTaskList.toArray()) {
			taskGrid.add(new Label(aTask.getName()), aTask.getDayInt(), aTask.getTimeInt());
		}
	}

	/**
	 * Displays task info in the label below the grid.
	 * 
	 * @param aTask The task to display.
	 */
	public void focusTask(Task aTask) {
		try {
			taskFocusLabel.setText(aTask.toString());
		} catch (Exception e) {
			taskFocusLabel.setText("Select on a task");
		}
	}
}