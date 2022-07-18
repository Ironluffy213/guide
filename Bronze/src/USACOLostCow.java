import java.io.*;
import java.util.*;

public class USACOLostCow {
	static Scanner in;
	static PrintWriter out;
	static int x, y;
	static boolean g;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(new File("lostcow.in"));
		out = new PrintWriter(new File("lostcow.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		x = in.nextInt();
		y = in.nextInt();
	}
	
	static void solve() {
		int m = 1;
		int cur = x;
		int d = 0;
		while(true) {
			int next = x + m;
			if(cur <= y && y <= next) {
				d += Math.abs(y-cur);
				break;
			}
			if(cur > y && y > next) {
				d += Math.abs(y-cur);
				break;
			}
			d += Math.abs(next-cur);
			cur = next;
			m *= -2;
		}
		out.println(d);
	}
}
