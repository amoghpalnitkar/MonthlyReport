package retrievePackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PendingServlet
 */
@WebServlet("/PendingServlet")
public class PendingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    String paperQuery,conQuery,attQuery,orgQuery,stringDate,date,updateQuery,idForNamePub,idForNameAtt,idForNameCon,idForNameOrg,firstNamePub,firstNameAtt,firstNameOrg,firstNameCon;
    Connection currentCon;
    ResultSet rs,rs1,rs2,rs3,rs4,rs5,rs6,rs7;
    Statement stmt;
    int id,nat;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PendingServlet() {
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
		System.out.println("in pending servlet get");
		String[] checkboxes=request.getParameterValues("check");
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
		
	}
	request.getRequestDispatcher("PendingServletdummy").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<String> PaperNameList=new ArrayList<String>();
		List<String> PaperTypeList=new ArrayList<String>();
		List<String> PaperPubInList=new ArrayList<String>();
		List<String> PaperDateList=new ArrayList<String>();
		List<String> PaperVolList=new ArrayList<String>();
		List<String> PaperIssueList=new ArrayList<String>();
		List<String> PaperPageNoList=new ArrayList<String>();
		List<String> PaperAuthorList=new ArrayList<String>();
		List<String> PaperNatIntList=new ArrayList<String>();
		List<String> PaperIdList=new ArrayList<String>();
		List<String> PaperFirstName=new ArrayList<String>();
		
		System.out.println("In Pending Servlet post");
		
		try {
			currentCon=loginPackage.ConnectionManager.getConnection();
		
		
		stmt=currentCon.createStatement();
		
	
		id = loginPackage.LoginBean.getUserId();
		paperQuery="select * from publication where verified = 0";
		rs = stmt.executeQuery(paperQuery);
		 
		
		while(rs.next())
		{
			PaperNameList.add(rs.getString("title"));
			PaperTypeList.add(rs.getString("type"));
			PaperPubInList.add(rs.getString("published_in"));
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
			idForNamePub = rs.getString("user_iduser");
			PaperIdList.add(rs.getString("idpublication"));
			PaperDateList.add(date);
			PaperVolList.add(rs.getString("volume"));
			PaperIssueList.add(rs.getString("issue"));
			PaperPageNoList.add(rs.getString("page_no"));
			PaperAuthorList.add(rs.getString("authors"));
			nat = rs.getInt("natint");
			if(nat == 0)
				PaperNatIntList.add("National");
			else
				PaperNatIntList.add("International");
			
			stmt=currentCon.createStatement();
			
			
			id = loginPackage.LoginBean.getUserId();
			paperQuery="select * from  user where iduser =" + idForNamePub;
			rs4 = stmt.executeQuery(paperQuery);
			while(rs4.next())
			{
				firstNamePub = rs4.getString("first_name");
				PaperFirstName.add(firstNamePub + "  " + rs4.getString("last_name"));
			}
				
		}

		
	}catch(Throwable e){
		System.out.println(e);
	}
		
		
		List<String> ConductedNameList=new ArrayList<String>();
		List<String> ConductedTypeList=new ArrayList<String>();
		List<String> ConductedDateList=new ArrayList<String>();
		List<String> ConductedDaysList=new ArrayList<String>();
		List<String> ConductedAssociationList=new ArrayList<String>();
		List<String> ConductedSponsorList=new ArrayList<String>();
		List<String> ConductedPlaceList=new ArrayList<String>();
		List<String> ConductedParticipantList=new ArrayList<String>();
		List<String> ConductedKeynoteList=new ArrayList<String>();
		List<String> ConductedIdList=new ArrayList<String>();
		List<String> ConductedFirstName=new ArrayList<String>();
		
		System.out.println("In Pending Servlet post");
		
		try {
			currentCon=loginPackage.ConnectionManager.getConnection();
		
		
		stmt=currentCon.createStatement();
		
	
		id = loginPackage.LoginBean.getUserId();
		conQuery="select * from conducted where verified = 0";
		rs1 = stmt.executeQuery(conQuery);
		 
		
		while(rs1.next())
		{
			ConductedIdList.add(rs1.getString("idconducted"));
			ConductedNameList.add(rs1.getString("name"));
			ConductedTypeList.add(rs1.getString("type"));
			ConductedDaysList.add(rs1.getString("no_of_days"));
			idForNameCon = rs1.getString("user_iduser");
			stringDate = rs1.getString("start_date");
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
			ConductedDateList.add(date);
			
			ConductedAssociationList.add(rs1.getString("association"));
			ConductedSponsorList.add(rs1.getString("sponsor"));
			ConductedPlaceList.add(rs1.getString("place"));
			ConductedParticipantList.add(rs1.getString("no_of_participant"));
			ConductedKeynoteList.add(rs1.getString("association"));
			
			
			System.out.println(rs1.getString("name"));
		
			nat = rs1.getInt("keynote");
			if(nat == 0)
				ConductedKeynoteList.add("Speaker");
			else
				ConductedKeynoteList.add("Keynote");
			stmt=currentCon.createStatement();
			
			
			//id = loginPackage.LoginBean.getUserId();
			paperQuery="select * from  user where iduser =" + idForNameCon;
			rs5 = stmt.executeQuery(paperQuery);
				while(rs5.next())
				{
					firstNameCon = rs5.getString("first_name");
					ConductedFirstName.add(firstNameCon + "  " + rs5.getString("last_name"));
				}
				
		}
	
	
		}catch(Throwable e){
		System.out.println(e);
	}

		
		
		List<String> AttendedNameList=new ArrayList<String>();
		List<String> AttendedTypeList=new ArrayList<String>();
		List<String> AttendedDateList=new ArrayList<String>();
		List<String> AttendedDaysList=new ArrayList<String>();
		List<String> AttendedAssociationList=new ArrayList<String>();
		List<String> AttendedIdList=new ArrayList<String>();
		List<String> AttendedFirstName=new ArrayList<String>();
		
		System.out.println("In Pending Servlet post");
		
		try {
			currentCon=loginPackage.ConnectionManager.getConnection();
		
		
		stmt=currentCon.createStatement();
		
	
		id = loginPackage.LoginBean.getUserId();
		attQuery="select * from attended where verified = 0";
		rs2 = stmt.executeQuery(attQuery);
		 
		
		while(rs2.next())
		{
			AttendedIdList.add(rs2.getString("idattended"));
			AttendedNameList.add(rs2.getString("name"));
			AttendedTypeList.add(rs2.getString("type"));
			AttendedDaysList.add(rs2.getString("no_of_days"));
			idForNameAtt = rs2.getString("user_iduser");
			
			stringDate = rs2.getString("start_date");
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
			AttendedDateList.add(date);
			AttendedAssociationList.add(rs2.getString("association"));
			
			stmt=currentCon.createStatement();
			
			
			id = loginPackage.LoginBean.getUserId();
			paperQuery="select * from  user where iduser =" + idForNameAtt;
			rs7 = stmt.executeQuery(paperQuery);
			while(rs7.next())
			{
				firstNameAtt = rs7.getString("first_name");
				AttendedFirstName.add(firstNameAtt + "  " + rs7.getString("last_name"));
			}
			
			
			System.out.println(rs2.getString("name"));			
		}
	}catch(Throwable e){
		System.out.println(e);
	}
		
		
		List<String> OrganizedNameList=new ArrayList<String>();
		List<String> OrganizedTypeList=new ArrayList<String>();
		List<String> OrganizedDateList=new ArrayList<String>();
		List<String> OrganizedDaysList=new ArrayList<String>();
		List<String> OrganizedAssociationList=new ArrayList<String>();
		List<String> OrganizedSponsorList=new ArrayList<String>();
		List<String> OrganizedPlaceList=new ArrayList<String>();
		List<String> OrganizedParticipantList=new ArrayList<String>();
		List<String> OrganizedSpeakerList=new ArrayList<String>();
		List<String> OrganizedIdList=new ArrayList<String>();
		List<String> OrganizedFirstName=new ArrayList<String>();
		
		System.out.println("In Pending Servlet post");
		
		try {
			currentCon=loginPackage.ConnectionManager.getConnection();
		
		
		stmt=currentCon.createStatement();
		
	
		id = loginPackage.LoginBean.getUserId();
		orgQuery="select * from organized where verified = 0";
		rs3 = stmt.executeQuery(orgQuery);
		 
		
		while(rs3.next())
		{
			OrganizedIdList.add(rs3.getString("idorganized"));
			OrganizedNameList.add(rs3.getString("name"));
			OrganizedTypeList.add(rs3.getString("type"));
			OrganizedDaysList.add(rs3.getString("no_of_days"));
			idForNameOrg = rs3.getString("user_iduser");
			stringDate = rs3.getString("start_date");
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
			OrganizedDateList.add(date);
			
			OrganizedAssociationList.add(rs3.getString("association"));
			OrganizedSponsorList.add(rs3.getString("sponsor"));
			OrganizedPlaceList.add(rs3.getString("place"));
			OrganizedParticipantList.add(rs3.getString("no_of_participant"));
			OrganizedSpeakerList.add(rs3.getString("association"));
			
			stmt=currentCon.createStatement();
			
			
			id = loginPackage.LoginBean.getUserId();
			paperQuery="select * from  user where iduser =" + idForNameOrg;
			rs6 = stmt.executeQuery(paperQuery);
			while(rs6.next())
			{
				firstNameOrg = rs6.getString("first_name");
				OrganizedFirstName.add(firstNameOrg + "  " + rs6.getString("last_name"));
			}
			
				
		}
	}catch(Throwable e){
		System.out.println(e);
	}
		
		
		request.setAttribute("name", PaperNameList);
		request.setAttribute("type", PaperTypeList);
		request.setAttribute("pubin", PaperPubInList);
		request.setAttribute("date", PaperDateList);
		request.setAttribute("vol", PaperVolList);
		request.setAttribute("issue", PaperIssueList);
		request.setAttribute("pageno", PaperPageNoList);
		request.setAttribute("author", PaperAuthorList);
		request.setAttribute("natint", PaperNatIntList);
		request.setAttribute("Idpub", PaperIdList);
		request.setAttribute("firstName", PaperFirstName);

		request.setAttribute("namecon", ConductedNameList);
		request.setAttribute("typecon", ConductedTypeList);
		request.setAttribute("datecon", ConductedDateList);
		request.setAttribute("daycon", ConductedDaysList);
		request.setAttribute("assocon", ConductedAssociationList);
		request.setAttribute("sponsorcon", ConductedSponsorList);
		request.setAttribute("placecon", ConductedPlaceList);
		request.setAttribute("particon", ConductedParticipantList);
		request.setAttribute("keycon", ConductedKeynoteList);
		request.setAttribute("Idcon", ConductedIdList);
		request.setAttribute("firstNamecon", ConductedFirstName);

		
		
		request.setAttribute("nameatt", AttendedNameList);
		request.setAttribute("typeatt", AttendedTypeList);
		request.setAttribute("dateatt", AttendedDateList);
		request.setAttribute("dayatt", AttendedDaysList);
		request.setAttribute("assoatt", AttendedAssociationList);
		request.setAttribute("Idatt", AttendedIdList);
		request.setAttribute("firstNameatt", AttendedFirstName);

		
		request.setAttribute("nameorg", OrganizedNameList);
		request.setAttribute("typeorg", OrganizedTypeList);
		request.setAttribute("dateorg", OrganizedDateList);
		request.setAttribute("dayorg", OrganizedDaysList);
		request.setAttribute("assoorg", OrganizedAssociationList);
		request.setAttribute("sponsororg", OrganizedSponsorList);
		request.setAttribute("placeorg", OrganizedPlaceList);
		request.setAttribute("partiorg", OrganizedParticipantList);
		request.setAttribute("speakorg", OrganizedSpeakerList);
		request.setAttribute("Idorg", OrganizedIdList);
		request.setAttribute("firstNameorg", OrganizedFirstName);
		
		
		request.getRequestDispatcher("PendingStudServlet").forward(request, response);
	}
}
