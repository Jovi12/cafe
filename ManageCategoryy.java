import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
//import net.proteanit.sql.DbUtils;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ManageCategoryy extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtAddnew;
	private JButton btnsave;
	private String[] col;
	protected AbstractButton tblData;
	private JTextField searchtxtfield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageCategoryy frame = new ManageCategoryy();
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
	public ManageCategoryy() {
		String col1[][]={{"ID","Category"}};
		 String col[]= {"",""};
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 134, 700, 400);
		contentPane =  new JPanel();
		contentPane.setBackground(Color.CYAN);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("Manage Category");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(22, 10, 142, 21);
		contentPane.add(lblNewLabel);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null, "Do you want really want to Close Application","Select",JOptionPane.YES_NO_OPTION);
				if(a==0) {
					System.exit(0);
				}
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnClose.setBounds(591, 10, 85, 21);
		contentPane.add(btnClose);
		
		JLabel lblViewCategory = new JLabel("View Category");
		lblViewCategory.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblViewCategory.setBounds(453, 24, 142, 21);
		contentPane.add(lblViewCategory);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				try {
				int index=table.getSelectedRow();
				TableModel model=table.getModel();
				String id=model.getValueAt(index, 0).toString();
				String name=model.getValueAt(index,1).toString();
				Class.forName("com.mysql.jdbc.Driver");
				Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3307/signup","root","");
				@SuppressWarnings("deprecation")
				PreparedStatement ps=con.prepareStatement("delete from Categorytable where id=?");
				ps.setString(1,id);
				ps.executeUpdate();
				JOptionPane.showConfirmDialog(null,"Do you want really want to Delete "+name+"Category","Select",JOptionPane.YES_NO_OPTION);
				}catch(Exception i) {
					
				}
			}
		});
		scrollPane.setBounds(416, 58, 254, 228);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBackground(Color.WHITE);
		table.setForeground(Color.BLACK);
		
		
		JButton btnlupdate = new JButton("Update");
		btnlupdate.setBounds(416, 311, 89, 23);
		btnlupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnlupdate.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(btnlupdate);
		
		JButton btnldelete = new JButton("Delete");
		btnldelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=txtAddnew.getText();
				
				try {
					
			
					String id= searchtxtfield.getText();
					Class.forName("com.mysql.jdbc.Driver");
				Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3307/signup","root","");
				@SuppressWarnings("deprecation")
				PreparedStatement ps=con.prepareStatement("delete from Categorytable where id=?");
				ps.setString(1,id);
				ps.executeUpdate();
				
				JOptionPane.showConfirmDialog(null,"Do you want really want to Delete "+name+"Category","Select",JOptionPane.YES_NO_OPTION);
				txtAddnew.setText("");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
				System.out.println(e1);
				}
				
				
			}
		});
		btnldelete.setBounds(550, 311, 89, 23);
		btnldelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(btnldelete);
		
		
		JLabel lblAddCategory = new JLabel("Add New Category");
		lblAddCategory.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAddCategory.setBounds(131, 92, 142, 21);
		contentPane.add(lblAddCategory);
		
		txtAddnew = new JTextField();
		txtAddnew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				}
		});
		txtAddnew.setBounds(64, 157, 254, 19);
		contentPane.add(txtAddnew);
		txtAddnew.setColumns(10);
		
		JButton btnsave = new JButton("Save");
		btnsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
				
					String name=txtAddnew.getText();
					Class.forName("com.mysql.jdbc.Driver");
				Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3307/signup","root","");
				@SuppressWarnings("deprecation")
				PreparedStatement ps=con.prepareStatement("insert into Categorytable (name)values(?)",Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, name);
				ps.executeUpdate();
				ResultSet tableKeys = ps.getGeneratedKeys();
				tableKeys.next();
				int autoGeneratedID = tableKeys.getInt(1);
				
				
				
				//ps.executeUpdate();
				
				JOptionPane.showMessageDialog(null,"Category Table Updated Successfully.");
				txtAddnew.setText("");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
				System.out.println(e1);
				}
				try {
					Class.forName("com.mysql.jdbc.Driver");
				Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3307/signup","root","");
				PreparedStatement ps=con.prepareStatement("Select * From categorytable ");
					
					ResultSet rs=ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch(ClassNotFoundException w) {
					System.out.println(w);
					
					
				}catch(SQLException ex) {
					
				}
			}
		});
		btnsave.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnsave.setBounds(64, 208, 85, 21);
		contentPane.add(btnsave);
		if(txtAddnew.getText().length()>0) {
			btnsave.setEnabled(true);
		}else {
			//btnsave.setEnabled(false);
		}
		
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtAddnew.setText(null);
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnClear.setBounds(209, 209, 85, 21);
		contentPane.add(btnClear);
		
		JPanel panel = new JPanel();
		panel.setBounds(41, 266, 307, 68);
		panel.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblname = new JLabel("Category ID");
		lblname.setBounds(10, 24, 100, 21);
		panel.add(lblname);
		lblname.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		searchtxtfield = new JTextField();
		searchtxtfield.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					String id = searchtxtfield.getText();
					Class.forName("com.mysql.jdbc.Driver");
					
				Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3307/signup","root","");
				PreparedStatement ps=con.prepareStatement("Select name from categorytable where id= ? ");
				ps.setString(1, id);
						ResultSet rs=ps.executeQuery();
						if(rs.next()==true) {
							String name=rs.getString(1);
							
							txtAddnew.setText(name);
						}else {
							txtAddnew.setText("");
						}
						
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(ClassNotFoundException w) {
					System.out.println(w);
					
					
				}catch(SQLException ex) {
					
				}
				
			}
		});
		searchtxtfield.setBounds(128, 24, 169, 20);
		panel.add(searchtxtfield);
		searchtxtfield.setColumns(10);
		
		
	
	}
}
