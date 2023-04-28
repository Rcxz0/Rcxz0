
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuWindow extends JFrame
{
   private JLabel messageLabel; // Displays a message
   private final int LABEL_WIDTH = 400;  // Label's width
   private final int LABEL_HEIGHT = 200; // Label's height

   // The following will reference menu components.
   private JMenuBar menuBar;    // The menu bar
   private JMenu fileMenu;      // The File menu
   private JMenu textMenu;      // The Text menu
   private JMenuItem exitItem;  // To exit
   private JRadioButtonMenuItem blackItem; // Makes text black
   private JRadioButtonMenuItem redItem;   // Makes text red
   private JRadioButtonMenuItem blueItem;  // Makes text blue
   private JCheckBoxMenuItem visibleItem;  // Toggle visibility

   public MenuWindow()
   {
      // Set the title.
      setTitle("Example Menu System");
      // Specify an action for the close button.
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // Create the messageLabel label.
      messageLabel = new JLabel("Use the Text menu to " +
            "change my color and make me invisible.",  SwingConstants.CENTER);
      // Set the label's preferred size.
      messageLabel.setPreferredSize(new Dimension(LABEL_WIDTH, LABEL_HEIGHT));
      // Set the label's foreground color.
      messageLabel.setForeground(Color.black);
      // Add the label to the content pane.
      add(messageLabel);
      // Build the menu bar.
      buildMenuBar();
      // Set the window's menu bar.
      setJMenuBar(menuBar);
      // Pack and display the window.
      pack();
      setVisible(true);
   }
   private void buildMenuBar()
   {
      // Create the menu bar.
      menuBar = new JMenuBar();
      // Create the file and text menus.
      buildFileMenu();
      buildTextMenu();
      // Add the file and text menus to the menu bar.
      menuBar.add(fileMenu);
      menuBar.add(textMenu);

   }
   private void buildFileMenu()
   {
      // Create an Exit menu item.
      exitItem = new JMenuItem("Exit");
      exitItem.addActionListener(new ExitListener());
      // Create a JMenu object for the File menu.
      fileMenu = new JMenu("File");
      // Add the Exit menu item to the File menu.
      fileMenu.add(exitItem);
   }

   private void buildTextMenu()
   {
      blackItem = new JRadioButtonMenuItem("Black", true);
      blackItem.addActionListener(new ColorListener());

      redItem = new JRadioButtonMenuItem("Red");
      redItem.addActionListener(new ColorListener());

      blueItem = new JRadioButtonMenuItem("Blue");
      blueItem.addActionListener(new ColorListener());

      ButtonGroup group = new ButtonGroup();
      group.add(blackItem);
      group.add(redItem);
      group.add(blueItem);
      visibleItem = new JCheckBoxMenuItem("Visible", true);
      visibleItem.addActionListener(new VisibleListener());

      textMenu = new JMenu("Text");

      textMenu.add(blackItem);
      textMenu.add(redItem);
      textMenu.add(blueItem);
      textMenu.addSeparator(); // Add a separator bar.
      textMenu.add(visibleItem);
   }

    private class ExitListener implements ActionListener
    {
       public void actionPerformed(ActionEvent e)
       {
          System.exit(0);
       }
    }

    private class ColorListener implements ActionListener
    {
       public void actionPerformed(ActionEvent e)
       {
          if (blackItem.isSelected())
             messageLabel.setForeground(Color.black);
          else if (redItem.isSelected())
             messageLabel.setForeground(Color.red);
          else if (blueItem.isSelected())
             messageLabel.setForeground(Color.blue);
       }
    }

   private class VisibleListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if (visibleItem.isSelected())
            messageLabel.setVisible(true);
         else
            messageLabel.setVisible(false);
      }
   }
   public static void main(String[] args)
   {
      new MenuWindow();
   }
}