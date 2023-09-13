/*change your answer from part a to print out an acute triangle of asterisks, specify the number of layers using an int
Such that for 5 layers the programme will print the following. Use while loops in your solution.

    *
   * *
  * * *
 * * * *
* * * * *

 */
public class Example1b {
    public static void main(String[] args) {
        int layers = 10;

        int i = 1;
        while (i <= layers){
            int j = 0;
            while(j < layers){
                if(j >= layers-i){
                    System.out.print("*");
                }
                System.out.print(" ");
                j++;
            }
            System.out.println();
            i++;
        }
    }
}
