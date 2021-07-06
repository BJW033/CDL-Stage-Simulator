package model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 * The Group Class contains six teams, the number of simulations to be used, and results of simulations on the teams.
 * @author bwu
 *
 */
public class Group{

	private team TeamA;
	private team TeamB;
	private team TeamC;
	private team TeamD;
	private team TeamE;
	private team TeamF;
	private int longName =0;
	private ArrayList<team> pool = new ArrayList<team>();
	private ArrayList<team> poolsim = new ArrayList<team>();
	private final int simulations=100000;

	/**
	 * Default constructor, creates six default teams in a the group
	 */
	public Group() {

		String A = "Faze";
		String B = "Optic";
		String C = "Thieves";
		String D = "Rokkr";
		String E = "Legion";
		String F = "Surge";


		TeamA=new team(A,B,C,D,E,F);
		TeamB=new team(B,A,C,D,E,F);
		TeamC=new team(C,B,A,D,E,F);
		TeamD=new team(D,B,C,A,E,F);
		TeamE=new team(E,B,C,D,A,F);
		TeamF=new team(F,B,C,D,E,A);

		pool.add(TeamA);
		pool.add(TeamB);
		pool.add(TeamC);
		pool.add(TeamD);
		pool.add(TeamE);
		pool.add(TeamF);

		poolsim.add(TeamA);
		poolsim.add(TeamB);
		poolsim.add(TeamC);
		poolsim.add(TeamD);
		poolsim.add(TeamE);
		poolsim.add(TeamF);


		for(team t: pool) {
			if(t.getName().length()>longName) {
				longName=t.getName().length();
			}
		}


	}
	/**
	 * Creates a group with teams with the names given by Strings A-F
	 * @param A String team name A
	 * @param B String team name B
	 * @param C String team name C
	 * @param D String team name D
	 * @param E String team name E
	 * @param F String team name F
	 */
	public Group(String A, String B,String C,String D,String E, String F) {
		TeamA=new team(A,B,C,D,E,F);
		TeamB=new team(B,A,C,D,E,F);
		TeamC=new team(C,B,A,D,E,F);
		TeamD=new team(D,B,C,A,E,F);
		TeamE=new team(E,B,C,D,A,F);
		TeamF=new team(F,B,C,D,E,A);

		pool.add(TeamA);
		pool.add(TeamB);
		pool.add(TeamC);
		pool.add(TeamD);
		pool.add(TeamE);
		pool.add(TeamF);

		poolsim.add(TeamA);
		poolsim.add(TeamB);
		poolsim.add(TeamC);
		poolsim.add(TeamD);
		poolsim.add(TeamE);
		poolsim.add(TeamF);



		for(team t: pool) {
			if(t.getName().length()>longName) {
				longName=t.getName().length();
			}
		}
	}
	/**
	 * Creates a group consisting of the names from an ArrayList of Strings that has a size six. 
	 * @param g ArrayList<String> of size six consisting of team names. 
	 */
	public Group(ArrayList<String> g) {
		TeamA=new team(g.get(0),g.get(1),g.get(2),g.get(3),g.get(4),g.get(5));
		TeamB=new team(g.get(1),g.get(0),g.get(2),g.get(3),g.get(4),g.get(5));
		TeamC=new team(g.get(2),g.get(1),g.get(0),g.get(3),g.get(4),g.get(5));
		TeamD=new team(g.get(3),g.get(1),g.get(2),g.get(0),g.get(4),g.get(5));
		TeamE=new team(g.get(4),g.get(1),g.get(2),g.get(3),g.get(0),g.get(5));
		TeamF=new team(g.get(5),g.get(1),g.get(2),g.get(3),g.get(4),g.get(0));


		pool.add(TeamA);
		pool.add(TeamB);
		pool.add(TeamC);
		pool.add(TeamD);
		pool.add(TeamE);
		pool.add(TeamF);

		poolsim.add(TeamA);
		poolsim.add(TeamB);
		poolsim.add(TeamC);
		poolsim.add(TeamD);
		poolsim.add(TeamE);
		poolsim.add(TeamF);


		for(team t: pool) {
			if(t.getName().length()>longName) {
				longName=t.getName().length();
			}
		}
	}

	/**
	 * Constructs the group determined by stage and group given by user. Uses stage to determine the stage being used for both the names
	 * and updates matches as of entering Stage Four Week Three and uses the boolean group in order to choose what team names are going 
	 * to be used. 
	 * @param group boolean True if Group A, false if Group B
	 * @param stage int chooses what stage is used for the team names, also used to update matches if Stage Four
	 */
	public Group(boolean group,int stage) {

		String A = "Faze";
		String B = "Optic";
		String C = "Thieves";
		String D = "Subliners";
		String E = "Legion";
		String F = "Ravens";

		if(stage == 4) {
			A = "Faze";
			B = "Optic";
			C = "Thieves";
			D = "Rokkr";
			E = "Legion";
			F = "Surge";
			if(group) {
				A = "Empire";
				B = "Ultra";
				C = "Mutineers";
				D = "Subliners";
				E = "Ravens";
				F = "Guerrillas";
			}

		}

		else {
			if(group) {
				A="Empire";
				B="Ultra";
				C="Rokkr";
				D="Mutineers";
				E="Guerrillas";
				F="Surge";
			}
		}

		TeamA=new team(A,B,C,D,E,F);
		TeamB=new team(B,A,C,D,E,F);
		TeamC=new team(C,B,A,D,E,F);
		TeamD=new team(D,B,C,A,E,F);
		TeamE=new team(E,B,C,D,A,F);
		TeamF=new team(F,B,C,D,E,A);

		pool.add(TeamA);
		pool.add(TeamB);
		pool.add(TeamC);
		pool.add(TeamD);
		pool.add(TeamE);
		pool.add(TeamF);

		poolsim.add(TeamA);
		poolsim.add(TeamB);
		poolsim.add(TeamC);
		poolsim.add(TeamD);
		poolsim.add(TeamE);
		poolsim.add(TeamF);


		for(team t: pool) {
			if(t.getName().length()>longName) {
				longName=t.getName().length();
			}
		}
		if(group && stage == 4) {
			updateMatch("Ultra", "Mutineers", 2, 3,false);

			updateMatch("Ultra", "Ravens", 3, 0,false);

			updateMatch("Ultra", "Empire", 3, 0,false);

			updateMatch("Subliners", "Mutineers", 3, 2,false);

			updateMatch("Subliners", "Guerrillas", 3, 1,false);


			updateMatch("Mutineers", "Ravens", 3, 0,false);
			updateMatch("Mutineers", "Guerrillas", 3, 1,false);

			updateMatch("Ravens", "Empire", 2, 3,false);

			updateMatch("Guerrillas", "Empire", 0, 3,false);

			updateMatch("Subliners", "Empire", 3, 2,false);
		}
		else if (stage == 4){
			updateMatch("Optic", "Faze", 0, 3,false);
			updateMatch("Optic","Legion", 3, 1,false); 
			updateMatch("Optic","Rokkr", 3, 0,false);


			updateMatch("Faze", "Surge", 3, 0,false); 
			updateMatch("Faze","Legion", 3, 1,false);


			updateMatch("Thieves","Legion", 2, 3,false);
			updateMatch("Thieves", "Surge", 3, 2,false);

			updateMatch("Rokkr", "Legion",3, 1,false);
			updateMatch("Rokkr","Surge",3, 1,false);


			updateMatch("Faze","Thieves", 3, 0,false);
		}
		

	}


	/**
	 * Updates the match of both teams with the given map count by calling the team.updateMatches(String, int, int)
	 * @param teamA String name of team A
	 * @param teamB String name of team B
	 * @param mapAw int map wins of team A
	 * @param mapBw int map wins of team B
	 */
	public void updateMatch(String teamA, String teamB, int mapAw, int mapBw) {
		getTeam(teamA).updateMatches(teamB, mapAw, mapBw);
		getTeam(teamB).updateMatches(teamA, mapBw, mapAw);
	}
	/**
	 * Updates the match of both teams with the given map count by calling the team.updateMatches(String, int, int).
	 * Uses boolean to determine if simulations should be run before and after update to compare the top three chances
	 * of only the two teams in the match. Prints results to console. 
	 * @param teamA String name of team A
	 * @param teamB String name of team B
	 * @param mapAw int map wins of team A
	 * @param mapBw int map wins of team B
	 * @param recent boolean If true, simulates before/after and prints difference to console. If false, only updates match of both teams.
	 */
	public void updateMatch(String teamA, String teamB, int mapAw, int mapBw, boolean recent) {
		ArrayList<Double> before = new ArrayList<Double>();
		ArrayList<Double> after = new ArrayList<Double>();
		if(recent) {
			before = simulateMatches(this,true);
		}
		getTeam(teamA).updateMatches(teamB, mapAw, mapBw);
		getTeam(teamB).updateMatches(teamA, mapBw, mapAw);
		if(recent) {
			after = simulateMatches(this,true);
			System.out.println("Top Three Percentages after "+ teamA +" vs " + teamB + " " + mapAw + " - " + mapBw);

			for(int i = 0; i<pool.size();i++) {
				double delta = ((after.get(i)-before.get(i))/simulations*100) ;
				System.out.print(pool.get(i).getName() + ":");
				if(delta >= 10) {
					for(int x=0;x<longName-pool.get(i).getName().length()+1;x++) {
						System.out.print(" ");
					}
				}
				else {
					for(int x=0;x<longName-pool.get(i).getName().length()+1;x++) {
						System.out.print(" ");
					}
				}
				if(delta>0) {
					System.out.printf("+%.3f%% change. Top 3 chances now: %.3f%%%n",delta,after.get(i)/simulations*100 );

				}
				else {
					System.out.printf("%.3f%% change. Top 3 chances now: %.3f%%%n",delta,after.get(i)/simulations*100 );
				}

			}
		}
	}

	/**
	 * Updates the match in both teams then simulates the rest of the group matches by calling simulateMatchesAddingMatch(Group) 
	 * which saves the results in poolsim attribute. The matches are then removed from the teams. 
	 * @param teamA
	 * @param teamB
	 * @param mapAw
	 * @param mapBw
	 */
	public void matchImpact(String teamA, String teamB, int mapAw, int mapBw) {

		getTeam(teamA).updateMatches(teamB, mapAw, mapBw);
		getTeam(teamB).updateMatches(teamA, mapBw, mapAw);
		
		simulateMatchesAddingMatch(this);
		
		getTeam(teamA).removeMatch(teamB);
		getTeam(teamB).removeMatch(teamA);

	}

	/////////////Print statements for debugging///////////////////
	/**
	 * Prints all matches from all the teams to console. Includes duplicates. 
	 */
	public void printAllMatches() {
		for(team i: pool) {
			i.printMatches();
		}
	}
	/**
	 * Prints the standings of the group. Uses a boolean to determine if the teams should be printed without ties then with tie breaks. 
	 * @param sim boolean determines if the teams should be sorted and corrected for ties
	 * @param p ArrayList<team> list of teams to sort
	 */
	public void printStandings(boolean sim,ArrayList<team> p) {
		if(!sim) {
			System.out.println("Before tie breaks");

			Collections.sort(p);
			for(team i: p) {
				i.printRecordShort();
			}
			tieCheck(p);
			System.out.println("After tie breaks");
			for(team i: p) {
				i.printRecordShort();
			}
		}
		else {
			Collections.sort(p);
			tieCheck(p);
			for(team i: p) {
				i.printRecordShort();
			}
		}

	}
	/**
	 * Prints the simulated placings of each team
	 */
	public void printSimulatedPlacings() {
		for(team t: this.pool) {
			t.printPlacings(longName);
		}
	}
	/**
	 * Prints the percent chances from simulations of each team
	 * @param simulations
	 */
	private void printSimulatedPercentages(int simulations) {
		System.out.println("Number of simulations: " + simulations);
		for(team t: this.pool) {
			t.printSimPer(simulations,longName);
		}
	}
	/**
	 * Prints only the played matches from the teams. Includes duplicates.
	 */
	public void printPlayedMatches() {
		for(team t: pool) {
			for(Match m: t.getMatches()) {
				if(m.getMapA() ==3 || m.getMapB()==3) {
					System.out.println(m);
				}
			}
		}
	}
	/**
	 * Prints the team names in the pool
	 */
	public void printPool() {
		for(team t: pool) {
			System.out.print(t.getName() + " " );
		}
		System.out.println();
	}
	
	/**
	 * Creates an exact duplicate of a group by copying the team names and matches. This is used for simulations without directly impacting
	 * the Group
	 * @param A Group Group to be copied
	 * @return Group duplicate of the given group
	 */
	private Group saveState(Group A) {
		Group dup=new Group(A.TeamA.getName(),A.TeamB.getName(),A.TeamC.getName(),A.TeamD.getName(),A.TeamE.getName(),A.TeamF.getName());

		for(int x=0;x<A.pool.size();x++) {
			for(int y=0;y<A.pool.get(x).getMatches().size();y++) {
				
				String teamA = A.pool.get(x).getName();
				String teamB = A.pool.get(x).getMatches().get(y).getB();
				int mapA=A.pool.get(x).getMatches().get(y).getMapA();
				int mapB=A.pool.get(x).getMatches().get(y).getMapB();

				if(mapA!=0 ||mapB!=0 ) {
					dup.getTeam(teamA).updateMatches(teamB, mapA, mapB);
				}
			}
		}
		return dup;
	}

	/**
	 * Iterates though the pool ArrayList reseting all of the team's placing data to zero
	 */
	public void resetPlacing() {
		for(team t: pool) {
			for(int i = 0; i<t.getPlacings().size();i++) {
				t.getPlacings().set(i, (double) 0);
			}
		}
	}
	/**
	 * Iterates though the pool ArrayList reseting all of the team's placingSim data to zero
	 */
	public void resetPlacingSim() {
		for(team t: pool) {
			for(int i = 0; i<t.getPlacingsSim().size();i++) {
				t.getPlacingsSim().set(i, (double) 0);
			}
		}
	}
	/**
	 * Uses the groups simulation attribute to determine the number of simulations to run. After resetting the the placings of each team,
	 * a copy of the group A is made. The matches of the copy are then iterated though. If a match had yet to be played, a fair "coin" if flipped 
	 * until one side lands three times. This then becomes the map count and the match is updated in the copy. The copy pool is then sorted
	 * and ties are broken. The copy standings are then used to add to the original group's team's placing values. If printSims is true, the 
	 * results of the simulation are printed. An ArrayList<Double> of the top three counts for each team is returned. The order of top
	 * three values is the same as the order of the pool. 
	 * @param A Group Group to be copied
	 * @param printSims boolean print the result of simulation
	 * @return ArrayList<Double> top three count for each team
	 */
	public ArrayList<Double> simulateMatches(Group A,boolean printSims) {

		resetPlacing();

		for(int sims = 0; sims<simulations;sims++) {
			Group Copy = saveState(A);
			for(int x=0;x<Copy.pool.size();x++) {
				String team = Copy.pool.get(x).getName();
				int mapA=0;
				int mapB=0;
				int count=0;
				for(int y =0; y<Copy.pool.get(x).getMatches().size();y++) {
					if(Copy.pool.get(x).getMatches().get(y).getMapA()==0 && Copy.pool.get(x).getMatches().get(y).getMapB()==0) {
						String opp = Copy.pool.get(x).getMatches().get(y).getB();
						while((mapA!=3 && mapB!=3) && count<10) { 
							double draw = Math.random();
							if(draw>0.5) { 
								mapA++; 
							} 
							else { 
								mapB++;
							} 
							if(mapA==3||mapB==3) {
								Copy.updateMatch(team,opp,mapA,mapB,false);

							} 
							else
								count++; 
						}
						mapA=0; 
						mapB=0;
						count=0;
					}
				}

			}
			Copy.disableTies(pool);
			Copy.sortStandings(Copy.pool);
			addSim(Copy);

		}
		if(printSims) {
			printSimulatedPercentages(simulations);
		}
		ArrayList<Double> ret = new ArrayList<Double>();
		for(team t: pool) {
			ret.add(t.getPlacings().get(0)+t.getPlacings().get(1)+t.getPlacings().get(2));
		}
		return ret;

	}
	/**
	 * Uses the groups simulation attribute to determine the number of simulations to run. After resetting the the placingsSim of each team,
	 * a copy of the group A is made. The matches of the copy poolsim are then iterated though. If a match had yet to be played, a fair "coin" 
	 * if flipped until one side lands three times. This then becomes the map count and the match is updated in the copy. The copy poolsim is 
	 * then sorted and ties are broken. The copy standings are then used to add to the original group's team's placingSim values. 
	 * An ArrayList<Double> of the top three counts for each team is returned. The order of top three values is the same as the order of the poolsim. 
	 * @param A Group Group to be copied
	 * @return ArrayList<Double> top three count for each team
	 */
	public ArrayList<Double> simulateMatchesAddingMatch(Group A) {

		resetPlacingSim();

		for(int sims = 0; sims<simulations;sims++) {
			Group Copy = saveState(A);
			for(int x=0;x<Copy.pool.size();x++) {
				String team = Copy.poolsim.get(x).getName();
				int mapA=0;
				int mapB=0;
				int count=0;
				for(int y =0; y<Copy.poolsim.get(x).getMatches().size();y++) {
					if(Copy.poolsim.get(x).getMatches().get(y).getMapA()==0 && Copy.poolsim.get(x).getMatches().get(y).getMapB()==0) {
						String opp = Copy.poolsim.get(x).getMatches().get(y).getB();
						while((mapA!=3 && mapB!=3) && count<10) { 
							double draw = Math.random();
							if(draw>0.5) { 
								mapA++;  
							} 
							else { 
								mapB++;
							} 
							if(mapA==3||mapB==3) {
								Copy.updateMatch(team,opp,mapA,mapB);

							} 
							else
								count++; 
						}
						mapA=0; 
						mapB=0;
						count=0;
					}
				}

			}
			Copy.disableTies(poolsim);
			Copy.sortStandings(Copy.poolsim);
			addSimMatch(Copy);

		}

		ArrayList<Double> ret = new ArrayList<Double>();
		for(team t: pool) {
			ret.add(t.getPlacingsSim().get(0)+t.getPlacingsSim().get(1)+t.getPlacingsSim().get(2));
		}
		return ret;

	}

	/**
	 * Iterates through a Group that is sorted and all ties are broken. The position the team is in the pool is then counted to the current
	 * group team's placings in the same position. If the team is in a deadtie, a portion equal to the number of teams they are tied with
	 * is given. 
	 * @param sim Group Group to add
	 */
	private void addSim(Group sim) {
		for(int x =0;x<pool.size();x++) {
			for(int y=0;y<sim.pool.size();y++) {
				if(this.pool.get(x).getName().equals(sim.pool.get(y).getName()) ){
					//System.out.println("found " + x + " " +y);
					if(sim.pool.get(x).isDeadtie2()) {
						this.pool.get(x).getPlacings().set(y, this.pool.get(x).getPlacings().get(y)+0.5);
					}
					else if(sim.pool.get(x).isDeadtie3()) {
						this.pool.get(x).getPlacings().set(y, this.pool.get(x).getPlacings().get(y)+0.33);
					}
					else if(sim.pool.get(x).isDeadtie4()) {
						this.pool.get(x).getPlacings().set(y, this.pool.get(x).getPlacings().get(y)+0.25);
					}
					else if(sim.pool.get(x).isDeadtie5()) {
						this.pool.get(x).getPlacings().set(y, this.pool.get(x).getPlacings().get(y)+0.20);
					}
					else if(sim.pool.get(x).isDeadtie6()) {
						this.pool.get(x).getPlacings().set(y, this.pool.get(x).getPlacings().get(y)+0.16);
					}
					else {
						this.pool.get(x).getPlacings().set(y, this.pool.get(x).getPlacings().get(y)+1);
					}
				}
			}

		}
	}

	/**
	 * Iterates through a Group that is sorted and all ties are broken. The position the team is in the poolsim is then counted to the current
	 * group team's placingsSim in the same position. If the team is in a deadtie, a portion equal to the number of teams they are tied with
	 * is given. 
	 * @param sim Group Group to add
	 */
	private void addSimMatch(Group sim) {
		for(int x =0;x<pool.size();x++) {
			for(int y=0;y<sim.pool.size();y++) {
				if(this.poolsim.get(x).getName().equals(sim.poolsim.get(y).getName()) ){
					//System.out.println("found " + x + " " +y);
					if(sim.poolsim.get(x).isDeadtie2()) {
						this.poolsim.get(x).getPlacingsSim().set(y, this.poolsim.get(x).getPlacingsSim().get(y)+0.5);
					}
					else if(sim.poolsim.get(x).isDeadtie3()) {
						this.poolsim.get(x).getPlacingsSim().set(y, this.poolsim.get(x).getPlacingsSim().get(y)+0.33);
					}
					else if(sim.poolsim.get(x).isDeadtie4()) {
						this.poolsim.get(x).getPlacingsSim().set(y, this.poolsim.get(x).getPlacingsSim().get(y)+0.25);
					}
					else if(sim.poolsim.get(x).isDeadtie5()) {
						this.poolsim.get(x).getPlacingsSim().set(y, this.poolsim.get(x).getPlacingsSim().get(y)+0.20);
					}
					else if(sim.poolsim.get(x).isDeadtie6()) {
						this.poolsim.get(x).getPlacingsSim().set(y, this.poolsim.get(x).getPlacingsSim().get(y)+0.16);
					}
					else {
						this.poolsim.get(x).getPlacingsSim().set(y, this.poolsim.get(x).getPlacingsSim().get(y)+1);
					}
				}
			}

		}
	}
	
	
	/**
	 * Iterates through the pool of team and resets all the teams map and match counts and all of their matches.
	 */
	public void resetMatches() {
		for(team t: pool) {
			for(Match m: t.getMatches()) {
				m.resetMatch();
			}
			t.setMapL(0);
			t.setMapW(0);
			t.setMatchW(0);
			t.setMatchL(0);
		}
	}
	/**
	 * Removes/resets a match between two teams in the pool. 
	 * @param teamA String name of team A
	 * @param teamB String name of team B
	 */
	public void resetMatch(String teamA, String teamB) {
		getTeam(teamA).removeMatch(teamB);
		getTeam(teamB).removeMatch(teamA);
	}

	/**
	 * Sorts the teams in a given ArrayList<teams> by match win percentage then breaks ties. 
	 * @param p ArrayList<team> to put in standings order
	 */
	public void sortStandings(ArrayList<team>p) {
		Collections.sort(p);
		tieCheck(p);
	}
	/**
	 * Sorts the teams in a pool by match win percentage then breaks ties. 
	 * @param p ArrayList<team> to put in standings order
	 */
	public void sortStandings() {
		Collections.sort(pool);
		tieCheck(pool);
	}

	/**
	 * Returns an ArrayList<team> of teams from pool sorted by the number of times the team placed top three in a simulation adding a match
	 * @return ArrayList<team> sorted ArrayList of teams by the number of times they get top three after a match was added
	 */
	public ArrayList<team> sortByTop3Sim() {
		ArrayList<team> ret = new ArrayList<team>();
		ret.addAll(pool);
		Collections.sort(ret, new Comparator<team>() {

			@Override
			public int compare(team o1, team o2) {
				if(o1.getTop3PerSim() > o2.getTop3PerSim()) {
					return -1;
				}

				return 1;
			}

		});

		return ret;
	}
	/**
	 * Returns an ArrayList<team> of teams from pool sorted by the number of times the team placed top three in a simulation
	 * @return ArrayList<team> sorted ArrayList of teams by the number of times they get top three 
	 */
	public ArrayList<team> sortByTop3() {
		ArrayList<team> ret = new ArrayList<team>();
		ret.addAll(pool);
		Collections.sort(ret, new Comparator<team>() {

			@Override
			public int compare(team o1, team o2) {
				if(o1.getTop3Per() > o2.getTop3Per()) {
					return -1;
				}

				return 1;
			}

		});

		return ret;
	}

	/**
	 * Returns an ArrayList<team> of teams from pool sorted by the number of times they got each place in the pool from 1st to 6th
	 * @return ArrayList<team> sorted ArrayList of teams by the number of times they get each seed in the pool
	 */
	public ArrayList<team> sortBySimPer() {
		ArrayList<team> ret = new ArrayList<team>();
		ret.addAll(pool);
		Collections.sort(ret, new Comparator<team>() {

			@Override
			public int compare(team o1, team o2) {
				if(o1.getPlacings().get(0) > o2.getPlacings().get(0)) {
					return -1;
				}
				else if(o1.getPlacings().get(0).equals(o2.getPlacings().get(0))) {
					//System.out.println("Tied at 1st place odds");
					if(o1.getPlacings().get(1) > o2.getPlacings().get(1)) {
						return -1;
					}
					else if(o1.getPlacings().get(1).equals(o2.getPlacings().get(1))) {
						//System.out.println("Tied at 2nd place odds");
						if(o1.getPlacings().get(2) > o2.getPlacings().get(2)) {
							return -1;
						}
						else if(o1.getPlacings().get(2).equals(o2.getPlacings().get(2))) {
							//System.out.println("Tied at 3rd place odds");
							if(o1.getPlacings().get(3) > o2.getPlacings().get(3)) {
								return -1;
							}
							else if(o1.getPlacings().get(3).equals(o2.getPlacings().get(3))) {
								//System.out.println("Tied at 4th place odds");
								if(o1.getPlacings().get(4) > o2.getPlacings().get(4)) {
									return -1;
								}
								else if(o1.getPlacings().get(4).equals(o2.getPlacings().get(4))) {
									if(o1.getPlacings().get(5) > o2.getPlacings().get(5)) {
										return -1;
									}
									else if(o1.getPlacings().get(5).equals(o2.getPlacings().get(5))) {
										return 0;
									}
								}
							}
						}
					}
				}

				return 1;
			}

		});

		return ret;
	}
	
	/**
	 * Sets a two-way tie between two teams at indexes x and y in the pool ArrayList
	 * @param x int index of team A
	 * @param y int index of team B
	 */
	private void setTies(int x, int y) {
		int twoWay = 2;
		pool.get(x).setTie(true,twoWay);
		pool.get(y).setTie(true,twoWay);;
	}

	/**
	 * Calls functions that check for each possible tie situation in order to reorder an ArrayList of teams to accommodate for
	 * tie breakers. 
	 * @param p ArrayList<team> list of teams to be sorted
	 */
	private void tieCheck(ArrayList<team> p) {

		int indexA=0;
		int[] wins = new int[6];
		int[] loses = new int[6];
		double winsSum=0;
		double losesSum=0;
		for(team i: p) {
			wins[indexA] = i.getmatchW();
			winsSum+=i.getmatchW();
			loses[indexA] = i.getmatchL();
			losesSum+=i.getmatchL();
			indexA++;
		}

		if(winsSum/6 == p.get(0).getmatchW() && losesSum/6 == p.get(0).getmatchL()) {
			//System.out.println("Six Way Tie");
			sixWayTie(p);
		}

		twoWayTie(wins,loses,p);
		threeWayTie(wins,loses,p);
		fourWayTie(wins,loses,p);
		fiveWayTie(wins,loses,p);


	}

	/**
	 * Iterates through arrays of wins and loses per team to find a dead tie between only two teams. Sends the index of the second
	 * team that is tied to splitTwoWay(int, ArrayList<team>)
	 * @param wins int[] array of wins in order of ArrayList<team>
	 * @param loses int[] array of loses in order of ArrayList<team>
	 * @param p ArrayList<team> list of teams to iterate though and sort
	 */
	private void twoWayTie(int[] wins,int[] loses, ArrayList<team>p) {
		//two way ties
		for(int i =2;i<p.size();i++) {
			if(i==2) {
				if(wins[i-2]==wins[i-1]&&loses[i-2]==loses[i-1]&&(wins[i-2]!=wins[i]||loses[i-2]!=loses[i])) {
					//System.out.println("Two Way tie for first");
					splitTwoWay(i-1,p);
				}
			}
			else if(wins[i-1]==wins[i-2] && loses[i-1]==loses[i-2]&&
					(wins[i-1]!=wins[i]||loses[i-1]!=loses[i]) && 
					(wins[i-3]!=wins[i-2]  ||loses[i-3]!=loses[i-2])) {
				//System.out.println("WE HAVE A Two Way TIE in the middle");
				//Break the tie
				splitTwoWay(i-1,p);


			}
			if(i==p.size()-2) {
				if(wins[i]==wins[i+1] && loses[i]==loses[i+1]
						&&(wins[i]!=wins[i-1]||loses[i]!=loses[i-1])) {
					//System.out.println("WE HAVE A Two Way TIE for last");
					//Break the tie
					//System.out.println(p.get(i+1).getMatches());
					splitTwoWay(i+1,p);

				}

			}
		}
	}
	/**
	 * To split a two way tie, the match between the two teams is found and the winner of that match takes precedence.
	 * The match is found using the lower team of the pool, if the mapA of the match is equal to three, then the lower team beat
	 * the higher team. So, the teams flip. 
	 * @param i int index of the lower team of the tie
	 * @param p ArrayList<team> pool of teams to be used
	 */
	private void splitTwoWay(int i, ArrayList<team>p) {
		for(Match m: p.get(i).getMatches()) {
			if(m.findMatch(p.get(i-1).getName())) {
				//System.out.println(m);
				//Haven't played each other
				if(m.getMapA()==0&&m.getMapB()==0) {
					double winper1 = p.get(i-1).getmapWinper();
					double winper2 = p.get(i).getmapWinper();
					//System.out.println(winper1 + " " + winper2);
					if(winper2>winper1) {
						Collections.swap(p, i-1, i);
					}
					else if(winper2==winper1) {
						setTies(i-1,i);
					}
				}
				//Played each other
				else if(m.getMapA()==3){
					//System.out.println("played each other ");
					Collections.swap(p, i, i-1);
				}
			}
		}
	}

	/**
	 * Iterates though the given wins[] and loses[] to find a three way tie. Uses splitThree(int, ArrayList<team>) with the index
	 * of the team immediately after the tie. 
	 * @param wins int[] array of wins in order of ArrayList<team>
	 * @param loses int[] array of loses in order of ArrayList<team>
	 * @param p ArrayList<team> list of teams to iterate though and sort
	 */
	private void threeWayTie(int[] wins, int[] loses, ArrayList<team>p) {

		for(int i = 3;i<pool.size();i++) {
			if(i==3) {
				if(wins[i-3]==wins[i-2]&&wins[i-2]==wins[i-1]&&
						loses[i-3]==loses[i-2]&&loses[i-2]==loses[i-1]&&
						(wins[i-1]!=wins[i]||loses[i-1]!=loses[i])){
					//System.out.println("Three Way Tie for first");	
					splitThreeWay(i,p);
				}
			}
			else if(wins[i-3]==wins[i-2]&&wins[i-2]==wins[i-1]&&
					loses[i-3]==loses[i-2]&&loses[i-2]==loses[i-1]&&
					(wins[i-1]!=wins[i]||loses[i-1]!=loses[i])&&
					(wins[i-4]!=wins[i-3] || loses[i-4]!=loses[i-3])){
				//System.out.println("Three Way Tie in the middle");
				splitThreeWay(i,p);
			}
			if(i==pool.size()-1){
				if(wins[i-2]==wins[i-1]&&wins[i-1]==wins[i]&&
						loses[i-2]==loses[i-1]&&loses[i-1]==loses[i]&&
						(wins[i]!=wins[i-3]||loses[i]!=loses[i-3])){
					//System.out.println("Three Way Tie for last");	
					splitThreeWay(i+1,p);
				}
			}

		}
	}
	/**
	 * Saves the match and map wins and loses of the three teams prior to index i. In order to break a three way tie, the match records between
	 * the three teams are used and sorted. If all three are 1-1 verse each other, the map counts of their matches verse each other are used. 
	 * If there is a match map tie, overall map counts are used to sort. Any overall map count tie is a dead tie that would require
	 * a sudden death map. 
	 * @param i int index of the team immediately following the three way tie
	 * @param p ArrayList<team> list to be used to sort
	 */
	private void splitThreeWay(int i, ArrayList<team> p) {

		String teamA = p.get(i-3).getName(); int winsA=0; int losesA=0; int mapsWA=0;int mapsLA=0; 
		double matchWinPerA = 0; double mapWinPerA=0;
		String teamB = p.get(i-2).getName(); int winsB=0; int losesB=0; int mapsWB=0; int mapsLB=0; 
		double matchWinPerB = 0;double mapWinPerB=0;
		String teamC = p.get(i-1).getName(); int winsC=0; int losesC=0; int mapsWC=0; int mapsLC=0;
		double matchWinPerC = 0;double mapWinPerC=0;

		for(int x =0;x<p.get(i-3).getMatches().size();x++) {
			if(p.get(i-3).getMatches().get(x).findMatch(teamB)||
					p.get(i-3).getMatches().get(x).findMatch(teamC)) {

				mapsWA += p.get(i-3).getMatches().get(x).getMapA(); 
				mapsLA += p.get(i-3).getMatches().get(x).getMapB();
				if(p.get(i-3).getMatches().get(x).getMapA()==3) { 
					winsA++; 
				} 
				else if(p.get(i-3).getMatches().get(x).getMapB()==3){ 
					losesA++;
				}


			} 
		}
		for(int x =0;x<p.get(i-2).getMatches().size();x++) {
			if(p.get(i-2).getMatches().get(x).findMatch(teamA)||
					p.get(i-2).getMatches().get(x).findMatch(teamC)) {

				mapsWB += p.get(i-2).getMatches().get(x).getMapA(); 
				mapsLB += p.get(i-2).getMatches().get(x).getMapB();
				if(p.get(i-2).getMatches().get(x).getMapA()==3) { 
					winsB++; 
				} 
				else if(p.get(i-2).getMatches().get(x).getMapB()==3){ 
					losesB++;
				}


			} 
		}
		for(int x =0;x<p.get(i-1).getMatches().size();x++) {
			if(p.get(i-1).getMatches().get(x).findMatch(teamB)||
					p.get(i-1).getMatches().get(x).findMatch(teamA)) {

				mapsWC += p.get(i-1).getMatches().get(x).getMapA(); 
				mapsLC += p.get(i-1).getMatches().get(x).getMapB();
				if(p.get(i-1).getMatches().get(x).getMapA()==3) { 
					winsC++; 
				} 
				else if(p.get(i-1).getMatches().get(x).getMapB()==3){ 
					losesC++;
				}


			} 
		}
		if(mapsWA+mapsLA==0) {
			matchWinPerA = 0; mapWinPerA =0;
		}
		else {
			mapWinPerA= (double) mapsWA/(mapsWA+mapsLA);
		}
		if(mapsWB+mapsLB==0) {
			matchWinPerB = 0; mapWinPerB =0;
		}
		else {
			mapWinPerB= (double) mapsWB/(mapsWB+mapsLB);
		}
		if(mapsWC+mapsLC==0) {
			matchWinPerC = 0; mapWinPerC =0;
		}
		else {
			mapWinPerC= (double) mapsWC/(mapsWC+mapsLC);
		}
		matchWinPerA = (double) winsA /(winsA+losesA);
		matchWinPerB = (double) winsB /(winsB+losesB);
		matchWinPerC = (double) winsC /(winsC+losesC);


		/*
		 * System.out.println( p.get(i-3).name + " " + winsA + "-" + losesA + "(" +
		 * matchWinPerA+ ") MAP " + mapsWA + "-" +mapsLA+"(" + mapWinPerA+ ")");
		 * System.out.println( p.get(i-2).name + " " + winsB + "-" + losesB +"(" +
		 * matchWinPerB+ ")  MAP " +mapsWB + "-" +mapsLB+"(" + mapWinPerB+ ")");
		 * System.out.println( p.get(i-1).name + " " + winsC + "-" + losesC + "(" +
		 * matchWinPerC+ ") MAP " +mapsWC + "-" +mapsLC+"(" + mapWinPerC+ ")");
		 */

		double pmapA = p.get(i-3).getmapWinper();
		double pmapB = p.get(i-2).getmapWinper();
		double pmapC = p.get(i-1).getmapWinper();



		//Tie in match count
		if(matchWinPerA == matchWinPerB && matchWinPerB == matchWinPerC) {
			//Tie in map count
			if(mapWinPerA == mapWinPerB && mapWinPerB == mapWinPerC) {

				//System.out.println(pmapA + " " + pmapB + " " + pmapC);
				//tie p map count
				if(pmapA==pmapB && pmapB==pmapC) {
					p.get(i-3).setTie(true,3);
					p.get(i-2).setTie(true,3);
					p.get(i-1).setTie(true,3);
				}



				//one better map count 
				else if(pmapA>pmapB && pmapA>pmapC) {
					if(pmapB==pmapC) {
						setTies(i-2,i-1);
					}
					else if(pmapB < pmapC) {
						Collections.swap(p,i-2,i-1);
					}

				}
				else if(pmapB>pmapA && pmapB>pmapC) {
					Collections.swap(p,i-3,i-2);
					if(pmapA==pmapC) {
						setTies(i-2,i-1);
					}
					else if(pmapA < pmapC) {
						Collections.swap(p,i-2,i-1);
					}
				}
				else if(pmapC>pmapA && pmapC>pmapB) {
					Collections.swap(p,i-1,i-2);
					Collections.swap(p,i-2,i-3);
					if(pmapA==pmapB) {
						setTies(i-2,i-1);
					}
					else if(pmapA < pmapB) {
						Collections.swap(p,i-2,i-1);
					}


				}
				//one worse map count 
				else if(pmapA<pmapB && pmapA<pmapC) {
					Collections.swap(p, i-3, i-2);
					Collections.swap(p, i-2, i-1);
					if(pmapB==pmapC) {
						setTies(i-3,i-2);
					}

				}
				else if(pmapB<pmapA && pmapB<pmapC) {
					Collections.swap(p, i-1, i-2);
					if(pmapA==pmapC) {
						setTies(i-3,i-2);
					}
				}
				else if(pmapC<pmapA && pmapC<pmapB) {
					if(pmapA==pmapB) {
						setTies(i-2,i-3);
					}
				}
			}
			//different map counts
			if(mapWinPerA>mapWinPerB && mapWinPerA>mapWinPerC) {
				if(mapWinPerB==mapWinPerC) {
					setTies(i-1,i-2);
				}
				else if(mapWinPerC>mapWinPerB) {
					Collections.swap(p, i-1, i-2);
				}
			}
			else if(mapWinPerB>mapWinPerA && mapWinPerB>mapWinPerC) {
				Collections.swap(p,i-2,i-3);
				if(mapWinPerA==mapWinPerC) {
					setTies(i-1,i-2);
				}
				else if(mapWinPerC>mapWinPerA) {
					Collections.swap(p, i-1, i-2);
				}
			}
			else if(mapWinPerC>mapWinPerB && mapWinPerC>mapWinPerA) {
				Collections.swap(p, i-1, i-2);
				Collections.swap(p, i-3, i-2);
				if(mapWinPerB==mapWinPerA) {
					setTies(i-1,i-2);
				}
				else if(mapWinPerB>mapWinPerA) {
					Collections.swap(p, i-1, i-2);
				}
			}

		}
		//different records
		else if(matchWinPerA>matchWinPerB && matchWinPerA>matchWinPerC) {
			if(matchWinPerC>matchWinPerB) {
				Collections.swap(p,i-2,i-1);
			}
		}
		else if(matchWinPerB>matchWinPerA && matchWinPerB>matchWinPerC) {
			Collections.swap(p,i-2,i-3);
			if(matchWinPerC>matchWinPerA) {
				Collections.swap(p,i-2,i-1);
			}
		}
		else if(matchWinPerC>matchWinPerA && matchWinPerC>matchWinPerB) {
			Collections.swap(p,i-2,i-3);
			Collections.swap(p,i-1,i-3);
			if(matchWinPerB>matchWinPerA) {
				Collections.swap(p,i-2,i-1);
			}
		}


	}

	/**
	 * Iterates though the given wins[] and loses[] to find a four way tie. Uses splitThree(int, ArrayList<team>) with the index
	 * of the team immediately after the tie. 
	 * @param wins int[] array of wins in order of ArrayList<team>
	 * @param loses int[] array of loses in order of ArrayList<team>
	 * @param p ArrayList<team> list of teams to iterate though and sort
	 */
	private void fourWayTie(int[] wins, int[] loses, ArrayList<team>p) {
		for(int i=4;i<p.size();i++) {
			if(i==4) {
				if(wins[i-4]==wins[i-3]&&wins[i-3]==wins[i-2] && wins[i-2]==wins[i-1]&&
						loses[i-4]==loses[i-3]&&loses[i-3]==loses[i-2] && loses[i-2]==loses[i-1]&&
						(wins[i-1]!=wins[i]||loses[i-1]!=loses[i])){

					//System.out.println("Four way tie for first");
					splitFourWay(i,p);
				}	
			}
			else if(i==5) {
				if(wins[i-4]==wins[i-3]&&wins[i-3]==wins[i-2] && wins[i-2]==wins[i-1]&&
						loses[i-4]==loses[i-3]&&loses[i-3]==loses[i-2] && loses[i-2]==loses[i-1]&&
						(wins[i-1]!=wins[i]||loses[i-1]!=loses[i])&&(wins[i-5]!=wins[i-1]||loses[i-5]!=loses[i-1])){
					//System.out.println("Four way tie middle");
					splitFourWay(i,p);
				}
				if(wins[i]==wins[i-3]&&wins[i-3]==wins[i-2] && wins[i-2]==wins[i-1]&&
						loses[i]==loses[i-3]&&loses[i-3]==loses[i-2] && loses[i-2]==loses[i-1]&&
						(wins[i]!=wins[i-4]||loses[i-4]!=loses[i])){
					//System.out.println("Four way tie End");
					splitFourWay(i+1,p);
				}

			}

		}
	}

	/**
	 * Saves the match and map wins and loses of the four teams prior to index i. In order to break a four way tie, the match records between
	 * the four teams are used and sorted. The internal match records are used to sort. There are two tie situations with four teams. One team 
	 * is 3-0/0-3 and the others are all tied or there are two 2-1/1-2 ties. For each tie the map counts of their matches verse each other 
	 * are used. If there is a match map tie, overall map counts are used to sort. Any overall map count tie is a dead tie that would require 
	 * a sudden death map. 
	 * @param i int index of team immediately following four way tie
	 * @param p ArrayList<team> list of teams to sort
	 */
	private void splitFourWay(int i, ArrayList<team>p) {
		String teamA = p.get(i-4).getName(); int winsA=0; int losesA=0; int mapsWA=0;int mapsLA=0; 
		double matchWinPerA = 0; double mapWinPerA=0;
		String teamB = p.get(i-3).getName(); int winsB=0; int losesB=0; int mapsWB=0; int mapsLB=0; 
		double matchWinPerB = 0;double mapWinPerB=0;
		String teamC = p.get(i-2).getName(); int winsC=0; int losesC=0; int mapsWC=0; int mapsLC=0;
		double matchWinPerC = 0;double mapWinPerC=0;
		String teamD = p.get(i-1).getName(); int winsD=0; int losesD=0; int mapsWD=0; int mapsLD=0;
		double matchWinPerD = 0;double mapWinPerD=0;

		for(int x =0;x<p.get(i-4).getMatches().size();x++) {
			if(p.get(i-4).getMatches().get(x).findMatch(teamB)||
					p.get(i-4).getMatches().get(x).findMatch(teamC)||
					p.get(i-4).getMatches().get(x).findMatch(teamD)) {

				mapsWA += p.get(i-4).getMatches().get(x).getMapA(); 
				mapsLA += p.get(i-4).getMatches().get(x).getMapB();
				if(p.get(i-4).getMatches().get(x).getMapA()==3) { 
					winsA++; 
				} 
				else if(p.get(i-4).getMatches().get(x).getMapB()==3){ 
					losesA++;
				}


			} 
		}

		for(int x =0;x<p.get(i-3).getMatches().size();x++) {
			if(p.get(i-3).getMatches().get(x).findMatch(teamA)||
					p.get(i-3).getMatches().get(x).findMatch(teamC)||
					p.get(i-3).getMatches().get(x).findMatch(teamD)) {

				mapsWB += p.get(i-3).getMatches().get(x).getMapA(); 
				mapsLB += p.get(i-3).getMatches().get(x).getMapB();
				if(p.get(i-3).getMatches().get(x).getMapA()==3) { 
					winsB++; 
				} 
				else if(p.get(i-3).getMatches().get(x).getMapB()==3){ 
					losesB++;
				}


			} 
		}
		for(int x =0;x<p.get(i-2).getMatches().size();x++) {
			if(p.get(i-2).getMatches().get(x).findMatch(teamA)||
					p.get(i-2).getMatches().get(x).findMatch(teamB)||
					p.get(i-2).getMatches().get(x).findMatch(teamD)) {

				mapsWC += p.get(i-2).getMatches().get(x).getMapA(); 
				mapsLC += p.get(i-2).getMatches().get(x).getMapB();
				if(p.get(i-2).getMatches().get(x).getMapA()==3) { 
					winsC++; 
				} 
				else if(p.get(i-2).getMatches().get(x).getMapB()==3){ 
					losesC++;
				}


			} 
		}
		for(int x =0;x<p.get(i-1).getMatches().size();x++) {
			if(p.get(i-1).getMatches().get(x).findMatch(teamB)||
					p.get(i-1).getMatches().get(x).findMatch(teamA)||
					p.get(i-1).getMatches().get(x).findMatch(teamC)) {

				mapsWD += p.get(i-1).getMatches().get(x).getMapA(); 
				mapsLD += p.get(i-1).getMatches().get(x).getMapB();
				if(p.get(i-1).getMatches().get(x).getMapA()==3) { 
					winsD++; 
				} 
				else if(p.get(i-1).getMatches().get(x).getMapB()==3){ 
					losesD++;
				}


			} 
		}
		if(mapsWA+mapsLA==0) {
			matchWinPerA = 0; mapWinPerA =0;
		}
		else {
			mapWinPerA= (double) mapsWA/(mapsWA+mapsLA);
		}
		if(mapsWB+mapsLB==0) {
			matchWinPerB = 0; mapWinPerB =0;
		}
		else {
			mapWinPerB= (double) mapsWB/(mapsWB+mapsLB);
		}
		if(mapsWC+mapsLC==0) {
			matchWinPerC = 0; mapWinPerC =0;
		}
		else {
			mapWinPerC= (double) mapsWC/(mapsWC+mapsLC);
		}
		if(mapsWD+mapsLD==0) {
			matchWinPerD = 0; mapWinPerD =0;
		}
		else {
			mapWinPerD= (double) mapsWD/(mapsWD+mapsLD);
		}
		matchWinPerA = (double) winsA /(winsA+losesA);
		matchWinPerB = (double) winsB /(winsB+losesB);
		matchWinPerC = (double) winsC /(winsC+losesC);
		matchWinPerD = (double) winsD /(winsD+losesD);



		/*
		 * System.out.println( p.get(i-4).name + " " + winsA + "-" + losesA + "(" +
		 * matchWinPerA+ ") MAP " + mapsWA + "-" +mapsLA+"(" + mapWinPerA+ ")");
		 * System.out.println( p.get(i-3).name + " " + winsB + "-" + losesB +"(" +
		 * matchWinPerB+ ")  MAP " +mapsWB + "-" +mapsLB+"(" + mapWinPerB+ ")");
		 * System.out.println( p.get(i-2).name + " " + winsC + "-" + losesC + "(" +
		 * matchWinPerC+ ") MAP " +mapsWC + "-" +mapsLC+"(" + mapWinPerC+ ")");
		 * System.out.println( p.get(i-1).name + " " + winsD + "-" + losesD + "(" +
		 * matchWinPerD+ ") MAP " +mapsWD + "-" +mapsLD+"(" + mapWinPerD+ ")");
		 */


		double poolmapA = p.get(i-4).getmapWinper();
		double poolmapB = p.get(i-3).getmapWinper();
		double poolmapC = p.get(i-2).getmapWinper();
		double poolmapD = p.get(i-1).getmapWinper();

		//Three Way ties


		///Team A is 3-0 implying all other teams are 1-2
		if(matchWinPerA> matchWinPerB && matchWinPerA > matchWinPerC && matchWinPerA > matchWinPerD) {
			//tie in map counts
			threeSplitTies(mapWinPerB,mapWinPerC,mapWinPerD,poolmapB,poolmapC,poolmapD,i,p);
		}
		//Team B is 3-0 implying all other teams are 1-2
		else if(matchWinPerB> matchWinPerA && matchWinPerB > matchWinPerC && matchWinPerB > matchWinPerD) {
			Collections.swap(p, i-4, i-3);
			threeSplitTies(mapWinPerA,mapWinPerC,mapWinPerD,poolmapA,poolmapC,poolmapD,i,p);
		}
		//Team C is 3-0 implying all other teams are 1-2
		else if(matchWinPerC> matchWinPerB && matchWinPerC > matchWinPerA && matchWinPerC > matchWinPerD) {
			Collections.swap(p, i-3, i-2);
			Collections.swap(p, i-4, i-3);				
			threeSplitTies(mapWinPerA,mapWinPerB,mapWinPerD,poolmapA,poolmapB,poolmapD,i,p);
		}
		//Team D is 3-0 implying all other teams are 1-2
		else if(matchWinPerD> matchWinPerB && matchWinPerD > matchWinPerC && matchWinPerD > matchWinPerA) {
			Collections.swap(p, i-2, i-1);
			Collections.swap(p, i-3, i-2);
			Collections.swap(p, i-4, i-3);
			threeSplitTies(mapWinPerA,mapWinPerB,mapWinPerC,poolmapA,poolmapB,poolmapC,i,p);
		}

		//Team A is 0-3 implying all other teams are 2-1
		else if(matchWinPerA< matchWinPerB && matchWinPerA < matchWinPerC && matchWinPerA < matchWinPerD) {
			Collections.swap(p, i-4, i-3);
			Collections.swap(p, i-3, i-2);
			Collections.swap(p, i-2, i-1);
			threeSplitTies(mapWinPerB,mapWinPerC,mapWinPerD,poolmapB,poolmapC,poolmapD,i-1,p);
		}
		//Team B is 0-3 implying all other teams are 2-1
		else if(matchWinPerB< matchWinPerA && matchWinPerB < matchWinPerC && matchWinPerB < matchWinPerD) {
			Collections.swap(p, i-3, i-2);
			Collections.swap(p, i-2, i-1);
			threeSplitTies(mapWinPerA,mapWinPerC,mapWinPerD,poolmapA,poolmapC,poolmapD,i-1,p);
		}
		//Team C is 0-3 implying all other teams are 2-1
		else if(matchWinPerC < matchWinPerB && matchWinPerC < matchWinPerA && matchWinPerC < matchWinPerD) {
			Collections.swap(p, i-1, i-2);			
			threeSplitTies(mapWinPerA,mapWinPerB,mapWinPerD,poolmapA,poolmapB,poolmapD,i-1,p);
		}
		//Team D is 0-3 implying all other teams are 2-1
		else if(matchWinPerD < matchWinPerB && matchWinPerD < matchWinPerC && matchWinPerD < matchWinPerA) {
			threeSplitTies(mapWinPerA,mapWinPerB,mapWinPerC,poolmapA,poolmapB,poolmapC,i-1,p);
		}


		//A leads
		else if(matchWinPerA>=matchWinPerB && matchWinPerA>=matchWinPerC && matchWinPerA>=matchWinPerD) {			
			fourWaySort(matchWinPerA,matchWinPerB,matchWinPerC,matchWinPerD,
					mapWinPerA,mapWinPerB,mapWinPerC,mapWinPerD,
					poolmapA,poolmapB,poolmapC,poolmapD,i,p);

		}

		//B leads
		else if(matchWinPerB>=matchWinPerA && matchWinPerB>=matchWinPerC && matchWinPerB>=matchWinPerD) {
			Collections.swap(p,i-4,i-3);
			fourWaySort(matchWinPerB,matchWinPerA,matchWinPerC,matchWinPerD,
					mapWinPerB,mapWinPerA,mapWinPerC,mapWinPerD,
					poolmapB,poolmapA,poolmapC,poolmapD,i,p);
		}
		//C is best
		else if(matchWinPerC>=matchWinPerA && matchWinPerC>=matchWinPerB && matchWinPerC>=matchWinPerD) {
			Collections.swap(p,i-4,i-3);
			Collections.swap(p,i-4,i-2);
			fourWaySort(matchWinPerC,matchWinPerA,matchWinPerB,matchWinPerD,
					mapWinPerC,mapWinPerA,mapWinPerB,mapWinPerD,
					poolmapC,poolmapA,poolmapB,poolmapD,i,p);
		}
		//D is best
		else if(matchWinPerD>=matchWinPerA && matchWinPerD>=matchWinPerB && matchWinPerD>=matchWinPerC) {
			System.out.println("DIDNT THINK THIS WOULD HAPPEN");
			Collections.swap(p,i-4,i-3);
			Collections.swap(p,i-4,i-2);
			Collections.swap(p,i-4,i-1);
			fourWaySort(matchWinPerD,matchWinPerA,matchWinPerB,matchWinPerC,
					mapWinPerD,mapWinPerA,mapWinPerB,mapWinPerC,
					poolmapD,poolmapA,poolmapB,poolmapC,i,p);
		}
	}
	/**
	 * Called from a four way tie break. This is when one team is 3-0 or 0-3. This function is used to sort the remaining teams by
	 * internal map counts and overall map counts.
	 * @param match1 double match map percentage of team A
	 * @param match2 double match map percentage of team B
	 * @param match3 double match map percentage of team C
	 * @param pool1 double overall pool percentage of team A
	 * @param pool2 double overall pool percentage of team B
	 * @param pool3 double overall pool percentage of team C
	 * @param i index of the team immediately following the three way tie
	 * @param p ArrayList<team> list of teams to sort
	 */
	private void threeSplitTies(double match1,double match2,double match3, double pool1,double pool2, double pool3,int i, ArrayList<team>p) {
		if(match1==match2 && match1==match3) {
			splitThreeWayMatchTie(pool1,pool2,pool3,i,p);
		}
		//Two way ties with better records than the third
		else if(match1==match3 && match1>match2) {
			Collections.swap(p, i-1, i-2);
			if(pool1==pool3) {
				setTies(i-2,i-3);
			}
			else if(pool3>pool1) {
				Collections.swap(p,i-3,i-2);
			}
		}
		else if(match1==match2 && match1>match3) {
			if(pool1==pool2) {
				setTies(i-2,i-3);
			}
			else if(pool2>pool1) {
				Collections.swap(p,i-3,i-2);
			}
		}
		else if(match2==match3 && match2>match1) {
			Collections.swap(p, i-3, i-2);
			Collections.swap(p, i-2, i-1);
			if(pool2==pool3) {
				setTies(i-2,i-3);
			}
			else if(pool3>pool2) {
				Collections.swap(p,i-3,i-2);
			}
		}
		//Two way ties worse than the third
		else if(match1>match3 && match1>match2) {
			if(pool2==pool3) {
				setTies(i-1,i-2);
			}
			else if(pool3>pool2) {
				Collections.swap(p,i-1,i-2);
			}
		}
		else if(match2>match1 && match2>match3) {
			Collections.swap(p, i-3, i-2);
			if(pool3==pool1) {
				setTies(i-2,i-1);
			}
			else if(pool3>pool1) {
				Collections.swap(p,i-1,i-2);
			}
		}
		else if(match3>match2 && match3>match1) {
			Collections.swap(p, i-1, i-2);
			Collections.swap(p, i-2, i-3);
			if(pool1==pool2) {
				setTies(i-1,i-2);
			}
			else if(pool2>pool1) {
				Collections.swap(p,i-1,i-2);
			}
		}
	}
	/**
	 * Used to break a three way tie where the teams have the same internal match count and map count. Break the three way tie of 
	 * overall pool map count. 
	 * @param pool1 double overall pool map percentage of team A
	 * @param pool2 double overall pool map percentage of team B
	 * @param pool3 double overall pool map percentage of team C
	 * @param i index of the team immediately following the three way tie
	 * @param p ArrayList<team> list of teams to sort
	 */
	private void splitThreeWayMatchTie(double pool1, double pool2, double pool3, int i, ArrayList<team>p) {
		//All three the same p record	
		if(pool2==pool1 && pool2==pool3) {
			p.get(i-3).setTie(true,3);
			p.get(i-2).setTie(true,3);
			p.get(i-1).setTie(true,3);
		}
		//1 strictly greater than 
		else if(pool1>pool2 && pool1>pool3) {
			if(pool2==pool3) {
				setTies(i-1,i-2);
			}
			else if(pool3>pool2) {
				Collections.swap(p, i-1, i-2);
			}
		}
		//1 = 2 > 3
		else if(pool1==pool2 && pool1>pool3) {
			setTies(i-3,i-2);
		}
		//1 = 3 > 2
		else if(pool1==pool3 && pool1>pool2) {
			Collections.swap(p,i-1,i-2);
			setTies(i-3,i-2);
		}
		//2 strictly greater than 
		else if(pool2>pool1 && pool2>pool3) {
			Collections.swap(p, i-3, i-2);
			if(pool1==pool3) {
				setTies(i-1,i-2);
			}
			else if(pool3>pool1) {
				Collections.swap(p, i-1, i-2);
			}
		}
		//2 = 3 > 1
		else if(pool2==pool3 && pool2>pool1) {
			Collections.swap(p, i-3, i-2);
			Collections.swap(p, i-2, i-1);
			setTies(i-3,i-2);
		}
		//3 strictly greater than 
		else if(pool3>pool1 && pool3>pool2) {
			Collections.swap(p, i-1, i-2);
			Collections.swap(p, i-2, i-3);
			if(pool1==pool2) {
				setTies(i-1,i-2);
			}
			else if(pool2>pool1) {
				Collections.swap(p, i-1, i-2);
			}
		}


	}

	/**
	 * Used to break four way ties where there are two duos with similar records (two 2-1 and two 1-2 teams). Uses internal match, internal map,
	 * and pool map counts to determine order. A team with a 2-1 record is always given first. Finds the other 2-1 team and breaks the 
	 * two sets of ties.
	 * @param match1 double internal match record of team A
	 * @param match2 double internal match record of team B
	 * @param match3 double internal match record of team C
	 * @param match4 double internal match record of team D
	 * @param map1 double internal map record of team A
	 * @param map2 double internal map record of team B
	 * @param map3 double internal map record of team C
	 * @param map4 double internal map record of team D
	 * @param pool1 double overall map record of team A
	 * @param pool2 double overall map record of team B
	 * @param pool3 double overall map record of team C
	 * @param pool4 double overall map record of team D
	 * @param i int index of team immediately following the set of ties
	 * @param p ArrayList<team> set of teams to sort
	 */
	private void fourWaySort(double match1, double match2, double match3, double match4, 
			double map1, double map2, double map3, double map4,
			double pool1, double pool2, double pool3, double pool4,int i, ArrayList<team>p) {
		//1 >= 2 > 3 >= 4
		if(match2>match3 && match2>match4) {
			if(match3==match4) {
				if(map4==map3) {
					if(pool4==pool3) {
						setTies(i-1,i-2);
					}
					else if(pool4>pool3) {
						Collections.swap(p,i-1,i-2);
					}
				}
				else if(map4>map3) {
					Collections.swap(p,i-1,i-2);
				}

			}
			if(match1==match2) {
				if(map2==map1) {
					if(pool2==pool1) {
						setTies(i-3,i-4);
					}
					else if(pool2>pool1) {
						Collections.swap(p,i-3,i-4);
					}
				}
				else if(map2>map1) {
					Collections.swap(p,i-4,i-3);
				}
			}
		}

		// 1 >= 4 > 2 >= 3
		else if(match2>=match3 && match2<match4) {
			Collections.swap(p,i-2,i-1);
			Collections.swap(p,i-3,i-2);
			if(match3==match2) {
				if(map2==map3) {
					if(pool2==pool3) {
						setTies(i-1,i-2);
					}
					else if(pool2<pool3) {
						Collections.swap(p,i-1,i-2);
					}
				}
				else if(map2<map3) {
					Collections.swap(p,i-1,i-2);
				}

			}
			if(match1==match4) {
				if(map4==map1) {
					if(pool4==pool1) {
						setTies(i-3,i-4);
					}
					else if(pool4>pool1) {
						Collections.swap(p,i-3,i-4);
					}
				}
				else if(map4>map1) {
					Collections.swap(p,i-4,i-3);
				}
			}

		}
		//1 >= 3 > 2 >= 4
		else if(match2<match3 && match2>=match4) {
			Collections.swap(p,i-3,i-2);
			if(match4==match2) {
				if(map2==map4) {
					if(pool2==pool4) {
						setTies(i-1,i-2);
					}
					else if(pool2<pool4) {
						Collections.swap(p,i-1,i-2);
					}
				}
				else if(map2<map4) {
					Collections.swap(p,i-1,i-2);
				}

			}
			if(match1==match3) {
				if(map3==map1) {
					if(pool3==pool1) {
						setTies(i-3,i-4);
					}
					else if(pool3>pool1) {
						Collections.swap(p,i-3,i-4);
					}
				}
				else if(map3>map1) {
					Collections.swap(p,i-4,i-3);
				}
			}

		}
	}
	/**
	 * Iterates though the given wins[] and loses[] to find a five way tie. Uses splitFiveWay(int, ArrayList<team>) with the index
	 * of the team immediately after the tie. 
	 * @param wins int[] array of wins in order of ArrayList<team>
	 * @param loses int[] array of loses in order of ArrayList<team>
	 * @param p ArrayList<team> list of teams to iterate though and sort
	 */
	private void fiveWayTie(int[] wins, int[] loses, ArrayList<team>p) {
		int i = 5;
		int start = 0;
		if(wins[i-5]==wins[i-4] && wins[i-4]==wins[i-3] && wins[i-3]==wins[i-2] && wins[i-2]==wins[i-1]&&
				loses[i-5]==loses[i-4] && loses[i-4]==loses[i-3] && loses[i-3]==loses[i-2] && loses[i-2]==loses[i-1]&&
				(wins[i-5]!=wins[i]||wins[i-5]!=loses[i])) {
			splitFiveWay(i,start,p,pool.get(pool.size()-1));
		}
		if(wins[i]==wins[i-4] && wins[i-4]==wins[i-3] && wins[i-3]==wins[i-2] && wins[i-2]==wins[i-1]&&
				loses[i]==loses[i-4] && loses[i-4]==loses[i-3] && loses[i-3]==loses[i-2] && loses[i-2]==loses[i-1]&&
				(wins[i-5]!=wins[i]||wins[i-5]!=loses[i])) {
			start=1;
			splitFiveWay(i,start,p,pool.get(0));
		}
	}
	/**
	 * Iterates through the tied teams and sorts them on internal map count. Checks the pool map counts before setting ties.
	 * @param i int index of team following tie
	 * @param start int index of team that starts the tie
	 * @param p ArrayList<team> list of teams to sort.
	 * @param t team the team that is not amongst the tied teams
	 */
	private void splitFiveWay(int i,int start, ArrayList<team>p,team t) {
		int tieCount = 1;
		double newMapA = 0;
		double newMapB = 0;
		int lastIndex = 0;
		if(start == 0) {
			lastIndex = 5;
		}
		for(int x =start;x<i;x++) {
			newMapA = ((double)p.get(x).getMapW()-p.get(x).findMatch(t.getName()).getMapA())/
					(p.get(x).getMapL()-p.get(x).findMatch(t.getName()).getMapB()+p.get(x).getMapW()-p.get(x).findMatch(t.getName()).getMapA());
			for(int y= x+1;y<lastIndex;y++) {
				newMapB = ((double)p.get(y).getMapW()-p.get(y).findMatch(t.getName()).getMapA())/
						(p.get(y).getMapL()-p.get(y).findMatch(t.getName()).getMapB()+p.get(y).getMapW()-p.get(y).findMatch(t.getName()).getMapA());
				if(newMapA<newMapB || (newMapA==newMapB && p.get(x).getmapWinper()<p.get(y).getmapWinper())) {
					Collections.swap(p, x, y);
				}
			}
		}

		//check for ties

		for(int x = start;x<lastIndex-1;x++) {
			int z=x+1;
			newMapA = ((double)p.get(x).getMapW()-p.get(x).findMatch(t.getName()).getMapA())/
					(p.get(x).getMapL()-p.get(x).findMatch(t.getName()).getMapB()+p.get(x).getMapW()-p.get(x).findMatch(t.getName()).getMapA());
			newMapB = ((double)p.get(z).getMapW()-p.get(z).findMatch(t.getName()).getMapA())/
					(p.get(z).getMapL()-p.get(z).findMatch(t.getName()).getMapB()+p.get(z).getMapW()-p.get(z).findMatch(t.getName()).getMapA());
			
			if(newMapA==newMapB  && p.get(x).getmapWinper()==p.get(z).getmapWinper()) {
				tieCount++;
			}
			if(p.get(x).getmapWinper()!=p.get(x+1).getmapWinper()) {
				if(tieCount!=1) {
					for(int y = x;y>x-tieCount;y--) {
						p.get(y).setTie(true, tieCount);
					}
					tieCount=1;
				}
			}
			if(x==p.size()-2) {
				if(tieCount!=1) {
					for(int y = x+1;y>x-tieCount+1;y--) {
						p.get(y).setTie(true, tieCount);
					}
					tieCount=1;
				}
			}


		}

	}
	/**
	 * Sorts the ArrayList<team> by map win percentage by creating an internal Comparator to sort. After the sort, the teams
	 * are iterated through to check for and apply ties to the teams. 
	 * @param p ArrayList<team> list of teams to sort
	 */
	private void sixWayTie(ArrayList<team> p) {
		//System.out.println("Didnt think this could happen");
		//six way ties
		Collections.sort(p, new Comparator<team>() {

			@Override
			public int compare(team o1, team o2) {
				if(o1.getmapWinper()>o2.getmapWinper()) {
					return -1;
				}
				return 1;
			}

		});
		//check for ties
		int tieCount=1;
		for(int x = 0;x<p.size()-1;x++) {
			if(p.get(x).getmapWinper()==p.get(x+1).getmapWinper()) {
				tieCount++;
			}
			if(p.get(x).getmapWinper()!=p.get(x+1).getmapWinper()) {
				if(tieCount!=1) {
					for(int y = x;y>x-tieCount;y--) {
						p.get(y).setTie(true, tieCount);
					}
					tieCount=1;
				}
			}
			if(x==p.size()-2) {
				if(tieCount!=1) {
					for(int y = x+1;y>x-tieCount+1;y--) {
						p.get(y).setTie(true, tieCount);
					}
					tieCount=1;
				}
			}
		}
	}
	/**
	 * Iterates through the given ArrayList and removes all set ties. 
	 * @param p ArrayList<team> list of teams
	 */
	public void disableTies(ArrayList<team> p) {
		for(team t: p) {
			for(int i = 2; i<7;i++) {
				t.setTie(false,i);
			}

		}
	}
	
	
	public ArrayList<team> getPool() {
		return pool;
	}
	public ArrayList<team> getPoolSim() {
		return poolsim;
	}
	public team getTeam(String t) {
		for(team i: pool) {
			if(i.getName().equals(t)) {
				return i;
			}
		}
		return null;

	}
	public ArrayList<team> getPoolsim() {
		return poolsim;
	}
}
