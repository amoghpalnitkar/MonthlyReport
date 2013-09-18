package adminPackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.mail.Authenticator;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class emailSendingServlet extends HttpServlet {
	private String host;
	private String port;
	private String user;
	private String pass;
	private Connection con;
	String getEmail;
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
		String recipient = null;
		String subject = "[PICT] Reminder for Monthly Report";
		
		String from=request.getParameter("start-date");
		String to=request.getParameter("end-date");
		System.out.println(from + to);
		String resultMessage = "";
		try
		{
			con = loginPackage.ConnectionManager.getConnection();
			getEmail = "select * from user where active=1";
			stmt = con.createStatement();
			rs = stmt.executeQuery(getEmail);
			
			while(rs.next())
			{
				recipient = rs.getString("emailid");
				
				
				if(!recipient.equals("admin"))
				{
					String content = rs.getString("title") +" " +rs.getString("first_name") + " " +rs.getString("last_name")+ ",\nPlease fill the details of your activities over the period "+ from + "to "+ to;
					System.out.println(recipient+"\n");
					EmailUtility.sendEmail(host, port, user, pass, recipient, subject,
						content);
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			resultMessage = "There were an error: " + e.getMessage();
		}
		finally {
			resultMessage = "The e-mail was sent successfully";
			request.setAttribute("Message", resultMessage);
			request.getRequestDispatcher("PendingServlet").forward(request, response);
		}
	}
}