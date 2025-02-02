package testGUI;

import javax.swing.*;
import javax.swing.table.TableColumn;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TestFrame 
{
	private JPanel HeaderPanel;
	private JPanel InputPanel;
	private JPanel OutputPanel;
	private JPanel CenterPanel;
	
	private JTabbedPane tabbedPane;
	private JPanel subCenterPanel1;
	private JPanel subCenterPanel2;
	private JPanel subCenterPanel3;
	
	private NumberTableModel tableModel;
	private JScrollPane scrollPane;
	
	
	public TestFrame()
	{
		//setup the frame
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setSize(1400,850);
		frame.setTitle("TEstFrame");
		
		//Header Panel
		HeaderPanel = new JPanel();
		HeaderPanel.setBackground(Color.DARK_GRAY);
		HeaderPanel.setBounds(0, 0, 1400, 100);
		
		//InputPanel Panel
		InputPanel = new JPanel();
		InputPanel.setBackground(Color.CYAN);
		InputPanel.setBounds(10, 150, 300, 400);
		InputPanel.setLayout(new GridLayout(3,3,10,10));
		

        for (int i = 0; i < 6; i++) 
        {
        	InputPanel.add(new JLabel("test " + i));
        }
		
		
		/*
		 * JLabel label1 = new JLabel(); label1.setText("test"); InputPanel.add(label1);
		 */
		
		//OutputPanel Panel
		OutputPanel = new JPanel();
		OutputPanel.setBackground(Color.RED);
		OutputPanel.setBounds(1075, 150, 300, 400);
		
		tableModel = new NumberTableModel();
        JTable table = new JTable(tableModel);

        TableColumn column = table.getColumnModel().getColumn(0);
        column.setPreferredWidth(65); // Preferred width to 50 pixels
        scrollPane = new JScrollPane(table);
		
		OutputPanel.add(scrollPane);
		scrollPane.setPreferredSize(new Dimension(130,300));
		
		
		//CenterPanel Panel
		CenterPanel = new JPanel();
		CenterPanel.setBackground(Color.DARK_GRAY);
		CenterPanel.setBounds(400, 150, 600, 200);
		
		//Muti-tabbed Pane setup
		tabbedPane = new JTabbedPane();
		subCenterPanel1 = new JPanel();
		subCenterPanel2 = new JPanel();
		subCenterPanel3 = new JPanel();
		
		subCenterPanel1.add(new JLabel("label Panel 1"));
		subCenterPanel2.add(new JLabel("label Panel 2"));
		subCenterPanel3.add(new JLabel("label Panel 3"));
        
		tabbedPane.addTab("Tab 1", subCenterPanel1);
		tabbedPane.addTab("Tab 2", subCenterPanel2);
		tabbedPane.addTab("Tab 3", subCenterPanel3);
		tabbedPane.setBounds(10, 600, 800, 200);
		frame.add(tabbedPane);
		
		
		
		frame.add(HeaderPanel);
		frame.add(InputPanel);
		frame.add(OutputPanel);
		frame.add(CenterPanel);
		
		frame.setVisible(true);
		
		
        new Timer(1000, e -> updateNumbers()).start(); // Update every second
		
		
	}

    // Update the numbers in the table
    private void updateNumbers() {
        Random random = new Random();
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            tableModel.setValueAt(random.nextInt(100), i, 0); // Update column 0 with random number
        }
    }
	
	
}
