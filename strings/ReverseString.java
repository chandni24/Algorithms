
public class ReverseString {
	public String reverseString(String s) {
		char c;
		int n = s.length()-1;
		for(int i=0; i<=(n)/2; i++) {
			s = s.substring(0,i) + s.substring(n,n+1) + s.substring(i+1,n) + s.substring(i,i+1) + s.substring(n+1);
			n--;
		}
		System.out.println(s);
		return s;
	}
	
	public static void main(String[] args) {
		String s = "abcd";	
		new Try().reverseString(s);
		System.out.println(s);
	}
}

