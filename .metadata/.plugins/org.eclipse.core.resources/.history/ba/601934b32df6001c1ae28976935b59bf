package application;

import java.io.File;
import java.util.ArrayList;

public class Workspace {
	
	private File workspace;
	private Main main;
	private ArrayList<WorkspaceFile> workspaceContent;
	
	public Workspace(Main pfMain) {
		this.workspace = new File(System.getProperty("user.dir") + "\\Workspace");
		this.main = pfMain;
		if (!workspace.exists()) {
			if (!workspace.mkdir()) {
				this.main.error("Workspace", "Creation du workspace impossible");
				System.exit(1);
			}
		}
		this.workspaceContent = new ArrayList<WorkspaceFile>();
		this.read(null);
	}

	/**
	 * Read the workspace Folder
	 */
	private void read(WorkspaceFile pfParent) {
		if (pfParent == null) {
			for (File file : workspace.listFiles()) {
				if (file.isDirectory()) {
					WorkspaceFile parent = new WorkspaceFile(file.getName(), WorkspaceFileType.FOLDER);
					this.workspaceContent.add(parent);
					this.read(parent);
				} else {
					this.workspaceContent.add(new WorkspaceFile(file.getName(), WorkspaceFileType.FILE));
				}
			}
		} else {
			for (File file : pfParent.getFile().listFiles()) {
				if (file.isDirectory()) {
					WorkspaceFile parent = new WorkspaceFile(pfParent ,file.getName(), WorkspaceFileType.FOLDER);
					this.workspaceContent.add(parent);
					this.read(parent);
				} else {
					this.workspaceContent.add(new WorkspaceFile(pfParent ,file.getName(), WorkspaceFileType.FILE));
				}
			}
		}
	}
	
	/**
	 * Getter workspace File
	 * @return File the workspace
	 */
	public File getWorkspace() {
		return this.workspace;
	}
	
}
