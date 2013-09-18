package retrievePackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PendingStudServlet
 */

public class PendingStudServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String studQuery,projQuery,conQuery,attQuery,orgQuery,stringDate,date,updateQuery,paperQuery,idForNameStud,idForNameProj;
    Connection currentCon;
    ResultSet rs,rs1,rs2,rs3,rs4,rs5,rs6;
    Statement stmt;
    int id,nat;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PendingStudServlet() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name,checked;
		
		String[] splits;
		System.out.println("in pending stud servlet get");
		String[] checkboxes=request.getParameterValues("checkStud");
		//System.out.println(checkboxes[0]);
		int len=checkboxes.length;
		System.out.println(len);
		int i=0;
	while(i<len)
	{
	
		System.out.println(checkboxes[i]);
		splits=checkboxes[i].split(":");
		System.out.println("id" + splits[0] + "tab" +splits[1]);
		updateQuery="update "+ splits[1] +" set verified=1 where id"+splits[1]+" ="+splits[0];
		try {
			stmt.executeUpdate(updateQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		i++;
		//request.getRequestDispatcher("PendingStudServletdummy").forward(request, response);
		
	}
	request.getRequestDispatcher("PendingServletdummy").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<String> StudCoPartList=new ArrayList<String>();
		List<String> StudDateList=new ArrayList<String>();
		List<String> StudEventNameList=new ArrayList<String>();
		List<String> StudPlaceList=new ArrayList<String>();
		List<String> StudPositionList=new ArrayList<String>();
		List<String> StudTypeList=new ArrayList<String>();
		List<String> StudIdList=new ArrayList<String>();
		List<String> StudFirstName=new ArrayList<String>();
		//List<String> PaperAuthorList=new ArrayList<String>();
		//List<String> PaperNatIntList=new ArrayList<String>();
		//List<String> PaperIdList=new ArrayList<String>();
	
		List<String> ProjTitleList=new ArrayList<String>();
		List<String> ProjCoPartList=new ArrayList<String>();
		List<String> ProjDateList=new ArrayList<String>();
		List<String> ProjEventNameList=new ArrayList<String>();
		List<String> ProjPlaceList=new ArrayList<String>();
		List<String> ProjPositionList=new ArrayList<String>();
		List<String> ProjDomainList=new ArrayList<String>();
		List<String> ProjIdList=new ArrayList<String>();
		List<String> ProjDescList=new ArrayList<String>();
		List<String> ProjFirstName=new ArrayList<String>();
		try {
			currentCon=loginPackage.ConnectionManager.getConnection();
		
		
		stmt=currentCon.createStatement();
		
	
		id = loginPackage.LoginBean.getUserId();
		studQuery="select * from stud_achieve where verified = 0";
		rs = stmt.executeQuery(studQuery);
		 
		
		while(rs.next())
		{
			StudCoPartList.add(rs.getString("co_participants"));
			StudPlaceList.add(rs.getString("place"));
			StudEventNameList.add(rs.getString("event_name"));
			idForNameStud=(rs.getString("student_idstudent"));
			
			stringDate = rs.getString("date");
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
			StudPositionList.add(rs.getString("position"));
			StudIdList.add(rs.getString("idstud_achieve"));
			StudTypeList.add(rs.getString("type"));
			StudDateList.add(date);
			
			stmt=currentCon.createStatement();
			
			
			//id = loginPackage.LoginBean.getUserId();
			paperQuery="select * from student where idstudent =" + idForNameStud;
			rs5 = stmt.executeQuery(paperQuery);
				while(rs5.next())
				{
					StudFirstName.add( rs5.getString("first_name") + "  " + rs5.getString("last_name"));
				}
			//PaperVolList.add(rs.getString("position"));
			//PaperIssueList.add(rs.getString("issue"));
			//PaperPageNoList.add(rs.getString("page_no"));
			//PaperAuthorList.add(rs.getString("authors"));
			//nat = rs.getInt("natint");
			//if(nat == 0)
				//PaperNatIntList.add("National");
			//else
				//PaperNatIntList.add("International");
				
		}
	}catch(Throwable e){
		System.out.println(e);
	}
		try{
		currentCon=loginPackage.ConnectionManager.getConnection();
		
		
		stmt=currentCon.createStatement();	
		id = loginPackage.LoginBean.getUserId();
		projQuery="select * from project where verified = 0";
		rs1 = stmt.executeQuery(projQuery);
	
		while(rs1.next())
		{
			ProjTitleList.add(rs1.getString("title"));
			ProjCoPartList.add(rs1.getString("co_participants"));
			ProjPlaceList.add(rs1.getString("place"));
			ProjEventNameList.add(rs1.getString("event_name"));
			idForNameProj=(rs1.getString("student_idstudent"));
			
			
			stringDate = rs1.getString("date");
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
			ProjPositionList.add(rs1.getString("position"));
			ProjIdList.add(rs1.getString("idproject"));
			ProjDomainList.add(rs1.getString("domain"));
			ProjDescList.add(rs1.getString("description"));
			ProjDateList.add(date);
			
			stmt=currentCon.createStatement();	
			
			paperQuery="select * from student where idstudent =" + idForNameProj;
			rs6 = stmt.executeQuery(paperQuery);
				while(rs6.next())
				{
					ProjFirstName.add( rs6.getString("first_name") + "  " + rs6.getString("last_name"));
				}
		}
		}catch(Throwable e)
		{
			e.printStackTrace();
		}
		request.setAttribute("coPartStud", StudCoPartList);
		request.setAttribute("dateStud", StudDateList);
		request.setAttribute("eventNameStud", StudEventNameList);
		request.setAttribute("idStud", StudIdList);
		request.setAttribute("placeStud", StudPlaceList);
		request.setAttribute("positionStud", StudPositionList);
		request.setAttribute("typeStud", StudTypeList);
		request.setAttribute("firstNameStud", StudFirstName);
		
		//request.setAttribute("author", PaperAuthorList);
		//request.setAttribute("natint", PaperNatIntList);
		//request.setAttribute("Idpub", PaperIdList);
	
		//request.getRequestDispatcher("WEB-INF/adminpage.jsp").forward(request, response);
		request.setAttribute("titleProj", ProjTitleList);
		request.setAttribute("coPartProj", ProjCoPartList);
		request.setAttribute("dateProj", ProjDateList);
		request.setAttribute("eventNameProj", ProjEventNameList);
		request.setAttribute("idProj", ProjIdList);
		request.setAttribute("placeProj", ProjPlaceList);
		request.setAttribute("positionProj", ProjPositionList);
		request.setAttribute("domainProj", ProjDomainList);
		request.setAttribute("descProj", ProjDescList);
		request.setAttribute("firstNameProj", ProjFirstName);
		
		request.getRequestDispatcher("DeactivateServlet").forward(request, response);
	}

}
