<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	background-image: url('././assets/images/error image.jpg');
	background-repeat: no-repeat;
	background-position: center;
	margin-top: 600px;
}

a {
	text-decoration: none;
	color:white;
	font-weight:bolder;
}

button {
	width: 140px;
	height: 45px;
	font-family: 'Roboto', sans-serif;
	font-size: 11px;
	text-transform: uppercase;
	letter-spacing: 2.5px;
	font-weight: 500;
	color: white;
	background-color: #fff;
	border: none;
	border-radius: 45px;
	/* box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.1); */
	transition: all 0.3s ease 0s;
	cursor: pointer;
	background-color: #e6397e;
	box-shadow: 0px 15px 20px rgba(218, 66, 107, 0.4);
	outline: none;
	margin-left: 700px;
	margin-top: 60px;
}

button:hover {
	color: #fff;
	transform: translateY(-7px);
}
</style>
</head>
<body>
	<button>
		<a href="Home.jsp">Back to home</a>
	</button>
</body>
</html>
