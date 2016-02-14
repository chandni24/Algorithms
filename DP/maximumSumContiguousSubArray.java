

import java.util.Scanner;

public class maximumSumContiguousSubArray {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N;
		long[][] sums = new long[T][2];
		for(int x=0; x<T; x++) {
			N = sc.nextInt();
			int[] A = new int[N];
			A[0] = sc.nextInt();
			long max_so_far = A[0], max_ending_here = A[0], non_cont_sum = A[0], min_neg = Integer.MIN_VALUE;
			//System.out.println(max_so_far+"\t"+non_cont_sum);
			for(int i=1; i<N; i++) {
				A[i] = sc.nextInt();
				if(max_ending_here + A[i] > A[i])
					max_ending_here = max_ending_here + A[i];
				else
					max_ending_here = A[i];
				if(max_so_far < max_ending_here)
					max_so_far = max_ending_here;
				if(A[i]>0)
					non_cont_sum = non_cont_sum + A[i];
				//System.out.println("p "+A[i]+"\t"+min_neg);
				if(A[i]<=0 && A[i] > min_neg)
					min_neg = A[i];
			}
			//System.out.println(max_so_far+"\t"+non_cont_sum+"\t"+min_neg);
			sums[x][0] = max_so_far;
			if (max_so_far >= non_cont_sum)
				sums[x][1] = max_so_far;
			else if(non_cont_sum < 0)
				sums[x][1] = min_neg;
			else
				sums[x][1] = non_cont_sum;
		}
		for(int x=0; x<T; x++) {
			System.out.println(sums[x][0]+"\t"+sums[x][1]);
		}
	}
}

/*
* 
1
6
1 -1 -1 -1 -1 5


4
1 2 3 4
2
-100 -1

Input
6
1
1
6
-1 -2 -3 -4 -5 -6
2
1 -2
3
1 2 3
1
-10
6
1 -1 -1 -1 -1 5

* 
Output
1 1
-1 -1
1 1
6 6
-10 -10
5 6
*/