import java.util.*;

public class MainChange {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean biggerPaid = false;

        double price = 0.00, paid= 0.00;

        while(!biggerPaid) {
            price = getMoneyInput("Enter the price in pounds and pence", in);
            paid = getMoneyInput("Enter the amount paid in pounds and pence", in);
            if(price > paid){
                System.out.println("You haven't paid enough!");
            }
            else{
                biggerPaid = true;
            }
        }

        System.out.println("price " + price);
        TreeMap<NotesAndCoins, Integer> changeComposition = calcChange(price, paid);

        for(NotesAndCoins n: changeComposition.keySet()){
            if(changeComposition.get(n) != 0){
                System.out.println(n.getName() + ": " + changeComposition.get(n));
            }
        }

        //TESTING ENUMS
//        NotesAndCoins test = NotesAndCoins.POUND10;
//        int test1 = NotesAndCoins.POUND10.getValueInP();
//        String test2 = NotesAndCoins.POUND10.getName();
//
//        System.out.println(test);
//        System.out.println(test1);
//        System.out.println(test2);

    }

    //takes input from the user and ensures it is a double and returns a double with 2 decimal places
    //Question(String) is the prompt for user input and (in)scanner is collecting user input
    public static double getMoneyInput(String question, Scanner in){
        boolean validInput = false;
        double amount = 0.00;
        //do this until the user enters a valid double
        while(!validInput) {
            System.out.println(question);
            try {
                amount = in.nextDouble();
                validInput = true;
            }catch (InputMismatchException e){
                System.out.println("Invalid input try again");
                in.next();
            }
        }
        //return the value entered fixed to 2dp
        return (double)((int)(amount*100))/100;
    }

    public static TreeMap<NotesAndCoins, Integer> calcChange(double price, double paid){

        //COMPLETE THIS METHOD!!!
        //This method will return a TreeMap where the key is NotesAndCoins and
        // the value is the number of each denomination to make up the change

        TreeMap<NotesAndCoins, Integer> tempChange = new TreeMap<>();

        int initialPrice = (int) price * 100;  // casting to int because the passed values are double
        int initialPayment = (int) paid * 100;  // Turning pounds into pence

        // Calculating the change
        int diff = initialPayment - initialPrice;
        for (NotesAndCoins element: NotesAndCoins.values())  // Looping through the enums
        {
            // I can't find a way to iterate over a collection other than a for each loop
            //for ( int i = 0; i < NotesAndCoins.values().length; i++)

            if (diff >= element.getValueInP())  // diff greater than or equal to value in enum
            {
                diff = diff - element.getValueInP(); // diff minus the value of enum it is immediately greater than
                tempChange.put(element, 1);  // Adding the value it is immediately greater than to the TreeMap

                while (diff >= element.getValueInP())  // Comparing the remaining smaller values
                {
                    diff = diff - element.getValueInP();  // Deducting the count to reach zero
                    tempChange.put(element, tempChange.get(element) + 1);  // Incrementing
                }
            }
        }
        return tempChange;
    }

    //.put() method of TreeMap is used to insert a mapping into a map.
    // This means we can insert a specific key and the value it is mapping
    // to into a particular map.
    // This still doesn't work perfectly
}

