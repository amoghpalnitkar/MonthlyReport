package retrievePackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RetrieveServletdummy extends HttpServlet {
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
    public RetrieveServletdummy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
