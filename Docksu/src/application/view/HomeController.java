package application.view;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.Initializable;

public class HomeController implements Initializable {
	
	private Main main;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	/**
	 * Setter main
	 * @param pfMain
	 */
	public void setMain(Main pfMain) {
		this.main = pfMain;
	}

}
