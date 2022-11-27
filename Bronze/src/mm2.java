import java.io.*;
import java.util.*;

public class mm2 {
	static Scanner in;
	static PrintWriter out;
	static int n, g;
	static triple[] m;
	static int[] amt;
	static boolean[] big;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(new File("measurement.in"));
		out = new PrintWriter(new File("measurement.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		n = in.nextInt();
		g = in.nextInt();
		in.nextLine();
		m = new triple[n];
		amt = new int[3];
		big = new boolean[3];
		int max = -999999999;
		
		for(int i = 0; i < n; i++) {
			String[] temp = in.nextLine().split(" ");
			if(temp[2].contains("+")) {
				temp[2] = temp[2].substring(1);
			}
			m[i] = new triple(Integer.parseInt(temp[0]), Integer.parseInt(temp[2]), Integer.parseInt(temp[2]));
		}
		Arrays.sort(m);
		
		amt[0] = g;
		amt[1] = g;
		amt[2] = g;
		
		amt[m[0].b] += m[0].c;
		
		for(int i = 0; i < 3; i++) {
			if(amt[i] > max) {
				max = amt[i];
			}
		}
		for(int i = 0; i < 3; i++) {
			if(amt[i] == max) {
				big[i] = true;
			}else {
				big[i] = false;
			}
		}
	}
	
	static void solve() {
		int cnt = 1;
		for(int i = 1; i < n; i++) {
			boolean[] c = new boolean[3];
			amt[m[i].b] += m[i].c;
			
			int max = -999999999;
			for(int j = 0; j < 3; j++) {
				if(amt[j] > max) {
					max = amt[j];
				}
			}
			for(int j = 0; j < 3; j++) {
				if(amt[j] == max) {
					c[j] = true;
				}else {
					c[j] = false;
				}
			}
			if(!Arrays.equals(big, c)) {
				cnt++;
			}
			for(int j = 0; j < 3; j++) {
				big[j] = c[j];
			}
		}
		out.println(cnt);
	}
	
	static class triple implements Comparable<triple> {
		int a, b, c;
		
		triple(int x, int s, int y){
			a = x;
			b = s;
			c = y;
		}
		
		public String toString() {
			return a+" "+b +" "+c;
		}
		
		@Override
		public int compareTo(triple that) {
			if(this.a>that.a) {
				return 1;
			}
			return -1;
		}
	}
}
