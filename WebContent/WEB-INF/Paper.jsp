<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<style type="text/css">
    <%@include file="../css/style.css" %>
</style>


<head>

</head>

<body class="mid1" onload = "(setDropDownValue('<%=retrievePackage.UserBean.getPaperType() %>',<%=retrievePackage.UserBean.getPaperNatint() %>))">
<img src="Images/blank.PNG" class="mr" align="top" >

<form method="get" action="PaperAddServlet" >
    <div class="menu_edit" id="ppr">
    
        Title:   <input  type="text" name="ppr-title" value="<%=retrievePackage.UserBean.getPaperTitle() %>"></input>
        Type:   
      <select id="selectType" name="ppr-conjor" >
	<option value="Conference">Conference</option>
	<option value="Journal">Journal</option>
      </select>
      
        Published in:   <input  type="text" name="ppr-published" value="<%=retrievePackage.UserBean.getPaperPubIn() %>"></input>
        Date:  <input id="datepick2" size="20" name="ppr-date" value="<%=retrievePackage.UserBean.getPaperDate() %>"></input>
        <br><br>Volume:   <input  type="text" name="ppr-volume" value="<%=retrievePackage.UserBean.getPaperVolume() %>"></input>
        Issue:   <input  type="text" name="ppr-issue" value="<%=retrievePackage.UserBean.getPaperIssue() %>"></input>
        Page number:   <input  type="text"  name="ppr-pageno" value="<%=retrievePackage.UserBean.getPaperPage() %>"></input>
        Authors:   <input  type="text"  name="ppr-author" value="<%=retrievePackage.UserBean.getPaperAuthor() %>"></input>
        National/International:  
      <select id="selectNatint" name="ppr-natint" onchange="" >
	<option value="0">National</option>
	<option value="1">International</option>
      </select>

        <br><input type="submit" value="Submit"></input>
    </div>
</form>

</body>
<script>
function setDropDownValue(selectedValueType,selectedValueNatint)
{
    var forType=document.getElementById('selectType');
    forType.value=selectedValueType;
    var forNatint = document.getElementById('selectNatint');
    forNatint.value = selectedValueNatint;
}

</script>
<script type="text/javascript" src="JavaScript/datepickr.js"></script>
                <script type="text/javascript">

                        new datepickr('datepick2', {
                                'dateFormat': 'd/m/y'
                        });

                </script>
</html>