import java.io.*;
import java.util.*;

public class CodeForcesWhiteSheet {
	static Scanner in;
	static PrintWriter out;
	static point a, b, c;	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(System.in);
		
		init();
		solve();
		
		in.close();
	}
	
	static void init() {
		a = new point(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
		b = new point(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
		c = new point(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
	}
	
	static void solve() {
		long overlap = ol(a, b) + ol(a, c) - ol(a, b, c);
		
		/*System.out.println(ol(a, b));
		System.out.println(ol(a, c));
		System.out.println(ol(a, b, c));*/
		
		long area = Math.abs(a.x1 - a.x2) * Math.abs(a.y1-a.y2);
		
		//System.out.println(area);
		
		if(overlap < area) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}
	
	static long ol(point a, point b) {
		long lx = Math.max(a.x1, b.x1);
		long rx = Math.min(a.x2, b.x2);
		long by = Math.max(a.y1, b.y1);
		long uy = Math.min(a.y2, b.y2);
		
		long w = rx - lx;
		long l = uy - by;
		
		if(w < 0 || l < 0) {
			return 0;
		}
		return w*l;
	}
	
	static long ol(point a, point b, point c) {
		long lx = Math.max(Math.max(c.x1, b.x1), a.x1);
		long rx = Math.min(Math.min(c.x2, b.x2), a.x2);
		long by = Math.max(Math.max(c.y1, b.y1), a.y1);
		long uy = Math.min(Math.min(c.y2, b.y2), a.y2);
		
		long w = rx - lx;
		long l = uy - by;
		
		if(w < 0 || l < 0) {
			return 0;
		}
		return w*l;
	}
	
	static class point{
		long x1, y1, x2, y2;
		point(long a, long b, long c, long d){
			x1 = a;
			y1 = b;
			x2 = c;
			y2 = d;
		}
	}
}
