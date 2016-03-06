import java.util.HashMap;


public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {    	
        if(nums.length == 0)
            return 0;
    	int i, j=0, len = 1;
    	for(i=0; i<nums.length-1; ) {
    		j = i+1;
    		if(j<nums.length && nums[i] == nums[j]) {
    			i++;
    			//System.out.println("i:"+i+" "+nums[i]+" j:"+j+" "+nums[j]);
    		}
    		else if(j < nums.length)
    			nums[len++] = nums[j];
    		i = j;
    	}
    	for(i=0; i<len; i++)
    		System.out.println(nums[i]);
    	return len;
    }
    
	public static void main(String[] args) {
		//int[] arr = {10, 9, 2, 6, 3, 5, 101, 18}; //4
		//int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60, 80 }; //6
		int arr[] = {1, 1, 1, 2, 2}; //5
		System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates(arr));
		
	}
}
