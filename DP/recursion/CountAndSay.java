/*
 * The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.

 *
 * @author chandni
 */

public class CountAndSay {

	/*
	public String countAndSay(int n) {		
		long x = 1, y, num, count;
		for(int i=1; i<n; i++) {
			num=0;
			while(x > 0) {
				y = x%10;
				count = count(x, y);
				num = (int) ((10*count+y)*Math.pow(10, length(num)) + num);
				x = (int) (x/Math.pow(10, count));
				//System.out.println(num+"\n");
			}
			x = num;
		}

		return Long.toString(x);
	}

	public int length(long num) {
		int i=1;
		if(num == 0)
			return 0;
		while((num=num/10)>0)
			i++;
		return i;
	}
*/
	public int count(String x, char y) {
		int count=0, i=x.length()-1;
		//System.out.println("s "+x+" "+y);
		while(x.length()>0 && x.charAt(i) == y){
			//System.out.println("count "+x%10+" "+y);
			count++;
			x = x.substring(0,x.length()-1);
			i--;
		}
		//System.out.println("count "+count);
		return count;		
	}

	public String countAndSay(int n) {
		int count, i, j;
		char y;
		String x = "1", num, piece;
		for(i=1; i<n; i++) {
			num="";
			while((j = x.length()-1) >= 0) {
				y = x.charAt(j);
				count = count(x, y);
				piece = Integer.toString(count).concat(Character.toString(y));
				num = piece.concat(num);
				x = x.substring(0, x.length()-count);
				//System.out.println(num+"\n");
			}
			x = num;
		}

		return x;
	}
	public static void main(String[] args) {

		int n = 11;
		CountAndSay cas = new CountAndSay();
		System.out.println("CountAndSay number for "+ n+ " is: "+ cas.countAndSay(n));

	}
}
