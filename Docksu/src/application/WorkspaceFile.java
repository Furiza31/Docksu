package application;

import java.io.File;

public class WorkspaceFile {
	
	File path;
	WorkspaceFile parent;
	WorkspaceFileType type;
	
	/**
	 * Constructor without parent
	 * @param pfName
	 * @param pfType
	 */
	public WorkspaceFile (String pfName, WorkspaceFileType pfType) {
		this.parent = null;
		this.path = new File(System.getProperty("user.dir") + "\\Workspace\\" + pfName);
		this.type = pfType;
	}

	/**
	 * Constructor with parent
	 * @param pfParent
	 * @param pfName
	 * @param pfType
	 */
	public WorkspaceFile (WorkspaceFile pfParent, String pfName, WorkspaceFileType pfType) {
		this.parent = pfParent;
		this.path = new File(pfParent.getFile().getAbsolutePath() + "\\" + pfName);
		this.type = pfType;
	}
	
	/**
	 * Getter file
	 * @return File
	 */
	public File getFile () {
		return path;
	}
	
	/**
	 * Getter type
	 * @return Type of the File
	 */
	public WorkspaceFileType getType() {
		return type;
	}
	
	/**
	 * Getter WorkspaceFile parent
	 * @return parent
	 */
	public WorkspaceFile getParent() {
		return parent;
	}
	
}