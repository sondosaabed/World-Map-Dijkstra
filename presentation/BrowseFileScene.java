package presentation;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
 * Create a scene that lets the user browse through the files to chose one
 */
public class BrowseFileScene {
	//fields
    private GridPane pane;
    private Label label;//Greeting User
    private	Button run;//User button to run the program
    private Button browse;//User Button to browse file
	private Button cancel;
  		
    public BrowseFileScene(Stage stage) {
      initialize(stage);
    }
    
    //initialization of objects
    public void initialize(Stage stage) {
    	pane = new GridPane();
    	pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(100));
		pane.setHgap(7);
		pane.setVgap(10); 
		
		Background bGround = new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY));
		pane.setBackground(bGround); 
		

		Image img = new Image("images/icon.png");
		ImageView v = new ImageView(img);
		v.setFitWidth(200);
		v.setFitHeight(200);

		Button logo = new Button();
		logo.setPrefSize(200, 200);
		logo.setGraphic(v);
		logo.setStyle("-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 0;-fx-background-color: transparent;");
		pane.add(logo, 0, 0);
		
		label = new Label("    Hello user, Browse your file...");
		label.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		pane.add(label, 1,0);
		
		run = new Button("Run");
		run.setTextFill(Color.BLACK);
		run.setPrefSize(100, 30);
		run.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		run.setStyle("-fx-background-radius: 22, 10;-fx-background-color:#F7D148;");
		
		browse = new Button("Browse"); 
		browse.setStyle("-fx-background-radius: 22, 10;-fx-background-color:#F7D148;");
		browse.setTextFill(Color.BLACK);
		browse.setPrefSize(100, 30);
		browse.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		pane.add(browse , 2,1);
		
		//User button to exit
		cancel = new Button("Cancel");
		cancel.setFont(Font.font(14)); 
		cancel.setPrefSize(100, 30);
		cancel.setStyle("-fx-background-radius: 22, 10;-fx-background-color:#F7D148;");
		cancel.setTextFill(Color.BLACK);
		cancel.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		pane.add(cancel,3,1); 
		
		//Create Scene
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setTitle("World Map");
		stage.getIcons().add(new Image("images/icon.png"));
		stage.centerOnScreen();
		stage.show();
    }
    /*
     * Getters and Setters
     */
    public GridPane getPane() {
		return pane;
	}

	public void setPane(GridPane pane) {
		this.pane = pane;
	}

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

	public Button getRun() {
		return run;
	}

	public void setRun(Button run) {
		this.run = run;
	}

	public Button getBrowse() {
		return browse;
	}

	public void setBrowse(Button browse) {
		this.browse = browse;
	}

	public Button getCancel() {
		return cancel;
	}

	public void setCancel(Button cancel) {
		this.cancel = cancel;
	}
}