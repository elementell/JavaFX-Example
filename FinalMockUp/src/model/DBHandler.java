package model;
	
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import application.Main;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class DBHandler {
	Connection conn;
	public DBHandler(String CONN, String DB, String USERNAME, String PASSWORD) {
		try {
			conn = DriverManager.getConnection((CONN + DB), USERNAME, PASSWORD);
		} catch (Exception e) {
			System.out.print(e);
		}
	}
	
	public void insertIntoDB(String fName, String lName, String email) {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			String sql = "INSERT INTO register VALUES ('"+fName+"', '"+lName+"', '"+email+"')";
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.print(e);
		}
		
	}
}
