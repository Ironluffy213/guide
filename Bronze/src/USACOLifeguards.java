import java.io.*;
import java.util.*;

public class USACOLifeguards {
	static Scanner in;
	static PrintWriter out;
	static int n;
	static pair[] time;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(new File("lifeguards.in"));
		out = new PrintWriter(new File("lifeguards.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		n = in.nextInt();
		time = new pair[n];
		
		for(int i = 0; i < n; i++) {
			time[i] = new pair(in.nextInt(), in.nextInt());
		}
	}
	
	static void solve() {
		pair[] c = time.clone();
		int max = 0;
		
		for(int i = 0; i < n; i++) {
			c[i] = new pair(0, 0);
			Arrays.sort(c);
			
			int len = c[n-1].e - c[1].s;
			
			for(int j = 1; j < n-1; j++) {
				int diff = c[j+1].s - c[j].e;
				if(diff > 0) {
					len -= diff;
				}
			}
			
			max = Math.max(len, max);
			
			c = time.clone();
		}
		
		out.println(max);
	}
	
	static class pair implements Comparable<pair> {
		int s, e;
		
		pair(int x, int y){
			s = x;
			e = y;
		}
		
		public String toString() {
			return s+" "+e;
		}
		
		@Override
		public int compareTo(pair that) {
			if(that.s > this.s) {
				return -1;
			}else if(this.s > that.s) {
				return 1;
			}else {
				if(this.e> that.e) {
					return 1;
				}else {
					return -1;
				}
			}
		}
	}
}
