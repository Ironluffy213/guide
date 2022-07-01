import java.io.*;
import java.util.*;

public class USACOBIllboard {
	static Scanner in;
	static PrintWriter out;
	static boolean[][] a;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(new File("billboard.in"));
		out = new PrintWriter(new File("billboard.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		a = new boolean[2001][2001];
		
		int x1 = in.nextInt()+1000;
		int y1 = in.nextInt()+1000;
		int x2 = in.nextInt()+1000;
		int y2 = in.nextInt()+1000;
	
		
		for(int i = x1; i < x2; i++) {
			for(int j = y1; j < y2; j++) {
				a[i][j] = true;
			}
		}
		
		x1 = in.nextInt()+1000;
		y1 = in.nextInt()+1000;
		x2 = in.nextInt()+1000;
		y2 = in.nextInt()+1000;
		
		for(int i = x1; i < x2; i++) {
			for(int j = y1; j < y2; j++) {
				a[i][j] = false;
			}
		}
	}
	
	static void solve() {
		int x1 = 2000;
		int x2 = 0;
		int y1 = 2000;
		int y2 = 0;
		boolean f = false;
		
		for(int i = 0; i <= 2000; i++) {
			for(int j = 0; j <= 2000; j++) {
				if(a[i][j]) {
					x1 = Math.min(x1,  i);
					y1 = Math.min(y1,  j);
					x2 = Math.max(x2,  i);
					y2 = Math.max(y2,  j);
					f = true;
				}
			}
		}
		
		if(f) {
			out.println((x2-x1+1)*(y2-y1+1));
		}else {
			out.println(0);
		}
	}
}
