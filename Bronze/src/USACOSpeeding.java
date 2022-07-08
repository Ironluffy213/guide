import java.io.*;
import java.util.*;

public class USACOSpeeding {
	static Scanner in;
	static PrintWriter out;
	static int[] b, s;
	static int d;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(new File("speeding.in"));
		out = new PrintWriter(new File("speeding.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		int n = in.nextInt();
		int m = in.nextInt();
		int[][] spd = new int[n+m][2];
		for(int i = 0; i < n+m; i++) {
			for(int j = 0; j < 2; j++) {
				spd[i][j] = in.nextInt();
			}
		}
		d = 0;
		for(int i = 0; i < n; i++) {
			d += spd[i][0];
		}
		b = new int[d];
		s = new int[d];
		int ind = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < spd[i][0]; j++) {
				b[ind] = spd[i][1];
				ind++;
			}
		}
		ind = 0;
		for(int i = n; i < n+m; i++) {
			for(int j = 0; j < spd[i][0]; j++) {
				s[ind] = spd[i][1];
				ind++;
			}
		}
		//System.out.println(Arrays.toString(s));
	}
	
	static void solve() {
		int diff = 0;
		for(int i = 0; i < d; i++) {
			if(b[i]-s[i] > diff) {
				diff = b[i]-s[i];
			}
		}
		out.println(diff);
	}
}
