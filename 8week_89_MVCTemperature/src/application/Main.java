package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	static TemperatureModel model;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("FarenheitGUI.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Farenheit");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		model = new TemperatureModel();
		launch(args);
	}
}
