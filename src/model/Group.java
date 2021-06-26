package model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Group{

	team TeamA;
	team TeamB;
	team TeamC;
	team TeamD;
	team TeamE;
	team TeamF;
	int longName =0;
	ArrayList<team> pool = new ArrayList<team>();
	ArrayList<team> poolsim = new ArrayList<team>();
	final int simulations=100000;
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
public Group(boolean group) {
		
		String A = "Faze";
		String B = "Optic";
		String C = "Thieves";
		String D = "Subliners";
		String E = "Legion";
		String F = "Ravens";
		
		if(group) {
			A="Empire";
			B="Ultra";
			C="Rokkr";
			D="Mutineers";
			E="Guerrillas";
			F="Surge";
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
		if(group) {
//			updateMatch("Ultra", "Mutineers", 2, 3,false);
//			  
//			  updateMatch("Ultra", "Ravens", 3, 0,false);
//			  
//			  updateMatch("Ultra", "Empire", 3, 0,false);
//			  
//			  updateMatch("Subliners", "Mutineers", 3, 2,false);
//			  
//			  updateMatch("Subliners", "Guerrillas", 3, 1,false);
//			  
//			  
//			  updateMatch("Mutineers", "Ravens", 3, 0,false);
//			  updateMatch("Mutineers", "Guerrillas", 3, 1,false);
//			  
//			  updateMatch("Ravens", "Empire", 2, 3,false);
//			  
//			  updateMatch("Guerrillas", "Empire", 0, 3,false);
//			  
//			  updateMatch("Subliners", "Empire", 3, 2,false);
		}
		else {
//			updateMatch("Optic", "Faze", 0, 3,false);
//			updateMatch("Optic","Legion", 3, 1,false); 
//			updateMatch("Optic","Rokkr", 3, 0,false);
//
//
//			updateMatch("Faze", "Surge", 3, 0,false); 
//			updateMatch("Faze","Legion", 3, 1,false);
//
//
//			updateMatch("Thieves","Legion", 2, 3,false);
//			updateMatch("Thieves", "Surge", 3, 2,false);
//
//			updateMatch("Rokkr", "Legion",3, 1,false);
//			updateMatch("Rokkr","Surge",3, 1,false);
//
//
//			updateMatch("Faze","Thieves", 3, 0,false);
			//updateMatch("Optic", "Surge", 2, 3,false);
			//updateMatch("Thieves", "Rokkr", 2, 3,true); 
			//updateMatch("Faze", "Rokkr", 3, 2,false);
			//updateMatch("Optic", "Thieves", 2, 3,false);
		}
		//printStandings(false, pool);

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
	public void updateMatch(String teamA, String teamB, int mapAw, int mapBw) {
		
		getTeam(teamA).updateMatches(teamB, mapAw, mapBw);
		getTeam(teamB).updateMatches(teamA, mapBw, mapAw);
		//System.out.println("Match Updated: " + teamA +" vs " + teamB + " " + mapAw + " - " + mapBw);
	}
	public void updateMatch(String teamA, String teamB, int mapAw, int mapBw, boolean recent) {
		ArrayList<Double> before = new ArrayList<Double>();
		ArrayList<Double> after = new ArrayList<Double>();
		if(recent) {
			before = simulateMatches(this,true);
		}
		getTeam(teamA).updateMatches(teamB, mapAw, mapBw);
		getTeam(teamB).updateMatches(teamA, mapBw, mapAw);
		//System.out.println("Match Updated: " + teamA +" vs " + teamB + " " + mapAw + " - " + mapBw);
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
			//getTeam(teamA).removeMatch(teamB);
			//getTeam(teamB).removeMatch(teamA);
			System.out.println();
			
		}
	}
	
	public void matchImpact(String teamA, String teamB, int mapAw, int mapBw) {
		
			//printStandings(true,pool);
			getTeam(teamA).updateMatches(teamB, mapAw, mapBw);
			getTeam(teamB).updateMatches(teamA, mapBw, mapAw);
//			Collections.sort(poolsim);
//			tieCheck(poolsim);
			//printStandings(true,poolsim);
			//printStandings(true,poolsim);
			simulateMatchesAddingMatch(this);
			getTeam(teamA).removeMatch(teamB);
			getTeam(teamB).removeMatch(teamA);
			//printStandings(true,poolsim);
			
		
		
	}
	
	
	public ArrayList<team> getPoolsim() {
		return poolsim;
	}
	public void printAllMatches() {
		for(team i: pool) {
			i.printMatches();
		}
	}
	public void printStandings(boolean sim,ArrayList<team> p) {
		//System.out.println(sim);
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
			//Collections.sort(p);
			//tieCheck(p);
			for(team i: p) {
				i.printRecordShort();
			}
		}

	}



	Group saveState(Group A) {
		
		//System.out.println(" Matches from original pool data");
		//A.printPlayedMatches();
		Group dup=new Group(A.TeamA.getName(),A.TeamB.getName(),A.TeamC.getName(),A.TeamD.getName(),A.TeamE.getName(),A.TeamF.getName());
		//A.printAllMatches();
		for(int x=0;x<A.pool.size();x++) {
			for(int y=0;y<A.pool.get(x).getMatches().size();y++) {
				//System.out.println(A.pool.get(x));

				
				String teamA = A.pool.get(x).getName();
				String teamB = A.pool.get(x).getMatches().get(y).B;
				int mapA=A.pool.get(x).getMatches().get(y).mapA;
				int mapB=A.pool.get(x).getMatches().get(y).mapB;
				
//				System.out.println("Checking: "+teamA + " " + mapA+ "-" +
//						mapB + " " +  teamB);
				
				if(mapA!=0 ||mapB!=0 ) {
					//System.out.println(A.pool.get(x).getName() + " and " + A.pool.get(x).getMatches().get(y).B + " have  played");
					dup.getTeam(teamA).updateMatches(teamB, mapA, mapB);
					
					
				}
			}
		}
		
		//dup.getTeam("Optic").updateMatches("Faze", 0, 3);
		//dup.printAllMatches();
		//dup.getTeam("Optic").printMatches();
		//System.out.println();
		//dup.printStandingsNoTie();
		return dup;
	}
	void printStandingsNoTie() {
		for(team i: pool) {
			i.printRecordShort();
		}
	}


	public ArrayList<Double> simulateMatches(Group A,boolean s) {
		
			resetSims();
		
		
		//A.printStandings();
		for(int sims = 0; sims<simulations;sims++) {
			Group Copy = saveState(A);
			for(int x=0;x<Copy.pool.size();x++) {
				String team = Copy.pool.get(x).getName();
				int mapA=0;
				int mapB=0;
				int count=0;
				//Copy.pool.get(x).printMatches();
				for(int y =0; y<Copy.pool.get(x).getMatches().size();y++) {
					//System.out.println(Copy.pool.get(x).getMatches().get(y).mapA + "-"+Copy.pool.get(x).getMatches().get(y).mapB);
					if(Copy.pool.get(x).getMatches().get(y).mapA==0 && Copy.pool.get(x).getMatches().get(y).mapB==0) {
						//System.out.println("teams have not played");
						String opp = Copy.pool.get(x).getMatches().get(y).B;
						while((mapA!=3 && mapB!=3) && count<10) { 
							double draw = Math.random();
							//System.out.println(draw);
							if(draw>0.5) { 
								mapA++; 
								//System.out.println("Map A:" + mapA); 
							} 
							else { 
								mapB++;
								//System.out.println("Map B:" + mapB); 
							} 
							if(mapA==3||mapB==3) {
								Copy.updateMatch(team,opp,mapA,mapB,false);
								//System.out.println(team + " " + mapA + "-" + mapB + " " + opp);

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
			//Copy.printAllMatches();
			//System.out.println(" Simulated Standings");
			
			//Copy.disableTies(Copy.pool);
			Collections.sort(Copy.pool);
		//	System.out.println();
			//Copy.printStandings();
			Copy.tieCheck(Copy.pool);
			//Copy.printStandings();
//			
			addSim(Copy);
//			if(Copy.getPool().get(2).name.equals("Surge")||Copy.getPool().get(2).name.equals("Legion")) {
//				System.out.println("Something didnt work");
//				Copy.printStandings();
//				System.out.println("errororororororo");
//				Copy.printAllMatches();
//				break;
//			}
//			System.out.println();


		}
		if(!s) {
			printSimulatedPercentages(simulations);
		}
		else {
			//printSimulatedPlacings();
		}
		
		ArrayList<Double> ret = new ArrayList<Double>();
		for(team t: pool) {
			ret.add(t.placings.get(0)+t.placings.get(1)+t.placings.get(2));
		}
		
		
		
		return ret;

	}
	public ArrayList<Double> simulateMatchesAddingMatch(Group A) {
		
		resetSims2();
	
	
	//Copy.printStandings();
	for(int sims = 0; sims<simulations;sims++) {
		Group Copy = saveState(A);
		for(int x=0;x<Copy.pool.size();x++) {
			String team = Copy.poolsim.get(x).getName();
			int mapA=0;
			int mapB=0;
			int count=0;
			//Copy.pool.get(x).printMatches();
			for(int y =0; y<Copy.poolsim.get(x).getMatches().size();y++) {
				//System.out.println(Copy.pool.get(x).getMatches().get(y).mapA + "-"+Copy.pool.get(x).getMatches().get(y).mapB);
				if(Copy.poolsim.get(x).getMatches().get(y).mapA==0 && Copy.poolsim.get(x).getMatches().get(y).mapB==0) {
					//System.out.println("teams have not played");
					String opp = Copy.poolsim.get(x).getMatches().get(y).B;
					while((mapA!=3 && mapB!=3) && count<10) { 
						double draw = Math.random();
						//System.out.println(draw);
						if(draw>0.5) { 
							mapA++; 
							//System.out.println("Map A:" + mapA); 
						} 
						else { 
							mapB++;
							//System.out.println("Map B:" + mapB); 
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
		//Copy.printAllMatches();
		
		
//		
		Copy.disableTies(poolsim);
		Collections.sort(Copy.poolsim);
		//System.out.println();
		//	Copy.printStandings();
		Copy.tieCheck(Copy.poolsim);
		//Copy.printStandings2();
		addSimMatch(Copy);
	
		


	}
	
	
	
	ArrayList<Double> ret = new ArrayList<Double>();
	for(team t: pool) {
//		System.out.println(t.getName() + " " +t.placings2.get(0)+ " " +t.placings2.get(1)+ " " +t.placings2.get(2)+" " +t.placings2.get(3)+ " " 
//		+ " " +t.placings2.get(4)+ " "+ t.placings2.get(5));
		ret.add(t.placings2.get(0)+t.placings2.get(1)+t.placings2.get(2));
	}
	
	
	return ret;

}
	
	void resetSims() {
		for(team t: pool) {
			for(int i = 0; i<t.placings.size();i++) {
				t.placings.set(i, (double) 0);
			}
		}
	}
	public void resetSims2() {
		for(team t: pool) {
			for(int i = 0; i<t.placings2.size();i++) {
				t.placings2.set(i, (double) 0);
			}
		}
	}
	
	void importantMatches(Group A) {
		Group Copy = saveState(A);
		Group simCopy = saveState(A);
		double perWin=0;
		double perLose=0;
		double winT3=0;
		double winB3=0;
		double loseT3=0;
		double loseB3=0;
		String influence= "";
		double diff=0;
		for(team t: Copy.pool) {
		//t.printMatches();
			for(Match m: t.matches) {
				if(m.mapA==0 && m.mapB==0) {
					//System.out.println("simulating: " + m.A+" vs " + m.B );
					for(int i=0;i<3;i++) {
					//System.out.println("simulating: " + m.A+" vs " + m.B + " 3 - " +i);
						simCopy.updateMatch(m.A, m.B, 3, i,false);
						simCopy.simulateMatches(simCopy,true);
						for(int x = 0;x<3;x++) {
							winT3 +=simCopy.getTeam(m.A).placings.get(x);
						}
						for(int y = 3;y<simCopy.getTeam(m.A).placings.size();y++) {
							winB3 +=simCopy.getTeam(m.A).placings.get(y);
						}
						
						simCopy = saveState(A);
						//System.out.println("simulating: " + m.A+" vs " + m.B + " " + i + " - 3");
						simCopy.updateMatch(m.A, m.B, i, 3,false);
						simCopy.simulateMatches(simCopy,true);
						for(int x = 0;x<3;x++) {
							loseT3 +=simCopy.getTeam(m.A).placings.get(x);
						}
						for(int y = 3;y<simCopy.getTeam(m.A).placings.size();y++) {
							loseB3 +=simCopy.getTeam(m.A).placings.get(y);
						}
						
						
						
						
						//System.out.println(Copy.pool.get(0).name + " " +winT3 + " " + winB3);
						//System.out.println(Copy.pool.get(0).name + " " +loseT3 + " " + loseB3);
						simCopy=saveState(A);
					}
					
					//System.out.println(t.name + " wins " +winT3 + " " + winB3);
					//System.out.println(t.name + " loses " +loseT3 + " " + loseB3);
					simCopy=saveState(A);
					
				}
				if((winT3/(winT3+winB3) - (loseT3/(loseT3+loseB3)) > diff)){
					//System.out.println("new influenctial match " +m.B);
					influence = m.B;
					diff= winT3/(winT3+winB3) - loseT3/(loseT3+loseB3);
					perWin = winT3/(winT3+winB3);
					perLose=loseT3/(loseT3+loseB3);
					
				}
				else if((winT3/(winT3+winB3) - (loseT3/(loseT3+loseB3)) == diff)){
					//System.out.println("tie influenctial match " +influence + " " +m.B);
					influence = influence.concat(" " + m.B);
				}
				winT3=0;
				winB3=0;
				loseT3=0;
				loseB3=0;
				
			
		}
		
		System.out.print("The most influential match for " + t.getName() + " is against " + influence);
		System.out.printf("\nTop Three Percentage with Win: %3.3f%%\nTop Three Percentage with Lose: %3.3f%%\n\n", perWin*100,perLose*100);
		
		influence ="";
		perWin=0;
		perLose=0;
		diff=0;
		
		}
	}
	
	
	
	
	
	
	void printSimulatedPlacings() {
		for(team t: this.pool) {
			t.printPlacings(longName);
		}
	}
	public void printSimulatedPercentages(int simulations) {
		System.out.println("Number of simulations: " + simulations);
		for(team t: this.pool) {
			t.printSimPer(simulations,longName);
		}
	}

	void addSim(Group sim) {
		for(int x =0;x<pool.size();x++) {
			for(int y=0;y<sim.pool.size();y++) {
				if(this.pool.get(x).getName().equals(sim.pool.get(y).getName()) ){
					//System.out.println("found " + x + " " +y);
					if(sim.pool.get(x).deadtie2) {
						this.pool.get(x).placings.set(y, this.pool.get(x).placings.get(y)+0.5);
					}
					else if(sim.pool.get(x).deadtie3) {
						this.pool.get(x).placings.set(y, this.pool.get(x).placings.get(y)+0.33);
					}
					else if(sim.pool.get(x).deadtie4) {
						this.pool.get(x).placings.set(y, this.pool.get(x).placings.get(y)+0.25);
					}
					else if(sim.pool.get(x).deadtie5) {
						this.pool.get(x).placings.set(y, this.pool.get(x).placings.get(y)+0.20);
					}
					else {
						this.pool.get(x).placings.set(y, this.pool.get(x).placings.get(y)+1);
					}
				}
			}

		}
	}
	void addSimMatch(Group sim) {
		for(int x =0;x<pool.size();x++) {
			for(int y=0;y<sim.pool.size();y++) {
				if(this.poolsim.get(x).getName().equals(sim.poolsim.get(y).getName()) ){
					//System.out.println("found " + x + " " +y);
					if(sim.poolsim.get(x).deadtie2) {
						this.poolsim.get(x).placings2.set(y, this.poolsim.get(x).placings2.get(y)+0.5);
					}
					else if(sim.poolsim.get(x).deadtie3) {
						this.poolsim.get(x).placings2.set(y, this.poolsim.get(x).placings2.get(y)+0.33);
					}
					else if(sim.poolsim.get(x).deadtie4) {
						this.poolsim.get(x).placings2.set(y, this.poolsim.get(x).placings2.get(y)+0.25);
					}
					else if(sim.poolsim.get(x).deadtie5) {
						this.poolsim.get(x).placings2.set(y, this.poolsim.get(x).placings2.get(y)+0.20);
					}
					else {
						this.poolsim.get(x).placings2.set(y, this.poolsim.get(x).placings2.get(y)+1);
					}
				}
			}

		}
	}
	public void setPool(ArrayList<team> pool2) {
		pool.clear();
		for(team t: pool2) {
			pool.add(t);
		}
		System.out.println("New pool: " +pool.get(0).getName());
		System.out.println("New pool: " +pool.get(1).getName());
		
	}
	
	
	public void printPool() {
		for(team t: pool) {
			System.out.print(t.getName() + " " );
		}
		System.out.println();
	}
	
	public void resetMatches() {
		for(team t: pool) {
			for(Match m: t.matches) {
				m.resetMatch();
			}
			t.mapL = 0;
			t.mapW = 0;
			t.matchW = 0;
			t.matchL = 0;
		}
	}
	public void printPlayedMatches() {
		for(team t: pool) {
			for(Match m: t.matches) {
				if(m.mapA ==3 || m.mapB==3) {
					System.out.println(m);
				}
			}
		}
	}
	public int getSimulations() {
		return simulations;
	}

	public void resetMatch(String teamA, String teamB) {
		getTeam(teamA).removeMatch(teamB);
		getTeam(teamB).removeMatch(teamA);
	}
	
	public void sortStandings(ArrayList<team>p) {
		Collections.sort(p);
		tieCheck(p);
	}
	
	public void sortStandings() {
		Collections.sort(pool);
		tieCheck(pool);
	}
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
	public void printStandings() {
		for(team t: pool) {
			t.printRecordShort();
		}
	}
	public void printStandings2() {
		for(team t: poolsim) {
			t.printRecordShort();
		}
	}
	
	void setTies(int x, int y) {
		pool.get(x).setTie(true,2);
		pool.get(y).setTie(true,2);;
	}

	void tieCheck(ArrayList<team> p) {

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
			sixWayTie();
		}

		twoWayTie(wins,loses,p);
		threeWayTie(wins,loses,p);
		fourWayTie(wins,loses,p);
		fiveWayTie(wins,loses,p);


	}

	void twoWayTie(int[] wins,int[] loses, ArrayList<team>p) {
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

	void splitTwoWay(int i, ArrayList<team>p) {
		for(Match m: p.get(i).getMatches()) {
			if(m.findMatch(p.get(i-1).getName())) {
				//System.out.println(m);
				//Haven't played each other
				if(m.mapA==0&&m.mapB==0) {
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
				else if(m.mapA==3){
					//System.out.println("played each other ");
					Collections.swap(p, i, i-1);
				}
			}
		}
	}

	void threeWayTie(int[] wins, int[] loses, ArrayList<team>p) {
		
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

	void splitThreeWay(int i, ArrayList<team> p) {

		String teamA = p.get(i-3).getName(); int winsA=0; int losesA=0; int mapsWA=0;int mapsLA=0; 
		double matchWinPerA = 0; double mapWinPerA=0;
		String teamB = p.get(i-2).getName(); int winsB=0; int losesB=0; int mapsWB=0; int mapsLB=0; 
		double matchWinPerB = 0;double mapWinPerB=0;
		String teamC = p.get(i-1).getName(); int winsC=0; int losesC=0; int mapsWC=0; int mapsLC=0;
		double matchWinPerC = 0;double mapWinPerC=0;

		for(int x =0;x<p.get(i-3).getMatches().size();x++) {
			if(p.get(i-3).getMatches().get(x).findMatch(teamB)||
					p.get(i-3).getMatches().get(x).findMatch(teamC)) {

				mapsWA += p.get(i-3).getMatches().get(x).mapA; 
				mapsLA += p.get(i-3).getMatches().get(x).mapB;
				if(p.get(i-3).getMatches().get(x).mapA==3) { 
					winsA++; 
				} 
				else if(p.get(i-3).getMatches().get(x).mapB==3){ 
					losesA++;
				}


			} 
		}
		for(int x =0;x<p.get(i-2).getMatches().size();x++) {
			if(p.get(i-2).getMatches().get(x).findMatch(teamA)||
					p.get(i-2).getMatches().get(x).findMatch(teamC)) {

				mapsWB += p.get(i-2).getMatches().get(x).mapA; 
				mapsLB += p.get(i-2).getMatches().get(x).mapB;
				if(p.get(i-2).getMatches().get(x).mapA==3) { 
					winsB++; 
				} 
				else if(p.get(i-2).getMatches().get(x).mapB==3){ 
					losesB++;
				}


			} 
		}
		for(int x =0;x<p.get(i-1).getMatches().size();x++) {
			if(p.get(i-1).getMatches().get(x).findMatch(teamB)||
					p.get(i-1).getMatches().get(x).findMatch(teamA)) {

				mapsWC += p.get(i-1).getMatches().get(x).mapA; 
				mapsLC += p.get(i-1).getMatches().get(x).mapB;
				if(p.get(i-1).getMatches().get(x).mapA==3) { 
					winsC++; 
				} 
				else if(p.get(i-1).getMatches().get(x).mapB==3){ 
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

	void threeSplitTies(double match1,double match2,double match3, double pool1,double pool2, double pool3,int i, ArrayList<team>p) {
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

	void splitThreeWayMatchTie(double pool1, double pool2, double pool3, int i, ArrayList<team>p) {
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

	void fourWayTie(int[] wins, int[] loses, ArrayList<team>p) {
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
	 * @param i
	 */
	void splitFourWay(int i, ArrayList<team>p) {
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

				mapsWA += p.get(i-4).getMatches().get(x).mapA; 
				mapsLA += p.get(i-4).getMatches().get(x).mapB;
				if(p.get(i-4).getMatches().get(x).mapA==3) { 
					winsA++; 
				} 
				else if(p.get(i-4).getMatches().get(x).mapB==3){ 
					losesA++;
				}


			} 
		}

		for(int x =0;x<p.get(i-3).getMatches().size();x++) {
			if(p.get(i-3).getMatches().get(x).findMatch(teamA)||
					p.get(i-3).getMatches().get(x).findMatch(teamC)||
					p.get(i-3).getMatches().get(x).findMatch(teamD)) {

				mapsWB += p.get(i-3).getMatches().get(x).mapA; 
				mapsLB += p.get(i-3).getMatches().get(x).mapB;
				if(p.get(i-3).getMatches().get(x).mapA==3) { 
					winsB++; 
				} 
				else if(p.get(i-3).getMatches().get(x).mapB==3){ 
					losesB++;
				}


			} 
		}
		for(int x =0;x<p.get(i-2).getMatches().size();x++) {
			if(p.get(i-2).getMatches().get(x).findMatch(teamA)||
					p.get(i-2).getMatches().get(x).findMatch(teamB)||
					p.get(i-2).getMatches().get(x).findMatch(teamD)) {

				mapsWC += p.get(i-2).getMatches().get(x).mapA; 
				mapsLC += p.get(i-2).getMatches().get(x).mapB;
				if(p.get(i-2).getMatches().get(x).mapA==3) { 
					winsC++; 
				} 
				else if(p.get(i-2).getMatches().get(x).mapB==3){ 
					losesC++;
				}


			} 
		}
		for(int x =0;x<p.get(i-1).getMatches().size();x++) {
			if(p.get(i-1).getMatches().get(x).findMatch(teamB)||
					p.get(i-1).getMatches().get(x).findMatch(teamA)||
					p.get(i-1).getMatches().get(x).findMatch(teamC)) {

				mapsWD += p.get(i-1).getMatches().get(x).mapA; 
				mapsLD += p.get(i-1).getMatches().get(x).mapB;
				if(p.get(i-1).getMatches().get(x).mapA==3) { 
					winsD++; 
				} 
				else if(p.get(i-1).getMatches().get(x).mapB==3){ 
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

	void fourWaySort(double match1, double match2, double match3, double match4, 
			double map1, double map2, double map3, double map4,
			double pool1, double pool2, double pool3, double pool4,int i, ArrayList<team>p) {
		//1 > 2 > 3 >= 4
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

	void fiveWayTie(int[] wins, int[] loses, ArrayList<team>p) {
		int i = 5;
		int start = 0;
		if(wins[i-5]==wins[i-4] && wins[i-4]==wins[i-3] && wins[i-3]==wins[i-2] && wins[i-2]==wins[i-1]&&
				loses[i-5]==loses[i-4] && loses[i-4]==loses[i-3] && loses[i-3]==loses[i-2] && loses[i-2]==loses[i-1]&&
				(wins[i-5]!=wins[i]||wins[i-5]!=loses[i])) {
			//System.out.println("Five way tie for first");
			splitFiveWay(i,start,p);
		}
		if(wins[i]==wins[i-4] && wins[i-4]==wins[i-3] && wins[i-3]==wins[i-2] && wins[i-2]==wins[i-1]&&
				loses[i]==loses[i-4] && loses[i-4]==loses[i-3] && loses[i-3]==loses[i-2] && loses[i-2]==loses[i-1]&&
				(wins[i-5]!=wins[i]||wins[i-5]!=loses[i])) {
			//System.out.println("Five way tie for last");
			start=1;
			splitFiveWay(i,start,p);
		}
	}

	void splitFiveWay(int i,int start, ArrayList<team>p) {
		int tieCount = 1;
		for(int x =start;x<i;x++) {
			for(int y= x+1;y<p.size();y++) {
				if(p.get(x).getmapWinper()<p.get(y).getmapWinper()) {
					Collections.swap(p, x, y);
				}
			}
		}

		//check for ties

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

	void sixWayTie() {
		System.out.println("Didnt think this could happen");
		//six way ties
		for(int x =0;x<5;x++) {
			for(int y= x+1;y<pool.size();y++) {
				if(pool.get(x).getmapWinper()<pool.get(y).getmapWinper()) {
					Collections.swap(pool, x, y);
				}

			}
		}
		//check for ties
		int tieCount=1;
		for(int x = 0;x<pool.size()-1;x++) {
			if(pool.get(x).getmapWinper()==pool.get(x+1).getmapWinper()) {
				tieCount++;
			}
			if(pool.get(x).getmapWinper()!=pool.get(x+1).getmapWinper()) {
				if(tieCount!=1) {
					for(int y = x;y>x-tieCount;y--) {
						pool.get(y).setTie(true, tieCount);
					}
					tieCount=1;
				}
			}
			if(x==pool.size()-2) {
				if(tieCount!=1) {
					for(int y = x+1;y>x-tieCount+1;y--) {
						pool.get(y).setTie(true, tieCount);
					}
					tieCount=1;
				}
			}
		}
	}

	public void disableTies(ArrayList<team> p) {
		for(team t: p) {
			for(int i = 2; i<7;i++) {
				t.setTie(false,i);
			}
			
		}
	}
}
