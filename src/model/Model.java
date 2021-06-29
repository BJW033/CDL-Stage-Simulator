package model;

import java.util.ArrayList;
/**
 * The Model is host to the ArrayList of team names and the two groups of teams and their data
 * @author bwu
 *
 */
public class Model {
	private Group GroupA;
	private Group GroupB;
	private int simulations;
	private ArrayList<String> teams;
	/**
	 * Model constructor that sets both GroupA and GroupB as default Groups and adds the names of the teams to the 
	 * teams ArrayList
	 */
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
/**
 * Getter for Group A
 * @return Group A
 */
	public Group getGroupA() {
		return GroupA;
	}
/**
 * Setter for Group A
 * @param groupA a group object to represent Group A
 */
	public void setGroupA(Group groupA) {
		GroupA = groupA;
	}
	/**
	 * Getter for Group B
	 * @return Group B
	 */
	public Group getGroupB() {
		return GroupB;
	}
/**
 * Setter for Group B
 * @param groupB a group object to represent Group B
 */
	public void setGroupB(Group groupB) {
		GroupB = groupB;
	}
	/**
	 * Getter for the number of simulations 
	 * @return number of simulations
	 */
	public int getSimulations() {
		return simulations;
	}
/**
 * Setter for the number of simulations
 * @param simulations number of simulations to be used
 */
	public void setSimulations(int simulations) {
		this.simulations = simulations;
	}
	/**
	 * Getter for the ArrayList of team names
	 * @return ArrayList of team names
	 */
	public ArrayList<String> getTeams(){
		return teams;
	}
	
}
