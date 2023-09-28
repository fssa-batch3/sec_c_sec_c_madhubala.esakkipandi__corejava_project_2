<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.fssa.glossyblends.model.*"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
  body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	background-color:white;
}

a {
	text-decoration: none;
}

button {
	background-color: #4CAF50;
	color: white;
	border: none;
	padding: 10px 20px;
	cursor: pointer;
}

button:hover {
	background-color: #45a049;
}

table {
	width: 80%;
	border-collapse: collapse;
	margin-top: 100px;
	background-color: white;
	box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); /* Adding box shadow */
	margin-left: 100px;
	border:none;
}

th, td {
	padding: 10px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}

th {
	background-color: #f2f2f2;
}

img {
	max-width: 100px;
	max-height: 100px;
	display: block;
	margin: auto;
}

/* Adding border-radius and box-shadow to button */
button {
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
}

/* Using the color code you provided */
button {
	background-color: #d70f64;
}

/* Adding border-radius and box-shadow to table */
table {
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
}
</style>

</head>
<body>


<a href="<%=request.getContextPath() %>/getRequestServlet">
<button>Go back</button>
</a>
<table border="1">
    <thead>
        <tr>
            <th>Image</th>
            <th>Cost</th>
            <th>Name</th>
            <th>Category</th>
        </tr>
    </thead>
    <tbody>
    
    <%List<Service> service=(List<Service>)request.getAttribute("listOfService"); %>
    <%for(Service ser:service){ %>
            <tr>
                <td><img src="<%=ser.getSampleImage() %>" alt="${service.name}" width="100" height="100"></td>
                <td><%=ser.getCost() %></td>
                <td><%=ser.getName() %></td>
                <td><%=ser.getCategory() %></td>
            </tr>
            <%} %>
    </tbody>
</table>

</body>
</html>