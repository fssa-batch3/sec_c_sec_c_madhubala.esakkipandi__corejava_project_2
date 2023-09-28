<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.fssa.glossyblends.model.*"%>
<%@ page import="java.util.List"%>

<link rel="stylesheet" type="text/css" href="././assets/css/ListArtist.css">

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <div class="hole-content">
        <!-- nav bar -->
        <div class="menu-bar">
            <img src="https://iili.io/J972xwu.png" alt="logo">
            <ul class="main">
                <li class="dropdown">
<a href="index.html">
Home <i class="fas fa-caret-down"></i>
</a>
</li>
                <li>
<a href="../booking/start_booking.html">Book here</a>
</li>
           		<%
			Boolean loggedIn = (Boolean) session.getAttribute("loggedInSuccess");

			if (loggedIn != null && loggedIn) {
			%>
			<li id="profile-btn"><a href="<%=request.getContextPath() %>/GetPendingListBooking"><img
					src="././assets/images/IMG20200903161128.jpg"
					class="my-profile-img"></a></li>
			<%
			} else {
			%>
			<li id="login-btn"><a href="Login.jsp"><i
					class="fa-solid fa-user"></i> Login</a></li>
			<%
			}
			%>


            </ul>
        </div>

	<div id="content-2">
		<div class="main-content">
			    <div class="head">
                        <p class="count"></p>
                        <i class="fa-solid fa-magnifying-glass" id="glass"></i>
                        <form action="GetArtistByNameServlet" method="GET">
                        <input name="name" type="search" id="search"
                            placeholder="search artist...">
                            </form>
                        <img src="././assets/images/GridColoured.ade2802b.svg" id="grid" alt="grid"> 
                         <p class="grid">GRID</p>
                    </div>

			<div class="box">
			
			
			
			
			<%String date=(String)request.getAttribute("date"); %>
			
			<%String place=(String)request.getAttribute("place"); %>
				<%
				List<Artist> artists = (List<Artist>) request.getAttribute("artists");

				for (Artist artist : artists) {
				
				%>
				
				
				<div class="one">
					<div class="pic">
						<img class="profile" src="<%=artist.getImageurl()%>">
					</div>

					<p class="username"><%=artist.getUsername()%></p>
					<div class="local">

						<img src="https://iili.io/J97dM2S.png" class="map" alt="Map">
						<p class="chennai"><%=artist.getLocation()%></p>
					</div>
					
					
               <p><%=artist.getGenderOfArtist()%></p>
                              <p>Year of experience  <%=artist.getYearsOfExperience()%></p>
               
					
					<a href="getServletOutput?id=<%=artist.getArtistId()%>&date=<%=date%>&place=<%=place%>"><button>See
							more</button></a>
				</div>
				<%
				}
				%>
			</div>
		</div>
	</div>

</body>
</html>