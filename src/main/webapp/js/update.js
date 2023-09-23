/**
 * 
 */

 

document.getElementById("cardform").addEventListener('submit', e => {
  e.preventDefault();
 
  const email_of_artist = document.getElementById("email-artist").value;
  const url = document.getElementById("link_url").value;
  const name = document.getElementById("artistname").value;
  const local = document.getElementById("locality").value;
  const ruppee = document.getElementById("rs").value;
  const address_artist = document.getElementById("address-artist").value;
  const password_artist = document.getElementById("password-artist").value;
  const confirmpasswrod = document.getElementById("confirmpass-artist").value;
  const experince_of_artst = document.getElementById("expernice-artist").value;
  const contact_artist = document.getElementById("number-artist").value;

  const data_records = JSON.parse(localStorage.getItem("card_data"));

  

  if (
    name !== "" &&
    email_of_artist.trim() !== "" &&
    password_artist.trim() !== "" &&
    confirmpasswrod.trim() !== "" &&
    url.trim() !== "" &&
    local.trim() !== "" &&
    ruppee.trim() !== "" &&
    experince_of_artst.trim() !== "" &&
    contact_artist.trim() !== "" &&
    address_artist.trim() !== ""
  ) {
    const card_data = JSON.parse(localStorage.getItem("card_data")) || [];
    const booking_records = [];
    const selected_dates = [];
    const serivice=[]

    const data_card = {
      address: address_artist,
      name,
      user_email: email_of_artist,
      artist_password: password_artist,
      confirm_pass: confirmpasswrod,
      ruppi: ruppee,
      localty: local,
      contact: contact_artist,
      experince_of_artist: experince_of_artst,
      image_url: url,
      booking_records: booking_records,
      selected_dates: selected_dates ,
      services_provding:serivice
      // Add the selected_dates array to the data_card object
    };

    let success = true;
    if (data_records != null) {
      for (let i = 0; i < data_records.length; i++) {
        if (data_records[i].user_email == email_of_artist) {
          success = false;
          break;
        }
      }
    }

    if (success) {
      if (password_artist == confirmpasswrod) {
        card_data.push(data_card);
        localStorage.setItem("card_data", JSON.stringify(card_data));
        alert("Registered successfully");
        window.location.href = "../ArtistFeature.html";
      } else {
        alert("Password mismatch");
      }
    } else {
      alert("Already You have registered");
    }
  } else {
    alert("Fill in all the required data");
  }
});


document.getElementById("delete").addEventListener("click",event=>{
                event.preventDefault();
            
 const card=JSON.parse(localStorage.getItem("card_data"))
            
            for(let i=0;i<card.length;i++){

                if(document.getElementById("artistname").value==card[i].name){
                    card.splice(i,1)
                    localStorage.setItem("card_data",JSON.stringify(card))
                }
            }
            
            })