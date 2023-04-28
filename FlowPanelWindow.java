
import javax.swing.*; // Needed for Swing classes
import java.awt.*; // Needed for BorderLayout class
import java.awt.event.ActionEvent;

public class FlowPanelWindow extends JFrame{
  private final int WINDOW_WIDTH = 250; // Window width
  private final int WINDOW_HEIGHT = 190; // Window height  
  JRadioButton btn1, btn2; //JRadioButton objects 
  JTextField t1, t2; //JTextField objects 

    public FlowPanelWindow()
    {
        setTitle("Tempreture Converter");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        JPanel panel12 = new JPanel();
        JLabel Celsius = new JLabel("Celsius");
        t1 = new JTextField(15);
        JPanel panel34 = new JPanel();
        JLabel Fihrenhite = new JLabel("Fihrenhite");
        t2 = new JTextField(10);
        JPanel panel56 = new JPanel();
        btn1 = new JRadioButton("Celsius");
        btn2 = new JRadioButton("Fihrenhite");
        ButtonGroup Group = new ButtonGroup();
        Group.add(btn1);
        Group.add(btn2);
        JPanel panel8 = new JPanel();
        JButton calculate = new JButton("Calculate");
        calculate.addActionListener(null);
        panel12.add(Celsius);
        panel12.add(t1);
        panel34.add(Fihrenhite);
        panel34.add(t2);
        panel56.add(btn1);
        panel56.add(btn2);
        panel8.add(calculate);
        add(panel12);
        add(panel34);
        add(panel56);
        add(panel8);
        setVisible(true);
        // Center the frame 
        setLocationRelativeTo(null); 
        // Display the window.
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent a) {
        
        if(btn1.isSelected())
        {
            double celsius = Double.parseDouble(t1.getText());
            double fahrenheit =  (celsius * 9/5) + 32; 
            t2.setText(String.valueOf(fahrenheit));
        }
        else if(btn2.isSelected())
        {
            double Fahrenheit = Double.parseDouble(t2.getText());
            double Celsius =  ((Fahrenheit - 32) * 5) / 9;
            t1.setText(String.valueOf(Celsius));
        }
    }
    public static void main(String[] args)
    {
        new FlowPanelWindow();
    }
}
