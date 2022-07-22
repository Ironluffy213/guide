import java.io.*;
import java.util.*;

public class USACOCensoring {
	static Scanner in;
	static PrintWriter out;
	static ArrayList<Character> s, t;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(new File("censor.in"));
		out = new PrintWriter(new File("censor.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		s = new ArrayList<Character>();
		t = new ArrayList<Character>();
		
		String temp = in.nextLine();
		for(int i = 0; i < temp.length(); i++) {
			s.add(temp.charAt(i));
		}
		
		temp = in.nextLine();
		for(int i = 0; i < temp.length(); i++) {
			t.add(temp.charAt(i));
		}
	}
	
	static void solve() {
		for(int i = 0; i < s.size()-t.size(); i++) {
			int same = 0;
			for(int j = 0; j < t.size(); j++) {
				if(s.get(i+j) == t.get(j)) {
					same++;
				}else {
					break;
				}
			}
			if(same == t.size()) {
				for(int j = 0; j < t.size(); j++){
					s.remove(i+j);
				}
				i = 0;
			}
		}
		out.println(s);
	}
}
