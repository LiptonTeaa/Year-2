import java.util.HashSet;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        String[] names = {"catFemale.txt", "catMale.txt", "dogFemale.txt", "dogMale.txt"};
        ArrayList<HashSet> contents = new ArrayList<HashSet>();
        Scanner in;

        for(int i = 0; i < names.length; i++){
            try {
                in = new Scanner(new File(names[i]));
                contents.add(new HashSet<String>());
                while(in.hasNext()){
                    contents.get(i).add(in.next());
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }

        // Print num of words in each element
//        for(HashSet c: contents){
//            System.out.println(c.size());
//        }

        // Print all names
//        for(HashSet c: contents){
//            System.out.println(c);
//        }

        // An ordered tree set of all cat names, male and female
//        TreeSet<String> inAllcat = new TreeSet<>();
//        inAllcat.addAll(contents.get(0));
//        inAllcat.addAll(contents.get(1));
//        // Creating an iterator
//        Iterator value = inAllcat.iterator();
//        // Displaying the values after iterating through the set
//        System.out.println("The iterator values are: ");
//        while (value.hasNext()) {
//            System.out.println(value.next());
//        }


        // I'm not doing this quiet right, I need to only pick out the similar names but i'm printing the
        // union out. What i need is the intersection.


        // List of all the male dog names that are also male cat names
//        TreeSet<String> inDogcat = new TreeSet<>();
//        TreeSet<String> inDogcat2 = new TreeSet<>();
//        inDogcat.addAll(contents.get(1));
//        inDogcat2.addAll(contents.get(3));
//        // New hash set
//        HashSet<String> hs = new HashSet<String>();
//        HashSet<String> hs2 = new HashSet<String>();
//        // Moving content into hash set to remove duplicates
//        hs.addAll(inDogcat);  // this does remove duplicates but it gives me the union if I add both here
//        hs2.addAll(inDogcat2);
//        hs.retainAll(hs2); // Gives me the intersection between hs and hs2
//        System.out.println(hs);
        // An explanation for the thing above, I created two tree sets and stored the lists individually in both and
        // made two hash sets and moved one into each so, I could use hash functions on them to take the intersection
        // and only retain the common names between the two. I'm sure there are better ways to do it but currently this
        // is the only way I know how to do it


        // A list of dog names that are both in male and female
//        TreeSet<String> inDogdog = new TreeSet<>();
//        TreeSet<String> inDogdog2 = new TreeSet<>();
//        inDogdog.addAll(contents.get(2));
//        inDogdog2.addAll(contents.get(3));
//        // New hash set
//        HashSet<String> hs = new HashSet<String>();
//        HashSet<String> hs2 = new HashSet<String>();
//        // Moving content into hash set to remove duplicates
//        hs.addAll(inDogdog);
//        hs2.addAll(inDogdog2);
//        hs.retainAll(hs2);
//        System.out.println(hs);

        // A combined set of all 4 sets, and it's length (I assume he means a union set by all 4 lists)
        TreeSet<String> inAll = new TreeSet<>();
        // Move all our names into the tree set
        inAll.addAll(contents.get(0)); // catFemale
        inAll.addAll(contents.get(1)); // catMale
        inAll.addAll(contents.get(2)); // dogFemale
        inAll.addAll(contents.get(3)); // dogFemale
        HashSet<String> hs = new HashSet<String>();
        hs.addAll(inAll);
        System.out.println(hs);


        // A random thing to note here is that adding my lists to a tree map will order them alphabetically
        // in that tree set because that's just how tree sets work. They order the data in them much like hash
        // sets don't keep duplicates of any values.


        // End of main
        }

    }




