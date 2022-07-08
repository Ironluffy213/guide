import java.io.*;
import java.util.*;

public class USACOBucketList {
	static Scanner in;
	static PrintWriter out;
	static int n;
	static int[] b;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(new File("blist.in"));
		out = new PrintWriter(new File("blist.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		b = new int[1001];
		n = in.nextInt();
		for(int i = 0; i < n; i++) {
			int s = in.nextInt();
			int e = in.nextInt();
			int num = in.nextInt();
			for(int j = s; j < e; j++) {
				b[j] += num;
			}
		}
		System.out.println(Arrays.toString(b));
	}
	
	static void solve() {
		int max = 0;
		for(int i = 0; i < 1001; i++) {
			if(b[i] > max) {
				max = b[i];
			}
		}
		out.println(max);
	}
}
