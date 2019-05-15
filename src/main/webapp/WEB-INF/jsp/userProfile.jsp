<!DOCTYPE HTML>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">

<title>User Profile Manager | Home</title>

<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">



<!-- [if lt IE 9]>
	<script src="static/js/html5shiv.min.js"></script>
	<script src="static/js/respond.min.js"></script>
	 <![endif]-->

</head>
<body>

	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Ubaid's Sample project for
				Spring Boot, Spring Data JPA, MySQL & JSP</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">

					<li><a href="newUserProfile">New User Profile</a></li>
					<li><a href="allUserProfiles">All User Profiles</a></li>
				</ul>
			</div>
		</div>
	</div>

	<c:choose>

		<c:when test="${mode == 'MODE_HOME'}">

			<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1>Welcome to User Profile Manager</h1>
				</div>
			</div>

		</c:when>

		<c:when test="${mode == 'MODE_USERPROFILES'}">
			<div class="container text-center" id="userProfileDiv">
				<h3>My User Profiles</h3>
				<hr>
				<div class="table-responsive">

					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>

								<th>S.#</th>
								<th>Title</th>
								<th>First Name</th>
								<th>Middle Name</th>
								<th>Last Name</th>
								<th>Father Name</th>
								<th>CNIC</th>
								<th>Email</th>
								<th>Fax</th>
								<th>Address</th>
								<th>District</th>
								<th>Phone Number</th>
								<th>Mobile Number</th>
								<th>Emergency Contact Number</th>
								<th>ZIP Code</th>
								<th>Date of Birth (MM/dd/yyyy)</th>
								<th>Date of Joining (MM/dd/yyyy)</th>
								<th>Date of Leaving (MM/dd/yyyy)</th>
								<th>Gender</th>
								<th>Marital Status</th>
								<th>isActive</th>
								<th>Edit</th>
								<th>Delete</th>


							</tr>
						</thead>
						<tbody>

							<c:forEach var="userProfile" items="${userProfiles}">

								<tr>
									<td>${userProfile.userProfileId}</td>
									<td>${userProfile.title}</td>
									<td>${userProfile.firstName}</td>
									<td>${userProfile.middleName}</td>
									<td>${userProfile.lastName}</td>
									<td>${userProfile.fatherName}</td>
									<td>${userProfile.CNIC}</td>
									<td>${userProfile.email}</td>
									<td>${userProfile.fax}</td>
									<td>${userProfile.address}</td>
									<td>${userProfile.district}</td>
									<td>${userProfile.phoneNumber}</td>
									<td>${userProfile.mobileNumber}</td>
									<td>${userProfile.emergencyContactNumber}</td>
									<td>${userProfile.zipCode}</td>

									<td><fmt:formatDate pattern="MM/dd/yyyy"
											value="${userProfile.dateOfBirth}" /></td>

									<td><fmt:formatDate pattern="MM/dd/yyyy"
											value="${userProfile.dateOfJoining}" /></td>

									<td><fmt:formatDate pattern="MM/dd/yyyy"
											value="${userProfile.dateOfLeaving}" /></td>

									<td>${userProfile.gender}</td>
									<td>${userProfile.maritalStatus}</td>

									<td>${userProfile.isActive}</td>


									<td><a
										href="updateUserProfile?userProfileId=${userProfile.userProfileId}"><span
											class="glyphicon glyphicon-pencil"></span></a></td>

									<td><a
										href="deleteUserProfile?userProfileId=${userProfile.userProfileId}"
										onClick="return confirm('Are you sure you want to delete this item?');"><span
											class="glyphicon glyphicon-trash"></span></a></td>

								</tr>

							</c:forEach>

						</tbody>
					</table>

				</div>
			</div>
		</c:when>

		<c:when test="${mode == 'MODE_NEW' || mode == 'MODE_UPDATE'}">

			<div class="container text-center">
				<h3>Manage User Profile</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="saveUserProfile">
					<input type="hidden" name="id" value="${userProfile.userProfileId}" />

					<div class="form-group">
						<label class="control-Label col-md-3">Title: <font
							color="red">*</font></label> <select name="${status.expression}"
							name="titleLst" id="titleLst">
							<option value=""></option>

							<c:forEach items="${titleList}" var="option">
								<option value="${option}">
									<c:out value="${option}"></c:out>
								</option>
							</c:forEach>
						</select>
					</div>

					<div class="form-group">
						<label class="control-Label col-md-3">First Name: <font
							color="red">*</font></label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="firstName"
								placeholder="First Name..." value="${userProfile.firstName}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-Label col-md-3">Middle Name: </label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="middleName"
								placeholder="Middle Name..." value="${userProfile.middleName}" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-Label col-md-3">Last Name: <font
							color="red">*</font></label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="lastName"
								placeholder="Last Name..." value="${userProfile.lastName}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-Label col-md-3">Father Name: <font
							color="red">*</font></label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="fatherName"
								placeholder="Father Name..." value="${userProfile.fatherName}" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-Label col-md-3">Date of Birth:
							(MM-dd-yyyy)<font color="red">*</font>
						</label>
						<div class="col-md-7">
							<input type="text" class="form-control" id="datepicker"
								value="${userProfile.dateOfBirth}" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-Label col-md-3">Date of Joining:
							(MM-dd-yyyy)<font color="red">*</font>
						</label>
						<div class="col-md-7">
							<input type="text" class="form-control" id="datepicker"
								value="${userProfile.dateOfJoining}" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-Label col-md-3">Gender: <font
							color="red">*</font></label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="gender"
								placeholder="Male, Female..." value="${userProfile.gender}" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-Label col-md-3">Marital Status: <font
							color="red">*</font></label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="maritalStatus"
								placeholder="Single, Married, Divorced, Widowed..."
								value="${userProfile.maritalStatus}" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-Label col-md-3">CNIC: <font
							color="red">*</font></label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="CNIC"
								placeholder="CNIC..." value="${userProfile.CNIC}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-Label col-md-3">Email: <font
							color="red">*</font></label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="email"
								placeholder="Email..." value="${userProfile.email}" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-Label col-md-3">Fax: </label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="fax"
								placeholder="Fax..." value="${userProfile.fax}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-Label col-md-3">Address: <font
							color="red">*</font></label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="address"
								placeholder="Address..." value="${userProfile.address}" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-Label col-md-3">District: </label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="district"
								placeholder="District..." value="${userProfile.district}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-Label col-md-3">Phone Number: </label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="phoneNumber"
								placeholder="Phone Number..." value="${userProfile.phoneNumber}" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-Label col-md-3">Mobile Number: </label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="mobileNumber"
								placeholder="Mobile Number..."
								value="${userProfile.mobileNumber}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-Label col-md-3">Emergency Contact
							Number: </label>
						<div class="col-md-7">
							<input type="text" class="form-control"
								name="emergencyContactNumber"
								placeholder="Emergency Contact Number..."
								value="${userProfile.emergencyContactNumber}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-Label col-md-3">ZIP Code: </label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="zipCode"
								placeholder="ZIP Code..." value="${userProfile.zipCode}" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-Label col-md-3">isActive: </label>
						<div class="col-md-7">
							<input type="radio" class="col-sm-1" name="isActive" value="true" />
							<div class="col-sm-1">Yes</div>

							<input type="radio" class="col-sm-1" name="isActive"
								value="false" checked />
							<div class="col-sm-1">No</div>
						</div>
					</div>

					<div class="form-group">
						<input type="submit"
							onclick="javascript:window.location.reload(true);"
							class="btn btn-primary" value="Save"> <input type="reset"
							class="btn btn-primary" value="Reset" />
					</div>
				</form>
			</div>

		</c:when>

		<c:when test="${mode == 'MODE_UPDATE'}">

		</c:when>

	</c:choose>


	<script src="static/js/jquery-3.1.1.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
	<script src="static/js/jQuery.js"></script>

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script>
		$(function() {
			$("#datepicker").datepicker();
		});
	</script>
</body>

</html>