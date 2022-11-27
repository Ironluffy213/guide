import java.io.*;
import java.util.*;

public class CSESapplediv {
	static Scanner in;
	static int n;
	static long[] w;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(System.in);
		
		init();
		solve();
		
		in.close();
	}
	
	static void init() {
		n = in.nextInt();
		in.nextLine();
		w = new long[n];
		
		for(int i = 0; i < n; i++) {
			w[i] = in.nextLong();
		}
	}
	
	static void solve() {
		n = (int)Math.pow(2, n);
		long min = 1000000000;
		for(int i = 0; i < n; i++) {
			String s = Integer.toBinaryString(i);
			long a = 0;
			long b = 0;
			int t = w.length-s.length();
			
			for(int j = 0; j < t; j++) {
				s = "0"+s;
			}
			
			for(int j = 0; j < s.length(); j++) {
				if(s.charAt(j) == '0') {
					a += w[j];
				}else {
					b  += w[j];
				}
			}
			
			if(min > Math.abs(a-b)) {
				min = Math.abs(a-b);
			}
		}
		System.out.println(min);
	}
	
}
