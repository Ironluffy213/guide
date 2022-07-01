import java.io.*;
import java.util.*;

public class USACOBucketBrigade {
	static Scanner in;
	static PrintWriter out;
	static char[][] b;
	static int bx, by, lx, ly, rx, ry;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(new File("buckets.in"));
		out = new PrintWriter(new File("buckets.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		b = new char[10][10];
		for(int i = 0; i < 10; i++) {
			b[i] = in.nextLine().toCharArray();
			for(int j = 0; j < 10; j++) {
				if(b[i][j] == 'B') {
					bx = i;
					by = j;
				}
				if(b[i][j] == 'L') {
					lx = i;
					ly = j;
				}
				if(b[i][j] == 'R') {
					rx = i;
					ry = j;
				}
			}
		}
	}
	
	static void solve() {
		int cnt = 0;
		cnt = Math.abs(bx-lx) + Math.abs(by-ly);
		if(bx == lx) {
			cnt = Math.abs(by-ly);
			if(rx == lx && ((ry < by && ry > ly) || (ry < ly && ry > by))) {
				cnt += 2;
			}
		}else if(by == ly) {
			cnt = Math.abs(bx-lx);
			if(ry == ly && ((rx < bx && rx > lx) || (rx < lx && rx > bx))) {
				cnt += 2;
			}
		}
		cnt -= 1;
		out.println(cnt);
	}
}
