
public class DiameterOfTree {

	static node root;
	int diameter(node root) {
		if(root == null)
			return 0;
		
		int lh = height(root.left);
		int rh = height(root.right);
		
		int ld = diameter(root.left);
		int rd = diameter(root.right);
				
		return Math.max(lh + rh + 1, Math.max(ld, rd));
	}
	
	int height(node n) {
		if(n == null)
			return 0;
		
		return(1+ Math.max(height(n.left), height(n.right)));
	}

	public static void main(String[] args) {
		DiameterOfTree tree = new DiameterOfTree();
		tree.root = new node(1);
		tree.root.left = new node(2);
		tree.root.right = new node(3);
		tree.root.left.left = new node(4);
		tree.root.left.right = new node(5);
		System.out.println("The diameter of given binary tree is : "+ tree.diameter(root));

	}

}
