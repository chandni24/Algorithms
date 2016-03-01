
public class ProductofArrayExceptSelf {

	public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] prod = new int[n];
        
        left[0] = 1;
        right[n-1] = 1;
        
        for(int i=1; i<n; i++) {
        	//System.out.println(i);
        	left[i] = left[i-1] * nums[i-1];
        	right[n-i-1] = right[n-i] * nums[n-i];
        }
        
        for(int i=0; i<n; i++) {
        	prod[i] = left[i] * right[i];
        }
        return prod;
    }

	
	public static void main(String[] args) throws Exception {
		int[] arr = {1, 2, 3, 4};
		int[] num = new ProductofArrayExceptSelf().productExceptSelf(arr);
		for(int i=0; i< num.length; i++) {
			System.out.println(num[i]);
		}
	}
}
