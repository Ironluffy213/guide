import java.io.*;
import java.util.*;

public class USACOGenomics {
	static Scanner in;
	static PrintWriter out;
	static int n, m;
	static ArrayList[] spot, og;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(new File("cownomics.in"));
		out = new PrintWriter(new File("cownomics.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		n = in.nextInt();
		m = in.nextInt();
		in.nextLine();
		spot = new ArrayList[n];
		og = new ArrayList[n];
		for(int i = 0; i < n; i++) {
			spot[i] = new ArrayList<Character>();
			String temp = in.nextLine();
			for(int j = 0; j < m; j++) {
				spot[i].add(temp.charAt(j));
			}
		}
		for(int i = 0; i < n; i++) {
			og[i] = new ArrayList<Character>();
			String temp = in.nextLine();
			for(int j = 0; j < m; j++) {
				og[i].add(temp.charAt(j));
			}
		}
	}
	
	static void solve() {
		ArrayList<pair> possible = new ArrayList<pair>();
		
		for(int i = 0; i < m; i++) {
			char p = (char) og[0].get(i);
			boolean same = true;
			for(int j = 1; j < n; j++) {
				if((char)og[j].get(i) != p) {
					same = false;
					break;
				}
			}
			if(same) {
				possible.add(new pair(p, i));
			}
		}
		
		int cnt = 0;
		
		for(int i = 0; i < possible.size(); i++) {
			boolean diff = true;
			for(int j = 0; j < n; j++) {
				if((char)spot[j].get(possible.get(i).pos) == possible.get(i).let) {
					diff = false;
				}
			}
			if(diff) {
				cnt++;
			}
		}
		
		out.println(cnt);
	}
	
	static class pair implements Comparable<pair> {
		char let;
		int pos;
		
		pair(char x, int y){
			let = x;
			pos = y;
		}
		
		public String toString() {
			return let+" "+pos;
		}
		
		@Override
		public int compareTo(pair that) {
			return this.pos-that.pos;
		}
	}
}
