import java.io.*;
import java.util.*;

public class USACOMixingMilk {
	static Scanner in;
	static PrintWriter out;
	static ArrayList<Integer>[] b;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(new File("mixmilk.in"));
		out = new PrintWriter(new File("mixmilk.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		b = new ArrayList[3];
		for(int i = 0; i < 3; i++) {
			b[i] = new ArrayList<Integer>();
			for(int j = 0; j < 2; j++) {
				b[i].add(in.nextInt());
			}
			b[i].add(b[i].get(0)-b[i].get(1));
		}
	}
	
	static void solve() {
		for(int i = 0; i < 100; i++) {
			int ind = i%3;
			int ind2 = i%3+1;
			if(ind2 > 2) {
				ind2 = 0;
			}
			
			if(b[ind].get(1) >= b[ind2].get(2)) {
				int t = b[ind].get(1) - b[ind2].get(2);
				
				b[ind].add(t, 1);
				b[ind].remove(2);
				
				b[ind2].add(b[ind2].get(0), 1);
				b[ind2].remove(2);
				b[ind2].add(0, 2);
				b[ind2].remove(3);
				
				t = b[ind].get(0)-t;
				b[ind].add(t, 2);
				b[ind].remove(3);
			}else {
				int t = b[ind].get(1) + b[ind2].get(1);
				
				b[ind].add(0, 1);
				b[ind].remove(2);
				
				b[ind2].add(t, 1);
				b[ind2].remove(2);
				b[ind2].add(b[ind2].get(0) - b[ind2].get(1), 2);
				b[ind2].remove(3);
				
				b[ind].add(b[ind].get(0), 2);
				b[ind].remove(3);
			}
		}
		for(int i = 0; i < 3; i++) {
			out.println(b[i].get(1));
		}
	}
	
}
