import java.io.*;
import java.util.*;

public class USACOPromotionCounting {
	static Scanner in;
	static PrintWriter out;
	static int b1, b2, s1, s2, g1, g2, p1, p2;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(new File("promote.in"));
		out = new PrintWriter(new File("promote.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		b1 = in.nextInt();
		b2 = in.nextInt();
		s1 = in.nextInt();
		s2 = in.nextInt();
		g1 = in.nextInt();
		g2 = in.nextInt();
		p1 = in.nextInt();
		p2 = in.nextInt();
	}
	
	static void solve() {
		int btotal = b1+s1+g1+p1;
		int atotal = b2+s2+g2+p2;
		
		int register = atotal-btotal;
		b1 += register;
		
		int bs = b1-b2;
		out.println(bs);
		s1 += bs;
		
		int sg = s1-s2;
		out.println(sg);
		g1 += sg;
		
		int gp = g1-g2;
		out.println(gp);
	}
}
