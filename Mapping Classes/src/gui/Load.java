package gui;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import data.Boot;
import helpers.StateManager;
import helpers.StateManager.*;

import static helpers.SaveLoad.*;

@SuppressWarnings("serial")
public class Load extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Load frame = new Load();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Load() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 185, 98);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{65, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblFileName = new JLabel("File Name:");
		GridBagConstraints gbc_lblFileName = new GridBagConstraints();
		gbc_lblFileName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFileName.anchor = GridBagConstraints.EAST;
		gbc_lblFileName.gridx = 0;
		gbc_lblFileName.gridy = 0;
		contentPane.add(lblFileName, gbc_lblFileName);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnLoad = new JButton("Load");
		GridBagConstraints gbc_btnLoad = new GridBagConstraints();
		gbc_btnLoad.gridx = 1;
		gbc_btnLoad.gridy = 1;
		contentPane.add(btnLoad, gbc_btnLoad);
		
		
		btnLoad.addActionListener(new ActionListener() { 
	          public void actionPerformed(ActionEvent e) {
	        	  
	        	  File test = new File("src/simulations/"+ textField.getText() +".simulation");
	        	  
	        	  if(test.exists()) {
	        		  loadSimulation(textField.getText());
	        		 StateManager.state = State.SIMULATION;
	        		 Boot.toggleRun();
	        	  }
	        	  else {
	        		  JOptionPane.showMessageDialog(null, "File does not exist", "Invalid File", JOptionPane.ERROR_MESSAGE);
	        	  }
		
	          }
	        });
	}

}
