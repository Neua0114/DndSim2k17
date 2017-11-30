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

import data.Editor;
import javax.swing.ImageIcon;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class EditSelect extends JFrame {

	private JPanel contentPane;
	private Editor edit;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditSelect frame = new EditSelect();
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

	public EditSelect() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 4, 0, 0));
		
		JButton btnFloor = new JButton("");
		btnFloor.setIcon(new ImageIcon(EditSelect.class.getResource("/res/Dark.png")));
		contentPane.add(btnFloor);
		
		JButton btnCornerNorthEast = new JButton("");
		btnCornerNorthEast.setIcon(new ImageIcon(EditSelect.class.getResource("/res/CornerNorthEast.png")));
		contentPane.add(btnCornerNorthEast);
		
		JButton btnCornerNorthWest = new JButton("");
		btnCornerNorthWest.setIcon(new ImageIcon(EditSelect.class.getResource("/res/CornerNorthWest.png")));
		contentPane.add(btnCornerNorthWest);
		
		JButton btnCornerSouthEast = new JButton("");
		btnCornerSouthEast.setIcon(new ImageIcon(EditSelect.class.getResource("/res/CornerSouthEast.png")));
		contentPane.add(btnCornerSouthEast);
		
		JButton btnCornerSouthWest = new JButton("");
		btnCornerSouthWest.setIcon(new ImageIcon(EditSelect.class.getResource("/res/CornerSouthWest.png")));
		contentPane.add(btnCornerSouthWest);
		
		JButton btnWallNorth = new JButton("");
		btnWallNorth.setIcon(new ImageIcon(EditSelect.class.getResource("/res/WallNorth.png")));
		contentPane.add(btnWallNorth);
		
		JButton btnWallSouth = new JButton("");
		btnWallSouth.setIcon(new ImageIcon(EditSelect.class.getResource("/res/WallSouth.png")));
		contentPane.add(btnWallSouth);
		
		JButton btnWallEast = new JButton("");
		btnWallEast.setIcon(new ImageIcon(EditSelect.class.getResource("/res/WallEast.png")));
		contentPane.add(btnWallEast);
		
		JButton btnWallWest = new JButton("");
		btnWallWest.setIcon(new ImageIcon(EditSelect.class.getResource("/res/WallWest.png")));
		contentPane.add(btnWallWest);
		
		btnWallWest.addActionListener(new ActionListener() { 
	          public void actionPerformed(ActionEvent e) {
	        	  edit.ChangeTile(8);
	          }
	        }); 
		
		btnFloor.addActionListener(new ActionListener() { 
	          public void actionPerformed(ActionEvent e) {
	        	  edit.ChangeTile(0);
	          }
	        }); 
		
		btnWallSouth.addActionListener(new ActionListener() { 
	          public void actionPerformed(ActionEvent e) {
	        	  edit.ChangeTile(6);
	          }
	        }); 
		
		btnWallEast.addActionListener(new ActionListener() { 
	          public void actionPerformed(ActionEvent e) {
	        	  edit.ChangeTile(7);
	          }
	        }); 
		
		btnWallNorth.addActionListener(new ActionListener() { 
	          public void actionPerformed(ActionEvent e) {
	        	  edit.ChangeTile(5);
	          }
	        }); 
		
		btnCornerSouthWest.addActionListener(new ActionListener() { 
	          public void actionPerformed(ActionEvent e) {
	        	  edit.ChangeTile(3);
	          }
	        }); 
		
		btnCornerSouthEast.addActionListener(new ActionListener() { 
	          public void actionPerformed(ActionEvent e) {
	        	  edit.ChangeTile(4);
	          }
	        }); 
		
		btnCornerNorthWest.addActionListener(new ActionListener() { 
	          public void actionPerformed(ActionEvent e) {
	        	  edit.ChangeTile(1);
	          }
	        }); 
		
		btnCornerNorthEast.addActionListener(new ActionListener() { 
	          public void actionPerformed(ActionEvent e) {
	        	  edit.ChangeTile(2);
	          }
	        }); 
	}
	
	public void setEdit(Editor edit) {
		this.edit = edit;
	}

}
