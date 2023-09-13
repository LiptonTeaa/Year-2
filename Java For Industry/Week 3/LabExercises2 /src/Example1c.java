/*change your answer from part b to print a six point star of asterisks, specify the number of layers using an int
Such that for 5 layers the programme will print the following. Use while loops in your solution.

    *
   * *
* * * * *
 * * * *
* * * * *
   * *
    *

 */

public class Example1c {
    public static void main(String[] args) {
        int layers = 16;
        int overlap = (int)(layers/4);
        String[][] starOutput = new String[layers + overlap][layers];

        //add the first triangle to the array (pointing up)
        int currentLayer = 1;
        while (currentLayer <= layers){
            int currentChar = 0;
            while(currentChar < layers){
                if(currentChar >= layers-currentLayer){
                    starOutput[currentLayer-1][currentChar] = "* ";
                }
                else {
                    starOutput[currentLayer-1][currentChar] = " ";
                }
                currentChar++;
            }
            currentLayer++;
        }

        //add the second triangle (pointing down but start on the overlap layer
        currentLayer = overlap;
        while (currentLayer <= layers+overlap-1){
            int curreentCharacter = 0;
            while(curreentCharacter < layers){
                if(starOutput[currentLayer][curreentCharacter] == null || !starOutput[currentLayer][curreentCharacter].equals("* "))
                if(curreentCharacter < currentLayer-overlap){
                    starOutput[currentLayer][curreentCharacter] = " ";
                }
                else {
                    starOutput[currentLayer][curreentCharacter] = "* ";
                }
                curreentCharacter++;
            }
            currentLayer++;
        }

        for(int i = 0; i < starOutput.length; i++){
            for(int j = 0; j < starOutput[i].length; j++){
                System.out.print("\033[33m" + starOutput[i][j]);
            }
            System.out.println();
        }
    }

}
