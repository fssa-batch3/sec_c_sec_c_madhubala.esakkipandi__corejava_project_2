/**
 * 
 */

 
   function login() {

            const usermail = document.getElementById("user").value
            const userpass = document.getElementById("pass").value
            let data = JSON.parse(localStorage.getItem("data"));

            console.log(data)
            // let login = {

            //     "email": usermail,
            //     "userofpassword": userpass

            // }

            let res;
            data.find(  // parameterized function 'a'
                element => {
                    if (element["user_email"] == usermail && element["user_password"] == userpass) { //data=[{0},{1}] //a=data[0],a=data[1]

                        return res = 1;

                    }
                    else {

                        return res = 0;
                    }
                }

            );

            if (res == 1) {
                alert("logged in")
                let mail_of_user=usermail
                localStorage.setItem("profile",mail_of_user )
                window.location.href = "../profile_of_user.html"
            }
            else {
                alert("none")
            }
        }

        function showPasswordWhenChecked() {
            let showPassword = document.getElementById("pass");

            if (showPassword.type === "pass") {
                showPassword.type = "text";
            } else {
                showPassword.type = "pass";
            }
            
        }

        // --------------------------------------------------------------------artist login 
       
        function artistlogin(e) {

 let artist_data=JSON.parse(localStorage.getItem("card_data"))
const usermail = document.getElementById("user").value
const userpass = document.getElementById("pass").value

let result;
let artist_email;
artist_data.find(  // parameterized function 'a'
    e => {
        if(e["user_email"] == usermail && e["artist_password"] == userpass) { //data=[{0},{1}] //a=data[0],a=data[1]

            artist_email = e["user_email"];
            return result = 1;
        }
        else {

            return result = 0;
        }
    }

);

if (result == 1) {
    alert("logged in")

    
    localStorage.setItem("artist_profile",artist_email)
    window.location.href = "../profileartist.html"
    
}
else {
    alert("none")
}
}

function showPasswordWhenChecked() {
let showPassword = document.getElementById("pass");

if (showPassword.type === "pass") {
    showPassword.type = "text";
} else {
    showPassword.type = "pass";
    
}

}