import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TipCalculator implements ActionListener {

    //take the bill price, add a tip expressed as a percentage, and then divide by the people present
    // I could have just extended JFrame and used "this" to access its methods like this.setTitle() or this.setSize()
    // or this.setLayout() or this.add()

    JLabel labOutput;
    JTextField inputPrice;
    JTextField inputTip;
    JTextField inputPeople;

    TipCalculator(){
        JFrame frm = new JFrame("Tip Calculator");
        frm.setSize(300, 250);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frm.setLayout(new FlowLayout());

        //Price
        JLabel labPrice = new JLabel("Price");
        frm.add(labPrice);

        inputPrice = new JTextField(20);
        // I could have an action listener here for the keyboard, but I'm ignoring it
        frm.add(inputPrice);

        // Tip %
        JLabel labTip = new JLabel("Tip %");
        frm.add(labTip);

        inputTip = new JTextField(20);
        frm.add(inputTip);

        // People
        JLabel labPeople = new JLabel("People");
        frm.add(labPeople);

        inputPeople = new JTextField(19);
        frm.add(inputPeople);

        // Calc button
        JButton button = new JButton("Calculate");
        button.addActionListener(this);  // Button being listened for in this class, hence this
        button.setActionCommand("tipCalcButton");  // Identifying button for action listener
        frm.add(button);

        labOutput = new JLabel("Click button to see each persons payable.");
        frm.add(labOutput);

        frm.setVisible(true);  // Has to be last
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
//        System.out.println("Button Pressed.");  // This only prints to console about any button click
//        System.out.println(ae.getActionCommand());  // Tells me what button is being pressed
//        System.out.println(inputPrice.getText());  // Outputs the text in the 'input' JTextField
//        System.out.println(inputTip.getText());
//        System.out.println(inputPeople.getText());
        // The above is just for testing purposes ^

        Double calc = 0.0;
        Double price = 0.0;
        Double tip = 0.0;
        Double people = 0.0;

        // Exception handling
        try
        {
            price = Double.parseDouble(inputPrice.getText());  // Passing value in input text field to calc
            tip = Double.parseDouble(inputTip.getText());
            people = Double.parseDouble(inputPeople.getText());
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Please only enter numbers.");
        }

        calc = (price * (tip/100))/people;  // I'm diving the tip to convert it to a fraction

        // I don't need the if since there is only one button, but I imagine it's good practice.
        if (ae.getActionCommand().equals("tipCalcButton"))
        {
            labOutput.setText("Each person should pay £" + calc);
        }
    }

    // main method for testing purposes
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){     // This is to create a new thread
            @Override
            public void run() {new TipCalculator();}
        });
    }

}
