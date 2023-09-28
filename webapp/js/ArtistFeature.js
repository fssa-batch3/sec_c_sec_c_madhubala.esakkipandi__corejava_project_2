/**
 * 
 */

  const get_form = document.getElementById("login_form");

    get_form.addEventListener("submit", (e) =>{

        e.preventDefault();

const artist_data=JSON.parse(localStorage.getItem("card_data"))
const usermail = document.getElementById("user").value
const userpass = document.getElementById("pass").value

let result;
let artist_email;
artist_data.find(  // parameterized function 'a'
   e => {
   if(e.user_email == usermail && e.artist_password == userpass) { //data=[{0},{1}] //a=data[0],a=data[1]

       artist_email = e.user_email;
       return result = 1;
   }

       return result = 0;
   
   }

);

if (result === 1) {
   
   localStorage.setItem("artist_profile",artist_email)
   alert("logged in")
   window.location.href="../pages/artit.html";
   // window.location.href = "../index.html"
}

else {
   alert("none")
}
        
})