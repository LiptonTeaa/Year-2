public class Example3 {
    public static void main(String[] args) {
        String hw = "hello world";

        //in this case they are different (small w)
        if(hw.equals("Hello World")){
            System.out.println("they are the same");
        }
        else{
            System.out.println("They are differnt");
        }

        System.out.println("The string hw has " + hw.length() + " characters");

        System.out.println("The string in lower case is " + hw.toLowerCase());

        char first = hw.charAt(0);
        if((int)first > 64 && (int)first < 91){
            System.out.println("First letter is a capital");
        }
        else{
            System.out.println("First letter is not a capital");
        }


    }
}
