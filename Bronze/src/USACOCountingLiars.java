import java.io.*;
import java.util.*;

public class USACOCountingLiars {
	static Scanner in;
	static int n;
	static char[] d;
	static int[] t;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(System.in);
		
		init();
		solve();
		
		in.close();
	}
	
	static void init() {
		n = Integer.parseInt(in.nextLine());
		d = new char[n];
		t = new int[n];
		
		for(int i = 0; i < n ; i++) {
			String[] temp = in.nextLine().split(" ");
			d[i] = temp[0].charAt(0);
			t[i] = Integer.parseInt(temp[1]);
		}
	}
	
	static void solve() {
		int ans = n;
		
		for(int i = 0; i < n; i++) {
			int x = t[i];
			int l = 0;
			
			for(int j = 0; j < n; j++) {
				if(d[j] == 'G' && x < t[j] || d[j] == 'L' && x > t[j]) {
					l++;
				}
			}
			
			ans = Math.min(ans, l);
		}
		
		System.out.println(ans);
	}
}
