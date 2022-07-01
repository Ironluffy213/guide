import java.io.*;
import java.util.*;

public class USACOSqaurePasture {
	static Scanner in;
	static PrintWriter out;
	static int s;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(new File("square.in"));
		out = new PrintWriter(new File("square.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		int ax1 = in.nextInt();
		int ay1 = in.nextInt();
		int ax2 = in.nextInt();
		int ay2 = in.nextInt();
		
		int bx1 = in.nextInt();
		int by1 = in.nextInt();
		int bx2 = in.nextInt();
		int by2 = in.nextInt();
		
		int minx = Math.min(ax1, ax2);
		minx = Math.min(minx, bx1);
		minx = Math.min(minx, bx2);
		
		int miny = Math.min(ay1, ay2);
		miny = Math.min(miny, by1);
		miny = Math.min(miny, by2);
		
		int maxx = Math.max(ax1, ax2);
		maxx = Math.max(maxx, bx1);
		maxx = Math.max(maxx, bx2);
		
		int maxy = Math.max(ay1, ay2);
		maxy = Math.max(maxy, by1);
		maxy = Math.max(maxy, by2);
		
		s = Math.max(maxy-miny, maxx-minx);
	}
	
	static void solve() {
		out.println(s*s);
	}
}
