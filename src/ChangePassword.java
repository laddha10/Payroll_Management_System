import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class ChangePassword extends JFrame {

	private JPanel contentPane;
	private JTextField textField_3;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePassword frame = new ChangePassword();
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
	public ChangePassword() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblEnterYourCurrent = new JLabel("Enter your current Password");
		
		JLabel lblEnterYourNew = new JLabel("Enter your new Password");
		JLabel lblEnterYourUsername = new JLabel("Enter your UserName");
		passwordField = new JPasswordField();
		
		passwordField_1 = new JPasswordField();
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
					int flag=0;
					String s1=textField_3.getText();
					char[] c=passwordField.getPassword();
					String s2=String.valueOf(c);
					//String s3=textField_2.getText();
					//char[] c1=passwordField.getPassword();
					//String s3=String.valueOf(c1);
					//if (s3==s4)
					//{
						Connection con=DBInfo.getConn();
						String query="select * from login where username=? and password=?";
						try
						{
							PreparedStatement ps=con.prepareStatement(query);
							ps.setString(1, s1);
							ps.setString(2, s2);
							ResultSet rs= ps.executeQuery();
							while (rs.next())
							{
								flag=1;
							}	
						}
						catch (Exception e1)
						{
							e1.printStackTrace();
						}
						if (flag==1)
						{
							int flag1=0;
							//String s3=textField_3.getText();
							char[] c2=passwordField_1.getPassword();
							String s5=String.valueOf(c2);
							//String s3= textField_1.getText();
							//String s4=textField_2.getText();
							Connection con1 = DBInfo.getConn();
							String query1="update login set password=? where username = ?";
							try
							{
								PreparedStatement ps1= con1.prepareStatement(query1);
								ps1.setString(1, s5);
								ps1.setString(2, s1);
								flag1=ps1.executeUpdate();
							}
							catch (Exception e2)
							{
								e2.printStackTrace();
							}
							if (flag1==0)
							{
								JOptionPane.showMessageDialog(getParent(), "Password not updated","Error", JOptionPane.ERROR_MESSAGE);
							}
							if (flag1==1)
							{
								JOptionPane.showMessageDialog(getParent(), "Password Updated","Success", JOptionPane.INFORMATION_MESSAGE);
								passwordField.setText(null);
								passwordField_1.setText(null);
								//textField_2.setText(null);
								textField_3.setText(null);
								dispose();
							}
								
						}
						if (flag==0)
						{
							JOptionPane.showMessageDialog(getParent(),"Wrong username or password!","Error", JOptionPane.ERROR_MESSAGE);
						}
					/*}
					else
					{
						JOptionPane.showMessageDialog(getParent(), "Both fields do not match","Error", JOptionPane.ERROR_MESSAGE);
					}*/
			}
		});
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				passwordField.setText(null);
				passwordField_1.setText(null);
				//textField_2.setText(null);
				textField_3.setText(null);
			}
		});
		
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEnterYourUsername)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEnterYourCurrent)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(btnUpdate)
									.addComponent(lblEnterYourNew)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(40)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(textField_3)
										.addComponent(passwordField)
										.addComponent(passwordField_1)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(63)
									.addComponent(btnReset)))))
					.addContainerGap(46, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterYourUsername)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterYourCurrent)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterYourNew)
						.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnUpdate)
						.addComponent(btnReset))
					.addGap(49))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
