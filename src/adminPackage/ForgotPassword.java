package adminPackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.mail.Authenticator;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForgotPassword extends HttpServlet {
	private String host;
	private String port;
	private String user;
	private String pass,content;
	private Connection con;
	String getEmail,userEmail,password;
	Statement stmt;
	ResultSet rs;
	public void init() {
		// reads SMTP server setting from web.xml file
		ServletContext context = getServletContext();
		host = context.getInitParameter("host");
		port = context.getInitParameter("port");
		user = context.getInitParameter("user");
		pass = context.getInitParameter("pass");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// reads form fields
		//String recipient = request.getParameter("recipient");
		
		String subject = "[PICT] Forgot Password";
		
		userEmail=request.getParameter("uname");
		System.out.println(userEmail);
		String recipient = userEmail;
		//String to=request.getParameter("end-date");
		//System.out.println(from + to);
		String resultMessage = "";
		try
		{
			con = loginPackage.ConnectionManager.getConnection();
			getEmail = "select * from user where emailid = '" + userEmail + "'";
			stmt = con.createStatement();
			rs = stmt.executeQuery(getEmail);
			
			while(rs.next())
			{
				password = rs.getString("password");
			}
				
				content = "Your account information is \nUsername : "+ userEmail + "\nPassword : "+password; 
					EmailUtility.sendEmail(host, port, user, pass, recipient, subject,
						content);
				
				
			
			
		} catch (Exception e) {
			e.printStackTrace();
			resultMessage = "There were an error: " + e.getMessage();
		}
		finally {
			resultMessage = "The e-mail was sent successfully";
			request.setAttribute("Message", resultMessage);
			request.getRequestDispatcher("LoginPage.jsp").forward(request, response);
		}
	}
}