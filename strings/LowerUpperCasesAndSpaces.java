/**
A string contains a-z, A-Z and spaces. Sort the string so that all lower cases are at the beginning, spaces in the 
middle and upper cases at the end. Original order among lower and upper cases needs to remain the same. 
For example: a cBd LkmY becomes ackm BLY. Is there a way in O(n) without extra space?

 * @author Chandni
 *
 */

public class LowerUpperCasesAndSpaces {

	public static String sortString(String s) {
		String str = "";
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
				str+=s.charAt(i);
		}
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == ' ')
				str+=s.charAt(i);
		}
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
				str+=s.charAt(i);
		}
		return str;
	}

	public static void main(String[] args) {
		String INPUT = "a cBd LkmY";
		System.out.println("The sorted string is: "+ sortString(INPUT));
	}
}
