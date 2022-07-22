import java.io.*;
import java.util.*;

public class USACOMeasuringTraffic {
	static Scanner in;
	static PrintWriter out;
	static int n;
	static triple[] f;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(new File("traffic.in"));
		out = new PrintWriter(new File("traffic.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		n = in.nextInt();
		in.nextLine();
		f = new triple[n];
		for(int i = 0; i < n; i++) {
			String[] t = in.nextLine().split(" ");
			f[i] = new triple(t[0], Integer.parseInt(t[1]), Integer.parseInt(t[2]));
		}
	}
	
	static void solve() {
		int left = -999999999;
		int right = 999999999;
		
		for(int i = n-1; i >= 0; i--) {
			if(f[i].e.equals("on")){
				left -= f[i].r;
				right -= f[i].l;
				if(left < 0) {
					left = 0;
				}
			}else if(f[i].e.equals("off")) {
				left += f[i].l;
				right += f[i].r;
			}else {
				left = Math.max(left, f[i].l);
				right = Math.min(right, f[i].r);
			}
		}
		
		out.println(left+" "+right);
		
		for(int i = 0; i < n; i++) {
			if(f[i].e.equals("off")){
				left -= f[i].r;
				right -= f[i].l;
				if(left < 0) {
					left = 0;
				}
			}else if(f[i].e.equals("on")) {
				left += f[i].l;
				right += f[i].r;
			}else {
				left = Math.max(left, f[i].l);
				right = Math.min(right, f[i].r);
			}
		}

		out.println(left+" "+right);
		
	}
	
	static class triple implements Comparable<triple> {
		int l, r;
		String e;
		
		triple(String z,int x, int y){
			e = z;
			l = x;
			r = y;
		}
		
		public String toString() {
			return e+" "+l+" "+r;
		}
		
		@Override
		public int compareTo(triple that) {
			if(this.e.equals(that.e)) {
				return 1;
			}
			return -1;
		}
	}
}
