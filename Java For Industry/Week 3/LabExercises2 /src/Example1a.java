/*print out a right angle triangle of asterisks, specify the number of rows using the int layers
Such that for 5 rows the programme will print the following. Use while loops in your solution.

*
**
***
****
*****

 */
public class Example1a {
    public static void main(String[] args) {
        int layers = 15;

        int i = 1;
        while (i <= layers){
            int j = i;
            while(j > 0){
                System.out.print("*");
                j--;
            }
            System.out.println();
            i++;
        }
    }
}
