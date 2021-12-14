package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;

public class CalendarController {

    @FXML
    private ChoiceBox<String> mondayChoiceBox;

    @FXML
    private ChoiceBox<String> sundayChoiceBox;

    @FXML
    private Tab displayEventTab;

    @FXML
    private Tab addEventTab;

    @FXML
    private void initialize() {
    	
    // This initializes the dropdown menus to display the time of day
    String[] times = {"8:00", "9:00", "10:00", "11:00", "12:00", "1:00", "2:00", "3:00", "4:00", "5:00"};
    sundayChoiceBox.setItems(FXCollections.observableArrayList(times));
    mondayChoiceBox.setItems(FXCollections.observableArrayList(times));
  
    
    sundayChoiceBox.getSelectionModel().selectedIndexProperty().addListener( 
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
}