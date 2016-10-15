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
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class Salary extends JFrame {

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
					Salary frame = new Salary();
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
	public Salary() {
		dispose();
		setBounds(100, 100, 574, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblEmpId = new JLabel("Emp ID");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblPost = new JLabel("Post");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblMonth = new JLabel("Month");
		
		JComboBox comboBox = new JComboBox<String>(GetValues.getMonth());
		comboBox.setSelectedIndex(0);
		
		
		JLabel lblLeave = new JLabel("Leave");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblBasicSalary = new JLabel("Basic Salary");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("HR");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setEditable(false);
		
		JLabel lblTada = new JLabel("TA/DA");
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setEditable(false);
		
		JLabel lblPf = new JLabel("PF");
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setEditable(false);
		
		JLabel lblTaxationRate = new JLabel("Taxation Rate");
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		
		JLabel lblTaxes = new JLabel("Taxes");
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setEditable(false);
		
		JLabel lblGrossSalary = new JLabel("Gross Salary");
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setEditable(false);
		
		JButton btnPayTheSalary = new JButton("Pay the salary");
		btnPayTheSalary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String s1=textField.getText();
				String s2=textField_1.getText();
				String s3=(String)comboBox.getSelectedItem();
				String s4=textField_2.getText();
				String s5=textField_3.getText();
				String s6=textField_4.getText();
				String s7=textField_5.getText();
				String s8=textField_6.getText();
				String s9=textField_7.getText();
				String s10=textField_8.getText();
				String s11=textField_9.getText();
				
				Connection con=DBInfo.getConn();
				String str="insert into payroll values (?,?,?,?,?,?,?,?,?,?,?)";
				int flag=0;
				try
				{
					PreparedStatement ps=con.prepareStatement(str);
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
					flag=ps.executeUpdate();
					
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
				if (flag==0)
				{
					JOptionPane.showMessageDialog(getParent(), "Salary not paid","Error!", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(getParent(), "Salary Paid","Success!", JOptionPane.INFORMATION_MESSAGE);
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
				}
			}
		});
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
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
			}
		});
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				double basic, hr,ta,pf,tax, rate, gross, leave,total = 0;
				basic=Double.parseDouble(textField_3.getText());
				hr = basic * (.25);
				textField_4.setText(Double.toString(hr));
				ta= basic * (.15);
				textField_5.setText(Double.toString(ta));
				pf = basic * (.10);
				textField_6.setText(Double.toString(pf));
				rate= Double.parseDouble(textField_7.getText());
				tax=basic * (rate/100);
				textField_8.setText(Double.toString(tax));	
				leave=Double.parseDouble(textField_2.getText());
				gross = basic + hr+ ta-pf-tax;
				if (leave<=3)
				{
					total=gross;
				}
				else
				{
					total=gross-(gross/(30-(leave+3)));
				}
				
				textField_9.setText(Double.toString(total));	
				String month;
				month=(String) comboBox.getSelectedItem();
				
				//if (month.equalsIgnoreCase())
				
				
					
						
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(94)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEmpId)
						.addComponent(lblPost)
						.addComponent(lblMonth)
						.addComponent(lblLeave)
						.addComponent(lblBasicSalary)
						.addComponent(lblNewLabel)
						.addComponent(lblTada)
						.addComponent(lblPf)
						.addComponent(lblTaxationRate)
						.addComponent(lblTaxes)
						.addComponent(btnCalculate)
						.addComponent(lblGrossSalary))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(38)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField_9)
								.addComponent(textField_8)
								.addComponent(textField_7)
								.addComponent(textField_6)
								.addComponent(textField_5)
								.addComponent(textField_4)
								.addComponent(textField_3)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
								.addComponent(textField_2)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(71)
							.addComponent(btnPayTheSalary)
							.addGap(68)
							.addComponent(btnReset)))
					.addContainerGap(74, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmpId))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPost)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMonth)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLeave)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBasicSalary)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTada)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPf)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTaxationRate)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTaxes)
						.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGrossSalary))
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCalculate)
						.addComponent(btnPayTheSalary)
						.addComponent(btnReset))
					.addGap(24))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
