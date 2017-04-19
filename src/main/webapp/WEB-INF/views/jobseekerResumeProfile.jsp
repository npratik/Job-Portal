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
	
	<title>JobSeeker's Dash Board</title>

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
					<li><a href="${pageContext.request.contextPath}/logoutJobSeeker.htm">Logout</a></li>
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
				<li class="open"><a href="${pageContext.request.contextPath}/jobseekerdashboarddivert.htm"><i class="fa fa-dashboard"></i> Dashboard</a></li>
				<li><a href="#"><i class="fa fa-desktop"></i> Jobs</a>
					<ul>
						<li><a href="${pageContext.request.contextPath}/listjobs.htm">View Job Openings</a></li>
						<li><a href="${pageContext.request.contextPath}/quickSearchJobs.htm">Quick Search Jobs</a></li>
						<li><a href="${pageContext.request.contextPath}/viewAndUpdateProfile.htm">Upload Resume</a></li>
						<li><a href="${pageContext.request.contextPath}/appliedJobs.htm">Applied Jobs</a></li>
						<!--  <li><a href="typography.html">Typography</a></li>
						<li><a href="icon.html">Icon</a></li>
						<li><a href="grid.html">Grid</a></li>-->
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
							<li><a href="${pageContext.request.contextPath}/logoutJobSeeker.htm">Logout</a></li>
						</ul>
					</li>
				</ul>

			</ul>
		</nav>
		<div class="content-wrapper">
			<div class="container-fluid">

				<div class="row">
					<div class="col-md-12">        <div class="container">
        	<h3>  Welcome: ${sessionScope.employeeSession.firstName} !!!</h3>
        	<h3> Upload your Resume !</h3>
       
        <div class="col-md-6"> 
       
         <form method="post" action="${pageContext.request.contextPath}/uploadResumeNew.htm" enctype="multipart/form-data">
          	
           
           <label for=""skills"">Core Skill/Technology</label>
				<select class="form-control" name="skills" id=""skills"">
					<option value="Java">Java</option>
					<option value=".NET">DOT NET</option>
					<option value="PeopleSoft">People Soft</option>
					<option value="Oracle">Oracle</option>
					<option value="Other">Other</option>
				</select>
				<br>
	<input type="file" name="resumeFile" id="upload-file-input"	required/>		<br>
<button type="submit" class="btn btn-primary">Update</button>
</form>
           
           <br>
            <c:if test="${!empty requestScope.resumeNotsucessful}">
                <p style="color:red">Sorry resume Could not be uploaded, Please try again !</p>
            </c:if>
            
            <c:if test="${!empty requestScope.resumesucessful}">
                <p style="color:green">Thank you ! Resume has been updated</p>
            </c:if>
            
          
           
             <c:if test="${!empty requestScope.resumeDoesnotexist}">
                <p style="color:Red">Please upload your resume and apply for job</p>
            </c:if>
            
            </div>
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
	//	}); successUpload
		
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