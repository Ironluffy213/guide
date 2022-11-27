import java.io.*;
import java.util.*;

public class USACOContaminated {
	static Scanner in;
	static PrintWriter out;
	static int n, m, d, s;
	static triple[] time;
	static boolean[][] record;
	static boolean[] bm;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(new File("badmilk.in"));
		out = new PrintWriter(new File("badmilk.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		n = in.nextInt();
		m = in.nextInt();
		d = in.nextInt();
		s = in.nextInt();
		
		time = new triple[d+s];
		record = new boolean[n][m];
		bm = new boolean[m];
		Arrays.fill(bm, true);
		
		for(int i = 0; i < d; i++) {
			time[i] = new triple(in.nextInt()-1, in.nextInt()-1, in.nextInt());
		}
		for(int i = d; i < s+d; i++) {
			time[i] = new triple(in.nextInt()-1, -1, in.nextInt());
		}
		Arrays.sort(time);
		//System.out.println(Arrays.toString(time));
	}
	
	static void solve() {
		for(triple t:time) {
			if(t.m == -1) {
				for(int i = 0; i < m; i++) {
					bm[i] = bm[i] && record[t.p][i];
				}
			}else {
				record[t.p][t.m] = true;
			}
		}
		
		int max = 0;
		for(int i = 0; i < m; i++) {
			int cnt = 0;
			if(bm[i]) {
				for(int j = 0; j < n; j++) {
					if(record[j][i]) {
						cnt++;
					}
				}
			}
			max = Math.max(max, cnt);
		}
		out.println(max);
	}
	
	static class triple implements Comparable<triple> {
		int p, m, t;
		
		triple(int x, int y, int z){
			p = x;
			m = y;
			t = z;
		}
		
		public String toString() {
			return p+" "+m+" "+t;
		}
		
		@Override
		public int compareTo(triple that) {
			if(this.t == that.t) {
				return this.m-that.m;
			}
			return this.t - that.t;
		}
	}
}
