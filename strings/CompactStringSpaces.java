
public class CompactStringSpaces {

	public static String compactSpaces(String str) {
		StringBuilder sb = new StringBuilder();
		String[] s = str.split(" ");
		for(int i=0;i<s.length; i++) {
			sb.append(s[i]);
			if(s[i].length() != 0)
				sb.append(" ");
		}
		System.out.println(s.length);
		return sb.toString();
		
	}
	
	public static void main(String[] args) {
		String INPUT = "The fox     jumped over    the    moon!";
		System.out.println("Original String: "+ INPUT+ "\n"+ compactSpaces(INPUT));
	}
}
