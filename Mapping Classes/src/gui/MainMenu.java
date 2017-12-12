package gui;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import static helpers.StateManager.*;
@SuppressWarnings("serial")
public class MainMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
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
	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 212, 92);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton btnSimulation = new JButton("Simulation");
		GridBagConstraints gbc_btnSimulation = new GridBagConstraints();
		gbc_btnSimulation.insets = new Insets(0, 0, 0, 5);
		gbc_btnSimulation.gridx = 0;
		gbc_btnSimulation.gridy = 0;
		contentPane.add(btnSimulation, gbc_btnSimulation);
		
		JButton btnEditor = new JButton("Editor");
		GridBagConstraints gbc_btnEditor = new GridBagConstraints();
		gbc_btnEditor.gridx = 1;
		gbc_btnEditor.gridy = 0;
		contentPane.add(btnEditor, gbc_btnEditor);
		
		btnSimulation.addActionListener(new ActionListener() { 
	          public void actionPerformed(ActionEvent e) {
	        	  state = State.LOAD;
	        	  menu.setVisible(false);
	          }
	        }); 
		
		btnEditor.addActionListener(new ActionListener() { 
	          public void actionPerformed(ActionEvent e) {
	        	  state = State.SCALE;
	          }
	        });
		
		
	}

}
