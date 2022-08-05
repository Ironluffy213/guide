import java.io.*;
import java.util.*;

public class USACOMowing {
	static Scanner in;
	static PrintWriter out;
	static int n;
	static char[] d;
	static int[] t;
	static int[][] b;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(new File("mowing.in"));
		out = new PrintWriter(new File("mowing.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		n = Integer.parseInt(in.nextLine());
		d = new char[n];
		t = new int[n];
		b = new int[2001][2001];
		
		for(int i = 0; i < n; i++) {
			String[] temp = in.nextLine().split(" ");
			d[i] = temp[0].charAt(0);
			t[i] = Integer.parseInt(temp[1]);
		}
	}
	
	static void solve() {
		int min = 999999999;
		int time = 1;
		int x = 1001;
		int y = 1001;
		b[x][y] = 1;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < t[i]; j++) {
				time++;
				
				if(d[i] == 'N') {
					y--;
				}else if(d[i] == 'S') {
					y++;
				}else if(d[i] == 'W') {
					x--;
				}else if(d[i] == 'E') {
					x++;
				}
				
				if(b[x][y] != 0) {
					min = Math.min(min, time-b[x][y]);
				}
				b[x][y] = time;
			}
		}
		
		if(min == 999999999) {
			out.println(-1);
		}else {
			out.println(min);
		}
	}
}
