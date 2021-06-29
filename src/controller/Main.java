package controller;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.StageName;
import model.Model;
import view.startView;

import view.addToGroupView;
import view.groupAmatchesView;
import view.groupBmatchesView;
import view.groupView;
import view.simulationsView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * The Main class is host to the main function of the application and controls all of the scenes of the application and 
 * connects the scenes to the model of the application
 * @author bwu
 *
 */
public class Main  extends Application {
 	ArrayList<String> groupA=new ArrayList<String>();;
	ArrayList<String> groupB=new ArrayList<String>();;
	private static Map<StageName, Scene> scenes = new HashMap<>();
	private startView startView;
	private groupView groupView;
	private groupAmatchesView groupAmatches;
	private groupBmatchesView groupBmatches;
	private simulationsView sim;
	private addToGroupView addToGroup;
	private Model model;
	/**
	 * The main function launches the application and provides the names of all teams in the league.
	 * @param args default argument (not used)
	 */
	    public static void main(String[] args) {

	    	
	        launch(args);
	    }

	    @Override
	    public void start(Stage primaryStage) {
	    	setModel(new Model());
	        startView = new startView(primaryStage,this);
	        groupView = new groupView(primaryStage,this);
	        groupAmatches = new groupAmatchesView(primaryStage,this,groupView);
	        groupBmatches = new groupBmatchesView(primaryStage,this);
	        sim = new simulationsView(primaryStage,this);
	        addToGroup = new addToGroupView(primaryStage,this);
	        scenes.put(StageName.WELCOME, startView.getScene());
	       scenes.put(StageName.GROUPSELECTION, groupView.getScene());
	       scenes.put(StageName.MATCHESA, groupAmatches.getScene());
	       scenes.put(StageName.MATCHESB, groupBmatches.getScene());
	       scenes.put(StageName.SIMULATION, sim.getScene());
	       scenes.put(StageName.ADDTO, addToGroup.getScene());
	        primaryStage.setScene(scenes.get(StageName.WELCOME));
	      
	      
	       
	    }
	    /**
	     * Getter for the addToGroup Scene
	     * @return addToGroup scene
	     */
	    public addToGroupView getAddToGroup() {
			return addToGroup;
		}
/**
 * Getter for the simulation Scene
 * @return simulation scene
 */
		public simulationsView getSim() {
			return sim;
		}
/**
 * Getter for the groupBmatches Scene
 * @return groupBmatchsView scene
 */
		public groupBmatchesView getGroupBmatches() {
			return groupBmatches;
		}
/**
 * Getter for the HashMap of Scenes
 * @return HashMap of Scenes
 */
		public Map<StageName, Scene> getScenes(){
	    	return scenes;
	    }

/**
 * Getter for an arraylist of team names from Group A
 * @return ArrayList of Group A team names
 */
		public ArrayList<String> getGroupA() {
			return groupA;
		}
/**
 * Getter for an arraylist of team names from Group B
 * @return ArrayList of Group B team names
 */
		public  ArrayList<String> getGroupB() {
			return groupB;
		}
/**
 * Getter for the groupAmatches Scene
 * @return groupAmatch Scene
 */
		public groupAmatchesView getGroupAmatches() {
			return groupAmatches;
		}
/**
 * Getter for the Model
 * @return model
 */
		public Model getModel() {
			return model;
		}
/**
 * Setter for the Model
 * @param model 
 */
		public void setModel(Model model) {
			this.model = model;
		}

		
	}






