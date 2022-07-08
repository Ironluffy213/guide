import java.io.*;
import java.util.*;

public class USACOShellGame {
	static Scanner in;
	static PrintWriter out;
	static int n;
	static ArrayList<Integer>[] swap;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(new File("shell.in"));
		out = new PrintWriter(new File("shell.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		n = in.nextInt();
		swap = new ArrayList[n];
		for(int i = 0; i < n; i++) {
			swap[i] = new ArrayList<Integer>();
			for(int j = 0; j < 3; j++) {
				swap[i].add(in.nextInt()-1);
			}
		}
	}
	
	static void solve() {
		int cnt = 0;
		for(int i = 0; i < 3; i++) {
			boolean[] p = new boolean[3];
			int tc = 0;
			p[i] = true;
			for(int j = 0; j < n; j++) {
				boolean t = p[swap[j].get(0)];
				p[swap[j].get(0)] = p[swap[j].get(1)];
				p[swap[j].get(1)] = t;
				if(p[swap[j].get(2)] == true) {
					tc++;
				}
			}
			if(cnt < tc) {
				cnt = tc;
			}
		}
		out.println(cnt);
	}
	
}
