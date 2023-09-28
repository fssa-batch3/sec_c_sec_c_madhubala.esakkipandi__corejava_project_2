<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.fssa.glossyblends.model.*"%>
<%@ page import="java.util.List"%>
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
				<div class="list-of-details6" id="option6Content">

					<h3>Your posts</h3>
					<hr>
					<div class="photo_vedios">
						<h3 id="optionpic" class="pho">Photos</h3>

					</div>
					<div class="photos" id="post1Content">
						<div class="content" id="content">
							<%
							List<Post> post = (List<Post>) request.getAttribute("works");
							%>
							<%
							for (Post posts : post) {
							%>
							<div class="pic">
								<div class="pic_container">
									<img src="./assets/images/ellipsis.png" class="elispse">
									<div class="dropdown-content">
										<a
											href="<%=request.getContextPath()%>/DeletePost?postId=<%=posts.getPostId()%>">Delete</a>
									</div>
								</div>


								<img src="<%=posts.getPostUrl()%>" class="pic_post">
							</div>
							<%
							}
							%>



						</div>
					</div>



				</div>
			</div>
		</div>
	</div>
	
	
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script>
<%String success = (String) request.getAttribute("success");
String error = (String) request.getAttribute("error");
String path = (String) request.getAttribute("paths");



System.out.println(error + " Succesmsg ----  errormsg " + success + "path :");
if (success != null) {%>
    <%System.out.print(success + "inside");%>
    swal("Success!","<%=success%>", "success");
    setTimeout(() => {
        console.log("df");
        window.location.href="<%=path%>";
    }, 4000);
<%}%>

<%if (error != null) {%>
    console.log("<%=error%>");
    <%System.out.print(error + "inside");%>
    swal("Failed!","<%=error%>", "error");
    setTimeout(() => {
        console.log("df");
        window.location.href="<%=path%>";
    }, 4000);
<%}%>


		
		
		
		
</script>

	
</body>
</html>