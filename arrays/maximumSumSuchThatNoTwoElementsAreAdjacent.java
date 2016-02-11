import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 
 * Maximum sum such that no two elements are adjacent
Question: Given an array of positive numbers, find the maximum sum of a subsequence 
with the constraint that no 2 numbers in the sequence should be adjacent in the array. 
So 3 2 7 10 should return 13 (sum of 3 and 10) or 3 2 5 10 7 should return 15 (sum of 3, 5 and 7).
Answer the question in most efficient way.
 * 
 * @author Chandni
 */
public class maximumSumSuchThatNoTwoElementsAreAdjacent {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		List<Integer> arr = new ArrayList<Integer>();
		int i = 0;
		arr.add(5); arr.add(5); arr.add(10); arr.add(40); arr.add(50); arr.add(35); 
//		while(sc.hasNext()) {
//			arr.add(sc.nextInt());	
//		}
		maxSum(arr);
	}
	
	public static void maxSum(List<Integer> arr) {
		int i = 0, incl = 0, excl = 0, f = 0;
		int l = arr.size();
		System.out.println("l "+l);	
		while(i < l) {
			System.out.println("i "+i);
			f = excl;
			excl = (incl>excl?incl:excl);
			incl = arr.get(i) + f;
			System.out.println(i+"\t"+incl+"\t"+excl);
			i++;
		}
		System.out.println("Maximum is "+incl);
	}
}
