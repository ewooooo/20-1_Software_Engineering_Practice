package application;

import javafx.event.ActionEvent;

public class LoggedInController {
	
	public void handleClose(ActionEvent event) throws Exception {
		System.out.println("Close button is presssed");
		System.exit(0);
	}
}