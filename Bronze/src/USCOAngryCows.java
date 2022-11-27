import java.io.*;
import java.util.*;

public class USCOAngryCows {
	static BufferedReader in;
	static PrintWriter out;
	static int n, k;
	static int[] a;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new BufferedReader(new FileReader("angry.in"));
		out = new PrintWriter(new File("angry.out"));
		
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
		Arrays.sort(a);
		//System.out.println(Arrays.toString(a));
	}
	
	static void solve() {
		int l = 0;
		int h = 500000000;
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
		int s = a[0];
		int c = 1;
		
		for(int i = 0; i < n; i++) {
			if(a[i]-s > m*2) {
				c++;
				s = a[i];
			}
		}
		
		return c<=k;
	}
}
