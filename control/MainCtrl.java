package control;

import javafx.stage.Stage;

public class MainCtrl {
	private BrowseFileCtrl scene;
	
	public MainCtrl(Stage stage) {
		showFirstScene(stage);
	}
	
	private void showFirstScene(Stage stage) {
		setScene(new BrowseFileCtrl(stage));
	}

	public BrowseFileCtrl getScene() {
		return scene;
	}

	public void setScene(BrowseFileCtrl scene) {
		this.scene = scene;
	}
}