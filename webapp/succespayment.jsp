<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script>
<%String errorMsg = (String) request.getAttribute("error");
String successMsg = (String) request.getAttribute("success");
System.out.println(successMsg + " Succesmsg ----  errormsg " + errorMsg + "path :" );
if (errorMsg != null) {%>
		
		<%System.out.print(errorMsg + "inside");%>
		swal("Failed!","<%=errorMsg%>", "error");
		setTimeout(() => {
			console.log("df");
			window.location.href="UpdatePaymentStatus";
		}, 4000);
		
	<%}%>
		
		<%if (successMsg != null) {%>
		console.log("<%=successMsg%>");
		<%System.out.print(successMsg + "inside");%>
		swal("Success!"," <%=successMsg%>", "success");
		setTimeout(() => {
			console.log("df");
			window.location.href="Home.jsp";
		}, 1000);
		<%}%>
</script>
	
</body>
</html>