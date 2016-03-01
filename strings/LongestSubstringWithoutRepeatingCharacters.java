import java.util.HashMap;

/*
 * 
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 * 
 * @author Chandni
 */

//check
//http://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
    	int n = 0, max = 1, f=0;
    	if(s.length()==0)
    		return 0;    		
    	HashMap hm = new HashMap();
    	for(int i=0; i<s.length(); i++) {
    		System.out.println(s.charAt(i)+"\t"+hm.containsKey(s.charAt(i)));
    		if(hm.containsKey(s.charAt(i))) {
        		System.out.println(i+"\t"+s.charAt(i)+"\t"+hm.get(s.charAt(i)));
    			n = i - Math.max((int)hm.get(s.charAt(i)),f);
    			f = Math.max(f, (int)hm.get(s.charAt(i)));
        		System.out.println(i+"\t"+s.charAt(i)+"\t"+hm.get(s.charAt(i))+"\t"+n+"\t"+f);
    		}
    		else {
    			n++;
    			System.out.println(i+"\t"+s.charAt(i)+"\t"+n);
    		}
			hm.put(s.charAt(i), i);
			if(max < n)
				max = n;
    	}
        return max;
    }
    
    public static void main(String[] args) throws Exception {
    	//String s = ""; //0
    	//String s = "ab"; //2
    	//String s = "abba"; //2
    	//String s = "dvdf"; //3
    	//String s = "abcabcba"; //3
    	//String s = "abcabcdba"; //4
    	String s = "zwnigfunjwz"; //8
    	System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s));
    }
}
