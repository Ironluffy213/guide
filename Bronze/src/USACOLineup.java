import java.io.*;
import java.util.*;

public class USACOLineup {
	static Scanner in;
	static PrintWriter out;
	static int n;
	static ArrayList<String> c;
	static ArrayList<String> p;
	static HashMap<String, String> m1; 
	static String[] cow = {"Bessie", "Buttercup", "Belinda", "Beatrice", "Bella", "Blue", "Betsy", "Sue"};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(new File("lineup.in"));
		out = new PrintWriter(new File("lineup.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		n = in.nextInt();
		in.nextLine();
		c = new ArrayList<String>();
		Arrays.sort(cow);
		
		m1 = new HashMap<String, String>();
		
		for(int i = 0; i < 8; i++) {
			m1.put(cow[i], i+"");
		}
		
		//System.out.println(m1);
		
		for(int i = 0; i < n; i++) {
			String f = m1.get(in.next());
			in.next();
			in.next();
			in.next();
			in.next();
			String s = m1.get(in.next());
			c.add(f+s);
			c.add(s+f);
		}
		
		p = new ArrayList<String>();
		
	}
	
	static void solve() {
		perm("01234567", "");
		String ans = "";
		
		for(int i = 0; i < p.size(); i++) {
			String s = p.get(i);
			int cnt = 0;
			for(int j = 0; j < n*2; j++) {
				if(s.contains(c.get(j))) {
					cnt++;
				}
			}
			if(cnt == n) {
				ans = s;
				break;
			}
		}
		for(int i = 0; i < 8; i++) {
			out.println(cow[ans.charAt(i)-'0']);
		}
	}
	
	static void perm(String f, String s) {
		if(f.length() == 0) {
			p.add(s);
		}
		
		for(int i = 0; i < f.length(); i++) {
			String t1 = f;
			String t2 = s;
			t2 = s + f.charAt(i);
			t1 = f.substring(0, i) + f.substring(i+1);
			perm(t1, t2);
		}
	}
}
