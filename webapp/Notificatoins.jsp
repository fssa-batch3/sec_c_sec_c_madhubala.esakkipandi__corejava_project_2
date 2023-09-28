<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<div class="full-content">

		<jsp:include page="./Header.jsp"></jsp:include>

		<div class="main-content-user">
			<div class="header">
				<h3>Profile of the user</h3>
				<hr>
			</div>
			<div class="details">
				<jsp:include page="./Profile.jsp"></jsp:include>
	<div class="list-of-details4" id="option4Content">
		<h3>Notifications</h3>
		<hr>
		<div class="notifiactionbox" id="notification">
			`
			<div class="notifibox">

				<div class="decoration-line"></div>
				<div class="img">
					<i class="fa-solid fa-exclamation"></i>
				</div>

				<h4 class="Booking-alert"></h4>
			</div>
			`
		</div>
	</div>

</div>
</div>
</div>

</body>
</html>