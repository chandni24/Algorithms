
public class IncreasingTripletSubsequence {
	public boolean increasingTriplet(int[] nums) {
		int a = Integer.MAX_VALUE;
		int b = Integer.MAX_VALUE;
		for(int i=0; i<nums.length; i++) {
			if(a >= nums[i]) {System.out.println("a "+a+" "+nums[i]);
				a = nums[i];}
			else if(b >= nums[i]) {System.out.println("b "+b+" "+nums[i]);
				b = nums[i];}
			else {System.out.println("a "+b+" b "+b+" "+nums[i]);
				return true;}
		}
		return false;
	}
	
	public static void main(String[] args) {
		//int[] arr = {10, 9, 2, 6, 3, 5, 101, 18}; //4
		//int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60, 80 }; //6
		int arr[] = {1, 1, 1, 1}; //5
		System.out.println(new IncreasingTripletSubsequence().increasingTriplet(arr));
		
	}
}
