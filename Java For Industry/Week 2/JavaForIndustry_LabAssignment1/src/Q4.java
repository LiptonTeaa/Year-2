public class Q4 {
    public static void main(String[] args) throws java.io.IOException{
        //write your answer here

        char ch;

        do {

            System.out.println("Welcome to bank XX. To proceed enter 1 for Current Accounts," +
                    " 2 for Credit Cards, 3 for Loans, 4 for Savings Accounts or press h to hang up.");

            ch = (char) System.in.read();

            System.in.read();

            switch (ch)
            {
                case '1':
                    System.out.println("You have selected Current Accounts.");
                    break;
                case '2':
                    System.out.println("You have selected Credit Cards.");
                    break;
                case '3':
                    System.out.println("You have selected Loans.");
                    break;
                case '4':
                    System.out.println("You have selected Savings Accounts.");
                    break;
                case 'h':
                    System.out.println("Goodbye.");
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
                    break;
            }

        } while (ch != 'h');

    }
}
