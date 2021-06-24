package model;

public class Model {
	private Group GroupA;
	private Group GroupB;
	private int simulations;
	
	public Model() {
		GroupA = new Group(false);
		GroupB = new Group(true);
		simulations = 100000;
		
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
	
	
}
