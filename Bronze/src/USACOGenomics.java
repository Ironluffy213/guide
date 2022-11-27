import java.io.*;
import java.util.*;

public class USACOGenomics {
	static Scanner in;
	static PrintWriter out;
	static int n, m;
	static char[][] a;
	static HashSet<Character> s, p;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(new File("cownomics.in"));
		out = new PrintWriter(new File("cownomics.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		n = in.nextInt();
		m = in.nextInt();
		
		a = new char[n*2][];
		
		for(int i = 0; i < n*2; i++) {
			a[i] = in.next().toCharArray();
		}
	}
	
	static void solve() {
		int ans = 0;
		
		for(int i = 0; i < m; i++) {
			if(check(i)) {
				ans++;
			}
		}
		
		out.println(ans);
	}
	
	static boolean check(int i) {
		s = new HashSet<Character>();
		p = new HashSet<Character>();
		
		for(int j = 0; j < n; j++) {
			s.add(a[j][i]);
		}
		
		for(int j = n; j < n*2; j++) {
			p.add(a[j][i]);
		}
		
		for(char c:s) {
			if(p.contains(c)) {
				return false;
			}
		}
		return true;
	}
}
