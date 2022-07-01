import java.io.*;
import java.util.*;

public class USACOWordProcessor {
	static Scanner in;
	static PrintWriter out;
	static int n, k;
	static String[] og;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(new File("word.in"));
		out = new PrintWriter(new File("word.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		n = in.nextInt();
		k = in.nextInt();
		in.nextLine();
		og = in.nextLine().split(" ");
	}
	
	static void solve() {
		int len = 0;
		ArrayList<String> let = new ArrayList<String>();
		if(og.length == 0) {
			out.println("");
		}else if(og.length == 1) {
			out.println(og[0]);
		}else {
			for(int i = 0; i < og.length; i++) {
				if(len + og[i].length() <= k) {
					let.add(og[i]);
					len += og[i].length();
				}else {
					for(int j = 0; j < let.size(); j++) {
						if(j == let.size()-1) {
							out.print(let.get(j));
							break;
						}
						out.print(let.get(j) + " ");
					}
					out.println();
					let.clear();
					let.add(og[i]);
					len = og[i].length();
				}
			}
			for(int j = 0; j < let.size(); j++) {
				if(j == let.size()-1) {
					out.print(let.get(j));
					break;
				}
				out.print(let.get(j) + " ");
			}
			out.println();
		}
	}
}
