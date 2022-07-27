import java.io.*;
import java.util.*;

public class CodeForcesMaxDist {
	static Scanner in;
	static PrintWriter out;
	static int n;
	static int[] x, y;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(System.in);
		
		init();
		solve();
		
		in.close();
	}
	
	static void init() {
		n = in.nextInt();
		x = new int[n];
		y = new int[n];
		
		for(int i = 0; i < n; i++) {
			x[i] = in.nextInt();
		}
		for(int i = 0; i < n; i++) {
			y[i] = in.nextInt();
		}
	}
	
	static void solve() {
		double dist = 0;
		for(int i = 0; i < n-1; i++) {
			for(int j = i+1; j < n; j++) {
				double dx = Math.pow(x[i]-x[j], 2);
				double dy =	Math.pow(y[i]-y[j], 2);
				double dt = Math.sqrt(dx+dy);
				
				if(dt > dist) {
					dist = dt;
				}
			}
		}
		dist = Math.pow(dist, 2);
		System.out.println((int)dist);
	}
}
