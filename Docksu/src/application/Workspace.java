package application;

public class Workspace {
	
	private String path;
	
	public Workspace() {
		this.path = System.getProperty("user.dir") + "\\Workspace";
	}
	
}
