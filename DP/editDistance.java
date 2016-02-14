import java.util.Arrays;
import java.util.Scanner;
public class editDistance {

	public int min(int x, int y, int z) {
		return (x<=y)?((x<=z)?x:z):((y<=z)?y:z);
	}

	public int eD(String a, String b, int m, int n) {
		//System.out.println(m+"\t"+n);
		int[][] save = new int[m+1][n+1];
		for(int i=0; i<=m; i++) {
			for(int j=0; j<=n; j++) {
				if(i == 0)
					save[i][j] = j;
				else if(j == 0)
					save[i][j] = i;
				else if(a.charAt(i-1) == b.charAt(j-1)) {
					//System.out.println(a.charAt(m-1)+"\t"+b.charAt(n-1)+"\n");
					save[i][j] = eD(a, b, i-1, j-1);
				}
				else
					save[i][j] = 1 + min(save[i][j-1],
										save[i-1][j],
										save[i-1][j-1]);
			}
		}
		
		return save[m][n];
	}

	public static void main(String[] args) throws Exception {
		editDistance editDis = new editDistance();
		Scanner sc = new Scanner(System.in);
		//String a = sc.next();
		//String b = sc.next();
		String a = "sunday", b = "saturday";
		//String a = "a", b = "x";
		int m = a.length();
		int n = b.length();
		
		//Arrays.fill(save, 3);
		int cost = editDis.eD(a, b, m, n);
		System.out.println(cost);

	}
}
