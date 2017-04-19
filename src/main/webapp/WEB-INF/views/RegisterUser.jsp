<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Job Seeker Registration</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	
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
  <div class="row">
  	<div class="col-md-6">
    
          <form:form action="userregistervalidate.htm" class="form-horizontal" commandName="person" method="post"> <!-- person <form class="form-horizontal" action="" method="POST">-->
          <fieldset>
            <div id="legend">
              <legend class="">Register</legend>
            </div>
            
            <c:if test="${!empty requestScope.erroremployeeAlreadyExists}">
                <p style="color:red">User Name Already Exists</p>
            </c:if>
            
            <div class="form-group">
				<label for="userRole">User Role</label>
				<form:select class="form-control" name="userRole" path="userRole"	id="userRole">
					<option value="jobseeker">Job Seeker</option>
					<option value="employer">Employer</option>
				</form:select>
			</div>
            
            <div class="control-group">
              <label class="control-label" for="firstName">First Name</label>
              <div class="controls">
                <form:input path="firstName" name="firstName" placeholder=""  id="firstName"  class="form-control input-lg"/>
                <form:errors path="firstName"/>
              </div>
            </div>
            
            
         
         
            <div class="control-group">
              <label class="control-label" for="lastName">Last Name</label>
              <div class="controls">
                <form:input type="text" id="lastName" path="lastName"  name="lastName" placeholder="" class="form-control input-lg"/>
                 <form:errors path="lastName"/>
              </div>
            </div>
         
            
            
            <div class="control-group">
              <label class="control-label" for="name">Username</label>
              <div class="controls">
                <form:input type="text" path="name"  id="name" name="name" placeholder="" class="form-control input-lg"/>
                <form:errors path="name"/>
              </div>
            </div>
         
            <div class="control-group">
              <label class="control-label" for="email">E-mail</label>
              <div class="controls">
                <form:input path="emailAddress" type="email" id="email" name="emailAddress" placeholder="" class="form-control input-lg"/>
                <form:errors path="emailAddress"/>
              </div>
            </div>
         
            <div class="control-group">
              <label class="control-label" for="password">Password</label>
              <div class="controls">
                <form:password path="password" type="password" id="password" name="password" placeholder="" class="form-control input-lg"/>
                <form:errors path="password"/>
              </div>
            </div>
         
           <!-- <div class="control-group">
              <label class="control-label" for="password_confirm">Password (Confirm)</label>
              <div class="controls">
                <input type="password" id="password_confirm" name="password_confirm" placeholder="" class="form-control input-lg">
                <p class="help-block">Please confirm password</p>
              </div>
            </div>-->
            
            <br>
            <div class="control-group">
              <!-- Button -->
              <div class="controls">
                <button type="submit" class="btn btn-success">Register</button>
              </div>
            </div>
          </fieldset>
        </form:form><!--</form>-->
    
    </div> 
  </div>
</div>
</body>
</html>