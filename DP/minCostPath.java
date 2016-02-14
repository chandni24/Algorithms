
public class minCostPath {

	public int min(int x, int y, int z) {
		return (x<=y)?((x<=z)?x:z):((y<=z)?y:z);
	}

	public int minC(int[][] arr, int m, int n) {
		
		int[][] cost = new int[arr.length][arr[0].length];
		System.out.println(cost.length+"\t"+m);
		cost[0][0] = arr[0][0];
		
		for(int i=1; i<=m; i++) {System.out.println("m "+m); 
			cost[i][0] = cost[i-1][0] + arr[i][0];
		}
		
		for(int i=1; i<=n; i++)
			cost[0][i] = cost[0][i-1] + arr[0][i];
		System.out.println(cost[0][2]);
				
		for(int i=1; i<=m; i++){
			for(int j=1; j<=n; j++){
				cost[i][j] = min(cost[i-1][j-1], cost[i][j-1], cost[i-1][j]) + arr[i][j];
				System.out.println(i+"\t"+j+"\t"+cost[i][j]);
			}
		}
		return cost[m][n];
	}
	public static void main(String[] args) throws Exception {
		minCostPath mcp = new minCostPath();
		int[][] arr = {{1,2,3},{4,8,2},{1,5,3}};
		int m=1, n=2;
		System.out.println(mcp.minC(arr, m, n));
		//System.out.println(arr.length);
	}
}
