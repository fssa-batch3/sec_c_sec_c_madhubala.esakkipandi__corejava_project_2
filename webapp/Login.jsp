<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" href="././assets/css/Login.css">

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width" , initial-scale="1.0">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
	integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
	crossorigin="anonymous" referrerpolicy="no-referrer">
<title>Document</title>
</head>

<body>
	<!-- whole section starts -->
	<div class="login">
		<!--  left side content starts-->
		<div class="log2">

			<div class="left">
				<!-- <img src="../../assets/images/Screenshot__63_-removebg-preview.png" class="log" alt="logo"> -->

				<h2>WELCOME BACK</h2>
				<p class="keep">keep connected with us</p>
				<!-- <img src="../../assets/images/3099609.jpg" class="loginn"> -->
				<img src="././assets/images/Mobile login-rafiki.svg" class="pic">
			</div>
			<!-- left side content ends -->

			<!-- right side content starts -->
			<div class="right">
				<div class="lay">
					<h3 class="vio">LOG-IN</h3>

					<form action="UserLoginServlet" method="post">

						<label for="user">
							<p>Email:</p>
						</label> <input id="user" type="email" placeholder="Enter your email"
							required name="email"> <label for="pass"> <%
 if (request.getAttribute("emailError") != null) {
 %>
							<p class="error-message"><%=request.getAttribute("emailError")%></p>
							<%
							}
							%>
							<p>Password:</p>
						</label> <input id="pass" type="password" placeholder="Enter your name"
							required name="password">
						<%
						if (request.getAttribute("passwordError") != null) {
						%>
						<p class="error-message"><%=request.getAttribute("passwordError")%></p>
						<%
						}
						%>

						<div class="foot">
							<div class="checkbox-remember">
								<input type="checkbox" required> <label for="check">Remember
									me</label>
							</div>

							<a href="#">Forget password?</a>

						</div>
						<div class="options_of_user">


							<button id="button_user" type="submit">Login</button>
						</div>
						<br> <br>

						<p class="sing">OR SIGN-UN WITH</p>

						<div class="logos">
							<i id="insta" class="fa-brands fa-instagram"></i> <i id="insta"
								class="fa-brands fa-facebook"></i> <i id="insta"
								class="fa-brands fa-square-twitter"></i>
						</div>
						<p class="do">
							Don't have an account?<a href="signUp.jsp"
								class="sign_up">sign-up</a>
						</p>
					</form>

				</div>
			</div>
			<!-- rightside content ends -->
		</div>
	</div>
	<!-- whole section ends -->

	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script>
<%String errorMsg = (String) request.getAttribute("emailError");
String PassworderrorMsg = (String) request.getAttribute("passwordError");

System.out.println(PassworderrorMsg + " Succesmsg ----  errormsg " + errorMsg + "path :");
if (PassworderrorMsg != null) {%>
    <%System.out.print(PassworderrorMsg + "inside");%>
    swal("Failed!","<%=PassworderrorMsg%>", "error");
    setTimeout(() => {
        console.log("df");
        window.location.href="Login.jsp";
    }, 4000);
<%}%>

<%if (errorMsg != null) {%>
    console.log("<%=errorMsg%>");
    <%System.out.print(errorMsg + "inside");%>
    swal("Failed!","<%=errorMsg%>", "error");
    setTimeout(() => {
        console.log("df");
        window.location.href="Login.jsp";
    }, 4000);
<%}%>


		
		
		
		
</script>


</body>

</html>