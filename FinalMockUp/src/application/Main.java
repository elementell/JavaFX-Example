package application;
	
import java.sql.Connection;
import java.sql.DriverManager;

import controller.MainController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/main.fxml"));
			Parent root = loader.load();
		    
	        Scene scene = new Scene(root, 600, 400);
	    
	        stage.setTitle("UNG Newsletter Registration");
	        stage.setScene(scene);
	        stage.show();
	        
	        ((MainController)loader.getController()).setStage(stage);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
