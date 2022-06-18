import java.util.Arrays;
import java.util.Scanner;

public class CsesMissingNumber {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long f = in.nextLong();
		in.nextLine();
		
		long sum = 0;
		for(int i = 0; i < f-1; i++) {
			sum += in.nextLong();
		}
		
		long og = (f*(f+1))/2;
		
		System.out.println(og-sum);
	}
}
