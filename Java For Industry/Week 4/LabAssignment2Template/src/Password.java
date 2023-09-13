// Two imports to make the shuffle algorithm work
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Password {

    // Implementing Fisher–Yates shuffle
    static void shuffleArray(char[] ar)
    {
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = (char) a;
        }
    }

    // generator’ that takes three arguments; length, symbols and digits
    // format: length 16, symbols 4 and digits 3 could produce the password ‘gD3Wd$^Skw2d%E\8’
    // Strings are an object type and can thus have methods used on them

    public static String generator(int length, int symbols, int digits)
    {
        int letters = length - (symbols + digits);

        char[] temp1 = new char[length];
        char[] temp2 = new char[length];
        char[] temp3 = new char[length];
        char[] temp4 = new char[length];
        char[] password = new char[length];

        String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String combinedLetters = upperCaseLetters + lowerCaseLetters;
        String specialChar = "!@#$%^&*?/";
        String numbers = "1234567890";

        int randomNum;
        //int randomNum = (int)(Math.random() * 101);  // generating random numbers from 0 to 100

        // Creating random letters (upper and lower case)
        for (int i = 0; i < letters; i++)
        {
            randomNum = (int)(Math.random() * combinedLetters.length());
            temp1[i] = combinedLetters.charAt(randomNum);
        }

        //System.out.println(temp1);

        // Creating random symbols
        for (int i = 0; i < symbols; i++)
        {
            randomNum = (int)(Math.random() * specialChar.length());
            temp2[i] = specialChar.charAt(randomNum);
        }

        //System.out.println(temp2);

        // Creating random digits
        for (int i = 0; i < digits; i++)
        {
            randomNum = (int)(Math.random() * numbers.length());
            temp3[i] = numbers.charAt(randomNum);
        }

        //System.out.println(temp3);

        // Concatenating all the temps into temp4
        for (int i = 0; i < letters; i++)
        {
            temp4[i] = temp1[i];
        }
        for (int i = 0; i < symbols; i++)
        {
            temp4[i + letters] = temp2[i];
        }
        for (int i = 0; i < digits; i++)
        {
            temp4[i + letters + symbols] = temp3[i];
        }

        //System.out.println(temp4);

        // Shuffling elements in temp4 to make a password
        shuffleArray(temp4);

        password = temp4;

        //System.out.println(password);

        // Converting char array to string
        String strPassword = String.valueOf(password);
        //System.out.println(strPassword);

        return strPassword;

//        This didn't work because it doesn't retain all the characters in temp4
//        for (int i = 0; i < temp4.length; i++)
//        {
//            randomNum = (int)(Math.random() * temp4.length);
//            password[i] = temp4[randomNum];
//        }

    }

    public static String validate(String pass)
    {

        String feedback = "";

        // Checking Length is over 16
        if (pass.length() >= 16)
        {
            int counterSym = 0;
            int counterDig = 0;
            for (int i = 0; i <= pass.length() - 1; i++)
            {
                // !@#$%^&*?/ symbols to look for
                switch (pass.charAt(i))
                {
                    case '!':
                        counterSym++;
                        break;
                    case '@':
                        counterSym++;
                        break;
                    case '#':
                        counterSym++;
                        break;
                    case '$':
                        counterSym++;
                        break;
                    case '%':
                        counterSym++;
                        break;
                    case '^':
                        counterSym++;
                        break;
                    case '&':
                        counterSym++;
                        break;
                    case '*':
                        counterSym++;
                        break;
                    case '?':
                        counterSym++;
                        break;
                    case '/':
                        counterSym++;
                        break;
                    default:
                        break;
                }

                switch (pass.charAt(i))
                {
                    case '1':
                        counterDig++;
                        break;
                    case '2':
                        counterDig++;
                        break;
                    case '3':
                        counterDig++;
                        break;
                    case '4':
                        counterDig++;
                        break;
                    case '5':
                        counterDig++;
                        break;
                    case '6':
                        counterDig++;
                        break;
                    case '7':
                        counterDig++;
                        break;
                    case '8':
                        counterDig++;
                        break;
                    case '9':
                        counterDig++;
                        break;
                    case '0':
                        counterDig++;
                        break;
                    default:
                        break;
                }
            }
            // Checking if there are more than 4 Symbols and Digits
            if ( counterSym > 4 || counterDig > 4)
            {
                String upperCaseChars = "(.*[A-Z].*)";
                String lowerCaseChars = "(.*[a-z].*)";
                // Checking if the password has a mix of cases
                if (pass.matches(upperCaseChars ) && pass.matches(lowerCaseChars ))
                {
                    feedback = "Excellent";
                }

                // reggex.pattern is the only way to count multiple occurrences using regular expression
                // Edward however gave me an easier way of doing this, you simply read numbers by looking at
                // their ascii or uni code to see if they're capital letters or smaller case letters, and
                // you can see what symbol/alphabet or number it is as long as it is on a keyboard.

            }
        }
        else if (pass.length() > 12 && pass.length() <16)
        {
            int counterSym = 0;
            int counterDig = 0;
            for (int i = 0; i <= pass.length() - 1; i++)
            {
                // !@#$%^&*?/ symbols to look for
                switch (pass.charAt(i))
                {
                    case '!':
                        counterSym++;
                        break;
                    case '@':
                        counterSym++;
                        break;
                    case '#':
                        counterSym++;
                        break;
                    case '$':
                        counterSym++;
                        break;
                    case '%':
                        counterSym++;
                        break;
                    case '^':
                        counterSym++;
                        break;
                    case '&':
                        counterSym++;
                        break;
                    case '*':
                        counterSym++;
                        break;
                    case '?':
                        counterSym++;
                        break;
                    case '/':
                        counterSym++;
                        break;
                    default:
                        break;
                }

                switch (pass.charAt(i))
                {
                    case '1':
                        counterDig++;
                        break;
                    case '2':
                        counterDig++;
                        break;
                    case '3':
                        counterDig++;
                        break;
                    case '4':
                        counterDig++;
                        break;
                    case '5':
                        counterDig++;
                        break;
                    case '6':
                        counterDig++;
                        break;
                    case '7':
                        counterDig++;
                        break;
                    case '8':
                        counterDig++;
                        break;
                    case '9':
                        counterDig++;
                        break;
                    case '0':
                        counterDig++;
                        break;
                    default:
                        break;
                }
            }
            // Checking if there are more than 4 Symbols and Digits
            if ( counterSym > 3 || counterDig > 3)
            {
                String upperCaseChars = "(.*[A-Z].*)";
                String lowerCaseChars = "(.*[a-z].*)";
                // Checking if the password has a mix of cases
                if (pass.matches(upperCaseChars ) && pass.matches(lowerCaseChars ))
                {
                    feedback = "Good";
                }
            }
        }
        else if (pass.length() > 8 && pass.length() <= 12)
        {
            int counterSym = 0;
            int counterDig = 0;
            for (int i = 0; i <= pass.length() - 1; i++)
            {
                // !@#$%^&*?/ symbols to look for
                switch (pass.charAt(i))
                {
                    case '!':
                        counterSym++;
                        break;
                    case '@':
                        counterSym++;
                        break;
                    case '#':
                        counterSym++;
                        break;
                    case '$':
                        counterSym++;
                        break;
                    case '%':
                        counterSym++;
                        break;
                    case '^':
                        counterSym++;
                        break;
                    case '&':
                        counterSym++;
                        break;
                    case '*':
                        counterSym++;
                        break;
                    case '?':
                        counterSym++;
                        break;
                    case '/':
                        counterSym++;
                        break;
                    default:
                        break;
                }

                switch (pass.charAt(i))
                {
                    case '1':
                        counterDig++;
                        break;
                    case '2':
                        counterDig++;
                        break;
                    case '3':
                        counterDig++;
                        break;
                    case '4':
                        counterDig++;
                        break;
                    case '5':
                        counterDig++;
                        break;
                    case '6':
                        counterDig++;
                        break;
                    case '7':
                        counterDig++;
                        break;
                    case '8':
                        counterDig++;
                        break;
                    case '9':
                        counterDig++;
                        break;
                    case '0':
                        counterDig++;
                        break;
                    default:
                        break;
                }
            }
            // Checking if there are more than 4 Symbols and Digits
            if ( counterSym > 1 || counterDig > 2)
            {
                String upperCaseChars = "(.*[A-Z].*)";
                String lowerCaseChars = "(.*[a-z].*)";
                // Checking if the password has a mix of cases
                if (pass.matches(upperCaseChars ) && pass.matches(lowerCaseChars ))
                {
                    feedback = "Ok";
                }
            }
        }
        else //if (pass.length() <= 8)
        {
            int counterSym = 0;
            int counterDig = 0;
            for (int i = 0; i <= pass.length() - 1; i++)
            {
                // !@#$%^&*?/ symbols to look for
                switch (pass.charAt(i))
                {
                    case '!':
                        counterSym++;
                        break;
                    case '@':
                        counterSym++;
                        break;
                    case '#':
                        counterSym++;
                        break;
                    case '$':
                        counterSym++;
                        break;
                    case '%':
                        counterSym++;
                        break;
                    case '^':
                        counterSym++;
                        break;
                    case '&':
                        counterSym++;
                        break;
                    case '*':
                        counterSym++;
                        break;
                    case '?':
                        counterSym++;
                        break;
                    case '/':
                        counterSym++;
                        break;
                    default:
                        break;
                }

                switch (pass.charAt(i))
                {
                    case '1':
                        counterDig++;
                        break;
                    case '2':
                        counterDig++;
                        break;
                    case '3':
                        counterDig++;
                        break;
                    case '4':
                        counterDig++;
                        break;
                    case '5':
                        counterDig++;
                        break;
                    case '6':
                        counterDig++;
                        break;
                    case '7':
                        counterDig++;
                        break;
                    case '8':
                        counterDig++;
                        break;
                    case '9':
                        counterDig++;
                        break;
                    case '0':
                        counterDig++;
                        break;
                    default:
                        break;
                }
            }
            // Checking if there are more than 4 Symbols and Digits
            if ( counterSym <= 1 || counterDig <= 2)
            {
                String upperCaseChars = "(.*[A-Z].*)";
                String lowerCaseChars = "(.*[a-z].*)";
                // Checking if the password has a mix of cases
                if (pass.matches(upperCaseChars ) && pass.matches(lowerCaseChars ))
                {
                    feedback = "Poor";
                }
            }
        }

       return feedback;

    }

//-----Just to test ---------------------------
//    public static void main(String[] args) {
//
//        //generator(16,4,3);
//        //generator(10,4,3);
//        //generator(20,9,2);
//        //generator(12,2,5);
//    }

}

