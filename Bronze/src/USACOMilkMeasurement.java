import java.io.*;
import java.util.*;

public class USACOMilkMeasurement {
	static Scanner in;
	static PrintWriter out;
	static int n, ind;
	static triple[] m;
	static int[] amt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(new File("measurement.in"));
		out = new PrintWriter(new File("measurement.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		n = Integer.parseInt(in.nextLine());
		m = new triple[n];
		amt = new int[3];
		int max = -999999999;
		ind = 0;
		
		for(int i = 0; i < n; i++) {
			String[] temp = in.nextLine().split(" ");
			if(temp[2].contains("+")) {
				temp[2] = temp[2].substring(1);
			}
			m[i] = new triple(Integer.parseInt(temp[0]), temp[1], Integer.parseInt(temp[2]));
		}
		Arrays.sort(m);
		
		amt[0] = 7;
		amt[1] = 7;
		amt[2] = 7;
		
		if(m[0].name.equals("Bessie")) {
			amt[0] += m[0].b;
		}else if(m[0].name.equals("Elsie")) {
			amt[1] += m[0].b;
		}else {
			amt[2] += m[0].b;
		}
		for(int i = 0; i < 3; i++) {
			if(amt[i] > max) {
				max = amt[i];
				ind = i;
			}
		}
	}
	
	static void solve() {
		int cnt = 0;
		for(int i = 1; i < n; i++) {
			if(m[i].name.equals("Bessie")) {
				amt[0] += m[i].b;
			}else if(m[i].name.equals("Elsie")) {
				amt[1] += m[i].b;
			}else {
				amt[2] += m[i].b;
			}
			
			int max = -999999999;
			int ti = 0;
			for(int j = 0; j < 3; j++) {
				if(amt[j] > max) {
					max = amt[j];
					ti = j;
				}
			}
			if(ti != ind) {
				cnt++;
				ind = ti;
			}
		}
		out.println(cnt+1);
	}
	
	static class triple implements Comparable<triple> {
		int a, b;
		String name;
		
		triple(int x, String s, int y){
			a = x;
			b = y;
			name = s;
		}
		
		public String toString() {
			return a+" "+name +" "+b;
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
