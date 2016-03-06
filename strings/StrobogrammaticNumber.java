/*
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * Write a function to determine if a number is strobogrammatic. The number is represented as a string.
 * For example, the numbers "69", "88", and "818" are all strobogrammatic.
 * Understand the problem:
 * The key of the problem is to understand what is called "strobogrammatic number". As defined, the number 0, 1 and 8 are strobogrammatic. However, 6 and 9 are kind of special. E.g. 
 * 6 0 0 9, return True
 * 66 000 99, return True;
 * 6969 return true; 
 * 6996, return true;
 * 
 * Consequently, we could use two pointers, one starts from the beginning and one from the end. If they are equal && substrobogrammatic (not includi * ng 6 and 9), continue; else return false. If not, but could be 6 and 9 or 9 and 6, respectively, continue; else return false;
 * 
 * @author chandni
 * 
*/

import java.util.HashMap;
import java.util.Map;

public class StrobogrammaticNumber {
	
	public boolean isStrobogrammatic(String num) {
		//Strobogrammatic digits: 0, 1, 8
		//special digits: 6, 9
		
		for(int i=0; i<num.length(); i++) {
			char n = num.charAt(i);
			//System.out.println(n+" here");
			if(!(n=='0' || n=='1' || n=='6' || n=='8' || n=='9')) {
				return false;
			}
			else if(n=='6' || n=='9'){
				//System.out.println(n+" here "+(num.length()-i-1));
				if(!((n=='6' && num.charAt(num.length()-i-1) == '9') || (n=='9' && num.charAt(num.length()-i-1) == '6')))
					return false;
			}
			else if(!(num.charAt(num.length()-i-1) == n))
				return false;
				
		}
		return true;
	}
	
	public static void main(String[] args) {
		Try frd = new Try();
		System.out.println(frd.isStrobogrammatic("6009"));
		//System.out.println(frd.fractionToDecimal(1, 214748364));	
	}
}

