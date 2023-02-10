package control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import application.Country;
import application.Edge;
import application.Map;
import application.Vertex;
import presentation.BrowseFileScene;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
/*
 * Create a Controller for the file browsing scene
 */
public class BrowseFileCtrl {
	//Attributes
	private FileChooser fileChooser;
	private File file;
	private BrowseFileScene BrowseScene;
	private MapCtrl scene2;
	private GridPane pane;
	private Label label;
	private Button run;
	private Button browse;
	private Button cancel;
	private Map map;

	public BrowseFileCtrl(Stage stage) {
		initialize(stage);
	}

	private void initialize(Stage stage) {
		BrowseScene = new BrowseFileScene(stage);
		setMap(new Map());
		setPane(BrowseScene.getPane());
		setLabel(BrowseScene.getLabel());
		run = BrowseScene.getRun();
		cancel= BrowseScene.getCancel();
		this.fileChooser = new FileChooser();
		browse= BrowseScene.getBrowse();
		handle_browse(browse,stage);
		handle_run(run,stage,getMap());
		handle_cancel(cancel);
	}

	private void handle_cancel(Button cancel2) {
		//Method to handle cancel button
		cancel2.setOnAction(a->{
			Platform.exit();
		});	
	}

	private void handle_run(Button run2, Stage stage,Map map2) {
		//Method to handle run button start the map scene
		run2.setOnAction(a->{
			setScene2(new MapCtrl(stage, map2));
		});		
	}

	private void handle_browse( Button browse, Stage stage) {
		//Method to handle browse button
		browse.setOnAction(e->{
			this.file=fileChooser.showOpenDialog(stage); 
			if(file==(null)) {
				AlertBoxCtrl a = new AlertBoxCtrl("You haven't chose a file yet!", "No file");
				a.show();
			} else {
				readFile(file,stage);
				GridPane.setHalignment(run,HPos.CENTER);
				pane.add(run, 2, 1);
				label.setText("             Reday to Process...");
			}
		});
	}
	
	private void readFile(File file, Stage stage) {
		/*
		 * Loop for the v and e and create edges and countries add them to the map
		 */
		int v =0; // number of vertices
		int e =0; // number of edges
		
		try {
			 FileReader fileR = new FileReader(file);
		     BufferedReader buffer = new BufferedReader(fileR);
	
		     if(file.length()==0) {	
		    	 // Empty file alert
		    	 AlertBoxCtrl a = new AlertBoxCtrl("Your file is an empty file!","Empty file");
		    	 a.show();
		     }else {
		    	// REad the first line which contains # of V and E
			    String s[]= buffer.readLine().trim().split(",");
			    v=Integer.parseInt(s[0]);
			    e=Integer.parseInt(s[1]);
			    
			    // Read the list of vertices
		 		for (int i = 0; i < v; i++) {
				    String s1[]= buffer.readLine().trim().split(",");
					Country country = new Country(s1[0].trim(), Integer.parseInt(s1[1].trim()), Integer.parseInt(s1[2].trim()));
					Vertex c = new Vertex(country);
					getMap().add(c);
				}
		 		
		 		//Read the list of edges
		 		for (int i = 0; i < e; i++) {
				    String s1[]= buffer.readLine().trim().split(",");
					
				    Country src = new Country(s1[0].trim());
					Country dist = new Country(s1[1].trim());
					/*
					 * Check if the source and distance exists in the list
					 * if exists then get them and add the distanation as edge to the source with its weight
					 * if not then show and alert that the country isn't in the file
					 */
					if(getMap().search(src) && getMap().search(dist)) {
						
						Vertex vs = getMap().getVertex(src);
						Vertex vd = getMap().getVertex(dist);

						Edge edge = new Edge(vd, Double.parseDouble(s1[2]));

						if(!vs.getAdjacencies().contains(edge)) {
							vs.getAdjacencies().add(edge);
						}else {
							AlertBoxCtrl a = new AlertBoxCtrl("Adjacent "+edge.getTarget().getLocation().getName()+" already exisst","Error data");
							a.show();
						}
					} else{
						AlertBoxCtrl a = new AlertBoxCtrl("One of the cities isn't in the list! "+src+" "+dist,"Error data");
						a.show();
					}
				}
		     }
		     buffer.close();
		} // catch exceptions
		catch(NumberFormatException t) {
			System.out.println(t);
		}catch (FileNotFoundException e1) {
			System.out.println(e1);
		}catch (IOException e1) {
			System.out.println(e1);
		} catch (InputMismatchException e1) {
			System.out.println(e1);
		}
	}
	/*
	 * Getters and Setters
	 */
	public FileChooser getFileChooser() {
		return fileChooser;
	}

	public void setFileChooser(FileChooser fileChooser) {
		this.fileChooser = fileChooser;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Button getRun() {
		return run;
	}

	public void setRun(Button run) {
		this.run = run;
	}

	public ButtonBase getCancel() {
		return cancel;
	}

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
	
	public BrowseFileScene getBrowseScene() {
		return BrowseScene;
	}

	public void setBrowseScene(BrowseFileScene browseScene) {
		BrowseScene = browseScene;
	}

	public MapCtrl getScene2() {
		return scene2;
	}

	public void setScene2(MapCtrl scene2) {
		this.scene2 = scene2;
	}

	public Button getBrowse() {
		return browse;
	}

	public void setBrowse(Button browse) {
		this.browse = browse;
	}

	public void setCancel(Button cancel) {
		this.cancel = cancel;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}
}