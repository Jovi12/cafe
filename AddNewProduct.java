import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;

public class AddNewProduct {

	private JFrame frame;
	private JTextField txtname;
	private JTextField txtprice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewProduct window = new AddNewProduct();
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
	public AddNewProduct() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 800,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblname = new JLabel("Name");
		lblname.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblname.setBounds(189, 121, 97, 14);
		frame.getContentPane().add(lblname);
		
		JLabel lblcategory = new JLabel("Category");
		lblcategory.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblcategory.setBounds(189, 169, 97, 34);
		frame.getContentPane().add(lblcategory);
		
		JLabel lblNewLabel = new JLabel("Price");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(196, 240, 76, 14);
		frame.getContentPane().add(lblNewLabel);
		
		txtname = new JTextField();
		txtname.setBounds(282, 121, 367, 20);
		frame.getContentPane().add(txtname);
		txtname.setColumns(10);
		
		txtprice = new JTextField();
		txtprice.setBounds(282, 240, 375, 20);
		frame.getContentPane().add(txtprice);
		txtprice.setColumns(10);
		
		JButton btnlsave = new JButton("SAVE");
		btnlsave.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnlsave.setForeground(new Color(0, 0, 0));
		btnlsave.setBounds(282, 324, 97, 23);
		frame.getContentPane().add(btnlsave);
		
		JButton btnNewButton = new JButton("CLEAR");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(578, 324, 97, 23);
		frame.getContentPane().add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(282, 178, 367, 20);
		frame.getContentPane().add(comboBox);
		
		JButton btnlclose = new JButton("Close");
		btnlclose.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnlclose.setBounds(685, 11, 89, 23);
		frame.getContentPane().add(btnlclose);
		
		JLabel lblNewLabel_1 = new JLabel("New Product");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(24, 16, 97, 14);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
