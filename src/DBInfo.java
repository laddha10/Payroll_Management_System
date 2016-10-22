import java.sql.Connection;
import java.sql.DriverManager;

public class DBInfo
{
	static
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("driver loaded");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public static Connection getConn()
	{
		Connection con=null;
		try
		{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll","root","abhi");
				
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
}
