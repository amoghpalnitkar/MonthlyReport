package retrievePackage;


import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import loginPackage.ConnectionManager;

/**
 * Servlet implementation class RetrieveServlet
 */
public class RetrieveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Connection currentCon = null;
	static ResultSet rs,rs1,rs2,rs3,rs4,rs5,rs6;
	Statement stmt,stmt1,stmt2,stmt3;
	String searchQuery = "select iduser from user";
	String name1,stringDate,date;
	String atdQuery,cdtQuery,orgQuery,pubQuery,conQuery;
	int days;
	Iterator<String> itr;
	
	int id;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("In the Retrieve Servlet get");	
		String cat=request.getParameter("param");
		String name=request.getParameter("name");
		String stringDate=request.getParameter("dat");
		SimpleDateFormat fromUser = new SimpleDateFormat("dd-MMM-yyyy");
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
				
		try
		{
			date = myFormat.format(fromUser.parse(stringDate));
		}
		catch(ParseException e)
		{
			date=stringDate;
		}
		if(cat.equals("paper"))
		{
			try 
			{
				System.out.println(cat+name+date);
				id = loginPackage.LoginBean.getUserId();
				pubQuery="select * from publication where user_iduser=" + id +" and title= '" + name +"' and date= '" + date +"'";			
				rs3 = stmt.executeQuery(pubQuery);
				
				while(rs3.next())
				{
					UserBean.setPaperId(rs3.getInt("idpublication"));
				UserBean.setPaperTitle(rs3.getString("title"));
				UserBean.setPaperType(rs3.getString("type"));
				UserBean.setPaperDate(rs3.getString("date"));
				UserBean.setPaperVolume(rs3.getString("volume"));
				UserBean.setPaperIssue(rs3.getString("issue"));
				UserBean.setPaperAuthor(rs3.getString("authors"));
				UserBean.setPaperPubIn(rs3.getString("published_in"));
				UserBean.setPaperPage(rs3.getString("page_no"));
				UserBean.setPaperNatint(rs3.getInt("natint"));
				request.getRequestDispatcher("WEB-INF/Paper.jsp").forward(request, response);
				}
 
				
			} 
				catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
		}
		if(cat.equals("conducted"))
		{
			try 
			{
				id = loginPackage.LoginBean.getUserId();
				System.out.println(cat+name+id);
				String conduct = "select * from conducted";
				//System.out.println("null");
				conQuery="select * from conducted where user_iduser=" + id +" and name= '" + name +"' and start_date= '" + date +"'";			
				rs4 = stmt.executeQuery(conQuery);
				
				while(rs4.next())
				{
					UserBean.setConId(rs4.getInt("idconducted"));
				UserBean.setConName(rs4.getString("name"));
				UserBean.setConType(rs4.getString("type"));
				UserBean.setConDate(rs4.getString("start_date"));
				UserBean.setConDays(rs4.getInt("no_of_days"));
				UserBean.setConAsso(rs4.getString("association"));
				UserBean.setConSponsor(rs4.getString("sponsor"));
				UserBean.setConPlace(rs4.getString("place"));
				UserBean.setConParti(rs4.getInt("no_of_participant"));
				UserBean.setConKeynote(rs4.getInt("keynote"));
				request.getRequestDispatcher("WEB-INF/Conducted.jsp").forward(request, response);
				}
				
			} 
				catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
		}
		if(cat.equals("organised"))
		{
			try 
			{
				id = loginPackage.LoginBean.getUserId();
				System.out.println(cat+name+id);
				//String orgQuery = "select * from organised";
				//System.out.println("null");
				orgQuery="select * from organized where user_iduser=" + id +" and name= '" + name +"' and start_date= '" + date +"'";			
				rs5 = stmt.executeQuery(orgQuery);
				
				while(rs5.next())
				{
					UserBean.setOrgId(rs5.getInt("idorganized"));
				UserBean.setOrgName(rs5.getString("name"));
				UserBean.setOrgType(rs5.getString("type"));
				UserBean.setOrgDate(rs5.getString("start_date"));
				UserBean.setOrgDays(rs5.getInt("no_of_days"));
				UserBean.setOrgAsso(rs5.getString("association"));
				UserBean.setOrgSponsor(rs5.getString("sponsor"));
				UserBean.setOrgPlace(rs5.getString("place"));
				UserBean.setOrgParti(rs5.getInt("no_of_participant"));
				UserBean.setOrgSpeaker(rs5.getString("speaker"));
				request.getRequestDispatcher("WEB-INF/Organised.jsp").forward(request, response);
				}
				
			} 
				catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		
			
		}
		if(cat.equals("attended"))
		{
			try 
			{
				id = loginPackage.LoginBean.getUserId();
				System.out.println(cat+name+id);
				//String orgQuery = "select * from organised";
				//System.out.println("null");
				String attQuery="select * from attended where user_iduser=" + id +" and name= '" + name +"' and start_date= '" + date +"'";			
				rs6 = stmt.executeQuery(attQuery);
				
				while(rs6.next())
				{
					UserBean.setAttId(rs6.getInt("idattended"));
				UserBean.setAttName(rs6.getString("name"));
				UserBean.setAttType(rs6.getString("type"));
				UserBean.setAttDate(rs6.getString("start_date"));
				UserBean.setAttDays(rs6.getInt("no_of_days"));
				UserBean.setAttAsso(rs6.getString("association"));
				UserBean.setAttTitle(rs6.getString("title"));
				request.getRequestDispatcher("WEB-INF/Attended.jsp").forward(request, response);
				}
				
			} 
				catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
		}

	
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<String> nameList=new ArrayList<String>();
		List<String> typeList=new ArrayList<String>();
		List<String> dateList=new ArrayList<String>();
		List<String> nameList1=new ArrayList<String>();
		List<String> typeList1=new ArrayList<String>();
		List<String> dateList1=new ArrayList<String>();
		List<String> nameList2=new ArrayList<String>();
		List<String> typeList2=new ArrayList<String>();
		List<String> dateList2=new ArrayList<String>();
		List<String> nameList3=new ArrayList<String>();
		List<String> typeList3=new ArrayList<String>();
		List<String> dateList3=new ArrayList<String>();
		try
		{
			
			
			System.out.println("In the Retrieve Servlet post");	
			
			//String[] name=new String[20];			   
			currentCon=loginPackage.ConnectionManager.getConnection();
			stmt=currentCon.createStatement();
		
			id = loginPackage.LoginBean.getUserId();
			atdQuery="select * from attended where user_iduser=" + id;
			rs = stmt.executeQuery(atdQuery);	
			
			while(rs.next())
			{				
				/*UserBean.setAttName(rs.getString("name"));
				UserBean.setAttType(rs.getString("type"));
				UserBean.setAttDate(rs.getString("start_date"));
				UserBean.setAttDays(rs.getInt("no_of_days"));
				UserBean.setAttTitle(rs.getString("title"));
				UserBean.setAttAsso(rs.getString("association"));*/
				
				nameList.add(rs.getString("name"));
				typeList.add(rs.getString("type"));
				stringDate=rs.getString("start_date");
				SimpleDateFormat fromUser = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat myFormat = new SimpleDateFormat("dd-MMM-yyyy");
				try
				{
					date = myFormat.format(fromUser.parse(stringDate));
				}
				catch(ParseException e)
				{
					e.printStackTrace();
				}
				dateList.add(date);

			}
			for (itr=nameList.iterator(); itr.hasNext(); )
			{
				System.out.println(itr.next());
			}
			
			
			cdtQuery="select * from conducted where user_iduser=" + id;
			rs1 = stmt.executeQuery(cdtQuery);	
			/*UserBean.setOrgName(rs1.getString("name"));
			UserBean.setOrgType(rs1.getString("type"));
			UserBean.setOrgDate(rs1.getString("start_date"));
			UserBean.setOrgDays(rs1.getInt("no_of_days"));
			UserBean.setOrgAsso(rs1.getString("association"));
			UserBean.setOrgSponsor(rs1.getString("sponsor"));
			UserBean.setOrgPlace(rs1.getString("place"));
			UserBean.setOrgParti(rs1.getInt("no_of_participant"));
			UserBean.setOrgSpeaker(rs1.getString("speaker"));*/
			
			while(rs1.next())
			{					
				
				nameList1.add(rs1.getString("name"));
				typeList1.add(rs1.getString("type"));
				stringDate=rs1.getString("start_date");
				SimpleDateFormat fromUser = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat myFormat = new SimpleDateFormat("dd-MMM-yyyy");
				try
				{
					date = myFormat.format(fromUser.parse(stringDate));
				}
				catch(ParseException e)
				{
					e.printStackTrace();
				}
				dateList1.add(date);

			}
			
			orgQuery="select * from organized where user_iduser=" + id;
			rs2 = stmt.executeQuery(orgQuery);	
			
			/*UserBean.setConName(rs2.getString("name"));
			UserBean.setConType(rs2.getString("type"));
			UserBean.setConDate(rs2.getString("start_date"));
			UserBean.setConDays(rs2.getInt("no_of_days"));
			UserBean.setConAsso(rs2.getString("association"));
			UserBean.setConSponsor(rs2.getString("sponsor"));
			UserBean.setConPlace(rs2.getString("place"));
			UserBean.setConParti(rs2.getInt("no_of_participant"));
			UserBean.setConKeynote(rs2.getInt("keynote"));*/
			
			while(rs2.next())
			{					
				
				nameList2.add(rs2.getString("name"));
				typeList2.add(rs2.getString("type"));
				stringDate=rs2.getString("start_date");
				SimpleDateFormat fromUser = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat myFormat = new SimpleDateFormat("dd-MMM-yyyy");
				try
				{
					date = myFormat.format(fromUser.parse(stringDate));
				}
				catch(ParseException e)
				{
					e.printStackTrace();
				}
				dateList2.add(date);

			}
			
			pubQuery="select * from publication where user_iduser=" + id;
			rs3 = stmt.executeQuery(pubQuery);	
			
			/*UserBean.setPaperTitle(rs3.getString("title"));
			UserBean.setPaperType(rs3.getString("type"));
			UserBean.setPaperDate(rs3.getString("date"));
			UserBean.setPaperVolume(rs3.getString("volume"));
			UserBean.setPaperIssue(rs3.getString("issue"));
			UserBean.setPaperAuthor(rs3.getString("authors"));
			UserBean.setPaperPubIn(rs3.getString("published_in"));
			UserBean.setPaperPage(rs3.getInt("page_no"));
			UserBean.setPaperNatint(rs3.getInt("natint"));*/
			
			while(rs3.next())
			{					
				
				nameList3.add(rs3.getString("title"));
				typeList3.add(rs3.getString("type"));
				stringDate=rs3.getString("date");
				SimpleDateFormat fromUser = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat myFormat = new SimpleDateFormat("dd-MMM-yyyy");
				try
				{
					date = myFormat.format(fromUser.parse(stringDate));
				}
				catch(ParseException e)
				{
					e.printStackTrace();
				}
				dateList3.add(date);

			}
			
		} 
		catch (Throwable exc)
		{
			System.out.println(exc);
		}
			
		
		
		request.setAttribute("name", nameList);
		request.setAttribute("type", typeList);
		request.setAttribute("date", dateList);
		request.setAttribute("name1", nameList1);
		request.setAttribute("type1", typeList1);
		request.setAttribute("date1", dateList1);
		request.setAttribute("name2", nameList2);
		request.setAttribute("type2", typeList2);
		request.setAttribute("date2", dateList2);
		request.setAttribute("name3", nameList3);
		request.setAttribute("type3", typeList3);
		request.setAttribute("date3", dateList3);
		
		request.getRequestDispatcher("WEB-INF/userhomepage.jsp").forward(request, response);
	}
		
}