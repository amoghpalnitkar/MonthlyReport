<!-- <!DOCTYPE html>
<html>
  
  <head>
    
  </head>
<%@page language="java" import="java.util.*" %>
<style type="text/css">
    <%@include file="../css/style.css" %>
</style>
<body class="mid1">
 <img src="Images/blank.PNG" class="mr" align="top" >
  
  <div id="margins">
  <ul id="nav1">
  	<li><a class="tabbed first" href="#Student" id="student" onclick= "getMyID(this.id);">Paper</a></li>
  	<li><a class="tabbed last" href="#Project" id="project" onclick= "getMyID(this.id);">BE Project</a></li> 
	<li><a class="tabbedright"  href="LoginPage.jsp">Sign Out</a></li>
  </ul>
  <script>
  function getNone()
  {
	  var form = document.getElementById("ppr");
	  form.style.display = "none";
  }
    function getMyID(inputId)
  {

      var form = document.getElementById("stud");
      if(inputId=="student")
      {
    	  form.style.display = "inline";    

      }
      else
      {
	  form.style.display = "none";
      }

      var form = document.getElementById("proj");
      if(inputId=="project")
      {
    	  form.style.display = "inline";    

      }
      else
      {
	  form.style.display = "none";
      }
  }
   </script>  
<form method="post" action="StudAddServlet">
    <div class="menu" id="stud">
      Event Title:<input  type="text" name="stud-title"></input>
      Type:<input type="text" name="stud-type" />
      Co-participants: <input type="text" name="stud-copart" />
      <!-- Type:
      <select id="" name="stud-type" onchange="">
	<option>Conducted</option>
	<option>Organized</option>
	<option>Participated</option>
      </select>
     Date:<br> 
      <input id="datepick3" size="20" name="stud-date" /><br><br>
      Place: <input  type="text" name="stud-place"></input>
      Rank:
      <select id="" name="stud-rank" onchange="">
	<option>Winner</option>
	<option>1st Runner Up</option>
	<option>2nd Runner Up</option>
	<option>Consolation</option>
    <option>Not applicable</option>
      </select>
      
      <input type="submit" value="Submit"></input>
      
      </div>
      </form>
<form method="get" action="StudAddServlet">
    <div class="menu" id="proj">
      Project Title:<input  type="text" name="stud-title" size="45"></input>
      Co-participants: <input type="text" name="stud-copart" />
      Type:
      <select id="" name="stud-type" onchange="">
	<option>Conducted</option>
	<option>Organized</option>
	<option>Participated</option>
      </select>
      Event Name: <input type="text" name="stud-copart" />
      Domain: <input type="text" name="stud-domain" />
     Date:<br>
      <input id="datepick3" size="20" name="stud-date" /><br>
      Place: <input  type="text" name="stud-place"></input>
      Rank:
      <select id="" name="stud-rank" onchange="">
	<option>Winner</option>
	<option>1st Runner Up</option>
	<option>2nd Runner Up</option>
	<option>Consolation</option>
    <option>Not applicable</option>
      </select><br>
      Description: <textarea rows="4" columns = "50" name="stud-desc"></textarea>
      <input type="submit" value="Submit"></input>
      
      </div>
      </form>
            

<script type="text/javascript" src="JavaScript/datepickr.js"></script>
                <script type="text/javascript">
                        
                     
                        new datepickr('datepick3',  {
                                'dateFormat': 'd/m/y'
                        });
                       
                </script>
                
        </div>       
</body>
</html>
 -->
 
  <!DOCTYPE html>
<html>
  
  <head>
    
  </head>
<%@page language="java" import="java.util.*" %>
<style type="text/css">
    <%@include file="../css/style.css" %>
</style>
<body class="mid1">
 <img src="Images/blank.PNG" class="mr" align="top" >
  
  <div id="margins">
  <ul id="nav1">
  	<li><a class="tabbed first" href="#Student" id="student" onclick= "getMyID(this.id);">Achievements</a></li>
  	<li><a class="tabbed last" href="#Project" id="project" onclick= "getMyID(this.id);">Projects</a></li> 
	<li><a class="tabbedright"  href="LoginPage.jsp">Sign Out</a></li>
  </ul>
  <script>
  function getNone()
  {
	  var form = document.getElementById("ppr");
	  form.style.display = "none";
  }
    function getMyID(inputId)
  {

      var form = document.getElementById("stud");
      if(inputId=="student")
      {
    	  form.style.display = "inline";    

      }
      else
      {
	  form.style.display = "none";
      }

      var form = document.getElementById("proj");
      if(inputId=="project")
      {
    	  form.style.display = "inline";    

      }
      else
      {
	  form.style.display = "none";
      }
  }
   </script>  
<form method="post" action="StudAddServlet">
    <div class="menu" id="stud">
      Event Title:<input  type="text" name="stud-title"></input>
      Type:<input type="text" name="stud-type" />
      Co-participants: <input type="text" name="stud-copart" />
      <!-- Type:
      <select id="" name="stud-type" onchange="">
	<option>Conducted</option>
	<option>Organized</option>
	<option>Participated</option>
      </select> -->
     Date:<br> 
      <input id="datepick3" size="20" name="stud-date" /><br><br>
      Place: <input  type="text" name="stud-place"></input>
      Rank:
      <select id="" name="stud-rank" onchange="">
	<option>Winner</option>
	<option>1st Runner Up</option>
	<option>2nd Runner Up</option>
	<option>Consolation</option>
    <option>Not applicable</option>
      </select>
      
      <input type="submit" value="Submit"></input>
      
      </div>
      </form>
<form method="get" action="StudAddServlet">
    <div class="menu" id="proj">
      Project Title:<input  type="text" name="stud-title" size="45"></input>
      Co-participants: <input type="text" name="stud-copart" />
      
      Event Name: <input type="text" name="stud-event" />
      Domain: <input type="text" name="stud-domain" />
     Date:<br>
      <input id="datepick1" size="20" name="stud-date" /><br>
      Place: <input  type="text" name="stud-place"></input>
      Rank:
      <select id="" name="stud-rank" onchange="">
	<option>Winner</option>
	<option>1st Runner Up</option>
	<option>2nd Runner Up</option>
	<option>Consolation</option>
    <option>Not applicable</option>
      </select><br>
      Description: <textarea rows="4" columns = "50" name="stud-descript"></textarea>
      <input type="submit" value="Submit"></input>
      
      </div>
      </form>
            

<script type="text/javascript" src="JavaScript/datepickr.js"></script>
                <script type="text/javascript">
                        
                new datepickr('datepick1', {
                    'dateFormat': 'd/m/y'
            });
                        new datepickr('datepick3',  {
                                'dateFormat': 'd/m/y'
                        });
                       
                </script>
                
        </div>       
</body>
</html>

  
