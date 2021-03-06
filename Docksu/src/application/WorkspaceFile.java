package application;

import java.io.File;
import java.net.URI;

@SuppressWarnings("serial")
public class WorkspaceFile extends File {

	public WorkspaceFile(File parent, String child) {
		super(parent, child);
	}

	public WorkspaceFile(String pathname) {
		super(pathname);
	}

	public WorkspaceFile(String parent, String child) {
		super(parent, child);
	}

	public WorkspaceFile(URI uri) {
		super(uri);
	}
	
	public WorkspaceFile(File file) {
		super(file.getPath());
	}
	
	public WorkspaceFile(WorkspaceFile file) {
		super(file.getPath());
	}
	
	@Override
	public String toString() {
		return super.getName();
	}

}
