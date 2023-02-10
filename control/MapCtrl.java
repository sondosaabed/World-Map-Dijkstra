package control;

import application.Country;
import application.Dijkstra;
import application.Map;
import application.Vertex;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import presentation.MapScene;

public class MapCtrl {
	//Fields
	private MapScene scene;
	private AnswerCtrl scene1;
	private Button cancel;
	private Button run;
	private ComboBox<String> target;
	private ComboBox<String> choice;
	private ComboBox<String> source;
	String src="";
	String dist="";
	private int mouseClick=0;
	private Dijkstra sol;
	
	public Dijkstra getSol() {
		return sol;
	}
	public void setSol(Dijkstra sol) {
		this.sol = sol;
	}
	public MapCtrl(Stage stage, Map map2) {
		initialize(stage,map2);
	}
	private void initialize(Stage stage,Map map2) {
		setScene(new MapScene(stage, map2));
		
		setCancel(getScene().getCancel());
		setRun(getScene().getRun());
		setTarget(getScene().getTarget());
		setChoice(getScene().getChoice());
		setSource(getScene().getSource());
		
		handle_cancel(getCancel());
		handle_run(getRun(),stage, map2);
	}
	
	private void handle_run(Button run, Stage stage, Map map) {
		run.setOnAction(e->{
			Vertex vs = new Vertex(null) ;
			Vertex vd = new Vertex(null);
			
			if(getChoice().getSelectionModel().getSelectedItem().equals("Through list")) {
				/*
				 * if user choses the countries through the lists
				 */
				src=getSource().getSelectionModel().getSelectedItem();
				dist=getTarget().getSelectionModel().getSelectedItem();
				
				Country cs = new Country(src);
				Country cd = new Country(dist);
				
				vs = map.getVertex(cs);
				vd = map.getVertex(cd);
				
			}else if(getChoice().getSelectionModel().getSelectedItem().equals("Through mouse")) {
				/*
				 * If the user chose the mouse as a way to chose source and distenation 
				 */				
				for(int i=0; i<getScene().getBtns().size();i++) {
					if(getScene().getBtns().get(i).getRadio().getBtn().isSelected()){
						mouseClick++;
						if(mouseClick==1) {
							//list.add(0,getScene().getBtns().get(i).getRadio().getCountry());
							src = getScene().getBtns().get(i).getRadio().getCountry().getName();
							System.out.println(src);
							getSource().setValue(src);
						}else if(mouseClick == 2) {
							//list.add(1,getScene().getBtns().get(i).getRadio().getCountry());
							dist = getScene().getBtns().get(i).getRadio().getCountry().getName();
							System.out.println(dist);
							getTarget().setValue(dist);
						}else {
							break;
						}
					}
				}
				for(int i=0; i<getScene().getBtns().size();i++) {
					getScene().getBtns().get(i).getRadio().getBtn().setSelected(false);
					getScene().getBtns().get(i).getRadio().getBtn().setToggleGroup(null);
				}
				Country cs = new Country(src);
				Country cd = new Country(dist);
				
				vs = map.getVertex(cs);
				vd = map.getVertex(cd);
			
			} else if(getChoice().getSelectionModel().getSelectedItem().equals(null)) {
				AlertBoxCtrl a = new AlertBoxCtrl("Chose how to select countries", "Selction method");
				a.show();
			}
			/*
			 * Clear the selections
			 */
			
			getChoice().getSelectionModel().clearSelection();
			getSource().getSelectionModel().clearSelection();
			getTarget().getSelectionModel().clearSelection();
			
			sol = new Dijkstra(vs, vd);
			
			for(int i=0;i<getScene().getBtns().size();i++) {
				Vertex v = new Vertex(getScene().getBtns().get(i).getRadio().getCountry());
				if(sol.getPathCountries().contains(v.getLocation())) {
					getScene().getBtns().get(i).getRadio().getBtn().setStyle("-fx-color:red;");
				}
			}
			setScene1(new AnswerCtrl(vs,vd,getScene().getBtns(),sol,stage, map));
		});
	}
	
	private void handle_cancel(Button cancel) {
		cancel.setOnAction(e->{
			Platform.exit();
		});
	}
	
	public MapScene getScene() {
		return scene;
	}
	public void setScene(MapScene scene) {
		this.scene = scene;
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
	public ComboBox<String> getChoice() {
		return choice;
	}
	public void setChoice(ComboBox<String> choice) {
		this.choice = choice;
	}
	public ComboBox<String> getTarget() {
		return target;
	}
	public void setTarget(ComboBox<String> target) {
		this.target = target;
	}
	public ComboBox<String> getSource() {
		return source;
	}
	public void setSource(ComboBox<String> source) {
		this.source = source;
	}
	public AnswerCtrl getScene1() {
		return scene1;
	}
	public void setScene1(AnswerCtrl scene1) {
		this.scene1 = scene1;
	}
	public int getMouseClick() {
		return mouseClick;
	}
	public void setMouseClick(int mouseClick) {
		this.mouseClick = mouseClick;
	}
}