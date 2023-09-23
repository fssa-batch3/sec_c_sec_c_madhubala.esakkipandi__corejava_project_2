/**
 * 
 */

 
        const artist_details = JSON.parse(localStorage.getItem("card_data"))
        const url = window.location.search;  //?name=Bridal MAkeup by sharmila
        console.log(url);

        const urls = new URLSearchParams(url)
        console.log(urls)//"name":"sharmila"

        const name = urls.get("name");
        console.log(name);

        const dateParam = urls.get("date");
        console.log(dateParam);

        // console.log(name)//"sharmila"

        // const name_1 = document.getElementById("name")

        // name_1.innerText = "sasi"
        var worksOfText = document.querySelectorAll(".works");

worksOfText.forEach(element => {
  element.innerHTML += `Works of ${name}`;
});
        let result;
        artist_details.find((e) => {
            if (e.name == name) {
                return result = e;

            }
        })
        console.log(result)

        const div_1 = document.createElement("div")
        div_1.setAttribute("class", "content-1-profile")
        document.querySelector(".profile-content").append(div_1)

        const img_1 = document.createElement("img")
        img_1.setAttribute("src", result.image_url);
        img_1.setAttribute("class", "profile");
        img_1.setAttribute("alt", "Makeup")
        document.querySelector(".content-1-profile").append(img_1)

        const div_2 = document.createElement("div")
        div_2.setAttribute("class", "content-2-profile")
        document.querySelector(".profile-content").append(div_2)

        const div_3 = document.createElement("div")
        div_3.setAttribute("class", "review")
        document.querySelector(".content-2-profile").append(div_3)

        const h_1 = document.createElement("h1")
        h_1.setAttribute("class", "name_of_artist")
        h_1.innerHTML = `Bridal Makeup By` + ` ${result.name}`
        document.querySelector(".review").append(h_1)

        const p_1 = document.createElement("p")
        p_1.innerHTML = "4.7"
        p_1.setAttribute("class", "icon_p")
        document.querySelector(".review").append(p_1)

        const i = document.createElement("i")
        i.setAttribute("class", "fa-solid fa-pen-nib")
        i.setAttribute("id", "icoen")
        document.querySelector(".icon_p").append(i)

        const p_2 = document.createElement("p")
        p_2.innerHTML = "36review"
        document.querySelector(".review").append(p_2)

        const div_4 = document.createElement("div")
        div_4.setAttribute("class", "  contact")
        document.querySelector(".content-2-profile").append(div_4)

        const img_2 = document.createElement("img")
        img_2.setAttribute("src", "../../assets/images/map.png")
        img_2.setAttribute("class", "map")
        img_2.setAttribute("alt", "map")
        document.querySelector(".contact").append(img_2)

        const p_3 = document.createElement("p")
        p_3.innerHTML = result.localty
        document.querySelector(".contact").append(p_3)

        const p_4 = document.createElement("p")
        p_4.innerHTML = "contact : " +  result.contact
        document.querySelector(".contact").append(p_4)

        const div_5 = document.createElement("div")
        div_5.setAttribute("class", "  line")
        document.querySelector(".content-2-profile").append(div_5)

        const p_5 = document.createElement("p")
        p_5.setAttribute("class", "icon_p1")
        p_5.innerHTML = "photos"
        document.querySelector(".line").append(p_5)

        const i_2 = document.createElement("i")
        i_2.setAttribute("class", "fa-regular fa-image")
        i_2.setAttribute("id", "icoen")
        document.querySelector(".icon_p1").append(i_2)

        const a_0 = document.createElement("a")
        // a_0.setAttribute("href", "")
        a_0.setAttribute("class", "ankerlnik")
        a_0.setAttribute("id", "wishlist")
        document.querySelector(".line").append(a_0)

        const p_6 = document.createElement("p")
        p_6.setAttribute("class", "icon_p2")
        p_6.innerHTML = "Add to wishlist"

        document.querySelector(".ankerlnik").append(p_6)

        const i_3 = document.createElement("i")
        i_3.setAttribute("class", "fa-regular fa-heart")
        i_3.setAttribute("id", "icoen")
        document.querySelector(".icon_p2").append(i_3)

        const p_7 = document.createElement("p")
        p_7.setAttribute("class", "icon_p3")
        p_7.innerHTML = "Write a review"

        document.querySelector(".line").append(p_7)

        const i_4 = document.createElement("i")
        i_4.setAttribute("class", "   fa-solid fa-pen-nib")
        i_4.setAttribute("id", "icoen")
        document.querySelector(".icon_p3").append(i_4)

        const p_8 = document.createElement("p")
        p_8.setAttribute("class", "icon_p4")
        p_8.innerHTML = "share"
        document.querySelector(".line").append(p_8)

        const i_5 = document.createElement("i")
        i_5.setAttribute("class", "  fa-solid fa-share-nodes")
        i_5.setAttribute("id", "icoen")
        document.querySelector(".icon_p4").append(i_5)

        const div_6 = document.createElement("div")
        div_6.setAttribute("class", "starting-price ")
        document.querySelector(".content-2-profile").append(div_6)

        const p_9 = document.createElement("p")
        p_9.setAttribute("class", "str_prc")
        p_9.innerHTML = "starting price"
        document.querySelector(".starting-price").append(p_9)

        const hr = document.createElement("hr")
        document.querySelector(".starting-price").append(hr)

        const p_10 = document.createElement("p")
        p_10.setAttribute("class", "prc")
        p_10.innerHTML = result.ruppi
        //             // --------
        document.querySelector(".starting-price").append(p_10)

        const a_1 = document.createElement("a")
        a_1.setAttribute("href", `../../pages/booking/book3.html?book_name=${name}`)
        a_1.setAttribute("class", "ankerlik")
        document.querySelector(".content-2-profile").append(a_1)

        // const button_1 = document.createElement("button")
        // button_1.setAttribute("class", "buttontopbtn")
        // button_1.innerHTML = "BOOK NOW"
        // document.querySelector(".ankerlik").append(button_1)
        // -------------------------------------------------------------------------------------

        // uploading images of artist
        const img_artist = JSON.parse(localStorage.getItem("card_data"))
        // console.log(img_artist)
        let element
        img_artist.filter(e => {
            if (name == e.name) {
                return element = e
            }

        })

console.log(element.upload)
 if(element.upload===undefined){

    
    let div = document.querySelector(".pic-content")
                div.innerHTML +=
                    `<p>There is no works uploaded by this artist</p>`
}


       
        let ele = element.upload


if(ele){
        ele.forEach(e => {
           
      

                let div = document.querySelector(".pic-content")
                div.innerHTML += `
           <img src="${e.imgurl}" class="pic-one">
       
            `
            
        })

    }
    p_5.addEventListener("click", () => {
  let div = document.querySelector(".pic-content");
  div.scrollIntoView({ behavior: "smooth" });
});

p_7.addEventListener("click", () => {
  let reviewBox = document.querySelector(".review_box");
  reviewBox.scrollIntoView({ behavior: "smooth" });
});






        // ----------------------------------------------------

        const artist_reviews = JSON.parse(localStorage.getItem("artistreviews")) ? JSON.parse(localStorage.getItem("artistreviews")) : [];
        let output = "";

        // Active artist name------------------

        const reviewer_name = localStorage.getItem("profile")
        const reviewer_name_matching = JSON.parse(localStorage.getItem("data"))
        let re;
        reviewer_name_matching.find((e) => {
            if (e.user_email == reviewer_name) {
                return re = e

            }

        }
        )

        // -----------------------------------

        const review_output = document.querySelector(".boxer");
        document.getElementById("sub-form").addEventListener("submit", e => {
            e.preventDefault();

            star_count = 0
            const star_icon = document.querySelectorAll(".active")
            star_count = star_icon.length
            // const input = document.getElementById("experience").value;
            const commentes = document.getElementById("vendors_review").value;
            const name_of_reviewer = re.user_name
            if ((commentes !== "")) {

                const user_rev = {
                    // input,
                    "comments": commentes,
                    "artists_name": name,
                    "reviewer_name": name_of_reviewer,
                    "count": star_count

                }
                artist_reviews.push(user_rev);
                localStorage.setItem("artistreviews", JSON.stringify(artist_reviews));
                alert("done");
                output = " ";
                review_list();
            }
            else {
                alert("not done");
            }
        }
        )

   






        const check = document.querySelectorAll(".check i");
       
        check.forEach((star, index1) => {
            star.addEventListener("click", () => {
             
                check.forEach((star, index2) => {
       
                    index1 >= index2 //4>=0
                        ? star.classList.add("active") //true
                        : star.classList.remove("active"); //false
                });
            });
        });

        // -----------------

        // ---------------------------------------


        //  -------------------------------

        // user's review

        function review_list() {
            let reviewCount = 0;
            for (let i = 0; i < artist_reviews.length; i++) {
                if (artist_reviews[i].artists_name == name) {
                    output +=
                        ` <div class="reviewocmment">
                     <div class="holeboxreview">
                        <div class="userprofile">
                          <img src="../../assets/images/73x73.png">
                         </div>
                        <div class="name_month">
                        <div class="name">
                        <div class="reference">
                        <p id="reviewrname">${artist_reviews[i].reviewer_name} </p>
                        </div>
                        <div class="ratings">
                        <p> <i id="star" class="fa-solid fa-star"></i><span>${artist_reviews[i].count}</span></p>
                        </div>  
                        </div>
                        <p >reviwed 2 weeks ago</p>
                        </div>
                        </div>
                        <div class="shown_comment">
                        <p class="month" id="commnt"> ${artist_reviews[i].comments}</p>
                        <p class="month">Recommended:</p>
                        <img src="../../assets/images/quality-of-work.webp" class="quality">

                  </div>

            </div>`

            reviewCount++; 
                   
                }
              
            }
            p_2.innerHTML = reviewCount + " reviews";
            review_output.innerHTML = output;
          
        }
        review_list();

        // ------------------------------

        // details's of artistname of current page

        const localityofartist = result.localty
        const container = document.getElementById("about")

        container.innerHTML += `
        <p class="details-artist">
            ${name} Makeover Artistry is an upscale bridal makeup professional.${name} Makeover Artistry love what they
            do and every client is sure to feel her passion when she works on them. The portfolio is sure to give you a
            good impression of what they're capable of! The expert team of artists and hair stylists ensure that all the
            services that they provide live up to the highest standard possible. They are widely reputed for their
            professional on time performance and delivery of their exquisite wedding services.
        </p>
        <br>
        <p>Location
            ${name} Makeover Artistry is based on ${localityofartist}, in the state of Tamil Nadu.
        </p>
    `

        // -----------------------

        const active_user = localStorage.getItem("profile");
        const dataofartist = JSON.parse(localStorage.getItem("data"));
        const artist_obj = dataofartist.find(obj => obj.user_email === active_user);
        const productTitle = name
        // console.log(result["artist_name"])

        const productImage = result.image_url;
        const productPrice = result.ruppi;
        const localityof_artist = result.localty
        const object_name = name;

        const wishlist_data = document.getElementById("wishlist");

        const user = dataofartist.find(obj => obj.user_email === active_user);

        wishlist_data.addEventListener('click', () => {

            const wish_data = JSON.parse(localStorage.getItem("wishlist_dta")) || [];
            const wishlistItem = {

                "email_user_wishlist": active_user,
                "user_name": object_name,
                "id_wishlist": wish_data.length,
                "title": productTitle,
                "image": productImage,
                
               
                "locality": localityof_artist,
                "status": false
            };

            const user = dataofartist.find(obj => obj.user_email === active_user);

            wish_data.push(wishlistItem);
            localStorage.setItem("wishlist_dta", JSON.stringify(wish_data));

            user.wishlist = wish_data.filter(element => element.email_user_wishlist === active_user);
            localStorage.setItem("data", JSON.stringify(dataofartist));
   alert("Wishlist added")

   location.reload()
        });

        let ress;
        artist_details.forEach((e) => {
            if (e.name == name) {
                ress = e;
                return true; 
            }
        });

        console.log(ress);

       
            console.log(  ress.services_provding.length)
if( ress.services_provding.length==0){
    console.log("aa");
let div=document.getElementById("data")
div.innerHTML+=`<p class="service_lisitng_none">There are no service is listed by the artist</p>`

const saveButton = document.querySelector(".save");
saveButton.style.display="none";
}

else {
            ress.services_provding.filter((service) => {
                appendToList(service.category, service);
            });
        }
        
        const selectedValue = null;

        function appendToList(category, data) {
            let element;
            switch (category) {
                case "Hairstyle":
                    element = document.querySelector(".hairstyle");
                    break;
                case "sareedrapping":
                    element = document.querySelector(".saree_drapping");
                    break;
                case "Mehandi":
                    element = document.querySelector(".mehandi");
                    break;
                case "Makeup":
                    element = document.querySelector(".makeup_types");
                    break;
                default:
                    console.error(`Invalid category: ${category}`);
                    return;
            }

            if (!data || !data.name || !data.cost) {
                console.error(`Invalid data for category ${category}`);
                return;
            }

            const newType = document.createElement("div");
            newType.classList.add("type_1", "types");
            newType.innerHTML = `
    <img src="${data.image}" class="makeuptypes_img">
    <p class="titlte_makeup">${data.name}</p>
    <p class="cost_makeup">Cost ₹ ${data.cost}</p>
    <button class="add_book_list" data-id="${data.category_id}" data-img="${data.image}" data-name="${data.name}" data-cost="${data.cost}">Add to booking list</button>
  `;

            element.querySelector(".types_head.cart").appendChild(newType);

            const button = newType.querySelector(".add_book_list");
            button.addEventListener("click", (e) => {
                const selectedValue = document.getElementById("name").value;
                if (!selectedValue) {
                    alert("Please select a customer.");
                    return;
                }
                const data = {
                    category_id: e.target.getAttribute("data-id"),
                    item_img: e.target.getAttribute("data-img"),
                    item_name: e.target.getAttribute("data-name"),
                    item_cost: e.target.getAttribute("data-cost"),
                    selected_value: selectedValue
                };

                const active_user = localStorage.getItem("profile");

                const ob = {
                    item_id: data.category_id,
                    item_img: data.item_img,
                    item_name: data.item_name,
                    item_cost: data.item_cost,
                    user: active_user,
                    name: ress.name,
                    selected_value: data.selected_value
                };

                const temporary_storage = JSON.parse(localStorage.getItem("temp_booking_data")) || [];

                // Check if item already exists in temporary storage
                const itemExists = temporary_storage.some(item => item.item_id === ob.item_id && item.user === ob.user && item.selected_value === ob.selected_value);
                if (itemExists) {
                    alert("This item has already been added to the booking list for this customer.");
                } else {
                    temporary_storage.push(ob);

                    localStorage.setItem("temp_booking_data", JSON.stringify(temporary_storage));
                    alert("Item added to booking list.");
                }
            });
        }

        const saveButton = document.querySelector(".save");

        saveButton.addEventListener("click", () => {
            const activeUser = localStorage.getItem("profile");
            const tempData = JSON.parse(localStorage.getItem("temp_booking_data"));
            const filteredData = tempData.filter((item) => item.user === activeUser);
            const savedData = JSON.parse(localStorage.getItem("saving_detail")) || [];
            savedData.push(...filteredData);

            localStorage.setItem("saving_detail", JSON.stringify(savedData));
            localStorage.setItem("temp_booking_data", JSON.stringify(tempData.filter((item) => item.user !== activeUser)));
            window.location.href = `../../pages/booking/book3.html?artist_name=${name}&date=${dateParam}`
        });