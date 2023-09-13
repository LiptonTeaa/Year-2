public class Main {

    import java.util.*;

        public static void main(String[] args) {
        //create a new list
        LinkedList list = new LinkedList();

        //Create variable to read from keyboard
        Scanner in = new Scanner(System.in);
        int option, x;


        do {
            System.out.println("Select your option:");
            System.out.println("0: Quit the programme");
            System.out.println("1: Insert an element to the beginning of the list");
            System.out.println("2: Delete an element to the list");
            System.out.println("3: Print the content of the list");

            option = in.nextInt();
            if (option == 1) {
                System.out.println("What number do you want to insert?");
                x = in.nextInt();
                list = insert_start(list, x);
                printList(list);
            }

            if (option == 2) {
                System.out.println("What number do you want to delete?");
                x = in.nextInt();
                list = delete(list, x);
                printList(list);
            }

            if (option == 3)
                printList(list);

            if (option == 0)
                System.out.println("Good bye!");


        } while (option != 0);

    }

}
