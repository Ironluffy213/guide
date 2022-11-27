import java.io.*;
import java.util.*;

public class USACOConvention {
	static BufferedReader in;
	static PrintWriter out;
	static int n, m, c;
	static int[] a;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new BufferedReader(new FileReader("convention.in"));
		out = new PrintWriter(new File("convention.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		a = new int[n];
		
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		//System.out.println(Arrays.toString(a));
	}
	
	static void solve() {
		long l = 0;
		long h = a[n-1]-a[0];
		long mid = 0;
		long ans = 0;
		
		while(l <= h) {
			mid = (l+h)/2;
			if(check(mid)) {
				ans = mid;
				h = mid-1;
			}else {
				l = mid+1;
			}
		}
		
		out.println(ans);
	}
	
	static boolean check(long mid) {
		long start = a[0];
		long bus = 1;
		long cow = 0;
		
		for(int i = 0; i < n; i++) {
			long w = a[i] - start;
			cow++;
			if(w > mid || cow > c) {
				bus++;
				start = a[i];
				cow = 1;
			}
		}
		
		return bus <= m;
	}
}
