package loginPackage;

//Data Encapsulation using Getters and Setters
public class LoginBean {
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String Email;
	private String Dept;
	private String Title;
	private static String studName;
	public boolean valid;
	public boolean isAdmin;
	public static int UserId;
	public static int StudId;
	public static int getUserId()
	{
		return UserId;
	}
	public static void setUserId(int UserID)
	{
		UserId = UserID;
	}
	public static int getStudId()
	{
		return StudId;
	}
	public static void setStudId(int StudID)
	{
		StudId = StudID;
	}
	public static void setStudName(String StudName)
	{
		studName = StudName;
	}
	public static String getStudName()
	{
		return studName;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public void setFirstName(String newFirstName)
	{
		firstName = newFirstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public void setLastName(String newLastName)
	{
		lastName = newLastName;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String newPassword)
	{
		password = newPassword;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUserName(String newUsername)
	{
		username = newUsername;
	}
	public String getTitle()
	{
		return Title;
	}
	public void setTitle(String newTitle)
	{
		Title = newTitle;
	}
	public String getEmailID()
	{
		return Email;
	}
	public void setEmailID(String newEmailID)
	{
		Email = newEmailID;
	}
	public String getDept()
	{
		return Dept;
	}
	public void setDept(String newDept)
	{
		Dept = newDept;
	}
	public boolean isValid()
	{
		return valid;
	}
	public void setValid(boolean newValid)
	{
		valid = newValid;
	}
}