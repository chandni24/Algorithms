
public class MorrisTraversalBinaryTree {

	static class Node {
	    int data;
	    Node left, right;	     
	    Node(int item) {
	        data = item;
	        left = right = null;
	    }
	}
	
	static Node root;
	
	void MorrisTraversal(Node node) {
		Node current, pre;        
        if (node == null) {
            return;
        }
        
        current = node;
        while(current != null) {
        	if(current.left == null) {
        		System.out.print(current.data+"\t");
        		current = current.right;
        	}
        	else {
        		pre = current.left;
        		//find inorder predecessor of current
        		while(pre.right != null && pre.right != current)
        			pre = pre.right;
        		
        		//make current as the right child of its inorder predecessor 
        		if(pre.right == null) {
        			pre.right = current;
        			current = current.left;
        		}
        		
        		//revert the changes made in if part to restore the original 
                //tree i.e., fix the right child of predecssor */
        		else {
        			pre.right = null;
        			System.out.print(current.data+"\t");
        			current = current.right;
        		}
        	}
        }
	}
	public static void main(String args[]) {
        int sum = 14;
        MorrisTraversalBinaryTree tree = new MorrisTraversalBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
         
        tree.MorrisTraversal(root);
    }
}
