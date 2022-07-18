import java.io.*;
import java.util.*;

public class USACOBovineShuffle {
	static Scanner in;
	static PrintWriter out;
	static int n;
	static int[] shuffle, order;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(new File("shuffle.in"));
		out = new PrintWriter(new File("shuffle.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		n = in.nextInt();
		shuffle = new int[n];
		order = new int[n];
		for(int i = 0; i < n; i++) {
			shuffle[i] = in.nextInt()-1;
		}
		for(int i = 0; i < n; i++) {
			order[i] = in.nextInt();
		}
	}
	
	static void solve() {
		for(int i = 0; i < 3; i++) {
			int temp = 0;
			for(int j = 0; j < n-1; j++) {
				temp = order[j];
				order[j] = order[shuffle[j]];
				order[shuffle[j]] = temp;
			}
		}
		for(int i = 0; i < n; i++) {
			out.println(order[i]);
		}
	}
}
