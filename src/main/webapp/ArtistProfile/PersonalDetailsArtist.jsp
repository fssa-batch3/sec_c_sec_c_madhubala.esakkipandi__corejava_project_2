<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.fssa.glossyblends.model.*"%>
<link rel="stylesheet" type="text/css"
	href="./assets/css/ArtistProfile.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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

				<div class="list-of-details3" id="option3Content">

					<h3>Personal Details</h3>
					<hr>


					<%
					Artist artist = (Artist) request.getAttribute("artist");
					%>
					<div class="gathering_informations">

						<form action="UpdateArtistServlet" method="post">
							<input type="text" placeholder="Name" id="nameofartist"
								class="information-input" value=<%=artist.getUsername()%>>
							<input type="Address" placeholder="Address"
								class="information-input" id="artist_address"
								value=<%=artist.getLocation()%>> <input type="password"
								placeholder="Password" id="passwordofartist"
								class="information-input" id="artist_password"
								value=<%=artist.getPassword()%>> <input type="tel"
								placeholder="Phone-Number" class="information-input"
								id="artist_number" value=<%=artist.getPhonenNumber()%>>
							<input type="Number" placeholder="Experince_year"
								class="information-input" id="artist_experince"
								value=<%=artist.getYearsOfExperience()%>> <input
								type="text" placeholder="Languages Known"
								class="information-input" id="artist_language"
								value=<%=artist.getLanguagesSpoken()%>>
							<div class="gender">
								<label>Gender:</label> <label>Male</label> <input type="radio"
									name="genderOfArtist" value="MALE"
									<%if (artist.getGenderOfArtist() == Artist.gender.MALE)
	out.print("checked");%>>
								<label>Female</label> <input type="radio" name="genderOfArtist"
									value="FEMALE"
									<%if (artist.getGenderOfArtist() == Artist.gender.FEMALE)
	out.print("checked");%>>


								<input type="url" placeholder="Image Link" name="link_url"
									class="information-input" required pattern="https?://.+"
									title="Include http://" value="<%=artist.getImageurl()%>">
								<!-- Select element for locality -->
								<select id="locality" class="input-info" name="locality"
									value=<%=artist.getLocation()%> class="information-input">
									<option value="" disabled selected>Choose a city</option>
									<option id="city" value="chennai">Chennai</option>
									<option id="city" value="Trichy">Trichy</option>
									<option id="city" value="Tirunelveli">Tirunelveli</option>
									<option id="city" value="namakal">Namakal</option>
									<option id="city" required value="Theni">Theni</option>
									<option id="city" required value="Madurai">Madurai</option>
									<option id="city" required value="Ramnad">Ramanathapuram</option>
									<option id="city" required value="virudhunagar">Virudhunagar</option>
									<option id="city" required value="Dindugal">Dindugal</option>
									<option id="city" required value="chengalpat">Chengalpattu</option>
									<option id="city" required value="salem">Salem</option>
									<option id="city" required value="kadalur">Kdalur</option>
									<option id="city" required value="Nagapatinam">Nagapatinam</option>
								</select>
							</div>

							<button type="submit" class="information-input">Update</button>
						</form>
					</div>



				</div>

			</div>
		</div>
	</div>

	<script>
    // Get the selected location from artist.getLocation()
    var selectedLocation = '<%=artist.getLocation()%>
		';

		// Find the <select> element
		var selectElement = document.getElementById("locality");

		// Loop through the options and set the selected attribute for the matching option
		for (var i = 0; i < selectElement.options.length; i++) {
			if (selectElement.options[i].value === selectedLocation) {
				selectElement.options[i].selected = true;
				break; // Exit the loop once the matching option is found
			}
		}
	</script>

</body>
</html>