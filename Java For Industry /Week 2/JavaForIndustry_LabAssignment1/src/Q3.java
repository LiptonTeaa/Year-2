public class Q3 {
    public static void main(String[] args) {

        //double salary = 60000.6879999;

        double salary = 48342.32;
        //double salary = 45500;
        //double salary = 22000;
        //double salary = 14500;
        double tax = 0;
        //float temp;

        //write your code here to calculate the tax of the variable salary, make sure you try multiple values
        // to test your work

        if (salary > 50000)
        {
            //tax = Double.floatValue(salary); // Won't work in a static method
            //temp = (float)salary;
            //System.out.println(temp);

            tax = salary * 0.4; //40%
            System.out.println("Tax on salary of $" + salary + " is $" + String.format("%.2f", tax));
        }
        else if (salary <= 50000 && salary > 30000)
        {
            tax = salary * 0.2; //20%
            System.out.println("Tax on salary of $" + salary + " is $" + String.format("%.2f", tax));
        }
        else if (salary <= 30000 && salary > 1500)
        {
            tax = tax * 0.05;
            System.out.println("Tax on salary of $" + salary + " is $" + String.format("%.2f", tax));
        }
        else
        {
            System.out.println("Tax on salary of $" + salary + " is $" + tax);
        }

    }
}

// I have no idea what formula the pds is using to calculate those taxes because I can't think of any equation to
// give me those answers. $8750 as result of 20% on $60000 makes no sense, if you work it backwards, 8750 is
// %14.58 something of 60000.
