public class Example1 {
    public static void main(String[] args) {
        final double pi = 3.14159;
        double r = 10;

        //2 methods of getting to 2 decimal places top one is easier to explain but
        //the bottom one is better for performance
        double c = Math.floor(r*2*pi*100)/100;
        double area = ((double)((int)(r*r*pi*100))/100);

        System.out.println("circum is " + c);
        System.out.println("areea is " + area);
    }
}
