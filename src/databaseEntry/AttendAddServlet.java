package databaseEntry;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import retrievePackage.UserBean;

import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class AttendAddServlet
 */

public class AttendAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String date,name,type,stringDate,stringDays,association;
	int UserID,days;
	static java.sql.Connection currentCon = null;
	java.sql.PreparedStatement AttendAddStatement=null;
	String updateQuery = "insert into attended(name,type,start_date,no_of_days,association,user_iduser) values (?,?,?,?,?,?)";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AttendAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		name = request.getParameter("att-title");
		type = request.getParameter("att-type");
		stringDate = request.getParameter("att-date");
		stringDays = request.getParameter("att-numdays");
		association = request.getParameter("att-association");

		SimpleDateFormat fromUser = new SimpleDateFormat("dd/MM/yy");
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
		days = Integer.parseInt(stringDays);
		try
		{
			date = myFormat.format(fromUser.parse(stringDate));
		}
		catch(ParseException e)
		{
			date=stringDate;
		}
		
		UserID = loginPackage.LoginBean.getUserId();
		int IdAttended = UserBean.getAttId();
		//System.out.println(userID+"  "+page_no+"  "+natint);
		String updateQuery = "update attended set name = ?,type = ?,start_date = ?,no_of_days = ?,association = ?,user_iduser = ? where idattended = ?";
		try {
			currentCon = loginPackage.ConnectionManager.getConnection();
			
			AttendAddStatement=currentCon.prepareStatement(updateQuery);
			AttendAddStatement.setString(1, name);
			AttendAddStatement.setString(2, type);
			AttendAddStatement.setString(3, date);
			AttendAddStatement.setInt(4, days);
			AttendAddStatement.setString(5, association);
			AttendAddStatement.setInt(6, UserID);
			AttendAddStatement.setInt(7, IdAttended);
			
			int isValid = AttendAddStatement.executeUpdate();
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
		request.getRequestDispatcher("RetrieveServletdummy").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		name = request.getParameter("att-title");
		type = request.getParameter("att-type");
		stringDate = request.getParameter("att-date");
		stringDays = request.getParameter("att-numdays");
		association = request.getParameter("att-association");

		SimpleDateFormat fromUser = new SimpleDateFormat("dd/MM/yy");
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
		days = Integer.parseInt(stringDays);
		try
		{
			date = myFormat.format(fromUser.parse(stringDate));
		}
		catch(ParseException e)
		{
			e.printStackTrace();
		}
		
		UserID = loginPackage.LoginBean.getUserId();
		//System.out.println(userID+"  "+page_no+"  "+natint);
		
		try {
			currentCon = loginPackage.ConnectionManager.getConnection();
			
			AttendAddStatement=currentCon.prepareStatement(updateQuery);
			AttendAddStatement.setString(1, name);
			AttendAddStatement.setString(2, type);
			AttendAddStatement.setString(3, date);
			AttendAddStatement.setInt(4, days);
			AttendAddStatement.setString(5, association);
			AttendAddStatement.setInt(6, UserID);
			
			int isValid = AttendAddStatement.executeUpdate();
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
		request.getRequestDispatcher("RetrieveServlet").forward(request, response);
	}

}
