
/*
 1 2 6 10 = 19
 1 2 6 11 = 20
 1 2 3 11 = 17
 1 2 3 12 = 18
 1 5 3 11 = 20
 1 5 3 12 = 21
 1 5 4 12 = 22
 1 5 4 13 = 23
 
*/

public class MaxPathArray {
	static int maxPath(int [][] arr) {
		int n = arr.length; //number of elements in last row = 3
		int [][] max = new int[n][n];

		for(int i=0; i< n; i++) {
			max[n-1][i] = arr[n-1][i];
		}

		while(--n >=0) {
			for(int i=0; i< n; i++) {
				max[n-1][i] = Math.max(max[n][i]+arr[n-1][i], max[n][i+1]+arr[n-1][i]);
			}
		}

		return max[0][0];
	}

	public static void main(String[] args) {
		int[][] arr =  {{1}, {2,5}, {6,3,4}, {10, 11, 12, 13}};
		System.out.println(maxPath(arr));

	}
}
