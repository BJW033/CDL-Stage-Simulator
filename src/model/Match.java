package model;
public class Match{
		String A;
		String B;
		int mapA;
		int mapB;

		public Match(String A, String B) {
			this.A = A;
			this.B = B;
			mapA=0;
			mapB=0;
		}

		public String toString() {
			return A + " vs " +B + ": " + mapA + "-" + mapB;
		}
		void updateMatch(int win,int oppWin) {
			mapA=win;
			mapB=oppWin;
		}
		boolean findMatch(String opp) {
			return opp.equals(B);
		}
		void resetMatch() {
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

