import java.util.*;
import java.io.*;

public class C {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int q = in.nextInt();
		TreeMap<Integer, Integer> ts = new TreeMap<Integer, Integer>();
		
		int s = 0;
		for(int i = 1; i <= n; i++) {
			int num = in.nextInt();
			if(!ts.containsKey(num)) {
				ts.put(num, i);
			}
		}
		for(int i = 0; i < q; i++) {
			int num = in.nextInt();
			if(ts.containsKey(num)) {
				System.out.println(ts.get(num));
			}else if(ts.higherKey(num) == null) {
				System.out.println(n+1);
			}else {
				System.out.println(ts.get(ts.higherKey(num)));
			}
		} 
	}
}
