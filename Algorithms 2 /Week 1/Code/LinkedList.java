import java.util.Scanner;

class LinkedList {

    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d){
            data = d;
            next=null;
        }
    }

    //Insert node at the beginning of the list
    public static LinkedList insert_start(LinkedList list, int data)
    {
        // We create the new node 
        Node newNode = new Node(data);

        //Now we link the node to the list 
        newNode.next=list.head;
        list.head=newNode;

        // Return the modified list
        return list;
    }

    //Display the content of the linked list 
    public static void printList(LinkedList list)
    {
        Node tmp = list.head;
        if(tmp!=null)
        {
            System.out.println("The content of the list is:");
            // Traverse the list
            while (tmp != null) {
                // Print the data at current node
                System.out.print(tmp.data);

                // Move to next node
                tmp = tmp.next;
                if(tmp!= null)
                    System.out.print("->");
            }
            System.out.println("");
        }
        else
            System.out.println("The list is empty");
    }

    //Delete the first element with data part equal to x
    public static LinkedList delete(LinkedList list, int x)
    {
        Node tmp=list.head;
        Node prev;

        if(tmp==null)
        {System.out.println("There is nothing to delete");
            return list; }
        else
        {

            //Case 1: x is found in the first node
            if(tmp.data==x)
            {
                list.head=tmp.next; //head points to the second element
                return list;
            }

            else   //Case 2: X is not in the first position, we must keep searching
            {
                prev=tmp;
                tmp=tmp.next;
                while(tmp!=null)
                {
                    if(tmp.data==x)
                    {
                        prev.next=tmp.next;
                        return list;
                    }
                    prev=tmp;
                    tmp=tmp.next;
                }
            }
            System.out.println("Element not found");
            return list;
        }

    }

    // My work from here on----

    //Display the length of the linked list
    public static int lengthList(LinkedList list)
    {
        Node tmp = list.head;
        int count = 0;
        if(tmp!=null)
        {
            // Traverse the list
            while (tmp != null) {
                // Counting nodes
                count = count + 1;

                // Move to next node
                tmp = tmp.next;
            }
            return (count);
            //System.out.println(count);
        }
        else
            return count;
    }

    //Display the first k elements of the linked list
    public static void  printListK(LinkedList list, int k)
    {
        Node tmp = list.head;
        int count = 0;
        if( k > 0 ) {
            if (k < lengthList(list)) {
                if (tmp != null) {
                    System.out.println("The first " + k + " elements are:");
                    // Traverse the list
                    while (tmp != null && count < k) {
                        // Print the data at current node
                        System.out.print(tmp.data);
                        count = count + 1;

                        // Move to next node
                        tmp = tmp.next;
                        if (tmp != null)
                            System.out.print("->");
                    }
                    System.out.println("");
                } else
                    System.out.println("The list is empty");
            }
            else {
                System.out.println("The list has less than " + lengthList(list) + " elements. ");
            }
        }
        else {
            System.out.println("Please enter positive numbers only.");
        }
    }

    //Display the number of times x appears in the linked list
    public static int countList(LinkedList list, int x)
    {
        Node tmp = list.head;
        int count = 0;
        if(tmp!=null)
        {
            // Traverse the list
            while (tmp != null) {
                // Print the data at current node
                if (tmp.data == x){
                    count++;
                }

                // Move to next node
                tmp = tmp.next;
            }
            //System.out.println("x appears " + count + " times");
            return count;
        }
        else
            System.out.println("The list is empty");
            return -1;
    }

    //Return the searched for element in the linked list
    public static boolean searchList(LinkedList list, int x)
    {
        Node tmp = list.head;
        if(tmp!=null)
        {
            // Traverse the list
            while (tmp != null) {
                // Print the data at current node

                if ( tmp.data == x)
                {
                    return true;
                }

                // Move to next node
                tmp = tmp.next;
            }
        }
            return false;
    }

    //Inserting at the end of the linked list
    public static LinkedList insert_end(LinkedList list, int x)
    {
        // We create the new node to insert
        Node newNode = new Node(x);

        Node tmp = list.head;
        if(tmp!=null)
        {
            // Traverse the list
            while (tmp != null) {

                if (tmp.next == null)
                {
                    // We set the last node to point to the new node
                    tmp.next = newNode;

                    // Return the modified list
                    return list;
                }
                // Move to next node
                tmp = tmp.next;
            }

        }
        else
            //Now we link the node to the list as the first if there is no other node in the list
            newNode.next=list.head;
            list.head=newNode;

            // Return the modified list
            return list;
    }

    //Clear the content of the linked list
    public static void clear(LinkedList list)
    {
        Node tmp = list.head;

        if(tmp!=null)
        {
            list.head = null;
            System.out.println("");
        }
        else
            System.out.println("The list is already empty");
    }

    //Display the greatest value in the linked list
    public static int max(LinkedList list)
    {
        Node tmp = list.head;
        int val = -1;
        if(tmp!=null)
        {
            // Traverse the list
            while (tmp != null) {

                if ( tmp.data > val)
                {
                    // Storing the greatest value in the list
                    val = tmp.data;
                }

                // Move to next node
                tmp = tmp.next;
            }
            System.out.println("");
            return val;
        }
        else
            System.out.println("The list is empty");
            return -1;
    }

    //Display the first element in the list and delete it
    public static int delete_first(LinkedList list)
    {
        Node tmp=list.head;
        int temp = -1;
        //Node prev;

        if(tmp==null)
        {System.out.println("There is nothing to delete");
            return -1; }
        else
        {
                temp = tmp.data;
                list.head=tmp.next; //head points to the second element
                return temp;
        }

    }



    public static void main(String[] args)
    {
        //create a new list
        LinkedList list = new LinkedList();

        //Create variable to read from keyboard
        Scanner in=new Scanner(System.in);
        int option, x;


        do
        {
            System.out.println("Select your option:");
            System.out.println("0: Quit the programme");
            System.out.println("1: Insert an element to the beginning of the list");
            System.out.println("2: Delete an element to the list");
            System.out.println("3: Print the content of the list");
            // My work from here on----
            System.out.println("4: Print the length of the list");
            System.out.println("5: Print the first k elements of the list");
            System.out.println("6: Print how many times element x appears in the list");
            System.out.println("7: Search for element x in the list");
            System.out.println("8: Insert an element at the end of the list");
            System.out.println("9: Clear the list");
            System.out.println("10: Print the greatest element in the list");
            System.out.println("11: Print and delete the first element in the list");


            option=in.nextInt();
            if(option==1)
            {
                System.out.println("What number do you want to insert?");
                x=in.nextInt();
                list=insert_start(list, x);
                printList(list);
            }

            if(option==2)
            {
                System.out.println("What number do you want to delete?");
                x=in.nextInt();
                list=delete(list, x);
                printList(list);
            }

            if(option==3)
                printList(list);

            if(option==0)
                System.out.println("Good bye!");

            // My work from here on----

            if(option==4)
                System.out.println("The length of the list is: " + lengthList(list));

            if(option==5)
            {
                System.out.println("What number of elements to print?");
                x=in.nextInt();
                printListK(list, x);
            }

            if(option==6)
            {
                System.out.println("Type number x");
                x=in.nextInt();
                System.out.println("x appears " + countList(list, x) + " times");
            }

            if(option==7)
            {
                System.out.println("Type number to search for");
                x=in.nextInt();
                System.out.println(searchList(list, x));
            }

            if(option==8)
            {
                System.out.println("What number do you want to insert at the end?");
                x=in.nextInt();
                list=insert_end(list, x);
                printList(list);
            }

            if(option==9)
            {
                clear(list);
            }

            if(option==10)
            {
                System.out.println("The greatest element is: " + max(list));
            }

            if(option==11)
            {
                System.out.println("The first element was: " + delete_first(list));
            }

        } while(option!=0);

    }
} 
