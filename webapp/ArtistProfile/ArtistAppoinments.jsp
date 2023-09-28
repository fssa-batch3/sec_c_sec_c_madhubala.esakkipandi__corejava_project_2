<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.fssa.glossyblends.model.*"%>
<%@ page import="com.fssa.glossyblends.service.*"%>

<%@ page import="com.fssa.glossyblends.service.ArtistService"%>
<%@ page import="java.util.List"%>
<%@ page import="java.time.LocalDate"%>



<link rel="stylesheet" type="text/css"
	href="./assets/css/ArtistProfile.css">
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200">
<script src="script.js" defer></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
	integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
	crossorigin="anonymous" referrerpolicy="no-referrer">

</head>

<body>

	<div class="full-content">
		<jsp:include page="HeaderArtist.jsp"></jsp:include>


		<div class="main-content">
			<div class="header">
				<h3>Profile of the artist</h3>
				<hr>
			</div>
			<div class="details">
				<jsp:include page="Profile.jsp"></jsp:include>


				<!-- <div class="content" id="content"> -->
				<!-- ------------------------------ -->
				<div class="list-of-details" id="option1Content">
					<div class="info">
						<div class="cancel">
							<canvas id="myChart"></canvas>
						</div>
						<div class="information_about_booking">

							<div class="count_information">


								<div class="box_color_passed"></div>

								<div class="count_info">

									<p>0 Passed Appoinment</p>
								</div>
							</div>

							<!-- ---------------- -->

							<div class="count_information2">


								<div class="box_color_passed upcomming_color"></div>

								<div class="count_info">

									<p>0 upcoming Appoinment</p>
								</div>
							</div>
							<!-- ----------------- -->
							<div class="count_information3">


								<div class="box_color_passed total_color"></div>

								<div class="count_info">

									<p>0 total Appoinment</p>
								</div>
							</div>
							<!-- ---------------------------------- -->

						</div>



					</div>

					<div class="list-of-appoinments" id="appoinments">
						<div class="head-appoinment">
							<h3 class="head">Appointments List</h3>
							<hr>
						</div>

						<%
						List<Booking> book = (List<Booking>) request.getAttribute("listOfSuccessFullBooking");
						%>
						<%
						if (book != null && !book.isEmpty()) {
						%>
						<%
						for (Booking books : book) {
							
							
							UserService userservice=new UserService();
							User user=userservice.getUserById(books.getUserId());
						%>
						
						
						<div class="requests" id="appointmentId">
							<div class="date">
								<h4><%=books.getDate()%></h4>
							</div>
							<div class="time">
								<p><%=books.getTimeOfEvent() %></p>
							</div>
							<div class="name-of-make">
								<p><%=user.getName()%></p>
							</div>
							<div class="location-appointment">
								<p><%=books.getLocation()%></p>
							</div>
							<div class="cost">
								<p><%=books.getTotalAmount()%></p>
							</div>
						</div>
						<hr>
						<%
						}
						%>
						<%
						} else {
						%>
						<p>No appointments available</p>
						<%
						}
						%>
					</div>



				</div>








			</div>

		</div>

	</div>





</body>

</html>
