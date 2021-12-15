package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
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

	// random tasks to test stuff**************************************************

	public Task task1 = new Task(2, 2);
	public Task task2 = new Task(2, 3);
	public Task task3 = new Task(5, 4);

//	@FXML
//	private void initialize() {
//
//		// This initializes the dropdown menus
//		String[] daysOfWeek = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
//		String[] hours = { "8:00", "9:00", "10:00", "11:00", "12:00", "1:00", "2:00", "3:00", "4:00", "5:00" };
//		dayChoiceBox.setItems(FXCollections.observableArrayList(daysOfWeek));
//		timeChoiceBox.setItems(FXCollections.observableArrayList(hours));
//
//		interactChoiceBox(dayChoiceBox);
//		interactChoiceBox(timeChoiceBox);
//
//		addedTasks.addTask(task1);
//		addedTasks.addTask(task2);
//		addedTasks.addTask(task3);
//		addedTasks.addTask(new Task(6, 3));
//		addedTasks.addTask(new Task(1, 1));
//		displayTasksToGrid(addedTasks);
//
//	}
//
//	/**
//	 * This method allows the user to interact with the choiceboxes
//	 * 
//	 * @param aChoiceBox
//	 */
//	private void interactChoiceBox(ChoiceBox<String> aChoiceBox) {
//		aChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
//			@Override
//			public void changed(ObservableValue observable, Number oldValue, Number newValue) {
//				int index = newValue.intValue();
//				if (index >= 0) {
//
//					// Event newEvent = new Event();
//				}
//
//			}
//		});
//
//	}
//
//	public void addTask(Task aTask) {
//		addedTasks.addTask(aTask);
//	}

	/**
	 * Gets the column and row index of a user's click on the grid and displays the
	 * clicked task if it exists.
	 * 
	 * @param <Node>
	 * @param event
	 */
	public void clickGrid(javafx.scene.input.MouseEvent event) {

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

				if (addedTasks.getByDayTime(colIndex.intValue(), rowIndex.intValue()) != null) {
					System.out.printf(addedTasks.getByDayTime(colIndex.intValue(), rowIndex.intValue()).toString());
					focusTask(addedTasks.getByDayTime(colIndex.intValue(), rowIndex.intValue()));
				} else {
					System.out.printf("No Task at [%d, %d]%n", colIndex.intValue(), rowIndex.intValue());
				}

			} catch (Exception e) {
				System.out.printf("Task at [%d, %d]%n", colIndex.intValue(), rowIndex.intValue());
				System.out.print("no task here");
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
	@FXML
    private TextField taskNameTextField;

    @FXML
    private TextField taskDescTextField;

    @FXML
    private Button addTaskButton;
@FXML
    private void initialize() {

        // This initializes the dropdown menus
        String[] daysOfWeek = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
        String[] hours = { "8:00", "9:00", "10:00", "11:00", "12:00", "1:00", "2:00", "3:00", "4:00", "5:00" };
        dayChoiceBox.setItems(FXCollections.observableArrayList(daysOfWeek));
        timeChoiceBox.setItems(FXCollections.observableArrayList(hours));

        addedTasks.addTask(task1);
		addedTasks.addTask(task2);
		addedTasks.addTask(task3);
		addedTasks.addTask(new Task(6, 3));
		addedTasks.addTask(new Task(1, 1));
		displayTasksToGrid(addedTasks);
        //disables add event button on initialization until textfields have value
        addTaskButton.setDisable(true);

    }
/*Checks for if user input has been added to TextFields, and does not allow user
     * to add task to grid with the addTaskButton if there is no user input in either
     * field.
     * From: https://www.youtube.com/watch?v=oo8G4QfgPSI
     */

    public void TextFieldsHaveValue(KeyEvent event) {
        String taskName = taskNameTextField.getText();
        String taskDesc = taskDescTextField.getText();
        boolean isDisabled = taskName.trim().isEmpty() || taskDesc.trim().isEmpty();
        addTaskButton.setDisable(isDisabled);
    }

//    /
//     * when the addTaskButton is clicked, a new task is created with the current
//     * inputs in textFields and ChoiceBoxes and the task is added to the Tasks Grid.
//     * User input is then cleared.
//     /
    public void addTaskButtonClicked() {
        Task task = new Task(dayChoiceBox.getSelectionModel().selectedIndexProperty().intValue()+1,
                timeChoiceBox.getSelectionModel().selectedIndexProperty().intValue());
        task.setName(taskNameTextField.getText());
        task.setDescription(taskDescTextField.getText());
        addedTasks.addTask(task);
        System.out.println(task.toString());
        clearAllUserInput();
    }

//    /
//     * removes any ChoiceBox selections and sets textFields to blank text.
//     */
    public void clearAllUserInput() {
        taskNameTextField.setText("");
        taskDescTextField.setText("");
        dayChoiceBox.getSelectionModel().clearSelection();
        timeChoiceBox.getSelectionModel().clearSelection();
    }

}