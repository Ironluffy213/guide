import java.io.*;
import java.util.*;

public class USACOStuckInRut2 {
	static Scanner in;
	static int n;
	static int[] dist;
	static boolean[] stuck;
	static LinkedList<cows> N, E;
	
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
				E.add( new cows(i, x, y));
			}else {
				N.add( new cows(i, x, y));
			}
		}
		
		Collections.sort(E, new Comparator<cows>() {
			@Override
			public int compare(USACOStuckInRut2.cows o1, USACOStuckInRut2.cows o2) {
				return o1.y-o2.y;
			}
		});
		
		Collections.sort(N, new Comparator<cows>() {
			@Override
			public int compare(USACOStuckInRut2.cows o1, USACOStuckInRut2.cows o2) {
				return o1.x-o2.x;
			}
		});
		
		//System.out.println(E);
		//System.out.println(N);
	}
	
	static void solve() {
		for(cows e:E) {
			for(cows n:N) {
				if(stuck[n.id] || stuck[e.id] || n.x < e.x || n.y > e.y) {
					continue;
				}
				
				int dx = n.x - e.x;
				int dy = e.y - n.y;
				
				if(dx > dy) {
					stuck[e.id] = true;
					dist[e.id] = dx;
				}else if(dx < dy) {
					stuck[n.id] = true;
					dist[n.id] = dy;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int n: dist) {
			if(n == 0) {
				sb.append("Infinity");
			}else {
				sb.append(n);
			}
			sb.append("\n");
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
