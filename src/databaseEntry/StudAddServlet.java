package databaseEntry;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudAddServlet
 */
public class StudAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      String name,type, stringDate,place,rank,date;
      int UserID;
      static Connection currentCon = null;
      String updateQuery = "insert into stud_achieve(co_participants,date,event_name,place,position,type,student_idstudent,verified) values (?,?,?,?,?,?,?,?)";
      java.sql.PreparedStatement StudAddStatement=null;
  	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String projQuery = "insert into project(co_participants,date,title,place,position,student_idstudent,event_name,domain,description,verified) values (?,?,?,?,?,?,?,?,?,?)";
	      
		String co_part=request.getParameter("stud-copart");
		name = request.getParameter("stud-title");
		type = request.getParameter("stud-type");
		stringDate = request.getParameter("stud-date");
		place = request.getParameter("stud-place");
		rank = request.getParameter("stud-rank");
		String event = request.getParameter("stud-event");
		String domain = request.getParameter("stud-domain");
		String descript = request.getParameter("stud-descript");

		SimpleDateFormat fromUser = new SimpleDateFormat("dd/MM/yy");
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		try
		{
			date = myFormat.format(fromUser.parse(stringDate));
		}
		catch(ParseException e)
		{
			e.printStackTrace();
		}
		
		UserID = loginPackage.LoginBean.getStudId();
		//String stud_name= loginPackage.LoginBean.getStudName();
		
		//System.out.println(userID+"  "+page_no+"  "+natint);
		
		try {
			currentCon = loginPackage.ConnectionManager.getConnection();
			
			StudAddStatement=currentCon.prepareStatement(projQuery);
			StudAddStatement.setString(1, co_part);
			StudAddStatement.setString(2, date);
			StudAddStatement.setString(3, name);
			StudAddStatement.setString(4, place);
			StudAddStatement.setString(5, rank);
			StudAddStatement.setInt(6, UserID);
			StudAddStatement.setString(7, event);
			StudAddStatement.setString(8, domain);
			StudAddStatement.setString(9, descript);
			StudAddStatement.setInt(10, 0);
			
			
			int isValid = StudAddStatement.executeUpdate();
			if(isValid == 1)
				System.out.println("Success!");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				currentCon.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
		request.getRequestDispatcher("WEB-INF/studHome.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String co_part=request.getParameter("stud-copart");
		name = request.getParameter("stud-title");
		type = request.getParameter("stud-type");
		stringDate = request.getParameter("stud-date");
		place = request.getParameter("stud-place");
		rank = request.getParameter("stud-rank");

		SimpleDateFormat fromUser = new SimpleDateFormat("dd/MM/yy");
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		try
		{
			date = myFormat.format(fromUser.parse(stringDate));
		}
		catch(ParseException e)
		{
			e.printStackTrace();
		}
		
		UserID = loginPackage.LoginBean.getStudId();
		//String stud_name= loginPackage.LoginBean.getStudName();
		
		//System.out.println(userID+"  "+page_no+"  "+natint);
		
		try {
			currentCon = loginPackage.ConnectionManager.getConnection();
			
			StudAddStatement=currentCon.prepareStatement(updateQuery);
			StudAddStatement.setString(1, co_part);
			StudAddStatement.setString(2, date);
			StudAddStatement.setString(3, name);
			StudAddStatement.setString(4, place);
			StudAddStatement.setString(5, rank);
			StudAddStatement.setString(6, type);
			StudAddStatement.setInt(7, UserID);
			
			
			int isValid = StudAddStatement.executeUpdate();
			if(isValid == 1)
				System.out.println("Success!");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				currentCon.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
		request.getRequestDispatcher("WEB-INF/studHome.jsp").forward(request, response);
	}
	
	
	
	

}
