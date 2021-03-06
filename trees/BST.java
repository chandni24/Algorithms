/*
 * 
 * Binary Search Tree
 * 
 * @author Chandni
 */

public class BST {

	static node root = null;

	class node{
		int key;
		node left = null;
		node right = null;		
	}

	public static void main(String[] args) {
		BST tree = new BST();
		tree.insert(50);
		tree.insert(30);System.out.println("Inserted 30");
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		// print inorder traversal of the BST
		//tree.inorder();
		
		Day3_range_in_sucpred d = new Day3_range_in_sucpred();
		//System.out.println("Count is "+d.countInRange(root, 25, 51));
		
		d.in_sucPred(root, 50);
	}

	public node search(int key) {
		node curr = root;
		while(curr!=null)
		{
			if(key == curr.key)
				return curr;
			else if(key < curr.key)
				curr = curr.left;
			else if(key > curr.key)
				curr = curr.right;
		}
		return null;
	}

	public void insert(int key) {
		node curr = root;
		System.out.println(key+" to be inserted");
		if(root == null)
		{
			node n = new node();
			n.key = key;
			root = n;
			System.out.println(key+" inserted as root");
		}
		while(curr!=null)
		{
			if(key < curr.key && curr.left != null)
				curr = curr.left;			
			else if(key < curr.key && curr.left == null) {
				node n = new node();
				n.key = key;
				curr.left = n;
				curr = null;
			}
			else if(key > curr.key && curr.right != null)
				curr = curr.right;
			else if(key > curr.key && curr.right == null) {
				node n = new node();
				n.key = key;
				curr.right = n;
				curr = null;
			}
		}
		System.out.println(key+" inserted");
	}

	void inorder()  {
		System.out.println(root.key+" is root");
		inorderRec(root);
	}

	// A utility function to do inorder traversal of BST
	public void inorderRec(node root) {
		if (root != null) {
			inorderRec(root.left);
			System.out.println(root.key);
			inorderRec(root.right);
		}
	}
}
