import java.util.ArrayList;

public class TextAnalysis implements TextCompare{
    String text;
    public TextAnalysis(String t){
        text = t;
    }

    @Override
    public int numberOfWords() {
        int temp;

        for (int i = 0; i < text.length(); i++)
        {
            if (text.charAt(i) == ' ');
            {
                temp++;
            }
        }
        return temp;
    }

    @Override
    public boolean wordInText(String word) {

        for (int i = 0; i < text.length(); i++)
        {
            if (text.matches(word));
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getLongestWordLength() {
        ArrayList<Integer> temp = new ArrayList<>();
        int count = 0;
        int count2 = 0;
        int count3 = 0;

        for (int i = 0; i < text.length(); i++)
        {
            count++;
            if (text.charAt(i) == ' ');
            {
                temp.add(0);
                count = 0;
            }
        }

        for (int i = 0; i < temp.size(); i++)
        {
            if (temp.get(i) > count2);
            {
                count2 = temp.get(i);
                count3 = temp.get(i);
            }
        }
        return count3;
    }
}

interface TextCompare{
    //returns the number of words in the text
    public int numberOfWords();

    //returns true if a word is in the text
    public boolean wordInText(String word);

    //finds the longest word length and returns the length
    public int getLongestWordLength();

    //returns true if Text has more words in it than the text provided as an argument
    public boolean longestByWord(String otherText);

}

class testText{
    public static void main(String[] args) {
        TextAnalysis ta = new TextAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod "
                +"tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation "
                +"ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in "
                +"voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, "
                +"sunt in culpa qui officia deserunt mollit anim id est laborum.");

       // you can write some testing code here...
    }
}
