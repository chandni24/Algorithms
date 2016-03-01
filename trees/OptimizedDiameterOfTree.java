
public class OptimizedDiameterOfTree {

	static node root;
	int diameterOpt(node root, height height) {
		
		height lh = new height();
		height rh = new height();
		
		if(root == null) {
			height.h = 0;
			return 0;
		}
		
		lh.h++;
		rh.h++;
		
		int ld = diameterOpt(root.left, lh);
		int rd = diameterOpt(root.right, rh);
				
		height.h = Math.max(lh.h, rh.h)+1;
		return Math.max(lh.h + rh.h + 1, Math.max(ld, rd));
	}
	
	int diameter() {
		height height = new height();
		return diameterOpt(root, height);
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
