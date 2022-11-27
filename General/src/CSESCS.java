import java.io.*;
import java.util.*;

public class CSESCS {
	static Scanner in;
	static ArrayList<String> p;
	static TreeSet<String> c;
	static String idx, s;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(System.in);
		
		init();
		solve();
		
		in.close();
	}
	
	static void init() {
		p = new ArrayList<String>();
		c = new TreeSet<String>();
		s = in.next();
		
		idx = "";
		for(int i = 0; i < s.length(); i++) {
			idx += i;
		}
		
		perm(idx, "");
		//System.out.println(p.size());
	}
	
	static void solve() {
		for(String n:p) {
			
		}
	}
	
	static void perm(String o, String n) {
		if(o.length() == 0) {
			p.add(n);
		}
		for(int i = 0; i < o.length(); i++) {
			String ot = o;
			String nt = n;
			nt = n + o.charAt(i);
			ot = o.substring(0, i) + o.substring(i+1);
			perm(ot ,nt);
		}
	}
}
