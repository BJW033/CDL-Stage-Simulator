package model;
import java.util.ArrayList;
/**
 * The team class contains all the information for each team including: name, match wins and loses, map wins and loses, list of Matches,
 * whether or not the team is in a tie (and how many ways the team is tied), and two lists of placings following simulations 
 * @author bwu
 *
 */
public class team implements Comparable<team>{

	private String name;
	private int matchW;
	private int matchL;
	private int mapW;
	private int mapL;
	private ArrayList<Match> matches =new ArrayList<Match>();
	private double matchWinper;
	private boolean deadtie2=false;
	private boolean deadtie3=false;
	private boolean deadtie4=false;
	private boolean deadtie5=false;
	private boolean deadtie6=false;
	private ArrayList<Double> placings = new ArrayList<Double>(); 
	private ArrayList<Double> placingsSim = new ArrayList<Double>();
	/**
	 * Constructor for team needing a string for the team name and five strings of the other five teams of the pool. 
	 * Creates matches for the team and each of their opponents, and sets their placings and placingsSim to to ArrayList of
	 * size six filled with zeros (doubles). 
	 * @param team String the team name of the object. 
	 * @param op1 String name of opponent one 
	 * @param op2 String name of opponent two 
	 * @param op3 String name of opponent three 
	 * @param op4 String name of opponent four 
	 * @param op5 String name of opponent five 
	 */
	public team(String team,String op1,String op2,String op3,String op4,String op5) {
		name = team;
		matchW=0;
		matchL=0;
		mapW=0;
		mapL=0;
		matchWinper=0;
		matches.add(new Match(team,op1));
		matches.add(new Match(team,op2));
		matches.add(new Match(team,op3));
		matches.add(new Match(team,op4));
		matches.add(new Match(team,op5));

		for(int i = 0;i<6;i++) {
			placings.add((double) 0);
		}
		for(int i = 0;i<6;i++) {
			placingsSim.add((double) 0);
		}
	}
	/**
	 * Prints the number of times from a simulation that a team landed in each seed of the pool.
	 * @param longName int the length of the longest name in the pool, used for formatting the print.
	 */
	public void printPlacings(int longName) {

		System.out.print(getName() + " simulated placings count: ");
		for(int i=0;i<longName-getName().length();i++) {
			System.out.print(" ");
		}
		System.out.println("1st: " + placings.get(0)+
				" 2nd: " + placings.get(1)+
				" 3rd: " + placings.get(2)+
				" 4th: " + placings.get(3)+
				" 5th: " + placings.get(4)+
				" 6th: " + placings.get(5));


	}

	/**
	 * Prints the percent of simulations that a team landed in each seed of the pool.
	 * @param sims int number of simulation run
	 * @param longName int the length of the longest name in the pool, used for formatting the print. 
	 */
	void printSimPer(int sims, int longName) {

		System.out.print(getName() + " simulated placings percent: ");
		for(int i=0;i<longName-getName().length();i++) {
			System.out.print(" ");
		}

		System.out.printf("1st: %2.3f%% "
				+ "2nd: %2.3f%% "
				+ "3rd: %2.3f%% "
				+ "4th: %2.3f%% "
				+ "5th: %2.3f%% "
				+ "6th: %2.3f%%%n", placings.get(0)/sims*100,
				placings.get(1)/sims*100,placings.get(2)/sims*100,placings.get(3)/sims*100,
				placings.get(4)/sims*100,placings.get(5)/sims*100);


	}

	/**
	 * Dynamic setter, that takes in a boolean value and an interger to dynamically set the number of teams the team is in a dead tie with
	 * not very frequently does this happen.
	 * @param b boolean value to be set
	 * @param i int number of teams the team is tied with
	 */
	public void setTie(boolean b,int i) {
		if(i==2) {
			deadtie2=b;
		}
		else if(i==3) {
			deadtie3=b;
		}
		else if(i==4) {
			deadtie4=b;
		}
		else if(i==5) {
			deadtie5=b;
		}
		else if(i==6) {
			deadtie6=b;
		}
	}

	/**
	 * Calculates and returns a team's map win percentage
	 * @return double map win percentage
	 */
	public double getmapWinper() {
		if(mapW+mapL == 0) {
			return 0;
		}
		return (double)mapW/(mapW+mapL);
	}


	/**
	 * Prints all of the teams matches and results
	 */
	public void printMatches() {
		System.out.println(getName()+"'s matches: ");
		matches.forEach((m) -> System.out.println(m));
	}
	/**
	 * Iterates through the team's matches and finds the match verse opp. Updates the map count in the Match object. Updated the team's 
	 * overall map count, match count, and match win percentage. 
	 * @param opp String opponent name
	 * @param teamAmaps int number of maps current team won
	 * @param teamBmaps int number of maps the opponent won
	 */
	public void updateMatches(String opp, int teamAmaps, int teamBmaps) {
		for(Match i: matches) {
			if(i.getB().equals(opp)) {
				i.updateMatch(teamAmaps, teamBmaps);
			}
		}
		if(teamAmaps == 3) {
			matchW++;
			mapW+=teamAmaps;
			mapL+=teamBmaps;
		}
		else {
			matchL++;
			mapL+=teamBmaps;
			mapW+=teamAmaps;
		}
		matchWinper = (double)matchW/(matchW + matchL);

	}

	/**
	 * Prints team map count.
	 */
	public void printMapCount() {
		System.out.println(getName() +" has a " + mapW + "-" + mapL +" map count.");
	}
	/**
	 * Prints team match count
	 */
	void printRecord() {
		System.out.println(getName() +" has a " + matchW + "-" + matchL +" match count.");
	}
	/**
	 * Prints the team full record with match and map count with tie indicators
	 */
	void printRecordShort() {
		System.out.print(getName() +": (Matches) " + matchW + "-" + matchL + " (Maps) "+ mapW + "-" + mapL);
		if(isDeadtie2()||deadtie3||deadtie4||deadtie5||deadtie6) {
			System.out.print("**");
		}
		if(deadtie3) {
			System.out.print("*");
		}

		if(deadtie4) {
			System.out.print("**");
		}

		if(deadtie5) {
			System.out.print("***");
		}

		if(deadtie6) {
			System.out.print("****");
		}
		System.out.println();

	}
	/**
	 * Uses the team's match win percentage to provide a basic sort of team in descending order
	 */
	@Override
	public int compareTo(team comparestu) {
		double compareMatchWinper=((team)comparestu).getmatchWinper();
		/* For Ascending order*/
		//System.out.println((int) ((compareMatchWinper-this.matchWinper)));
		if((int) ((compareMatchWinper-this.matchWinper)*10)==0) {
			if(this.matchL > ((team)comparestu).getmatchL() || this.matchW < ((team)comparestu).getmatchW()) {
				return 1;
			}
			else
				return -1;
		}
		return (int) ((compareMatchWinper-this.matchWinper)*10);

	}

	/**
	 * Searches the list of matches for a provided opponent 
	 * @param op String name of of opponent of match
	 * @return Match if a Match verse op exists, null otherwise. 
	 */
	public Match findMatch(String op) {
		for(Match m: matches) {
			if(op.equals(m.getB())) {
				return m;
			}
		}
		return null;
	}

	/**
	 * Resets the match verse particular opponent. Removes the match maps from the team's map count and removes the 
	 * team's match from its match count.
	 * @param opp
	 */
	public void removeMatch(String opp) {
		for(Match m: matches) {
			if(m.getB().equals(opp)) {
				if(m.getMapA() == 3) {
					matchW --;
				}
				else {
					matchL --;
				}
				mapW -= m.getMapA();
				mapL -=m.getMapB();


				m.resetMatch();
			}

		}
	}

	/**
	 * Prints if the team is in any kind of tie.
	 */
	public void printTies() {
		if(deadtie2||deadtie3||deadtie4||deadtie5||deadtie6) {
			System.out.print("Ties present");
		}
	}


	/**
	 * Returns the number of times the team placed in the top three in the first Simulation ArrayList
	 * @return double sum of first three elements of placings
	 */
	public double getTop3Per() {
		return placings.get(0)+placings.get(1)+placings.get(2);
	}
	/**
	 * Returns the number of times the team placed in the top three in the second Simulation ArrayList
	 * @return double sum of first three elements of placingsSim
	 */
	public double getTop3PerSim() {
		return placingsSim.get(0)+placingsSim.get(1)+placingsSim.get(2);
	}


	public ArrayList<Double> getPlacings() {
		return placings;
	}
	public boolean isDeadtie2() {
		return deadtie2;
	}

	public boolean isDeadtie3() {
		return deadtie3;
	}
	public boolean isDeadtie4() {
		return deadtie4;
	}
	public boolean isDeadtie5() {
		return deadtie5;
	}
	public boolean isDeadtie6() {
		return deadtie6;
	}
	public ArrayList<Double> getPlacingsSim() {
		return placingsSim;
	}
	public void setMatchW(int matchW) {
		this.matchW = matchW;
	}
	public void setMatchL(int matchL) {
		this.matchL = matchL;
	}
	public void setMapW(int mapW) {
		this.mapW = mapW;
	}
	public void setMapL(int mapL) {
		this.mapL = mapL;
	}
	public ArrayList<Match> getMatches() {
		return matches;
	}
	public int getmatchW() {
		return matchW;
	}

	public int getmatchL() {
		return matchL;
	}

	public double getmatchWinper() {
		return matchWinper;
	}
	public String getName() {
		return name;
	}

}

