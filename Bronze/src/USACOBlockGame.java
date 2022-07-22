import java.io.*;
import java.util.*;

public class USACOBlockGame {
	static Scanner in;
	static PrintWriter out;
	static int n;
	static int[] a, b, c;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(new File("blocks.in"));
		out = new PrintWriter(new File("blocks.out"));
		
		init();
		
		in.close();
		out.close();
	}
	
	static void init() {
		n = Integer.parseInt(in.nextLine());
		c = new int[26];
		for(int i = 0; i < n; i++) {
			solve();
		}
		for(int i = 0 ; i < 26; i++) {
			out.println(c[i]);
		}
	}
	
	static void solve() {
		a = new int[26];
		b = new int[26];
		
		String s1 = in.next();
		String s2 = in.next();
		
		for(int i = 0; i < s1.length(); i++) {
			a[s1.charAt(i)-'a']++;
		}
		
		for(int i = 0; i < s2.length(); i++) {
			b[s2.charAt(i)-'a']++;
		}
		
		for(int i = 0; i < 26; i++) {
			c[i] += Math.max(a[i], b[i]);
		}
	}
}
