

<%@ page import="com.fssa.glossyblends.model.*"%>
<%@ page import="java.util.List"%>


<div class="profile-of-artist">
	<%
	Artist artist = (Artist) session.getAttribute("artist");
	%>
	<div class="pic-profile">

		<%
		String artistImage = artist.getImageurl();
		if (artistImage != null) {
		%>
		<img src="<%=artistImage%>" class="profile">
		<%
		} else {
		%>
		<img src="./assets/images/user image.webp" class="profile">
		<%
		}
		%>


	</div>
	<h3 id="name"></h3>

	<input class="permenant-details" type="email" id="emailofartist"
		placeholder="Email" value="<%=artist.getEmail()%>" disable>
	<%
	Long userContact = (Long) artist.getPhonenNumber(); // Assuming getMobileNumber() retrieves the user's contact
	if (userContact != null) {
	%>
	<input class="permenant-details_user" id="number_user" type="number"
		placeholder="Contact" value="<%=artist.getPhonenNumber()%>" disbale>
	<%
	}
	%>
	
			
	<button class="permenant-details" id="update">
		<a href="Home.jsp">Home</a>
	</button>

</div>
