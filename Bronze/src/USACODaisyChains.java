import java.io.*;
import java.util.*;

public class USACODaisyChains {
	static Scanner in;
	static int n;
	static int[] f;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(System.in);
		
		init();
		solve();
		
		in.close();
	}
	
	static void init() {
		n = in.nextInt();
		f = new int[n];
		
		for(int i = 0; i < n; i++) {
			f[i] = in.nextInt();
		}
	}
	
	static void solve() {
		int cnt = n;
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				int avg = 0;
				for(int k = i; k < j; k++) {
					avg += f[k];
				}
				avg /= (j-i+1);
				for(int k = i; k < j; k++) {
					if(avg == f[k]) {
						cnt++;
						break;
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
