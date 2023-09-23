<%@ page import="com.fssa.glossyblends.model.*"%>
<%@ page import="java.util.List"%>
<div class="profile-of-artist">
    <div class="pic-profile">
        <img src="././assets/images/IMG20200903161128.jpg" class="profile">
    </div>
    <% User user = (User) session.getAttribute("user"); %>

    <h3 id="name"><%= user.getName() %></h3>
    <input class="permenant-details_user" type="email" id="newemail" placeholder="Email" disabled value="<%= session.getAttribute("email") %>">

    <%
    String userContact = user.getMobileNumber(); // Assuming getMobileNumber() retrieves the user's contact
    if (userContact != null) {
    %>
    <input class="permenant-details_user" id="number_user" type="number" placeholder="Contact" value="<%= user.getMobileNumber() %>">
    <%
    } %>
    <a href="./UserLogout"><button class="permenant-details_user" id="logout">Logout</button></a>
    <button class="permenant-details">
        <a href="Home.jsp">Home</a>
    </button>
</div>
