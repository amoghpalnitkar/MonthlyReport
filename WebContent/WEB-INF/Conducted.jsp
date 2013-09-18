<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<style type="text/css">
    <%@include file="../css/style.css" %>
</style>


<head>
</head>
<body class="mid1">
<img src="Images/blank.PNG" class="mr" align="top" >
<form method="get" action="ConductAddServlet">
    <div class="menu_edit" id="con">

          Title:     <input  type="text"  name="con-title" value="<%=retrievePackage.UserBean.getConName() %>"></input>
        Type:   
      <select id="" onchange="" name="con-type">
	<option>Seminar</option>
	<option>Workshop</option>
	<option>FDP</option>
      </select>
          Date:    
      <input id="datepick1" size="20" name="con-date" value = "<%=retrievePackage.UserBean.getConDate() %>"/>
          <br><br>Number of days:     <input  name="con-numdays" type="text" value= "<%=retrievePackage.UserBean.getConDays() %>" ></input>
          Association     <input  name="con-asso" type="text" value = "<%=retrievePackage.UserBean.getConAsso() %>"></input>
          Sponsor     <input  type="text" name="con-sponsor" value = "<%=retrievePackage.UserBean.getConSponsor() %>"></input>
          Number of participants     <input  type="text"  name="con-numpartic" value="<%=retrievePackage.UserBean.getConParti() %>"></input>
          Place     <input  type="text"  name="con-place" value = "<%=retrievePackage.UserBean.getConPlace() %>"></input>
          Keynote     
      <input id="keynote-yes" name="con-keynote" type="radio"  value="Yes">
	Yes
     
      <input id="keynote-no" name="con-keynote" type="radio"  value="No">
	No
    

        <br> <input type="submit" value="Submit"></input>
    </div>
    </form>


</body>

<script type="text/javascript" src="JavaScript/datepickr.js"></script>
                <script type="text/javascript">
                        
                        new datepickr('datepick1', {
                            'dateFormat': 'd/m/y'
                    });
                       
                </script>
</html>