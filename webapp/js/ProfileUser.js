/**
 * 
 */

 
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




let log_out_user=document.getElementById("logout")
log_out_user.addEventListener("click", function() {
        
  localStorage.removeItem("profile");
});

//     let dta_of_user = JSON.parse(localStorage.getItem("data"));
//     let booking_data = JSON.parse(
//       localStorage.getItem("records_booking_clients")
//     );
//     let active_user = localStorage.getItem("profile");

//     console.log(booking_data);

//     booking_data.filter((element) => {
//       if (element.customer_email == active_user) {
//         if (element.status == false) {
//           show_div(element);
//         }
//       }
//     });

//     function show_div(item) {
//       let id = document.getElementById("appoinments");
//       id.innerHTML += `
//     <div class="information-appoinment" >         
// <div class="name-of-make">
//     <p>Your booking appoinment with ${item.selected_artist_for_booking} artist is in pending</p>
// </div>
// <div class="update-appoinment">
//     <button>pending</button>
// </div>
// </div> 
// <hr>
//     `;
//     }

//     let user = localStorage.getItem("profile");

//     // find the ID of the confirmed booking with status=true

//     const data_record = JSON.parse(
//       localStorage.getItem("records_booking_clients")
//     );

//     let confirmed_booking_id;
//     data_record.filter((booking) => {
//       if (booking.status === true) {
//         confirmed_booking_id = booking.id;
    
//         console.log(booking);
//       }

//       let find;

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

  // let data_of_wishlist = JSON.parse(localStorage.getItem("wishlist_dta"))||[]; 
  // let removewish = document.querySelectorAll(".fa-circle-xmark");
   
//   removewish.forEach((e,index)=>{
//   e.addEventListener("click",element=>{
//     data_of_wishlist.splice(index,1)
//     localStorage.setItem("wishlist_dta",JSON.stringify(data_of_wishlist))
//     location.reload()
//   })
// })

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









