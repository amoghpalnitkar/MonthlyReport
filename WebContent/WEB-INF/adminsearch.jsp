<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<style type="text/css">
    <%@include file="../css/style.css" %>
</style>



<body>
 <form  action = "SearchServlet" method = "POST">
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
<input type="checkbox" name="paper" value="Stud-achieve"/>Student Achievements
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
</body>
</html>