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

	@FXML
	private TextField taskNameTextField;

	@FXML
	private TextField taskDescTextField;

	@FXML
	private Button addTaskButton;

	@FXML
	private void initialize() {
	
	    // This initializes the drop-down menus
	    String[] daysOfWeek = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
	    String[] hours = { "8:00", "9:00", "10:00", "11:00", "12:00", "1:00", "2:00", "3:00", "4:00", "5:00" };
	    dayChoiceBox.setItems(FXCollections.observableArrayList(daysOfWeek));
	    timeChoiceBox.setItems(FXCollections.observableArrayList(hours));
	
	
	    //disables add event button on initialization until text fields have value
	    addTaskButton.setDisable(true);
	
	}
	// The list of tasks to be added to and displayed.
	private TaskList addedTasks = new TaskList();

	/**
	 * Gets the column and row index of a user's click on the grid and displays the
	 * clicked task if it exists.
	 * 
	 * @param <Node>
	 * @param event
	 */
	public void clickGrid(javafx.scene.input.MouseEvent event) {

		Node target = (Node) event.getTarget();
		try {
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
				taskFocusLabel.setText("No task selected");
			else {
				try {

					if (addedTasks.getByDayTime(colIndex.intValue(), rowIndex.intValue()) != null) {
						focusTask(addedTasks.getByDayTime(colIndex.intValue(), rowIndex.intValue()));
					} else {
						taskFocusLabel.setText("No task selected");
					}

				} catch (Exception e) {
				}
				// https://stackoverflow.com/questions/39178981/accessing-the-column-and-row-index-of-gridpane-in-javafx-keeps-returning-null
			}
		} catch (Exception e) {
		}
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
			taskFocusLabel.setText("Select a task");
		}
	}
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
        Task aTask = new Task(dayChoiceBox.getSelectionModel().selectedIndexProperty().intValue()+1,
        		timeChoiceBox.getSelectionModel().selectedIndexProperty().intValue()+1);
        aTask.setName(taskNameTextField.getText());
        aTask.setDescription(taskDescTextField.getText());
        
        addedTasks.addTask(aTask);
        
        clearAllUserInput();
        addTaskButton.setDisable(true);
        displayTasksToGrid(addedTasks);
       
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