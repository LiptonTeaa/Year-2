
//An implementation of a binary search tree data structure
class BinarySearchTree{ 
	Node root;
	
	/**
	 * Inserts a new value into the binary search tree.
	 * @param data The data value of the new node to be inserted.
	 */
	public void insert(int data){
		// We create the new node 
		Node newNode = new Node(data); 
		//if root is null then we can insert it into the root
		if(root==null)
		{
			root=newNode;
			System.out.println("adding to an empty tree");
		}
		else
		{
			//if tree is not empty then we need to navigate deeper to place it in the correct position in the tree
			root.insert(newNode);
		}
	}
	
	//Displays the content of the tree in pre-order format
	public void preOrder() { 
		System.out.println();
		if(root!=null)
		{
			root.preOrder(Node.NodeType.RootNode);
		}
		else
		{
			System.out.println("\nThe tree is empty.");	
		}  
		System.out.println();
	}
	
	//Displays the content of the tree in post-order format
	public void postOrder() {
		System.out.println();
		if(root!=null)
		{
			root.postOrder(Node.NodeType.RootNode);
		}
		else
		{
			System.out.println("\nThe tree is empty.");	
		}
		System.out.println();
	}
	
	//Displays the content of the tree in in-order format
	public void inOrder() { 
		System.out.println();
		if(root!=null)
		{
			root.inOrder(Node.NodeType.RootNode);
		}
		else
		{
			System.out.println("\nThe tree is empty.");
		}
		System.out.println();
	}
	
	/**
	 * Removes a node with a specific data value from the node hierarchy.
	 * @param x	The data value of the node we want to remove.
	 */
	public void remove(int x)
	{
		//Handle empty tree
		if(root == null){
			System.out.println("The tree is empty.");
		}
		//If tree is not empty then we can do removal via the node class
		else{
			root = root.remove(x);
		}
		System.out.println();
	}
} 
