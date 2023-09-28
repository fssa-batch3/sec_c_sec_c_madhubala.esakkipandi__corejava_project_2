<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" type="text/css"
	href="././assets/css/register.css">


<%@ page import="com.fssa.glossyblends.model.*"%>
<%@ page import="com.fssa.glossyblends.service.ArtistService"%>
<%@ page import="java.util.List"%>
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

				<div class="list-of-details2_user" id="option2Content">



					<div class="accepted_record" id="record_accept">

						<h3 class="heading">Your Accepted Records</h3>


						<%
						List<Booking> book = (List<Booking>) request.getAttribute("listOfConfirmed");
						%>

						<%
						if (book != null) {
						%>
						<div class="content_booking_history">
							<%
							for (Booking booking : book) {
							%>

							<%
							int artistId = booking.getArtistId();
							ArtistService artistService = new ArtistService();
							Artist artist = artistService.getArtistById(artistId); // No need for explicit casting
							String artistName = artist.getUsername();
							%>

							<div class="content_confirmed">

								<div class="cont">
									<p>
										Date: <span class="bolding_letters"><%=booking.getDate()%></span>
									</p>

									<p>
										place:<span class="bolding_letters"><%=booking.getLocation()%></span>
									</p>
									<p>
										Selected artist:<span class="bolding_letters"><%=artistName%></span>
									</p>
									<p>
										contact<span class="bolding_letters"><%=artist.getPhonenNumber()%></span>
									</p>
									<p>
										Cost:<span class="bolding_letters"><%=booking.getTotalAmount()%></span>
									</p>

								</div>
								<div class="paybtn">
								<p>Click here to procceed to payment</p>
									<a
										href="PaymentServlet?booking_Id=<%=booking.getBookingId()%>&user_Id=<%=booking.getUserId()%>&artist_Id=<%=booking.getArtistId()%>"
										class="proceed"><button class="proceedbtn">
											 Payment</button></a>

								</div>

							</div>


							<%
							}
							%>
						</div>
						<%
						} else {
						%>

						<p>There are no confirmed records</p>

						<%
						}
						%>




					</div>
				</div>
			</div>
		</div>
	</div>




	`
</body>
</html>