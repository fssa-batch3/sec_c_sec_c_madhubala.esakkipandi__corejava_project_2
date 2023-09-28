<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.fssa.glossyblends.model.*"%>

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

				<%
				String email = request.getParameter("email");
				%>

				<%
				User user = (User) request.getAttribute("user");
				%>


				<div class="list-of-details3_user" id="option3Content">
					<h3 class="heading">Personal Details</h3>
					<hr>
					<div class="gathering_informations">
						<form method="post" action="UpdateProfile">
							<input type="text" placeholder="Name" id="newname"
								class="information-inputs_user"
								value="<%=(user != null && user.getName() != null) ? user.getName() : ""%>"
								name="name"> <input type="Address" placeholder="Address"
								class="information-inputs_user" id="address"
								value="<%=(user != null && user.getAddress() != null) ? user.getAddress() : ""%>"
								name="address"> <input type="password"
								placeholder="Password" id="password"
								class="information-inputs_user" id="artist_password"
								value="<%=(user != null && user.getPassword() != null) ? user.getPassword() : ""%>"
								name="password" disabled> <input type="password"
								placeholder="repeat Password" id="address"
								class="information-inputs_user"
								value="<%=(user != null && user.getRepeatPassword() != null) ? user.getRepeatPassword() : ""%>"
								name="repeatPassword" disabled> <input type="tel"
								placeholder="Phone-Number" class="information-inputs_user"
								id="number"
								value="<%=(user != null && user.getMobileNumber() != null) ? user.getMobileNumber() : ""%>"
								name="number"> <input type="text" placeholder="locality"
								class="information-inputs_user" id="city"> <input
								type="text" name="pincode" placeholder="Pincode" id="address"
								class="information-inputs_user"
								value="<%=(user != null && user.getPincode() != null) ? user.getPincode() : ""%>">
							<input type="text" placeholder="DoorNumber" id="address" name="doornumber"
								class="information-inputs_user"
								value="<%=(user != null && user.getDoorNumber() != null) ? user.getDoorNumber() : ""%>">
							
							<button class="permenant-details_user" id="update" type="submit">update</button>
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
			window.location.href="<%=path%>";
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