package loginPackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginDAO
{
static Connection currentCon = null;
static ResultSet rs,resultUser = null;
public static LoginBean login(LoginBean bean)
{
int UserID;
Statement stmt = null;
//Statement getUser = null;
String username = bean.getUsername();
String password = bean.getPassword();
String searchQuery = "select * from user where emailid='" + username + "' AND password='" + password + "'" + " AND active =1";
//String getUserID = "select iduser from user where emailid = '" + username + "'";
try
{
//connecting to the DB
currentCon = ConnectionManager.getConnection();
stmt=currentCon.createStatement();
rs = stmt.executeQuery(searchQuery);
boolean userExists = rs.next();

if (!userExists)
{
System.out.println("Username/Password entered is Incorrect or User doesnot Exists.");
bean.setValid(false);
}
else if (userExists)
{
//String firstName = rs.getString("emailid");
//String lastName = rs.getString("lastName");
//System.out.println("Welcome " + firstName);
//bean.setFirstName(firstName);
//bean.setLastName(lastName);
	//getUser = currentCon.createStatement();
	//resultUser = getUser.executeQuery(getUserID);
	//UserID = resultUser
	if(rs.getString("emailid").equals("admin"))
	{
		bean.isAdmin = true;
	}
	UserID = rs.getInt("iduser");
	LoginBean.setUserId(UserID);
bean.setValid(true);
}

}
catch (Exception ex)
{
System.out.println("Log In failed: An Exception has occurred! " + ex);
}
return bean;
}
}