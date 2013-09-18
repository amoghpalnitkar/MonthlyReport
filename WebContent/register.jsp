<!-- 
<html>
<head></head>
<style type="text/css">
    <%@include file="css/style.css" %>
</style>
<script type="text/javascript">
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
    
    var form = document.getElementById("staf");
    if(inputId=="staff")
    {
  	  form.style.display = "inline";    

    }
    else
    {
	  form.style.display = "none";
    }
}

function checkEqual()
{
	var check1,check2;
	check1 = document.getElementById('passwd1');
	//text = check.innerHTML;
	check2 = document.getElementById('passwd2');
	//document.write("Called");
	if(check1.value == check2.value)
	{
		//document.write("written in if");
		document.getElementById('checkPassword').innerHTML = "";
		return true;
	}
	else
	{
		document.getElementById('checkPassword').innerHTML = "Passwords do not match!";
		return false;
	};
	
}

function checkname()
{
if(document.getElementById('firstname').value.length==0)
	{
		//document.getElementById('test').innerHTML = document.getElementById('test').innerHTML + " Cannot leave blank";	
		return " Name";
	}
	return "";
}

function checklast()
{
if(document.getElementById('lastname').value.length==0)
	{
		//document.getElementById('test').innerHTML = document.getElementById('test').innerHTML + " Cannot leave blank";	
		return " Last Name";
	}
	return "";
}

function checkemail()
{
	var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;

    if (reg.test(document.getElementById('emailid').value) == false) 
    {
        //alert('Invalid Email Address');
        return "Email";
    }
if(document.getElementById('emailid').value.length==0)
	{
		//document.getElementById('test').innerHTML = document.getElementById('test').innerHTML + " Cannot leave blank";	
		return " Email";
	}
	return "";
}

function checkdept()
{
if(document.getElementById('dept').value.length==0)
	{
		//document.getElementById('test').innerHTML = document.getElementById('test').innerHTML + " Cannot leave blank";	
		return " Department";
	}
	return "";
}

function checktitle()
{
if(document.getElementById('title').value.length==0)
	{
		//document.getElementById('test').innerHTML = document.getElementById('test').innerHTML + " Cannot leave blank";	
		return " Title";
	}
	return "";
}

function validate()
{
	var reason="";
	
	reason+=checkname();
	reason+=checklast();
	reason+=checkemail();
	reason+=checkdept();
	reason+=checktitle();

	if(reason!="")
		{
			alert("Fill all the fields" + reason);
			return false;
		}
	if(!checkEqual())
		return false;
	return true;
}

</script>
<body class="mid1">

<div >
<img src="Images/blank.PNG" class="mr" align="top" >
<br>
<ul id="nav1">
<li><input type="radio" name="userType" value="staff" id="staff" onchange="getMyID(this.id);"/>Staff</li>
<li><input type="radio" name="userType" value="student" id="student" onchange="getMyID(this.id);"/>Student<br></li>
</ul>
<div class="register">
<a class="normallinks" href ="LoginPage.jsp">Home</a><br>
<input type="radio" name="userType" value="staff" id="staff" onchange="getMyID(this.id);"/>Staff
<input type="radio" name="userType" value="student" id="student" onchange="getMyID(this.id);"/>Student

<form method="post" action="RegisterServlet" onsubmit="return validate()">
<div style="display:none;" id="staf">
Please fill out the following details
<br></br>
<p class="smalltext" id="test">First name</p>
 <input type="text" name="firstname" id="firstname">
<p class="smalltext">Last name</p>
 <input type="text" name="lastname" id="lastname">
<p class="smalltext">Email id</p>
<input type="text" id="emailid" name="emailid" autocomplete="off"></input>

<p class="smalltext">Password</p>
 <input type="password" name="passwd" id = "passwd1">
 
 <div id="checkPassword"> Passwords do not match!</div>
<p class="smalltext">Confirm Password </p>
 <input type="password" name="passwd" id = "passwd2" onKeyUp="checkEqual()">
<p class="smalltext">Department</p>
 <input type="text" name="department" id="dept"> 
 <p class="smalltext">Title</p>
 <input type="text" name="title" id="title">
<input class="login" type="submit" value="Register" id="login" >
</div>
</form>

<form method="get" action="RegisterServlet">
<div style="display:none;" id="stud" >
Please fill out the following details 
<br></br>
<p class="smalltext" id="test">Name</p>
 <input type="text" name="firstname" id="firstname_stud">

<input type="text" id="emailid_stud" name="emailid" autocomplete="off"></input>

<p class="smalltext">Password</p>
 <input type="password" name="passwd" id = "passwd1_stud">
 
 <div id="checkPassword"> Passwords do not match!</div>
<p class="smalltext">Confirm Password </p>
 <input type="password" name="passwd" id = "passwd2_stud" onKeyUp="checkEqual()">
<p class="smalltext">Department</p>
 <input type="text" name="department" id="dept_stud"> 
 
<input class="login" type="submit" value="Register" id="login_stud" >
</div>
</form>


</div>

</div>

</body>



</html> 

////////////////////////////////////////////////////////////////////////////////////////////
 -->

<html>
<head></head>
<style type="text/css">
    <%@include file="css/style.css" %>
</style>
<script type="text/javascript">
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
    
    var form = document.getElementById("staf");
    if(inputId=="staff")
    {
  	  form.style.display = "inline";    

    }
    else
    {
	  form.style.display = "none";
    }
}

function checkEqual()
{
	var check1,check2;
	check1 = document.getElementById('passwd1');
	//text = check.innerHTML;
	check2 = document.getElementById('passwd2');
	//document.write("Called");
	if(check1.value == check2.value)
	{
		//document.write("written in if");
		document.getElementById('checkPassword').innerHTML = "";
		return true;
	}
	else
	{
		document.getElementById('checkPassword').innerHTML = "Passwords do not match!";
		return false;
	};
	
}

function checkEqual_stud()
{
	var check1,check2;
	check1 = document.getElementById('passwd1_stud');
	//text = check.innerHTML;
	check2 = document.getElementById('passwd2_stud');
	//document.write("Called");
	if(check1.value == check2.value)
	{
		//document.write("written in if");
		document.getElementById('checkPassword_stud').innerHTML = "";
		return true;
	}
	else
	{
		document.getElementById('checkPassword_stud').innerHTML = "Passwords do not match!";
		return false;
	};
	
}

function checkname()
{
if(document.getElementById('firstname').value.length==0)
	{
		//document.getElementById('test').innerHTML = document.getElementById('test').innerHTML + " Cannot leave blank";	
		return " Name";
	}
	return "";
}

function checklast()
{
if(document.getElementById('lastname').value.length==0)
	{
		//document.getElementById('test').innerHTML = document.getElementById('test').innerHTML + " Cannot leave blank";	
		return " Last Name";
	}
	return "";
}

function checkemail()
{
if(document.getElementById('emailid').value.length==0)
	{
		//document.getElementById('test').innerHTML = document.getElementById('test').innerHTML + " Cannot leave blank";	
		return " Email";
	}
	return "";
}
function checkEmail()
{
	
	var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;

    if (reg.test(document.getElementById('emailid').value) == false) 
    {
    	
    	document.getElementById('checkvalid').innerHTML = "Enter valid email address";
        return false;
    }
    document.getElementById('checkvalid').innerHTML = "";
    return true;
	}
function checkdept()
{
if(document.getElementById('dept').value.length==0)
	{
		//document.getElementById('test').innerHTML = document.getElementById('test').innerHTML + " Cannot leave blank";	
		return " Department";
	}
	return "";
}

function checktitle()
{
if(document.getElementById('title').value.length==0)
	{
		//document.getElementById('test').innerHTML = document.getElementById('test').innerHTML + " Cannot leave blank";	
		return " Title";
	}
	return "";
}


function checkname_stud()
{
	
if(document.getElementById('firstname_stud').value.length==0)
	{
	
		//document.getElementById('test').innerHTML = document.getElementById('test').innerHTML + " Cannot leave blank";	
		return " Name";
	}
	return "";
}

function checklast_stud()
{
if(document.getElementById('lastname_stud').value.length==0)
	{
		//document.getElementById('test').innerHTML = document.getElementById('test').innerHTML + " Cannot leave blank";	
		return " Last Name";
	}
	return "";
}

function checkemail_stud()
{
	
if(document.getElementById('emailid_stud').value.length==0)
	{
		//document.getElementById('test').innerHTML = document.getElementById('test').innerHTML + " Cannot leave blank";	
		return " Email";
	}
	return "";
}

function checkdept_stud()
{
if(document.getElementById('dept_stud').value.length==0)
	{
		//document.getElementById('test').innerHTML = document.getElementById('test').innerHTML + " Cannot leave blank";	
		return " Department";
	}
	return "";
}
function checkEmail_stud()
{
	var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;

    if (reg.test(document.getElementById('emailid_stud').value) == false) 
    {
       
        document.getElementById("checkvalid_stud").innerHTML = "Provide a valid email address";
        return false;
    }
    else
    	{
    	
    		document.getElementById('checkvalid_stud').innerHTML = "";
    return true;
    	}
    
}
function checkroll_stud()
{
	if(isNaN(document.getElementById('roll_no_stud').value))
	{
		document.getElementById('numpart').innerHTML = "Enter numeric data";
		return "Roll No";
	}
if(document.getElementById('roll_no_stud').value.length==0)
	{

		//document.getElementById('test').innerHTML = document.getElementById('test').innerHTML + " Cannot leave blank";	
		return " Roll No";
	}
	return "";
}

function validate()
{
	var reason="";
	
	reason+=checkname();
	reason+=checklast();
	reason+=checkemail();
	reason+=checkdept();
	reason+=checktitle();

	if(reason!="")
		{
			alert("Fill all the fields" + reason);
			return false;
		}
	if(!checkEqual() || !checkEmail())
		return false;
	return true;
}

function validate_stud()
{
	var reason="";
	
	reason+=checkname_stud();
	reason+=checklast_stud();
	reason+=checkemail_stud();
	reason+=checkdept_stud();
	reason+=checkroll_stud();

	if(reason!="")
		{
			alert("Fill all the fields" + reason);
			return false;
		}
	if(!checkEqual_stud() || !checkEmail_stud())
		return false;
	return true;
}

</script>
<body class="mid1">

<div >
<img src="Images/blank.PNG" class="mr" align="top" >
<br>

<div class="register">
<a class="normallinks" href ="LoginPage.jsp">Home</a><br>
<input type="radio" name="userType" value="staff" id="staff" onchange="getMyID(this.id);"/>Staff
<input type="radio" name="userType" value="student" id="student" onchange="getMyID(this.id);"/>Student

<form method="post" action="RegisterServlet" onsubmit="return validate()">
<div style="display:none;" id="staf">
Please fill out the following details
<br></br>
<p class="smalltext" id="test">First name</p>
 <input type="text" name="firstname" id="firstname">
<p class="smalltext">Last name</p>
 <input type="text" name="lastname" id="lastname">
 
 <div id=checkvalid></div>
<p class="smalltext">Email id</p>
<input type="text" id="emailid" name="emailid" autocomplete="off" onKeyUp="checkEmail()"></input>

<p class="smalltext">Password</p>
 <input type="password" name="passwd" id = "passwd1">
 
 <div id="checkPassword"></div>
<p class="smalltext">Confirm Password </p>
 <input type="password" name="passwd" id = "passwd2" onKeyUp="checkEqual()">
<p class="smalltext">Department</p>
 <input type="text" name="department" id="dept"> 
 <p class="smalltext">Title</p>
 <input type="text" name="title" id="title">
<input class="login" type="submit" value="Register" id="login" >
</div>
</form>

<form method="get" action="RegisterServlet" onsubmit="return validate_stud()">
<div style="display:none;" id="stud" >
Please fill out the following details 
<br></br>
<p class="smalltext" id="test">First Name</p>
 <input type="text" name="firstname_stud" id="firstname_stud">
<p class="smalltext">Last name</p>
 <input type="text" name="lastname_stud" id="lastname_stud">
 
<p class="smalltext">Roll No</p>
 <input type="text" name="roll_no_stud" id="roll_no_stud"> 
<p class="smalltext">Email</p>
<div id="checkvalid_stud"> </div> 
 <input type="text" id="emailid_stud" name="emailid_stud" autocomplete="off" onKeyUp = "checkEmail_stud()"></input>

<p class="smalltext">Password</p>
 <input type="password" name="passwd_stud" id = "passwd1_stud">
 
 <div id="checkPassword_stud"> </div>
<p class="smalltext">Confirm Password </p>
 <input type="password" name="passwd" id = "passwd2_stud" onKeyUp="checkEqual_stud()">
<p class="smalltext">Department</p>
 <input type="text" name="department_stud" id="dept_stud"> 
 
<input class="login" type="submit" value="Register" id="login_stud" >
</div>
</form>


</div>

</div>

</body>



</html> 



