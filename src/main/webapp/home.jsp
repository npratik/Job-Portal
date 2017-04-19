<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!-- <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> -->
<html>
<head>
	<meta charset="utf-8">
	<title> Transforming Careers</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<!--<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	<link rel="stylesheet" type="text/css" href="css/vectorcalcstyle.css">-->

</head>
<body>

<div class="container">


<!-- Static navbar -->
      <nav class="navbar navbar-default">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Transforming Careers</a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li class="active"><a href="#">Dashboard</a></li>
              <li><a href="#">Search</a></li>
              <!-- <li><a href="${pageContext.request.contextPath}/regiternewuserpage.htm">Register User</a></li> -->
            </ul>
            <ul class="nav navbar-nav navbar-right">
              <!--<li class="active"><a href="./">Default <span class="sr-only">(current)</span></a></li>
              <li><a href="../navbar-static-top/">Static top</a></li>
              <li><a href="../navbar-fixed-top/">Fixed top</a></li>-->
					<li>
					<!-- <form class="navbar-form navbar-left" role="search">
						<input type="text" class="form-control" placeholder="Search for Jobs">
						<button type="submit" class="btn btn-default">Search</button>
					</form> -->
			        </li>
			   <li><a href="${pageContext.request.contextPath}/employerregister.htm">New Employers</a></li>
			  <li><a href="${pageContext.request.contextPath}/jobseekerregister.htm">New Employees</a></li>
			  <li><a href="${pageContext.request.contextPath}/employerLogin.htm">Sign In</a></li> <!-- <li><a href="employerLogin.htm">Employers</a></li> -->
			      <li class="logindd dropdown">
       <!-- 
        <a id="Login_1" href="#" class="dropdown-toggle loginDD" data-toggle="dropdown"><span class="loginStatusBox"><span class="icon icon-white icon-user"></span></span> Sign In/Register <b class="caret"></b></a>
        <ul id="3" class="dropdown-menu dropdown-left list-unstyled">
            <li id="universalLoginPanel">
                <ul class="list-unstyled">
                    <li id="universalLoginError" name="universalLoginError" class="error nav-text" style="display:none;"></li>
                    <form class="navbar-form signin">
                        <div class="form-group"><input id="Email_1" class="form-control" placeholder="Email" type="text"></div>
						<br><br/>
                        <div class="form-group"><input id="Password_1" class="form-control" placeholder="Password" type="password"></div>
                        <div class="form-group">
						    <br><br/>
						    
                            <a id="ForgotPassword_1" href="#" class="rightLink">Forgot password?</a>
                            <div class="checkbox">
                                <label for="LoggedIn_1"><input type="checkbox" id="LoggedIn_1"> Stay signed in</label>
                            </div>
                        </div>
						<br><br/>
                        <button id="LoginBtn_1" type="submit" class="btn btn-primary btn-block">Sign In</button>
                    </form>
                    <li class="nav-text"><a id="SignUpBtn_1" href="jobseekerregister.htm" class="btn btn-inverse">Register for a Transforming-Careers account</a></li>
                </ul>
            </li>
            
        </ul>  -->
    </li>
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav>
	  
	  
	   <img class="img-responsive" src="resources/images/office.jpg" alt="office" width="1900" height="300"> <!--width="460" height="345"-->
      
	  <!--
      <div class="jumbotron">
        <h1>Navbar example</h1>
        <p>This example is a quick exercise to illustrate how the default, static navbar and fixed to top navbar work. It includes the responsive CSS and HTML, so it also adapts to your viewport and device.</p>
        <p>
          <a class="btn btn-lg btn-primary" href="../../components/#navbar" role="button">View navbar docs &raquo;</a>
        </p>
      </div>-->


    <footer class="footer">
      <div class="container">
        <p class="text-muted">For more details follow us @TransformingCareers.</p>
      </div>
    </footer>

</div>
</body>
</html>
