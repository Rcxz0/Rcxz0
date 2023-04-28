/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter12;

import java.awt.FlowLayout;
import javax.swing.*; //Needed for Swing classes 
import java.awt.event.*; //Needed for ActionListener Interface
import java.io.IOException;

public class KiloConverter extends JFrame implements ActionListener {

    private JPanel panel; // to reference a panel
    private JLabel messageLabel; // To reference a label
    private JTextField kiloTextField; // To reference a text field
    private JButton calcButton; //To reference a button
    private final int WINDOW_WIDTH = 350; //Window width
    private final int WINDOW_HEIGHT = 100; // Window Height

    /**
     * Constructor
     */
    public KiloConverter() {

        //Set the window title.
        setTitle("Kilometer Converter");

        //Set the size of the window.
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        //Specify what happens when the close button is clicked
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Build the panel and add it to the JFrame.
        buildPanel();

        //Add Panel to the frame's content pane.
        add(panel);

        //Display the window.
        setVisible(true);
    }

    /**
     * The buildPanel method adds a label, a text field, and a button to a
     * panel.
     */
    private void buildPanel() {

        //Create a label to display instructions.
        messageLabel = new JLabel("Enter a distance "
                + "in kilometers");

        //Create a text field of 10 characters wide.
        kiloTextField = new JTextField(10);
        //kiloTextField.setEditable(false);

        //Create a button with the caption "Calculate"
        calcButton = new JButton("Calculate");

        //Add an action listener to the button.
        //1st Way
        calcButton.addActionListener(new CalcMiles());
        //2nd Way
        //calcButton.addActionListener(this); 
        /* 3rd Way
        calcButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            
            final double CONVERSION = 0.6214;
            String input; // To hold the user's input
            double miles; // The number of miles

            //Get the text entered by the user into the text field.
            input = kiloTextField.getText();
            miles = 0;
            try{
            //Convert the input to miles.
            miles = Double.parseDouble(input) * CONVERSION;
            }catch(NumberFormatException nfe){
                JOptionPane.showMessageDialog(null, "Please enter kilometers in numbers only, current value = ( " + input + " )");
                return;
            }

            //Display the result.
            JOptionPane.showMessageDialog(null, input
                    + " kilometers is " + miles + " miles.");
        }
        });
         */
        //Create a JPanel Object and let the Panel field reference it.
        panel = new JPanel();

        //Add the label, text field, and button components to the panel
        panel.add(messageLabel);
        panel.add(kiloTextField);
        panel.add(calcButton);
        //panel.setLayout(new FlowLayout(FlowLayout.LEFT));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        final double CONVERSION = 0.6214;
        String input; // To hold the user's input
        double miles; // The number of miles

        //Get the text entered by the user into the text field.
        input = kiloTextField.getText();
        miles = 0;
        try {
            //Convert the input to miles.
            miles = Double.parseDouble(input) * CONVERSION;
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Please enter kilometers in numbers only, current value = ( " + input + " )");
            return;
        }

        //Display the result.
        JOptionPane.showMessageDialog(null, input
                + " kilometers is " + miles + " miles.");

    }

    /**
     * calcButtonListener is an action listener class for the Calculate button.
     */
    private class CalcMiles implements ActionListener {

        /**
         * The actionPerformed method executes when the user clicks on the
         * Calculate button.
         *
         * @param e The event object.
         */
        public void actionPerformed(ActionEvent e) {

            final double CONVERSION = 0.6214;
            String input; // To hold the user's input
            double miles; // The number of miles

            //Get the text entered by the user into the text field.
            input = kiloTextField.getText();
            miles = 0;
            try {
                //Convert the input to miles.
                miles = Double.parseDouble(input) * CONVERSION;
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Please enter kilometers in numbers only, current value = ( " + input + " )");
                return;
            }

            //Display the result.
            JOptionPane.showMessageDialog(null, input
                    + " kilometers is " + miles + " miles.");
        }
    }
    
    
    /**
     * main method
     */
    public static void main(String[] args) {

        new KiloConverter();
    }
}
