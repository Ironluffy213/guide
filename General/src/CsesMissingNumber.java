import java.util.*;
import java.io.*;

public class CsesMissingNumber {
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*Scanner in = new Scanner(System.in);
		long f = in.nextLong();
		in.nextLine();
		
		long sum = 0;
		for(int i = 0; i < f-1; i++) {
			sum += in.nextLong();
		}
		
		long og = (f*(f+1))/2;
		
		System.out.println(og-sum);*/
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Long.parseLong(in.readLine());
		
		long sum = n*(n+1)/2;
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		for(int i = 0; i < n-1; i++) {
			sum -= Long.parseLong(st.nextToken());
		}
		
		System.out.println(sum);
	}
}
