//Class data structure for storing binary search tree elements
class Node { 
	int data; 
	Node left;
	Node right;
	static int spacingBuffer = 0;

	//Enum for identifying node type when printing
	public enum NodeType {
		LeftNode,
		RightNode,
		RootNode
	}

	/**
	 * Constructs a new node.
	 * @param d The data value of the new node.
	 */
	Node(int d){
		data = d; 
		left=null;
		right=null;
	}
	
	//Prints spacing based on the current spacing buffer. Used to make printed nodes easier to read.
	void printSpacing(){
		for (int i = 0; i < spacingBuffer; i++) {
			System.out.print("  ");
		}
	}

	//Helper function for printing nodes in a readable format
	void PrintNodeType(NodeType ntype){
		switch(ntype){
			case LeftNode:
				System.out.print("Left:");
				break;
			case RightNode:
				System.out.print("Right:");
				break;
			case RootNode:
				System.out.print("Root:");
				break;
		}
	}
	
	/**
	 * Inserts a new node into the correct place in the node hierarchy
	 * @param newNode The node to be inserted
	 */
	public void insert(Node newNode) 
	{ 
		if(data>=newNode.data)
		{
			if(left != null){
				//If the new node should be inserted to the left and there is already a node to the left then call insert recursively on that left node
				left.insert(newNode);
			}
			else{
				//If the new node should be inserted to the left and the left is empty then insert it there
				left = newNode;
			}
		}
		else
		{
			if(right != null){
				//If the new node should be inserted to the right and there is already a node to the left then call insert recursively on that right node
				right.insert(newNode);
			}
			else{
				//If the new node should be inserted to the right and the right is empty then insert it there
				right = newNode;
			}
		}
	} 
  
	//Display the content of the tree in pre-order format
	public void preOrder(NodeType ntype) 
	{
		PrintNodeType(ntype);
		//Print data before children
		System.out.println(data);
		//Increment spacing buffer for nicer printing when printSpacing is called
		spacingBuffer++;
		//If there is a node to the left then print its contents
		if(left!=null)
		{
			printSpacing();
			left.preOrder(NodeType.LeftNode);
		}
		//If there is a node to the right then print its contents
		if(right != null)
		{
			printSpacing();
			right.preOrder(NodeType.RightNode);
		}
		spacingBuffer--;
	} 
	
	//Display the content of the tree in post-order format
	public void postOrder(NodeType ntype) 
	{
		//WRITE YOUR CODE HERE
	} 
	
	//Display the content of the tree in in-order format
	public void inOrder(NodeType ntype) 
	{
		//WRITE YOUR CODE HERE
	}

	/**
	 * Removes a node with a specific data value from the node hierarchy.
	 * @param x	The data value of the node we want to remove.
	 * @return This node if this node should not be removed, left if this node should be removed.
	 */
	Node remove(int x){
		//WRITE YOUR CODE HERE
	}
	
	/**
	 * Gets the leftmost child of the right node
	 * @return 	The leftmost child node.
	 * 			Will be this.right if this.right has no children to the left, or it will be null if this.right is null.
	 */
	Node getRMin()
	{
		//WRITE YOUR CODE HERE
	}
}