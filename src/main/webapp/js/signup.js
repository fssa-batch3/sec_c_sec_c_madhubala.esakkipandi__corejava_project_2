/**
 * 
 */

   const register_form = document.getElementById("form");
        register_form.addEventListener('submit', e => {
            e.preventDefault();
            const name = document.getElementById("name").value
            const email = document.getElementById("email").value
            // const username = document.getElementById("username").value
            const password = document.getElementById("password").value
            const repeat = document.getElementById("repeat").value
            const booking_records = [];
            const user_records = JSON.parse(localStorage.getItem("data"));
            if ((name.trim() != "") && (email.trim() != "") && (password.trim() != "") && (repeat.trim() != "")) {
                const data = JSON.parse(localStorage.getItem("data")) ? JSON.parse(localStorage.getItem("data")):[];

                const user_data = {
            "user_name": name,
            "user_email": email,
            // "name_user": username,
            "user_password": password,
            "repeat_pass": repeat,
            "booking_records":booking_records

        }
                let success = true;
                if (user_records != null) {
                    for (let i = 0; i < user_records.length; i++) {
                        if (user_records[i].user_email==email) {
                            success = false;
                            break;
                        }
                    }
                }
                if (success) {
                    if (password == repeat) {

                        data.push(user_data);
                        localStorage.setItem("data", JSON.stringify(data));
                        alert("Account create successfully");
                        window.location.href = "../Login/login.html"
                    }
                    else {
                        alert("password mismatch")
                    }
                }
                else {
                    alert("Already Have a account");
                }
            }
            else {
                alert("fill this data")
            }
        });