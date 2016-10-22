import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.naming.spi.DirStateFactory.Result;

public class GetValues 
{
	public static Vector<String> getDepartment()
	{
		Vector<String> v= new Vector <String>();
		Connection con = DBInfo.getConn();
		String query="select * from department order by name";
		try
		{
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet res=ps.executeQuery();
			while (res.next())
			{
				v.add(res.getString(1).toUpperCase());
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return v;
	}
	
	public static Vector<String> getPost()
	{
		Vector<String> v=new Vector <String>();
		Connection con=DBInfo.getConn();
		String query="select * from post order by post";
		try
		{
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet res= ps.executeQuery();
			while (res.next())
			{
				v.add(res.getString(1).toUpperCase());
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return v;
	}
	public static Vector<String> getMonth()
	{
		Vector <String> v = new Vector<String>();
		Connection con=DBInfo.getConn();
		String query="select * from month";
		try
		{
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet res=ps.executeQuery();
			while (res.next())
			{
				v.add(res.getString(1));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return v;
	}
	public static Vector<String> getSearch()
	{
		Vector <String> v = new Vector <String>();
		Connection con=DBInfo.getConn();
		String query="select * from searchby";
		try
		{
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet res=ps.executeQuery();
			while (res.next())
			{
				v.add(res.getString(1));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return v;
		
	}

}
