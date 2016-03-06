import java.util.HashMap;


public class LongestConsecutiveSubsequence {

	public int longestConsecutive(int[] nums) {
		HashMap hm = new HashMap<>();
		int max = 0, x, y, count;
		for(int i=0; i<nums.length; i++)
			hm.put(nums[i], 0);
		for(int i=0; i<nums.length; i++) {
			count = 1;
			x = nums[i]-1;
			y = nums[i]+1;
			while(hm.containsKey(x)) {
				hm.remove(x--);
				count++;
			}
			while(hm.containsKey(y)) {
				hm.remove(y++);
				count++;
			}
			if(max < count)
				max = count;
		}
		return max;
	}
	public static void main(String[] args) {
		int arr[] = {1, 9, 3, 10, 4, 20, 2}; //4
		//int arr[] = {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42}; //5
		System.out.println(new LongestConsecutiveSubsequence().longestConsecutive(arr));
	}
}
