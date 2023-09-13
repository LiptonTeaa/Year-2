import java.sql.Struct;
import java.util.ArrayList;
import java.util.Collections;

public class Hand {
    private ArrayList<Card> hand = new ArrayList<>();
    private final String[] ranks = {"Royal Flush", "Straight Flush", "4-of-a-kind", "Full House", "Flush", "Straight",
            "3-of-a-kind", "2 Pair", "1 Pair", "High Card"};

    public void addCard(Card c){
        if(hand.size() < 5){
            hand.add(c);
        }
    }

    public String getHandRank(){
        if(hand.size() != 5){
            return "Incorrect hand size";
        }
        //sort the hand
        hand.sort(new SortCards());
        //Collections.sort(hand, new SortCards());

        int temp = 0;
        for(int i = 0; i < hand.size() - 1; i++) {
            for(int j = i + 1; j < hand.size(); j++) {
                temp = temp + comp(hand.get(i), hand.get(j)); // checking how many cards differ
            } // Every false comparison will add to temp
        } // Considering this is sorted, I shouldn't need a nested loop but it give me a greater accuracy

        //high card (None of the other hands match, the highest value of the card)

//        int temp = 0;
//        for(int i = 0; i < hand.size() - 1; i++) {
//            SortCards sort = new SortCards();
//            temp = temp + sort.compare(hand.get(i), hand.get(i + 1));
//        }
//        if (temp != 0)
//        {
//            return ranks[9];
//        }

        //one pair ( a pair of cards with the same value e.g. 7D, 7H, 4S, 6H, 8H)

        if (temp == 9){         // The more similar numbers there are, the smaller the value for temp should be
            return ranks[8];    // Just a method for counting cards of similar numerical values
        }

        //two pair (2 pairs of matched values e.g. 7D, 7H, 4S, 4C, 2D)

        if (temp == 8){
            return ranks[7];
        }

        //3 of a kind (3 cards with the same value and two others e.g. 7D, 7H, 7C, 2H, KS)

        if (temp == 7){
            return ranks[6];
        }

        //straight (A run of values in different suits e.g. 3H, 4D, 5H, 6C, 7S)

        if (ascRowOrder()){
            return ranks[5];
        }

        //flush (All cards are in the same suit e.g. 3H, 7H, 9H, JH, KH)

        //full house (3 of a kind and a pair e.g. 7S, 7H, 7D, 4C, 4H)

        if (temp == 6){
            return ranks[3];
        }

        //4 of a kind (4 cards with the same value e.g. 9S, 9C, 9H, 9D, 7D)

        if (temp == 1){
            return ranks[2];
        }


        //straight flush (5 cards in a row all of the same suit e.g. 3S, 4S, 5S, 6S, 7S)

        if (ascRowOrder() && compS()){
            return ranks[2];
        }

        //royal flush (J,Q,K,A,10 all of the same suit)

        // Getting each card manually since we need a specific set of cards
        int tempJ = 0, tempQ = 0, tempK = 0, tempA = 0, tempN = 0;
        for(int i = 0; i < hand.size(); i++){
            if ( hand.get(i).getNumericValue() == 11){
                tempJ = 1;
            }
        }
        for(int i = 0; i < hand.size(); i++){
            if ( hand.get(i).getNumericValue() == 12){
                tempQ = 1;
            }
        }
        for(int i = 0; i < hand.size(); i++){
            if ( hand.get(i).getNumericValue() == 13){
                tempK = 1;
            }
        }
        for(int i = 0; i < hand.size(); i++){
            if ( hand.get(i).getNumericValue() == 14){
                tempA = 1;
            }
        }
        for(int i = 0; i < hand.size(); i++){
            if ( hand.get(i).getNumericValue() == 10){
                tempN = 1;
            }
        }
        if (tempJ == 1 && tempQ == 1 && tempK == 1 && tempA == 1 && tempN == 1 && compS()){
            return ranks[0];
        }


        return ranks[9];
    }

    public String toString(){
        String output = "";
        for(Card c: hand){
            if(c.getSuit().equals("Hearts") || c.getSuit().equals("Diamonds")) {
                output += "\u001B[31m[ " + c.getValue() + " , " + c.getSuit() + " ] \u001B[0m";
            }
            else{
                output += "[ " + c.getValue() + " , " + c.getSuit() + " ] ";
            }
        }

        return output;
    }

    public boolean ascRowOrder (){ // Method to check if the held hand is in ascending order
        ArrayList<Integer> temp = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < hand.size(); i++){
            temp.add(hand.get(i).getNumericValue()); // Storing the numeric values of the held hand
        }
        int firstCard = temp.get(0);
        for (int i = 1 ; i < 5 ; i ++){
            if ((firstCard + 1) == temp.get(i)){ // Comparing values
                count ++;
                firstCard = firstCard + 1;
            }
        }
        return count == 4;
    }
    // Could do it using the comparator but can't access it to compare individual elements

    public int comp(Card o1, Card o2) {
        if (o1.getNumericValue() > o2.getNumericValue() || o1.getNumericValue() < o2.getNumericValue())
        {
            return 1;
        }

        else // o1 == o2
        {
            return 0;
        }
    }

    public boolean compS() {
        int temp = 0;
        for (int i = 0; i < hand.size(); i++){ // comparing and returning how many times suits repeat
            if ( hand.get(i).getSuit() ==  hand.get(i + 1).getSuit() ){
                temp++;
            }
        }
        if (temp == 4) {
            return true;
        }
        return false;
    }


}
