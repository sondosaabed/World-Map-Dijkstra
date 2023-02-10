package presentation;

import java.util.ArrayList;

import application.Map;
import control.CountryRadioBtnCtrl;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
 * This class creates the scene of the map and let's the user to chose the source and destination
 * by either clicking or by the drop down list
 */
public class MapScene {
	//Fields
	private Button cancel;
	private Button run;
	private Button reset;
	private ComboBox<String> target;
	private ComboBox<String> choice;
	private ComboBox<String> source;
	private ArrayList<CountryRadioBtnCtrl> btns;
	int mouseClick=0;
	
	public MapScene(Stage stage,Map map2) {
		initialize(stage,map2);
	}

	private void initialize(Stage stage, Map map2) {
		BackgroundFill bgf1 = new BackgroundFill(Color.LIGHTGREEN,CornerRadii.EMPTY,Insets.EMPTY);
		Background bg1= new Background(bgf1 );

		GridPane main = new GridPane();
		main.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

		Image mapi = new Image("images/map.png");
		ImageView v = new ImageView(mapi);
		v.setFitWidth(1120);
		v.setFitHeight(620);
		main.add(v,0,0);

		GridPane root = new GridPane();  
		root.setAlignment(Pos.CENTER); 
		root.setPrefHeight(620);
		root.setPrefWidth(1120);
		main.add(root, 0, 0);
		GridPane.setMargin(root, new Insets(0, 10, 0, 0));

		setBtns(new ArrayList<>());
		for (int i = 0; i < map2.getVetices().size(); i++) {
			CountryRadioBtnCtrl ctrl = new CountryRadioBtnCtrl(map2.getVetices().get(i).getLocation(),i);
			btns.add(i,ctrl);
		}
		
		for(int i=0; i<btns.size();i++) {
			btns.get(i).getRadio().getBtn().setId(i+""); 
			btns.get(i).getRadio().getLabel().setId(i+""); 
			GridPane.setRowIndex(btns.get(i).getRadio().getLabel(),btns.get(i).getRadio().getCountry().getX());
			GridPane.setColumnIndex(btns.get(i).getRadio().getLabel(),btns.get(i).getRadio().getCountry().getY()); 
			root.getChildren().add(btns.get(i).getRadio().getLabel());
		}
		
		GridPane pane = new GridPane();

		main.add(pane, 1, 0);

		pane.setPadding(new Insets(20,20,20,20));
		pane.setAlignment(Pos.CENTER); 
		pane.setHgap(10);
		pane.setVgap(15); 

		Label mapp = new Label("World Map");
		mapp.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		pane.add(mapp,0,0);

		Label cityl = new Label("Choose Country:");
		cityl.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 18));
		pane.add(cityl,0,1);

		Label sourcel = new Label("Source:");
		sourcel.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 18));
		pane.add(sourcel,0,2);

		//This label will be updated by process of file importing
		Label targetl = new Label("Target:");
		targetl.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 18));
		pane.add(targetl,0,3);

		choice = new ComboBox<String>();
		choice.setPrefHeight(30);
		choice.setPrefWidth(150);
		choice.setBackground(bg1);
		choice.getItems().add("Through list");
		choice.getItems().add("Through mouse");
		choice.setStyle("-fx-background-radius: 10, 5;-fx-background-color:lightgreen;");
		pane.add(choice, 1, 1);

		source = new ComboBox<String>();
		source.setPrefHeight(30);
		source.setPrefWidth(150);
		source.setBackground(bg1);
		for(int i=0; i<map2.getVetices().size();i++) {
			source.getItems().add(map2.getVetices().get(i).getLocation().getName()) ;
		}
		source.setStyle("-fx-background-radius: 10, 5;-fx-background-color:lightgreen;");

		pane.add(source, 1, 2);

		target = new ComboBox<String>();
		target.setPrefHeight(30);
		target.setPrefWidth(150);
		target.setBackground(bg1);
		for(int i=0; i<map2.getVetices().size();i++) {
			target.getItems().add(map2.getVetices().get(i).getLocation().getName()) ;
		}
		target.setStyle("-fx-background-radius: 10, 5;-fx-background-color:lightgreen;");
		pane.add(target, 1, 3);

		//User button to run the shortest path
		run = new Button("Run");
		run.setFont(Font.font(14));
		run.setPrefSize(100, 30);
		run.setStyle("-fx-background-radius: 22, 10;-fx-background-color:#F7D148;");
		run.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 18));
		pane.add(run,0,4);

		//User button to exit
		cancel = new Button("Exit");
		cancel.setFont(Font.font(14));
		cancel.setPrefSize(100, 30);
		GridPane.setHalignment(cancel, HPos.CENTER);
		cancel.setStyle("-fx-background-radius: 22, 10;-fx-background-color:lightpink;");
		cancel.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 18));
		pane.add(cancel,1,4); 

		//Scene setting
		Scene scene = new Scene(main); 
		stage.setTitle("World Map");
		stage.getIcons().add(new Image("images/icon.png"));
		stage.setScene(scene);  
		stage.centerOnScreen();
		stage.show();
	}

	public ComboBox<String> getTarget() {
		return target;
	}

	public void setTarget(ComboBox<String> target) {
		this.target = target;
	}

	public ComboBox<String> getChoice() {
		return choice;
	}

	public void setChoice(ComboBox<String> choice) {
		this.choice = choice;
	}

	public ComboBox<String> getSource() {
		return source;
	}

	public void setSource(ComboBox<String> source) {
		this.source = source;
	}

	public Button getCancel() {
		return cancel;
	}

	public void setCancel(Button cancel) {
		this.cancel = cancel;
	}

	public Button getRun() {
		return run;
	}

	public void setRun(Button run) {
		this.run = run;
	}

	public Button getReset() {
		return reset;
	}

	public void setReset(Button reset) {
		this.reset = reset;
	}

	public ArrayList<CountryRadioBtnCtrl> getBtns() {
		return btns;
	}

	public void setBtns(ArrayList<CountryRadioBtnCtrl> btns) {
		this.btns = btns;
	}
}