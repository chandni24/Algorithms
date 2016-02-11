/*
 * 
 * Longest valid substring
 * 
 * @author Chandni
 */

import java.util.Stack;

/*
()((() - 2
)()() - 4
()((() - 2
()()() - 6
()(()() - 4
)()()) - 4
(()()() - 6
()(())))) - 6
 */
public class LongestValidSubstring {
	static Stack st = new Stack();
	public static void main(String[] args) {
		String[] s = {"()((()", "()(()))))"};
		int len, max, max2;	
		for(int j=0; j<s.length; j++) {
			len = 0; max = 0; max2 = 0;
			System.out.println("\n"+s[j]);
			for(int i=0; i<s[j].length(); i++) {

				if(st.isEmpty()) {
					//System.out.print(len+"\t"+max+"\t"+max2);
					if(max<len+max2) {
						max = len+max2;
					}
					max2 = len;
					len = 0;
					//System.out.println("\t-\t"+len+"\t"+max+"\t"+max2);
				}
				//else System.out.println("p "+i+" - "+st.peek()+" "+st.size());
				if(s[j].charAt(i) == '(')
					st.push('(');
				else if(!st.isEmpty() && s[j].charAt(i) == ')') {
					if((char) st.pop() == '(')
						len+=2;
					//System.out.println(i+"\t"+len);
				}
				else
					st.push(s[j].charAt(i));
			}
			if(max<len)
				max = len;
			if(st.isEmpty()) {
				//System.out.print(len+"\t"+max+"\t"+max2);
				max += max2;
				//System.out.println("\t-\t"+len+"\t"+max+"\t"+max2);
			}
			System.out.println(max);
			while(!st.isEmpty())
				st.pop();
		}
	}
}
