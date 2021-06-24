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



public class Main  extends Application {
	private static ArrayList<String> teams;
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
	
	    public static void main(String[] args) {
	    	
	    	teams = new ArrayList<String>();
	    	teams.add("Faze");
	    	teams.add("Empire");
	    	teams.add("Optic");
	    	teams.add("Guerrillas");
	    	teams.add("Legion");
	    	teams.add("Mutineers");
	    	teams.add("Ravens");
	    	teams.add("Rokkr");
	    	teams.add("Subliners");
	    	teams.add("Surge");
	    	teams.add("Thieves");
	    	teams.add("Ultra");
	    	
	    	
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
	    
	    public addToGroupView getAddToGroup() {
			return addToGroup;
		}

		public simulationsView getSim() {
			return sim;
		}

		public groupBmatchesView getGroupBmatches() {
			return groupBmatches;
		}

		public Map<StageName, Scene> getScenes(){
	    	return scenes;
	    }

		public ArrayList<String> getTeams() {
			return teams;
		}

		public ArrayList<String> getGroupA() {
			return groupA;
		}

		public  ArrayList<String> getGroupB() {
			return groupB;
		}

		

		public groupAmatchesView getGroupAmatches() {
			return groupAmatches;
		}

		public Model getModel() {
			return model;
		}

		public void setModel(Model model) {
			this.model = model;
		}

		
	}

//
//public class Main  {
//	
//	private static Map<StageName, Scene> scenes = new HashMap<>();
//	  public static void main(String args[]) {
//	  
//	  
//	  Group GroupA = new Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
//	  
//	  
//	  //GroupA.printStandings(); //GroupA.printAllMatches();
//	  
//	  
//	  GroupA.updateMatch("Optic", "Faze", 0, 3,false);
//	  GroupA.updateMatch("Optic","Legion", 3, 1,false); 
//	  GroupA.updateMatch("Optic","Rokkr", 3, 0,false);
//	  
//	  
//	  GroupA.updateMatch("Faze", "Surge", 3, 0,false); 
//	  GroupA.updateMatch("Faze","Legion", 3, 1,false);
//	  
//	  
//	  GroupA.updateMatch("Thieves","Legion", 2, 3,false);
//	  GroupA.updateMatch("Thieves", "Surge", 3, 2,false);
//	  
//	  GroupA.updateMatch("Rokkr", "Legion",3, 1,false);
//	  GroupA.updateMatch("Rokkr","Surge",3, 1,false);
//	  
//	  
//	  GroupA.updateMatch("Faze","Thieves", 3, 0,false);
//	  
//	  
//	  GroupA.updateMatch("Optic", "Surge", 2, 3,false);
//	  
//	  
//	   GroupA.updateMatch("Thieves", "Rokkr", 2, 3,true); 
//	  // GroupA.updateMatch("Faze", "Rokkr", 3, 2,false);
//	  //GroupA.updateMatch("Legion", "Surge", 3, 2); 
//	  //GroupA.updateMatch("Optic","Thieves", 3, 2,false);
//	  
//	  
//	  
//	  
//	  
//	  Group GroupB = new Group("Ultra","Subliners","Mutineers","Ravens","Gurrillas", "Empire");
//	  
//	  GroupB.updateMatch("Ultra", "Mutineers", 2, 3,false);
//	  
//	  GroupB.updateMatch("Ultra", "Ravens", 3, 0,false);
//	  
//	  GroupB.updateMatch("Ultra", "Empire", 3, 0,false);
//	  
//	  GroupB.updateMatch("Subliners", "Mutineers", 3, 2,false);
//	  
//	  GroupB.updateMatch("Subliners", "Gurrillas", 3, 1,false);
//	  
//	  
//	  GroupB.updateMatch("Mutineers", "Ravens", 3, 0,false);
//	  GroupB.updateMatch("Mutineers", "Gurrillas", 3, 1,false);
//	  
//	  
//	  
//	  GroupB.updateMatch("Ravens", "Empire", 2, 3,false);
//	  
//	  GroupB.updateMatch("Gurrillas", "Empire", 0, 3,false);
//	  
//	  GroupB.updateMatch("Subliners", "Empire", 3, 2,false);
//	  GroupB.updateMatch("Ultra", "Gurrillas", 3, 0,false);
//	  
//	  GroupB.updateMatch("Subliners", "Ravens", 3, 0,true);
//	  
//	  
//	  //GroupB.updateMatch("Ravens", "Gurrillas", 2, 3,false);
//	  //GroupB.updateMatch("Mutineers", "Empire", 2, 3,false);
//	  //GroupB.updateMatch("Ultra", "Subliners", 2, 3,false);
//	  
//	  
//	  GroupA.simulateMatches(GroupA,false); 
//	  GroupB.simulateMatches(GroupB,false);
//	  
//	  //GroupA.importantMatches(GroupA); 
//	  //GroupB.importantMatches(GroupB);
//	  //GroupB.printStandings();
//	  
//	  
//	  
//	  }
//	public List<Node> getScenes() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
//	 
//
//
//}




