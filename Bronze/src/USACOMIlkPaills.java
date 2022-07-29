import java.io.*;
import java.util.*;

public class USACOMIlkPaills {
	static Scanner in;
	static PrintWriter out;
	static int x, y, m;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(new File("pails.in"));
		out = new PrintWriter(new File("pails.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		x = in.nextInt();
		y = in.nextInt();
		m = in.nextInt();
	}
	
	static void solve() {
		int max = 0;
		for(int i = m; i > 0; i--) {
			if(i%x == 0|| i%y == 0) {
				max = i;
				break;
			}else {
				int temp = i;
				while(true) {
					temp -= x;
					if(temp%y == 0) {
						max = i;
						break;
					}
				}
				temp = i;
				while(true) {
					temp -= y;
					if(temp%x == 0) {
						max = i;
						break;
					}
				}
			}
		}
		out.println(max);
	}
}
