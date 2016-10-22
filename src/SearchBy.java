import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.JobAttributes;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.metal.MetalBorders.TextFieldBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class SearchBy extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchBy frame = new SearchBy();
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
	public SearchBy() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JComboBox <String>comboBox = new JComboBox<>(GetValues.getSearch());
		
		
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblSearchBy = new JLabel("Search by");
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent arg0)
			{
				
				String s=(String)comboBox.getSelectedItem();
				String s10=textField.getText();
				if (s10.length()==0)
				{
					JOptionPane.showMessageDialog(getParent(), "Enter any value","Error", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
				if(s.equalsIgnoreCase("Name"))
				{ 
					String s1=textField.getText();
					if(s1.length()!=0)
					{
				try{
					
					
					
				
					Vector<String> header=new Vector<>();
					Vector<Vector<String>> records =new Vector<>();
					Connection con=DBInfo.getConn();
					String query="Select * from employee where Name=?";
					
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, s1);
					ResultSet res=ps.executeQuery();
					
					ResultSetMetaData rsmd=res.getMetaData();
					
					int count=rsmd.getColumnCount();
					
					for(int i=1;i<=count;i++)
					{
						header.add(rsmd.getColumnName(i).toUpperCase());
					}
					
					
					while(res.next())
					{   
						Vector<String> inner=new Vector<>();
						for(int i=1;i<=count;i++)
						{
							inner.add(res.getString(i));
						}
					records.add(inner);
					
						}
					JFrame j=new JFrame("Employee Details");
					
						j.setSize(1000,300);
					
						j.setVisible(true);
						
						
						JTable table=new JTable(records,header);
						JScrollPane pane=new JScrollPane(table);
						
						j.getContentPane().add(pane);
		                j.setVisible(true);
					
		                
						}
				catch(Exception e)
				{
					e.printStackTrace();
					
				}
					}
				
				}
				 
				 
				else if(s.equalsIgnoreCase("Department"))
					{ 
						
					try{
						
						String s1=textField.getText();
						Vector<String> header=new Vector<>();
						Vector<Vector<String>> records =new Vector<>();
						Connection con=DBInfo.getConn();
						String query="Select * from employee where Department=?";
						
						PreparedStatement ps=con.prepareStatement(query);
						ps.setString(1, s1);
						ResultSet res=ps.executeQuery();
						
						ResultSetMetaData rsmd=res.getMetaData();
						
						int count=rsmd.getColumnCount();
						
						for(int i=1;i<=count;i++)
						{
							header.add(rsmd.getColumnName(i).toUpperCase());
						}
						
						//System.out.println("header");
						while(res.next())
						{   
							Vector<String> inner=new Vector<>();
							for(int i=1;i<=count;i++)
							{
								inner.add(res.getString(i));
							}
						records.add(inner);
						
							}
						JFrame j=new JFrame("Employee Details");
						
							j.setSize(1000,300);
						
							j.setVisible(true);
							
							
							JTable table=new JTable(records,header);
							JScrollPane pane=new JScrollPane(table);
							
							j.getContentPane().add(pane);
						
			                j.setVisible(true);
			               
			                
							}
					catch(Exception e)
					{
						e.printStackTrace();
						
					}
				
					}
				
				 
				 
				else	if(s.equalsIgnoreCase("Post"))
					 
				 {
						
					try{
						
						String s1=textField.getText();
						Vector<String> header=new Vector<>();
						Vector<Vector<String>> records =new Vector<>();
						Connection con=DBInfo.getConn();
						String query="Select * from employee where Post=?";
						
						PreparedStatement ps=con.prepareStatement(query);
						ps.setString(1, s1);
						ResultSet res=ps.executeQuery();
						
						ResultSetMetaData rsmd=res.getMetaData();
						
						int count=rsmd.getColumnCount();
						
						for(int i=1;i<=count;i++)
						{
							header.add(rsmd.getColumnName(i).toUpperCase());
						}
						
						//System.out.println("header");
						while(res.next())
						{   
							Vector<String> inner=new Vector<>();
							for(int i=1;i<=count;i++)
							{
								inner.add(res.getString(i));
							}
						records.add(inner);
						
							}
						JFrame j=new JFrame("Employee Details");
						
							j.setSize(1000,300);
						
							j.setVisible(true);
							
							
							JTable table=new JTable(records,header);
							JScrollPane pane=new JScrollPane(table);
							
							j.getContentPane().add(pane);
						
			                j.setVisible(true);
			               
			                
							}
					catch(Exception e)
					{
						e.printStackTrace();
						
					}
				
					}
				
			}
			}
			
			
			
			});
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				textField.setText(null);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(79)
							.addComponent(lblSearchBy)
							.addGap(72)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(textField, Alignment.LEADING)
								.addComponent(comboBox, Alignment.LEADING, 0, 138, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(91)
							.addComponent(btnSearch)
							.addGap(77)
							.addComponent(btnReset)))
					.addContainerGap(87, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(101)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSearchBy))
					.addGap(29)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSearch)
						.addComponent(btnReset))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
