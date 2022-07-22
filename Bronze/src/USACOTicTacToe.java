import java.io.*;
import java.util.*;

public class USACOTicTacToe {
	static Scanner in;
	static PrintWriter out;
	static char[][] b;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(new File("tttt.in"));
		out = new PrintWriter(new File("tttt.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		b = new char[3][3];
		for(int i = 0; i < 3; i++) {
			String t = in.nextLine();
			for(int j = 0; j < 3; j++) {
				b[i][j] = t.charAt(j);
			}
		}
	}
	
	static void solve() {
		int ind = 0;
		int team = 0;
		int diff = 0;
		boolean one = false;
		
		for(int i = 0; i < 3; i++) {
			if(b[i][0] != b[i][1]) {
				diff++;
			}
			if(b[i][2] != b[i][1]) {
				diff++;
			}
			if(b[i][0] != b[i][2]) {
				diff++;
			}
			if(b[i][0] == b[i][1] && b[i][1] == b[i][2]) {
				ind++;
				one = true;
			}
			if(diff < 3 && !one) {
				team++;
			}
			one = false;
		}
		
		for(int i = 0; i < 3; i++) {
			if(b[0][i] != b[1][i]) {
				diff++;
			}
			if(b[2][i] != b[1][i]) {
				diff++;
			}
			if(b[0][i] != b[2][i]) {
				diff++;
			}
			if(b[0][i] == b[1][i] && b[1][i] == b[2][i]) {
				ind++;
			}
			if(diff < 3 && !one) {
				team++;
			}
			one = false;
		}
		
		if(b[0][0] == b[1][1] && b[1][1] == b[2][2]) {
			ind++;
		}
		
		if(b[0][2] == b[1][1] && b[1][1] == b[2][0]) {
			ind++;
		}
		
		out.println(ind);
		out.println(team);
		
		
	}
}
