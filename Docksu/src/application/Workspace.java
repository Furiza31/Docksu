package application;

import java.io.File;
import java.util.ArrayList;

public class Workspace {
	
	private File workspace;
	private Main main;
	private ArrayList<File> data;
	
	public Workspace(Main pfMain) {
		this.workspace = new File(System.getProperty("user.dir") + "\\Workspace");
		this.main = pfMain;
		if (!workspace.exists()) {
			if (!workspace.mkdir()) {
				this.main.error("Workspace", "Creation du workspace impossible");
				System.exit(1);
			}
		}
		this.data = new ArrayList<File>();
		this.read(this.workspace);
	}
	
	/**
	 * Read the workspace folder (recursive)
	 * @param folder
	 */
	private void read(File folder) {
		for (File fileEntry: folder.listFiles()) {
			if (fileEntry.isDirectory()) read(fileEntry);
			else this.data.add(fileEntry);
		}
	}
	
	/**
	 * Getter data
	 * @return data of the workspace
	 */
	public ArrayList<File> getData() {
		return this.data;
	}
	
	/**
	 * Getter workspace File
	 * @return File the workspace
	 */
	public File getWorkspace() {
		return this.workspace;
	}
	
}
