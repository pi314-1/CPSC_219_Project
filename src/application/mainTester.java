package application;
	
import java.io.FileInputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;


public class mainTester extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			TabPane root = new TabPane();
			
			FXMLLoader loader = new FXMLLoader();
			root = (TabPane)loader.load(new 
					FileInputStream("src/view/CalendarInterface.fxml"));
			Scene scene = new Scene(root,600,600);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
