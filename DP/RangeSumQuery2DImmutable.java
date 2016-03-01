/*
 * Given a 2D matrix, find the sum of the elements inside the rectangle defined by (row1, col1), (row2, col2).
 *
 *  Given matrix = [
 * [3, 0, 1, 4, 2],
 * [5, 6, 3, 2, 1],
 * [1, 2, 0, 1, 5],
 * [4, 1, 0, 1, 7],
 * [1, 0, 3, 0, 5]
 * ]
 * 
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 * Note:
 * 
 * You may assume that the matrix does not change.
 * There are many calls to sumRegion function.
 *
 *@author Chandni
 */

public class RangeSumQuery2DImmutable {
	int[][] sum_m;
    public RangeSumQuery2DImmutable(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){return;}
        
    	sum_m = new int[matrix.length][matrix[0].length];
		//System.out.println(matrix.length+"\t"+matrix[0].length);
    	for(int i=0; i < matrix.length; i++) {
    		for(int j=0; j < matrix[0].length; j++) {
    			//System.out.println(i+"\t"+j+"\t"+matrix[0].length);
    			if(i == 0 && j == 0)
    				sum_m[i][j] = matrix[i][j];
    			else if(i == 0 && j != 0)
    				sum_m[i][j] = sum_m[i][j-1] + matrix[i][j];
    			else if(i != 0 && j == 0)
    				sum_m[i][j] = sum_m[i-1][j] + matrix[i][j];
    			else
    				sum_m[i][j] = sum_m[i][j-1] + sum_m[i-1][j] - sum_m[i-1][j-1] + matrix[i][j];
    		}
    	}
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
    	return (sum_m[row2][col2] - sum_m[row2][col1-1] - sum_m[row1-1][col2] + sum_m[row1-1][col1-1]);
    }
    
	public static void main(String[] args) {
		int[][] matrix = {{3, 0, 1, 4, 2},
		               {5, 6, 3, 2, 1},
		               {1, 2, 0, 1, 5},
		               {4, 1, 0, 1, 7},
		               {1, 0, 3, 0, 5}};
		RangeSumQuery2DImmutable numMatrix = new RangeSumQuery2DImmutable(matrix);
		System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
		System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
		System.out.println(numMatrix.sumRegion(1, 2, 2, 4));
	}
}
