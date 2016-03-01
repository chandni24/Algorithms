/*
 * 
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * 
 * @author Chandni
 */
public class LC_AddTwoNumbers {

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0), node = root;
        int carry = 0;
        while(l1 != null || l2 != null) {
        	
        	if(l1 != null) {
        		carry = carry + l1.val;
        		l1 = l1.next;
        	}
        	if(l2 != null) {
        		carry = carry + l2.val;
        		l2 = l2.next;
        	}
        	node.next = new ListNode(carry%10);
        	if(root == null) {
        		root = node;
        	}
        	node = node.next;
        	carry = carry/10;
        }
//        while(l1 != null) {
//        	carry = carry + l1.val;
//        	node = new ListNode(carry%10);
//        	if(root == null) {
//        		root = node;
//        	}
//        	else {
//        		l3.next = node;
//        	}
//        	l1 = l1.next;
//        }
//        while(l2 != null) {
//        	carry = carry + l2.val;
//        	node = new ListNode(carry%10);
//        	if(root == null) {
//        		root = node;
//        	}
//        	else {
//        		l3.next = node;
//        	}
//        	l2 = l2.next;
//        }
        
        if(carry != 0){
        	node.next = new ListNode(carry%10);
        }
        
        return root.next;
    }
    
    public void printList(ListNode root) {
    	while(root != null){
    		System.out.println(root.val);
    		root = root.next;
    	}
    }
    public static void main(String[] args){
    	ListNode l1 = null, l2 = null;
    	//(2 -> 4 -> 3) + (5 -> 6 -> 4)
    	//ListNode ll = new ListNode(0);
    	l1 = new ListNode(2);
//    	l1.next = new ListNode(4);
//    	l1.next.next = new ListNode(3);
//    	//l1.next.next.next = new ListNode(5);
    	l2 = new ListNode(5);
//    	l2.next = new ListNode(6);
//    	l2.next.next = new ListNode(7);
//    	
    	ListNode root = new LC_AddTwoNumbers().addTwoNumbers(l1, l2);
    	new LC_AddTwoNumbers().printList(root);
    }
}
