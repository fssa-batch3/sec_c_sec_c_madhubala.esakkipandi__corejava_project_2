<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.fssa.glossyblends.model.*"%>
<%@ page import="com.fssa.glossyblends.service.*"%>

<%@ page import="com.fssa.glossyblends.service.ArtistService"%>
<%@ page import="java.util.List"%>
<link rel="stylesheet" type="text/css"
	href="./assets/css/ArtistProfile.css">
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table {
	width: 100%;
	border-collapse: collapse;
}

table, th, td {
	border: 1px solid #ccc;
}

th, td {
	padding: 10px;
	text-align: left;
}

button {
	padding: 5px 10px;
	background-color: #0074d9;
	color: #fff;
	border: none;
	cursor: pointer;
}

button.approve-btn {
	background-color: #2ecc40;
}
</style>
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
				<div class="list-of-details4" id="option4Content">

					<h3>Notifications</h3>
					<hr>
					<div class="notifiactionbox" id="notification">

						<!-- <div class="notifibox">

                            <div class="decoration-line">

                            </div>
                            <div class="img">
                                <i class="fa-solid fa-exclamation"></i>
                            </div>
                            <h4 class="Booking-alert">You have booked the Madhubala for Feb14</h4>
                            <button>Approve</button>
                            <button>Skip</button>
                        </div> -->
						<div class="hole_notification">





							<%
							List<Booking> book = (List<Booking>) request.getAttribute("listOfPending");
							%>


							<%
							for (Booking books : book) {
							%>


							<%
							UserService user = new UserService();
							User users = user.getUserById(books.getUserId());
							%>

							<div class="notification_history">

								<table>
									<tr>
										<th colspan="2">Details of the requested customer</th>
									</tr>
									<tr>
										<td>Name:</td>
										<td><%=users.getName()%></td>
									</tr>

									<tr>
										<td>Venue:</td>
										<td><%=books.getLocation()%></td>
									</tr>
									<tr>
										<td>Date Of Event:</td>
										<td><%=books.getDate()%></td>
									</tr>
									<tr>
										<td>Time:</td>
										<td>20:12</td>
									</tr>
									<tr>
										<td colspan="2">
											<button class="approve-btn"
												data-booking-id="<%=books.getBookingId()%>">Accept</button>
											<button>Reject</button> <a
											href="getRequestServices?BookingId=<%=books.getBookingId()%>&ArtistId=<%=books.getArtistId()%>&UserId=<%=books.getUserId()%>">

											see	more
												</button>
										</a>
										</td>
									</tr>
								</table>






							</div>


							<%
							}
							%>


						</div>





					</div>

				</div>
			</div>
		</div>
	</div>



	<script>
		$(document)
				.ready(
						function() {
							$('.approve-btn')
									.click(
											function() {
												// Get the booking ID associated with the clicked button
												var bookingId = $(this).data(
														'booking-id');

												$
														.ajax({
															type : "POST",
															url : "http://localhost:8080/glossyblends-webapp/StatusUpdate",
															data : {
																bookingId : bookingId,
																status : "Confirmed"
															},
															success : function(
																	response) {
																console
																		.log("Success: "
																				+ response);

																location
																		.reload();
															},
															error : function(
																	xhr,
																	status,
																	error) {
																console
																		.error(xhr.responseText);
															}
														});
											});
						});
	</script>
</body>
</html>