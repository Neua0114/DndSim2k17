package gui;

import static helpers.StateManager.editing;
import static helpers.StateManager.*;
import static helpers.SaveLoad.*;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;


import data.Editor;
import data.EntityType;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
@SuppressWarnings("serial")
public class EditSelect extends JFrame {

	private JPanel contentPane;
	private Editor edit;
	private JTextField txtFile;
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
		setBounds(100, 100, 537, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{571, 0};
		gbl_contentPane.rowHeights = new int[]{342, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setToolTipText("Tiles");
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		contentPane.add(tabbedPane, gbc_tabbedPane);
		
		JPanel pnlTiles = new JPanel();
		tabbedPane.addTab("Tiles", null, pnlTiles, null);
		GridBagLayout gbl_pnlTiles = new GridBagLayout();
		gbl_pnlTiles.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_pnlTiles.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_pnlTiles.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlTiles.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlTiles.setLayout(gbl_pnlTiles);
		
		JButton btnFloor = new JButton("");
		btnFloor.setIcon(new ImageIcon(EditSelect.class.getResource("/res/Dark.png")));
		GridBagConstraints gbc_btnFloor = new GridBagConstraints();
		gbc_btnFloor.insets = new Insets(0, 0, 5, 5);
		gbc_btnFloor.gridx = 0;
		gbc_btnFloor.gridy = 0;
		pnlTiles.add(btnFloor, gbc_btnFloor);
		
		JButton btnCornerNorthEast = new JButton("");
		btnCornerNorthEast.setIcon(new ImageIcon(EditSelect.class.getResource("/res/CornerNorthEast.png")));
		GridBagConstraints gbc_btnCornerNorthEast = new GridBagConstraints();
		gbc_btnCornerNorthEast.insets = new Insets(0, 0, 5, 5);
		gbc_btnCornerNorthEast.gridx = 0;
		gbc_btnCornerNorthEast.gridy = 1;
		pnlTiles.add(btnCornerNorthEast, gbc_btnCornerNorthEast);
		
		JButton btnCornerNorthWest = new JButton("");
		btnCornerNorthWest.setIcon(new ImageIcon(EditSelect.class.getResource("/res/CornerNorthWest.png")));
		GridBagConstraints gbc_btnCornerNorthWest = new GridBagConstraints();
		gbc_btnCornerNorthWest.insets = new Insets(0, 0, 5, 5);
		gbc_btnCornerNorthWest.gridx = 1;
		gbc_btnCornerNorthWest.gridy = 1;
		pnlTiles.add(btnCornerNorthWest, gbc_btnCornerNorthWest);
		
		JButton btnCornerSouthEast = new JButton("");
		btnCornerSouthEast.setIcon(new ImageIcon(EditSelect.class.getResource("/res/CornerSouthEast.png")));
		GridBagConstraints gbc_btnCornerSouthEast = new GridBagConstraints();
		gbc_btnCornerSouthEast.insets = new Insets(0, 0, 5, 5);
		gbc_btnCornerSouthEast.gridx = 2;
		gbc_btnCornerSouthEast.gridy = 1;
		pnlTiles.add(btnCornerSouthEast, gbc_btnCornerSouthEast);
		
		JButton btnCornerSouthWest = new JButton("");
		btnCornerSouthWest.setIcon(new ImageIcon(EditSelect.class.getResource("/res/CornerSouthWest.png")));
		GridBagConstraints gbc_btnCornerSouthWest = new GridBagConstraints();
		gbc_btnCornerSouthWest.insets = new Insets(0, 0, 5, 0);
		gbc_btnCornerSouthWest.gridx = 3;
		gbc_btnCornerSouthWest.gridy = 1;
		pnlTiles.add(btnCornerSouthWest, gbc_btnCornerSouthWest);
		
		JButton btnWallNorth = new JButton("");
		btnWallNorth.setIcon(new ImageIcon(EditSelect.class.getResource("/res/WallNorth.png")));
		GridBagConstraints gbc_btnWallNorth = new GridBagConstraints();
		gbc_btnWallNorth.insets = new Insets(0, 0, 5, 5);
		gbc_btnWallNorth.gridx = 0;
		gbc_btnWallNorth.gridy = 2;
		pnlTiles.add(btnWallNorth, gbc_btnWallNorth);
		
		JButton btnWallSouth = new JButton("");
		btnWallSouth.setIcon(new ImageIcon(EditSelect.class.getResource("/res/WallSouth.png")));
		GridBagConstraints gbc_btnWallSouth = new GridBagConstraints();
		gbc_btnWallSouth.insets = new Insets(0, 0, 5, 5);
		gbc_btnWallSouth.gridx = 1;
		gbc_btnWallSouth.gridy = 2;
		pnlTiles.add(btnWallSouth, gbc_btnWallSouth);
		
		JButton btnWallEast = new JButton("");
		btnWallEast.setIcon(new ImageIcon(EditSelect.class.getResource("/res/WallEast.png")));
		GridBagConstraints gbc_btnWallEast = new GridBagConstraints();
		gbc_btnWallEast.insets = new Insets(0, 0, 5, 5);
		gbc_btnWallEast.gridx = 2;
		gbc_btnWallEast.gridy = 2;
		pnlTiles.add(btnWallEast, gbc_btnWallEast);
		
		JButton btnWallWest = new JButton("");
		btnWallWest.setIcon(new ImageIcon(EditSelect.class.getResource("/res/WallWest.png")));
		GridBagConstraints gbc_btnWallWest = new GridBagConstraints();
		gbc_btnWallWest.insets = new Insets(0, 0, 5, 0);
		gbc_btnWallWest.gridx = 3;
		gbc_btnWallWest.gridy = 2;
		pnlTiles.add(btnWallWest, gbc_btnWallWest);
		
		JButton btnHallNorthSouth = new JButton("");
		btnHallNorthSouth.setIcon(new ImageIcon(EditSelect.class.getResource("/res/HallNorthSouth.png")));
		GridBagConstraints gbc_btnHallNorthSouth = new GridBagConstraints();
		gbc_btnHallNorthSouth.insets = new Insets(0, 0, 0, 5);
		gbc_btnHallNorthSouth.gridx = 0;
		gbc_btnHallNorthSouth.gridy = 3;
		pnlTiles.add(btnHallNorthSouth, gbc_btnHallNorthSouth);
		
		JButton btnHallEastWest = new JButton("");
		btnHallEastWest.setIcon(new ImageIcon(EditSelect.class.getResource("/res/HallEastWest.png")));
		GridBagConstraints gbc_btnHallEastWest = new GridBagConstraints();
		gbc_btnHallEastWest.insets = new Insets(0, 0, 0, 5);
		gbc_btnHallEastWest.gridx = 1;
		gbc_btnHallEastWest.gridy = 3;
		pnlTiles.add(btnHallEastWest, gbc_btnHallEastWest);
		
		JPanel pnlEntities = new JPanel();
		tabbedPane.addTab("Entities", null, pnlEntities, null);
		GridBagLayout gbl_pnlEntities = new GridBagLayout();
		gbl_pnlEntities.columnWidths = new int[]{64, 0, 0, 0, 0, 0};
		gbl_pnlEntities.rowHeights = new int[]{73, 0, 0, 0, 0};
		gbl_pnlEntities.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlEntities.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlEntities.setLayout(gbl_pnlEntities);
		//"/res/CharCleric.png"
		JButton btnCharCleric = new JButton("");
		btnCharCleric.setIcon(resizeIcon(new ImageIcon(EditSelect.class.getResource("/res/CharCleric.png"))));
		GridBagConstraints gbc_btnCharCleric = new GridBagConstraints();
		gbc_btnCharCleric.insets = new Insets(0, 0, 5, 5);
		gbc_btnCharCleric.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnCharCleric.gridx = 0;
		gbc_btnCharCleric.gridy = 0;
		pnlEntities.add(btnCharCleric, gbc_btnCharCleric);
		
		JButton btnCharFighter = new JButton("");
		btnCharFighter.setIcon(resizeIcon(new ImageIcon(EditSelect.class.getResource("/res/CharFighter.png"))));
		GridBagConstraints gbc_btnCharFighter = new GridBagConstraints();
		gbc_btnCharFighter.insets = new Insets(0, 0, 5, 5);
		gbc_btnCharFighter.gridx = 1;
		gbc_btnCharFighter.gridy = 0;
		pnlEntities.add(btnCharFighter, gbc_btnCharFighter);
		
		JButton btnCharRanger = new JButton("");
		btnCharRanger.setIcon(resizeIcon(new ImageIcon(EditSelect.class.getResource("/res/CharRanger.png"))));
		GridBagConstraints gbc_btnCharRanger = new GridBagConstraints();
		gbc_btnCharRanger.insets = new Insets(0, 0, 5, 5);
		gbc_btnCharRanger.gridx = 2;
		gbc_btnCharRanger.gridy = 0;
		pnlEntities.add(btnCharRanger, gbc_btnCharRanger);
		
		JButton btnCharRogue = new JButton("");
		btnCharRogue.setIcon(resizeIcon(new ImageIcon(EditSelect.class.getResource("/res/CharRogue.png"))));
		GridBagConstraints gbc_btnCharRogue = new GridBagConstraints();
		gbc_btnCharRogue.insets = new Insets(0, 0, 5, 5);
		gbc_btnCharRogue.gridx = 3;
		gbc_btnCharRogue.gridy = 0;
		pnlEntities.add(btnCharRogue, gbc_btnCharRogue);
		
		JButton btnCharWizard = new JButton("");
		btnCharWizard.setIcon(resizeIcon(new ImageIcon(EditSelect.class.getResource("/res/CharWizard.png"))));
		GridBagConstraints gbc_btnCharWizard = new GridBagConstraints();
		gbc_btnCharWizard.insets = new Insets(0, 0, 5, 0);
		gbc_btnCharWizard.gridx = 4;
		gbc_btnCharWizard.gridy = 0;
		pnlEntities.add(btnCharWizard, gbc_btnCharWizard);
		
		JButton btnMonBeetle = new JButton("");
		btnMonBeetle.setIcon(resizeIcon(new ImageIcon(EditSelect.class.getResource("/res/MonBeetle.png"))));
		GridBagConstraints gbc_btnMonBeetle = new GridBagConstraints();
		gbc_btnMonBeetle.insets = new Insets(0, 0, 5, 5);
		gbc_btnMonBeetle.gridx = 0;
		gbc_btnMonBeetle.gridy = 1;
		pnlEntities.add(btnMonBeetle, gbc_btnMonBeetle);
		
		JButton btnMonGoblin = new JButton("");
		btnMonGoblin.setIcon(resizeIcon(new ImageIcon(EditSelect.class.getResource("/res/MonGoblin.png"))));
		GridBagConstraints gbc_btnMonGoblin = new GridBagConstraints();
		gbc_btnMonGoblin.insets = new Insets(0, 0, 5, 5);
		gbc_btnMonGoblin.gridx = 1;
		gbc_btnMonGoblin.gridy = 1;
		pnlEntities.add(btnMonGoblin, gbc_btnMonGoblin);
		
		JButton btnMonHalfOgre = new JButton("");
		btnMonHalfOgre.setIcon(resizeIcon(new ImageIcon(EditSelect.class.getResource("/res/MonHalfOgre.png"))));
		GridBagConstraints gbc_btnMonHalfOgre = new GridBagConstraints();
		gbc_btnMonHalfOgre.insets = new Insets(0, 0, 5, 5);
		gbc_btnMonHalfOgre.gridx = 2;
		gbc_btnMonHalfOgre.gridy = 1;
		pnlEntities.add(btnMonHalfOgre, gbc_btnMonHalfOgre);
		
		JButton btnMonHobgoblin = new JButton("");
		btnMonHobgoblin.setIcon(resizeIcon(new ImageIcon(EditSelect.class.getResource("/res/MonHobgoblin.png"))));
		GridBagConstraints gbc_btnMonHobgoblin = new GridBagConstraints();
		gbc_btnMonHobgoblin.insets = new Insets(0, 0, 5, 5);
		gbc_btnMonHobgoblin.gridx = 3;
		gbc_btnMonHobgoblin.gridy = 1;
		pnlEntities.add(btnMonHobgoblin, gbc_btnMonHobgoblin);
		
		JButton btnMonKobold = new JButton("");
		btnMonKobold.setIcon(resizeIcon(new ImageIcon(EditSelect.class.getResource("/res/MonKobold.png"))));
		GridBagConstraints gbc_btnMonKobold = new GridBagConstraints();
		gbc_btnMonKobold.insets = new Insets(0, 0, 5, 0);
		gbc_btnMonKobold.gridx = 4;
		gbc_btnMonKobold.gridy = 1;
		pnlEntities.add(btnMonKobold, gbc_btnMonKobold);
		
		JButton btnMonOgre = new JButton("");
		btnMonOgre.setIcon(resizeIcon(new ImageIcon(EditSelect.class.getResource("/res/MonOgre.png"))));
		GridBagConstraints gbc_btnMonOgre = new GridBagConstraints();
		gbc_btnMonOgre.insets = new Insets(0, 0, 5, 5);
		gbc_btnMonOgre.gridx = 0;
		gbc_btnMonOgre.gridy = 2;
		pnlEntities.add(btnMonOgre, gbc_btnMonOgre);
		
		JButton btnMonShrub = new JButton("");
		btnMonShrub.setIcon(resizeIcon(new ImageIcon(EditSelect.class.getResource("/res/MonShrub.png"))));
		GridBagConstraints gbc_btnMonShrub = new GridBagConstraints();
		gbc_btnMonShrub.insets = new Insets(0, 0, 5, 5);
		gbc_btnMonShrub.gridx = 1;
		gbc_btnMonShrub.gridy = 2;
		pnlEntities.add(btnMonShrub, gbc_btnMonShrub);
		
		JButton btnMonSkeleton = new JButton("");
		btnMonSkeleton.setIcon(resizeIcon(new ImageIcon(EditSelect.class.getResource("/res/MonSkeleton.png"))));
		GridBagConstraints gbc_btnMonSkeleton = new GridBagConstraints();
		gbc_btnMonSkeleton.insets = new Insets(0, 0, 5, 5);
		gbc_btnMonSkeleton.gridx = 2;
		gbc_btnMonSkeleton.gridy = 2;
		pnlEntities.add(btnMonSkeleton, gbc_btnMonSkeleton);
		
		JButton btnMonTree = new JButton("");
		btnMonTree.setIcon(resizeIcon(new ImageIcon(EditSelect.class.getResource("/res/MonTree.png"))));
		GridBagConstraints gbc_btnMonTree = new GridBagConstraints();
		gbc_btnMonTree.insets = new Insets(0, 0, 5, 5);
		gbc_btnMonTree.gridx = 3;
		gbc_btnMonTree.gridy = 2;
		pnlEntities.add(btnMonTree, gbc_btnMonTree);
		
		JButton btnMonWarHorse = new JButton("");
		btnMonWarHorse.setIcon(resizeIcon(new ImageIcon(EditSelect.class.getResource("/res/MonWarHorse.png"))));
		GridBagConstraints gbc_btnMonWarHorse = new GridBagConstraints();
		gbc_btnMonWarHorse.insets = new Insets(0, 0, 5, 0);
		gbc_btnMonWarHorse.gridx = 4;
		gbc_btnMonWarHorse.gridy = 2;
		pnlEntities.add(btnMonWarHorse, gbc_btnMonWarHorse);
		
		JButton btnRemove = new JButton("");
		btnRemove.setIcon(resizeIcon(new ImageIcon(EditSelect.class.getResource("/res/Remove.png"))));
		GridBagConstraints gbc_btnRemove = new GridBagConstraints();
		gbc_btnRemove.insets = new Insets(0, 0, 0, 5);
		gbc_btnRemove.gridx = 0;
		gbc_btnRemove.gridy = 3;
		pnlEntities.add(btnRemove, gbc_btnRemove);
		
		JPanel pnlSave = new JPanel();
		tabbedPane.addTab("Save", null, pnlSave, null);
		GridBagLayout gbl_pnlSave = new GridBagLayout();
		gbl_pnlSave.columnWidths = new int[]{0, 0, 162, 0};
		gbl_pnlSave.rowHeights = new int[]{0, 0, 0, 0};
		gbl_pnlSave.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlSave.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlSave.setLayout(gbl_pnlSave);
		
		JLabel lblFileName = new JLabel("File Name:");
		GridBagConstraints gbc_lblFileName = new GridBagConstraints();
		gbc_lblFileName.anchor = GridBagConstraints.EAST;
		gbc_lblFileName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFileName.gridx = 1;
		gbc_lblFileName.gridy = 0;
		pnlSave.add(lblFileName, gbc_lblFileName);
		
		txtFile = new JTextField();
		GridBagConstraints gbc_txtFile = new GridBagConstraints();
		gbc_txtFile.anchor = GridBagConstraints.WEST;
		gbc_txtFile.insets = new Insets(0, 0, 5, 0);
		gbc_txtFile.gridx = 2;
		gbc_txtFile.gridy = 0;
		pnlSave.add(txtFile, gbc_txtFile);
		txtFile.setColumns(15);
		
		JButton btnSave = new JButton("Save");
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 0, 5, 5);
		gbc_btnSave.gridx = 1;
		gbc_btnSave.gridy = 1;
		pnlSave.add(btnSave, gbc_btnSave);
		
		btnSave.addActionListener(new ActionListener() { 
	          public void actionPerformed(ActionEvent e) {
	        	  saveSimulation(txtFile.getText());
	          }
	        }); 
		
		
		btnWallWest.addActionListener(new ActionListener() { 
	          public void actionPerformed(ActionEvent e) {
	        	  editing = 0;
	        	  edit.ChangeTile(8);
	          }
	        }); 
		
		btnFloor.addActionListener(new ActionListener() { 
	          public void actionPerformed(ActionEvent e) {
	        	  editing = 0;
	        	  edit.ChangeTile(0);
	          }
	        }); 
		
		btnWallSouth.addActionListener(new ActionListener() { 
	          public void actionPerformed(ActionEvent e) {
	        	  editing = 0;
	        	  edit.ChangeTile(6);
	          }
	        }); 
		
		btnWallEast.addActionListener(new ActionListener() { 
	          public void actionPerformed(ActionEvent e) {
	        	  editing = 0;
	        	  edit.ChangeTile(7);
	          }
	        }); 
		
		btnWallNorth.addActionListener(new ActionListener() { 
	          public void actionPerformed(ActionEvent e) {
	        	  editing = 0;
	        	  edit.ChangeTile(5);
	          }
	        }); 
		
		btnCornerSouthWest.addActionListener(new ActionListener() { 
	          public void actionPerformed(ActionEvent e) {
	        	  editing = 0;
	        	  edit.ChangeTile(3);
	          }
	        }); 
		
		btnCornerSouthEast.addActionListener(new ActionListener() { 
	          public void actionPerformed(ActionEvent e) {
	        	  editing = 0;
	        	  edit.ChangeTile(4);
	          }
	        }); 
		
		btnCornerNorthWest.addActionListener(new ActionListener() { 
	          public void actionPerformed(ActionEvent e) {
	        	  editing = 0;
	        	  edit.ChangeTile(1);
	          }
	        }); 
		
		btnCornerNorthEast.addActionListener(new ActionListener() { 
	          public void actionPerformed(ActionEvent e) {
	        	  editing = 0;
	        	  edit.ChangeTile(2);
	          }
	        }); 
		
		btnHallNorthSouth.addActionListener(new ActionListener() { 
	          public void actionPerformed(ActionEvent e) {
	        	  editing = 0;
	        	  edit.ChangeTile(10);
	          }
	        }); 
		
		btnHallEastWest.addActionListener(new ActionListener() { 
	          public void actionPerformed(ActionEvent e) {
	        	  editing = 0;
	        	  edit.ChangeTile(9);
	          }
	        }); 
		
		btnCharCleric.addActionListener(new ActionListener() { 
	          public void actionPerformed(ActionEvent e) {
	        	  editing = 1;
	        	  curType = EntityType.CharCleric;
	          }
	        }); 
		
		btnCharFighter.addActionListener(new ActionListener() { 
	          public void actionPerformed(ActionEvent e) {
	        	  editing = 1;
	        	  curType = EntityType.CharFighter;
	          }
	        }); 
		
		btnCharRanger.addActionListener(new ActionListener() { 
	          public void actionPerformed(ActionEvent e) {
	        	  editing = 1;
	        	  curType = EntityType.CharRanger;
	          }
	        }); 
		
		btnCharRogue.addActionListener(new ActionListener() { 
	          public void actionPerformed(ActionEvent e) {
	        	  editing = 1;
	        	  curType = EntityType.CharRogue;
	          }
	        }); 
		
		btnCharWizard.addActionListener(new ActionListener() { 
	          public void actionPerformed(ActionEvent e) {
	        	  editing = 1;
	        	  curType = EntityType.CharWizard;
	          }
	        }); 
		
		btnMonBeetle.addActionListener(new ActionListener() { 
	          public void actionPerformed(ActionEvent e) {
	        	  editing = 2;
	        	  curType = EntityType.MonBeetle;
	          }
	        }); 
		
		btnMonGoblin.addActionListener(new ActionListener() { 
	          public void actionPerformed(ActionEvent e) {
	        	  editing = 2;
	        	  curType = EntityType.MonGoblin;
	          }
	        });
		
		btnMonHalfOgre.addActionListener(new ActionListener() { 
	          public void actionPerformed(ActionEvent e) {
	        	  editing = 2;
	        	  curType = EntityType.MonHalfOgre;
	          }
	        });
		
		btnMonHobgoblin.addActionListener(new ActionListener() { 
	          public void actionPerformed(ActionEvent e) {
	        	  editing = 2;
	        	  curType = EntityType.MonHobgoblin;
	          }
	        });
		
		btnMonKobold.addActionListener(new ActionListener() { 
	          public void actionPerformed(ActionEvent e) {
	        	  editing = 2;
	        	  curType = EntityType.MonKobold;
	          }
	        });
		
		btnMonOgre.addActionListener(new ActionListener() { 
	          public void actionPerformed(ActionEvent e) {
	        	  editing = 2;
	        	  curType = EntityType.MonOgre;
	          }
	        });
		
		btnMonShrub.addActionListener(new ActionListener() { 
	          public void actionPerformed(ActionEvent e) {
	        	  editing = 2;
	        	  curType = EntityType.MonShrub;
	          }
	        });
		
		btnMonSkeleton.addActionListener(new ActionListener() { 
	          public void actionPerformed(ActionEvent e) {
	        	  editing = 2;
	        	  curType = EntityType.MonSkeleton;
	          }
	        });
		
		btnMonTree.addActionListener(new ActionListener() { 
	          public void actionPerformed(ActionEvent e) {
	        	  editing = 2;
	        	  curType = EntityType.MonTree;
	          }
	        });
		
		btnMonWarHorse.addActionListener(new ActionListener() { 
	          public void actionPerformed(ActionEvent e) {
	        	  editing = 2;
	        	  curType = EntityType.MonWarHorse;
	          }
	        });
		
		btnRemove.addActionListener(new ActionListener() { 
	          public void actionPerformed(ActionEvent e) {
	        	  editing = 3;
	          }
	        });
	}
	
	public void setEdit(Editor edit) {
		this.edit = edit;
	}
	
	private static Icon resizeIcon(ImageIcon icon) {
	    Image img = icon.getImage();  
	    Image resizedImage = img.getScaledInstance(64, 64,  java.awt.Image.SCALE_SMOOTH);  
	    return new ImageIcon(resizedImage);
	}

}
