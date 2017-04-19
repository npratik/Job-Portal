<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en" class="no-js">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	<meta name="theme-color" content="#3e454c">
	
	<title>Quick Search for Jobs</title>

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
		<a href="#" class="logo"><img src="${pageContext.request.contextPath}/resources/img/logo.jpg" class="img-responsive" alt=""></a>
		<span class="menu-btn"><i class="fa fa-bars"></i></span>
		<ul class="ts-profile-nav">
			<li><a href="#">Help</a></li>
			<li><a href="#">Settings</a></li>
			<li class="ts-account">
				<a href="#"><img src="${pageContext.request.contextPath}/resources/img/ts-avatar.jpg" class="ts-avatar hidden-side" alt=""> Account <i class="fa fa-angle-down hidden-side"></i></a>
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
						<!--  <li><a href="${pageContext.request.contextPath}/jobseekerUpdateProfile.htm">Update Profile</a></li>-->
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
						<a href="#"><img src="img/ts-avatar.jpg" class="ts-avatar hidden-side" alt=""> Account <i class="fa fa-angle-down hidden-side"></i></a>
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
					<div class="col-md-12">

						<h2 class="page-title">Jobs Quick Search</h2>

						<!-- Zero Configuration Table -->
						<div class="panel panel-default">
							<div class="panel-heading">Jobs Quick Search</div>
							<div class="panel-body">
								<table id="zctb" class="display table table-striped table-bordered table-hover" cellspacing="0" width="100%">
									<thead>
      		<tr>
      		    <th>Job Code</th>
                <th>Company Name</th>
                <th>Job Location</th>
                <th>Job Type</th>
                <th>Job Description</th>
                
                
                <th>Click to Apply for Job</th>
            </tr>
             </thead>
             
            <tbody> 
            <c:forEach var="advert" items="${jobquicksearch}">
                <tr>
                    <td>${advert.jobId}</td>
                    <td>${advert.company}</td>
                    <td>${advert.jobLocation}</td>
                    <td>${advert.jobType}</td>
                    <td>${advert.jobDescrition}</td>
                    <td><a href="${pageContext.request.contextPath}/appliedjobs/${advert.jobId}.htm" class="btn btn-primary" role="button">Apply For Job</a></td>
                </tr>
            </c:forEach>
        </tbody>
								</table>

								

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

</body>

</html>
