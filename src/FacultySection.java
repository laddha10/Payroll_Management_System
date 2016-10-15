import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FacultySection extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FacultySection frame = new FacultySection();
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
	public FacultySection() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 2, 0, 0));
		
		JButton btnNewButton = new JButton("Employee Details");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				SearchEmp obj = new SearchEmp();
				obj.setVisible(true);
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnEmployeeDetails = new JButton("Payroll");
		btnEmployeeDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				EmpSalary obj = new EmpSalary();
				obj.setVisible(true);
			}
		});
		contentPane.add(btnEmployeeDetails);
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				ChangePassword obj = new ChangePassword();
				obj.setVisible(true);
			}
		});
		contentPane.add(btnChangePassword);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
			}
		});
		contentPane.add(btnLogOut);
	}

}
