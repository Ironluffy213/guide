import java.io.*;
import java.util.*;

public class USACOSocialDist {
	static BufferedReader in;
	static PrintWriter out;
	static int n, k;
	static pair[] a;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new BufferedReader(new FileReader("socdist.in"));
		out = new PrintWriter(new File("socdist.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		a = new pair[k];
		
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(in.readLine());
			a[i] = new pair(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
		}
		Arrays.sort(a);
		//System.out.println(Arrays.toString(a));
	}
	
	static void solve() {
		long l = 1;
		long h = (long)Math.pow(10, 18);
		long m = 0;
		long ans = 0;
		
		while(l <= h) {
			m = (l+h)/2;
			if(check(m)) {
				ans = m;
				l = m+1;
			}else {
				h = m-1;
			}
		}
		
		out.println(ans);
	}
	
	static boolean check(long m) {
		long cow = 1;
		long cur = a[0].s;
		
		for(pair p: a) {
			while(Math.max(cur+m, p.s) <= p.e) {
				cur = Math.max(cur+m, p.s);
				cow++;
				if(cow == n) {
					return true;
				}
			}
		}
		return false;
	}
	
	static class pair implements Comparable<pair> {
		long s, e;
		
		pair(long a, long b){
			s = a;
			e = b;
		}
		
		public String toString() {
			return s+" "+e;
		}
		
		@Override
		public int compareTo(pair that) {
			if(this.s>that.s) {
				return 1;
			}
			return -1;
		}
	}
}
