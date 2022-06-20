package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	private Workspace workspace;
	
	@Override
	public void start(Stage primaryStage) {
		System.out.println("Start");
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void stop() throws Exception {
		System.out.println("Stop");
	}
	
	@Override
	public void init() throws Exception {
		System.out.println("Init");
		this.workspace = new Workspace();
	}
}
