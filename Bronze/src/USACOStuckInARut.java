import java.io.*;
import java.util.*;

public class USACOStuckInARut {
	static Scanner in;
	static int n;
	static triple[] cow;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(System.in);
		
		init();
		solve();
		
		in.close();
	}
	
	static void init() {
		n = Integer.parseInt(in.nextLine());
		cow = new triple[n];
		
		for(int i = 0; i < n; i++) {
			String[] temp = in.nextLine().split(" ");
			cow[i] = new triple(Integer.parseInt(temp[0]), temp[1], Integer.parseInt(temp[2]));
		}
	}
	
	static void solve() {
		
	}
	
	static class triple implements Comparable<triple> {
		int x, y;
		String dir;
		
		triple(int a, String s, int b){
			x = x;
			y = y;
			dir = s;
		}
		
		public String toString() {
			return dir+" "+x +" "+y;
		}
		
		@Override
		public int compareTo(triple that) {
			if(this.x>that.y) {
				return 1;
			}
			return -1;
		}
	}
}
