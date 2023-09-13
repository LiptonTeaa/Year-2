/*
    Using the following weightings and score calculate the final grade and print out the degree classification
    coursework          weighting       score
    ------------------|---------------|---------
    Quizzes             15%             63
    Presentation        15%             67
    Essay               30%             56
    practical           40%             71
 */

public class Example2 {
    public static void main(String[] args) {
        double[] weighting = {0.15, 0.15, 0.3, 0.4};
        double[] studentGrades = {63, 67, 56, 71};

        double finalGrade = 0;

        for(var i = 0; i < studentGrades.length; i++){
            finalGrade += weighting[i]*studentGrades[i];
        }

        System.out.println("You got a total score of " + Math.ceil(finalGrade)+ "%");
        if(finalGrade > 70){
            System.out.println("Excellent work you got a first");
        }
        else if(finalGrade > 60){
            System.out.println("Very good you got a 2:1");
        }
        else if(finalGrade > 50){
            System.out.println("Good, you got a 2:2");
        }
        else if(finalGrade > 40){
            System.out.println("You have passed");
        }
        else{
            System.out.println("You failed");
        }
    }
}
