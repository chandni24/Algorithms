import java.util.Scanner;

public class coinChange {

	public long coinChangeFnc(int[] S, int M, int N) {
		long[][] count = new long[M][N+1];
		int i, j, x, y;
		for(i=0; i<M; i++)
				count[i][0] = 1;
				
		for(i=0; i<M; i++) {
			for(j=1; j<=N; j++) {				
				
				x = (int) (i > 0?count[i-1][j]:0);
				y = (int) (j-S[i] >= 0?count[i][j-S[i]]:0);
				//System.out.println("see "+i+"\t"+j);
				//System.out.println(x+"\t"+y);
				count[i][j] = x + y;
			}
		}
		//System.out.println("check "+M+"\t"+N+"\t"+count.length+"\t"+count[0].length);
		return count[M-1][N];
	}

	public static void main(String[] args) {
		coinChange ccf = new coinChange();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] S = new int[M];
		for(int i=0; i<M; i++)
			S[i] = sc.nextInt();
		//int N = 4, M = 3;
		//int[] S = {1, 2, 3};
		//int N = 10, M = 4;
		//int[] S = {2, 5, 3, 6};		
		System.out.println(ccf.coinChangeFnc(S, M, N));
	}
}

/*
Input
245 26
16 30 9 17 40 13 42 5 25 49 7 23 1 44 4 11 33 12 27 2 38 24 28 32 14 50 

Output
64027917156

Input
250 24
41 34 46 9 37 32 42 21 7 13 1 24 3 43 2 23 8 45 19 30 29 18 35 11 

Output
15685693751
*/

/*****Recursive solution
public int coinChangeFnc(int[] S, int M, int N) {
	if(N==0)
		return 1;
	if(M<0 && N>0)
		return 0;
	if(N<0)
		return 0;
	System.out.println(M+"\t"+N);
	return coinChangeFnc(S, M-1, N) + coinChangeFnc(S, M, N-S[M]);
}
*/
