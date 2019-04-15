package guitest;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.SpringLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gui {

	private JFrame frame;
	private JTextField txtPathOfPdf;
	private JTextField txtExJavaPython;
	private JTextField txtResultShowsHere;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Select ");
		btnNewButton.setBounds(307, 61, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		txtPathOfPdf = new JTextField();
		txtPathOfPdf.setText("Path of PDF Resume Location");
		txtPathOfPdf.setBounds(68, 94, 213, 26);
		frame.getContentPane().add(txtPathOfPdf);
		txtPathOfPdf.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Searching Engine");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(161, 12, 140, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Step 1: Find your PDF Resume");
		lblNewLabel_1.setBounds(41, 66, 197, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Step 2: Information to find");
		lblNewLabel_2.setBounds(41, 130, 203, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Step 3: Display the searching result");
		lblNewLabel_3.setBounds(41, 201, 240, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnClick = new JButton("Click");
		btnClick.setBounds(307, 125, 117, 29);
		frame.getContentPane().add(btnClick);
		
		JButton btnNewButton_1 = new JButton("Display");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(307, 196, 117, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		txtExJavaPython = new JTextField();
		txtExJavaPython.setText("Ex: Java, Python, C++");
		txtExJavaPython.setBounds(68, 163, 213, 26);
		frame.getContentPane().add(txtExJavaPython);
		txtExJavaPython.setColumns(10);
		
		txtResultShowsHere = new JTextField();
		txtResultShowsHere.setText("Result shows here");
		txtResultShowsHere.setBounds(68, 229, 213, 26);
		frame.getContentPane().add(txtResultShowsHere);
		txtResultShowsHere.setColumns(10);
	}
}
