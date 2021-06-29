package model;

import java.util.ArrayList;

public class Model {
	private Group GroupA;
	private Group GroupB;
	private int simulations;
	private ArrayList<String> teams;
	
	public Model() {
		GroupA = new Group();
		GroupB = new Group();
		simulations = 100000;
		teams = new ArrayList<String>();
		teams.add("Faze");
    	teams.add("Empire");
    	teams.add("Ultra");
    	teams.add("Guerrillas");
    	teams.add("Subliners");
    	teams.add("Thieves");
    	teams.add("Ravens");
    	teams.add("Rokkr");
    	teams.add("Legion");
    	teams.add("Surge");
    	teams.add("Mutineers");
    	teams.add("Optic");
    	
	}

	public Group getGroupA() {
		return GroupA;
	}

	public void setGroupA(Group groupA) {
		GroupA = groupA;
	}

	public Group getGroupB() {
		return GroupB;
	}

	public void setGroupB(Group groupB) {
		GroupB = groupB;
	}

	public int getSimulations() {
		return simulations;
	}

	public void setSimulations(int simulations) {
		this.simulations = simulations;
	}
	
	public ArrayList<String> getTeams(){
		return teams;
	}
	
}
