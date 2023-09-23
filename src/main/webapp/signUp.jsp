<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" href="././assets/css/SignUp.css">

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>

</head>

<body>
	<!-- whole content starts -->
	<!-- <div class="hle"> -->
	<!-- msin content starts -->
	<div class="signupp">
		<!-- leftside of main content starts -->
		<div class="left">
			<img src="././assets/images/Mobile login-pana.svg" alt="login-img">
		</div>
		<!-- left side of main content ends -->
		<!-- Right side of main content starts -->
		<div class="right">
			<h1>signup</h1>
			<form id="form" action="AddUserServlet" method="post">
				<br> <br> <br> <label> <input type="text"
					placeholder="Full Name..." id="name" required pattern="[A-Za-z]+"
					title="Please enter only letters" name="name">
				</label> <br> <label> <input type="email"
					placeholder="Email..." id="email"
					pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" required
					title="Please enter a valid email address" name="email">
				</label> <br> <label> <input type="password"
					placeholder="Password..." id="password"
					title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
					pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required
					name="password">
				</label> <br> <label> <input type="password"
					placeholder=" Repeat Password..." id="repeat"
					title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
					pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required
					name="repeat-password">
				</label> <br> <br>
				<div class="terms_and_conditions">
					<input type="checkbox" value="checkbox" id="box"> <label
						for="box"> I am agree with <strong>Termsof user</strong>
					</label>
				</div>
				<br> <br>
				<div class="btn">
					<!-- <button><a href="../../index.html">sign-up</a></button> -->
					<button type="submit">sign-up</button>
					<p>
						<a href="../Login/login.html" class="link">signin →</a>
					</p>
				</div>
			</form>
		</div>
		<!-- rightside of main content ends -->
	</div>
	<!-- main content ends -->
	<!-- </div> -->
	<!-- whole content ends -->
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script>
<%String errorMsg = (String) request.getAttribute("Error");
String path = (String) request.getAttribute("ErrorPath");


System.out.println( " Succesmsg ----  errormsg " + errorMsg + "path :" + path);
if (errorMsg != null) {%>
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