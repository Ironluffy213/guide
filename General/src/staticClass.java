
public class staticClass {
	public static void main(String[] args) {
		
	}
	
	static class pair implements Comparable<pair> {
		int a, b;
		
		pair(int x, int y){
			a = x;
			b = y;
		}
		
		public String toString() {
			return a+" "+b;
		}
		
		@Override
		public int compareTo(pair that) {
			return this.a-that.a;
		}
	}
}
