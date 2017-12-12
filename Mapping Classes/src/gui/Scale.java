package gui;

import static helpers.Artist.setDimensions;

import static helpers.StateManager.*;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import data.Boot;

import helpers.StateManager.State;

@SuppressWarnings("serial")
public class Scale extends JFrame {

	private JPanel contentPane;
	private JTextField txtWidth;
	private JTextField txtHeight;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Scale frame = new Scale();
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
	public Scale() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 323, 114);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblScale = new JLabel("Scale:");
		GridBagConstraints gbc_lblScale = new GridBagConstraints();
		gbc_lblScale.insets = new Insets(0, 0, 5, 5);
		gbc_lblScale.gridx = 0;
		gbc_lblScale.gridy = 0;
		contentPane.add(lblScale, gbc_lblScale);
		
		JRadioButton rdbtn32px = new JRadioButton("32px");
		rdbtn32px.setSelected(true);
		GridBagConstraints gbc_rdbtn32px = new GridBagConstraints();
		gbc_rdbtn32px.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtn32px.gridx = 1;
		gbc_rdbtn32px.gridy = 0;
		contentPane.add(rdbtn32px, gbc_rdbtn32px);
		
		JRadioButton rdbtn48px = new JRadioButton("48px");
		GridBagConstraints gbc_rdbtn48px = new GridBagConstraints();
		gbc_rdbtn48px.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtn48px.gridx = 2;
		gbc_rdbtn48px.gridy = 0;
		contentPane.add(rdbtn48px, gbc_rdbtn48px);
		
		JRadioButton rdbtn64px = new JRadioButton("64px");
		GridBagConstraints gbc_rdbtn64px = new GridBagConstraints();
		gbc_rdbtn64px.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtn64px.gridx = 3;
		gbc_rdbtn64px.gridy = 0;
		contentPane.add(rdbtn64px, gbc_rdbtn64px);
		
		JLabel lblWidth = new JLabel("Width:");
		GridBagConstraints gbc_lblWidth = new GridBagConstraints();
		gbc_lblWidth.anchor = GridBagConstraints.EAST;
		gbc_lblWidth.insets = new Insets(0, 0, 0, 5);
		gbc_lblWidth.gridx = 0;
		gbc_lblWidth.gridy = 1;
		contentPane.add(lblWidth, gbc_lblWidth);
		
		txtWidth = new JTextField();
		GridBagConstraints gbc_txtWidth = new GridBagConstraints();
		gbc_txtWidth.insets = new Insets(0, 0, 0, 5);
		gbc_txtWidth.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtWidth.gridx = 1;
		gbc_txtWidth.gridy = 1;
		contentPane.add(txtWidth, gbc_txtWidth);
		txtWidth.setColumns(3);
		
		JLabel lblHeight = new JLabel("Height:");
		GridBagConstraints gbc_lblHeight = new GridBagConstraints();
		gbc_lblHeight.anchor = GridBagConstraints.EAST;
		gbc_lblHeight.insets = new Insets(0, 0, 0, 5);
		gbc_lblHeight.gridx = 2;
		gbc_lblHeight.gridy = 1;
		contentPane.add(lblHeight, gbc_lblHeight);
		
		txtHeight = new JTextField();
		GridBagConstraints gbc_txtHeight = new GridBagConstraints();
		gbc_txtHeight.insets = new Insets(0, 0, 0, 5);
		gbc_txtHeight.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHeight.gridx = 3;
		gbc_txtHeight.gridy = 1;
		contentPane.add(txtHeight, gbc_txtHeight);
		txtHeight.setColumns(3);
		
		JButton btnSubmit = new JButton("Submit");
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.gridx = 5;
		gbc_btnSubmit.gridy = 1;
		contentPane.add(btnSubmit, gbc_btnSubmit);
		
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtn32px);
		group.add(rdbtn48px);
		group.add(rdbtn64px);
		
		btnSubmit.addActionListener(new ActionListener() { 
	          public void actionPerformed(ActionEvent e) {
	        	  int width = Integer.parseInt(txtWidth.getText());
	        	  int height = Integer.parseInt(txtHeight.getText());
	        	  int scale = 32;
	        	  if (rdbtn32px.isSelected())
	        		  scale = 32;
	        	  else if (rdbtn48px.isSelected())
	        		  scale = 48;
	        	  else if (rdbtn64px.isSelected())
	        		  scale = 64;
	        	  
	        	  setDimensions(width*scale, height*scale, scale);
	        	  mapWidth = width;
	        	  mapHeight = height;
	        	  state = State.EDITOR;
	        	  Boot.toggleRun();
	        	  dispose();
	          }
	        });
	}

}
