import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					principal frame = new principal();
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
	public principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(82, 110, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(82, 38, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("text");
		lblNewLabel.setBounds(28, 41, 44, 12);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("lien");
		lblNewLabel_1.setBounds(28, 97, 84, 44);
		contentPane.add(lblNewLabel_1);
		
		
        
        JButton validerButton = new JButton("Valider");
        validerButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        validerButton.setBounds(226, 78, 84, 20);
        contentPane.add(validerButton);

        validerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String texte = textField.getText();
                String lien = textField_1.getText();
                JOptionPane.showMessageDialog(principal.this,
                        "Texte: " + texte + "\nLien: " + lien,
                        "Informations saisies",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
		

	}

