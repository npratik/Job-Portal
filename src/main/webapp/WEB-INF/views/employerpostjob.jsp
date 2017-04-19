<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>



<!doctype html>
<html lang="en" class="no-js">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	<meta name="theme-color" content="#3e454c">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employer Job Post</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	
	
	<title>Employer Dash Board</title>

	<!-- Font awesome -->
	<link rel="stylesheet" href="resources/css/font-awesome.min.css">
	<!-- Sandstone Bootstrap CSS -->
	<link rel="stylesheet" href="resources/css/bootstrap.min.css">
	<!-- Bootstrap Datatables -->
	<link rel="stylesheet" href="resources/css/dataTables.bootstrap.min.css">
	<!-- Bootstrap social button library -->
	<link rel="stylesheet" href="resources/css/bootstrap-social.css">
	<!-- Bootstrap select -->
	<link rel="stylesheet" href="resources/css/bootstrap-select.css">
	<!-- Bootstrap file input -->
	<link rel="stylesheet" href="resources/css/fileinput.min.css">
	<!-- Awesome Bootstrap checkbox -->
	<link rel="stylesheet" href="resources/css/awesome-bootstrap-checkbox.css">
	<!-- Admin Stye -->
	<link rel="stylesheet" href="resources/css/style.css">

	<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
	<div class="brand clearfix">
		<a href="#" class="logo"><img src="resources/img/logo.jpg" class="img-responsive" alt=""></a>
		<span class="menu-btn"><i class="fa fa-bars"></i></span>
		<ul class="ts-profile-nav">
			<li><a href="#">Help</a></li>
			<li><a href="#">Settings</a></li>
			<li class="ts-account">
				<a href="#"><img src="resources/img/ts-avatar.jpg" class="ts-avatar hidden-side" alt=""> Account <i class="fa fa-angle-down hidden-side"></i></a>
				<ul>
					<li><a href="#">My Account</a></li>
					<li><a href="#">Edit Account</a></li>
					<li><a href="${pageContext.request.contextPath}/logoutEmployer.htm">Logout</a></li>
				</ul>
			</li>
		</ul>
	</div>

	<div class="ts-main-content">
		<nav class="ts-sidebar">
			<ul class="ts-sidebar-menu">
				<li class="ts-label">Search</li>
				<li>
					<input type="text" class="ts-sidebar-search" placeholder="Search here...">
				</li>
				<li class="ts-label">Main</li>
				<li class="open"><a href="${pageContext.request.contextPath}/getemployerdashboard.htm"><i class="fa fa-dashboard"></i> Dashboard</a></li>
				<li><a href="#"><i class="fa fa-desktop"></i> More Options</a>
					<ul>
						
						<li><a href="${pageContext.request.contextPath}/employerpostjob.htm">Post a Job</a></li>
						<li><a href="${pageContext.request.contextPath}/viewApplicants.htm">View Applicants/Posted Jobs</a></li>
						
						
					</ul>
				</li>
				

				<!-- Account from above -->
				<ul class="ts-profile-nav">
					<li><a href="#">Help</a></li>
					<li><a href="#">Settings</a></li>
					<li class="ts-account">
						<a href="#"><img src="resources/img/ts-avatar.jpg" class="ts-avatar hidden-side" alt=""> Account <i class="fa fa-angle-down hidden-side"></i></a>
						<ul>
							<li><a href="#">My Account</a></li>
							<li><a href="#">Edit Account</a></li>
							<li><a href="${pageContext.request.contextPath}/logoutEmployer.htm">Logout</a></li>
						</ul>
					</li>
				</ul>

			</ul>
		</nav>
		<div class="content-wrapper">
			<div class="container-fluid">

				<div class="row">
					<div class="col-md-12">

						<h2 class="page-title">Employer's Dashboard</h2>
						<!-- <h3> Employer Dashboard</h3> -->
                                  <p>  Welcome: ${sessionScope.employerSession.firstName} !</p>
						
						
						    <div class="container">

  	<div class="col-md-6">
    
          <form:form action="employerpostjob.htm" class="form-horizontal" commandName="jobs" method="post"> <!-- person <form class="form-horizontal" action="" method="POST">-->
          <fieldset>
            <div id="legend">
              <legend class="">Post a Job</legend>
            </div>
            
            <!-- <div class="control-group">
              <label class="control-label" for="jobId">Job Id</label>
              <div class="controls">
                <form:input path="jobId" name="jobId" placeholder=""  id="jobId"  class="form-control input-lg"/>
               <!--  <p class="help-block">First Name can contain only letters</p>-->
              <!--  </div>-->
            <!--  </div>-->
            
            
           <div class="form-group">
				<label for="JobLocation">Job Location</label>
				<form:select class="form-control" name="company" path="company"	id="company">
					<option value="ADP">ADP</option>
					<option value="Oracle">Oracle</option>
					<option value="Wells Fargo">Wells Fargo</option>
					<option value="KBC">KBC</option>
					<option value="HoustonLakes">HoustonLakes</option>
					<option value="Other">Other</option>
				</form:select>
			</div>
            
            
         <!--    <div class="control-group">
              <label class="control-label" for="company">Company</label>
              <div class="controls">
                <form:input type="text" id="company" path="company"  name="company" placeholder="" class="form-control input-lg"/>
               
              </div>
            </div>
             -->
            <div class="form-group">
				<label for="JobLocation">Job Location</label>
				<form:select class="form-control" name="jobLocation" path="jobLocation"	id="jobLocation">
					<option value="Boston">Boston</option>
					<option value="New York">New York</option>
					<option value="New Jersy">New Jersy</option>
					<option value="Chicago">Chicago</option>
					<option value="Houston">Houston</option>
					<option value="Asheville">Asheville</option>
				</form:select>
			</div>
         
            
            
            <!-- <div class="control-group">
              <label class="control-label" for="jobLocation">Job Location</label>
              <div class="controls">
                <form:input type="text" path="jobLocation"  id="jobLocation" name="jobLocation" placeholder="" class="form-control input-lg"/>
              
              </div>
            </div> -->
         
            <!--  <div class="control-group">
              <label class="control-label" for="jobType">Job Type</label>
              <div class="controls">
                <form:input path="jobType" type="jobType" id="jobType" name="jobType" placeholder="" class="form-control input-lg"/>
              
              </div>
            </div>-->
            
            <div class="form-group">
				<label for="jobType">Job Type</label>
				<form:select class="form-control" name="jobType" path="jobType"	id="jobType">
					<option value="Full Time">Full Time</option>
					<option value="Part Time">Part Time</option>
					<option value="Internship">Internship</option>
					<option value="Co-op">Co-op</option>
				</form:select>
			</div>
         
         
             <div class="form-group">
				<label for="jobType">Domain</label>
				<form:select class="form-control" name="technology" path="technology"	id="technology">
					<option value="Information Technology">Information Technology</option>
					<option value="Management">Management</option>
					<option value="Construction">Construction</option>
					<option value="Mechanical">Mechanical</option>
				</form:select>
			</div>
			
			<div class="form-group">
              <label class="control-label" for="jobType">Job Description</label>
              <div class="controls">
                <form:input path="jobDescrition" type="jobDescrition" id="jobDescrition" name="jobDescrition" placeholder="" class="form-control input-lg" required="required"/>
              
              </div>
            </div>
			
			
			<div class="form-group">
			
			  <button type="submit" class="btn btn-success">Post Job</button>
           </div>
          </fieldset>
        </form:form><!--</form>-->
        
        
        
            <c:if test="${!empty requestScope.jobSucessfullyAdded}">
                <p style="color:green">Job has been Sucessfully Added !</p>
            </c:if>
    
    </div> 
  
</div>
						
						
					</div>
				</div>

			</div>
		</div>
	</div>

	<!-- Loading Scripts -->
	<script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/bootstrap-select.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/jquery.dataTables.min.js"></script>
	<script src="resources/js/dataTables.bootstrap.min.js"></script>
	<script src="resources/js/Chart.min.js"></script>
	<script src="resources/js/fileinput.js"></script>
	<script src="resources/js/chartData.js"></script>
	<script src="resources/js/main.js"></script>
	
	<script>
		
	window.onload = function(){
    
		// Line chart from swirlData for dashReport
	//	var ctx = document.getElementById("dashReport").getContext("2d");
	//	window.myLine = new Chart(ctx).Line(swirlData, {
	//		responsive: true,
	//		scaleShowVerticalLines: false,
	//		scaleBeginAtZero : true,
	//		
	//	}); 
		
		// Pie Chart from doughutData
		var doctx = document.getElementById("chart-area3").getContext("2d");
		window.myDoughnut = new Chart(doctx).Pie(doughnutData, {responsive : true});

		// Dougnut Chart from doughnutData
		var doctx = document.getElementById("chart-area4").getContext("2d");
		window.myDoughnut = new Chart(doctx).Doughnut(doughnutData, {responsive : true});

	}
	</script>

</body>

</html>