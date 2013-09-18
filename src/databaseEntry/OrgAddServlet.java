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

import retrievePackage.UserBean;

/**
 * Servlet implementation class OrgAddServlet
 */


public class OrgAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Connection currentCon = null;
	String date,name,type,stringDate,stringDays,association,sponsor,place,no_of_participants,speaker;
	int UserID,days;
	java.sql.PreparedStatement OrgAddStatement=null;
	String updateQuery = "insert into organized(name,type,start_date,no_of_days,association,sponsor,place,no_of_participant,user_iduser,speaker) values (?,?,?,?,?,?,?,?,?,?)";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrgAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("In OrgAddServlet get");
		name = request.getParameter("org-name");
		type = request.getParameter("org-type");
		stringDate = request.getParameter("org-date");
		stringDays = request.getParameter("org-numberdays");
		association = request.getParameter("org-asso");
		sponsor = request.getParameter("org-sponsor");
		place = request.getParameter("org-place");
		no_of_participants = request.getParameter("org-numpartic");
		speaker = request.getParameter("org-speaker");
		SimpleDateFormat fromUser = new SimpleDateFormat("dd/MM/yy");
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
		try
		{
			date = myFormat.format(fromUser.parse(stringDate));
		}
		catch(ParseException e)
		{
			date=stringDate;
		}
		
		days=Integer.parseInt(stringDays);
		UserID = loginPackage.LoginBean.getUserId();
		//System.out.println(userID+"  "+page_no+"  "+natint);
		int IdOrganised = UserBean.getOrgId();
		String updateQuery = "update organized set name = ?,type = ?,start_date = ?,no_of_days = ?,association = ?,sponsor = ?,place = ?,no_of_participant = ?,user_iduser = ?,speaker = ? where idorganized = ?";
		try {
			currentCon = loginPackage.ConnectionManager.getConnection();
			
			OrgAddStatement=currentCon.prepareStatement(updateQuery);
			OrgAddStatement.setString(1, name);
			OrgAddStatement.setString(2, type);
			OrgAddStatement.setString(3, date);
			OrgAddStatement.setInt(4, days);
			OrgAddStatement.setString(5, association);
			OrgAddStatement.setString(6, sponsor);
			OrgAddStatement.setString(7, place);
			OrgAddStatement.setString(8, no_of_participants);
			OrgAddStatement.setInt(9, UserID);
			OrgAddStatement.setString(10, speaker);
			OrgAddStatement.setInt(11, IdOrganised);

			
			int isValid = OrgAddStatement.executeUpdate();
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
		System.out.println("In OrgAddServlet");
		name = request.getParameter("org-name");
		type = request.getParameter("org-type");
		stringDate = request.getParameter("org-date");
		stringDays = request.getParameter("org-numberdays");
		association = request.getParameter("org-asso");
		sponsor = request.getParameter("org-sponsor");
		place = request.getParameter("org-place");
		no_of_participants = request.getParameter("org-numpartic");
		speaker = request.getParameter("org-speaker");
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
		
		days=Integer.parseInt(stringDays);
		UserID = loginPackage.LoginBean.getUserId();
		//System.out.println(userID+"  "+page_no+"  "+natint);
		
		try {
			currentCon = loginPackage.ConnectionManager.getConnection();
			
			OrgAddStatement=currentCon.prepareStatement(updateQuery);
			OrgAddStatement.setString(1, name);
			OrgAddStatement.setString(2, type);
			OrgAddStatement.setString(3, date);
			OrgAddStatement.setInt(4, days);
			OrgAddStatement.setString(5, association);
			OrgAddStatement.setString(6, sponsor);
			OrgAddStatement.setString(7, place);
			OrgAddStatement.setString(8, no_of_participants);
			OrgAddStatement.setInt(9, UserID);
			OrgAddStatement.setString(10, speaker);

			
			int isValid = OrgAddStatement.executeUpdate();
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
