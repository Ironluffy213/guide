import java.io.*;
import java.util.*;

public class USACOCowSignal {
	static Scanner in;
	static PrintWriter out;
	static int m, n, k;
	static char[][] b;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(new File("cowsignal.in"));
		out = new PrintWriter(new File("cowsignal.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		m = in.nextInt();
		n = in.nextInt();
		k = in.nextInt();
		in.nextLine();
		m = m*k;
		n = n*k;
		b = new char[m][n];
	}
	
	static void solve() {
		for(int i = 0; i < m; i+=k) {
			String temp = in.nextLine();
			for(int j = 0; j < n; j += k) {
				for(int l = 0; l < k; l++) {
					b[i+l][j] = temp.charAt(j/k);
					b[i][j+l] = temp.charAt(j/k);
					b[i+l][j+l] = temp.charAt(j/k);
				}
			}
		}
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				out.print(b[i][j]);
			}
			out.println();
		}
	}
}
