import java.io.*;
import java.util.*;

public class USACOTeleporter {
	static Scanner in;
	static PrintWriter out;
	static int a, b, x, y;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(new File("teleport.in"));
		out = new PrintWriter(new File("teleport.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		a = in.nextInt();
		b = in.nextInt();
		x = in.nextInt();
		y = in.nextInt();
	}
	
	static void solve() {
		int l1 = Math.abs(a-b);
		int l2 = Math.abs(a-x)+Math.abs(b-y);
		int l3 = Math.abs(a-y)+Math.abs(b-x);
		
		
		int min = Math.min(Math.min(l2, l3), Math.min(l1, l2));
		
		out.println(min);
	}
}
