import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try 
				{
					Login frame = new Login();
					frame.setVisible(true);
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblEnterUsername = new JLabel("Enter Username");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblEnterPassword = new JLabel("Enter Password");
		passwordField = new JPasswordField();
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				if (e.getSource()==btnLogin)
				{
					int flag=0;
					String s1=textField.getText();
					char[] c=passwordField.getPassword();
					String s2=String.valueOf(c);
					String usertype="";
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
							usertype=rs.getString(3);
							
						}	
					}
					catch (Exception e1)
					{
						e1.printStackTrace();
					}
					if (flag==1)
					{
						if (usertype.equalsIgnoreCase("Admin"))
						{
							AdminPage obj= new AdminPage();
							obj.setVisible(true);
							dispose();
							//System.out.println("admin called");
						}
						if (usertype.equalsIgnoreCase("faculty"))
						{
							FacultySection obj = new FacultySection();
							obj.setVisible(true);
							dispose();
							//System.out.println ("faculty called");
						}
					}
						if (flag==0)
						{
							JOptionPane.showMessageDialog(getParent(),"Wrong username or password!","Error", JOptionPane.ERROR_MESSAGE);
						}
					}
					
				}
				
			
			
		});
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if (e.getSource()==btnReset)
				{
					textField.setText(null);
					passwordField.setText(null);
				}
			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(77)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEnterUsername)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addComponent(btnLogin)
							.addComponent(lblEnterPassword)))
					.addGap(45)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(passwordField)
						.addComponent(btnReset)
						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
					.addContainerGap(67, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(51)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterUsername)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLogin)
						.addComponent(btnReset))
					.addContainerGap(79, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
