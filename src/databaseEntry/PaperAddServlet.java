package databaseEntry;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import retrievePackage.UserBean;

/**
 * Servlet implementation class DbAddServlet
 */
@WebServlet("/DbAddServlet")
public class PaperAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Connection currentCon = null;
	String title,type,published_in,volume,issue,authors,Stringnatint,Spage_no,StringDate,date;
	int page_no,natint;
  //String updateQuery = "insert into publication(title,type,published_in,volume,issue,page_no,authors,user_iduser,natint) values(?,?,?,?,?,?,?,?,?)";
	//String updateQuery = "insert into publication(title) values(?)";
    java.sql.PreparedStatement PaperAddStatement=null;
    int userID;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaperAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("In PaperAddServlet get");
		 	
		title = request.getParameter("ppr-title");		
		type = request.getParameter("ppr-conjor");		
		published_in = request.getParameter("ppr-published");
		volume = request.getParameter("ppr-volume");
		issue = request.getParameter("ppr-issue");
		Spage_no = request.getParameter("ppr-pageno");
		Stringnatint = request.getParameter("ppr-natint");
		StringDate = request.getParameter("ppr-date");
		authors = request.getParameter("ppr-author");
		//page_no = Integer.valueOf(Spage_no) ;
		SimpleDateFormat fromUser = new SimpleDateFormat("dd/MM/yy");
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		System.out.println(type + Stringnatint +StringDate);
		
		
		try
		{
			date = myFormat.format(fromUser.parse(StringDate));
		}
		catch(ParseException e)
		{
			//e.printStackTrace();
			date=StringDate;
			
		}
		if(Stringnatint.equalsIgnoreCase("National"))
			natint = 0;
		else
			natint = 1;
		userID = loginPackage.LoginBean.getUserId();
		int paperID=UserBean.getPaperId();
		//System.out.println(userID+"  "+page_no+"  "+natint);
		String updateQuery = "update publication set title =?,type=?,published_in=?,date=?,volume=?,issue=?,page_no=?,authors=?,natint=?, user_iduser=? where idpublication=?";
		
		try {
			currentCon = loginPackage.ConnectionManager.getConnection();
			
			PaperAddStatement=currentCon.prepareStatement(updateQuery);
			PaperAddStatement.setString(1, title);
			PaperAddStatement.setString(2, type);
			PaperAddStatement.setString(3, published_in);
			PaperAddStatement.setString(4,date);
			PaperAddStatement.setString(5, volume);
			PaperAddStatement.setString(6, issue);
			PaperAddStatement.setString(7, Spage_no);
			PaperAddStatement.setString(8, authors);
			PaperAddStatement.setInt(9, natint);
			PaperAddStatement.setInt(10, userID);
			PaperAddStatement.setInt(11, paperID);
			
			

			
			int isValid = PaperAddStatement.executeUpdate();
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
		 String updateQuery = "insert into publication(title,type,published_in,date,volume,issue,page_no,authors,user_iduser,natint) values(?,?,?,?,?,?,?,?,?,?)";
			
		System.out.println("In PaperAddServlet");
		title = request.getParameter("ppr-title");
		
		type = request.getParameter("ppr-conjor");
		
		published_in = request.getParameter("ppr-published");
		volume = request.getParameter("ppr-volume");
		issue = request.getParameter("ppr-issue");
		Spage_no = request.getParameter("ppr-pageno");
		Stringnatint = request.getParameter("ppr-natint");
		StringDate = request.getParameter("ppr-date");
		authors = request.getParameter("ppr-author");
		//page_no = Integer.valueOf(Spage_no) ;
		SimpleDateFormat fromUser = new SimpleDateFormat("dd/MM/yy");
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		System.out.println(type + Stringnatint +StringDate);
		
		
		try
		{
			date = myFormat.format(fromUser.parse(StringDate));
		}
		catch(ParseException e)
		{
			e.printStackTrace();
		}
		if(Stringnatint.equalsIgnoreCase("National"))
			natint = 0;
		else
			natint = 1;
		userID = loginPackage.LoginBean.getUserId();
		//System.out.println(userID+"  "+page_no+"  "+natint);
		
		try {
			currentCon = loginPackage.ConnectionManager.getConnection();
			
			PaperAddStatement=currentCon.prepareStatement(updateQuery);
			PaperAddStatement.setString(1, title);
			PaperAddStatement.setString(2, type);
			PaperAddStatement.setString(3, published_in);
			PaperAddStatement.setString(4,date);
			PaperAddStatement.setString(5, volume);
			PaperAddStatement.setString(6, issue);
			PaperAddStatement.setString(7, Spage_no);
			PaperAddStatement.setString(8, authors);
			PaperAddStatement.setInt(9, userID);
			PaperAddStatement.setInt(10, natint);

			
			int isValid = PaperAddStatement.executeUpdate();
			//if(isValid == 1)
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
