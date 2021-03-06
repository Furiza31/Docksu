package application;
	
import java.io.IOException;

import application.view.HomeController;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	private Workspace workspace;
	private Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) {
		System.out.println("Start");
		this.workspace = new Workspace(this);
		this.primaryStage = primaryStage;
		showHome();
	}

	/**
	 * Main
	 * @param args
	 */
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
	}
	
	/**
	 * Getter workspace
	 * @return workspace
	 */
	public Workspace getWorkspace() {
		return this.workspace;
	}
	
	/**
	 * Getter primaryStage
	 * @return primaryStage
	 */
	public Stage getPrimaryStage() {
		return this.primaryStage;
	}
	
	/**
	 * Show error
	 * @param title
	 * @param content
	 */
	public void error (String title, String content) {
		Alert box = new Alert(AlertType.ERROR);
		box.setTitle(title);
		box.setContentText(content);
		box.showAndWait();
	}
	
	/**
	 * Show the home page
	 */
	public void showHome() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/Home.fxml"));
			
			BorderPane body = loader.load();
			HomeController ctrl = loader.getController();
			ctrl.setMain(this);
			ctrl.showWorkspace();
			
			Scene scene = new Scene(body);
			this.primaryStage.setScene(scene);
			this.primaryStage.setTitle("Accueil");
			this.primaryStage.show();
		} catch (IOException e) {
			this.error("Chargement de la vue", "Ressource \"Home.fxml\" non disponible");
			System.out.println(e);
			System.exit(1);
		}
	}
}
