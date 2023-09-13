public class Card {
    private String value;
    private String suit;

    public Card(String value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    public int getNumericValue(){
        switch (value){
            case "K":
                return 13;
            case "Q":
                return 12;
            case "J":
                return 11;
            case "A":
                return 14;
            default:
                return Integer.parseInt(value);
        }
    }

    // Getters and Setters

    // Value----
    public String getValue() {
        return value;
    } // Getter

    public void setValue(String value) {
        this.value = value;
    } // Setter

    // Suit----
    public String getSuit() {
        return suit;
    } // Getter

    public void setSuit(String suit) {
        this.suit = suit;
    } // Setter
}
