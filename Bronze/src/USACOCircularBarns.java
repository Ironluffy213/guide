import java.io.*;
import java.util.*;

public class USACOCircularBarns {
	static Scanner in;
	static PrintWriter out;
	static int n;
	static int[] r;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(new File("cbarn.in"));
		out = new PrintWriter(new File("cbarn.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		n = in.nextInt();
		r = new int[n];
		for(int i = 0; i < n; i++) {
			r[i] = in.nextInt();
		}
	}
	
	static void solve() {
		int steps = 999999999;
		for(int i = 0; i < n; i++) {
			int cnt = 0;
			for(int j = 0; j < n; j++) {
				int diff  = j - i;
				if(diff == 0) {
					continue;
				}else if(diff < 0) {
					diff = n+diff;
				}
				cnt += diff*r[j];
			}
			steps = Math.min(steps, cnt);
		}
		out.println(steps);
	}
}
