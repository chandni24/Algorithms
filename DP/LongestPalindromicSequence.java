/*
 * Given a sequence, find the length of the longest palindromic subsequence in it. 
 * For example, if the given sequence is “BBABCBCAB”, then the output should be 7 as “BABCBAB” 
 * is the longest palindromic subseuqnce in it. “BBBBB” and “BBCBB” are also palindromic subsequences 
 * of the given sequence, but not the longest ones.
 *
 * @author chandni
 */
public class LongestPalindromicSequence {

	public int countLPS(String s, int i, int j) {
		System.out.println("0 "+s+" "+i+" "+j);
		int count = 0;
		if(i>j)
			return 0;
		else if(i==j) { //System.out.println("2 "+s);
			return 1;
		}
		else if(s.charAt(i) == s.charAt(j)) { //System.out.println("3 "+i+j+s+"\t"+s.substring(i+1,j));
			return 2 + countLPS(s, i+1,j-1);
		}
		else { System.out.println("4 "+s+"\t"+s.substring(i+1,j)+"\t"+s.substring(i,j-1));
			return Math.max(countLPS(s, i+1, j), countLPS(s, i, j-1));
		}
	}
	
	public int countLPS_opti(String s) {
		int i, j = 0, c, n = s.length();
		int[][] count = new int[n][n];
		System.out.println("0 "+count.length+" "+count[0].length);
//		if(M==N)
//			return 1;
		for (i = 0; i < n; i++)
		      count[i][i] = 1;
		for(c=2; c<=n; c++) {
			for(i=0; i<n-c+1; i++) { 
				j = i+c-1;
				System.out.println("1 "+s+" "+i+" "+j+" ");
				if(s.charAt(i) == s.charAt(j) && c==2)
					count[i][j] = 2;
				else if(s.charAt(i) == s.charAt(j))
					count[i][j] = 2 + count[i+1][j-1];
				else
					count[i][j] = Math.max(count[i+1][j], count[i][j-1]);
			}
		}
		return count[0][n-1];
	}
	
	public static void main(String[] args) {
		LongestPalindromicSequence lps = new LongestPalindromicSequence();
		String s = "BBABCBCAB";
		//String s = "GEEKSFORGEEKS";
		//String s = "AB";
		int count;
		//count = lps.countLPS(s, 0, s.length()-1);
		count = lps.countLPS_opti(s);
		System.out.println(count);
	}
	
}
