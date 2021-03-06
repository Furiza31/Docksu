package application.view;

import application.WorkspaceFile;

import java.io.File;
import java.io.IOException;
import java.net.URL;
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
	private TreeView<WorkspaceFile> treeView;

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
		TreeItem<WorkspaceFile> parent = this.treeView.getTreeItem(0);
		WorkspaceFile f = new WorkspaceFile(this.main.getWorkspace().getWorkspace().getPath() + "\\" + this.textField.getText());
		if (!this.textField.getText().isEmpty()) {
			if (!Objects.isNull(this.treeView.getSelectionModel().getSelectedItem())) {
				if (this.treeView.getSelectionModel().getSelectedItem().getValue().isDirectory()) {
					parent = this.treeView.getSelectionModel().getSelectedItem();
					f = new WorkspaceFile(this.treeView.getSelectionModel().getSelectedItem().getValue().getPath() + "\\"
							+ this.textField.getText());
				} else {
					parent = this.treeView.getSelectionModel().getSelectedItem().getParent();
					f = new WorkspaceFile(this.treeView.getSelectionModel().getSelectedItem().getValue().getParent() + "\\"
							+ this.textField.getText());
				}
			}
			try {
				if (!f.createNewFile()) {
					this.main.error("Nouveau fichier", "Le fichier existe d??j??");
				} else parent.getChildren().add(new TreeItem<WorkspaceFile>(new WorkspaceFile(f)));
			} catch (IOException e) {
				this.main.error("Nouveau fichier", "Impossible de cr??er ce fichier");
			}
		} else this.main.error("Nouveau fichier", "Entrer un nom de fichier valide");
		this.textField.setText("");
	}
	
	/**
	 * Show the workspace in the TreeView
	 * @param parent folder
	 */
	public void showWorkspace() {
		TreeItem<WorkspaceFile> rootItem = new TreeItem<WorkspaceFile>(this.main.getWorkspace().getWorkspace());
		rootItem.getChildren().add(getWorkspaceContent(this.main.getWorkspace().getWorkspace()));
		rootItem.setExpanded(true);
		this.treeView = new TreeView<WorkspaceFile>(rootItem);
		this.treeView.setShowRoot(false);
		this.body.setCenter(this.treeView);
	}
	
	/**
	 * get the workspace content (recursive)
	 * @param folder the parent folder
	 * @return TreeItem all files/folder in a folder
	 */
	private TreeItem<WorkspaceFile> getWorkspaceContent(WorkspaceFile folder) {
		TreeItem<WorkspaceFile> res = new TreeItem<WorkspaceFile>(folder);
		for (File fileEntry: folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				res.getChildren().add(getWorkspaceContent(new WorkspaceFile(fileEntry)));
			} else res.getChildren().add(new TreeItem<WorkspaceFile>(new WorkspaceFile(fileEntry)));
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
