import java.io.*;
import java.util.*;

public class USACOSleepingInClass {
	static Scanner in;
	static int n, max;
	static ArrayList<Integer> num;
	static boolean eq;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new Scanner(System.in);
		int t = in.nextInt();
		
		for(int i = 0;i < t; i++) {
			init();
			solve();
		}
		
		in.close();
	}
	
	static void init() {
		n = in.nextInt();
		num = new ArrayList<Integer>();
		eq = false;
		max = 0;
		
		
		for(int i = 0; i < n; i++) {
			num.add(in.nextInt());
			if(i > 0 && num.get(i-1) == num.get(i)) {
				eq = true;
			}else {
				if(max < num.get(i)) {
					max = num.get(i);
				}
				eq = false;
			}
		}
	}
	
	static void solve() {
		int cnt = 0;
		ArrayList<Integer> c = new ArrayList<Integer>();
		if(eq) {
			System.out.println(0);
		}else {
			while(!eq) {
				cnt++;
				for(int i = 0; i < num.size(); i++) {
					if(num.get(i) == max) {
						c.add(max);
					}else {
						if(i+1 > num.size()) {
							break;
						}
						int temp = num.get(i)+num.get(i+1);
						c.add(temp);
						i++;
					}
				}
				for(int i = 0; i < n; i++) {
					if(c.get(i) != c.get(i+1)) {
						eq = false;
						break;
					}
					eq = true;
				}
				num = (ArrayList<Integer>) c.clone();
			}
			System.out.println(cnt);
		}
	}

}
