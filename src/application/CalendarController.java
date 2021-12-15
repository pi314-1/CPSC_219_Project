package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;
//import jdk.internal.jimage.ImageReader.Node;
import javafx.scene.layout.GridPane;

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
    private void initialize() {
    	
    // This initializes the dropdown menus
    String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    String[] hours = {"8:00", "9:00", "10:00", "11:00", "12:00", "1:00", "2:00", "3:00", "4:00", "5:00"};
    dayChoiceBox.setItems(FXCollections.observableArrayList(daysOfWeek));
    timeChoiceBox.setItems(FXCollections.observableArrayList(hours));
  
    interactChoiceBox(dayChoiceBox);
    interactChoiceBox(timeChoiceBox);
  
}
    
    /**
     * This method allows the user to interact with the choiceboxes
     * @param aChoiceBox
     */
    private void interactChoiceBox(ChoiceBox<String> aChoiceBox) {
    	aChoiceBox.getSelectionModel().selectedIndexProperty().addListener( 
   		     new ChangeListener<Number>() { 
   		          @Override 
   		          public void changed(ObservableValue observable, Number oldValue, Number newValue) { 
   		               int index = newValue.intValue();  
   		               if (index >= 0) {
   		            	
   		            	   //Event newEvent = new Event();
   		               }
   		                    
   		          }
   		     }
   		);
    	
    }
    
    
    /**
     * Gets the column and row index of a user's click on the grid.
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
            System.out.printf("Mouse entered cell [%d, %d]%n", colIndex.intValue(), rowIndex.intValue());
        // https://stackoverflow.com/questions/39178981/accessing-the-column-and-row-index-of-gridpane-in-javafx-keeps-returning-null
    }
}