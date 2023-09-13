public class Q2 {

    // I could have done these in an array to make the output cleaner but the question sounded like I was only
    // supposed to print them out in the loops.

    public static void main(String[] args) {
        //part 1: display even numbers between 0 and 1000

        int i = 0;

        while (i <= 1000)
        {
            //System.out.println(i);
            i = i + 2;
        }

        //part 2: display odd numbers between 0 and 1000

        int j = 1;

        while (j <= 1000)
        {
            //System.out.println(j);
            j = j + 2;
        }


        //part 3: display all the multiples of 4 between 0 and 1000

        int x = 0;

        while (x <= 1000)
        {
            if(x % 4 == 0)
            {
                //System.out.println(x);
            }
            x++;
        }


        //part 4: display all the numbers between 1 and 1000 replacing multiples of 3 with Java
        //multiples of 5 with Script and multiples of 3 and 5 with JavaScript

        int y = 0;

        while (y <= 1000)
        {

            if (y%3 == 0 && y%5 == 0)
            {
                System.out.println("JavaScript");
            }
            else if (y%5 == 0)
            {
                System.out.println("Script");
            }
            else if (y%3 == 0)
            {
                System.out.println("Java");
            }
            else
            {
                System.out.println(y);
            }

            y++;
        }

//        switch (y)
//        {
//            case y%3 == 0: //It's making this boolean ,so I can't use it
//                System.out.println("Java");
//                break;
//            default:
//                System.out.println(y);
//        }

    }
}
