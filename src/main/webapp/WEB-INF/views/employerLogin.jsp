<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!-- Check*** if this is required -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<title> Transforming Careers</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	
	<link rel="stylesheet" type="text/css" href="resources/css/styleEmployer.css">

</head>
<body>
<div class="container">
   <nav class="navbar navbar-default">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/diverthome.htm">Transforming Careers</a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li class="active"><a href="#">Dashboard</a></li>
              <li><a href="#">Search</a></li>
              <li><a href="#">News</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
              
					<li>
					
			        </li>
			   <li><a href="${pageContext.request.contextPath}/employerregister.htm">New Employers</a></li>
			  <li><a href="${pageContext.request.contextPath}/jobseekerregister.htm">New Employees</a></li>
			  <li><a href="${pageContext.request.contextPath}/employerLogin.htm">Sign In</a></li> <!-- <li><a href="employerLogin.htm">Employers</a></li> -->
			      <li class="logindd dropdown">
       
    </li>
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav>
  
  <div class="row" id="pwd-container">
    <div class="col-md-4"></div>
    
    <div class="col-md-4">
      <section class="login-form">
        <!--<form method="post" action="#" role="login">-->
          <!--<img src="" class="img-responsive" alt="Employers Login" />-->
          
          <c:if test="${!empty requestScope.errorInvalidUserIDpsw}">
           <span>     <p style="color:red">Invalid UserName/Password </p></span>
            </c:if>
        
          <form:form id="loginform" commandName="person" role="form" action="jobseekerLogin.htm" method="post">
		  <h2 style="float:center">User's Login</h2> <!--check-->
          <form:input path ="name" type="name"  name="name" placeholder="Email" class="form-control input-lg"  /><br/>
         <span style-color="red"> <form:errors path="name"/></span>
          
          <form:input path="password"  type="password" class="form-control input" id="password" placeholder="Password" required="" /><br/>
          <form:errors path="password"/>
          
          <!-- <form:input path="password"  type="password" class="form-control input-lg" id="password" placeholder="Password" required="" /><br/>-->
          
          
          <!--  <div class="pwstrength_viewport_progress"></div>-->
          
          
          <button type="submit" name="go" class="btn btn-lg btn-primary btn-block">Sign in</button><br/>
          <div>
            
            <a  href="jobseekerregister.htm" >  Register as a Job Seeker</a> <!--or <a href="#">reset password</a>-->
            
            <span>  -     </span>
            
            <a  href="employerregister.htm" >   Register as an Employer</a>
            
          </div>
          
        </form:form><!--</form>-->
        
        
        
        
        
        
        <div class="form-links">
        </div>
      </section>  
      </div>
      
      <div class="col-md-4"></div>
      

  </div>
  
  <p>
    
  </p>     
  
  
</div>

</body>
</html>
