package com.memory.java;

import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class Main {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main Board = new Main();
					Board.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[][grow]", "[][][][][]"));
		
		JLabel lblHauteur = new JLabel("Hauteur");
		frame.getContentPane().add(lblHauteur, "cell 0 1,alignx trailing");
		
		textField = new JTextField();
		textField.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt1) {
				// CHANGE VALEUR H
			}
		});
		textField.setText("5");
		frame.getContentPane().add(textField, "cell 1 1,growx");
		textField.setColumns(2);
		
		JLabel lblLargeur = new JLabel("Largeur");
		frame.getContentPane().add(lblLargeur, "cell 0 2,alignx trailing");
		
		textField_1 = new JTextField();
		textField_1.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt2) {
				//CHANGE VALEUR W
			}
		});
		textField_1.setText("5");
		frame.getContentPane().add(textField_1, "cell 1 2,growx");
		textField_1.setColumns(2);
		
		JButton btnValider = new JButton("Valider");
		frame.getContentPane().add(btnValider, "cell 0 4");
	}

}
