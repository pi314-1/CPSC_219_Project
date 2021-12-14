module CPSC_219_ProjectInterface {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	
	opens application to javafx.graphics, javafx.fxml;
}
