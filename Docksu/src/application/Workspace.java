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
			if (fileEntry.isDirectory()) {
				this.data.add(fileEntry);
				read(fileEntry);
			}
			else this.data.add(fileEntry);
		}
	}
	
	/**
	 * Getter of Files by a name
	 * @param name
	 * @return ArrayList of Files
	 */
	public ArrayList<File> getFiles(String name) {
		ArrayList<File> res = new ArrayList<File>();
		int i, size;
		size = this.data.size();
		for (i = 0; i < size; i++) {
			if (this.data.get(i).getName().equals(name)) res.add(this.data.get(i));
		}
		return res;
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
