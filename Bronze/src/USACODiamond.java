import java.io.*;
import java.util.*;

public class USACODiamond {
	static Scanner in;
	static PrintWriter out;
	static int n, k;
	static int[] size;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(new File("diamond.in"));
		out = new PrintWriter(new File("diamond.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		n = in.nextInt();
		k = in.nextInt();
		size = new int[n];
		
		for(int i = 0; i < n; i++) {
			size[i] = in.nextInt();
		}
	}
	
	static void solve() {
		int cnt = 0;
		for(int i = 0; i < n-1; i++) {
			int max = 0;
			int ind = 0;
			boolean chng = false;
			if(size[i] == 0) {
				continue;
			}
			for(int j = i+1; j < n; j++) {
				if(size[j] == 0) {
					continue;
				}
				int diff = Math.abs(size[i]-size[j]);
				
				if(max < diff && diff <= k) {
					max = diff;
					ind = j;
					chng = true;
				}
			}
			if(chng) {
				size[ind] = 0;
			}
			cnt++;
		}
		out.println(cnt*2);
	}
}
