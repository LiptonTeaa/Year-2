import java.util.Scanner;

//An implementation of a binary search tree data structure
class BinarySearchTreeTest{ 
    public static void main(String[] args) 
    { 
        //create a new bst
        BinarySearchTree bst = new BinarySearchTree(); 
        
        //Create variable to read from keyboard
        Scanner in=new Scanner(System.in);
		int option, x;
		
		int[] testNodes = {
			5,
			2,
			4, 
			9, 
			11,
			6,
			8
		};

		for (int i = 0; i < testNodes.length; i++) {
			bst.insert(testNodes[i]);
		}

		bst.remove(5);
		bst.preOrder();
		
        do
		{
			System.out.println("Select your option:");
			System.out.println("0: Quit the programe");
			System.out.println("1: Insert number in the bst");
			System.out.println("2: Traverse pre order");
			System.out.println("3: Traverse in order");
			System.out.println("4: Traverse post order");
			System.out.println("5: Remove a number in the bst");
			
			option=in.nextInt();
			switch(option){
				case 0:
					System.out.println("Good bye!");
					break;
				case 1:
					System.out.println("What number do you want to insert?");
					x=in.nextInt();
					bst.insert(x);
					break;
				case 2:
					bst.preOrder();
					break;
				case 3:
					bst.inOrder();
					break;
				case 4:
					bst.postOrder();
					break;
				case 5:
					System.out.println("What number do you want to remove?");
					x=in.nextInt();
					bst.remove(x);
					break;
				default:
					System.out.println("That is not an option");
					break;
			}
			
       } while(option!=0);

	   in.close();
    } 
} 
