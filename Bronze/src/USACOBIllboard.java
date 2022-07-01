import java.io.*;
import java.util.*;

public class USACOBIllboard {
	static Scanner in;
	static PrintWriter out;
	static long[] c;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(new File("billboard.in"));
		out = new PrintWriter(new File("billboard.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		c = new long[8];
		for(int i = 0; i < 8; i++) {
			c[i] = (long)in.nextInt() + 1000l;
		}
	}
	
	static void solve() {
		long la = Math.abs(c[0]-c[2])*Math.abs(c[1]-c[3]);
		
		long trax = Math.min(c[0], c[2]);
		long tray = Math.min(c[1], c[3]);
		
		long blax = Math.max(c[0], c[2]);
		long blay = Math.max(c[1], c[3]);
		
		long trbx = Math.min(c[4], c[6]);
		long trby = Math.min(c[5], c[7]);

		long blbx = Math.min(c[4], c[6]);
		long blby = Math.min(c[5], c[7]);
		
		long w = Math.min(trax, trbx) - Math.max(blax, blbx);
		long l = Math.min(tray, trby) - Math.max(blay, blby);
		
		long ia = 0;
		if(w > 0 && l > 0) {
			ia = w * l;
		}
		la = la - ia;
		
		out.println(la);
	}
}
