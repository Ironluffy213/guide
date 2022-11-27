import java.io.*;
import java.util.*;

public class TreeCutting {
	static Scanner in;
	static int n, m;
	static int[] a;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(System.in);
		
		init();
		solve();
		
		in.close();
	}
	
	static void init() throws IOException {
		n = in.nextInt();
		m = in.nextInt();
		a = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		Arrays.sort(a);
		//System.out.println(Arrays.toString(a));
	}
	
	static void solve() {
		int l = 0;
		int h = a[n-1];
		int mid = 0;
		int ans = 0;
		
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
	
	static boolean check(int mid) {
		int s = 0;
		
		for(int i = 0; i < n; i++) {
			if(a[i]-mid > 0) {
				s += (a[i]-mid);
			}
		}
		
		return s>=m;
	}
}
