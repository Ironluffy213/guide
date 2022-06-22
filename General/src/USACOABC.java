import java.io.*;
import java.util.*;

public class USACOABC {
	static Scanner in;
	static int[] num;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(System.in);
		
		init();
		solve();
		
		in.close();
	}
	
	static void init() {
		num = new int[7];
		for(int i = 0; i < 7; i++) {
			num[i] = in.nextInt();
		}
		Arrays.sort(num);
	}
	
	static void solve() {
		int A = num[0];
		int B = num[1];
		int C =  num[6]-(A+B);
		System.out.println(A + " " + B + " " + C);
	}
}
