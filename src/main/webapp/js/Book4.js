/**
 * 
 */



const urlParams = new URLSearchParams(window.location.search);
const booking_id = urlParams.get("booking_id");
const artist_name = urlParams.get("artistemail");
const user_email = urlParams.get("user_email");


console.log(booking_id);
console.log(artist_name);
console.log(user_email);



let data_artist=JSON.parse(localStorage.getItem("card_data"))

let data_active_user=JSON.parse(localStorage.getItem("data"))
console.log(data_artist)
console.log(data_active_user)



let res
data_artist.find(e=>{
  if(e.name==artist_name){
 return res=e;
  }

})



let user
data_active_user.find(e=>{
  if(e.user_email==user_email){
    return user=e
  }


})









user.booking_records.find(e=>{
  if(e.id==booking_id){




    showing_addedlist(e)
    console.log(e)
    

  }
})


function showing_addedlist(element) {
  let div = document.querySelector(".booking_list");
  div.innerHTML +=
    `<div class="savinglist">
      <h1>Total booking</h1>
      <div class="totalbooking">`;

  const customerData = {}; 
  let overallTotalCost = 0; 

  res.booking_records.find((element) => {
    if (element.id == booking_id) {
      element.details_Of_booking_Info.forEach((option) => {
        const customerNumber = option.customerNumber;

        if (!customerData.hasOwnProperty(customerNumber)) {
          // Create a new entry for the customer if it doesn't exist
          customerData[customerNumber] = {
            items: [],
            totalCost: 0
          };
        }

        const itemData = {
          name: option.name,
          cost: option.cost
        };

        customerData[customerNumber].items.push(itemData);
        customerData[customerNumber].totalCost += parseInt(option.cost.replace("cost : Rs ", ""));

        overallTotalCost += parseInt(option.cost.replace("cost : Rs ", ""));
      });
    }
  });

  // Loop through customer data and display the booking list
  for (const customerNumber in customerData) {
    const customer = customerData[customerNumber];



  div.innerHTML +=
      `<div class="customer_${customerNumber}">
        <h3>${customerNumber}</h3>
        <div class="names_total_cost">`;



    customer.items.forEach((item) => {
      div.innerHTML +=
        `<div class="one">
          <p>${item.name}</p>
          <p>Cost: ₹ ${item.cost}</p>
        </div>`
    });



    div.innerHTML += `</div>
      <h3 class="single_cust_total_cost">TOTAL COST: ₹ ${customer.totalCost}</h3>
      <hr class="horizontal_line">
    </div>`;
  }

  div.innerHTML +=
    `<h3 class="over_all_total_amount">Total amount: ₹ ${overallTotalCost}</h3>
  </div>
</div>`;

div.innerHTML+=`
<button  class="pay_btn"onclick="payment_confirmed('${booking_id}')">Pay</button>



`






}
function payment_confirmed(id){



  res.booking_records.find(e=>{
if(e.id==booking_id){

  e.confirmation=true;

  localStorage.setItem("card_data",JSON.stringify(data_artist))

}
    
user.booking_records.find(e=>{
  if(e.id==booking_id){
    e.confirmation=true;
    localStorage.setItem("data",JSON.stringify(data_active_user))
    
  }



})




window.location.href="../booking/book5.html"








  })
}





// function sendemial(email_cus, mes) {
//       Email.send({
//         Host: "smtp.elasticemail.com",
//         Username: "emadhubala1@gmail.com",
//         Password: "5888FAB177209DF44C3A157057CF48050EE3",
//         To: email_cus,
//         From: "emadhubala1@gmail.com",
//         Subject: "About your booking statement",
//         Body: mes
//       })
//         .then(message => {
//           alert(message);
//           window.location.href = "../../pages/profileartist.html";
//         });
//     }



