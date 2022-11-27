import java.io.*;
import java.util.*;

public class USACoCross1 {
	static Scanner in;
	static PrintWriter out;
	static int n;
	static HashMap<Integer, Integer> cow;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(new File("crossroad.in"));
		out = new PrintWriter(new File("crossroad.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		n = in.nextInt();
		cow = new HashMap<Integer, Integer>();
	}
	
	static void solve() {
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			int id = in.nextInt();
			int pos = in.nextInt();
			if(cow.containsKey(id)) {
				if(pos != cow.get(id)) {
					cnt++;
				}
			}
			cow.put(id, pos);
		}
	}
}
