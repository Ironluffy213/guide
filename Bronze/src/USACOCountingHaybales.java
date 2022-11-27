import java.io.*;
import java.util.*;

public class USACOCountingHaybales {
	static Scanner in;
	static PrintWriter out;
	static int n, q;
	static int[] hay;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(new File("haybales.in"));
		out = new PrintWriter(new File("haybales.out"));
		
		init();
		
		in.close();
		out.close();
	}
	
	static void init() throws IOException {
		n = in.nextInt();
		q = in.nextInt();
		hay = new int[n];
		
		for(int i = 0; i < n; i++) {
			hay[i] = in.nextInt();
		}
		Arrays.sort(hay);
		
		//System.out.println(Arrays.toString(hay));
		
		for(int i = 0; i < q; i++) {
			solve();
		}
	}
	
	static void solve() {
		int l = in.nextInt();
		int u = in.nextInt();
		
		int t1 = Arrays.binarySearch(hay, l);
		int t2 = Arrays.binarySearch(hay, u);
		
		if(t1 < 0) {
			t1 = Math.abs(t1)-1;
		}
		if(t2 < 0) {
			t2 = Math.abs(t2)-2;
		}
		
		out.println(t2-t1+1);
	}
}
