<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>



<!doctype html>
<html lang="en" class="no-js">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	<meta name="theme-color" content="#3e454c">
	
	<title>Employer Dash Board</title>

	<!-- Font awesome -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css">
	<!-- Sandstone Bootstrap CSS -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
	<!-- Bootstrap Datatables -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/dataTables.bootstrap.min.css">
	<!-- Bootstrap social button library -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-social.css">
	<!-- Bootstrap select -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-select.css">
	<!-- Bootstrap file input -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/fileinput.min.css">
	<!-- Awesome Bootstrap checkbox -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/awesome-bootstrap-checkbox.css">
	<!-- Admin Stye -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">

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
						<!-- <li><a href="viewApplicants.htm">View Applicants</a></li> -->
						
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

						<!-- <h3 class="page-title">View Applicant's</h3> -->
						<!-- <h3> Employer Dashboard</h3> -->
                                 <!--  <p> Welcome: ${sessionScope.employerSession.firstName} !</p> -->
        <div class="container">
        <h3> Applicant Details</h3>
        <hr>
         <form method="post" action="${pageContext.request.contextPath}/updateSingleApplicantStatus/${sessionScope.applicantobj.appliedid}.htm" >
        
  			<table class="table table-striped">
    			<thead>
      		<tr>
                <th>Applicant Id</th>
                <th>First Name</th>
                <th> Last Name </th>
                <th>User Name</th>
                <th>Status</th>
                <th>Message</th>
                <th> Click to update Status</th>
                
            </tr>
             </thead>
             
            <tbody> 
            
                <tr>
                  
                    <td>${sessionScope.applicantobj.appliedid}</td>
                   <td>${sessionScope.applicantobj.jobseeker.firstName}</td>
                   <td>${sessionScope.applicantobj.jobseeker.lastName}</td>
                   <td>${sessionScope.applicantobj.jobseeker.name}</td>
                    
                    <td>
                    
                    
                    <select class="form-control" name="Status" id="Status" >
													<option value="Accepted">Accepted</option>
													<option value="Rejected">Rejected</option>
													<option value="Under Review">Under Review</option>
					</select>
                    
                    </td>
                    
                    <td><input type="text" name="message" id="message" class="form-control" placeholder=""> </td>
                    <td><button type="submit" class="btn btn-success">Update</button></td>
                    
                </tr>
          
        </tbody>
  </table>
            <c:if test="${!empty requestScope.jobupdatedsucess}">
                <p style="color:green">Status has been updated !</p>
            </c:if>
 </form> 
</div>
   </div>
				</div>

			</div>
		</div>
	</div>

	<!-- Loading Scripts -->
	<script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap-select.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery.dataTables.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/dataTables.bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/Chart.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/fileinput.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/chartData.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
	
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