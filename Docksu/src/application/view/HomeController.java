package application.view;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;

public class HomeController implements Initializable {
	
	private Main main;
	
	@FXML
	TextField searchBar;
	
	@FXML
	Button newFile;
	
	@FXML
	Button newFolder;
	
	@FXML
	TreeView<String> treeView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		newFile.setOnAction(event -> newFile());
		newFolder.setOnAction(event -> newFolder());
	}

	private void newFolder() {
		System.out.println("New folder");
	}

	private void newFile() {
		System.out.println("New File");
	}

	/**
	 * Setter main
	 * @param pfMain
	 */
	public void setMain(Main pfMain) {
		this.main = pfMain;
	}

}
