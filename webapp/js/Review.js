/**
 * 
 */
const reviewarr=[]
document.getElementById("reviewform").addEventListener("submit",e=>

{
    const userName = document.getElementById("user_name").value
            const customerReview = document.getElementById("user_revi").value
            if(userName!=""&&customerReview!=""){

          const reviews = JSON.parse(localStorage.getItem("reviews")) ? JSON.parse(localStorage.getItem("reviews")) : reviewarr;

  const user_review={

   "name":userName,
   customerReview

  }

  reviews.push(user_review)
  localStorage.setItem("reviews", JSON.stringify(reviews));

            }

}
)

let reviewofuser=JSON.parse(localStorage.getItem("reviews"))

for(const i of reviewofuser){

    const nameOfUsers = i.name;
    const customersReview = i.customerReview;
        
    reviewofuser+=
    `<div class="reviewed-box">
                <div class="content-inside">
                    <div class="top-review-text">
                        <i class="fa-solid fa-user"></i>
                    </div>
                    <div class="name">
                        <h3>${nameOfUsers}</h3>
                    </div>
                </div>
                <hr>
                <div class="star-icon">
                    <div class="star-2">
                        <i id="star" class="fa-solid fa-star"></i>
                        <i id="star" class="fa-solid fa-star"></i>
                        <i id="star" class="fa-solid fa-star"></i>
                        <i id="star" class="fa-solid fa-star"></i>
                        <i id="star" class="fa-solid fa-star"></i>
                    </div>
                    <p> 20 day ago</p>
                </div>
                <div class="text">

                    <p> ${customersReview}</p>
                    <p> <strong>
                            Date of experience:</strong> 04 December 2022</p>
                </div>
                <hr>
                </div>`

            }

const div = document.getElementById("review-content");
 div.innerHTML += reviewofuser;
 
console.log(reviewofuser);