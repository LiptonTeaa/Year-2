public class Q1 {

    public static void main(String[] args) {
        //write your code here to output the employee details

        int empNum = 12345;
        String name = "Jack";
        int age = 52;
        double salaryAnnual = 27736.80;
        int yearsToRetirement;
        double hourlyRate;

        yearsToRetirement = 66 - age;

        //works a 35-hour week, 52 weeks a year
        // hourlyWage = annualSalary/weeks a year/ hours per week

        hourlyRate = salaryAnnual/52/35;

        System.out.println("Employee Reference,");
        System.out.println("--------------------------");
        System.out.println("ID Number: " + empNum);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: $" + salaryAnnual);
        System.out.println("Years to retirement: " + yearsToRetirement);
        System.out.println("Hourly rate: $" + hourlyRate);

    }
}
