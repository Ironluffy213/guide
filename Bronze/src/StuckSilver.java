import java.awt.desktop.SystemSleepEvent;
import java.io.*;
import java.util.*;

public class StuckSilver {
	static Scanner in;
	static int n;
	static int[] dist;
	static boolean[] stuck;
	static LinkedList<cows> E, N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(System.in);
		
		init();
		solve();
		
		in.close();
	}
	
	static void init() {
		n = Integer.parseInt(in.nextLine());
		dist = new int[n];
		stuck = new boolean[n];
		
		E = new LinkedList<cows>();
		N = new LinkedList<cows>();
		
		for(int i = 0; i < n; i++) {
			char d = in.next().charAt(0);
			int x = in.nextInt();
			int y = in.nextInt();
			
			if(d == 'E') {
				E.add(new cows(i, x, y));
			}else {
				N.add(new cows(i, x, y));
			}
		}
		
		
		Collections.sort(E, new Comparator<cows>() {
			@Override
			public int compare(StuckSilver.cows o1, StuckSilver.cows o2) {
				return o1.y-o2.y;
			}
		});
		
		Collections.sort(N, new Comparator<cows>() {
			@Override
			public int compare(StuckSilver.cows o1, StuckSilver.cows o2) {
				return o1.x-o2.x;
			}
		});
	}
	
	static void solve() {
		for(cows e: E) {
			for(cows n:N) {
				if(n.x < e.x || n.y > e.y || stuck[n.id] || stuck[e.id]) {
					continue;
				}
				
				int dx = n.x-e.x;
				int dy = e.y-n.y;
				
				if(dx > dy) {
					stuck[e.id] = true;
					dist[n.id] += dist[e.id]+1;
				}else if(dx < dy) {
					stuck[n.id] = true;
					dist[e.id] += dist[n.id]+1;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int n:dist) {
			sb.append(n).append("\n");
		}
		
		System.out.print(sb.toString());
	}
	
	static class cows{
		int id, x, y;
		
		cows(int a, int b, int c){
			id = a;
			x = b;
			y = c;
		}
		
		public String toString() {
			return id+" "+x+" "+y;
		}
	}
}
