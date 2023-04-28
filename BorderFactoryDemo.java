
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * This class demonstrates the use of BorderFactory class to draw borders around
 * the JComponent objects
 *
 * @author Rahul Sapkal(rahul@javareference.com)
 */
public class BorderFactoryDemo extends JFrame {

    /**
     * Constructor
     */
    public BorderFactoryDemo() {
        super("Border Factory Demo");

        //creating main panel
        JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        //createing simple borders
        JPanel simplePanel = new JPanel(new GridLayout(7, 1, 5, 5));
        simplePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel simpleLabel = new JLabel("SIMPLE BORDERS", JLabel.CENTER);
        simpleLabel.setForeground(Color.red.darker());
        simplePanel.add(simpleLabel);

        JLabel lineBorderLabel = new JLabel("Line Border", JLabel.CENTER);
        lineBorderLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        simplePanel.add(lineBorderLabel);

        JLabel etchedRasBorderLabel = new JLabel("Raised Etched Border", JLabel.CENTER);
        etchedRasBorderLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        simplePanel.add(etchedRasBorderLabel);

        JLabel etchedLowBorderLabel = new JLabel("Lowered Etched Border", JLabel.CENTER);
        etchedLowBorderLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        simplePanel.add(etchedLowBorderLabel);

        JLabel bevelRasBorderLabel = new JLabel("Raised Bevel Border", JLabel.CENTER);
        bevelRasBorderLabel.setBorder(BorderFactory.createRaisedBevelBorder());
        simplePanel.add(bevelRasBorderLabel);

        JLabel bevelLowBorderLabel = new JLabel("Lowered Bevel Border", JLabel.CENTER);
        bevelLowBorderLabel.setBorder(BorderFactory.createLoweredBevelBorder());
        simplePanel.add(bevelLowBorderLabel);

        JLabel emptyBorderLabel = new JLabel("Empty Border", JLabel.CENTER);
        emptyBorderLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        simplePanel.add(emptyBorderLabel);

        //creating title borders
        JPanel titlePanel = new JPanel(new GridLayout(6, 1, 5, 5));
        titlePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel titleLabel = new JLabel("TITLE BORDERS", JLabel.CENTER);
        titleLabel.setForeground(Color.red.darker());
        titlePanel.add(titleLabel);

        JPanel titleBorderPanel = new JPanel();
        titleBorderPanel.setBorder(BorderFactory.createTitledBorder("Title Border"));
        titleBorderPanel.add(new JLabel("JavaReference.com Examples"), JLabel.CENTER);
        titlePanel.add(titleBorderPanel);

        JPanel titleLineBorderPanel = new JPanel();
        titleLineBorderPanel.add(new JLabel("JavaReference.com Examples"), JLabel.CENTER);
        titleLineBorderPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLUE), "Title Line Border with color"));
        titlePanel.add(titleLineBorderPanel);

        JPanel titleLowEtcBorderPanel = new JPanel();
        titleLowEtcBorderPanel.add(new JLabel("JavaReference.com Examples", JLabel.CENTER));
        titleLowEtcBorderPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Title Lowered Etched Border"));
        titlePanel.add(titleLowEtcBorderPanel);

        JPanel titleLowBevBorderPanel = new JPanel();
        titleLowBevBorderPanel.add(new JLabel("JavaReference.com Examples", JLabel.CENTER));
        titleLowBevBorderPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLoweredBevelBorder(), "Title Lowered Bevel Border"));
        titlePanel.add(titleLowBevBorderPanel);

        JPanel titleEmptyBorderPanel = new JPanel();
        titleEmptyBorderPanel.add(new JLabel("JavaReference.com Examples", JLabel.CENTER));
        titleEmptyBorderPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(
                10, 10, 10, 10), "Title Empty Border"));
        titlePanel.add(titleEmptyBorderPanel);

        //creating matte borders
        JPanel mattePanel = new JPanel(new GridLayout(4, 1, 5, 5));
        mattePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel matteLabel = new JLabel("MATTE BORDERS", JLabel.CENTER);
        matteLabel.setForeground(Color.red.darker());
        mattePanel.add(matteLabel);

        ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("matte.gif"));

        JLabel matteIconBorderLabel = new JLabel("Matt Border with Icon", JLabel.CENTER);
        matteIconBorderLabel.setBorder(BorderFactory.createMatteBorder(
                -1, -1, -1, -1, icon));
        mattePanel.add(matteIconBorderLabel);

        JLabel mattIconBorderWithSpaceLabel = new JLabel("Matt Border with Icon and Spacing",
                JLabel.CENTER);
        mattIconBorderWithSpaceLabel.setBorder(BorderFactory.createMatteBorder(
                0, 20, 0, 0, icon));
        mattePanel.add(mattIconBorderWithSpaceLabel);

        JLabel mattColorBorderLabel = new JLabel("Matt Border with Color and Spacing", JLabel.CENTER);
        mattColorBorderLabel.setBorder(BorderFactory.createMatteBorder(
                2, 5, 2, 5, Color.BLUE));
        mattePanel.add(mattColorBorderLabel);

        //creating compound borders
        JPanel compPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        compPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel compLabel = new JLabel("COMPOUND BORDERS", JLabel.CENTER);
        compLabel.setForeground(Color.red.darker());
        compPanel.add(compLabel);

        JLabel compBevelLabel = new JLabel("Rasied and Low Bevel combination", JLabel.CENTER);
        compBevelLabel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),
                BorderFactory.createLoweredBevelBorder()));
        compPanel.add(compBevelLabel);

        JLabel compMatteLineBorderLabel = new JLabel("Matte and Line border combination", JLabel.CENTER);
        compMatteLineBorderLabel.setBorder(
                BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.red),
                        BorderFactory.createMatteBorder(-1, -1, -1, -1, icon)));
        compPanel.add(compMatteLineBorderLabel);

        //adding border panels to main panel
        mainPanel.add(simplePanel);
        mainPanel.add(titlePanel);
        mainPanel.add(mattePanel);
        mainPanel.add(compPanel);

        //adding mainpanel to the frame
        getContentPane().add(mainPanel);
    }

    /**
     * Main method to run as an Application
     *
     * @param argv
     */
    public static void main(String[] argv) {
        BorderFactoryDemo borderFactoryDemo = new BorderFactoryDemo();
        borderFactoryDemo.setVisible(true);
        borderFactoryDemo.pack();
         // Specify an action for the close button.
        borderFactoryDemo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
