package labs_examples.datastructures.trees.labs;

/*
    Trees: Exercise_01

    Please demonstrate how to create a custom Binary Search Tree (BST). Using your custom BST, demonstrate how to:

        1.) Create a new CustomBST
        2.) Insert new elements
        3.) Retrieve elements
        4.) Update elements
        5.) Delete elements
        6.) Print elements (Bonus: try in-order traversal, pre-order traversal, post-order traversal)
        7.) Keep the tree well balanced

 */
//I used a Youtube tutorial to get my BST class started: https://www.youtube.com/watch?v=Gt2yBZAhsGM&list=PLZPZq0r_RZON1eaqfafTnEexRzuHbfZX8&index=27
public class Exercise_01 {

	public static void main(String[] args) {

		BinarySearchTree tree = new BinarySearchTree();
		
		tree.insert(new Node(5));
		tree.insert(new Node(1));
		tree.insert(new Node(9));
		tree.insert(new Node(2));
		tree.insert(new Node(7));
		tree.insert(new Node(3));
		tree.insert(new Node(8));
		tree.insert(new Node(6));
		tree.insert(new Node(4));
		tree.updateElement(4, 44);
		tree.remove(0);
		tree.remove(3);
		tree.display();
		System.out.println(tree.contains(10));
	}

}
//Node object that holds a single integer value
class Node{
	int data;
	int height;
	Node left;
	Node right;
	
	public Node(int data) {
		this.data = data;
		this.height = 1;
	}
}
class BinarySearchTree{
	
	Node root;
	
	public void insert(Node node) {
		//its easier to use recursion if you have a helper method.
		//Use helper method to insert a given Node into the tree and update the root Node after rotation.
		root = insertHelper(root, node);
	}
	//this must take in the root node as parameter so it can be altered during recursion
	private Node insertHelper(Node root, Node node) {
		
		int data = node.data;
		//if tree is empty, new Node is the root
		if(root == null) {
			root = node;
			return root;
		}
		//if node data is less than the root node data, call this method again going left
		else if(data < root.data) {
			//recursive
			root.left = insertHelper(root.left, node);
		}
		// if it is greater than the root node, we go right
		else {
			root.right = insertHelper(root.right, node);
		}
		//after new Node is inserted at the appropriate position, re-balance the tree if necessary.
		root = rebalance(root);
		return root;
	}
	public void display() {
		displayHelper(root);
	}
	//root will always be passed in. 
	private void displayHelper(Node root) {
		
		//In order traversal / ascending order
		if(root != null) {
			displayHelper(root.left);
			System.out.println(root.data);
			displayHelper(root.right);
		}
	}
	public boolean contains(int data) {
		return containsHelper(root, data);
		
	}
	private boolean containsHelper(Node root, int data) {
		
		if(root == null) {
			return false;
		}
		else if(root.data == data) {
			return true;
		}
		else if(root.data > data) {
			return containsHelper(root.left, data);
		}
		else {
			return containsHelper(root.right, data);
		}
	}
	public void remove(int data) {
		//if the given Node data exists, call removeHelper
		if(contains(data)) {
			removeHelper(root, data);
		}
		else {
			System.out.println(data+" not found");
		}
	}
	private Node removeHelper(Node root, int data) {
		
		if(root == null) {
			return root;
			//traverse down the tree until the Node is found on the left or right side
		}else if(data < root.data) {
			root.left = removeHelper(root.left, data);
		}else if(data > root.data) {
			root.right = removeHelper(root.right, data);
		}
		else { // node found and it is a leaf node.
			if(root.left == null && root.right == null) {
				root = null;
			}
			//Node is found and it has a right child. find a successor to replace this node
			else if(root.right != null) {
				//successor: find the least value below the right child of this node. Connect it to the parent of this node.
				root.data = successor(root);
				root.right = removeHelper(root.right, root.data);
			}
			else {
				//find the greatest value below the left child.
				root.data = predecessor(root);
				root.left = removeHelper(root.left, root.data);
			}
		}
		
		return root;
		
	}
	
	private int successor(Node root) {
		root = root.right;
		while(root.left != null) {
			root = root.left;
		}
		return root.data;
		
	}
	private int predecessor(Node root) {
		root = root.left;
		while(root.right != null) {
			root = root.right;
		}
		return root.data;
		
	}
	//If data exists, remove and replace with given data
	public void updateElement(int data, int newData) {
	    if (contains(data)) {
	        remove(data);
	        insert(new Node(newData));
	    } else {
	        System.out.println(data + " not found");
	    }
	}
	// called at the end of every insert
	 // rotate based on the balance factor
    private Node rebalance(Node node) {
       
        int balanceFactor = getBalanceFactor(node);

       //left subtree is bigger
        if (balanceFactor > 1) {
            if (getBalanceFactor(node.left) >= 0) {
                node = rightRotate(node);
            } else {
                node.left = leftRotate(node.left);
                node = rightRotate(node);
            }
            //right subtree is bigger
        } else if (balanceFactor < -1) {
            if (getBalanceFactor(node.right) <= 0) {
                node = leftRotate(node);
            } else {
                node.right = rightRotate(node.right);
                node = leftRotate(node);
            }
        }

        return node;
    }

    private int getHeight(Node node) {
        // Calculate the height of a node (recursively). Find max between left and right and add 1.
        if (node == null) {
            return 0;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    private int getBalanceFactor(Node node) {
        // Calculate the balance factor of a node. Subtract height of right subtree from height of left subtree.
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    private Node rightRotate(Node node) {
        //right rotation. Node's left child is new root. Update pointers. return new root.
        Node newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;
        return newRoot;
    }

    private Node leftRotate(Node node) {
        //left rotation. Node's right child is new root. Update pointers. return new root.
        Node newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        return newRoot;
    }
}