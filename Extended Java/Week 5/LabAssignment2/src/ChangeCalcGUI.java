import javax.swing.*;
import java.awt.*;

public class ChangeCalcGUI {

    ChangeCalcGUI()
    {
        JFrame frame = new JFrame("Change Calc");
        frame.setSize(200, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new GridLayout(12,1));
        // GridBag()

        JLabel label = new JLabel("Change");
        frame.add(label);

        JLabel label1 = new JLabel("£50");
        frame.add(label1);

        JLabel label2 = new JLabel("£20");
        frame.add(label2);

        JLabel label3 = new JLabel("£10");
        frame.add(label3);

        JLabel label4 = new JLabel("£5");
        frame.add(label4);

        JLabel label5 = new JLabel("£2");
        frame.add(label5);

        JLabel label6 = new JLabel("£1");
        frame.add(label6);

        JLabel label7 = new JLabel("50p");
        frame.add(label7);

        JLabel label8 = new JLabel("20p");
        frame.add(label8);

        JLabel label9 = new JLabel("10p");
        frame.add(label9);

        JLabel label10 = new JLabel("5p");
        frame.add(label10);

        JLabel label11 = new JLabel("2p");
        frame.add(label11);

        JLabel label12 = new JLabel("1p");
        frame.add(label12);

        frame.setVisible(true);
    }

    // main method for testing purposes
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){     // This is to create a new thread
            @Override
            public void run() {new ChangeCalcGUI();}
        });
    }

}
