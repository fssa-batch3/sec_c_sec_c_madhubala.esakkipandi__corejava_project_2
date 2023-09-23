/**
 * 
 */
  const search_url = window.location.search;  //?name=Bridal MAkeup by sharmila
    const getid = new URLSearchParams(search_url)
    const id = getid.get("bookingid");

    console.log(id)
    const url = window.location.search;  //?name=Bridal MAkeup by sharmila
    const urls = new URLSearchParams(url)
    const name = urls.get("param2");

    const date=urls.get("date")
    console.log(date)
    const radioButtons = document.getElementsByName("group");
    let selectedValue
    for (let i = 0; i < radioButtons.length; i++) {
      radioButtons[i].addEventListener("click", function () {
        if (this.checked) {
          selectedValue = this.value;

        }
      });
    }

    //     const bookinkdata=JSON.parse(localStorage.getItem("bookingDatas"))
    //     console.log(bookinkdata)



    // let res
    //     bookinkdata.find(e=>{
    //   if(id==e.bookingId){

    // res=e
    //   }

    //     })
    const bookingInfo = JSON.parse(localStorage.getItem("bookingDatas")).find(booking => booking.bookingId === parseInt(id));
    console.log(bookingInfo);

    const form_filled = document.getElementById("booking-form");
    form_filled.addEventListener('submit', e => {
      e.preventDefault();

      const data_of_cus = JSON.parse(localStorage.getItem("data"));
      const dataofartist = JSON.parse(localStorage.getItem("card_data"));
      // const active_user = localStorage.getItem("profile");
      const date_event_client = date
      const name_client = document.getElementById("Name-of-customer").value;
      const contact_client = document.getElementById("contact-of-customer").value;
      const addres_client = document.getElementById("address-customer").value;
      const time_client = document.getElementById("Time-choosen-customer").value;
      const address = document.getElementById("address-customer").value;
      const emailofcus = localStorage.getItem("profile");

      if (!name_client || !time_client || !contact_client || !addres_client || !address) {
        alert("Please fill all the required data.");
        return;
      }

      let isBooked = dataofartist.find(artist => {
        return artist.name === name_client && artist.booking_records && artist.booking_records.some(record => {
          return record.time === time_client;
        });
      });

      if (isBooked) {
        const failedmessage = `This date and time is already booked. You can proceed with booking someone else or choose another time. Thank you!`;
        const popupContainer = document.getElementById('popup-container');
        const popupMessage = document.getElementById('popup-message');
        popupMessage.textContent = failedmessage;
        popupContainer.style.display = 'block';

        const closeButton = document.getElementById('close-button');
        closeButton.addEventListener('click', function () {
          popupContainer.style.display = 'none';
        });
      } else {
        const totalcost = bookingInfo.bookingTotalCost;
        const details = bookingInfo.bookingDetails;

        const artist = dataofartist.find(obj => obj.name === name);
        if (!artist) {
          console.log("Artist not found.");
          return;
        }




     
        const customer = data_of_cus.find(obj => obj.user_email === emailofcus);
        console.log(customer)
        const object_booking_records = {
          "customer_name": name_client,
          "customer_email": emailofcus,
          "customer_contact": contact_client,
          "customer_address": addres_client,
          "event_date": date_event_client,
          "time": time_client,
          "status": false,
          "selected_event": selectedValue,

          "details_Of_booking_Info": details,
          "totalcost": totalcost,
          "location": address,
          "id": customer.booking_records.length > 0 ? customer.booking_records[customer.booking_records.length - 1].id + 1 : 1,
          "selected_artist_for_booking": name,
          "confirmation": false
        };

        console.log(object_booking_records.id)
        artist.booking_records.push(object_booking_records);

        const artistEmail = artist.user_email;
        const artistName = artist.name;
        // const profileUrl = `https://example.com/profile?name=${encodeURIComponent(artistName)}`;
        const message = `Dear ${name}, \n\nYou have a new booking from ${name_client} on ${time_client}. Please log in to your account to view the details of this booking. You can view <a href="../../pages/ArtistFeature.html">${artistName}'s</a> profile. \n\nThank you!`;
        sendemail(artistEmail, message);


        if (!customer) {
          console.log("Customer not found.");
          return;
        }


        customer.booking_records.push(object_booking_records);
        localStorage.setItem("data", JSON.stringify(data_of_cus));
        localStorage.setItem("card_data", JSON.stringify(dataofartist));

        const successMessage = `Your booking request  sended successful! to ${object_booking_records.selected_artist_for_booking}`;
        const popupContainer = document.getElementById('popup-container');
        const popupMessage = document.getElementById('popup-message');
        popupMessage.textContent = successMessage;
        popupContainer.style.display = 'block';

      }
    });


    let total_amount = document.getElementById("total-amount")

    total_amount.innerHTML += `${bookingInfo.bookingTotalCost}`


    let options = document.getElementById("options");
    let bookingDetails = bookingInfo.bookingDetails;
    let names = "";
    for (let i = 0; i < bookingDetails.length; i++) {
      names += bookingDetails[i].name + ", ";
    }
    options.value = names.slice(0, -2);



    const closeButton = document.getElementById('close-button');
    closeButton.addEventListener('click', () => {
      const popupContainer = document.getElementById('popup-container');
      popupContainer.style.display = 'none';
      window.location.href = "../profile_of_user.html"

    });

