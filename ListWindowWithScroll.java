
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
public class ListWindowWithScroll extends JFrame
{
   private JPanel monthPanel;         // To hold components
   private JPanel selectedMonthPanel; // To hold components
   private JList monthList;           // The months
   private JScrollPane scrollPane;    // A scroll pane
   private JTextField selectedMonth;  // The selected month
   private JLabel label;              // A message

   private String[] months = { "January", "February",
            "March", "April", "May", "June", "July",  "August", "September", "October", "November", "December" };

   public ListWindowWithScroll()
   {
      // Set the title.
      setTitle("List Demo");
      // Specify an action for the close button.
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // Add a BorderLayout manager.
      setLayout(new BorderLayout());
      // Build the month and selectedMonth panels.
      buildMonthPanel();
      buildSelectedMonthPanel();
      // Add the panels to the content pane.
      add(monthPanel, BorderLayout.CENTER);
      add(selectedMonthPanel, BorderLayout.SOUTH);
      // Pack and display the window.
      pack();
      setVisible(true);
   }
   private void buildMonthPanel()
   {
      // Create a panel to hold the list.
      monthPanel = new JPanel();
      // Create the list.
      monthList = new JList(months);
      // Set the selection mode to single selection.
      monthList.setSelectionMode( ListSelectionModel.SINGLE_SELECTION);
      // Register the list selection listener.
      monthList.addListSelectionListener(new ListListener());
      // Set the number of visible rows to 6.
      monthList.setVisibleRowCount(6);
      // Add the list to a scroll pane.
      scrollPane = new JScrollPane(monthList);
      // Add the scroll pane to the panel.
      monthPanel.add(scrollPane);
   }
   private void buildSelectedMonthPanel()
   {
      // Create a panel to hold the text field.
      selectedMonthPanel = new JPanel();
      // Create the label.
      label = new JLabel("You selected: ");
      // Create the text field.
      selectedMonth = new JTextField(10);
      // Make the text field uneditable.
      selectedMonth.setEditable(false);
      // Add the label and text field to the panel.
      selectedMonthPanel.add(label);
      selectedMonthPanel.add(selectedMonth);
   }

   private class ListListener implements ListSelectionListener
   {
      public void valueChanged(ListSelectionEvent e)
      {
         // Get the selected month.
         String selection =
               (String) monthList.getSelectedValue();
         selectedMonth.setText(selection);
      }
   }
     public static void main(String[] args)
     {
          ListWindowWithScroll lw = new ListWindowWithScroll();
     }
}