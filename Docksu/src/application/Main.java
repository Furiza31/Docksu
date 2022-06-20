package application;
	
import java.io.IOException;

import application.view.AccueilController;
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
		afficherAccueil(primaryStage);
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
	
	public Workspace getWorkspace() {
		return this.workspace;
	}
	
	private void afficherAccueil(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/Accueil.fxml"));
			
			BorderPane body = loader.load();
			AccueilController ctrl = loader.getController();
			ctrl.setMain(this);
			
			Scene scene = new Scene(body);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Accueil");
			primaryStage.show();
		} catch (IOException e) {
			System.out.println("Accueil.fxml non disponible");
			System.exit(1);
		}
		
	}
}
