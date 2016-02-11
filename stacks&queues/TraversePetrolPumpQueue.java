/*
 * 
 * Traverse Petrol pump queue
 * 
 * @author Chandni
 */

import java.util.Scanner;
/*
4 6
6 5
7 3
4 5
 */
/*
6 5
4 7
7 3
4 6
 */
public class TraversePetrolPumpQueue {

	node root = null;
	node top = null;
	class node {
		int amnt;
		int dis;
		node next = null;
	}

	public static void main(String[] args) {
		TraversePetrolPumpQueue tpp = new TraversePetrolPumpQueue();
		Scanner sc = new Scanner(System.in);
		node n2;
		int n=4;
		int[] a = new int[n];
		int[] d = new int[n];
		int sum_a = 0, sum_d = 0, len = 0, x=0;
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
			d[i] = sc.nextInt();
		}
		while(len<n) {
			//System.out.println("Sums "+sum_a+a[x] +"\t"+ sum_d+d[x]);
			if(sum_a+a[x] < sum_d+d[x]) {
				tpp.enqueue(a[x], d[x]);
				sum_a += a[x];
				sum_d += d[x];
				len++;
			}
			else {
				n2 = tpp.dequeue();
				if(n2!=null) {
					len--;
					sum_a -= n2.amnt;
					sum_d -= n2.dis;
				}
			}
			if(++x == n)
				x = 0;
		}
		if(len == n) {
			n2 = tpp.dequeue();
			System.out.println("Start with node with petrol amount "+n2.amnt+" and distance from next pump "+n2.dis);
		}
		else
			System.out.println("Circular tour not possible");
	}

	public void enqueue(int a, int d) {
		System.out.println("Enqueing "+a+"\t"+d);
		node n = new node();
		n.amnt = a;
		n.dis = d;
		if(root == null)
			root = n;
		else
			top.next = n;
		top = n;
	}

	public node dequeue() {
		if(root == null)
			return null;
		node n = root;
		root = root.next;
		return n;
	}
}
