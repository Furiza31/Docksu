package application;

public class Workspace {
	
	private WorkspaceFile workspace;
	private Main main;
	
	public Workspace(Main pfMain) {
		this.workspace = new WorkspaceFile(System.getProperty("user.dir") + "\\Workspace");
		this.main = pfMain;
		if (!this.workspace.exists()) {
			if (!this.workspace.mkdir()) {
				this.main.error("Workspace", "Creation du workspace impossible");
				System.exit(1);
			}
		}
	}
	
	/**
	 * Getter workspace File
	 * @return File the workspace
	 */
	public WorkspaceFile getWorkspace() {
		return this.workspace;
	}
	
}
