import java.util.*;
import java.io.*;

public class CodeForcesClosestLeft {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int q = in.nextInt();
		TreeMap<Integer, Integer> ts = new TreeMap<Integer, Integer>();
		
		for(int i = 1; i <= n; i++) {
			ts.put(in.nextInt(), i);
		}
		for(int i = 0; i < q; i++) {
			int num = in.nextInt();
			if(ts.containsKey(num)) {
				System.out.println(ts.get(num));
			}else if(ts.lowerKey(num) == null) {
				System.out.println(0);
			}else {
				System.out.println(ts.get(ts.lowerKey(num)));
			}
		} 
	}
}
