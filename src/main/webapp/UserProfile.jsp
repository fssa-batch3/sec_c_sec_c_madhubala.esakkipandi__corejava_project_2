<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<link rel="stylesheet" type="text/css"
	href="././assets/css/register.css">
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" type="text/css"
	href="././assets/css/register.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200">
<!-- <script src="script.js" defer></script> -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
	integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
	crossorigin="anonymous" referrerpolicy="no-referrer">
</head>

<body>
	<div class="full-content">
		<div class="sidebar-user" id="side-bar">
			<div class="Appoinment-records" id="option1">
				<div class="border">
					<img src="././assets/images/writing.png" class="icon-appoinmnet">
				</div>
				<h6>Appoinment Records</h6>
			</div>

			<div class="Schedules-record" id="option2">
				<div class="border">
					<img src="././assets/images/schedule.png" class="icon-appoinmnet">
				</div>
				<h6>Accepted Records</h6>
			</div>
			<form action="UpdateProfile">
			<div class="Personal-details" id="option3">
				<div class="border">
					<img src="../assets/images/user.png" class="icon-appoinmnet">
				</div>
				<h6>Personal Details</h6>
			</div>
			
			<div class="Notification-record" id="option4">
				<div class="border">
					<img src="././assets/images/bell.png" class="icon-appoinmnet">
				</div>
				<h6>Notifications</h6>
			</div>
			<div class="Remainder" id="option5">
				<div class="border">
					<img src="././assets/images/contract.png" class="icon-appoinmnet">
				</div>
				<h6>Wishlist</h6>
			</div>
			<div class="Remainder" id="option6">
				<div class="border">
					<img src="././assets/images/contract.png" class="icon-appoinmnet">
				</div>
				<h6>History</h6>
			</div>
		</div>

		<div class="main-content-user">
			<div class="header">
				<h3>Profile of the user</h3>
				<hr>
			</div>
			<div class="details">
				<div class="profile-of-artist">
					<div class="pic-profile">
						<img src="././assets/images/IMG20200903161128.jpg" class="profile">
					</div>
					<h3 id="name">E.Madhubala</h3>
					<input class="permenant-details_user" type="email" id="newemail"
						placeholder="Email"> <input class="permenant-details_user"
						id="number_user" type="number" placeholder="Contact">
					<!-- <input class="permenant-details_user" type="button" placeholder="Log-Out"> -->

					<button class="permenant-details_user" id="update">update</button>
					<button class="permenant-details_user" id="logout">Log-Out</button>
					<button class="permenant-details">
						<a href="../index.html">Home</a>
					</button>
				</div>

				<!-- <div class="content" id="content"> -->
				<!-- ------------------------------ -->
				<div class="list-of-details" id="option1Content">

					<!-- <div class="info">
                        <div class="cancel">
                            <canvas id="myChart"></canvas>
                        </div>

                        <div class="accepted">
                            <canvas id="myChart2"></canvas>
                        </div>
                        <div class="packages">
                            <canvas id="myChart3"></canvas>
                        </div>
                    </div> -->

					<div class="list-of-appoinment-user" id="appoinments">
						<div class="head-appoinment">
							<h3 class="head">Appoinments List</h3>
							<hr>
						</div>

						<div class="information-appoinment">

							<div class="date">

								<h4>Feb 21</h4>
							</div>
							<div class="time">
								<p>12.pm</p>
							</div>
							<div class="selected_artist_name">

								<p>Wedding makeup</p>
							</div>
							<div class="location_appoinment">
								<p>Chennai</p>
							</div>
							<div class="cost">
								<p>Rs.12,000</p>
							</div>

						</div>
						<hr>

						<!-- -------------- -->
					</div>
				</div>
				<div class="list-of-details2_user" id="option2Content">


					<div class="accepted_record" id="record_accept">

						<h3 class="booking_history">My Booking history</h3>








					</div>











				</div>

				<div class="list-of-details4" id="option4Content">
					<h3>Notifications</h3>
					<hr>
					<div class="notifiactionbox" id="notification">
						<div class="notifibox">

							<div class="decoration-line"></div>
							<div class="img">
								<i class="fa-solid fa-exclamation"></i>
							</div>
							<h4 class="Booking-alert">You have booked the Madhubala for
								Feb14</h4>
							<button>Approve</button>
							<button>Skip</button>
						</div>
						-->

						<div class="notifibox">
							<div class="decoration-line"></div>
							<div class="img">
								<i class="fa-solid fa-exclamation"></i>
							</div>

							<h4 class="Booking-alert">You have booked the Madhubala for
								Feb14</h4>
							<button id="approve-btn">Approve</button>
							<button>Skip</button>
						</div>
						<div class="notifibox">
							<div class="decoration-line"></div>
							<div class="img">
								<i class="fa-solid fa-exclamation"></i>
							</div>
							<h4 class="Booking-alert">You have booked the Madhubala for
								Feb14</h4>
							<button id="approve-btn">Approve</button>
							<button>Skip</button>
						</div>
						<div class="notifibox">
							<div class="decoration-line"></div>
							<div class="img">
								<i class="fa-solid fa-exclamation"></i>
							</div>
							<h4 class="Booking-alert">You have booked the Madhubala for
								Feb14</h4>
							<button id="approve-btn">Approve</button>
							<button>Skip</button>
						</div>
					</div>
				</div>
				<div class="list-of-details3_user" id="option3Content">
					<h3>Personal Details</h3>
					<hr>
					<div class="gathering_informations">
						<input type="text" placeholder="Name" id="newname"
							class="information-inputs_user"> <input type="Address"
							placeholder="Address" class="information-inputs_user"
							id="address"> <input type="password"
							placeholder="Password" id="password"
							class="information-inputs_user" id="artist_password"> <input
							type="tel" placeholder="Phone-Number"
							class="information-inputs_user" id="number"> <input
							type="text" placeholder="Socilamedia-Account"
							class="information-inputs_user" id="social_media"> <input
							type="text" placeholder="locality"
							class="information-inputs_user" id="city"> <input
							type="text" placeholder="age" class="information-inputs_user"
							id="artist_location">
						<div class="Gender">
							<label>Gender:</label> <label>Male</label> <input type="radio">
							<label>Female</label> <input type="radio">
						</div>

						<textarea placeholder="Bio" id="bio"> </textarea>
					</div>
				</div>
				<div class="list-of-details5_user" id="option5Content">
					<h3>Wishlist</h3>
					<hr>

					<div class="content-details5_user" id="cont_push_wishlist"></div>
				</div>

				<div class="list-of-details6_user" id="option6Content">

					<h3>Your booking history</h3>
					<hr>
					<div class="content_booking_history">

						<div class="content_confirmed">

							<p>Date:2023/03/02</p>
							<p>Selected options</p>
							<p>place:chennai</p>
							<p>Selected_artist:Steffy Makeup</p>
							<p>contact:09876543567890</p>
							<p>Cost:20000</p>
						</div>
					</div>

				</div>
			</div>

			<!-- </div> -->
		</div>
	</div>
	</div>

	<script>
const Option1 = document.getElementById("option1");
const Option2 = document.getElementById("option2");
const Option3 = document.getElementById("option3");
const Option4 = document.getElementById("option4");
const Option5 = document.getElementById("option5");
const Option6 = document.getElementById("option6");

const details1 = document.getElementById("option1Content");
const details2 = document.getElementById("option2Content");
const details3 = document.getElementById("option3Content");
const details4 = document.getElementById("option4Content");
const details5 = document.getElementById("option5Content");
const details6 = document.getElementById("option6Content");

Option1.addEventListener("click", () => {
    details1.style.display = 'block';
    details2.style.display = 'none';
    details3.style.display = 'none';
    details4.style.display = 'none';
    details5.style.display = 'none';
    details6.style.display = 'none';
});

Option2.addEventListener("click", () => {
    details1.style.display = 'none';
    details2.style.display = 'block';
    details3.style.display = 'none';
    details4.style.display = 'none';
    details5.style.display = 'none';
    details6.style.display = 'none';
});

Option3.addEventListener("click", () => {
    details1.style.display = 'none';
    details2.style.display = 'none';
    details3.style.display = 'block';
    details4.style.display = 'none';
    details5.style.display = 'none';
    details6.style.display = 'none';
});

Option4.addEventListener("click", () => {
    details1.style.display = 'none';
    details2.style.display = 'none';
    details3.style.display = 'none';
    details4.style.display = 'block';
    details5.style.display = 'none';
    details6.style.display = 'none';
});

Option5.addEventListener("click", () => {
    details1.style.display = 'none';
    details2.style.display = 'none';
    details3.style.display = 'none';
    details4.style.display = 'none';
    details5.style.display = 'block';
    details6.style.display = 'none';


});



Option6.addEventListener("click", () => {
    details1.style.display = 'none';
    details2.style.display = 'none';
    details3.style.display = 'none';
    details4.style.display = 'none';
    details5.style.display = 'none';
    details6.style.display = 'block';


});







const user_profile_data = JSON.parse(localStorage.getItem("data"));
const user_pp = localStorage.getItem("profile");
let res;

console.log(user_pp);
res = user_profile_data.find(e => e.user_email === user_pp);
console.log(res);

if(res.wishlist){
res.wishlist.forEach(e => {
  list_fav(e);
});
}
function list_fav(obj) {
  const appending_div = document.getElementById("cont_push_wishlist");
  appending_div.innerHTML += `
    <div class="div-of-whish" id="obj_artist">
      <div class="pic-wishlist">
        <img src="${obj.image}" class="pic-img-wish">
      </div>
      <div class="left-content-wishlist">
        <div class="details-artist-wish">
          <h3>${obj.title} Makeover artistry</h3>
        <p>Locality   : ${obj.locality}</p>
          
        </div>
        <i class="fa-solid fa-circle-xmark trash-icon" id="${obj.id_wishlist}"></i>
      </div>
    </div>
  `;
}

const trashIcons = document.querySelectorAll(".trash-icon");
trashIcons.forEach((icon) => {
  icon.addEventListener("click", (e) => {
    const id = e.target.id;
    console.log(id)
    remove_wishlist_item(id);
  });
});
function remove_wishlist_item(id) {
  const user_profile_data = JSON.parse(localStorage.getItem("data"));
  const user_pp = localStorage.getItem("profile");
  let res = user_profile_data.find(e => e.user_email === user_pp);

  console.log("id: ", id);
  console.log("wishlist: ", res.wishlist);

  const index = res.wishlist.filter((item) => item.id_wishlist === id);
  console.log(index)
  if (index) {
    res.wishlist.splice(res.wishlist.indexOf(index), 1);
    localStorage.setItem("data", JSON.stringify(user_profile_data));
    // console.log(`Wishlist item with ID ${id} has been removed.`);

    alert("wishlist delted")
    location.reload()
  } else {
    // console.log(`Wishlist item with ID ${id} not found.`);
  }
}


    // document.getElementById("newname").value =res["user_name"];
    // document.getElementById("newemail").value = res["user_email"];
    // document.getElementById("password").value=res["user_password"]

    document.getElementById("newname").value =res.user_name;
    document.getElementById("newemail").value = res.user_email;
    document.getElementById("password").value=res.user_password

    if (res.user_bio) {
            document.getElementById("bio").value =res.user_bio;
        }
        if (res.user_number) {
            document.getElementById("number").value = res.user_number;
        }

        if (res.user_city) {
            document.getElementById("city").value =res.user_city;
        }
        if (res.user_address) {
            document.getElementsByName("address").value =res.user_address;
        }
        if (res.ac_social) {
            document.getElementsByName("social_media").value =res.ac_social;
        }
        const  name_of_user= document.getElementById("name")

        name_of_user.textContent=res.user_name

        document.getElementById("number_user").value=res.user_number
        
// -------------------------

            document.getElementById("update").addEventListener("click",e=>{
                e.preventDefault();
            res.user_name= document.getElementById("newname").value
            res.user_password=document.getElementById("password").value

            if (document.getElementById("bio").value !== "") {
              res.user_bio = document.getElementById("bio").value;
            }
            if (document.getElementById("number").value !== "") {
              res.user_number = document.getElementById("number").value;
            }
            if (document.getElementById("city").value !== "") {
              res.user_city = document.getElementById("city").value;
            }

            if (document.getElementById("address").value !== "") {
              res.user_address= document.getElementById("address").value;
            }
            if (document.getElementById("social_media").value !== "") {
              res.ac_social= document.getElementById("social_media").value;
            }

            localStorage.setItem("data",JSON.stringify(user_profile_data));
            console.log(res);

            })

 

const data = JSON.parse(localStorage.getItem("data"));
const user_email = localStorage.getItem("profile");

let e;
data.find((obj) => {
  if (user_email === obj.user_email) {
  
    return e=obj;

  }
});

const bookingRecordsDiv = document.getElementById("appoinments");

e.booking_records.forEach((record) => {
  
  const timeSplit = (record.time).split(':');
  
   let hours = timeSplit[0];
  minutes = timeSplit[1];
  if (hours > 12) {
    meridian = 'PM';
    hours -= 12;
  } else if (hours < 12) {
    meridian = 'AM';
    if (hours == 0) {
      hours = 12;
    }
  } else {
    meridian = 'PM';

  }

   
const correct_time=`${hours  }:${  minutes  } ${  meridian}`
console.log(correct_time)

  const recordDiv = document.createElement("div");
  recordDiv.classList.add("information-appoinment");

  if(record.status==false){
 
  recordDiv.innerHTML = `
    <div class="date">
      <h4>${record.event_date}</h4>
    </div>
    <div class="time">
      <p>${correct_time}</p>
    </div>
    <div class="selected_artist_name">
      <p>Your booking with ${record.selected_artist_for_booking} is on pending with total cost of ${record.totalcost}  </p>
    </div>
   
  `;

  bookingRecordsDiv.appendChild(recordDiv);

  bookingRecordsDiv.appendChild(document.createElement("hr"));

  }
});




e.booking_records.find((booking) => {


          if (booking.status==true&&booking.confirmation==false) {
            list_request(booking);
          }
        }
    
      )
    function list_request(booking) {
      const container = document.getElementById("notification");
      container.innerHTML += 
      ` <div class="notifibox">

<div class="decoration-line">

</div>
<div class="img">
<i class="fa-solid fa-exclamation"></i>
</div>

<h4 class="Booking-alert">${booking.selected_artist_for_booking} accepted your boooking ${booking.event_date}and id${booking.id}</h4>
</div>`;

    }
  

    


function list_request(booking){

  
 
const container = document.getElementById("record_accept");
 

let artist_name=booking.selected_artist_for_booking


let data_of_selected_artist=JSON.parse(localStorage.getItem("card_data"))

let artist
data_of_selected_artist.filter(e=>{
  if(e.name==booking.selected_artist_for_booking){
return artist=e.user_email


  }
})

container.innerHTML+=
`
  

<div class="records_1">

<p><span class="bold">Artist_name: </span> ${booking.selected_artist_for_booking}</p>
<p><span class="bold">Event_date:  </span> ${booking.event_date}</p>
<p><span class="bold">Selected options:  </span> ${booking.details_Of_booking_Info[0].name}</p>
<p><span class="bold">Total cost:  </span> ${booking.totalcost}</p>
<a href="./../pages/booking/book4.html?booking_id=${booking.id} &user_email=${user_email}&artistemail=${booking.selected_artist_for_booking}&email_artist=${artist}" class="proceed"><button>Proceed to Payment</button></a>

  
</div>

    `;


  
}



e.booking_records.find((booking) => {


if (booking.status==true&&booking.confirmation==true) {
  accepted_record(booking);
}
}

)




function accepted_record(e){


  let confirmed_record=document.querySelector(".content_booking_history")

  confirmed_record.innerHTML+=`
  
  <div class="content_confirmed">

<p>Date: <span class="bolding_letters"> ${e.event_date}
  </span></p>
<p>Selected options:<span class="bolding_letters"> ${e.details_Of_booking_Info.map(info => info.name).join(', ')} </span</p>
<p>place:<span class="bolding_letters">chennai</p>
<p>Selected artist:<span class="bolding_letters"> ${e.selected_artist_for_booking}</span</p>
<p>contact<span class="bolding_letters">:09876543567890</span</p>
<p>Cost:<span class="bolding_letters"> ${e.totalcost}</span</p>
</div>
  
  `

}














  </script>
</body>

</html>