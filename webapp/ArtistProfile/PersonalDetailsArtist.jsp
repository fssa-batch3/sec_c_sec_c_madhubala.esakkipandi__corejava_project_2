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
								class="information-input" value=<%=artist.getUsername()%>
								name="name"> <input type="Address" placeholder="Address"
								class="information-input" id="artist_address"
								value=<%=artist.getLocation()%> name="locality"> <input
								type="password" placeholder="Password" id="passwordofartist"
								class="information-input" id="artist_password"
								value=<%=artist.getPassword()%> name="password"> <input
								type="tel" placeholder="Phone-Number" class="information-input"
								id="artist_number" value=<%=artist.getPhonenNumber()%>
								name="number"> <input type="Number"
								placeholder="Experince_year" class="information-input"
								id="artist_experince" value=<%=artist.getYearsOfExperience()%>
								name="expernice-artist"> <input type="text"
								placeholder="Languages Known" class="information-input"
								id="artist_language" value=<%=artist.getLanguagesSpoken()%>
								name="language"> <input type="url"
								placeholder="Image Link" name="link_url"
								class="information-input" required pattern="https?://.+"
								title="Include http://" value="<%=artist.getImageurl()%>">
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

							<button type="submit" class="information-input" id="updatebtn">Update</button>
						</form>
					</div>



				</div>

			</div>
		</div>
	</div>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

	<script>
<%String errorMsg = (String) request.getAttribute("error");
String successMsg = (String) request.getAttribute("success");
String path = (String) request.getAttribute("path");
System.out.println(successMsg + " Succesmsg ----  errormsg " + errorMsg + "path :" + path);
if (errorMsg != null) {%>
		
		<%System.out.print(errorMsg + "inside");%>
		swal("Failed!","<%=errorMsg%>", "error");
		setTimeout(() => {
			console.log("df");
			window.location.href="";
		}, 1000);
		
	<%}%>
		
		<%if (successMsg != null) {%>
		console.log("<%=successMsg%>");
		<%System.out.print(successMsg + "inside");%>
		swal("Success!"," <%=successMsg%>", "success");
		setTimeout(() => {
			console.log("df");
			window.location.href="<%=path%>";
		}, 1000);
		<%}%>
</script>


</body>
</html>