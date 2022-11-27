import java.util.*;
import java.io.*;

public class CodeForcesBinarySearch {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int q = in.nextInt();
		int[] num = new int[n];
		int[] search = new int[q];
		
		for(int i = 0; i < n; i++) {
			num[i] = in.nextInt();
		}
		for(int i = 0; i < q; i++) {
			search[i] = in.nextInt();
		}
		
		for(int i = 0; i < q; i++) {
			if(Arrays.binarySearch(num, search[i]) < 0) {
				System.out.println("NO");
			}else {
				System.out.println("YES");
			}
		}
	}
}
