
public class MaximumProductSubarray {

	public int maxProduct(int[] nums) {
		int maxProd_so_far = Integer.MIN_VALUE, minProd_ending_here = 1, maxProd_ending_here = 1, temp;
		
		for(int i=0; i<nums.length; i++) {
			temp = maxProd_ending_here;
			maxProd_ending_here = Math.max(maxProd_ending_here * nums[i], minProd_ending_here * nums[i]);
			maxProd_ending_here = Math.max(maxProd_ending_here, nums[i]);
			if(minProd_ending_here * nums[i] < 0)
				minProd_ending_here = minProd_ending_here * nums[i];
			else
				minProd_ending_here = nums[i];
			minProd_ending_here = Math.min(minProd_ending_here, temp * nums[i]);
			
			if(maxProd_so_far < maxProd_ending_here)
				maxProd_so_far = maxProd_ending_here;
		}
		System.out.println(minProd_ending_here+"\t"+maxProd_ending_here+"\t"+maxProd_so_far+"\n");
        return maxProd_so_far;
    }

	public static void main(String[] args) throws Exception {
		int[] arr = {-1,-2,-9,-6};
//		int arr[] = {1, -2, -3, 0, 7, -8, -2};
		System.out.println(new MaximumProductSubarray().maxProduct(arr));
	}
}
