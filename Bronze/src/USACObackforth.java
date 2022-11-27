import java.io.*;
import java.util.*;

public class USACObackforth {
	static Scanner in;
	static PrintWriter out;
	static int[] a1, b1, a2, b2;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(new File("backforth.in"));
		out = new PrintWriter(new File("backforth.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		a1 = new int[10];
		b1 = new int[10];
		
		for(int i = 0; i < 10; i++) {
			a1[i] = in.nextInt();
		}
		
		for(int i = 0; i < 10; i++) {
			b1[i] = in.nextInt();
		}
		
		a2 = new int[10];
		b2 = new int[10];
		
		a2 = a1.clone();
		b2 = b1.clone();
	}
	
	static void solve() {
		HashSet<Integer> bucket = new HashSet<Integer>();
		int m = 1000;
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				int tw = -a1[i] + b1[j];
				int temp = a1[i];
				a1[i] = b1[j];
				b1[j] = temp;
				
				for(int k = 0; k < 10; k++) {
					for(int l = 0; l < 10; l++) {
						int tf = -a1[k]+b1[l];
						bucket.add(m+tw+tf);
					}
				}
				a1 = a2.clone();
				b1 = b2.clone();
			}
		}
		out.println(bucket.size());
	}
}
