import java.io.*;
import java.util.*;

public class USACOMixingMilk {
	static Scanner in;
	static PrintWriter out;
	static int[] c, f;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(new File("mixmilk.in"));
		out = new PrintWriter(new File("mixmilk.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		c = new int[3];
		f = new int[3];
		for(int i = 0; i < 3; i++) {
			c[i] = in.nextInt();
			f[i] = in.nextInt();
		}
	}
	
	static void solve() {
		for(int i = 0; i < 100; i++) {
			if(c[(i+1)%3]-f[(i+1)%3] >= f[i%3]) {
				f[(i+1)%3] += f[i%3];
				f[i%3] = 0;
			}else {
				f[i%3] = f[i%3]-(c[(i+1)%3]-f[(i+1)%3]);
				f[(i+1)%3] = c[(i+1)%3];
			}
		}
		for(int i = 0; i < 3; i++) {
			out.println(f[i]);
		}
	}
}
