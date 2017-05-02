package controller;
	
import java.sql.Connection;
import java.sql.DriverManager;

import application.Main;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class MainController {
	Stage stage;
	public MainController() {}
	public void setStage (Stage s) {
		stage = s;
	}
	@FXML protected void handleStart(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/form.fxml"));
			Parent root = loader.load();
		    
	        Scene scene = new Scene(root, 600, 400);
	    
	        stage.setTitle("UNG Newsletter Registration");
	        stage.setScene(scene);
	        stage.show();
	        
	        ((FormController)loader.getController()).setStage(stage);
		} catch (Exception e) {
			System.out.println(e);
		}
    }
}
