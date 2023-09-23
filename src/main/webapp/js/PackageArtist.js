/**
 * 
 */

 
 const addBtn = document.getElementById('btn_add');
const formService = document.getElementById('fomr_service');
const container = document.getElementById('container');

addBtn.addEventListener('click', () => {
  formService.style.display = 'block';
  container.classList.toggle('blur');
});

const listingForm = document.getElementById("listing");
listingForm.addEventListener("submit", (event) => {
  event.preventDefault();

  const radioButtons = document.getElementsByName("category");
  let selectedValue = "";

  for (let i = 0; i < radioButtons.length; i++) {
    if (radioButtons[i].checked) {
      selectedValue = radioButtons[i].value;
      break;
    }
  }

  const active_user = localStorage.getItem("artist_profile");
  const name = document.getElementById("name_of_cetegory").value;
  const cost = document.getElementById("number_for_cetegory").value;
  const image = document.getElementById("url_of_cetegory").value;

  if (!name || !cost || !image) {
    alert("Please fill out all required fields.");
    return;
  }

  const dataOfArtist = JSON.parse(localStorage.getItem("card_data"));
  const user = dataOfArtist.find((obj) => obj.user_email === active_user);

  if (!user) {
    console.log("User not found.");
    return;
  }

  const listing_items = user.services_provding || [];

  const object = {
    category: selectedValue,
    name,
    cost,
    image,
    artist_email: active_user,
    category_id: listing_items.length,
  };

  listing_items.push(object);

  user.services_provding = listing_items;

  localStorage.setItem("card_data", JSON.stringify(dataOfArtist));
  alert("service added")
  location.reload()
});


        
let close_button=document.querySelector(".fa-circle-xmark");

close_button.addEventListener('click',e=>{
    location.reload()
})



const data_artist = JSON.parse(localStorage.getItem("card_data"))
const active_user = localStorage.getItem("artist_profile");

const artist_object = data_artist.find((obj) => obj.user_email === active_user);

console.log(artist_object);
console.log(artist_object.services_provding);
artist_object.services_provding.forEach(e => {
  let div = document.getElementById("pack");

  
  div.innerHTML += `
      <div class="card" onclick="card_service(${e.category_id})">
        <img src="${e.image}" class="pic">
        <p class="name_service">${e.name}</p>
        <p class="cost_service">cost: Rs:${e.cost}</p>
      </div>
    `
});




function card_service(category_id) {
  const data_artist = JSON.parse(localStorage.getItem("card_data"));
  const active_user = localStorage.getItem("artist_profile");

  const artist_object = data_artist.find((obj) => obj.user_email === active_user);

  let res;
  artist_object.services_provding.find((e) => {
    if (e.category_id == category_id) {
      return (res = e);
    }
  });









  let edit_delete = document.querySelector(".edit_delete");
  let div_hide = document.querySelector(".artist_pack");

  edit_delete.style.display = 'block';
  div_hide.classList.toggle('blur');

  let showNameElement = document.querySelector(".show_name");
  let costEditElement = document.querySelector(".cost_edit");
  let imageEditElement = document.querySelector(".image_edit");

  let storedData = res;
  if (storedData) {
    showNameElement.innerHTML = storedData.name;
    costEditElement.value = storedData.cost;
    imageEditElement.value = storedData.image;
  }


  let deleteButton = document.getElementById("Delete_button");
  deleteButton.addEventListener("click", function(event) {
    event.preventDefault(); // Prevent form submission

    // Remove the object from local storage
    if (storedData) {
      const dataIndex = artist_object.services_provding.indexOf(storedData);
      if (dataIndex > -1) {
        artist_object.services_provding.splice(dataIndex, 1);
        localStorage.setItem("card_data", JSON.stringify(data_artist));
      }

    }

    // Optionally, display a success message or perform any additional actions
    alert("Data deleted successfully!");
    location.reload()
  });

let editButton = document.getElementById("edit_button");
  editButton.addEventListener("click", function(event) {
    event.preventDefault(); 

   
    let updatedCost = costEditElement.value;
    let updatedImage = imageEditElement.value;

    if (storedData) {
      storedData.cost = updatedCost;
      storedData.image = updatedImage;

      localStorage.setItem("card_data", JSON.stringify(data_artist));

      alert("Data updated successfully!");
      location.reload()
    }
    })
}
