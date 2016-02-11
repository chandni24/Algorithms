/*
 * 
 * Linked List
 * 
 * @author Chandni
 */

public class linkedList {
	
	Node head;
	static class Node {
		int data;
		Node next;
		Node(int d) {
			data = d;
			next = null;
		}		
	}
	public static void main(String[] args) {
		
		linkedList llist = new linkedList();
		Node firstNode = new Node(1);		
		Node secondNode = new Node(2);
		firstNode.next = secondNode;
		Node thirdNode = new Node(3);
		secondNode.next = thirdNode;
		llist.head = firstNode;
		llist.push();
		llist.insertAfter(secondNode, 4);
		llist.insertEnd(5);
		llist.printList();
		System.out.println();
		
		llist.deleteNode(secondNode);
		llist.printList();
		
//		llist.deleteNode(0);
//		llist.printList();
//		System.out.println();
//		
//		llist.reverseList();
//		llist.printList();
//		System.out.println();
//		
//		llist.detectLoop();
//		llist.printList();
//		System.out.println();
	}
    
	public void printList() {
		Node n = head;
		while(n != null) {
			System.out.print(n.data+"\t");
			n = n.next;
		}
		System.out.println();
	}
    
	public void push() {
		Node n = new Node(0);
		n.next = head;
		head = n;
	}
	
	public void insertAfter(Node prevNode, int data) {
		Node n = new Node(data);
		n.next = prevNode.next;
		prevNode.next = n;
	}
	
	public void insertEnd(int data) {
		Node n = new Node(data);
		Node n1 = head;
		while(n1.next != null) {
			n1 = n1.next;
		}
		n1.next = n;
	}
	
	public void deleteNode(int data) {
		Node n = head;
		Node prev = null;
		while(n != null) {
			if(n.data == data){
				if (prev == null)
					head = n.next;
				else
					prev.next = n.next;
				break;
			}
			prev = n;
			n = n.next;
		}
	}
	
	public void reverseList() {
		Node curr = head; 
		Node n = curr.next;
		Node prev = null;
		while(curr != null) {
			n = curr.next;
			curr.next = prev;
			prev = curr;
			curr = n;
		}
		head = prev;
	}
	
	public void detectLoop() {
		Node n1 = head;
		Node n2 = head.next;
		int flag = 0;
		while(n1 != null && n2 != null && n2.next != null) {
			n1 = n1.next;
			n2 = n2.next.next;
			if (n1 == n2) {
				flag = 1;
				break;
			}
		}
		System.out.println("\nflag "+flag+"\n");
	}

	public void deleteNode(Node n) {
		if (head == null)
			return;
		else if (head ==n) {
			head = head.next;
			return;
		}
		Node curr = head.next;
		Node prev = head;
		while(curr != null) {
			if (curr == n) {
				prev.next = curr.next;
			}
			prev = curr;
			curr = curr.next;
		}
	}

}
