<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" type="text/css"
	href="././assets/css/ArtistProfile.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="sidebar-user" id="side-bar">
	<a href="<%=request.getContextPath() %>/GetPendingListBooking">
		<div class="Appoinment-records" id="option1">
			<div class="border">
				<img src="././assets/images/writing.png" class="icon-appoinmnet">
			</div>
			<h6>Pending List</h6>
		</div>
		</a>

		<a href="./getConfirmedBooking">
			<div class="Schedules-record" id="option2">
				<div class="border">
					<img src="././assets/images/schedule.png" class="icon-appoinmnet">
				</div>
				<h6>Accepted Records</h6>
			</div>
		</a> <a href="UpdateProfile">
			<div class="Personal-details" id="option3">
				<div class="border">
					<img src="././assets/images/user.png" class="icon-appoinmnet">
				</div>
				<h6>Personal Details</h6>
			</div>
		</a>
		<div class="Notification-record" id="option4">
			<div class="border">
				<img src="././assets/images/bell.png" class="icon-appoinmnet">
			</div>
			<h6>Notifications</h6>
		</div>
		<div class="Remainder" id="option5">
			<div class="border">
				<img src="././assets/images/contract.png" class="icon-appoinmnet">
			</div>
			<h6>Wishlist</h6>
		</div>
		<a href="<%=request.getContextPath() %>/getSuccessFulBooking">
		<div class="Remainder" id="option6">
			<div class="border">
				<img src="././assets/images/contract.png" class="icon-appoinmnet">
			</div>
			<h6>History</h6>
		</div>
		</a>
	</div>

	<script>
const Option1 = document.getElementById("option1");
const Option2 = document.getElementById("option2");
const Option3 = document.getElementById("option3");
const Option4 = document.getElementById("option4");
const Option5 = document.getElementById("option5");
const Option6 = document.getElementById("option6");

Option1.addEventListener("click", () => {
    window.location.href = "UserAppoinment.jsp";
});

Option2.addEventListener("click", () => {
    window.location.href = "AcceptedRecord.jsp";
});

Option3.addEventListener("click", () => {
    window.location.href = "PersonalDEtails.jsp";
});

Option4.addEventListener("click", () => {
    window.location.href = "Notificatoins.jsp";
});

Option5.addEventListener("click", () => {
    window.location.href = "Wishlist.jsp";
});

Option6.addEventListener("click", () => {
    window.location.href = "BookingHistory.jsp";
});
</script>
</body>
</html>
