import java.util.*;
import java.io.*;

public class kattisbasketball {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] board = in.nextLine().split("");
		System.out.println(board[board.length-2]);
	}
}
