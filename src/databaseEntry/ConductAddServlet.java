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
 * Servlet implementation class ConductAddServlet
 */
public class ConductAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Connection currentCon = null;
	String date,name,type,stringDate,stringDays,association,sponsor,place,no_of_participants,takeNote;
	int UserID,days,keyNote;
	java.sql.PreparedStatement ConductAddStatement=null;
	String updateQuery = "insert into conducted(name,type,start_date,no_of_days,association,sponsor,place,no_of_participant,user_iduser,keynote) values (?,?,?,?,?,?,?,?,?,?)";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConductAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int IdConducted = 0;
		System.out.println("In ConductAddServlet");
		name = request.getParameter("con-title");
		type = request.getParameter("con-type");
		stringDate = request.getParameter("con-date");
		stringDays = request.getParameter("con-numdays");
		association = request.getParameter("con-asso");
		sponsor = request.getParameter("con-sponsor");
		place = request.getParameter("con-place");
		no_of_participants = request.getParameter("con-numpartic");
		takeNote = request.getParameter("con-keynote");
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
		if(takeNote.equals("Yes"))
		{
			keyNote = 1;
		}
		else
			keyNote = 0;
		days=Integer.parseInt(stringDays);
		UserID = loginPackage.LoginBean.getUserId();
		IdConducted = UserBean.getConId();
		String updateQuery = "update conducted set name = ?,type = ?,start_date = ?,no_of_days = ?,association = ?,sponsor = ?,place = ?,no_of_participant = ?,user_iduser = ?,keynote = ? where idconducted = ?";
		try {
			currentCon = loginPackage.ConnectionManager.getConnection();
			
			ConductAddStatement=currentCon.prepareStatement(updateQuery);
			ConductAddStatement.setString(1, name);
			ConductAddStatement.setString(2, type);
			ConductAddStatement.setString(3, date);
			ConductAddStatement.setInt(4, days);
			ConductAddStatement.setString(5, association);
			ConductAddStatement.setString(6, sponsor);
			ConductAddStatement.setString(7, place);
			ConductAddStatement.setString(8, no_of_participants);
			ConductAddStatement.setInt(9, UserID);
			ConductAddStatement.setInt(10, keyNote);
			ConductAddStatement.setInt(11, IdConducted);
			
			int isValid = ConductAddStatement.executeUpdate();
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
		System.out.println("In ConductAddServlet");
		name = request.getParameter("con-title");
		type = request.getParameter("con-type");
		stringDate = request.getParameter("con-date");
		stringDays = request.getParameter("con-numdays");
		association = request.getParameter("con-asso");
		sponsor = request.getParameter("con-sponsor");
		place = request.getParameter("con-place");
		no_of_participants = request.getParameter("con-numpartic");
		takeNote = request.getParameter("con-keynote");
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
		if(takeNote.equals("Yes"))
		{
			keyNote = 1;
		}
		else
			keyNote = 0;
		days=Integer.parseInt(stringDays);
		UserID = loginPackage.LoginBean.getUserId();
		//System.out.println(userID+"  "+page_no+"  "+natint);
		
		try {
			currentCon = loginPackage.ConnectionManager.getConnection();
			
			ConductAddStatement=currentCon.prepareStatement(updateQuery);
			ConductAddStatement.setString(1, name);
			ConductAddStatement.setString(2, type);
			ConductAddStatement.setString(3, date);
			ConductAddStatement.setInt(4, days);
			ConductAddStatement.setString(5, association);
			ConductAddStatement.setString(6, sponsor);
			ConductAddStatement.setString(7, place);
			ConductAddStatement.setString(8, no_of_participants);
			ConductAddStatement.setInt(9, UserID);
			ConductAddStatement.setInt(10, keyNote);

			
			int isValid = ConductAddStatement.executeUpdate();
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
