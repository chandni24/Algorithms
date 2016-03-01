import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
 * Given a string, find the longest substring that contains only two unique characters. 
 * For example, given "abcbbbbcccbdddadacb", 
 * the longest substring that contains 2 unique character is "bcbbbbcccb".
 * 
 * @author Chandni
 */
public class LongestSubstringWhichContains2UniqueCharacters {
	public String maxSubString2UniqueChars_usingArray(String s) {
    	int s_i = 0, e_i = 0;
    	String maxStr = "";
    	
    	if(s.length()==0)
    		return "";
    	char[] characters = new char[2];
    	int[] indices = new int[2];
    	System.out.println(characters[0]);
    	characters[0] = s.charAt(0);
    	indices[0] = 0;
    	characters[1] = '-';
    	indices[1] = -1;
    	for(int i=1; i<s.length(); i++) {
    		//System.out.println(s.charAt(i)+"\t"+hm.containsKey(s.charAt(i)));
    		if(!((characters[0] != '-' && characters[0] == s.charAt(i)) || (characters[1] != '-' && characters[1] == s.charAt(i))))
    			//checks that s.charAt(i) is not present in characters array
    		{
        		//System.out.println(i+"\t"+s.charAt(i)+"\t"+characters[0]+"\t"+characters[1]);
        		if(characters[1] != '-') {
        			characters[0] = characters[1];
        			indices[0] = indices[1];
        			characters[1] = s.charAt(i);
        			indices[1] = i;

        			if(maxStr.length() < e_i-s_i+1)
        				maxStr = s.substring(s_i, e_i+1);
        			//System.out.println(maxStr);
        			s_i = indices[0];
        			e_i = i;
        		}
        		else {
        			characters[1] = s.charAt(i);
        			indices[1] = i;
        		}
        			
    		}
    		else {
    			e_i++;
    			if(characters[0] == s.charAt(i))
    				indices[0] = i;
    			else
    				indices[1] = i;
    		}
        	//System.out.println("indices "+s_i+"\t"+e_i);
    	}
        return maxStr;
    }

	public String maxSubString2UniqueChars(String s) {
		int maxLen = 0, s_i = 0;
    	String maxStr = "";
    	
    	if(s.length()==0)
    		return "";
    	
    	HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
    	for(int i=1; i<s.length(); i++) {
    		char c = s.charAt(i);
    		//System.out.println(s.charAt(i)+"\t"+hm.containsKey(s.charAt(i)));
    		if(hm.size() == 2 && !hm.containsKey(c))
    			//checks that s.charAt(i) is not present in characters array
    		{
    			if(maxStr.length() < maxLen) {
    				maxLen = i - s_i;
    				maxStr = s.substring(s_i, i);
    			}
    			//System.out.println(maxStr);
        		//System.out.println(i+"\t"+s.charAt(i)+"\t"+characters[0]+"\t"+characters[1]);
    			
    			int leftMost = s.length();
        		for(Entry<Character, Integer> entry : hm.entrySet()) {
        			if(entry.getValue() < leftMost)
        				leftMost = entry.getValue(); 
        		}
        		
        		s_i = leftMost;
        		hm.remove(s.charAt(leftMost));
    		}
    		hm.put(c, i);
        	//System.out.println("indices "+s_i+"\t"+e_i);
    	}
    	System.out.println("indices "+s_i+"\t"+maxLen);
    	if(hm.size() == 2 && maxLen <= 0)
    		return s;
        return maxStr;
    }
    public static void main(String[] args) throws Exception {

    	//String s = "abcbbcacb"; //bcbbc
    	String s = "abcbbbbcccbdddadacb"; //bcbbbbcccb
    	System.out.println(new LongestSubstringWhichContains2UniqueCharacters().maxSubString2UniqueChars(s));
    }
}
