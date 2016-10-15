



	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;
	import java.util.Vector;

	import javax.swing.JFrame;
	import javax.swing.JScrollPane;
	import javax.swing.JTable;

	import java.sql.ResultSetMetaData;

	import java.sql.ResultSet;

	public class Table_Test extends JFrame 
	{
		public Table_Test() throws SQLException 
		{
			Vector<String> header=new Vector<>();
			Vector<Vector<String>> records =new Vector<>();
			Connection con=DBInfo.getConn();
			String query="Select * from Employee";
			PreparedStatement ps=con.prepareStatement(query);
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
				setSize(300,200);
				setLocationRelativeTo(this);
				setVisible(true);
				JTable table=new JTable(records,header);
				JScrollPane pane=new JScrollPane(table);
				add(pane);
				
				
			}
		public static void main(String[] args)throws Exception 
		{
			Table_Test obj=new Table_Test();
			obj.setVisible(true);
			
		}
		}





