import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

// My Imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener{

    //a list of all possible 5 letter words in English
    public static HashSet<String> dictionary = new HashSet<>();

    //a smaller list of words for selecting the target word from (i.e. the word the player needs to guess)
    public static ArrayList<String> targetWords = new ArrayList<>();

    public static void main(String[] args) {
    //load in the two word lists
        try{
            Scanner in_dict  = new Scanner(new File("gameDictionary.txt"));
            while(in_dict.hasNext()){
                dictionary.add(in_dict.next());
            }

            Scanner in_targets = new Scanner(new File("targetWords.txt"));
            while(in_targets.hasNext()){
                targetWords.add(in_targets.next());
            }
            in_dict.close();
            in_targets.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // My Work below here ---------------------------------

        // We have to instantiate our new class
        SwingUtilities.invokeLater(new Runnable(){     // This is to create a new thread
            @Override
            public void run() {new Main();}
        });
    }

    // Global store for target word to use between methods
    static String tar;

    // Line 1
    JTextField word1;
    JLabel output1;
    // Line 2
    JTextField word2;
    JLabel output2;
    // Line 3
    JTextField word3;
    JLabel output3;
    // Line 4
    JTextField word4;
    JLabel output4;
    // Line 5
    JTextField word5;
    JLabel output5;
    // Line 6
    JTextField word6;
    JLabel output6;

    Main (){

        // Getting us a new target word every time the constructor is called
        String temporary = getTarget();
        tar = temporary;

        // I'm also choosing to not extend Jframe
        // Jframe is going to be the container that will hold the components (sort of)
        JFrame frm = new JFrame("Worlde");
        frm.setSize(600, 350);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // I think a grid or grid bag layout would be useful for this application
        frm.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Line 1
        //These are components that we are adding into the frame
        JLabel lab1 = new JLabel("Guess 1:");
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        // Once we create a component, we have to add it to our frame
        frm.add(lab1,c);

        word1 = new JTextField(10);
        word1.addActionListener(this);
        c.fill = GridBagConstraints.BOTH; // To compensate for size
        c.gridx = 1;
        c.gridy = 0;
        frm.add(word1,c);

        JButton btn1 = new JButton("Guess");
        btn1.addActionListener(this);
        btn1.setActionCommand("button1");
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 2;
        c.gridy = 0;
        frm.add(btn1,c);

        output1 = new JLabel(".");
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 3;
        c.gridy = 0;
        frm.add(output1,c);

        // Line 2
        JLabel lab2 = new JLabel("Guess 2:");
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 1;
        frm.add(lab2,c);

        word2 = new JTextField(10);
        word2.addActionListener(this);
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 1;
        frm.add(word2,c);

        JButton btn2 = new JButton("Guess");
        btn2.addActionListener(this);
        btn2.setActionCommand("button2");
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 2;
        c.gridy = 1;
        frm.add(btn2,c);

        output2 = new JLabel(".");
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 3;
        c.gridy = 1;
        frm.add(output2,c);

        // Line 3
        JLabel lab3 = new JLabel("Guess 3:");
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 2;
        frm.add(lab3,c);

        word3 = new JTextField(10);
        word3.addActionListener(this);
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 2;
        frm.add(word3,c);

        JButton btn3 = new JButton("Guess");
        btn3.addActionListener(this);
        btn3.setActionCommand("button3");
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 2;
        c.gridy = 2;
        frm.add(btn3,c);

        output3 = new JLabel(".");
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 3;
        c.gridy = 2;
        frm.add(output3,c);

        // Line 4
        JLabel lab4 = new JLabel("Guess 4:");
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 3;
        frm.add(lab4,c);

        word4 = new JTextField(10);
        word4.addActionListener(this);
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 3;
        frm.add(word4,c);

        JButton btn4 = new JButton("Guess");
        btn4.addActionListener(this);
        btn4.setActionCommand("button4");
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 2;
        c.gridy = 3;
        frm.add(btn4,c);

        output4 = new JLabel(".");
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 3;
        c.gridy = 3;
        frm.add(output4,c);

        // Line 5
        JLabel lab5 = new JLabel("Guess 5:");
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 4;
        frm.add(lab5,c);

        word5 = new JTextField(10);
        word5.addActionListener(this);
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 4;
        frm.add(word5,c);

        JButton btn5 = new JButton("Guess");
        btn5.addActionListener(this);
        btn5.setActionCommand("button5");
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 2;
        c.gridy = 4;
        frm.add(btn5,c);

        output5 = new JLabel(".");
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 3;
        c.gridy = 4;
        frm.add(output5,c);

        // Line 6
        JLabel lab6 = new JLabel("Guess 6:");
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 5;
        frm.add(lab6,c);

        word6 = new JTextField(10);
        word6.addActionListener(this);
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 5;
        frm.add(word6,c);

        JButton btn6 = new JButton("Guess");
        btn6.addActionListener(this);
        btn6.setActionCommand("button6");
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 2;
        c.gridy = 5;
        frm.add(btn6,c);

        output6 = new JLabel(".");
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 3;
        c.gridy = 5;
        frm.add(output6,c);

        // Line 7
        JLabel lab7 = new JLabel("Type a word in a box and click 'Guess' next to it to start playing.");
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 4;
        c.gridx = 0;
        c.gridy = 6;
        frm.add(lab7,c);

        // Line 8
        JLabel lab8 = new JLabel("Key,");
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 7;
        frm.add(lab8,c);

        // Line 9
        JLabel lab9 = new JLabel("! : Correct character, correct location.");
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 8;
        frm.add(lab9,c);

        // Line 10
        JLabel lab10 = new JLabel("? : Correct character, wrong location.");
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 9;
        frm.add(lab10,c);

        // Line 11
        JLabel lab11 = new JLabel("≠ : Wrong character, wrong location.");
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 10;
        frm.add(lab11,c);

        // So, it doesn't only show for a second before disappearing
        frm.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println(ae.getActionCommand());

        String temp = "";       // To store user input
        boolean flag = true;    // To check character input

        // Probably make this a switch
        if (ae.getActionCommand().equals("button1")){
            temp = word1.getText(); //retrieving input
            for ( int i = 0; i < temp.length() ;i++)
            {
                if ( temp.charAt(i) <= 96 || temp.charAt(i) >= 123)
                {
                    flag = false;
                }
            }
            // check if word is in dictionary
            if (!checkDic(temp) || temp.length() != 5 || !flag)
            {
                JOptionPane.showMessageDialog(null, "Try again. Word is not exist in dictionary or not 5 characters long or not letters.");
                return;
            }
            output1.setText(matchWord(temp));
        }

        if (ae.getActionCommand().equals("button2")){
            temp = word2.getText(); //retrieving input
            for ( int i = 0; i < temp.length() ;i++)
            {
                if ( temp.charAt(i) <= 96 || temp.charAt(i) >= 123)
                {
                    flag = false;
                }
            }
            // check if word is in dictionary
            if (!checkDic(temp) || temp.length() != 5)
            {
                JOptionPane.showMessageDialog(null, "Try again. Word is not exist in dictionary or not 5 characters long.");
                return;
            }
            output2.setText(matchWord(temp));
        }

        if (ae.getActionCommand().equals("button3")){
            temp = word3.getText(); //retrieving input
            for ( int i = 0; i < temp.length() ;i++)
            {
                if ( temp.charAt(i) <= 96 || temp.charAt(i) >= 123)
                {
                    flag = false;
                }
            }
            // check if word is in dictionary
            if (!checkDic(temp) || temp.length() != 5)
            {
                JOptionPane.showMessageDialog(null, "Try again. Word is not exist in dictionary or not 5 characters long.");
                return;
            }
            output3.setText(matchWord(temp));
        }

        if (ae.getActionCommand().equals("button4")){
            temp = word4.getText(); //retrieving input
            for ( int i = 0; i < temp.length() ;i++)
            {
                if ( temp.charAt(i) <= 96 || temp.charAt(i) >= 123)
                {
                    flag = false;
                }
            }
            // check if word is in dictionary
            if (!checkDic(temp) || temp.length() != 5)
            {
                JOptionPane.showMessageDialog(null, "Try again. Word is not exist in dictionary or not 5 characters long.");
                return;
            }
            output4.setText(matchWord(temp));
        }

        if (ae.getActionCommand().equals("button5")){
            temp = word5.getText(); //retrieving input
            for ( int i = 0; i < temp.length() ;i++)
            {
                if ( temp.charAt(i) <= 96 || temp.charAt(i) >= 123)
                {
                    flag = false;
                }
            }
            // check if word is in dictionary
            if (!checkDic(temp) || temp.length() != 5)
            {
                JOptionPane.showMessageDialog(null, "Try again. Word is not exist in dictionary or not 5 characters long.");
                return;
            }
            output5.setText(matchWord(temp));
        }

        if (ae.getActionCommand().equals("button6")){
            temp = word6.getText(); //retrieving input
            for ( int i = 0; i < temp.length() ;i++)
            {
                if ( temp.charAt(i) <= 96 || temp.charAt(i) >= 123)
                {
                    flag = false;
                }
            }
            // check if word is in dictionary
            if (!checkDic(temp) || temp.length() != 5)
            {
                JOptionPane.showMessageDialog(null, "Try again. Word is not exist in dictionary or not 5 characters long.");
                return;
            }
            output6.setText(matchWord(temp));
        }


    }

    public boolean checkDic (String word)
    {
        // I'm looping over all the values in the hashset to check if the input word exists
        for(String s: dictionary){
            if (s.equals(word))
            {
                return true;
            }
        }
        return false;
    }

    // This is the method that will match our input word to our target word
    public static String matchWord(String input)
    {
        String tWord = tar;
        String ansString = "";
        boolean flag = false;
        System.out.println("User input word is: " + input);

        for ( int i = 0; i < input.length(); i++)
        {
            flag = false;
            for ( int j = 0; j < tWord.length(); j++)
            {
                if (input.charAt(i) == tWord.charAt(j))
                {
                    if ( input.charAt(i) == tWord.charAt(i))
                    {
                        ansString = ansString + String.valueOf(input.charAt(i)) + ": !, ";
                        flag = true;
                        break;
                    }
                    ansString = ansString + String.valueOf(input.charAt(i)) + ": ?, ";
                    flag = true;
                    break;
                }
            }
            if (!flag)
            {
                ansString = ansString + String.valueOf(input.charAt(i)) + ": ≠, ";
            }
        }

        // This checks if our word is correct
        int count = 0;
        for (int i = 0; i < ansString.length(); i++)
        {
            if (ansString.charAt(i) == '!')
            {
                count++;
            }
        }
        if (count == 5)
        {
            JOptionPane.showMessageDialog(null,"<html><font color = 'green'> You got the correct word </font></html>");
            new Main();
        }

        // Returning the position check if word is not correct
        return ansString;
    }

    // Below is part of the template

    //use this method for selecting a word. It's important for marking that the word you have selected is printed out to the console!
    public static String getTarget(){
        Random r = new Random();
        String target = targetWords.get(r.nextInt(targetWords.size()));
        //don't delete this line.
        System.out.println("The target word is: " + target);
        return target;
    }
}
