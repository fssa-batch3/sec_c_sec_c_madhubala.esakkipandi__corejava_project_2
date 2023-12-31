/**
 * 
 */

  const url = window.location.search;  //?name=Bridal MAkeup by sharmila
    const urls = new URLSearchParams(url)
    const name = urls.get("artist_name");

const date=urls.get("date")
console.log(date)
    console.log(name)

    const radioButtons = document.getElementsByName("group");
    let selectedValue
    for (let i = 0; i < radioButtons.length; i++) {
      radioButtons[i].addEventListener("click", function () {
        if (this.checked) {
          selectedValue = this.value;

        }
      });
    }


const saving_data = JSON.parse(localStorage.getItem("saving_detail"));

if (saving_data) {
  const current_user = localStorage.getItem("profile");
  saving_data.forEach(element => {
    if (element.user == current_user&&element.name==name) {
      showing_list(element);
    
    }
  });
}

function showing_list(e) {
  const showing_booking_list = document.querySelector(".listing");
  showing_booking_list.innerHTML += `<div class="list_1">
    <div class="pic_book_list">
      <img src="${e.item_img}" class="selected_list_img">
    </div>
    <div class="details_cost">
      <h3>${e.item_name}</h3>
      <p>cost : Rs ${e.item_cost}</p>
      <h6 class="id">${e.item_id}</h6>
    </div>
  </div>`;
}

const current_user = localStorage.getItem("profile");
const user_savings = saving_data.filter(item => item.user === current_user);

const total_booking_div = document.querySelector(".totalbooking");
total_booking_div.innerHTML = "";

const selected_values = [...new Set(user_savings.map(item => item.selected_value))];
let total_booking_cost = 0;


selected_values.forEach((selected_value, index) => {
  const customer_div = document.createElement("div");
  customer_div.className = `customer_${index + 1}`;

  const customer_title = document.createElement("h3");
  customer_title.textContent = `Customer ${index + 1}`;
  customer_div.appendChild(customer_title);

  const names_total_cost_div = document.createElement("div");
  names_total_cost_div.className = "names_total_cost";

  let total_cost = 0;

  user_savings.forEach(item => {
    if (item.selected_value === selected_value) {
      
      const item_div = document.createElement("div");
      item_div.className = "one";

      const item_name = document.createElement("p");
      item_name.textContent = item.item_name;
      item_div.appendChild(item_name);

      const item_cost = document.createElement("p");
      item_cost.textContent = `Cost: ₹ ${item.item_cost}`;
      item_div.appendChild(item_cost);

      names_total_cost_div.appendChild(item_div);

      total_cost += parseInt(item.item_cost);
    }
  });

  customer_div.appendChild(names_total_cost_div);

  const total_cost_title = document.createElement("h3");
  total_cost_title.className = "single_cust_total_cost";
  total_cost_title.textContent = `TOTAL COST: ₹ ${total_cost}`;
  customer_div.appendChild(total_cost_title);

  total_booking_div.appendChild(customer_div);

  total_booking_cost += total_cost; // increment the booking total cost with each customer's total cost
});

const booking_total_cost = document.createElement("h3");
booking_total_cost.className = "booking_total_cost";
booking_total_cost.textContent = `Booking Total Cost: ₹ ${total_booking_cost}`;
total_booking_div.appendChild(booking_total_cost);

console.log(total_booking_cost)

// let total_cost_in_form=document.getElementById("total-amount")

// total_cost_in_form.innerText=total_booking_cost

const bookNowButton = document.querySelector(".proceed");
bookNowButton.addEventListener("click", () => {
  // Get the active user from localStorage
  const activeuser = localStorage.getItem("profile");

// ...

const bookingList = document.querySelectorAll(".list_1");
const bookingDetails = Array.from(bookingList).map((listItem, index) => {
  const itemImg = listItem.querySelector(".selected_list_img").getAttribute("src");
  const itemName = listItem.querySelector(".details_cost h3").textContent;
  const itemCost = listItem.querySelector(".details_cost p").textContent.replace("cost+", "");
  const itemId = listItem.querySelector(".details_cost h6").textContent;

  const itemCustomerNumber = selected_values[index % selected_values.length];

  return { img: itemImg, name: itemName, cost: itemCost, customerNumber: itemCustomerNumber, itemId };
});

// ...



  const bookingTotalCost = document.querySelector(".booking_total_cost").textContent.replace("Booking Total Cost: ₹ ", "");

  if (bookingDetails.length === 0 || bookingTotalCost === "0") {
    // Show an error message instead of redirecting
    alert("Please select some items before proceeding.");
    return;
  }


  // Generate a unique booking ID
  const bookingId = Date.now();

  const newBooking = {
    bookingId,
    bookingDetails,
    bookingTotalCost,
    activeuser // Include the active user in the new booking object
  };

  const bookingData = JSON.parse(localStorage.getItem("bookingDatas")) || [];

  const existingBookingIndex = bookingData.findIndex(booking => booking.bookingId === newBooking.bookingId);
  if (existingBookingIndex === -1) {
    bookingData.push(newBooking);
  } else {
    // If an existing booking with the same ID is found, update the booking details and total cost
    bookingData[existingBookingIndex].bookingDetails = newBooking.bookingDetails;
    bookingData[existingBookingIndex].bookingTotalCost = newBooking.bookingTotalCost;
  }

  // Get the active user from localStorage
  const current_user = localStorage.getItem("profile");

  // Filter the saving_data array to remove items that were added to the booking by the current user
  const filtered_saving_data = saving_data.filter(item => !(item.user === current_user && item.name === name));

  // Save the updated saving_data array back to localStorage
  localStorage.setItem("saving_detail", JSON.stringify(filtered_saving_data));

  // Redirect to the next page
  window.location.href = `./finalbooking.html?bookingid=${bookingId}&param2=${name}&date=${date}`;

  localStorage.setItem("bookingDatas", JSON.stringify(bookingData));
});



