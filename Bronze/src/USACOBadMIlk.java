import java.io.*;
import java.util.*;


public class USACOBadMIlk {
	static Scanner in;
	static PrintWriter out;
	static int n, m, d, s;
	static triple[] drink;
	static pair[] sick;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(new File("badmilk.in"));
		out = new PrintWriter(new File("badmilk.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		n = in.nextInt();
		m = in.nextInt();
		d = in.nextInt();
		s = in.nextInt();
		drink = new triple[d];
		sick = new pair[s];
		
		for(int i = 0; i < d; i++) {
			drink[i] = new triple(in.nextInt(), in.nextInt(), in.nextInt());
		}
		Arrays.sort(drink);
		
		for(int i = 0; i < s; i++) {
			sick[i] = new pair(in.nextInt(), in.nextInt());
		}
		Arrays.sort(sick);
		
		//System.out.println(Arrays.toString(drink));
	}
	
	static void solve() {
		ArrayList<Integer> pos = new ArrayList<Integer>();
		int p = 0;
		while(sick[0].y >= drink[p].t) {
			pos.add(drink[p].m);
			p++;
		}
		//System.out.println(pos);
		
		int cnt = 0;
		for(int i = 0; i < d; i++) {
			for(int j = 0; j < s; j++) {
				if(sick[j].x == drink[i].p && sick[j].y <= drink[i].t && ) {
					cnt++;
				}else if(sick[j].x != drink[i].p) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
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
            if(this.y>that.y) {
            	return 1;
            }else if(this.y == that.y) {
            	if(this.x<that.x) {
                	return 1;
                }
            }else {
            	if(this.x < that.x) {
                	return 1;
                }
            }
            return -1;
        }
    }
	static class triple implements Comparable<triple>{
        int p, m ,t;
        
        triple(int a, int b, int c){
            p = a;
            m = b;
            t = c;
        }
        
        public String toString() {
            return p+" "+m+" "+t;
        }

       public int compareTo(triple that) {
    	   if(this.t >= that.t) {
    		   return 1;
    	   }
    	   return -1;
       }
    }
}
