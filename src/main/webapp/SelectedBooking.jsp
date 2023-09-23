<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.fssa.glossyblends.model.*"%>
<%@ page import="java.util.List"%>
<link rel="stylesheet" type="text/css" href="././assets/css/Book.css">
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
	integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
	crossorigin="anonymous" referrerpolicy="no-referrer">
</head>

<body>
	<!-- nav bar starts -->
	<div class="menu-bar">
		<img src="../../assets/images/Screenshot__63_-removebg-preview.png"
			alt="logo">
		<ul class="main">
			<li class="dropdown"><a href="../../index.html"> Home <i
					class="fas fa-caret-down"></i>
			</a> <!-- <div class="dropdown-content">
          <ul>
            <li>
              <a href="#feature">Features</a>
            </li>

            <li>
              <a href="../../pages/review/review.html">Reviews</a>
            </li>
          </ul>
        </div> --></li>
			<!-- <li><a href="#">For artist</a>
        <div class="dropdown-content">
          <ul>
            <li>
              <a href="./pages/upload/upload.html">Upload </a>
            </li>
        </div>
      </li> -->
			<li><a href="./pages/booking/start_booking.html">Book here</a></li>
			<!-- <li><a href="./pages/Login/login.html"> <i class="fa-solid fa-user"></i>login</a></li> -->
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

	<div class="cart_adding">

		<div class="addedlist">

			<div class="head">
				<h3>Your booking list</h3>
			</div>

			<div id="serviceListContainer" class="listing"></div>




			<div class="proceedtopay">
				<%
				// Retrieve the userId and artistId parameters from the request
				String userId = request.getParameter("userId");
				String artistId = request.getParameter("artistId");
				String date = request.getParameter("date");
				String place = request.getParameter("city");
				%>
				
				<div class="proceedtopay">
					<form method="GET" action="Booking.jsp">
						<input type="hidden" name="userId" value="<%=userId%>"> <input
							type="hidden" name="artistId" value="<%=artistId%>"> <input
							type="hidden" name="date" value="<%=date%>"> 
							<input type="hidden" name="place" value="<%=place%>">
						<button type="submit" class="proceed">Proceed to
							pay</button>
					</form>
				</div>
			</div>

		</div>

		<div class="savinglist">

			<h1>Total booking</h1>
			<div class="totalbooking">

				<div class="customer_1">

					<div class="names_total_cost"></div>
					<hr>
					<br> <br> <br>
					<h3 class="single_cust_total_cost">TOTAL COST: ₹ 800000</h3>

				</div>

			</div>

		</div>

	</div>



	<div id="popup-container">
		<div id="popup-message">
			<h3>Your booking successfully completed</h3>
		</div>
		<button id="close-button">Close</button>
	</div>

	<!-- </div> -->
	<script>
	document.addEventListener("DOMContentLoaded", function () {
		  const urlParams = new URLSearchParams(window.location.search);
		  const userId = urlParams.get("userId");
		  const artistId = urlParams.get("artistId");
		  const savedDetails = JSON.parse(localStorage.getItem("tempDetails"));

		  // Filter savedDetails to include only relevant data
		  const filteredDetails = savedDetails.filter((outerObj) => {
		    return outerObj.some((innerObj) => {
		      return innerObj.user_id === userId && innerObj.artist_id === artistId;
		    });
		  });

		  // Create an array to hold Service objects
		  const serviceObjects = [];

		  filteredDetails.forEach((innerArray) => {
		    innerArray.forEach((item) => {
		      // Map the savedDetails data to create Service objects
		      const service = {
		        category: item.category_name, // Map category_name to category property
		        name: item.item_name,
		        cost: item.item_cost, // Parse the cost to a float
		        sampleImage: item.item_img,
		        artistId: parseInt(artistId), // Parse artistId to an integer
		        id: userId,
		        serviceId:parseInt(item.item_categoryId)// Parse id to an integer
		      };

		      // Push the created Service object to the array
		      serviceObjects.push(service);
		      console.log(service);
		    });
		  });

		  // Now that you have the serviceObjects array, you can dynamically populate the container.
		  const serviceListContainer = document.getElementById("serviceListContainer");

		  if (serviceListContainer) {
		    // Create HTML elements for each service and append them to the container
		    serviceObjects.forEach((service) => {
		      const serviceItem = document.createElement("div");
		      serviceItem.className = "list_1";

		      const picBookList = document.createElement("div");
		      picBookList.className = "pic_book_list";
		      const img = document.createElement("img");
		      img.className = "selected_list_img";
		      img.src = service.sampleImage;
		      picBookList.appendChild(img);

		      const detailsCost = document.createElement("div");
		      detailsCost.className = "details_cost";
		      const h3 = document.createElement("h3");
		      h3.innerText = service.name;
		      
		      const p = document.createElement("p");
		      p.innerText = "Cost"+" "+service.cost;
		      
		      const h6 = document.createElement("h6");
		      h6.className = "id";
		      h6.innerText = service.id;

		      detailsCost.appendChild(h3);
		      detailsCost.appendChild(p);
		      detailsCost.appendChild(h6);

		      serviceItem.appendChild(picBookList);
		      serviceItem.appendChild(detailsCost);

		      serviceListContainer.appendChild(serviceItem);
		    });
		  } else {
		    console.error("Service list container not found.");
		  }






	  const namesTotalCostContainer = document.querySelector(".names_total_cost");

	  let totalCost = 0; // Initialize the total cost

	  
	  serviceObjects.forEach((service) => {
		  console.log(service);
	      const serviceItem = document.createElement("div");
	      serviceItem.className = "one";
	      
	      const serviceName = document.createElement("p");
	      serviceName.innerText = service.name;

	      const serviceCost = document.createElement("p");
	      serviceCost.innerText = "Cost: ₹ " + service.cost;

	      serviceItem.appendChild(serviceName);
	      serviceItem.appendChild(serviceCost);

	      namesTotalCostContainer.appendChild(serviceItem);
	      totalCost += parseFloat(service.cost);
	    });
	  console.log("dfgf"+totalCost);

	  const totalCostElement = document.querySelector(".single_cust_total_cost");
	  if (totalCostElement) {
	    totalCostElement.innerText = "TOTAL COST: ₹ " + totalCost.toFixed(2); // Display the total cost with 2 decimal places
	  } else {
	    console.error("Total cost element not found.");
	  }
	   
	  
	});
	  
	  
</script>

</body>

</html>
