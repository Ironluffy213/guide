import java.io.*;
import java.util.*;

public class USACOLoadBalancing {
	static Scanner in;
	static PrintWriter out;
	static int n, b;
	static pair[] loc;
	static boolean[][] cow;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(new File("balancing.in"));
		out = new PrintWriter(new File("balancing.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		n = in.nextInt();
		b = in.nextInt();
		loc = new pair[n];
		cow = new boolean[b][b];
		
		for(int i = 0; i < n; i++) {
			loc[i] = new pair(in.nextInt(), in.nextInt());
		}
		Arrays.sort(loc);
		System.out.println(Arrays.toString(loc));
		
		for(int i = 0; i < n; i++) {
			cow[loc[i].x][loc[i].y] = true;
		}
	}
	
	static void solve() {
		
	}
	static class pair implements Comparable<pair>{
        int x, y;
        
        pair(int a, int b){
            x = a;
            y = b;
        }
        
        public String toString() {
            return x+" "+y;
        }

        @Override
        public int compareTo(pair that) {
            if(this.x>that.x) {
            	return 1;
            }else if(this.x == that.x) {
            	if(this.y>that.y) {
                	return 1;
                }
            }else {
            	if(this.y > that.y) {
                	return 1;
                }
            }
            return -1;
        }
    }
}
