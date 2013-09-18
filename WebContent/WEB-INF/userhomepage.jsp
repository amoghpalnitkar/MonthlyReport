
<html>
  
  <head>
    
  </head>
<%@page language="java" import="java.util.*" %>
<style type="text/css">
    <%@include file="../css/style.css" %>
</style>

  <script type="text/javascript">

  function getNone()
  {
	  var form = document.getElementById("ppr");
	  form.style.display = "none";
  }
  function getMyID(inputId)
  {

      var form = document.getElementById("ppr");
      if(inputId=="paper")
      {
    	  form.style.display = "inline";    

      }
      else
      {
	  form.style.display = "none";
      }

      var form = document.getElementById("att");
      if(inputId=="attended")
      {
    	  form.style.display = "inline";    

      }
      else
      {
	  form.style.display = "none";
      }

      var form = document.getElementById("org");
      if(inputId=="organized")
      {
    	  form.style.display = "inline";    


      }
      else
      {
	  form.style.display = "none";
      }

      var form = document.getElementById("con");
      if(inputId=="conducted")
      {
    	  form.style.display = "inline";    


      }
      else
      {
	  form.style.display = "none";
      }
      
      var form = document.getElementById("summary");
      if(inputId=="summ")
      {
    	  form.style.display = "inline";  

      }
      else
      {
	  	form.style.display = "none";
      }

  }
function getCheckedValue(radioObj) {
	if(!radioObj)
		return "";
	var radioLength = radioObj.length;
	if(radioLength == undefined)
		if(radioObj.checked)
			return radioObj.value;
		else
			return "";
	for(var i = 0; i < radioLength; i++) {
		if(radioObj[i].checked) {
			return radioObj[i].value;
		}
	}
	return "";
}
	function checkname(type)
	{
		name=type+'-name';
	if(document.getElementById(name).value.length==0)
		{
			//document.getElementById('test').innerHTML = document.getElementById('test').innerHTML + " Cannot leave blank";	
			return " Name";
		}
		return "";
	}
	
	function checkdate(type)
	{
		name=type+'-date';
	if(document.getElementById(name).value.length==0)
		{
			//document.getElementById('test').innerHTML = document.getElementById('test').innerHTML + " Cannot leave blank";	
			return " Date";
		}
		return "";
	}
	function checkasso(type)
	{
		name=type+'-asso';
	if(document.getElementById(name).value.length==0)
		{
			//document.getElementById('test').innerHTML = document.getElementById('test').innerHTML + " Cannot leave blank";	
			return " Association";
		}
		return "";
	}
	function checksponsor(type)
	{
		name=type+'-sponsor';
	if(document.getElementById(name).value.length==0)
		{
			//document.getElementById('test').innerHTML = document.getElementById('test').innerHTML + " Cannot leave blank";	
			return " Sponsor";
		}
		return "";
	}
	
	function checkplace(type)
	{
		name=type+'-place';
	if(document.getElementById(name).value.length==0)
		{
			//document.getElementById('test').innerHTML = document.getElementById('test').innerHTML + " Cannot leave blank";	
			return " Place";
		}
		return "";
	}
	
	function checknumpartic(type)
	{
		name=type+'-numpartic';
	if(document.getElementById(name).value.length==0)
		{
			//document.getElementById('test').innerHTML = document.getElementById('test').innerHTML + " Cannot leave blank";	
			return " No of particpants";
		}
		return "";
	}
	
	function checkpublished(type)
	{
		name=type+ '-published';
	if(document.getElementById(name).value.length==0)
		{
			//document.getElementById('test').innerHTML = document.getElementById('test').innerHTML + " Cannot leave blank";	
			return " Published";
		}
		return "";
	}
	
	function checkvolume(type)
	{
		name=type+ '-volume';
	if(document.getElementById(name).value.length==0)
		{
			//document.getElementById('test').innerHTML = document.getElementById('test').innerHTML + " Cannot leave blank";	
			return " Volume";
		}
		return "";
	}
	
	function checkissue(type)
	{
		name=type+ '-issue';
	if(document.getElementById(name).value.length==0)
		{
			//document.getElementById('test').innerHTML = document.getElementById('test').innerHTML + " Cannot leave blank";	
			return " Issue";
		}
		return "";
	}
	
	function checkpageno(type)
	{
		name=type+ '-pageno';
	if(document.getElementById(name).value.length==0 )
		{
			//document.getElementById('test').innerHTML = document.getElementById('test').innerHTML + " Cannot leave blank";	
			return " PageNo";
		}
		return "";
	}
	
	function checkauthor(type)
	{
		name=type+ '-author';
	if(document.getElementById(name).value.length==0)
		{
			//document.getElementById('test').innerHTML = document.getElementById('test').innerHTML + " Cannot leave blank";	
			return " Author";
		}
		return "";
	}
	
	function checkType()
	{
		if(isNaN(document.getElementById('org-numpartic').value))
		{
			document.getElementById('numpart').innerHTML = "Enter numeric data";
			return false;
		}
		else
		{
			document.getElementById('numpart').innerHTML = "";
			return true;
		}
	}
	
	function checkTypecondays()
	{
		if(isNaN(document.getElementById('con-numdays').value))
		{
			document.getElementById('numdays-con').innerHTML = "Enter numeric data";
			return false;
		}
		else
		{
			document.getElementById('numdays-con').innerHTML = "";
			return true;
		}
	}
	
	function checkTypeattdays()
	{
		if(isNaN(document.getElementById('att-numdays').value))
		{
			document.getElementById('numdays-att').innerHTML = "Enter numeric data";
			return false;
		}
		else
		{
			document.getElementById('numdays-att').innerHTML = "";
			return true;
		}
	}
	
	function checkTypedays()
	{
		if(isNaN(document.getElementById('org-numberdays').value))
		{
			document.getElementById('numdays').innerHTML = "Enter numeric data";
			return false;
		}
		else
		{
			document.getElementById('numdays').innerHTML = "";
			return true;
		}
	}
	
	function validate(type)
	{
		
		
		var reason="";
		
			
		reason+=checkname(type);
		if(type!="ppr")
		reason+=checkasso(type);
		if(type=="org" || type=="con" )
		{	
			reason+=checksponsor(type);
			reason+=checkplace(type);
			reason+=checknumpartic(type);
			

		}	
		if(type=="ppr")
		{
			reason+=checkpublished(type);
			reason+=checkvolume(type);
			reason+=checkissue(type);
			reason+=checkpageno(type);
			reason+=checkauthor(type);
		}
		if(reason!="")
			{
				alert("Fill all the fields" + reason);
				return false;
			}
		
		if(type=="org")
		{
			if(!checkType() || !checkTypedays())
			{
				return false;
			}
		}
		
		if(type=="att")
		{
			if(!checkTypeattdays())
				return false;
				
		}
		
		if(type=="con")
		{
			if(!checkTypecondays())
				return false;
				
		}
		
		return true;
		
	}

  </script>


  <body class="mid1">
  <img src="Images/blank.PNG" class="mr" align="top" >
  
<div id="margins">

      <ul id="nav1">
	<li><a class="tabbed first" href="#Paper" id="paper" onclick= "getMyID(this.id);">Paper</a></li>
	<li ><a class="tabbed" href="#Attended" id="attended" onclick="getMyID(this.id)">Attended</a></li>
	<li ><a class="tabbed" href="#Organized" id="organized" onclick="getMyID(this.id)">Organized</a></li>
	<li ><a class="tabbed" href="#Conducted" id="conducted" onclick="getMyID(this.id)">Conducted</a></li>
    <li ><a class="tabbed last" href="#Summary" id="summ" onclick="getMyID(this.id)">Summary</a></li>
 	<li><a class="tabbedright"  href="LoginPage.jsp">Sign Out</a></li>
        </ul>
     
   
    
<%Iterator<String> itr,itr1,itr2;%>
<form method="post" action="OrgAddServlet" onsubmit="return validate('org')">
    <div class="menu" id="org">
      Title:<input  type="text" name="org-name" id="org-name"></input>
      Type:
      <select id="" name="org-type" onchange="">
	<option>Seminar</option>
	<option>Workshop</option>
	<option>FDP</option>
      </select>
     Date:<br> 
      <input id="datepick3" size="20" name="org-date" id="org-date"/>
     <br> <br>
     <div id="numdays"></div>
     Number of days:<input name="org-numberdays" type="text" value="1" id="org-numberdays" onKeyUp="checkTypedays()"></input>
      Association <br> <input  name="org-asso" type="text" id="org-asso"></input>
      Sponsor <input   name="org-sponsor" type="text" id="org-sponsor"></input>
      Place <input   name="org-place" type="text" id="org-place"></input>
      <div id="numpart"></div>
      Number of participants <input type="text" name="org-numpartic" value="0" id="org-numpartic" onKeyUp="checkType()"></input>
      Speaker<input  type="text"  name="org-speaker" id="org-speaker"></input>
      <input type="submit" value="Submit">
      
      <table class="position_side" width="420" height="85" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#000000">
<tbody class ="scrollContent">
 <tr>
  <th width="131" height="33" bordercolor="#000000" bgcolor="#d3d3d3" >
    Title
  </th>
   <th width="141" bordercolor="#000000" bgcolor="#d3d3d3">
    Type
  </th>
  <th width="140" bordercolor="#000000" bgcolor="#d3d3d3">
    Category
  </th>
   <th width="140" bordercolor="#000000" bgcolor="#d3d3d3">
    Date
  </th>
  </tr>
        <%
        List<String> data2= (List<String>)request.getAttribute("name2");
        List<String> datatype2= (List<String>)request.getAttribute("type2");
        List<String> date2= (List<String>)request.getAttribute("date2");
for (itr=data2.iterator(),itr1=datatype2.iterator(),itr2=date2.iterator(); itr.hasNext(); )
{
	String name1=(String)itr.next();
	String dat1=(String)itr2.next();
%>
  <tr>
     <td height="50" align="center"><a href="RetrieveServlet?param=organised&name=<%=name1%>&dat=<%=dat1%>"><%=name1%></a></td>
    <td align="center"><%=itr1.next()%></td>
     <td align="center">Organised</td>
    <td align="center"><%=dat1%></td>
  </tr>
  <%}%>
  </tbody>
  </table>
    </div>
    </form>

<form method="post" action="AttendAddServlet" onsubmit="return validate('att')">
    <div class="menu"  id="att">
        Title:<br>  <input  type="text"  name="att-title" id="att-name"></input>
        Type:<br>  
      <select id="" name="att-type" onchange="">
	<option>Seminar</option>
	<option>Workshop</option>
	<option>FDP</option>
      </select>
       Date:<br> 
      <input id="datepick4" size="20"  name="att-date"/>
      
      <br><br> 
      <div id="numdays-att"></div>
      Number of days: <br> <input type="text" name="att-numdays" id="att-numdays" value="1" OnKeyUp="checkTypeattdays()"></input>
       Association <br> <input  type="text" name="att-association" id=att-asso></input>
       <input type="submit" value="Submit" ></input>
      
      <table class="position_side" width="420" height="85" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#000000">
<tbody class ="scrollContent">
 <tr>
  <th width="131" height="33" bordercolor="#000000" bgcolor="#d3d3d3" >
    Title
  </th>
   <th width="141" bordercolor="#000000" bgcolor="#d3d3d3">
    Type
  </th>
  <th width="140" bordercolor="#000000" bgcolor="#d3d3d3">
    Category
  </th>
   <th width="140" bordercolor="#000000" bgcolor="#d3d3d3">
    Date
  </th>
 </tr> 
 
<%
     List<String> data= (List<String>)request.getAttribute("name");
 List<String> datatype= (List<String>)request.getAttribute("type");
 List<String> date= (List<String>)request.getAttribute("date");
 
      for (itr=data.iterator(),itr1=datatype.iterator(),itr2=date.iterator(); itr.hasNext(); )
{
	String name1=(String)itr.next();
	String dat1=(String)itr2.next();
%>
  <tr>
    <td height="50" align="center"><a href="RetrieveServlet?param=attended&name=<%=name1%>&dat=<%=dat1%>"><%=name1%></a></td>
    <td align="center"><%=itr1.next()%></td>
    <td align="center">Attended</td>
    <td align="center"><%=dat1%></td>
  </tr>
  <%}%>
  </tbody>
	</table>
    </div>
    </form>
    

<form method="post" action="PaperAddServlet" onsubmit="return validate('ppr')">
    <div class="menu"  id="ppr">
      Title:<br> <input  type="text" name="ppr-title" id="ppr-name"></input>
      Type: <br>
      <select id="" name="ppr-conjor" onchange="">
	<option>Conference</option>
	<option>Journal</option>
      </select>
      
      Published in:<br> <input  type="text" name="ppr-published" id="ppr-published"></input>
      Date:<br>
      <input id="datepick2" size="20" name="ppr-date"/>
      <br><br>Volume:<br> <input  type="text" name="ppr-volume" id="ppr-volume"></input>
      Issue:<br> <input  type="text" name="ppr-issue" id="ppr-issue"></input>
      Page number:<br> <input  type="text"  name="ppr-pageno" id="ppr-pageno"></input>
      Authors:<br> <input  type="text"  name="ppr-author" id="ppr-author"></input>
      National/International:<br>
      <select id="" name="ppr-natint" onchange="">
	<option>National</option>
	<option>International</option>
      </select>

      <br><br> <input type="submit" value="Submit"></input>
      
      
<table class="position_side" width="420" height="85" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#000000">
<tbody class ="scrollContent">
 <tr>
  <th width="131" height="33" bordercolor="#000000" bgcolor="#d3d3d3" >
    Title
  </th>
   <th width="141" bordercolor="#000000" bgcolor="#d3d3d3">
    Type
  </th>
  <th width="140" bordercolor="#000000" bgcolor="#d3d3d3">
    Category
  </th>
   <th width="140" bordercolor="#000000" bgcolor="#d3d3d3">
    Date
  </th>
  </tr>
  
<% 
List<String> data3= (List<String>)request.getAttribute("name3");
List<String> datatype3= (List<String>)request.getAttribute("type3");
List<String> date3= (List<String>)request.getAttribute("date3");
for (itr=data3.iterator(),itr1=datatype3.iterator(),itr2=date3.iterator(); itr.hasNext();)
{
	String name1=(String)itr.next();
	String dat1=(String)itr2.next();
	%>
  <tr>
  <td height="50" align="center"><a href="RetrieveServlet?param=paper&name=<%=name1%>&dat=<%=dat1%>"><%=name1%></a></td>
    <td align="center"><%=itr1.next()%></td>
     <td align="center">Publication</td>
    <td align="center"><%=dat1%></td>
     </tr>
     
  <%}%>
  </tbody>
  </table>
    </div>
</form>

<form method="post" action="ConductAddServlet" onsubmit="return validate('con')">
    <div class="menu" id="con">

      Title: <br> <input  type="text"  name="con-title" id="con-name"></input>
       Type: <br> 
      <select id="" onchange="" name="con-type">
	<option>Seminar</option>
	<option>Workshop</option>
	<option>FDP</option>
      </select>
      Date:<br>
      <input id="datepick1" size="20" name="con-date" />
      
      <br><br>
      <div id="numdays-con"></div>
      Number of days: <br> <input  name="con-numdays" id="con-numdays" type="text" value="1" OnKeyUp="checkTypecondays()"></input>
      Association <br><input  name="con-asso" type="text" id="con-asso"></input>
      Sponsor <br><input  type="text" name="con-sponsor" id="con-sponsor"></input>
     Number of participants <br><input  type="text"  name="con-numpartic" id="con-numpartic"></input>
      Place <br><input  type="text"  name="con-place" id="con-place"></input>
     Keynote <br><br>
      <input id="keynote-yes" name="con-keynote" type="radio"  value="Yes" checked>
	Yes
     
      <input id="keynote-no" name="con-keynote" type="radio"  value="No">
	No
    

     <br><br><input type="submit" value="Submit"></input>
     
     <table class="position_side" width="420" height="85" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#000000">
  <tbody class ="scrollContent">
  <tr>
  <th width="131" height="33" bordercolor="#000000" bgcolor="#d3d3d3" >
    Title
  </th>
   <th width="141" bordercolor="#000000" bgcolor="#d3d3d3">
    Type
  </th>
  <th width="140" bordercolor="#000000" bgcolor="#d3d3d3">
    Category
  </th>
   <th width="140" bordercolor="#000000" bgcolor="#d3d3d3">
    Date
  </th>
   </tr>  
<%
List<String> data1= (List<String>)request.getAttribute("name1");
List<String> datatype1= (List<String>)request.getAttribute("type1");
List<String> date1= (List<String>)request.getAttribute("date1");
  
for (itr=data1.iterator(),itr1=datatype1.iterator(),itr2=date1.iterator(); itr.hasNext(); )
{
	String name1=(String)itr.next();
	String dat1=(String)itr2.next();
%>
  <tr>
    <td height="50" align="center"><a href="RetrieveServlet?param=conducted&name=<%=name1%>&dat=<%=dat1%>"><%=name1%></a></td>
    <td align="center"><%=itr1.next()%></td>
     <td align="center">Conducted</td>
    <td align="center"><%=dat1%></td>
  </tr>
  <%}%>
  </tbody>
  </table>
    </div>
</form>
    
<form>
 <div class="menu" id="summary" >  
<div >
<table class="position" width="420" height="400" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#000000" >
 <tbody class ="scrollContentsum">
  <tr>
  <th width="131" height="33" bordercolor="#000000" bgcolor="#d3d3d3" >
    Title
  </th>
   <th width="141" bordercolor="#000000" bgcolor="#d3d3d3">
    Type
  </th>
  <th width="140" bordercolor="#000000" bgcolor="#d3d3d3">
    Category
  </th>
   <th width="140" bordercolor="#000000" bgcolor="#d3d3d3">
    Date
  </th>

<% data= (List<String>)request.getAttribute("name");
datatype= (List<String>)request.getAttribute("type");
date= (List<String>)request.getAttribute("date");
data1= (List<String>)request.getAttribute("name1");
datatype1= (List<String>)request.getAttribute("type1");
date1= (List<String>)request.getAttribute("date1");
data2= (List<String>)request.getAttribute("name2");
datatype2= (List<String>)request.getAttribute("type2");
date2= (List<String>)request.getAttribute("date2");
data3= (List<String>)request.getAttribute("name3");
datatype3= (List<String>)request.getAttribute("type3");
date3= (List<String>)request.getAttribute("date3");
for (itr=data.iterator(),itr1=datatype.iterator(),itr2=date.iterator(); itr.hasNext(); )
{
	String name1=(String)itr.next();
	String dat1=(String)itr2.next();
%>
  <tr>
    <td height="50" align="center"><a href="RetrieveServlet?param=attended&name=<%=name1%>&dat=<%=dat1%>"><%=name1%></a></td>
    <td align="center"><%=itr1.next()%></td>
    <td align="center">Attended</td>
    <td align="center"><%=dat1%></td>
  </tr>
  <%}
  
for (itr=data1.iterator(),itr1=datatype1.iterator(),itr2=date1.iterator(); itr.hasNext(); )
{
	String name1=(String)itr.next();
	String dat1=(String)itr2.next();
%>
  <tr>
    <td height="50" align="center"><a href="RetrieveServlet?param=conducted&name=<%=name1%>&dat=<%=dat1%>"><%=name1%></a></td>
    <td align="center"><%=itr1.next()%></td>
     <td align="center">Conducted</td>
    <td align="center"><%=dat1%></td>
  </tr>
  <%}

for (itr=data2.iterator(),itr1=datatype2.iterator(),itr2=date2.iterator(); itr.hasNext(); )
{
	String name1=(String)itr.next();
	String dat1=(String)itr2.next();
%>
  <tr>
     <td height="50" align="center"><a href="RetrieveServlet?param=organised&name=<%=name1%>&dat=<%=dat1%>"><%=name1%></a></td>
    <td align="center"><%=itr1.next()%></td>
     <td align="center">Organised</td>
    <td align="center"><%=dat1%></td>
  </tr>
  <%}

for (itr=data3.iterator(),itr1=datatype3.iterator(),itr2=date3.iterator(); itr.hasNext(); )
{
	String name1=(String)itr.next();
	String dat1=(String)itr2.next();
%>
  <tr>
  <td height="50" align="center"><a href="RetrieveServlet?param=paper&name=<%=name1%>&dat=<%=dat1%>"><%=name1%></a></td>
    <td align="center"><%=itr1.next()%></td>
     <td align="center">Publication</td>
    <td align="center"><%=dat1%></td>
     </tr>
     
  <%}
  
  
  %>
  </tbody>
</table>
</div>
</div>
</form>
<script type="text/javascript" src="JavaScript/datepickr.js"></script>
                <script type="text/javascript">
                        
                        new datepickr('datepick1', {
                            'dateFormat': 'd/m/y'
                    });
                        new datepickr('datepick2', {
                                'dateFormat': 'd/m/y'
                        });

                        new datepickr('datepick3',  {
                                'dateFormat': 'd/m/y'
                        });
                        new datepickr('datepick4', {
                                'dateFormat': 'd/m/y'
                        });
                </script>
</div>
  </body>
</html>
