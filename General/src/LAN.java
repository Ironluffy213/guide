import java.io.*;
import java.util.*;

public class LAN {
	static Scanner in;
	static int n, k;
	static int[] a;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(System.in);
		
		init();
		solve();
		
		in.close();
	}
	
	static void init() throws IOException {
		n = in.nextInt();
		k = in.nextInt();
		a = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		Arrays.sort(a);
		//System.out.println(Arrays.toString(a));
	}
	
	static void solve() {
		long l = 1;
		long h = a[n-1];
		long mid = 0;
		long ans = 0;
		
		while(l <= h) {
			mid = (l+h)/2;
			if(check(mid)) {
				ans = mid;
				l = mid+1;
			}else {
				h = mid-1;
			}
		}
		
		System.out.println(ans);
	}
	
	static boolean check(long mid) {
		long s = 0;
		
		for(int i = 0; i < n; i++) {
			s += (a[i]/mid);
		}
		
		return s>=k;
	}
}
