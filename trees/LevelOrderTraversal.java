import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * LeetCode question: https://oj.leetcode.com/problems/binary-tree-level-order-traversal/
 * @param root
 * @return
 * 
 * Takes O(n^2) time
 * Using a queue reduces the time to O(n); Check LevelOrderTraversal_usingQueue.java
 * @author chandni
 */

public class LevelOrderTraversal {
	
	List<List<Integer>> ll = new ArrayList<List<Integer>>();
	Stack<List<Integer>> ll2 = new Stack<List<Integer>>();
	public List<List<Integer>> levelOrder(TreeNode root) {
		if(root == null)
			return ll;

		List<Integer> current = new ArrayList<Integer>();
		int h = height(root);
		for(int i=1; i<=h; i++) {
			printGivenLevel(root, i, current);
			ll.add(current);
			current = new ArrayList<Integer>();
		}

		return ll;        
	}
	
	public List<List<Integer>> levelOrder2(TreeNode root) {
		if(root == null)
			return ll;

		List<Integer> current = new ArrayList<Integer>();
		int h = height(root);
		for(int i=1; i<=h; i++) {
			printGivenLevel(root, i, current);
			ll2.push(current);
			current = new ArrayList<Integer>();
		}
		h=ll2.size();
		for(int i=0; i<h; i++) {
			ll.add(ll2.pop());
		}

		return ll;        
	}
	
	public void printGivenLevel(TreeNode root, int level, List<Integer> current) {
		if(root == null)
			return;
		if(level == 1)
			current.add(root.val);
		else {
			printGivenLevel(root.left, level-1, current);
			printGivenLevel(root.right, level-1, current);
		}
	}

	public int height(TreeNode root) {
		if(root == null)
			return 0;
		return 1 + Math.max(height(root.left), height(root.right));
	}
	
	public void printTree() {
		List<List<Integer>> go = ll;
		for(int i=0; i<ll.size(); i++) {
			for(int j=0; j<go.get(i).size(); j++) {
				System.out.print(go.get(i).get(j)+"\t");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) throws Exception {
		TreeNode root = new TreeNode(4);
		TreeNode n11 = new TreeNode(2);
		root.left = n11;
		TreeNode n12 = new TreeNode(7);
		root.right = n12;
		TreeNode n21 = new TreeNode(1);
		TreeNode n22 = new TreeNode(3);
		TreeNode n23 = new TreeNode(6);
		TreeNode n24 = new TreeNode(9);
		n11.left = n21;
		n11.right = n22;
		n12.left = n23;
		n12.right = n24;
		//	    	TreeNode n31 = new TreeNode(7);
		//	    	TreeNode n32 = new TreeNode(4);
		//	    	n22.left = n31;
		//	    	n22.right = n32;

		LevelOrderTraversal lot = new LevelOrderTraversal();
		lot.levelOrder2(root); 

		lot.printTree();
	}
}
