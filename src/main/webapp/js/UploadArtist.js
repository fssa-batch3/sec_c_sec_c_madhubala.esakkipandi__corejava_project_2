/**
 * 
 */

   const dataofartist = JSON.parse(localStorage.getItem("card_data"))
        document.getElementById("upload_form").addEventListener('submit', e => {

            e.preventDefault();

            const title = document.getElementById("title").value
            const textarea = document.getElementById("textarea").value
            const user_upload_name = document.getElementById("name").value
            // const tel=document.getElementById("num").value
            const img_url = document.getElementById("imgurl").value
            const uploaddetail = JSON.parse(localStorage.getItem("upload_details"));

            const active_user = localStorage.getItem("artist_profile")

            const upload_details = JSON.parse(localStorage.getItem("upload_details")) ? JSON.parse(localStorage.getItem("upload_details")) : [];
            const upload_detail = {}

            upload_detail.title = title;
            upload_detail.textarea = textarea;
            upload_detail.uploadname = user_upload_name;
            upload_detail.imgurl = img_url;
            // upload_detail["mobilenumber"]= tel,
            upload_detail.uploader_emial = active_user
            upload_detail.id = length
            upload_details.push(upload_detail);
            localStorage.setItem("upload_details", JSON.stringify(upload_details));

            const user = dataofartist.find(obj => obj.user_email === active_user);

            user.upload = upload_details.filter(element => element.uploader_emial === active_user);
            localStorage.setItem("card_data", JSON.stringify(dataofartist));
alert("work uploaded ")
            location.reload()

        })


        let maindiv=document.getElementById("div_main")
            let wave=document.getElementById("waves")
            let show=document.getElementById("buton_click")

   let form_filled_form=document.getElementById("upload_form")

       
        
            show.addEventListener('click', () => {
                form_filled_form.style.display = 'block';
                maindiv.classList.toggle('blur');
                wave.classList.toggle('blur')
});

     