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
			//System.out.println(Arrays.toString(temp));
			cow[i] = new triple(temp[0].charAt(0), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]));
			//System.out.println(temp[1]);
		}
		//System.out.println(Arrays.toString(cow));
	}
	
	static void solve() {
		int min = 0;
		for(int i = 0; i < n; i++) {
			min = check(i);
			if(min == Integer.MAX_VALUE) {
				System.out.println("Infinity");
			}else {
				System.out.println(min);
			}
		}
	}
	
	static int check(int i) {
		int min = Integer.MAX_VALUE;
		
		for(int j = 0; j < n; j++) {
			if(i == j || cow[i].dir == cow[j].dir) {
				continue;
			}
			
			int dx = Math.abs(cow[i].x - cow[j].x);
			int dy = Math.abs(cow[i].y - cow[j].y);
			
			if(cow[i].dir == 'E') {
				if(cow[i].x > cow[j].x || cow[i].y < cow[j].y) {
					continue;
				}
				
				if(dx > dy && check(j) >= dy) {
					min = Math.min(min, dx);
				}
			}else {
				if(cow[i].x < cow[j].x || cow[i].y > cow[j].y) {
					continue;
				}
				
				if(dx < dy && check(j) >= dx) {
					min = Math.min(min, dy);
				}
			}
		}
		return min;
	}
	
	static class triple implements Comparable<triple> {
		int x, y;
		char dir;
		
		triple(char s, int a, int b){
			x = a;
			y = b;
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
