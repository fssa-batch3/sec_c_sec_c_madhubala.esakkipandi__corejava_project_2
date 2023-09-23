<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.fssa.glossyblends.model.*"%>
<%@ page import="java.util.List"%>
<link rel="stylesheet" type="text/css"
	href="././assets/css/showartist.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"
	integrity="sha512-mRC1HzihODlsy8FgItDfvz1CgclWkqLYlO83fFfB5/CBq5t7I68J9e4U4PvU+TuN9CAvvLQz3j3ln4KlBRc7wKw=="
	crossorigin="anonymous" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Glossy blends</title>
</head>
<body>
	<div class="menu-bar">
		<img src="https://iili.io/J972xwu.png" alt="logo">
		<ul class="main">
			<li class="dropdown"><a href="#"> Home <i
					class="fas fa-caret-down"></i></a></li>
			<li><a href="../booking/start_booking.html">Book here</a></li>
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

	<div class="profile-content">
		<%
		Artist artist = (Artist) request.getAttribute("artist");
		%>
		<div class="content-1-profile">
			<img class="profile" src="<%=artist.getImageurl()%>" alt="profile">
		</div>

		<div class="content-2-profile">
			<div class="review">
				<h1 class="name_of_artist">
					Bridal makeup by
					<%=artist.getUsername()%></h1>
				<p>
					<i id="icoen" class="fa-solid fa-star"></i>4.7
				</p>
				<p>36 reviews</p>
			</div>

			<div class="contact">
				<img src="././assets/images/map.png" class="map" alt="map">
				<p><%=artist.getLocation()%></p>
				<p>contact</p>
				<p><%=artist.getPhonenNumber()%></p>
			</div>

			<div class="line">
				<p>
					<i id="icoen" class="fa-regular fa-image"></i>photos
				</p>
				<p>
					<i id="icoen" class="fa-solid fa-pen-nib"></i>Shortlist
				</p>
				<p>
					<i id="icoen" class="fa-regular fa-heart"></i>Write a review
				</p>
				<p>
					<i id="icoen" class="fa-solid fa-share-nodes"></i>Share
				</p>
			</div>
		</div>
	</div>

	<div class="photo">
		<div class="heading">
			<h1 class="album photos">Photos</h1>
		</div>
		<div class="pic-content">
			<%
			List<Post> posts = (List<Post>) request.getAttribute("artistPosts");
			if (posts != null && !posts.isEmpty()) {
				for (Post post : posts) {
			%>
			<img class="pic-one" src="<%=post.getPostUrl()%>" />
			<%
			}
			} else {
			%>
			<p>
				There are no posts posted by
				<%=artist.getUsername()%></p>
			<%
			}
			%>
		</div>
	</div>



	<%
	int userId = -1;
	Object idAttribute = request.getAttribute("id");
	if (idAttribute != null) {
		userId = (int) idAttribute;
	}
	%>

<%String date=(String)request.getAttribute("date");%>
<%String place=(String)request.getAttribute("place");%>


	<div class="cart_items" id="data">
		<h1 class="cart_head">Different types of service providing</h1>

		<%
		List<Service> services = (List<Service>) request.getAttribute("artistServices");
		if (services == null) {
		%>
		<p>There are no services available</p>
		<%
		} else {
		%>
		<div class="hairstyle typesOf_cart">
			<div class="types_head cart">
				<%
				if (services != null) {
					for (Service service : services) {
						if (service.getCategory().equals(ServiceCategory.HAIR_STYLE)) {
				%>
				<div class="types">
					<img class="makeuptypes_img" src="<%=service.getSampleImage()%>" />
					<p class="titlte_makeup"><%=service.getName()%></p>
					<p class="cost_makeup"><%=service.getCost()%></p>
					<button class="add_book_list" data-id="<%=service.getId()%>"
						data-img="<%=service.getSampleImage()%>"
						data-name="<%=service.getName()%>"
						data-cost="<%=service.getCost()%>"
						data-categoryId="<%=service.getCategory().toString()%>"
						data-userId="<%=userId%>"
						data-artistId="<%=artist.getArtistId()%>">Add to booking
						list</button>


				</div>
				<%
				}
				}
				}
				%>
			</div>
		</div>

		<div class="makeup_types typesOf_cart">
			<div class="types_head cart">
				<%
				if (services != null) {
					for (Service service : services) {
						if (service.getCategory().equals(ServiceCategory.MAKEUP)) {
				%>
				<div class="types">
					<img class="makeuptypes_img" src="<%=service.getSampleImage()%>" />
					<p class="titlte_makeup"><%=service.getName()%></p>
					<p class="cost_makeup"><%=service.getCost()%></p>
					<button class="add_book_list" data-id="<%=service.getId()%>"
						data-img="<%=service.getSampleImage()%>"
						data-name="<%=service.getName()%>"
						data-cost="<%=service.getCost()%>"
						data-categoryId="<%=service.getCategory().toString()%>"
						data-userId="<%=userId%>"
						data-artistId="<%=artist.getArtistId()%>">Add to booking
						list</button>


				</div>
				<%
				}
				}
				}
				%>
			</div>
		</div>

		<div class="saree_drapping typesOf_cart">
			<div class="types_head cart">
				<%
				if (services != null) {
					for (Service service : services) {
						if (service.getCategory().equals(ServiceCategory.SAREE_DRAPPING)) {
				%>
				<div class="types">
					<img class="makeuptypes_img" src="<%=service.getSampleImage()%>" />
					<p class="titlte_makeup"><%=service.getName()%></p>
					<p class="cost_makeup"><%=service.getCost()%></p>
					<button class="add_book_list" data-id="<%=service.getId()%>"
						data-img="<%=service.getSampleImage()%>"
						data-name="<%=service.getName()%>"
						data-cost="<%=service.getCost()%>"
						data-categoryId="<%=service.getCategory().toString()%>"
						data-userId="<%=userId%>"
						data-artistId="<%=artist.getArtistId()%>">Add to booking
						list</button>


				</div>
				<%
				}
				}
				}
				%>
			</div>
		</div>

		<div class="mehandi typesOf_cart">
			<div class="types_head cart">
				<%
				if (services != null) {
					for (Service service : services) {
						if (service.getCategory().equals(ServiceCategory.MEHANDI)) {
				%>
				<div class="types">
					<img class="makeuptypes_img" src="<%=service.getSampleImage()%>" />
					<p class="titlte_makeup"><%=service.getName()%></p>
					<p><%=service.getId()%></p>
					<p class="cost_makeup"><%=service.getCost()%></p>
					<button class="add_book_list" data-id="<%=service.getId()%>"
						data-img="<%=service.getSampleImage()%>"
						data-name="<%=service.getName()%>"
						data-cost="<%=service.getCost()%>"
						data-categoryId="<%=service.getCategory().toString()%>"
						data-userId="<%=userId%>"
						data-artistId="<%=artist.getArtistId()%>">Add to booking
						list</button>


				</div>
				<%
				}
				}
				}
				%>
			</div>
		</div>
		<%
		}
		%>

		<form method="GET" action="SelectedBooking.jsp">
			<input type="hidden" name="userId" value="<%=userId%>">
			<%
			int artistId = artist.getArtistId();
			%>
			<input type="hidden" name="artistId" value="<%=artistId%>">
			 <input type="hidden" name="date" value="<%=date%>"> 
			 <input type="hidden" name="city" value="<%=place%>">

			<button class="save" type="submit">Save</button>
		</form>


	</div>
	<script>
function moveAllServicesToTempDetails() {
        // Retrieve the existing booking details from local storage or initialize an empty array
        const bookingDetails = JSON.parse(localStorage.getItem("bookingDetails")) || [];

        // Retrieve the existing tempDetails from local storage or initialize an empty array
        const tempDetails = JSON.parse(localStorage.getItem("tempDetails")) || [];

        // Group bookingDetails by artist_id and user_id
        const groupedTempDetails = groupByArtistAndUser(bookingDetails);

        // Merge groupedTempDetails with tempDetails
        const updatedTempDetails = tempDetails.concat(groupedTempDetails);

        // Update the tempDetails in local storage as a single array of objects
        localStorage.setItem("tempDetails", JSON.stringify(updatedTempDetails));

        // Clear the bookingDetails array
        localStorage.setItem("bookingDetails", JSON.stringify([]));
    }

    // Function to group bookingDetails by artist_id and user_id
    function groupByArtistAndUser(bookingDetails) {
        const groupedDetails = {};
        for (const detail of bookingDetails) {
            const key = `${detail.artist_id}_${detail.user_id}`;
            if (!groupedDetails[key]) {
                groupedDetails[key] = [];
            }
            groupedDetails[key].push(detail);
        }

        // Convert the groupedDetails object into an array
        const result = [];
        for (const key in groupedDetails) {
            if (groupedDetails.hasOwnProperty(key)) {
                result.push(groupedDetails[key]);
            }
        }

        return result;
    }

    const buttons = document.querySelectorAll(".add_book_list");
    buttons.forEach(button => {
        button.addEventListener("click", async (e) => {
            const categoryName = e.target.getAttribute("data-categoryId"); // Get the category name from the data attribute
            const userId = e.target.getAttribute("data-userId");
            const artistId = e.target.getAttribute("data-artistId");
            const serviceId=(e.target.getAttribute("data-id"));
            const bookingData = {
                category_name: categoryName,
                item_img: e.target.getAttribute("data-img"),
                item_name: e.target.getAttribute("data-name"),
                item_cost: e.target.getAttribute("data-cost"),
                item_categoryId: serviceId,
                artist_id: artistId,
                user_id: userId
    
            };

            
            
            // Retrieve the existing booking list from local storage or initialize an empty array
            const bookingList = JSON.parse(localStorage.getItem("bookingDetails")) || [];

            // Add the selected item to the booking list
            bookingList.push(bookingData);

            // Store the updated booking list in local storage
            localStorage.setItem("bookingDetails", JSON.stringify(bookingList));

            alert("Item added to booking list.");
        });
    });

    
    
    
    const urlParams = new URLSearchParams(window.location.search);
	  const date = urlParams.get("date");
	  const city = urlParams.get("place");
	  
	  console.log(date);
	  console.log(city)
    document.querySelector(".save").addEventListener("click", () => {
     
        const userId = document.querySelector('input[name="userId"]').value;
        const artistId = document.querySelector('input[name="artistId"]').value;

        console.log("userId:", userId);
        console.log("artistId:", artistId);



        moveAllServicesToTempDetails();

        localStorage.setItem("bookingDetails", JSON.stringify([]));

        alert("All selected items have been saved.");
        if (userId && artistId &&date!=null && city!=null) {
            window.location.href = `SelectedBooking.jsp?userId=${userId}&artistId=${artistId}&date=${date}&city=${city}`;
        }
      
     
        
        
    });


    
</script>



</body>
</html>
