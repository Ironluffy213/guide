import java.io.*;
import java.util.*;

public class USACOCensoring {
	static Scanner in;
	static PrintWriter out;
	static String s, t;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(new File("censor.in"));
		out = new PrintWriter(new File("censor.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		s = in.nextLine();
		t = in.nextLine();
	}
	
	static void solve() {
		StringBuilder sb = new StringBuilder();
		int len = t.length();
		
		for(int i = 0; i < s.length(); i++) {
			sb.append(s.charAt(i));
			if(sb.length() >= len && sb.substring(sb.length()-len).equals(t)) {
				sb.delete(sb.length()-len, sb.length()+1);
			}
		}
		
		out.println(sb);
	}
}
