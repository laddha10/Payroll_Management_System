import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ComboBoxEditor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SearchUpdateDelete extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchUpdateDelete frame = new SearchUpdateDelete();
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
	public SearchUpdateDelete() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setBounds(100, 100, 642, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblEmployeeId = new JLabel("Employee ID");
		
		textField = new JTextField();
		
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblContactNo = new JLabel("Contact No.");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JLabel lblQualification = new JLabel("Qualification");
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		JLabel lblDateOfJoining = new JLabel("Date of Joining");
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		
		JLabel lblDepartment = new JLabel("Department");
		
		JComboBox <String>comboBox = new JComboBox <String>();
		
		JLabel lblPost = new JLabel("Post");
		
		JComboBox <String> comboBox_1 = new JComboBox<String>();
		
		JLabel lblPassword = new JLabel("UserName");
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		JComboBox <String>comboBox_2 = new JComboBox<String>(GetValues.getDepartment());
		
		JComboBox <String>comboBox_3 = new JComboBox<String>(GetValues.getPost());
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) 
			{
				int flag=0;
				String s1=textField.getText();
				Connection con=DBInfo.getConn();
				String query="select * from employee where EmpID=?";
				try
				{
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, s1);
					ResultSet res=ps.executeQuery();
					//flag=ps.executeUpdate();
					while (res.next())
					{
						textField_1.setText(res.getString(2));
						textField_2.setText(res.getString(3));
						textField_3.setText(res.getString(4));
						textField_4.setText(res.getString(5));
						textField_5.setText(res.getString(6));
						textField_6.setText(res.getString(7));
						textField_7.setText(res.getString(8));
						textField_8.setText(res.getString(11));
						textField_9.setText(res.getString(12));
						comboBox.addItem(res.getString("Department"));
						//comboBox.getSelectedItem();
						 comboBox_1.addItem(res.getString("Post"));
		                // comboBox_1.getSelectedItem();
						//comboBox.getSelectedItem(res.getString(9));
						//comboBox_1.getSelectedItem(res.getString(10));
						
					}
					
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
				/*if (flag==0)
				{
					JOptionPane.showMessageDialog(getParent(), "Employee Not Found","Error!",JOptionPane.ERROR_MESSAGE);
				}*/
				
					
						
			}
		});
		JButton btnSearch = new JButton("Search");
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int flag=0;
				String s12=textField.getText();
				String s1=textField_1.getText();
				String s2=textField_2.getText();
				String s3=textField_3.getText();
				String s4=textField_4.getText();
				String s5=textField_5.getText();
				String s6=textField_6.getText();
				String s7=textField_7.getText();
				String s10=textField_8.getText();
				String s11=textField_9.getText();
				String s8=(String)comboBox_2.getSelectedItem();
				String s9=(String)comboBox_3.getSelectedItem();
				
				Connection con=DBInfo.getConn();
				String query="update employee set Name=?, Contact=?, EmailID=?, Address=?, Qualification=?, DOB=?, DOJ=?, Department=?, Post=?, UserName=?, Password=? where EmpID=?";
				try
				{
					PreparedStatement ps=con.prepareStatement(query);
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
					
					flag=ps.executeUpdate();
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
				
				if (flag==0)
				{
					JOptionPane.showMessageDialog(getParent(), "Profile not updated","Error",JOptionPane.ERROR_MESSAGE);
				}
				if (flag==1)
				{
					JOptionPane.showMessageDialog(getParent(), "Profile Updated","Success",JOptionPane.INFORMATION_MESSAGE);
					textField.setText(null);
					textField_1.setText(null);
					textField_2.setText(null);
					textField_3.setText(null);
					textField_4.setText(null);
					textField_5.setText(null);
					textField_6.setText(null);
					textField_7.setText(null);
					textField_8.setText(null);
					textField_9.setText(null);
					comboBox.setSelectedIndex(0);
					comboBox_1.setSelectedIndex(0);
					comboBox_2.setSelectedIndex(0);
					comboBox_3.setSelectedIndex(0);
					
					
					
				}
			}
		});
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int flag=0;
				String s1=textField.getText();
				Connection con=DBInfo.getConn();
				String query="delete from Employee where EmpID=?";
				try
				{
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, s1);
					flag=ps.executeUpdate();
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
				if (flag==0)
				{
					JOptionPane.showMessageDialog(getParent(), "Employee Not Deleted","Error!",JOptionPane.ERROR_MESSAGE);
				}
				if (flag==1)
				{
					JOptionPane.showMessageDialog(getParent(), "Employee deleted","Success!",JOptionPane.INFORMATION_MESSAGE);;
					textField.setText(null);
					textField_1.setText(null);
					textField_2.setText(null);
					textField_3.setText(null);
					textField_4.setText(null);
					textField_5.setText(null);
					textField_6.setText(null);
					textField_7.setText(null);
					textField_8.setText(null);
					textField_9.setText(null);
					comboBox.setSelectedIndex(0);
					comboBox_1.setSelectedIndex(0);
				}
			}
		});
		
		
		
		JLabel lblPassword_1 = new JLabel("Password");
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(68)
					.addComponent(btnSearch)
					.addGap(119)
					.addComponent(btnUpdate)
					.addGap(93)
					.addComponent(btnDelete)
					.addContainerGap(105, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(48)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEmployeeId)
						.addComponent(lblName)
						.addComponent(lblContactNo)
						.addComponent(lblEmail)
						.addComponent(lblAddress)
						.addComponent(lblQualification)
						.addComponent(lblDateOfBirth)
						.addComponent(lblDateOfJoining)
						.addComponent(lblDepartment)
						.addComponent(lblPost)
						.addComponent(lblPassword)
						.addComponent(lblPassword_1))
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_9, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
						.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
						.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
						.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
						.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
						.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
						.addComponent(textField_6, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
						.addComponent(textField_7, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
						.addComponent(textField_8, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(comboBox_1, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(comboBox, Alignment.LEADING, 0, 164, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE))
					.addGap(47))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmployeeId)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblContactNo)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddress)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblQualification)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDateOfBirth)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDateOfJoining)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDepartment)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPost)
								.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPassword)
								.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPassword_1)
						.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(23)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnUpdate)
						.addComponent(btnDelete)
						.addComponent(btnSearch))
					.addContainerGap(10, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
