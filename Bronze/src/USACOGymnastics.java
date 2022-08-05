import java.io.*;
import java.util.*;

public class USACOGymnastics {
	static Scanner in;
	static PrintWriter out;
	static int k, n;
	static ArrayList[] rank;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(new File("gymnastics.in"));
		out = new PrintWriter(new File("gymnastics.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		k = in.nextInt();
		n = in.nextInt();
		//System.out.println(n);
		rank = new ArrayList[k];
		for(int i = 0; i < k; i++) {
			rank[i] = new ArrayList<Integer>();
			for(int j = 0; j < n; j++) {
				rank[i].add(in.nextInt());
			}
		}
		//System.out.println(Arrays.toString(rank));
	}
	
	static void solve() {
		int cnt = 0;
		for(int i = 0; i < k; i++) {
			for(int j = 0; j < n; j++) {
				
			}
		}
	}
}
