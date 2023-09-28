<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" type="text/css"
	href="././assets/css/register.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="./../assets/css/register.css">
</head>
<body>





	<div class="div-form">

		<div class="side-bar">
			<h1 class="head">
				Register and keep your<br> work protective

			</h1>
			<img src="././assets/images/register-artist.svg">
		</div>


		<form id="cardform" method="post" action="AddArtistServlet">
			<input type="text" class="input-info" placeholder="Username"
				name="username" required pattern="[A-Za-z\\s]+"
				title="Please enter only letters spaces are allowed"> <input
				type="email" class="input-info" placeholder="Email" name="email"
				required pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"
				title="Please enter a valid email address"> <input
				type="password" class="input-info" placeholder="Password"
				name="password" required
				title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
				pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"> <input
				type="number" class="input-info" placeholder="Years of Experience"
				name="expernice-artist" required pattern="[0-9]+"
				title="Please enter only numbers"> <input type="text"
				class="input-info" placeholder="Contact Number" name="number-artist">
			<input type="url" placeholder="Image Link" name="link_url"
				class="input-info" required pattern="https?://.+"
				title="Include http://"> <select id="locality"
				class="input-info" name="locality">
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
			<div class="gender">
				<label>Gender:</label> <label>Male</label> <input type="radio"
					name="genderOfArtist" value="MALE"> <label>Female</label> <input
					type="radio" name="genderOfArtist" value="FEMALE">
			</div>
			 <input type=text
				class="input-info" placeholder=" Known Languages" name="language">
			<br> <br>
			<button type="submit" placeholder="Register" class="btn-register">Register</button>


		</form>


	</div>

	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script>
    <% 
    String errorMsg = (String) request.getAttribute("errorMessage");
    String success = (String) request.getAttribute("success");
    String path = (String) request.getAttribute("path");
    System.out.println("Success message: " + success + " | Error message: " + errorMsg + " | Path: " + path);
    
    if (errorMsg != null) {
    %>
        swal("Failed!", "<%=errorMsg%>", "error");
        setTimeout(() => {
            console.log("Redirecting...");
            window.location.href = "Register.jsp";
        }, 1000);
    <% } %>

    <% if (success != null) { %>
        swal("Success!", "<%=success%>", "success");
        setTimeout(() => {
            console.log("Redirecting...");
            window.location.href = "Artist.jsp";
        }, 1000);
    <% } %>
</script>


</body>
</html>
