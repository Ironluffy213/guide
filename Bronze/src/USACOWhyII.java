import java.io.*;
import java.util.*;

public class USACOWhyII {
	static Scanner in;
	static PrintWriter out;
	static char[] cow;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(new File("circlecross.in"));
		out = new PrintWriter(new File("circlecross.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		cow = new char[52];
		String t = in.nextLine();
		
		for(int i = 0; i < 52; i++) {
			cow[i] = t.charAt(i);
		}
	}
	
	static void solve() {
		int cnt = 0;
				
		for(int i =  0; i < 51; i++) {
			if(cow[i] != cow[i+1]) {
				cnt++;
			}else {
				i++;
			}
		}
		cnt /= 2;
		
		if(cnt%2 == 1) {
			cnt++;
		}
		
		out.println(cnt/2);
	}
}
