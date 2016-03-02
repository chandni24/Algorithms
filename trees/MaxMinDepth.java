/**
Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * @author chandni
 *
 */


/**
Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * @author chandni
 *
 */
public class MaxMinDepth {
	public int MaxDepth(TreeNode root) {
		if(root == null)
			return 0;
		return 1 + Math.max(MaxDepth(root.left), MaxDepth(root.right));
	}
	
	public int MinDepth(TreeNode root) {
		//check this thoroughly
		if(root == null)
			return 0;
		return 1 + Math.min(MaxDepth(root.left), MaxDepth(root.right));
	}
	
	public static void main(String[] args) throws Exception {
    	TreeNode root = new TreeNode(4);
    	TreeNode n11 = new TreeNode(2);
    	root.left = n11;
//    	TreeNode n12 = new TreeNode(7);
//    	root.right = n12;
    	TreeNode n21 = new TreeNode(1);
    	TreeNode n22 = new TreeNode(3);
    	TreeNode n23 = new TreeNode(6);
    	TreeNode n24 = new TreeNode(9);
    	n11.left = n21;
    	n11.right = n22;
    	n21.left = n23;
    	n21.right = n24;
//    	TreeNode n31 = new TreeNode(7);
//    	TreeNode n32 = new TreeNode(4);
//    	n22.left = n31;
//    	n22.right = n32;
    	
    	MaxMinDepth mmd = new MaxMinDepth();
    	System.out.println(mmd.MaxDepth(root)); 
    	System.out.println(mmd.MinDepth(root)); 
    	
	}
}
