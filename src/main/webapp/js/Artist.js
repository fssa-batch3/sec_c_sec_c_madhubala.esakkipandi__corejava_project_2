/**
 * 
 */

 let active_artist=localStorage.getItem("artist_profile")
console.log(active_artist);
let details=JSON.parse(localStorage.getItem("card_data"))
 let finded=details.find(e=>e.user_email==active_artist)

console.log(finded)
let name_artist=finded.name
console.log(name_artist)
    let name=document.querySelectorAll(".head_h3");