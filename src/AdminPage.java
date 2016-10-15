import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage frame = new AdminPage();
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
	public AdminPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 2, 0, 0));
		
		JButton btnNewButton = new JButton("Add New Employee");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				AddNewEmployee obj= new AddNewEmployee();
				obj.setVisible(true);
				
				
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Search/Update/Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				SearchUpdateDelete obj=new SearchUpdateDelete();
				obj.setVisible(true);
			}
		});
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Payroll");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Salary obj=new Salary();
				obj.setVisible(true);
			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Search by");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				SearchBy obj=new SearchBy();
				obj.setVisible(true);
			}
		});
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_5 = new JButton("Logout");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
			}
		});
		contentPane.add(btnNewButton_5);
	}

}
