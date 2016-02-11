/*
 * 
 * Reverse Stack Recursion
 * 
 * @author Chandni
 */

import java.util.Stack;


public class ReverseStackRecursion {

	static Stack<Character> s = new Stack<Character>();
	public static void main(String[] args) {
		ReverseStackRecursion r = new ReverseStackRecursion();
		s.push('1');
		s.push('2');
		s.push('3');
		System.out.println(s.peek());
		r.reverse();
		System.out.println("hey\t"+s.pop()+"\t"+s.pop()+"\t"+s.pop()+"\t");
	}

	public void insertAtBottom(char i) {
		char x = 0;
		if (s.empty()) {
			System.out.println(i);
			s.push(i);
		}
		else {
			x = s.pop(); 
			insertAtBottom(i);
			s.push(x);
		}
	}
	
	public void reverse() {
		char x ;
		if (!s.isEmpty()) {
			x = s.pop();
			System.out.println(s.isEmpty()+"\tx is "+x);
			reverse();
			System.out.println("1 "+x);
			insertAtBottom(x);
		}
	}
	
}
