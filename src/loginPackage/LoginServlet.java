package loginPackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
			System.out.println("In the Login Servlet");
			String usertype=null;



			LoginBean user = new LoginBean();
			usertype=request.getParameter("userType");
			//System.out.println(usertype);
			if(usertype.equals("Staff"))
			{
				user.setUserName(request.getParameter("uname"));
				user.setPassword(request.getParameter("password"));
				user = LoginDAO.login(user);
				if(user.isValid())
				{
					HttpSession session = request.getSession(true);
					session.setAttribute("currentSessionUser",user);
					//response.sendRedirect("RetrieveServlet.java");
					if(user.isAdmin)
						request.getRequestDispatcher("PendingServlet").forward(request, response);
					else
						request.getRequestDispatcher("RetrieveServlet").forward(request, response);

				}else
					response.sendRedirect("LoginFailed.jsp");
			}
			else if (usertype.equals("Student"))
			{
				String check_stud="select * from student where emailid = '"+request.getParameter("uname")+"' AND password='"+request.getParameter("password")+"'";
				 Connection currentCon = null;
				 ResultSet rs = null;
				 Statement stmt = null;
				 currentCon = ConnectionManager.getConnection();
				 stmt=currentCon.createStatement();
				 rs = stmt.executeQuery(check_stud);
				boolean studExists = rs.next();
				if (studExists){
					LoginBean.setStudId(rs.getInt("idstudent"));
					LoginBean.setStudName(rs.getString("first_name"));
					request.getRequestDispatcher("WEB-INF/studHome.jsp").forward(request, response);
				}
				else
					response.sendRedirect("LoginFailed.jsp");
			}
		}
			
		catch (Throwable exc)
			{
				System.out.println(exc);
			}


		}
	}
