<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.fssa.glossyblends.model.*"%>
<%@ page import="java.util.List"%>

<link rel="stylesheet" type="text/css" href="././assets/css/Booking.css">

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


	<div class="preferences">
		<div class="info">
			<div class="event">
				<h3 class="types">Select the event</h3>
				<form id="booking-form">
					<div class="events_options">
						<div class="bridal user_choice">
							<input type="radio" name="group" value="Bridal" class="input">
							<label>Bridal</label>
						</div>
						<div class="baby_shower user_choice">
							<input type="radio" name="group" value="Babyshower" class="input">
							<label>Baby shower</label>
						</div>
						<div class="engagement user_choice">
							<input type="radio" name="group" value="Engagement" class="input">
							<label>Engegement</label>
						</div>
						<div class="puberty user_choice">
							<input type="radio" name="group" value="Puberty" class="input">
							<label>Puberty</label>
						</div>
						<div class="birthday user_choice">
							<input type="radio" name="group" value="Birthday" class="input">
							<label>Birthday party</label>
						</div>
						<div class="photoshoots user_choice">
							<input type="radio" name="group" value="Photoshoot" class="input">
							<label>Photoshoots</label>
						</div>
					</div>
			</div>
			<div class="booking_details">
				<h3>Book Your Booking now!!</h3>
				<div class="name_num inputs">
					<div class="cus_name">
						<i class="fa-sharp fa-solid fa-user"></i> <input type="text"
							placeholder="Name" id="Name-of-customer">
					</div>
					<div class="cus_num">
						<i class="fa-solid fa-mobile-screen"></i> <input type="number"
							placeholder="Mobile number" id="contact-of-customer">
					</div>
				</div>
				<div class="cus_address inputs">
					<i class="fa-solid fa-location-dot"></i> <input type="text"
						placeholder="Address" id="address-customer">
				</div>
				<div class="door_num inputs">
					<i class="fa-solid fa-door-open"></i> <input type="text"
						placeholder="Door Number" id="door-customer">
				</div>
				<div class="date_time inputs">
					<div class="pincode inputs">
						<i class="fa-solid fa-hashtag"></i> <input type="number"
							placeholder="pincode" maxlength="6" id="pincode-customer">
					</div>
					<div class="time inputs">
						<i class="fa-solid fa-clock"></i> <input type="time"
							id="Time-choosen-customer" name="time-customer">

					</div>

				</div>
				<div class="selected_option inputs">
					<i class="fa-solid fa-indian-rupee-sign " id="rupee"></i> <label>Selected
						option</label> <input type="text" id="options">
				</div>
				<h4>
					Total Amount : <i class="fa-solid fa-indian-rupee-sign"></i> <span
						id="total-amount"></span>
				</h4>

				<button type="submit">Book now</button>
				</form>
			</div>
		</div>
	</div>
	<div id="popup-container">
		<div id="popup-message">
			<h3>Your booking successfully completed</h3>
		</div>
		<button id="close-button">Close</button>
	</div>




	<!-- Your existing HTML content goes here -->

	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

	<script>

const urlParams = new URLSearchParams(window.location.search);
const userId = urlParams.get("userId");
const artistId = urlParams.get("artistId");
const savedDetails = JSON.parse(localStorage.getItem("tempDetails"));

//Get the date and place parameters from the URL
var dateParam = urlParams.get("date");
var placeParam = urlParams.get("place");
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
	  const service = {
			  category: item.category_name, 
			  name: item.item_name,
			  cost: parseInt(item.item_cost),
			  service_id: parseInt(item.item_categoryId),
			  sampleImage: item.item_img,
			  artistId: parseInt(artistId), 
			  id: parseInt(userId) 
			};


    serviceObjects.push(service);
    
  });



  let totalAmount=0;

  const itemData = {};

  serviceObjects.forEach((service) => {
    console.log(service.cost);
    const { name, cost } = service;
    if (!itemData[name]) {
      itemData[name] = { count: 0, totalCost: 0, cost: cost }; // Add cost property
    }
    itemData[name].count++;
    console.log(itemData[name].count);
    itemData[name].totalCost += cost * itemData[name].count; // Update totalCost
  });


  
  
  
  
  
  const formattedItems = Object.keys(itemData).map((name) => {
    console.log(name);
    const item = itemData[name];    
    console.log(item);
    if (item.count === 1) {
      console.log("name=" + item.totalCost);
      return name + "-" + item.totalCost;
    } else {
      return name + item.count + "*" + item.cost;
    }

  }).join('+');


  
  
document.getElementById("options").value = formattedItems;

console.log(formattedItems);

totalAmount = serviceObjects.reduce((accumulator, service) => {
	  return accumulator + service.cost;
	}, 0);
console.log(totalAmount);
	document.getElementById("total-amount").textContent = totalAmount;

});


</script>


	<script>

const form = document.getElementById("booking-form");

form.addEventListener("submit", function (event) {
  event.preventDefault(); // Prevent the default form submission

 
  // Convert FormData to a plain object
  const category = document.querySelector('input[name="group"]:checked').value;
  const name = document.getElementById("Name-of-customer").value;
  const mobileNumber = document.getElementById("contact-of-customer").value;
  const address = document.getElementById("address-customer").value;
  const doorNumber = document.getElementById("door-customer").value;
  const pincode = document.getElementById("pincode-customer").value;
  const time = document.getElementById("Time-choosen-customer").value;

  // Create an object to hold the form data
  const formData = {
    category,
    name,
    mobileNumber,
    address,
    doorNumber,
    pincode,
    time,
    dateParam,
    placeParam
  };
console.log(formData.category);
  // Merge form data with serviceObjects
  const combinedData = {
    form: formData,
    serviceObjects: serviceObjects,
  };

  const jsonData = JSON.stringify(combinedData);

  fetch("http://localhost:8080/glossyblends-webapp/BookingServlet", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: jsonData,
  })
    .then(response => {
      if (response.ok) {
        // handle successful response
        return response.json(); // Parse JSON response
      } else {
        // handle error response
        return response.text().then(errorMessage => {
          throw new Error(errorMessage);
        });
      }
    })
    .then(data => {
      // Check if the response contains a "message" field
      if (data && data.message) {
        const successMessage = data.message; // Get the success message
        console.log("Server response:", data);
        		swal("Success!", successMessage, "success");
        		setTimeout(() => {
        			console.log("df");
        			window.location.href="Home.jsp";
        		}, 1000);

      } else {
        // Handle the response without a "message" field as needed
        console.error("Unexpected response format:", data);
      }
      
      // Continue with the rest of your code here if needed
      
      const savedDetails = JSON.parse(localStorage.getItem("tempDetails"));
      const filteredDetails = savedDetails.filter((outerObj) => {
        return !outerObj.some((innerObj) => {
          return innerObj.user_id === userId && innerObj.artist_id === artistId;
        });
      });

      localStorage.setItem("tempDetails", JSON.stringify(filteredDetails));
    })
    .catch((error) => {
        console.error("Error:", error);
        
        swal("Failed!", error.message, "error");
        setTimeout(() => {
            console.log("df");
        }, 4000);
    });

});


</script>

</body>

</html>