import java.io.*;
import java.util.*;

public class USACOTriangle {
	static Scanner in;
	static PrintWriter out;
	static int n;
	static int[] x, y;
	static TreeSet<Integer> sx, sy;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(new File("triangles.in"));
		out = new PrintWriter(new File("triangles.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		n = Integer.parseInt(in.nextLine());
		x = new int[n];
		y = new int[n];
		
		for(int i = 0; i < n; i++) {
			String[] temp = in.nextLine().split(" ");
			x[i] = Integer.parseInt(temp[0]);
			y[i] = Integer.parseInt(temp[1]);
		}

		sx = new TreeSet<Integer>();
		sy = new TreeSet<Integer>();
	}
	
	static void solve() {
		int area = 0;
		
		for(int i = 0; i < n-2; i++) {
			for(int j = i+1; j < n-1; j++) {
				for(int k = j+1; k < n; k++) {
					if(ok(i, j, k)) {
						area = Math.max(area, Math.abs(sx.first()-sx.last())) * Math.abs(sy.first()-sy.last());
					}
				}
			}
		}
		
		out.println(area);
	}
	
	static boolean ok(int i, int j, int k) {
		sx.clear();
		sy.clear();
		
		sx.add(x[i]);
		sx.add(x[j]);
		sx.add(x[k]);
		
		sy.add(y[i]);
		sy.add(y[j]);
		sy.add(y[k]);
		
		//System.out.println(sx);
		//System.out.println(sy);
		return sx.size() == 2 && sy.size() == 2;
	}
}
