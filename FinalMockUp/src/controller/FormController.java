package controller;
	
import java.sql.Connection;
import java.sql.DriverManager;

import application.Main;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.DBHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;


public class FormController {
	Stage stage;
	
	@FXML private TextField fname;
	@FXML private TextField lname;
	@FXML private TextField email;
	
	public FormController() {}
	public void setStage (Stage s) {
		stage = s;
	}
	@FXML protected void handleSubmit(ActionEvent event) {
		if (fname.getText().length() > 0 && lname.getText().length() > 0 && email.getText().length() > 0) {
			try {
				DBHandler dbconn = new DBHandler("jdbc:mysql://localhost/","newsletter","username","password");
				dbconn.insertIntoDB(fname.getText(), lname.getText(), email.getText());
				
				Parent root = FXMLLoader.load(getClass().getResource("/view/thanks.fxml"));
			    
		        Scene scene = new Scene(root, 600, 400);
		    
		        stage.setTitle("UNG Newsletter Registration");
		        stage.setScene(scene);
		        stage.show();
			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			System.out.println("You have to put something in the text fields doofus");
		}
    }
}
