<%@page import="retrievePackage.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<style type="text/css">
    <%@include file="../css/style.css" %>
</style>

<head>

</head>
<body class="mid1" onload = "setDropDownValue('<%= UserBean.getOrgType() %>')" >
<img src="Images/blank.PNG" class="mr" align="top" >

<form method="get" action="OrgAddServlet">
    <div class="menu_edit" id="org">
          Title:     <input  type="text" name="org-name" value = "<%=retrievePackage.UserBean.getOrgName() %>"></input>
          Type:     
      <select id="selectType" name="org-type" onchange="">
	<option value="Seminar">Seminar</option>
	<option value="Workshop">Workshop</option>
	<option value="FDP">FDP</option>
      </select>
          Date:    
      <input id="datepick3" size="20" name="org-date" value = "<%=retrievePackage.UserBean.getOrgDate() %>"/>
          <br><br>Number of days:     <input name="org-numberdays" type="text" value="<%=retrievePackage.UserBean.getOrgDays() %>"></input>
          Association     <input  name="org-asso" type="text" value = "<%=retrievePackage.UserBean.getOrgAsso() %>"></input>
          Sponsor     <input   name="org-sponsor" type="text" value = "<%=retrievePackage.UserBean.getOrgSponsor() %>"></input>
          Place     <input   name="org-place" type="text" value = "<%=retrievePackage.UserBean.getOrgPlace() %>"></input>
          Number of participants     <input type="text" name="org-numpartic" value="<%=retrievePackage.UserBean.getOrgParti() %>"></input>
          Speaker     <input  type="text"  name="org-speaker" value = "<%=retrievePackage.UserBean.getOrgSpeaker() %>"></input>
          <br><input type="submit" value="Submit"></input>
    </div>
    </form>

</body>
<script type="text/javascript">
function setDropDownValue(selectedValueType)
{
    var forType=document.getElementById('selectType');
    forType.value=selectedValueType;
}</script>
<script type="text/javascript" src="JavaScript/datepickr.js"></script>
                <script type="text/javascript">
                        

                        new datepickr('datepick3',  {
                                'dateFormat': 'd/m/y'
                        });
                        
                </script>

</html>