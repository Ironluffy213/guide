import java.io.*;
import java.util.*;

public class CSESWeirdAlgorithm {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long f = in.nextLong();
		
		System.out.print(f + " ");
		
		while(f != 1) {
			if(f%2 == 0) {
				f = f/2;
			}else {
				f = f*3+1;
			}
			if(f == 1) {
				System.out.print(f);
				break;
			}
			System.out.print(f + " ");
		}
		System.out.println();
	}
}
