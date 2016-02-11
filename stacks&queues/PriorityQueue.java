/*
 * 
 * Priority Queue Implementation
 * 
 * @author Chandni
 */

public class PriorityQueue {
	
	node head = null;
	node top = null;
	
	class node{
		char c;
		int priority;
		node next;
	}
	
	public static void main(String[] args) {
		PriorityQueue q = new PriorityQueue();
		q.enqueue('a', 1);
		q.enqueue('b', 2);
		q.enqueue('c', 4);
		q.enqueue('d', 3);
		System.out.println(q.getHighestPriority().c);
		q.printQueue();
	}
	
	public void enqueue(char e, int p) {
		node n = new node();
		n.c = e;
		n.priority = p;
		if(head == null){
			head = n;
			n.next = null;
			top = n;
		}
		else {
			top.next = n;
			top = n;
		}
	}
	
	public node dequeue() {
		node n = head;
		if(head.next!=null)
			head = head.next;
		return n;
	}
	
	public node getHighestPriority() {
		node n = head;
		node n_high = null;
		int max = 0;
		while(n!=null) {
			if(max < n.priority) {
				max = n.priority;
				n_high = n;
			}
			n = n.next;
		}
		return n_high;
	}
	
	//To Be Fixed
//	public node deleteHighestPriority() {
//		node n = head;
//		node prev = null;
//		node curr = null;
//		int max = 0;
//		while(n!=null) {
//			if(max < n.priority) {
//				max = n.priority;
//				curr = n;
//			}
//			prev = n;
//			n = n.next;
//		}
//		
//		return prev;
//	}
	
	public void printQueue() {
		node n = head;
		while(n!=null) {
			System.out.print(n.c+"\t");
			n = n.next;
		}
		System.out.println();
	}
}
