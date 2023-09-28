<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" type="text/css" href="artist.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/sweetalert2@10">

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="app.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
	integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
	crossorigin="anonymous" referrerpolicy="no-referrer">

</head>
<body>
	<div class="whole">
		<section>
			<div class="curve">
				<h1 class="heading">Join as an artist reveal your wokrs</h1>
			</div>
		</section>
		<div class="content-info">
			<div class="information">

				<h1>Reveal YOur Works</h1>
				<h3>
					<span class="italic">Y</span>our wok is a reflection of whco you
					are .so make it great "
				</h3>

				<h3 class="upper-font">our talent is God's gift to you.What you
					do with it is your gift back to god.</h3>
			</div>
			<IMG SRC="https://iili.io/J950Tqx.jpg" class="makeupitems">
		</div>
	</div>
	<div class="div">

		<div class="login_side">
			<h2>If you have already registered Login here</h2>
			<div class="form">
				<form id="login_form" method="post" action="ArtistLoginServlet">
					<br> <br> <label for="user" class="label">Email:</label>
					<br> <br> <input id="user" type="email" name="email"
						placeholder="Enter your email" required>
					<%
					if (request.getAttribute("emailError") != null) {
					%>
					<p class="error-message"><%=request.getAttribute("emailError")%></p>
					<%
					}
					%>
					<br> <br> <label for="pass" class="label">Password:</label>
					<br> <br> <input id="pass" type="password"
						name="password" placeholder="Enter your password" required>
					<%
					if (request.getAttribute("passwordError") != null) {
					%>
					<p class="error-message"><%=request.getAttribute("passwordError")%></p>
					<%
					}
					%>

					<br>
					<button type="submit" id="button_artist">Log-In</button>
				</form>

			</div>

		</div>

		<div class="register-side">

			<div class="right">
				<br>
				<h1>Create Your account</h1>
				<h3 class="title">If you did'nt register yet</h3>

				<li class="points">Accept our all rules</li> <a href="Register.jsp">
					<button class="btnn">Click here to register</button>
				</a>
			</div>

		</div>

		<a href></a>
	</div>

	<div class="ideas">

		<div class="points-of-ideas">
			<div class="Popular">
				<i class="fa-solid fa-fire"></i>
				<p>Don't just dream of becoming a popular makeup artist. Join us
					and make it a reality.</p>
			</div>
			<div class="works">

				<i class="fa-solid fa-image"></i>
				<p>The greatest satisfaction in work is knowing that you've made
					a satisfaction for someone</p>
			</div>
			<div class="post">
				<i class="fa-solid fa-cloud-arrow-up"></i>
				<p>Don't keep your amazing work hidden from the world. Share it
					with the world.</p>
			</div>
			<div class="Favotite">
				<i class="fa-solid fa-crown"></i>
				<P>Make every interaction with your customers a positive
					one.Become a favorite for coustomer</P>
			</div>

			<div class="Portfolio">
				<i class="fa-solid fa-print"></i>
				<P>Build Your portfolio.It is a reflection of your unique style
					and skill set. Make it count.</P>
			</div>
			<div class="Happyclients">
				<i class="fa-solid fa-face-smile"></i>
				<p>Be reliable, communicate clearly and respond promptly to
					client queries and feedback</p>
			</div>

		</div>
	</div>

	<div id="register">
		<i class="fa-solid fa-quote-left" id="top-quoat"></i>
		<p class="register-text">
			<span class="variatn-color">D</span> on't wait for someone else to
			discover your talent.<br> <span class="variatn-color">T</span>ake
			control of your career and register as an artist today
		</p>
		<i class="fa-solid fa-quote-left fa-rotate-180" id="bot-quoat"></i>


	</div>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script>
<%String errorMsg = (String) request.getAttribute("emailError");
String PassworderrorMsg = (String) request.getAttribute("passwordError");
String path = (String) request.getAttribute("pathd");


System.out.println(PassworderrorMsg + " Succesmsg ----  errormsg " + errorMsg + "path :" + path);
if (PassworderrorMsg != null) {%>
    <%System.out.print(PassworderrorMsg + "inside");%>
    swal("Failed!","<%=PassworderrorMsg%>", "error");
    setTimeout(() => {
        console.log("df");
        window.location.href="<%=path%>";
    }, 4000);
<%}%>

<%if (errorMsg != null) {%>
    console.log("<%=errorMsg%>");
    <%System.out.print(errorMsg + "inside");%>
    swal("Failed!","<%=errorMsg%>", "error");
    setTimeout(() => {
        console.log("df");
        window.location.href="<%=path%>";
    }, 4000);
<%}%>


		
		
		
		
</script>



</body>
</html>