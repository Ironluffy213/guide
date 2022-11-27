import java.io.*;
import java.util.*;


public class USACOCowntactTracing {
	static Scanner in;
	static PrintWriter out;
	static int n, t;
	static int[] cow;
	static triple[] infect;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(new File("tracing.in"));
		out = new PrintWriter(new File("tracing.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		n = in.nextInt();
		t = in.nextInt();
		in.nextLine();
		cow = new int[n];
		infect = new triple[t];
		
		String[] temp = in.nextLine().split("");
		for(int i = 0; i < n; i++) {
			cow[i] = Integer.parseInt(temp[i]);
		}
		
		for(int i = 0; i < t; i++) {
			infect[i] = new triple(in.nextInt(), in.nextInt(), in.nextInt());
		}
		Arrays.sort(infect);
		
		System.out.println(Arrays.toString(cow));
	}
	
	static void solve() {
		boolean[] path = new boolean[n];
		ArrayList<Integer> np = new ArrayList<Integer>();
		ArrayList<Integer> p = new ArrayList<Integer>();
		
		int cnt = 0;
		for(int i = 0; i < t; i++) {
			if(cow[infect[i].x-1] == 0 || cow[infect[i].y-1] == 0) {
				path[infect[i].x-1] = false;
				path[infect[i].y-1] = false;
				
				np.add(infect[i].x);
				np.add(infect[i].y);
			}else {
				path[infect[i].x-1] = true;
				path[infect[i].y-1] = true;
				
				p.add(infect[i].x);
				p.add(infect[i].y);
				cnt++;
			}
		}
		
		for(int i = 0; i < p.size(); i++) {
			int temp = p.get(i);
			if(np.contains(temp)) {
				p.remove(i);
			}
		}
		
		System.out.println(p.size() + " " + cnt + " " + )
	}

	static class triple implements Comparable<triple>{
        int t, x ,y;
        
        triple(int a, int b, int c){
            t = a;
            x = b;
            y = c;
        }
        
        public String toString() {
            return t+" "+x+" "+y;
        }

       public int compareTo(triple that) {
    	   if(this.t >= that.t) {
    		   return 1;
    	   }
    	   return -1;
       }
    }
}
