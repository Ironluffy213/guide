import java.io.*;
import java.util.*;

public class USACOGuess {
	static Scanner in;
	static PrintWriter out;
	static int n;
	static StringTokenizer st;
	static ArrayList<String>[] a;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(new File("guess.in"));
		out = new PrintWriter(new File("guess.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		st = new StringTokenizer(in.nextLine());
		n = Integer.parseInt(st.nextToken());
		a= new ArrayList[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = new ArrayList<String>();
		}
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.nextLine());
			st.nextToken();
			int num = Integer.parseInt(st.nextToken());
			for(int j = 0; j < num; j++) {
				a[i].add(st.nextToken());
			}
		}
		System.out.println(Arrays.toString(a));
	}
	
	static void solve() {
		int cnt = 0;
		for(int i = 0; i < n-1; i++) {
			for(int j = i+1; j < n; j++) {
				int tc = 1;
				for(String s:a[i]) {
					if(a[j].contains(s)) {
						tc++;
					}
				}
				cnt = Math.max(tc, cnt);
			}
		}
		out.println(cnt);
	}
}
