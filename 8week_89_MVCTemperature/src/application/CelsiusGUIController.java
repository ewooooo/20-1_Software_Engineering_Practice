package application;



import java.util.Observable;
import java.util.Observer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CelsiusGUIController implements Observer{

	@FXML
	private TextField temperatureField;
	
	private TemperatureModel model;
	
	public CelsiusGUIController() {
		this.model = Main.model;
		model.addObserver(this);
	}

	@Override
	public void update(Observable t, Object o) {
		temperatureField.setText(""+model.getC());
	}
	
	public void handleRaise(ActionEvent event) throws Exception{
		model.setC(model.getC()+1.0);
	}
	public void handleLower(ActionEvent event) throws Exception{
		model.setC(model.getC()-1.0);
	}

}
