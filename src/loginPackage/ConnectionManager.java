package loginPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionManager {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/monthlyreport", "root", "amogh123");
		
		//PreparedStatement statement = con.prepareStatement("select * from users");
		
		//ResultSet result = statement.executeQuery();
		//while(result.next())
		//{
			//System.out.println(result.getString(1) + " " + result.getString(2)+ " " + result.getString(3));
			
		//}
			
		return con;
	}

}
