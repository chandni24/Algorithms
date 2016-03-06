
public class LongestIncreasingSubsequence { //O(n^2)
    public int lengthOfLIS(int[] nums) {
    	int max = 0, count, x;
    	int[] inc = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
        	inc[i] = 1;
        	for(int j=0; j<i; j++) {
        		if(nums[i] > nums[j]){
        			//System.out.println(nums[i]+"  "+nums[j]);
        			inc[i] = Math.max(inc[i], inc[j]+1);
        		}
        	}
        	max = Math.max(max, inc[i]);
        }
        return max;
    }
    
    public int ceil(int[] a, int l, int u, int key) {
    	int m = 0;
    	while(u-l > 1) {
    		m = (l+u)/2;
    		if(key <= a[m])
    			u = m;
    		else
    			l = m;
    	}
    	return u;
    }

    public int lengthOfLIS2(int[] nums) { //O(nlogn)
        if(nums.length == 0)
            return 0;
    	int[] inc = new int[nums.length];    	
    	inc[0] = nums[0];
    	int len = 1;
    	//System.out.println("inc length "+inc.length);
    	for(int i=1; i<nums.length; i++) {
    		//System.out.println(nums[i]);
    		if(nums[i] < inc[0]) {
    			inc[0] = nums[i];}
    		else if(nums[i] > inc[len-1]){
    			inc[len++] = nums[i];}
    		else{
    			inc[ceil(inc, -1, len-1, nums[i])] = nums[i]; }
    	}
//    	for(int i=0; i<len; i++)
//    		System.out.print(inc[i]+"\t");
    	return len;
    }
    
	public static void main(String[] args) {
		//int[] arr = {10, 9, 2, 6, 3, 5, 101, 18}; //4
		//int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60, 80 }; //6
		int arr[] = {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42}; //5
		System.out.println(new LongestIncreasingSubsequence().lengthOfLIS2(arr));
		
	}
}
