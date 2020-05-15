package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
	@FXML
	private Label statusLable;
	@FXML
	private TextField userNameTextField;
	@FXML
	private TextField passwordField;

	public void handleLogin(ActionEvent event) throws Exception {
		if (userNameTextField.getText().equals("user") && passwordField.getText().equals("pass")) {
			statusLable.setText("Login Success");
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("LoggedIn.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} else {
			statusLable.setText("Login Failed");
		}
	}
}