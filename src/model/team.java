package model;
import java.util.ArrayList;

public class team implements Comparable<team>{
	
		String name;
		int matchW;
		int matchL;
		int mapW;
		int mapL;
		ArrayList<Match> matches =new ArrayList<Match>();
		double matchWinper;
		boolean deadtie=false;
		 boolean deadtie2=false;
		boolean deadtie3=false;
		boolean deadtie4=false;
		boolean deadtie5=false;
		boolean deadtie6=false;
		ArrayList<Double> placings = new ArrayList<Double>(); 
		ArrayList<Double> placings2 = new ArrayList<Double>(); 
		double top3Per=0;

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
				placings2.add((double) 0);
			}
		}
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
		public ArrayList<Double> getPlacings() {
			return placings;
		}
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

		public void setTie(boolean b) {
			deadtie=true;
		}
		public void setTie(boolean b,int i) {
			if(i==2) {
				setDeadtie2(b);
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

		public double getmapWinper() {
			if(mapW+mapL == 0) {
				return 0;
			}
			return (double)mapW/(mapW+mapL);
		}

		public ArrayList<Match> getMatches() {

			return matches;
		}

		void printMatches() {
			System.out.println(getName()+"'s matches: ");
			matches.forEach((m) -> System.out.println(m));
		}

		void updateMatches(String opp, int teamAmaps, int teamBmaps) {
			for(Match i: matches) {
				if(i.B.equals(opp)) {
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

		void printMapCount() {
			System.out.println(getName() +" has a " + mapW + "-" + mapL +" map count.");
		}
		void printRecord() {
			System.out.println(getName() +" has a " + matchW + "-" + matchL +" match count.");
		}
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
		public ArrayList<Double> getPlacings2() {
			return placings2;
		}
		public void setPlacings2(ArrayList<Double> placings2) {
			this.placings2 = placings2;
		}
		
		public Match findMatch(String s) {
			for(Match m: matches) {
				if(s.equals(m.B)) {
					return m;
				}
			}
			return null;
		}
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
		
		public void printTies() {
			if(isDeadtie2()||deadtie3||deadtie4||deadtie5||deadtie6) {
				System.out.print("Ties present");
			}
		}
		
		public double getTop3PerSim() {
			return placings2.get(0)+placings2.get(1)+placings2.get(2);
		}
		public double getTop3Per() {
			return placings.get(0)+placings.get(1)+placings.get(2);
		}
		boolean isDeadtie2() {
			return deadtie2;
		}
		public void setDeadtie2(boolean deadtie2) {
			this.deadtie2 = deadtie2;
		}
		

	}

