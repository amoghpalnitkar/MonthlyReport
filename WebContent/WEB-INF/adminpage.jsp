<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  
<html>
  <%@page language="java" import="java.util.*" %>
  <head>
    
  </head>

<style type="text/css">
    <%@include file="../css/style.css" %>
</style>

  <script type="text/javascript">

  function getMyID(inputId)
  {

      var form = document.getElementById("searc");
      if(inputId=="search")
      {
    	  form.style.display = "inline";    


      }
      else
      {
	  form.style.display = "none";
      }

      var form = document.getElementById("pend");
      if(inputId=="pending")
      {
    	  form.style.display = "inline";    
      }
      else
      {
	  form.style.display = "none";
      }
      
      var form = document.getElementById("pendStud");
      if(inputId=="pendingStud")
      {
    	  form.style.display = "inline";    


      }
      else
      {
	  form.style.display = "none";
      }

      var form = document.getElementById("reminder");
      if(inputId=="sendReminders")
      {
    	  form.style.display = "inline";    


      }
      else
      {
	  form.style.display = "none";
      }
      
      var form = document.getElementById("deacti");
      if(inputId=="deactivate")
      {
    	  form.style.display = "inline";    


      }
      else
      {
	  form.style.display = "none";
      }

  }

  </script>


  <body class="mid1">
   <img src="Images/blank.PNG" class="mr" align="top" >
  
  <div id="margins">
   
<ul id="nav1">
	<li ><a class="tabbed first" href="#Search" id="search" onclick= "getMyID(this.id);">Search</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
	<li ><a class="tabbed" href="#Pending Approval" id="pending" onclick="getMyID(this.id)">Pending Approval</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
	<li ><a class="tabbed" href="#Pending Stud Approval" id="pendingStud" onclick="getMyID(this.id)">Pending Student Approval</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
	<li><a class="tabbed" href="#Deactivate" id="deactivate" onclick="getMyID(this.id)">Deactivate</a></li>
	<li><a class="tabbed" href="#Send Reminders" id="sendReminders" onclick="getMyID(this.id)">Send Reminders</a></li>
    <li><a class="tabbedright"  href="LoginPage.jsp">Sign Out</a></li>
  </ul>    
   
    </div>

     <!-- <div class="menu" id="searc">
	<iframe src="WEB-INF/adminsearch.jsp" width=300 height=820 style="display:inline" frameborder="0"></iframe>
	<iframe src="WEB-INF/adminsearchresults.jsp" width=800 height=820 style="display:inline" frameborder="0"></iframe>
   </div>
	  -->
	<div class="menu"  id="searc">
    
    <form action="SearchServlet" method="post">
    <br/>From<br/>
<input id="datepick1" size="20" name="start-date" />

<br/><br/>To<br/>
<input id="datepick2" size="20" name="end-date" />
<br><br>


<input type="checkbox" name="paper" value="Organized"/>Organized
<input type="radio" name="nt_organized" value="Numbering" checked="checked"/>Numbering
<input type="radio" name="nt_organized" value="Tabular"/>Tabular<br>
<br>
<input type="checkbox" name="paper" value="Conducted"/>Conducted
<input type="radio" name="nt_conducted" value="Numbering" checked="checked"/>Numbering
<input type="radio" name="nt_conducted" value="Tabular"/>Tabular<br>
<br>
<input type="checkbox" name="paper" value="Attended"/>Attended
<input type="radio" name="nt_attended" value="Numbering" checked="checked"/>Numbering
<input type="radio" name="nt_attended" value="Tabular"/>Tabular<br>
<br>
<input type="checkbox" name="paper" value="Publication"/>Publication
<input type="radio" name="nt_publication" value="Numbering" checked="checked"/>Numbering
<input type="radio" name="nt_publication" value="Tabular"/>Tabular<br>
<br>
<input type="checkbox" name="paper" value="Stud_achieve"/>Student Achievements
<input type="radio" name="nt_studachieve" value="Numbering" checked="checked"/>Numbering
<input type="radio" name="nt_studachieve" value="Tabular"/>Tabular<br>
<br>



<br><br>

<input type="submit"  value="Search">

<script type="text/javascript" src="JavaScript/datepickr.js"></script>
                <script type="text/javascript">
                        
                        new datepickr('datepick1', {
                            'dateFormat': 'y-m-d'
                    });
                        new datepickr('datepick2', {
                                'dateFormat': 'y-m-d'
                        });

                       
                </script>
                
    
    
    </form>
    </div>
     
	 
   
  <div class="menu"  id="pend">
    
    <form action="PendingServlet" method="get">
    <p class="makeBold">Publication:</p>
     <table id="paper" width="820" height="85" border="1" align="center" cellpadding="10" cellspacing="0" bordercolor="#000000">
 <tbody class ="scrollContent">
  <tr>
  <th width="131" height="27" bordercolor="#000000" bgcolor="#d3d3d3" >
    Name
  </th>
  <th width="131" height="27" bordercolor="#000000" bgcolor="#d3d3d3" >
    Title
  </th>
   <th width="141" bordercolor="#000000" bgcolor="#d3d3d3">
    Type
  </th>
  <th width="160" bordercolor="#000000" bgcolor="#d3d3d3">
    Published In
  </th>
   <th width="140" bordercolor="#000000" bgcolor="#d3d3d3">
    Date
  </th>
  <th width="131" height="33" bordercolor="#000000" bgcolor="#d3d3d3" >
    Volume
  </th>
   <th width="141" bordercolor="#000000" bgcolor="#d3d3d3">
    Issue
  </th>
  <th width="140" bordercolor="#000000" bgcolor="#d3d3d3">
    Page Number
  </th>
   <th width="140" bordercolor="#000000" bgcolor="#d3d3d3">
   Co-Authors
  </th>
  <th width="170" bordercolor="#000000" bgcolor="#d3d3d3">
    Scope
  </th>
  <th width="170" bordercolor="#000000" bgcolor="#d3d3d3">
    Verified
  </th>
  </tr>
  <% Iterator itr,itr1,itr2,itr3,itr4,itr5,itr6,itr7,itr8,itr9,itri;
int i=0;%>
<% 
List<String> data= (List<String>)request.getAttribute("name");
List<String> datatype= (List<String>)request.getAttribute("type");
List<String> date= (List<String>)request.getAttribute("date");
List<String> pubin= (List<String>)request.getAttribute("pubin");
List<String> vol= (List<String>)request.getAttribute("vol");
List<String> issue= (List<String>)request.getAttribute("issue");
List<String> pageno= (List<String>)request.getAttribute("pageno");
List<String> author= (List<String>)request.getAttribute("author");
List<String> natint= (List<String>)request.getAttribute("natint");
List<String> Idpub= (List<String>)request.getAttribute("Idpub");
List<String> firstName= (List<String>)request.getAttribute("firstName");


for (itr=data.iterator(),itr1=datatype.iterator(),itr2=date.iterator(),itr3=pubin.iterator(),itr4=vol.iterator(),itr5=issue.iterator(),itr6=pageno.iterator(),itr7=author.iterator(),itr8=natint.iterator(),itr9=firstName.iterator(),itri=Idpub.iterator(); itr.hasNext(); )
{
	String name1=(String)itr.next();
	String id = (String)itri.next();
%>
  <tr>
     <td align="center"><%=itr9.next()%></td>
    <td height="40" align="center"><%=name1%></td>
  
    <td align="center"><%=itr1.next()%></td>
    <td align="center"><%=itr2.next()%></td>
    <td align="center"><%=itr3.next()%></td>
    <td align="center"><%=itr4.next()%></td>
    <td align="center"><%=itr5.next()%></td>
    <td align="center"><%=itr6.next()%></td>
    <td align="center"><%=itr7.next()%></td>
    <td align="center"><%=itr8.next()%></td>
    <td><input type="checkbox" name="check" value="<%=id+":publication"%>"/>    &nbsp;   </td> 
  </tr>
  <%}%>
  </tbody>
  </table>

 <p class="makeBold">Conducted:</p>
  <table id="conducted " width="820" height="85" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#000000">
 <tbody class ="scrollContent">
 <tr>
 <th width="131" height="27" bordercolor="#000000" bgcolor="#d3d3d3" >
   Name
  </th>
  <th width="131" height="33" bordercolor="#000000" bgcolor="#d3d3d3" >
    Title
  </th>
   <th width="141" bordercolor="#000000" bgcolor="#d3d3d3">
    Type
  </th>
   <th width="160" bordercolor="#000000" bgcolor="#d3d3d3">
    Date
  </th>
  <th width="140" bordercolor="#000000" bgcolor="#d3d3d3">
    Days
  </th>
  <th width="160" bordercolor="#000000" bgcolor="#d3d3d3">
    Association
  </th>
  <th width="141" bordercolor="#000000" bgcolor="#d3d3d3">
    Sponsor
  </th>
  <th width="140" bordercolor="#000000" bgcolor="#d3d3d3">
    Place
  </th>
  <th width="170" bordercolor="#000000" bgcolor="#d3d3d3">
    No. Of Participants
  </th>
  <th width="170" bordercolor="#000000" bgcolor="#d3d3d3">
    Keynote
  </th>
   <th width="170" bordercolor="#000000" bgcolor="#d3d3d3">
    Verified
  </th>
  </tr>
  
  <%
  List<String> namecon= (List<String>)request.getAttribute("namecon");
  List<String> typecon= (List<String>)request.getAttribute("typecon");
  List<String> datecon= (List<String>)request.getAttribute("datecon");
  List<String> daycon= (List<String>)request.getAttribute("daycon");
  List<String> assocon= (List<String>)request.getAttribute("assocon");
  List<String> sponcon= (List<String>)request.getAttribute("sponsorcon");
  List<String> placecon= (List<String>)request.getAttribute("placecon");
  List<String> particon= (List<String>)request.getAttribute("particon");
  List<String> keycon= (List<String>)request.getAttribute("keycon");
  List<String> Idcon= (List<String>)request.getAttribute("Idcon");
  List<String> firstNamecon= (List<String>)request.getAttribute("firstNamecon");
  
  for (itr=namecon.iterator(),itr1=typecon.iterator(),itr2=datecon.iterator(),itr3=daycon.iterator(),itr4=assocon.iterator(),itr5=sponcon.iterator(),itr6=placecon.iterator(),itr7=particon.iterator(),itr8=keycon.iterator(),itr9=firstNamecon.iterator(),itri=Idcon.iterator(); itr.hasNext(); )
  {
	  String name1=(String)itr.next();
	  String id = (String)itri.next();	
	  %>
	    <tr>
	    <td align="center"><%=itr9.next()%></td>
	      <td height="40" align="center"><%=name1%></td>
	       
	      <td align="center"><%=itr1.next()%></td>
	      <td align="center"><%=itr2.next()%></td>
	      <td align="center"><%=itr3.next()%></td>
	      <td align="center"><%=itr4.next()%></td>
	      <td align="center"><%=itr5.next()%></td>
	      <td align="center"><%=itr6.next()%></td>
	      <td align="center"><%=itr7.next()%></td>
	      <td align="center"><%=itr8.next()%></td>
	      <td><input type="checkbox" name="check" value="<%=id+":conducted"%>"/>    &nbsp;   </td> 
	    </tr>
	    <% } %>
	    </tbody>
</table>

<p class="makeBold">Attended:</p>	    
	<table id="attended " width="820" height="85" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#000000">
 <tbody class ="scrollContent">
 <tr>
 <th width="131" height="33" bordercolor="#000000" bgcolor="#d3d3d3" >
   Name
  </th>
  <th width="131" height="33" bordercolor="#000000" bgcolor="#d3d3d3" >
    Title
  </th>
   <th width="141" bordercolor="#000000" bgcolor="#d3d3d3">
    Type
  </th>
   <th width="160" bordercolor="#000000" bgcolor="#d3d3d3">
    Date
  </th>
  <th width="140" bordercolor="#000000" bgcolor="#d3d3d3">
    Days
  </th>
  <th width="160" bordercolor="#000000" bgcolor="#d3d3d3">
    Association
  </th>
  <th width="141" bordercolor="#000000" bgcolor="#d3d3d3">
    Verified
  </th>
  </tr>
  
	    
<%
	List<String> nameatt= (List<String>)request.getAttribute("nameatt");
  List<String> typeatt= (List<String>)request.getAttribute("typeatt");
  List<String> dateatt= (List<String>)request.getAttribute("dateatt");
  List<String> dayatt= (List<String>)request.getAttribute("dayatt");
  List<String> assoatt= (List<String>)request.getAttribute("assoatt");
  List<String> Idatt= (List<String>)request.getAttribute("Idatt");
  List<String> firstNameatt= (List<String>)request.getAttribute("firstNameatt");
  
  for(itr=nameatt.iterator(),itr1=typeatt.iterator(),itr2=dateatt.iterator(),itr3=dayatt.iterator(),itr4=assoatt.iterator(),itr5=firstNameatt.iterator(),itri=Idatt.iterator();itr.hasNext(); )
  {
	  String name1=(String)itr.next();
	  String id = (String)itri.next();	
	  %>
	    <tr>
	     <td align="center"><%=itr5.next()%></td>
	      
	      <td height="40" align="center"><%=name1%></td>
	      <td align="center"><%=itr1.next()%></td>
	      <td align="center"><%=itr2.next()%></td>
	      <td align="center"><%=itr3.next()%></td>
	      <td align="center"><%=itr4.next()%></td>

	      <td><input type="checkbox" name="check" value="<%=id+":attended"%>"/>    &nbsp;   </td> 
	    </tr>
	    <% } %>
  </tbody>
  </table>
  
<p class="makeBold">Organized:</p>
  <table id="organized "  width="820" height="85" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#000000">
 <tbody class ="scrollContent">
 <tr>
 <th width="131" height="27" bordercolor="#000000" bgcolor="#d3d3d3" >
    Name
  </th>
  <th width="131" height="33" bordercolor="#000000" bgcolor="#d3d3d3" >
    Title
  </th>
   <th width="141" bordercolor="#000000" bgcolor="#d3d3d3">
    Type
  </th>
   <th width="160" bordercolor="#000000" bgcolor="#d3d3d3">
    Date
  </th>
  <th width="140" bordercolor="#000000" bgcolor="#d3d3d3">
    Days
  </th>
  <th width="160" bordercolor="#000000" bgcolor="#d3d3d3">
    Association
  </th>
  <th width="141" bordercolor="#000000" bgcolor="#d3d3d3">
    Sponsor
  </th>
  <th width="140" bordercolor="#000000" bgcolor="#d3d3d3">
    Place
  </th>
  <th width="170" bordercolor="#000000" bgcolor="#d3d3d3">
    No. Of Participants
  </th>
  <th width="170" bordercolor="#000000" bgcolor="#d3d3d3">
    Speaker
  </th>
   <th width="170" bordercolor="#000000" bgcolor="#d3d3d3">
    Verified
  </th>
  </tr>
  
  <%
  List<String> nameorg= (List<String>)request.getAttribute("nameorg");
  List<String> typeorg= (List<String>)request.getAttribute("typeorg");
  List<String> dateorg= (List<String>)request.getAttribute("dateorg");
  List<String> dayorg= (List<String>)request.getAttribute("dayorg");
  List<String> assoorg= (List<String>)request.getAttribute("assoorg");
  List<String> sponorg= (List<String>)request.getAttribute("sponsororg");
  List<String> placeorg= (List<String>)request.getAttribute("placeorg");
  List<String> partiorg= (List<String>)request.getAttribute("partiorg");
  List<String> speakorg= (List<String>)request.getAttribute("speakorg");
  List<String> Idorg= (List<String>)request.getAttribute("Idorg");
  List<String> firstNameorg= (List<String>)request.getAttribute("firstNameorg");

  
  for (itr=nameorg.iterator(),itr1=typeorg.iterator(),itr2=dateorg.iterator(),itr3=dayorg.iterator(),itr4=assoorg.iterator(),itr5=sponorg.iterator(),itr6=placeorg.iterator(),itr7=partiorg.iterator(),itr8=speakorg.iterator(),itr9=firstNameorg.iterator(),itri=Idorg.iterator(); itr.hasNext(); )
  {
	  String name1=(String)itr.next();
	  String id = (String)itri.next();
	  %>
	    <tr>
	    <td align="center"><%=itr9.next()%></td>
	      <td height="40" align="center"><%=name1%></td>
	       
	      <td align="center"><%=itr1.next()%></td>
	      <td align="center"><%=itr2.next()%></td>
	      <td align="center"><%=itr3.next()%></td>
	      <td align="center"><%=itr4.next()%></td>
	      <td align="center"><%=itr5.next()%></td>
	      <td align="center"><%=itr6.next()%></td>
	      <td align="center"><%=itr7.next()%></td>
	      <td align="center"><%=itr8.next()%></td>
	      <td> &nbsp;<input type="checkbox" name="check" value="<%=id+":organized"%>"/> </td> 
	    </tr>
	    <% } %>
</tbody>
  </table>
  
  <input type="submit" value="Verify">
  </form>
    </div>
    
    
     <div class="menu"  id="pendStud">
    <form action="PendingStudServlet" method="get">
  
<p class="makeBold">Student Achivements:</p>
  <table id="studentAchieve "  width="820" height="85" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#000000">
 <tbody class ="scrollContent">
 <tr>
 <th width="131" height="33" bordercolor="#000000" bgcolor="#d3d3d3" >
	Name
  </th>
 
  <th width="131" height="33" bordercolor="#000000" bgcolor="#d3d3d3" >
    Co-Participants
  </th>
   <th width="141" bordercolor="#000000" bgcolor="#d3d3d3">
    Date
  </th>
   <th width="160" bordercolor="#000000" bgcolor="#d3d3d3">
    Event-Name
  </th>
  <th width="140" bordercolor="#000000" bgcolor="#d3d3d3">
    Place
  </th>
  <th width="160" bordercolor="#000000" bgcolor="#d3d3d3">
    Position
  </th>
  <th width="141" bordercolor="#000000" bgcolor="#d3d3d3">
    Type
   <th width="170" bordercolor="#000000" bgcolor="#d3d3d3">
    Verified
  </th>
  </tr>
  
  <%
  List<String> coPartStud= (List<String>)request.getAttribute("coPartStud");
  List<String> dateStud= (List<String>)request.getAttribute("dateStud");
  List<String> eventNameStud= (List<String>)request.getAttribute("eventNameStud");
  List<String> placeStud= (List<String>)request.getAttribute("placeStud");
  List<String> positionStud= (List<String>)request.getAttribute("positionStud");
  List<String> typeStud= (List<String>)request.getAttribute("typeStud");
  List<String> IdStud= (List<String>)request.getAttribute("idStud");
  List<String> firstNameStud= (List<String>)request.getAttribute("firstNameStud");
  
  for (itr=coPartStud.iterator(),itr1=dateStud.iterator(),itr2=eventNameStud.iterator(),itr3=placeStud.iterator(),itr4=positionStud.iterator(),itr5=typeStud.iterator(),itr6=IdStud.iterator(),itr7=firstNameStud.iterator(); itr.hasNext(); )
  {
	  //String name1=(String)itr2.next();
	  String id = (String)itr6.next();
	  %>
	    <tr>
	     <td align="center"><%=itr7.next()%></td>
	      <td align="center"><%=itr.next()%></td>
	      <td align="center"><%=itr1.next()%></td>
	      <td align="center"><%=itr2.next()%></td>
	      <td align="center"><%=itr3.next()%></td>
	      <td align="center"><%=itr4.next()%></td>
	      <td align="center"><%=itr5.next()%></td>
	      <td> &nbsp;<input type="checkbox" name="checkStud" value="<%=id+":stud_achieve"%>"/> </td> 
	    </tr>
	    <% } %>
</tbody>
  </table>
  
    
  <p class="makeBold">Project:</p>
  <table id="studentAchieve "  width="820" height="85" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#000000">
 <tbody class ="scrollContent">
 <tr>
 <th width="131" height="33" bordercolor="#000000" bgcolor="#d3d3d3" >
	Name
  </th>
 <th width="131" height="33" bordercolor="#000000" bgcolor="#d3d3d3" >
    Title
  </th>
  <th width="131" height="33" bordercolor="#000000" bgcolor="#d3d3d3" >
    Co-Participants
  </th>
   <th width="141" bordercolor="#000000" bgcolor="#d3d3d3">
    Date
  </th>
   <th width="160" bordercolor="#000000" bgcolor="#d3d3d3">
    Event-Name
  </th>
  <th width="140" bordercolor="#000000" bgcolor="#d3d3d3">
    Place
  </th>
  <th width="160" bordercolor="#000000" bgcolor="#d3d3d3">
    Position
  </th>
  <th width="141" bordercolor="#000000" bgcolor="#d3d3d3">
    Domain</th>
    <th width="141" bordercolor="#000000" bgcolor="#d3d3d3">
    Description</th>
   <th width="170" bordercolor="#000000" bgcolor="#d3d3d3">
    Verified
  </th>
  </tr>
  
  <%
  List<String> coPartProj= (List<String>)request.getAttribute("coPartProj");
  List<String> dateProj= (List<String>)request.getAttribute("dateProj");
  List<String> eventNameProj= (List<String>)request.getAttribute("eventNameProj");
  List<String> placeProj= (List<String>)request.getAttribute("placeProj");
  List<String> positionProj= (List<String>)request.getAttribute("positionProj");
  List<String> domainProj= (List<String>)request.getAttribute("domainProj");
  List<String> descProj= (List<String>)request.getAttribute("descProj");
  List<String> IdProj= (List<String>)request.getAttribute("idProj");
  List<String> titleProj= (List<String>)request.getAttribute("titleProj");
  List<String> firstNameProj= (List<String>)request.getAttribute("firstNameProj");
  
  for (itr=coPartProj.iterator(),itr1=dateProj.iterator(),itr2=eventNameProj.iterator(),itr3=placeProj.iterator(),itr4=positionProj.iterator(),itr5=domainProj.iterator(),itr6=descProj.iterator(),itr7=IdProj.iterator(),itr8=titleProj.iterator(),itr8=firstNameProj.iterator(); itr.hasNext(); )
  {
	  //String name1=(String)itr2.next();
	  String id = (String)itr7.next();
	  %>
	    <tr>
	      <td align="center"><%=itr8.next()%></td>
	      <td align="center"><%=itr.next()%></td>
	      <td align="center"><%=itr1.next()%></td>
	      <td align="center"><%=itr2.next()%></td>
	      <td align="center"><%=itr3.next()%></td>
	      <td align="center"><%=itr4.next()%></td>
	      <td align="center"><%=itr5.next()%></td>
	       <td align="center"><%=itr6.next()%></td>
	      <td> &nbsp;<input type="checkbox" name="checkStud" value="<%=id+":project"%>"/> </td> 
	    </tr>
	    <% } %>
</tbody>
 
  </table>

   
    <input type="submit" value="Verify">
    </form>
    
    </div>
    <form method = "POST" action = "emailSendingServlet">
    <div class="menu"  id="reminder">
    
      <p>Please send the mails</p>
      <br/>From<br/>
		<input id="datepick1" size="20" name="start-date" />

		<br/><br/>To<br/>
		<input id="datepick2" size="20" name="end-date" />
		<br><br>
      <br/><input type="submit" value="Send"/>
  
    </div>
	</form>
	<div class="menu" id="deacti">
	
	<form action="DeactivateServlet" method="get">
	 <table id="deact" width="820" height="85" border="1" align="center" cellpadding="10" cellspacing="0" bordercolor="#000000">
 <tbody class ="scrollContent">
  <tr>
  <th width="131" height="27" bordercolor="#000000" bgcolor="#d3d3d3" >
    First name
  </th>
   <th width="141" bordercolor="#000000" bgcolor="#d3d3d3">
    Last name
  </th>
  <th width="160" bordercolor="#000000" bgcolor="#d3d3d3">
    Department
  </th>
  
  </tr>
 <% Iterator ditr,ditr1,ditr2,ditri;
 int di=0;%>
<% 
List<String> fname= (List<String>)request.getAttribute("firstname");
List<String> lname= (List<String>)request.getAttribute("lastname");
List<String> dept= (List<String>)request.getAttribute("department");
List<String> iduser= (List<String>)request.getAttribute("Iduser");
for (ditr=fname.iterator(),ditr1=lname.iterator(),ditr2=dept.iterator(),ditri=iduser.iterator(); ditr.hasNext(); )
{
	String name2=(String)ditr.next();
	String id1 = (String)ditri.next();
	
%>
  <tr>
    <td height="40" align="center"><%=name2%></td>
    <td align="center"><%=ditr1.next()%></td>
    <td align="center"><%=ditr2.next()%></td>
    <td><input type="checkbox" name="check" value="<%=id1%>"/>    &nbsp;   </td> 
  </tr>
  <%}%>
  </tbody>
  </table>
  
   <input type="submit" value="Deactivate">
	</form>
	</div>
	
  </body>
  
  <script type="text/javascript" src="JavaScript/datepickr.js"></script>
                <script type="text/javascript">
                        
                        new datepickr('datepick1', {
                            'dateFormat': 'd/m/y'
                    });
                        new datepickr('datepick2', {
                                'dateFormat': 'd/m/y'
                        });

                       
                </script>
</html>