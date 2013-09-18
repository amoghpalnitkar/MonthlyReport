package loginPackage;


import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;


/**
 * Servlet implementation class LoginServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Connection currentCon = null;
	static ResultSet rs = null;
	java.sql.PreparedStatement registerStatement=null;
	int r;
	java.sql.PreparedStatement studStatement = null;
	String firstName,lastName,Email,Dept,Title,password;
	//String searchQuery = "insert into user values (3,'vishdam','" + firstName + "','" + lastName + "','" + Title + "','" + password + "','" + Dept + "')";
	String searchQuery= "insert into user(emailid,first_name,last_name,title,password,dept,active) values(?,?,?,?,?,?,?)";
	
	//emailid,last_name,title,password,dept

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In register servlet get");
		try {
			currentCon = ConnectionManager.getConnection();
		} catch (ClassNotFoundException | SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		String updateQuery = "insert into student(first_name,last_name,roll_no,dept,emailid,password,active) values(?,?,?,?,?,?,?)";
		String studName = request.getParameter("firstname_stud");
		String studLast = request.getParameter("lastname_stud");
		String studRoll = request.getParameter("roll_no_stud");
		String studDept = request.getParameter("department_stud");
		String studEmail = request.getParameter("emailid_stud");
		String studpwd = request.getParameter("passwd_stud");
		
		try {
			//stmt=currentCon.prepareStatement(updateQuery);
			studStatement = currentCon.prepareStatement(updateQuery);
			System.out.println(studName+studLast+studRoll+studDept+studpwd+studEmail);
			studStatement.setString(1, studName);
			studStatement.setString(2, studLast);
			studStatement.setString(3, studRoll);
			studStatement.setString(4, studDept);
			studStatement.setString(5, studEmail);
			studStatement.setString(6, studpwd );
			studStatement.setInt(7, 1 );
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			int suc = studStatement.executeUpdate();
			if(suc == 1)
				//System.out.println("Success!");
			request.getRequestDispatcher("LoginPage.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
			System.out.println("In the Register Servlet");
			LoginBean user = new LoginBean();
			user.setFirstName(request.getParameter("firstname"));
			user.setLastName(request.getParameter("lastname"));
			user.setPassword(request.getParameter("passwd"));
			user.setTitle(request.getParameter("title"));
			user.setEmailID(request.getParameter("emailid"));
			user.setDept(request.getParameter("department"));

			firstName = user.getFirstName();
			lastName = user.getLastName();		
			Title = user.getTitle();
			password=user.getPassword();
			Email=user.getEmailID();
			Dept=user.getDept();
			
			currentCon = ConnectionManager.getConnection();
			
			
			registerStatement=currentCon.prepareStatement(searchQuery);
			//registerStatement.setInt(1, 2);
			registerStatement.setString(1, Email);
			registerStatement.setString(2, firstName);
			registerStatement.setString(3, lastName);
			registerStatement.setString(4, Title);
			registerStatement.setString(5, password);
			registerStatement.setString(6, Dept);
			registerStatement.setInt(7, 1);
			
			
			r=registerStatement.executeUpdate();
			if(r==1)
			{
				//System.out.println("Success!");
				System.out.println(firstName + lastName + Email + Dept + Title + password);				
			}
			currentCon.close();
			//request.getRequestDispatcher("main.jsp").forward(request, response);
			response.sendRedirect("LoginPage.jsp");
			//stmt.ex
			//rs = stmt.executeQuery(searchQuery);


		} catch (Throwable exc)
		{
			System.out.println(exc);
		}
	}

}