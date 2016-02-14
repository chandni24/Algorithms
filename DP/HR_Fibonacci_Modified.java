import java.math.BigInteger;
import java.util.Scanner;


public class HR_Fibonacci_Modified {
	public static void main(String[] args) {
		int N;
		BigInteger A, C = BigInteger.ZERO;
		BigInteger B;
		Scanner sc = new Scanner(System.in);
		A = sc.nextBigInteger();
		B = sc.nextBigInteger();
		N = sc.nextInt();
		while(N-2 > 0) {
			C = B.multiply(B).add(A);
			//System.out.println(N+"\t"+C);
			A = B;
			B = C;
			N--;
		}
		System.out.println(C);
	}
}
