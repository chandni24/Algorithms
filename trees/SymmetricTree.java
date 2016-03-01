
public class SymmetricTree {

	public boolean isMirror(TreeNode n1, TreeNode n2) {
		if(n1 == null && n2 == null)
			return true;
		
		if(n1 != null && n2 != null && n1.val == n2.val) {
			return isMirror(n1.left, n2.right) && isMirror(n1.right, n2.left);
		}
		
		return false;		
	}
	
	public boolean isSymmetric(TreeNode root) {
		return isMirror(root, root);
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
    	
    	SymmetricTree st = new SymmetricTree();
    	System.out.println(st.isSymmetric(root)); 
    	
    	st.inOrderPrintTree(root);
	}
}
