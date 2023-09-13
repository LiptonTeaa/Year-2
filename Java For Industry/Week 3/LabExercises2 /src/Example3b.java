/*
given a month string print out how many days the month has using a switch statement
 */

public class Example3b {
    public static void main(String[] args) {
        String month = "October";
        int days = 30;
        switch (month){
            case "January":
            case "March":
            case "May":
            case "July":
            case "August":
            case "October":
            case "December":
                days = 31;
                break;
            case "February":
                days = 28;
                break;
        }

        System.out.println(month + " has " + days + "days");
    }
}
