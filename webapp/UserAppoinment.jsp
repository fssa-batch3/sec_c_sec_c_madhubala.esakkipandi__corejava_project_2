<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.fssa.glossyblends.model.*"%>
<%@ page import="com.fssa.glossyblends.service.ArtistService"%>
<%@ page import="java.util.List"%>
<link rel="stylesheet" type="text/css"
	href="././assets/css/ArtistProfile.css">
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
				<div class="list-of-details" id="option1Content" onclick="">


					<%
					List<Booking> bookings = (List<Booking>) request.getAttribute("listOfPending");
					%>

					<div class="list-of-appoinment-user" id="appoinments">
						<div class="head-appoinment">
							<h3 class="heading">Appoinments List</h3>
							<hr>
						</div>

						<%
						if (bookings != null && !bookings.isEmpty()) {
						%>
						<%
						for (Booking book : bookings) {
						%>
						<div class="information-appointments" id="listOfAppoinments">
							<%
							int artistId = book.getArtistId();
							ArtistService artistService = new ArtistService();
							Artist artist = artistService.getArtistById(artistId); // No need for explicit casting
							String artistName = artist.getUsername();
							%>
							<div class="date">
								<h4><%=book.getDate()%></h4>
							</div>
							<div class="time">
								<p><%=book.getTimeOfEvent()%></p>
							</div>
							<div class="selected_artist_name">
								<p>
									Your booking with
									<%=artistName%>
									is on pending with a total cost of
									<%=book.getTotalAmount()%>
								</p>
							</div>
							<div class="selecteditems">

								<a
									href="ServicesSelected?BookingId=<%=book.getBookingId()%>&ArtistId=<%=book.getArtistId()%>&UserId=<%=book.getUserId()%>">
									<button class="see_more">See More</button>
								</a>

							</div>
						</div>
						<hr>
						<%
						}
						%>
						<%
						} else {
						%>
						<p class="notify_pending">No pending appointments available.
						</p>
						<img src="././assets/images/not found.png" class="not_found">
						<%
						}
						%>
					</div>


				</div>
			</div>
		</div>
	</div>
	</div>

</body>
</html>