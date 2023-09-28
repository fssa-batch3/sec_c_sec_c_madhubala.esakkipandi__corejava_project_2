<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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

				<div class="list-of-details6_user" id="option6Content">

					<h3 class="heading">Your booking history</h3>
					<hr>
					<div class="content_booking_history">

						<%
						List<Booking> booking = (List<Booking>) request.getAttribute("listOfSuccessFullBooking");
						%>

						<%
						for (Booking bok : booking) {
						%>

						<div class="content_confirmed_history">

							<p>
								Date: <span class="bolding_letters"><%=bok.getDate()%> </span>
							</p>
						
							<p>
								place:<span class="bolding_letters"><%=bok.getAddress()%>
								</span>
							</p>
							<p>

								<%
								ArtistService artist = new ArtistService();
								Artist artists = artist.getArtistById(bok.getArtistId());
								
								%>
								Selected artist:<span class="bolding_letters"><%=artists.getUsername()%>
								</span>
							</p>

							<p>
								Cost:<span class="bolding_letters"><%=bok.getTotalAmount()%>
								</span>
							</p>
							
							<p>
								Cost:<span class="bolding_letters"><%=artists.getPhonenNumber()%>
								</span>
							</p>
						</div>
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