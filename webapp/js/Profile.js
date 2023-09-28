

    
const ctx = document.getElementById('myChart').getContext('2d');
const artist_profiles = JSON.parse(localStorage.getItem("card_data"));
const user_data = localStorage.getItem("artist_profile");
const user_obj = artist_profiles.find((e) => e.user_email == user_data);
let passed_appts = 0;
let upcoming_appts = 0;
let confirmed_appts = 0;

const today = new Date();
// ...
if (user_obj.booking_records) {
  user_obj.booking_records.forEach((rec) => {
    const appt_date = new Date(rec.event_date);

    if (rec.confirmation === true) {
      confirmed_appts++;

      if (appt_date.getTime() < today.getTime()) {
        passed_appts++;
        console.log("Confirmed Appointment ID (Passed): " + rec.id);
      } else if (appt_date.getTime() >= today.getTime()) {
        upcoming_appts++;
        console.log("Confirmed Appointment ID (Upcoming): " + rec.id);
      }
    }
  });
}


// ...


document.querySelector('.count_information .count_info p').textContent = passed_appts + ' Passed Appointments';
document.querySelector('.count_information2 .count_info p').textContent = upcoming_appts + ' Upcoming Appointments';
document.querySelector('.count_information3 .count_info p').textContent = confirmed_appts + ' Total Appointments';

console.log("Confirmed Appointments: " + confirmed_appts);
console.log("Passed Appointments: " + passed_appts);
console.log("Upcoming Appointments: " + upcoming_appts);

const myChart = new Chart(ctx, {
  type: 'bar',
  data: {
    labels: ['Passed', 'Upcoming', 'Total', ],
    datasets: [{
      label: 'Appointments',
      data: [passed_appts, upcoming_appts, confirmed_appts],
      backgroundColor: [
        'rgba(54, 162, 235, 0.8)',
        'rgba(255, 206, 86, 0.8)',
        'rgba(241, 50, 145, 1)',
        
      ],
      borderColor: [
        'rgba(54, 162, 235, 1)',
        'rgba(255, 206, 86, 1)',
        'rgba(241, 50, 145, 1)',
      
      ],
      borderWidth: 1
    }]
  },
  options: {
    scales: {
      yAxes: [{
        ticks: {
          beginAtZero: true,
          display: false
        },
        gridLines: {
          display: false
        }
      }],
      xAxes: [{
        ticks: {
          autoSkip: false,
          display: true
        },
        gridLines: {
          display: false
        }
      }]
    },
    legend: {
      display: true,
      labels: {
        fontColor: 'black'
      }
    },
    tooltips: {
      callbacks: {
        label: function (tooltipItem, data) {
          let label = data.labels[tooltipItem.index] || '';

          if (label) {
            label += ': ';
          }
          label += tooltipItem.yLabel;
          return label;
        }
      }
    }
  }
});


myChart.update();

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
        const artist_profile = JSON.parse(localStorage.getItem("card_data"));
const user_pp = localStorage.getItem("artist_profile");

console.log(artist_profile);

let result;
artist_profile.find((e) => {
  if (e.user_email == user_pp) {
    result = e;
  }
});

 // Create an empty booking_records array

document.getElementById("nameofartist").value = result.name;
document.getElementById("passwordofartist").value = result.artist_password;
document.getElementById("emailofartist").value = result.user_email;
document.getElementById("artist_address").value = result.address;
document.getElementById("artist_number").value = result.contact;
document.getElementById("artist_price").value = result.ruppi;
document.getElementById("artist_experince").value = result.experince_of_artist;
document.getElementById("artist_location").value = result.localty;
if (result.Language) {
  document.getElementById("artist_language").value = result.Language;
}
if (result.social_media_account) {
  document.getElementById("artist_social_media").value = result.social_media_account;
}

if (result.artits_bio) {
  document.getElementById("artits_bio").value = result.artits_bio;
}
if (result.gender) {
  document.getElementsByName("gender").value = result.gender;
}

document.getElementById("number_artits").value = result.contact;
const nameElement = document.getElementById("name");
nameElement.textContent = result.name;

// -------------------------

document.getElementById("update").addEventListener("click", (e) => {
  e.preventDefault();
  result.user_name = document.getElementById("nameofartist").value;
  result.number = document.getElementById("artist_number").value;
  result.address = document.getElementById("artist_address").value;
  result.location = document.getElementById("artist_location").value;
  result.experince = document.getElementById("artist_experince").value;
  result.price = document.getElementById("artist_price").value;

  if (document.getElementById("artits_bio").value !== "") {
    result.artits_bio = document.getElementById("artits_bio").value;
  }
  if (document.getElementById("artist_language").value !== "") {
    result.Language = document.getElementById("artist_language").value;
  }
  if (document.getElementById("artist_social_media").value !== "") {
    result.social_media_account = document.getElementById("artist_social_media").value;
  }

  console.log(result);
  localStorage.setItem("card_data", JSON.stringify(artist_profile));
});


        // -----------------------------------

        // document.getElementById("delete").addEventListener("click",event=>{
        //  event.preventDefault();   
        // localStorage.removeItem("profile");

        // })

        // -----------------------------------


        // post upload code is this

        const photoBtn = document.getElementById("optionpic");
        const photoDiv = document.getElementById("post1Content");
        const vedioBtn = document.getElementById("optiontvedio");
        const vedioDiv = document.getElementById("post2Content");

        photoBtn.addEventListener("click", () => {
            photoDiv.style.display = "block";
            vedioDiv.style.display = "none";
        });

        vedioBtn.addEventListener("click", () => {
            vedioDiv.style.display = "block";
            photoDiv.style.display = "none";
        });

        const active_user = localStorage.getItem("artist_profile")
        console.log(active_user)

      

  function list_work_uploads(){

    const artist_user = JSON.parse(localStorage.getItem("card_data"))

    const cont = document.getElementById("content");

    cont.innerHTML = "";
    
        artist_user.find(item=>{
          if(item.user_email==active_user){
          
            item.upload.forEach((e,index)=>{



  cont.innerHTML += `




          <div class="pic">
                    
                      <img src="../assets/images/ellipsis.png" class="elispse">
                      <div class="dropdown-content">
                        <p class="delete" id="del" onclick="deleteworks(${index})">
                      Delete
                    </p>
                                                  </div>

                      <img src="${e.imgurl}" class="pic_post">
                  </div>



    
`
})

// alert("word added")
          }

        })
        

      }

        function deleteworks(index){

          const artist_user_tow = JSON.parse(localStorage.getItem("card_data"))
         
          artist_user_tow.find(e=>{

            if(e.user_email==active_user){

              e["upload"].splice(index,1);

              alert("work deleted");

              localStorage.setItem("card_data", JSON.stringify(artist_user_tow));

              list_work_uploads();


            }
          })

        }

    
    
   
   
       
    
const card_data = JSON.parse(localStorage.getItem("card_data"));
const artist_email = localStorage.getItem("artist_profile");

let get_artist_name;
card_data.find((obj) => {
  if (artist_email === obj.user_email) {
    get_artist_name = obj.name;
    return get_artist_name;
  }
});

const artist = card_data.find((obj) => obj.name === get_artist_name);



if (artist.booking_records) {
  artist.booking_records.forEach((record) => {
    list_request(record);
    list_true(record);
  });
}
function list_request(item) {
  let time = item.time;

  const timeSplit = time.split(":");
  let hours = timeSplit[0];
  let minutes = timeSplit[1];
  let meridian;
  if (hours >= 12) {
    meridian = "PM";
    hours -= 12;
  } else {
    meridian = "AM";
  }
  if (hours === 0) {
    hours = 12;
  }

  const correct_time = `${hours}:${minutes} ${meridian}`;


  if (item.status == false&&item.confirmation==false) {
    const container = document.querySelector(".hole_notification");
    container.innerHTML +=
      `
        <div class="notification_history">
          <div class="details_list">
            <h4>Details of the requested customer</h4>
            <p>Name: ${item.customer_name}</p>
            <p>Venue: ${item.customer_address}</p>
            <p>Date of event: ${item.event_date}</p>
            <p>Time: ${correct_time}</p>
            <button id="approve-btn" onclick="approve_booking('${item.selected_artist_for_booking}','${item.id}','${item.customer_email}')" >Accept</button>
          </div>
          <div class="list">
            <h4>List of selected options</h4>
            <p>Event name: ${item.selected_event}</p>
            <p>${item.details_Of_booking_Info[0].customerNumber}: ${item.details_Of_booking_Info[0].name}</p>
            
            <p>Total cost: ${item.totalcost}</p>

          </div>
        </div>
      `;
    
  } else {
    const requestDiv = document.querySelector(`[data-request-id="${item.id}"]`);
    if (requestDiv) {
      requestDiv.remove();
    }
  }
}
// <button id="reject-btn" onclick="reject_booking('${item.selected_artist_for_booking}','${item.id}','${item.customer_email}')" >reject</button>


// function reject_booking(id) {
//   const index = artist.booking_records.findIndex(record => record.id === id);
//   if (index !== -1) {
//     artist.booking_records.splice(index, 1);

//   }
// }


function approve_booking(selected_artist_for_booking, id,user_email) {
    let data_of_user=JSON.parse(localStorage.getItem("data"))
  let card_data = JSON.parse(localStorage.getItem("card_data"));
  const artist = card_data.find((obj) => obj.name === selected_artist_for_booking);
 
  let bookingIndex = artist.booking_records.findIndex((e) => e.id == id&&e.customer_email==user_email);

  
  const user = data_of_user.find((obj) => obj.user_email === user_email);
 
 let bookIndex = user.booking_records.findIndex((e) => e.id == id &&e.selected_artist_for_booking==selected_artist_for_booking);


  if (bookingIndex !== -1) {
    artist.booking_records[bookingIndex].status = true;

    localStorage.setItem("card_data", JSON.stringify(card_data));
  
    user.booking_records[bookIndex].status = true;

    console.log( user.booking_records[bookIndex].status )
localStorage.setItem("data", JSON.stringify(data_of_user));
    console.log(
      `Booking for ${selected_artist_for_booking} at ${id} has been approved.`
    );
   
  }



  // const profileUrl = `https://example.com/profile?name=${encodeURIComponent(artistName)}`;
        const message = `Dear ${user_email}, \n\nYour booking  request with  ${selected_artist_for_booking} is accepted.You can view the payment link in your profile.TO make your booking confirm.Click the link and pay \n\nThank you!`;
        sendemail(user_email, message);

}



function list_true(e) {
  if (e.status == true &&e.confirmation==true) {
    let time = e.time;
    const timeSplit = time.split(":");
    let hours = timeSplit[0];
    let minutes = timeSplit[1];
    let meridian;
    if (hours >= 12) {
      meridian = "PM";
      hours -= 12;
    } else {
      meridian = "AM";
    }
    if (hours === 0) {
      hours = 12;
    }
    const correct_time = `${hours}:${minutes} ${meridian}`;
    let appoinment_div = document.getElementById("appoinments");
    appoinment_div.innerHTML += `
      <div class="information-appoinment">
        <div class="date">
          <h4>${e.event_date}</h4>
        </div>
        <div class="time">
          <p>${correct_time}</p>
        </div>
        <div class="name-of-make">
          <p>${e.selected_event} makeup</p>
        </div>
        <div class="location_appoinment">
          <p>${e.customer_address}</p>
        </div>
        <div class="cost">
          <p>Total cost:${e.totalcost}</p>
        </div>
      </div>
      <hr>
    `;
  }
  
}



if(artist.events){

artist.events.forEach(e=>{


    selected_dates(e)
})
}

function selected_dates(element){

    let selected_dates_events=document.querySelector(".div")

    selected_dates_events.innerHTML+=`
    
    <div class="showing_list">

<p><span class="titlte">Event_name:</span>${element.eventName}</p>
<p>Date: ${element.day} |${element.month}|${element.year}</p>
<p>Time: ${element.time}</p>
</div>
    


    `

    
}




list_work_uploads();








function sendemail(email_cus, mes) {
      Email.send({
        Host: "smtp.elasticemail.com",
        Username: "emadhubala1@gmail.com",
        Password: "5888FAB177209DF44C3A157057CF48050EE3",
        To: email_cus,
        From: "emadhubala1@gmail.com",
        Subject: "About your booking statement",
        Body: mes
      })
        .then(message => {
          alert("Message sended to the customer");
          window.location.href = "../../pages/profileartist.html";
        });
    }




 
 