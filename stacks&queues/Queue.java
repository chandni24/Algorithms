/*
 * 
 * Queue
 * 
 * @author Chandni
 */

import java.util.ArrayList;
import java.util.List;


public class Queue {
	
	List<Character> queue = new ArrayList<Character>();
	public static void main(String[] args){
		Queue q = new Queue();
		q.enqueue('a');
		q.enqueue('b');
		q.enqueue('c');
		q.enqueue('d');
		q.printQueue();
	}

	public void enqueue(char e) {
		queue.add(e);
	}
	
	public char dequeue() {
		try {
			return queue.remove(0);
		}
		catch (Exception e1) {
			System.out.println(e1);
		}
		return '0';
	}
	
	public char front() {
		if(!queue.isEmpty())
			return queue.get(0);
		else
			return '0';
	}
	
	public void printQueue() {
		for(int i=0; i<queue.size(); i++)
			System.out.print(queue.get(i)+"\t");
		System.out.println();
	}
}
