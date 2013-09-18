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
<body class="mid1" onload="setDropDownValue('<%= retrievePackage.UserBean.getAttType() %>')">
<img src="Images/blank.PNG" class="mr" align="top" >

<form method="get" action="AttendAddServlet">
    <div class="menu_edit" id="att">
          Title:     <input  type="text"  name="att-title" value = "<%= retrievePackage.UserBean.getAttName() %>"></input>
          Type:     
      <select id="selectType" name="att-type" onchange="">
	<option value="Seminar">Seminar</option>
	<option value="Workshop">Workshop</option>
	<option value="FDP">FDP</option>
      </select>
          Date:    
      <input id="datepick4" size="20"  name="att-date" value="<%= retrievePackage.UserBean.getAttDate() %>"/>
          <br><br>Number of days:     <input type="text" name="att-numdays" value="<%= retrievePackage.UserBean.getAttDays() %>"></input>
          Association     <input  type="text" name="att-association" value = "<%= retrievePackage.UserBean.getAttAsso() %>"></input>
          <br><input type="submit" value="Submit" ></input>
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
                        
                
                        new datepickr('datepick4', {
                                'dateFormat': 'd/m/y'
                        });
                </script>
</html>