/**
 * 
 */

 const profileBtn = document.getElementById("profile-btn");
    const loginBtn = document.getElementById("login-btn");
    
    const userEmail = localStorage.getItem("profile");
    if (userEmail) {
        profileBtn.style.display = "block";
        loginBtn.style.display = "none";
    } else {
        profileBtn.style.display = "none";
        loginBtn.style.display = "block";
    }

    const button = document.querySelector('.book_now');
button.addEventListener('click', (e) => {
  e.preventDefault();

  const isLoggedIn = checkLoggedIn();
  const isRegistered = checkRegistered();

  // Get form values
  const date = document.getElementById("date").value;
  const place = document.getElementById("place").value;

  // Check if all form fields are filled
  if (date === "" || place === "") {
    alert("Please fill all fields");
    return;
  }

  if (!isLoggedIn) {
    alert("Please log in to proceed");
    window.location.href = '../login/login.html';
    return;
  }

  if (!isRegistered) {
    alert("Please register to proceed");
    // Redirect to registration page
    window.location.href = '../registration/registration.html';
    return;
  }

  // All conditions met, construct the URL and navigate to the next page
  const url = `../booking/book.html?date=${date}&place=${place}`;
  window.location.href = url;
});


function checkLoggedIn() {
  const userEmail = localStorage.getItem("profile");
  return userEmail !== null; 
}

function checkRegistered() {
  const userEmail = localStorage.getItem("profile");
  const data = JSON.parse(localStorage.getItem("data"));
  if (data !== null) {
    for (let i = 0; i < data.length; i++) {
      if (data[i].user_email == userEmail) {
        return true; 
      }
    }
  }
  return false; 
}





const dateInput = document.getElementById('date');
const today = new Date();
const year = today.getFullYear();
let month = today.getMonth() + 1;
let day = today.getDate();

// Add leading zeros if month or day is less than 10
if (month < 10) {
  month = '0' + month;
}

if (day < 10) {
  day = '0' + day;
}

const minDate = year + '-' + month + '-' + day;
dateInput.setAttribute('min', minDate);
