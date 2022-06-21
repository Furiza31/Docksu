package application;

import java.io.File;

public class Workspace {
	
	private File data;
	private Main main;
	
	public Workspace(Main pfMain) {
		this.data = new File(System.getProperty("user.dir") + "\\Workspace");
		this.main = pfMain;
		if (!data.exists()) {
			if (!data.mkdir()) {
				this.main.error("Workspace", "Creation du workspace impossible");
				System.exit(1);
			}
		}
	}
	
}
