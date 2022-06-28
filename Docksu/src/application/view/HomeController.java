package application.view;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;

public class HomeController implements Initializable {

	private Main main;
	private TreeView<File> treeView;

	@FXML
	private TextField textField;

	@FXML
	private Button newFile;

	@FXML
	private Button newFolder;

	@FXML
	private BorderPane body;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		newFile.setOnAction(event -> newFile());
		newFolder.setOnAction(event -> newFolder());
		textField.textProperty().addListener((observable, oldValue, newValue) -> searchBar(newValue));
	}

	private void searchBar(String research) {
		System.out.println(research);
	}

	private void newFolder() {
		System.out.println("New folder");
	}

	/**
	 * Create a new File in the selected folder
	 * If file is selected, the parent folder will be selected
	 * If nothing is selected, the workspace folder will be selected
	 */
	private void newFile() {
		File f;
		if (!this.textField.getText().isEmpty()) {
			if (!Objects.isNull(this.treeView.getSelectionModel().getSelectedItem())) {
				if (this.treeView.getSelectionModel().getSelectedItem().getValue().isDirectory()) {
					f = new File(this.treeView.getSelectionModel().getSelectedItem().getValue().getPath() + "\\"
							+ this.textField.getText());
				} else {
					f = new File(this.treeView.getSelectionModel().getSelectedItem().getValue().getParent() + "\\"
							+ this.textField.getText());
				}
				try {
					if (!f.createNewFile()) {
						this.main.error("Nouveau fichier", "Le fichier existe déjà");
					}
				} catch (IOException e) {
					this.main.error("Nouveau fichier", "Impossible de créer ce fichier");
				}
			} else {
				f = new File(this.main.getWorkspace().getWorkspace().getPath() + "\\" + this.textField.getText());
				try {
					if (!f.createNewFile()) {
						this.main.error("Nouveau fichier", "Le fichier existe déjà");
					}
				} catch (IOException e) {
					this.main.error("Nouveau fichier", "Impossible de créer ce fichier");
				}
			}
		} else
			this.main.error("Nouveau fichier", "Entrer un nom de fichier valide");
	}
	
	/**
	 * Show the workspace in the TreeView
	 * @param parent folder
	 */
	public void showWorkspace() {
		TreeItem<File> rootItem = new TreeItem<File>(this.main.getWorkspace().getWorkspace());
		rootItem.setExpanded(true);
		rootItem.getChildren().add(getWorkspaceContent(this.main.getWorkspace().getWorkspace()));
		TreeView<File> treeView = new TreeView<File>(rootItem);
		this.body.setCenter(treeView);
		this.treeView = treeView;
		treeView.setShowRoot(false);
	}
	
	/**
	 * get the workspace content (recursive)
	 * @param folder the parent folder
	 * @return TreeItem all files/folder in a folder
	 */
	private TreeItem<File> getWorkspaceContent(File folder) {
		TreeItem<File> res = new TreeItem<File>(folder);
		for (File fileEntry: folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				res.getChildren().add(getWorkspaceContent(fileEntry));
			} else res.getChildren().add(new TreeItem<File>(fileEntry));
		}
		return res;
	}

	/**
	 * Setter main
	 * 
	 * @param pfMain
	 */
	public void setMain(Main pfMain) {
		this.main = pfMain;
	}

}
