import java.io.*;
import java.util.*;

public class USACOGuess {
	static Scanner in;
	static PrintWriter out;
	static int n;
	static String[] ani;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(new File("guess.in"));
		out = new PrintWriter(new File("guess.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		n = in.nextInt();
		in.nextLine();
		ani = new String[n];
		
		for(int i = 0; i < n; i++) {
			ani[i] = in.nextLine();
		}
	}
	
	static void solve() {
		int q = 0;
		while(true) {
			q++;
			String word = "";
			for(int i = 0; i < n; i++) {
				if(ani[i].equals("")) {
					continue;
				}
				String[] temp = ani[i].split(" ");
				int cnt = 0;
				int max = 0;
				for(int j = 0; j < temp.length; j++) {
					for(int k = i+1; k < n; k++) {
						if(ani[k].contains(temp[j])) {
							cnt++;
						}
					}
					if(cnt > max) {
						cnt = max;
						word = temp[j];
					}
				}
			}
			int c = 0;
			for(int i = 0; i < n; i++) {
				if(!ani[i].contains(word)) {
					ani[i] = "";
				}else {
					c++;
				}
			}
			if(c == 1) {
				break;
			}
		}
		
		out.println(q);
	}
}
