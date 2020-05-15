package application;



import java.util.Observable;
import java.util.Observer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class FarenheitGUIController implements Observer {
	@FXML
	private TextField temperatureField;
	
	private TemperatureModel model;
	
	public FarenheitGUIController() throws Exception {
		this.model = Main.model;
		model.addObserver(this);
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("CelsiusGUI.fxml"));
		primaryStage.setTitle("Celsius");
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	@Override
	public void update(Observable t, Object o) {
		temperatureField.setText(""+model.getF());
	}
	public void handleRaise(ActionEvent event) throws Exception{
		model.setF(model.getF()+1.0);
	}
	public void handleLower(ActionEvent event) throws Exception{

		model.setF(model.getF()-1.0);
	}

	
}
