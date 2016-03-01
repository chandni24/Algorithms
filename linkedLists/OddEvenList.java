import java.util.*;

public class OddEvenList {

	public static class list{
		int val;
		list next = null;
	}
	
	public void printList(list a) {
		list r = a;
		while(a != null) {
			System.out.print(a.val);
			a = a.next;
		}
	}
	
	public list fixList(list a) {
		list odd = null, even = null, ol = null, el = null, root = a;
		
		
		while(a!=null) {
			//System.out.print(a.val+"\t");
			if(a.val%2 ==0 && el == null) {
				System.out.println("e1"+"\t"+a.val);
				even = a;
				el = a;
			}
			else if(a.val%2 ==0 && el != null) {System.out.println("e2"+"\t"+a.val);
				even.next = a;
				even = even.next;
			}
			else if(a.val%2 !=0 && ol == null) {System.out.println("o1"+"\t"+a.val);
				odd = a;
				ol = a;
			}
			else if(a.val%2 !=0 && ol != null) {System.out.println("o2"+"\t"+a.val);
				odd.next = a;
				odd = odd.next;
			}
			
			if(root == null && odd != null)
				root = odd;
			
			//System.out.print("g "+el.val+"\t");

			a = a.next;
		}
		System.out.println("\n\n"+el.val+"\t"+odd.val+"\t"+ol.val);
		if(el != null && odd!= null)
			odd.next = el;
		if(even != null)
			even.next = null;
		return ol;
	}
	
	public static void main(String[] args) throws Exception {
		//list a = new list(); 
		list root, a = new list(), b = null;
		root = a;
		int i=1;
		int[] inp = {2,1,4,3,6,5,7,8};
		a.val = inp[0];
		System.out.println(inp.length);
		while(i < inp.length) {
			b = new list(); a.next = b; b.val = inp[i]; a = b;i++;
		}
//		a.val = 1;
//		b = new list(); a.next = b; b.val = 2; a = b;
//		b = new list(); a.next = b; b.val = 3; a = b;
//		b = new list(); a.next = b; b.val = 4; a = b;
//		b = new list(); a.next = b; b.val = 5; a = b;
		
		OddEvenList oel = new OddEvenList();
		oel.printList(root);
		System.out.println();
		oel.printList(oel.fixList(root));
		
	}
}

/*
 * 	public void fixList(list a) {
		//public list oddEvenList(list head) {
			if (a==null || a.next==null || a.next.next==null) System.out.println("null");
			list oddDummyHead = new list();
			list evenDummyHead = new list();
			oddDummyHead.next = a;
			evenDummyHead.next = a.next;
			list oddCur = a;
			list evenCur = a.next;
			while (evenCur!=null && evenCur.next!=null) {
			oddCur.next = evenCur.next;
			evenCur.next = evenCur.next.next;
			oddCur = oddCur.next;
			evenCur = evenCur.next;
			}
			oddCur.next = evenDummyHead.next;
			System.out.println( oddDummyHead.next);
			
	}
 */
