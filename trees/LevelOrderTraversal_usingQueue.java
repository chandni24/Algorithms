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
 * Takes O(n) time
 * Can also be done using recursive function but that requires O(n^2) time; Check LevelOrderTraversal.java
 * @author chandni
 */

public class LevelOrderTraversal_usingQueue {
	
	List<List<Integer>> ll = new ArrayList<List<Integer>>();
	public void levelOrder(TreeNode root) {
		if(root == null)
			System.out.println("Empty tree");

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		
		while(!q.isEmpty()){
			TreeNode node = q.remove();
			System.out.print(node.val+"\t");
			if(node.left != null)
				q.add(node.left);
			if(node.right != null)
				q.add(node.right);
		}     
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

		LevelOrderTraversal_usingQueue lot = new LevelOrderTraversal_usingQueue();
		lot.levelOrder(root); 

		//lot.printTree();
	}
}
