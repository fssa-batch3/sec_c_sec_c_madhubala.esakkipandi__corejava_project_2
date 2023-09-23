/**
 * 
 */

 
const urlParams = new URLSearchParams(window.location.search);
const dateParam = urlParams.get("date"); 

console.log(dateParam);

const [year, month, day] = dateParam.split("-").map(Number);

const place = urlParams.get("place");

const records = JSON.parse(localStorage.getItem("card_data"))

console.log(records)

let filteredArtistsByPlace = records.filter((artist) => {
  return artist.localty === place;
});

filteredArtistsByPlace.forEach((artist) => {
  console.log(artist.selected_dates);
});

console.log(filteredArtistsByPlace,"ppp");

let filteredArtistsByDate = filteredArtistsByPlace.filter((artist) => {
  const hasSelectedDates =
    artist.selected_dates && artist.selected_dates.length > 0;

  const hasBookingRecords =
    artist.booking_records && artist.booking_records.length > 0;

  const selectedDatesMatch = hasSelectedDates
    ? artist.selected_dates.some((selectedDate) => {
        if (typeof selectedDate !== 'string') {
          return false;
        }
        const [selectedYear, selectedMonth, selectedDay] = selectedDate.split('-');
        return (
          Number(selectedYear) === year &&
          Number(selectedMonth) === month &&
          Number(selectedDay) === day
        );
      })
    : false;

  const bookingRecordsMatch = hasBookingRecords
    ? artist.booking_records.some((bookingRecord) => {
        if (typeof bookingRecord.event_date !== 'string') {
          return false;
        }
        const [eventYear, eventMonth, eventDay] = bookingRecord.event_date.split('-');
        return (
          Number(eventYear) === year &&
          Number(eventMonth) === month &&
          Number(eventDay) === day
        );
      })
    : false;

  return !selectedDatesMatch && !bookingRecordsMatch;
});






// console.log()
console.log(filteredArtistsByDate,"ii")
document.querySelector(".count").textContent = `${filteredArtistsByDate.length} results were found `;

if (filteredArtistsByDate.length === 0) {
  const noResultsDiv = document.createElement("div");
  noResultsDiv.innerText = "No artists are available on that date.";
  document.querySelector(".box").appendChild(noResultsDiv);
  
}


// else {
//   const gridIcon = document.getElementById("grid");
//   const boxDiv = document.querySelector(".box");

//   gridIcon.addEventListener("click", () => {
//     if (!boxDiv.classList.contains("grid-view")) {
//       boxDiv.classList.add("grid-view");
//     } else {
//       boxDiv.classList.remove("grid-view");
//     }
//   });

//   for (const artist of filteredArtistsByDate) {
//     if (!boxDiv.classList.contains("grid-view")) {
    
//           const div_1 = document.createElement("div");
//     div_1.setAttribute("class", "one");
//     document.querySelector(".box").prepend(div_1);

//     const div_2 = document.createElement("div");
//     div_2.setAttribute("class", "pic");
//     document.querySelector(".one").append(div_2);

//     const img_1 = document.createElement("img");
//     img_1.setAttribute("src", artist.image_url);
//     img_1.setAttribute("class", "profile");
//     img_1.setAttribute("alt", "Makeup");
//     document.querySelector(".pic").append(img_1);

//     const p_1 = document.createElement("p");
//     p_1.innerHTML =artist.name;
//     document.querySelector(".one").append(p_1);

//     const p_2 = document.createElement("p");
//     p_2.innerHTML = "5.0(51reviews)";
//     p_2.setAttribute("class", "para");
//     document.querySelector(".one").append(p_2);

//     const i = document.createElement("i");
//     i.setAttribute("class", "fa-solid fa-star");
//     i.setAttribute("id", "star");
//     document.querySelector(".para").append(i);

//     const div_3 = document.createElement("div");
//     div_3.setAttribute("class", "local");
//     document.querySelector(".one").append(div_3);

//     const img_2 = document.createElement("img");
//     img_2.setAttribute("src", "../../assets/images/map.png");
//     img_2.setAttribute("alt", "map");
//     img_2.setAttribute("class", "map");
//     document.querySelector(".local").append(img_2);

//     const p_3 = document.createElement("p");
//     p_3.innerHTML = artist.localty;
//     p_3.setAttribute("class", "chennai");
//     document.querySelector(".local").append(p_3);

//     const p_4 = document.createElement("p");
//     p_4.innerHTML = "Minimum makeup prize";
//     document.querySelector(".one").append(p_4);

//     const p_5 = document.createElement("p");
//     p_5.innerHTML = "₹ " + artist.ruppi;
//     p_5.setAttribute("class", "Price");
//     document.querySelector(".one").append(p_5);

//     const a_1 = document.createElement("a");
//     a_1.setAttribute("href", `../booking/book2.html?name=${artist.name}&date=${year}-${month}-${day}`);
//     a_1.setAttribute("class", "anker");
//     document.querySelector(".one").append(a_1);

//     const button_1 = document.createElement("button");
//     button_1.innerHTML = "See more";
//     document.querySelector(".anker").append(button_1);

//     } else {
//       // Display content in grid view
//       boxDiv.innerHTML += `
//         <div class="grid_div">
//           <div class="card">
//             <div class="pic_grid">
//               <img src="${artist.image_url}" class="grid_image">
//             </div>
//             <div class="contnt_grid">
//               <p>${artist.name}</p>
//               <p>Ratings_reviews</p>
//               <p>${artist.localty}</p>
//               <p>${artist.ruppi}</p>
//               <button>see more</button>
//             </div>
//           </div>
//         </div>`;
//     }
//   }
// }
else {



  for (const artist of filteredArtistsByDate) {
    const div_1 = document.createElement("div");
    div_1.setAttribute("class", "one");
    document.querySelector(".box").prepend(div_1);

    const div_2 = document.createElement("div");
    div_2.setAttribute("class", "pic");
    document.querySelector(".one").append(div_2);

    const img_1 = document.createElement("img");
    img_1.setAttribute("src", artist.image_url);
    img_1.setAttribute("class", "profile");
    img_1.setAttribute("alt", "Makeup");
    document.querySelector(".pic").append(img_1);

    const p_1 = document.createElement("p");
    p_1.innerHTML =artist.name;
    document.querySelector(".one").append(p_1);

    const p_2 = document.createElement("p");
    p_2.innerHTML = "5.0(51reviews)";
    p_2.setAttribute("class", "para");
    document.querySelector(".one").append(p_2);

    const i = document.createElement("i");
    i.setAttribute("class", "fa-solid fa-star");
    i.setAttribute("id", "star");
    document.querySelector(".para").append(i);

    const div_3 = document.createElement("div");
    div_3.setAttribute("class", "local");
    document.querySelector(".one").append(div_3);

    const img_2 = document.createElement("img");
    img_2.setAttribute("src", "../../assets/images/map.png");
    img_2.setAttribute("alt", "map");
    img_2.setAttribute("class", "map");
    document.querySelector(".local").append(img_2);

    const p_3 = document.createElement("p");
    p_3.innerHTML = artist.localty;
    p_3.setAttribute("class", "chennai");
    document.querySelector(".local").append(p_3);

    const p_4 = document.createElement("p");
    p_4.innerHTML = "Minimum makeup prize";
    document.querySelector(".one").append(p_4);

    const p_5 = document.createElement("p");
    p_5.innerHTML = "₹ " + artist.ruppi;
    p_5.setAttribute("class", "Price");
    document.querySelector(".one").append(p_5);

    const a_1 = document.createElement("a");
    a_1.setAttribute("href", `../booking/book2.html?name=${artist.name}&date=${year}-${month}-${day}`);
    a_1.setAttribute("class", "anker");
    document.querySelector(".one").append(a_1);

    const button_1 = document.createElement("button");
    button_1.innerHTML = "See more";
    document.querySelector(".anker").append(button_1);




  }
}




//search filter for searching artist

      result_of_search= document.getElementById("search")
      result_of_search.addEventListener("input", (e) => {
      let word = e.target.value.toLowerCase();
      let dic = document.querySelectorAll(".one");
      console.log(word)
      dic.forEach(ex => {
        let child = ex.children[1].textContent.toLocaleLowerCase();
        if (child.startsWith(word)) {
          ex.style.display = "block"
        }
        else {
          ex.style.display = "none"
        }       
      })
      let count = document.querySelectorAll(".one[style='display: block;']").length;
      console.log(count)
  let countText = `${count} results are found`;
  document.querySelector(".count").textContent = countText;
//   document.querySelector(".count").style.display = "block";


    })
     

    //LOGGED IN DATA
    const isLoggedIn = localStorage.getItem("profile") !== null;

const loginLink = document.querySelector('a[href="../Login/login.html"]');
const profileLink = document.querySelector('a[href="../profile_of_user.html"]');

if (isLoggedIn) {
    loginLink.style.display = "none";
    profileLink.style.display = "block";
} else {
    loginLink.style.display = "block";
    profileLink.style.display = "none";
}


