import java.util.Comparator;

public class SortCards implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {

        if ( o1.getNumericValue() > o2.getNumericValue() ) // o1 > o2
        {
            return 1;
        }
        else if ( o1.getNumericValue() < o2.getNumericValue() ) // o1 < o2
        {
            return -1;
        }
        else // o1 == o2
        {
            return 0;
        }
        //Integer.parseInt(o1.getValue()) > Integer.parseInt(o2.getValue()) // Won't work
        // maybe I could have used compare as part of the collections package because it too returns these values
        //return Integer.valueOf(x).compareTo.(Integer.valueOf(y))
        //return Integer.compare(o1.getValue(), o2.getValue());
        //return o1.getValue() - o2.getValue(); This one might not work
    }

}
