package control;

import java.util.ArrayList;

import application.Dijkstra;
import application.Map;
import application.Vertex;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import presentation.AnswerScene;
/*
 * Create controller for the scene that shows the shortest path
 */
public class AnswerCtrl {
	// fields
	private AnswerScene scene;
	MapCtrl scenel;
	private TextField dist;
	private TextArea path;
	private Button cancel;
	private Stage stage;
	
	public AnswerCtrl(Vertex source, Vertex distVertex, ArrayList<CountryRadioBtnCtrl> btns, Dijkstra sol, Stage stage, Map map) {
		initialize(source,distVertex,btns,sol, stage, map);
	}
	
	private void initialize(Vertex source, Vertex distantion, ArrayList<CountryRadioBtnCtrl> btns, Dijkstra sol, Stage stage, Map map) {
		setScene(new AnswerScene(source,distantion));
		setDist(getScene().getDist());
		setPath(getScene().getPath());
		setCancel(getScene().getCancel());
		setStage(getScene().getStage());
						
		getDist().setText(compute_distance(sol)+" KM");
		getPath().setText(print_shortest_path(sol));
		
		handle_okay(getCancel(),btns, stage, map);
	}
	
	private double compute_distance(Dijkstra sol) {
		return sol.getDistance();
	}
	
	private String print_shortest_path(Dijkstra sol) {
		// returns the path as a string
		String path="";
		for(int i=0;i<sol.getPath().size();i++) {
		    path=path+(sol.getPath().get(i).getLocation().getName())+"\n";
		}
		return path;
	}
	
	private void handle_okay(Button okay, ArrayList<CountryRadioBtnCtrl> btns, Stage stage, Map map) {
		okay.setOnAction(e->{
			scenel = new MapCtrl(stage, map);
//			for(int i=0; i<btns.size();i++) {
//				btns.get(i).getRadio().getBtn().setSelected(false);
//				btns.get(i).getRadio().getBtn().setStyle("-fx-color:black;");
//			}
			getStage().close();
		});
	}
	/*
	 * Getters and Setters
	 */
	public AnswerScene getScene() {
		return scene;
	}

	public void setScene(AnswerScene scene) {
		this.scene = scene;
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

	public Button getCancel() {
		return cancel;
	}

	public void setCancel(Button cancel) {
		this.cancel = cancel;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
}