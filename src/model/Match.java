package model;


/**
 * A match includes the names of both teams and the map count result of the match. 
 * @author bwu
 *
 */
public class Match{
		private String A;
		private String B;
		private int mapA;
		private int mapB;

		/**
		 * Match constructor that sets the two names of the teams involved and sets the map count to zero-zero
		 * Team A is considered the first team and is always the same as the team name of the team with the ArrayList of matches
		 * @param A String name of team A
		 * @param B String name of team B
		 */
		public Match(String A, String B) {
			this.A = A;
			this.B = B;
			mapA=0;
			mapB=0;
		}

		/**
		 * Returns a string made up of the team names and map count
		 */
		public String toString() {
			return A + " vs " +B + ": " + mapA + "-" + mapB;
		}
		/**
		 * Takes in two integers and sets them to each map value
		 * @param win integer number of map wins for team A
		 * @param oppWin integer number of map wins for team B
		 */
		public void updateMatch(int win,int oppWin) {
			mapA=win;
			mapB=oppWin;
		}
		/**
		 * Returns boolean on if the Match is between the two teams
		 * @param opp String name of opponent
		 * @return true if team B is the opp
		 */
		public boolean findMatch(String opp) {
			return opp.equals(B);
		}
		/**
		 * Sets both maps counts to zero
		 */
		public void resetMatch() {
			mapA = 0;
			mapB = 0;
		}

		public String getA() {
			return A;
		}

		public String getB() {
			return B;
		}

		public int getMapA() {
			return mapA;
		}

		public int getMapB() {
			return mapB;
		}
	}

