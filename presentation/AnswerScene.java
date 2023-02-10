package presentation;

import application.Vertex;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
/*
 * This class creates a scene where 
 */
public class AnswerScene {
	//Fields
	private TextField dist;
	private TextArea path;
	private Button cancel;
	private Stage stage;
	
	public AnswerScene(Vertex source, Vertex distanation) {
		initialize(source,distanation);
	}
	
	private void initialize(Vertex source, Vertex distantion){
		BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(c1);

		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(70, 70, 70, 70));
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setBackground(background);

		Image img = new Image("images/icon.png");
		ImageView v = new ImageView(img);
		v.setFitWidth(70);
		v.setFitHeight(70);

		Button logo = new Button();
		logo.setPrefSize(70, 70);
		logo.setGraphic(v);
		logo.setStyle("-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 0;-fx-background-color: transparent;");
		GridPane.setHalignment(logo, HPos.CENTER);
		pane.add(logo, 0, 0);
		
		Label oath = new Label("From "+source.getLocation().getName()+" to "+distantion.getLocation().getName());
		oath.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.ITALIC, 20));
		pane.add(oath,0,1);
		
		stage = new Stage();
		Label pathl = new Label("Flying shortest path:");
		pathl.setPrefWidth(180);
		pathl.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 18));
		pane.add(pathl,0,2);

		Label distl = new Label("Distance:");
		distl.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 18));
		pane.add(distl,0,4);

		//Prints the path that gives the shortest path
		path = new TextArea();
		path.setPrefHeight(300);
		path.setPrefWidth(250);
		path.setEditable(false);
		path.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 18));
		pane.add(path, 0, 3);

		//Calculates the shortest destination
		dist = new TextField();
		dist.setPrefHeight(40);
		dist.setPrefWidth(150);
		dist.setEditable(false);
		dist.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 18));
		pane.add(dist, 0, 5);
		
		//User button to exit
		//this button will be like the reset button
		cancel = new Button("Okay");
		cancel.setFont(Font.font(14));
		cancel.setPrefSize(100, 30);
		GridPane.setHalignment(cancel, HPos.CENTER);
		cancel.setStyle("-fx-background-radius: 22, 10;-fx-background-color:#F7D148;");
		cancel.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 18));
		pane.add(cancel,0,6); 
		
		//Scene setting
    	Scene scene = new Scene(pane); 
    	stage.setTitle("World Map");
		stage.getIcons().add(new Image("images/icon.png"));
		stage.setScene(scene);  
		stage.setX(1100);
		stage.setY(10);
    	stage.show();
	}
	
	public Button getCancel() {
		return cancel;
	}
	public void setCancel(Button cancel) {
		this.cancel = cancel;
	}
	public TextField getDist() {
		return dist;
	}

	public void setDist(TextField dist) {
		this.dist = dist;
	}

	public TextArea getPath() {
		return path;
	}

	public void setPath(TextArea path) {
		this.path = path;
	}

	public Stage getStage() {
		return stage;
	}
}