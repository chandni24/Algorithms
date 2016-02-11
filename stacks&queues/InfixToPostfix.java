/*
 * 
 * Infix to postfix using stack
 * 
 * @author Chandni
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class InfixToPostfix {

	public static String postFix = "";
	public stack s;
	String input;

	public InfixToPostfix(String in){
		input = in;
		s = new stack(in.length());
	}


	public void infixToPostfix() {
		char c;
		for(int i=0; i<input.length(); i++) {
			c = input.charAt(i);
			System.out.println("see0 "+c);
			switch(c) {
				case '+':
				case '-':
					gotOper(c, 1);
					break;
				case '*':
				case '/':
					gotOper(c, 2);
					break;
				case '(':
					s.push(c);
					break;
				case ')':
					gotOper();
					break;
				default:
					postFix = postFix + c;
					break;
			}
		}
		System.out.println("seech "+s.isEmpty());
		while (!s.isEmpty()) {
			postFix = postFix + s.pop();
	      }
	}
	
	public void gotOper(char c, int prec) {
		while(!s.isEmpty()) {
			System.out.println("see0.1 "+c+" "+prec);
			char ch = s.pop();
			if (ch == '(') {
				s.push(ch);
				break;
			}
			else {
				int prec2;
				if (ch == '+' || ch == '-')
					prec2 = 1;
				else
					prec2 = 2;

				System.out.println("see0.2 "+ch+" "+prec2);
				if (prec2 < prec) { 
					s.push(ch);
					break;
				}
				else {
					System.out.println("see1 "+ch);
					postFix = postFix + c;
				}
			}
		}
		  s.push(c);
	}

	public void gotOper() {
		while(!s.isEmpty()) {
			char ch = s.pop();
			if(ch == '(')
				break;
			else {
				System.out.println("see2 "+ch);
				postFix = postFix + ch;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = "1+2-3";
		//String input = "1+2*4/5-7+3/6";
		InfixToPostfix s1 = new InfixToPostfix(input);
		s1.infixToPostfix();
		
		System.out.println("Postfix is "+postFix);

	}

	class stack{

		int maxSize;
		char[] stackA;
		int top;
		public stack(int len) {
			maxSize = len;
			stackA = new char[maxSize];
			top = -1;
		}
		public void printStack() {
			for(int i=0; i<top; i++) {
				System.out.print(stackA[i]+"\t");
			}
		}

		public void push(char data) {
			System.out.println(data+"\t"+top+"\n");
			stackA[++top] = data;
		}

		public char pop() {
			return stackA[top--];
		}
		
		public char peep() {
			return stackA[top];
		}
		
		public boolean isEmpty() {
			return (top == -1);
		}
	}

}