import java.io.*;
import java.util.*;

public class USACOSqaurePasture {
	static Scanner in;
	static PrintWriter out;
	static boolean[][] b;
	static int[] c;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(new File("square.in"));
		out = new PrintWriter(new File("square.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		b = new boolean[11][11];
		c = new int[8];
		for(int i = 0; i < 2; i++) {
			int x1 = in.nextInt();
			int y1 = in.nextInt();
			int x2 = in.nextInt();
			int y2 = in.nextInt();
			int min = Math.min(x1, x2);
			int max = Math.max(x1, x2);
			int mi = Math.min(y1, y2);
			int ma = Math.max(y1, y2);
			for(int j = min; j <= max; j++) {
				for(int k = mi; k <= ma; k++) {
					b[j][k] = true;
				}
			}
		}
		
		boolean start = false;
		boolean end = false;
		for(int i = 0; i < 11; i++) {
			for(int j = 0; j < 11; j++) {
				if(!start && b[i][j] == true) {
					c[0] = i;
					c[1] = j;
					c[2] = i;
					start = true;
				}
				if(start && b[i][j] == true && b[i][j+1] == false && i == c[0]) {
					c[3] = j;
				}
				if(b[i][j] == true && b[i+1][j] == false && !end) {
					c[4] = i;
					c[5] = j;
					c[6] = i;
					end = true;
				}
				if(end && b[i][j] == true && b[i][j+1] == false && b[i+1][j] == false && i == c[4]) {
					c[7] = j;
				}
			}
		}
		System.out.println(Arrays.toString(c));
	}
	
	static void solve() {
		
	}
}
