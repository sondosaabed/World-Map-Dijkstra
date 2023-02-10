package application;

import control.MainCtrl;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application{
	public static void main(String args) {
		launch(args);
	}

	@SuppressWarnings("unused")
	@Override
	public void start(Stage stage) throws Exception {
		MainCtrl mainctrl = new MainCtrl(stage);
		stage.getIcons().add(new Image("images/icon.png"));
	}
}