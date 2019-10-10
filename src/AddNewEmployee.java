import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.font.TextHitInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

public class AddNewEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_10;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try
				{
					AddNewEmployee frame = new AddNewEmployee();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	public String EmpId()
    {
    	 String id="";
         for(int i=0;i<3;i++)
         {
         id+=(int)(Math.random()*4)+1;
         //System.out.println(id);
         }
         return id;
    }
	/**
	 * Create the frame.
	 */
	public AddNewEmployee() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dispose();
		setBounds(100, 100, 522, 456);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAddItems = new JMenu("Add Items");
		menuBar.add(mnAddItems);
		
		JMenuItem mntmAddDepartment = new JMenuItem("Add Department");
		mntmAddDepartment.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (e.getSource()==mntmAddDepartment)
				{
					int flag=0;
					String str = JOptionPane.showInputDialog("Enter the name of Department");
					System.out.println(str);
					Connection con= DBInfo.getConn();
					try
					{
						String query="insert into department values (?)";
						PreparedStatement ps=con.prepareStatement(query);
						ps.setString(1, str.toUpperCase());
						flag=ps.executeUpdate();
					}
					catch (Exception e1)
					{
						e1.printStackTrace();
					}
					if (flag==1)
					{
						JOptionPane.showMessageDialog(getParent(), "Department added","Success!",JOptionPane.INFORMATION_MESSAGE);
						dispose();
						AddNewEmployee obj= new AddNewEmployee();
						obj.setVisible(true);
					}
					if (flag==0)
					{
						JOptionPane.showMessageDialog(getParent(), "Department not added", "Failed!", JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
		});
		mnAddItems.add(mntmAddDepartment);
		
		JSeparator separator = new JSeparator();
		mnAddItems.add(separator);
		
		JMenuItem mntmAddPost = new JMenuItem("Add Post");
		mntmAddPost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int flag=0;
				String str=JOptionPane.showInputDialog("Enter Post");
				System.out.println(str);
				Connection con=DBInfo.getConn();
				try
				{
					String query="insert into post values(?)";
					PreparedStatement ps= con.prepareStatement(query);
					ps.setString(1, str.toUpperCase());
					flag=ps.executeUpdate();
				}
				catch (Exception e3)
				{
					e3.printStackTrace();					
				}
				if (flag==1)
				{
					JOptionPane.showMessageDialog(getParent(), "Post added","Success!",JOptionPane.INFORMATION_MESSAGE);
					dispose();
					AddNewEmployee obj=new AddNewEmployee();
					obj.setVisible(true);	
				}
				if (flag==0)
				{
					JOptionPane.showMessageDialog(getParent(), "Post not added","Failure!",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		mnAddItems.add(mntmAddPost);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblEmployeeId = new JLabel("Employee Id");
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setText(EmpId());
		textField.setEditable(false);
		
		JLabel lblName = new JLabel("Name");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Contact No.");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("EmailID");
		
		textField_3 = new JTextField();
		textField_3.setText("");
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Address");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Qualification");
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		JLabel lblDateOfJoining = new JLabel("Date of Joining");
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		
		JLabel lblDepartment = new JLabel("Department");
		JComboBox <String> comboBox = new JComboBox<String>(GetValues.getDepartment());
		
		
		
		JLabel lblPost = new JLabel("Post");
		JComboBox  comboBox_1 = new JComboBox<String>(GetValues.getPost());
		
		JLabel lblPassword = new JLabel("Password");
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String s1=textField.getText();
				String s2=textField_1.getText();
				String s3=textField_2.getText();
				String s4=textField_3.getText();
				String s5=textField_4.getText();
				String s6=textField_5.getText();
				String s7=textField_6.getText();
				String s8=textField_7.getText();
				String s9=(String)comboBox.getSelectedItem();
				String s10=(String)comboBox_1.getSelectedItem();
				String s11=textField_10.getText();
				String s12=textField_8.getText();
				if (s2.length() == 0||s3.length()  == 0||s4.length() == 0||s5.length()== 0||s6.length() == 0||s7.length() == 0||s8.length() == 0||s11.length() == 0)
				{
					JOptionPane.showMessageDialog(getParent(), "Enter all the values","Error!",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
				Connection con= DBInfo.getConn();
				String str=" insert into employee values (?,?,?,?,?,?,?,?,?,?,?,?)";
				String str1="insert into login values (?,?,?)";
				int flag=0;
				try
				{
					PreparedStatement ps=con.prepareStatement(str);
					PreparedStatement ps1=con.prepareStatement(str1);
					ps.setString(1, s1);
					ps.setString(2, s2);
					ps.setString(3, s3);
					ps.setString(4, s4);
					ps.setString(5, s5);
					ps.setString(6, s6);
					ps.setString(7, s7);
					ps.setString(8, s8);
					ps.setString(9, s9);
					ps.setString(10, s10);
					ps.setString(11, s11);
					ps.setString(12, s12);
					flag = ps.executeUpdate();
					ps1.setString(1, s11);
					ps1.setString(2, s12);
					ps1.setString(3, "faculty");
					ps1.executeUpdate();
					
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
					e1.printStackTrace();
					e1.printStackTrace();
				}
				if (flag==0)
				{
					JOptionPane.showMessageDialog(getParent(), "Employee not added","Error", JOptionPane.ERROR_MESSAGE);
				}
				if (flag==1)
				{
					JOptionPane.showMessageDialog(getParent(), "Employee Added","Added",JOptionPane.INFORMATION_MESSAGE);
					textField.setText(EmpId());
					textField_1.setText(null);
					textField_2.setText(null);
					textField_3.setText(null);
					textField_4.setText(null);
					textField_5.setText(null);
					textField_6.setText(null);
					textField_7.setText(null);
					textField_10.setText(null);
					textField_8.setText(null);
					comboBox.setSelectedIndex(0); //how to get the select as the value
					comboBox_1.setSelectedIndex(0); // how to put the error 
				}
				}
		}});
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				textField.setText(EmpId());
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				textField_5.setText(null);
				textField_6.setText(null);
				textField_7.setText(null);
				textField_10.setText(null);
				textField_8.setText(null);
				comboBox.setSelectedIndex(0);
				comboBox_1.setSelectedIndex(0);
			}
		});
		
		JLabel lblUsername = new JLabel("Username");
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(65)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEmployeeId)
						.addComponent(lblName)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_3)
						.addComponent(lblDateOfBirth)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDepartment)
								.addComponent(lblDateOfJoining)
								.addComponent(lblPost)
								.addComponent(lblUsername)
								.addComponent(lblPassword))))
					.addGap(49)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_8, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
						.addComponent(textField_1, 221, 221, Short.MAX_VALUE)
						.addComponent(textField_2, 221, 221, Short.MAX_VALUE)
						.addComponent(textField_3, 221, 221, Short.MAX_VALUE)
						.addComponent(textField_4, 221, 221, Short.MAX_VALUE)
						.addComponent(textField_5, 221, 221, Short.MAX_VALUE)
						.addComponent(textField_6, 221, 221, Short.MAX_VALUE)
						.addComponent(textField_7, 221, 221, Short.MAX_VALUE)
						.addComponent(textField_10, 221, 221, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(comboBox_1, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(comboBox, Alignment.LEADING, 0, 108, Short.MAX_VALUE)))
					.addGap(89))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(108)
					.addComponent(btnSave)
					.addPreferredGap(ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
					.addComponent(btnReset)
					.addGap(105))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmployeeId))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDateOfBirth)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDateOfJoining)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDepartment)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPost)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsername))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSave)
						.addComponent(btnReset))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
