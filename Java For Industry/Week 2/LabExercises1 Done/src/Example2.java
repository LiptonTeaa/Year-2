public class Example2 {
    public static void main(String[] args) {
        float a = 99999.8f;
        float b = 99999.4f;

        //note that the output isn't quite the same as with doubles.
        //this is because a float is a less accurate approximation of the number
        System.out.println(a+b);
    }
}
