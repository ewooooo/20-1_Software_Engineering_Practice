package Model;

import Controller.LoginController;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;

public class LoginGUI extends Application {
	private static LoginGUI login;
	private static LoginController LoginCon;
	Pane p;

	public void init() throws Exception {
		// TODO Auto-generated method stub
		FXMLLoader fxmlLoader = new FXMLLoader();

		p = fxmlLoader.load(getInstance().getClass().getResource("..//View//Login.fxml").openStream());

		super.init();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		init();
		primaryStage.setScene(new Scene(p));
		primaryStage.setTitle("login");
		primaryStage.setResizable(false);
		primaryStage.show();

	}

	public static LoginGUI getInstance() {
		if (login == null) {
			login = new LoginGUI();
		}
		return login;
	}

	public static LoginController getEnvViewCon() {
		return LoginCon;
	}

	@Override
	public void stop() throws Exception {
		// TODO Auto-generated method stub System.exit(0);
		super.stop();
	}


	public static void main(String[] args) {
		launch(args);
	}
}
