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
		if(x > y) {
			g = true;
		}else {
			g = false;
		}
	}
	
	static void solve() {
		int i = 0;
		int d = 0;
		int p  = 0;
		while(true) {
			if(x == y) {
				break;
			}
			d += (int) (Math.pow(2,  i)+p);
			p = (int) (Math.pow(-1, i)*Math.pow(2,  i));
			i++;
			if(g) {
				if(p+x < y) {
					d -= y-(p+x);
					break;
				}
			}else {
				if(p+x > y) {
					d -= (p+x)-y;
					break;
				}
			}
			p = Math.abs(p);
		}
		out.println(d);
	}
}
