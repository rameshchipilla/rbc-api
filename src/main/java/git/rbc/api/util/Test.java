package git.rbc.api.util;

import java.util.Scanner;

public class Test {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
//		scan.nextl
//		int N = 2;
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//        scanner.close();
//		System.out.println(N % 2);
		for (int N = 1; N <= 25; N++) {
//			System.out.println(N);
			if (N % 2 == 0 && (N < 6 || N > 20)) {
//				System.out.println("Not Weird");
			} else {
				System.out.println(N);

			}
		}
	}
}
