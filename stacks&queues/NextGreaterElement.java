
/*
 * 
 * Next greater element in a stack
 * Stack used from java.util and basic computations
 * 
 * @author Chandni
 */

import java.util.*;

public class NextGreaterElement {

	public static void main(String[] args) {
		
		Stack<Integer> s = new Stack<Integer>();
		List<Integer> in = new ArrayList<>();
		Scanner sc = new Scanner (System.in);
		while(sc.hasNextInt()) {
			in.add(sc.nextInt());
		}
		s.push(in.get(0));
		for(int i=1; i< in.size(); i++) {
			if(s.peek() < in.get(i)) {
				System.out.println(s.peek()+" -- "+in.get(i));
				s.pop();
				for(int j=0; j<s.size();) {
					if(s.peek() < in.get(i))
						System.out.println(s.pop()+" -- "+in.get(i));
					else
						j++;
				}
			}
			s.push(in.get(i));
		}
		while(!s.isEmpty()) {
			System.out.println(s.pop()+" -- "+-1);
		}
	}
}
