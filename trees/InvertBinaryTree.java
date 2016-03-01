
public class InvertBinaryTree {
	public void invertTree(TreeNode root) {
		if(root == null)
			return;
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		if(root.left != null)
			invertTree(root.left);
		if(root.right != null)
			invertTree(root.right);
		return;
	}

	public void inOrderPrintTree(TreeNode root) {
		if(root == null)
			return;
		inOrderPrintTree(root.left);
		System.out.println(root.val);
		inOrderPrintTree(root.right);
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
//    	TreeNode n31 = new TreeNode(7);
//    	TreeNode n32 = new TreeNode(4);
//    	n22.left = n31;
//    	n22.right = n32;
    	
    	InvertBinaryTree ibt = new InvertBinaryTree();
    	ibt.invertTree(root); 
    	
    	ibt.inOrderPrintTree(root);
	}
}
