<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" type="text/css"
	href="./../assets/css/ArtistProfile.css">
	
	
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <script src="../js/Calender.js"></script>
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
				<div class="list-of-details2" id="option2Content">

					<h2>Schedules</h2>
					<hr>
					<div class="wrapper">

						<header>
							<p class="current-date"></p>
							<div class="icons">
								<span id="prev" class="material-symbols-rounded">chevron_left</span>
								<span id="next" class="material-symbols-rounded">chevron_right</span>
							</div>
						</header>
						<div class="calendar">
							<ul class="weeks">
								<li>Sun</li>
								<li>Mon</li>
								<li>Tue</li>
								<li>Wed</li>
								<li>Thu</li>
								<li>Fri</li>
								<li>Sat</li>
							</ul>
							<ul class="days"></ul>
						</div>
					</div>



					<div class="div">


						<h1>Here is the you list appoinment dates</h1>




					</div>



				</div>


				<form class="popup-form">
					<h3>Add your event dates</h3>
					<input type="text" placeholder="Event Name" id="popup-event-name">
					<br> <input type="time" id="popup-time"> <br>
					<button type="submit" class="btn">Add</button>
				</form>
			</div>

		</div>
	</div>

</body>
</html>

