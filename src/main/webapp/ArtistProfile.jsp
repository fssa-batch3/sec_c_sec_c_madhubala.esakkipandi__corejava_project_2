<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.fssa.glossyblends.model.*"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Profile</title>
<link rel="stylesheet" type="text/css"
	href="./../assets/css/register.css">
</head>
<body>
	<div class="div-form">

		<%
		Artist artist = (Artist) request.getAttribute("artist");
		%>
		<div class="side-bar">
			<h1 class="head">Update Your Profile</h1>
			<h3 class="name_artist">
				HI
				<%=artist.getUsername()%>
				!!
			</h3>

			<img src=<%=artist.getImageurl()%>>
			<form action="DeleteArtistServlet" method="post">
				<input type="hidden" name="action" value="deleteArtist">
				<button type="submit" class="btn-register delete">Delete</button>
			</form>

		</div>




		<form id="cardform" method="post" action="UpdateArtistServlet">
			<input type="text" class="input-info" placeholder="Username"
				name="username" required pattern="[A-Za-z]+"
				title="Please enter only letters"
				value="<%=(artist != null) ? artist.getUsername() : ""%>"> <input
				type="email" class="input-info" placeholder="Email" name="email"
				required pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"
				title="Please enter a valid email address"
				value="<%=(artist != null) ? artist.getEmail() : ""%>"> <input
				type="password" class="input-info" placeholder="Password"
				name="password"
				title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
				pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
				value="<%=(artist != null) ? artist.getPassword() : ""%>"> <input
				type="number" class="input-info" placeholder="Years of Experience"
				name="expernice-artist" required pattern="[0-9]+"
				title="Please enter only numbers"
				value="<%=artist.getYearsOfExperience()%>"> <input
				type="text" class="input-info" placeholder="Contact Number"
				name="number-artist" value="<%=artist.getPhonenNumber()%>">
			<input type="url" placeholder="Image Link" name="link_url"
				class="input-info" required pattern="https?://.+"
				title="Include http://" value="<%=artist.getImageurl()%>">
			<!-- Select element for locality -->
			<select id="locality" class="input-info" name="locality"
				value=<%=artist.getLocation()%>>
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
			<!-- Gender radio buttons -->
			<div class="gender">
				<label>Gender:</label> <label>Male</label> <input type="radio"
					name="genderOfArtist" value="MALE"
					<%if (artist.getGenderOfArtist() == Artist.gender.MALE)
	out.print("checked");%>>
				<label>Female</label> <input type="radio" name="genderOfArtist"
					value="FEMALE"
					<%if (artist.getGenderOfArtist() == Artist.gender.FEMALE)
	out.print("checked");%>>
			</div>
			<!-- Checkbox for availability -->
			<input type="checkbox" id="isAvailable" name="isAvailable"
				value="true" <%if (artist.isAvailable())
	out.print("checked");%>>
			<label for="isAvailable">Available</label> <label for="language">Known
				Languages</label> <input type="text" class="input-info"
				placeholder="Languages" name="language"
				value="<%=artist.getLanguagesSpoken()%>"> <br> <br>
			<button type="submit" placeholder="Update Profile"
				class="btn-register">Update Profile</button>

		</form>




	</div>
</body>
</html>
