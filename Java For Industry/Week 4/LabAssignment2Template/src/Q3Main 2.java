public class Q3Main {
    public static void main(String[] args) {

        // Length = (Letters = Length - (Symbols + Digits)) + Symbols + Digits

        String pass1 = Password.generator(18,5,6);
        System.out.println("This is password 1: " + pass1);
        System.out.println("Password 1 is " + Password.validate(pass1));

        String pass2 = Password.generator(9,2,2);
        System.out.println("this is password 2: " + pass2);
        System.out.println("Password 2 is " + Password.validate(pass2));

        String pass3 = Password.generator(9,2,3);
        System.out.println("This is password 3: " + pass3);
        System.out.println("Password 3 is " + Password.validate(pass3));

        String pass4 = Password.generator(14,4,5);
        System.out.println("this is password 4: " + pass4);
        System.out.println("Password 4 is " + Password.validate(pass4));

        String pass5 = Password.generator(6,2,1);
        System.out.println("this is password 5: " + pass5);
        System.out.println("Password 5 is " + Password.validate(pass5));

    }
}
