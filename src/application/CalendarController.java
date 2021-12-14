package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;
//import jdk.internal.jimage.ImageReader.Node;

public class CalendarController<GridPane> {


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
     * this method should allow the user to click a grid on the display and the event details will show up in a text dialog below
     * @param <Node>
     * @param event
     */
    public <Node> void clickGrid(javafx.scene.input.MouseEvent event) {
        Node source = (Node)event.getSource() ;
//        Integer colIndex = taskGrid.getColumnIndex(source);
//        Integer rowIndex = taskGrid.getRowIndex(source);
//        System.out.println("Mouse clicked cell: " + colIndex + "And: " + rowIndex);
        System.out.println("Mouse clicked cell: ");

    }
}