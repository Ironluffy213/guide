import java.io.*;
import java.util.*;

public class USACODanceShow {
	static BufferedReader in;
	static PrintWriter out;
	static int n, k;
	static int[] a;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new BufferedReader(new FileReader("cowdance.in"));
		out = new PrintWriter(new File("cowdance.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		a = new int[n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			a[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	static void solve() {
		int l = 0;
		int h = n;
		int m = 0;
		int ans = 0;
		
		while(l <= h) {
			m = (l+h)/2;
			if(check(m)) {
				ans = m;
				h = m-1;
			}else {
				l = m+1;
			}
		}
		
		out.println(ans);
	}
	
	static boolean check(int m) {
		PriorityQueue<Integer> stage = new PriorityQueue<Integer>();
		for(int i = 0; i < m; i++) {
			stage.add(a[i]);
		}
		for(int i = m; i < n; i++) {
			int t = stage.poll()+a[i];
			if(t > k) {
				return false;
			}
			stage.add(t);
		}
		return true;
	}
}
