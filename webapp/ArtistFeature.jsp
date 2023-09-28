<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" type="text/css"
	href="././assets/css/ArtistFeature.css">

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href=".././assets/css/ArtistFeature.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
	integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
	crossorigin="anonymous" referrerpolicy="no-referrer">
<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
</head>
<body>
	<div class="menu-bar">
		<img src="https://iili.io/J972xwu.png" alt="logo">
		<ul class="main">
			<li class="dropdown"><a href="index.jsp"> Home <i
					class="fas fa-caret-down"></i>
			</a></li>

			<li><a href="../booking/start_booking.html">Book here</a></li>
			<%
			Boolean loggedIn = (Boolean) session.getAttribute("loggedInSuccess");

			if (loggedIn != null && loggedIn != false) {
			%>
			<li id="profile-btn"><a
				href="<%=request.getContextPath()%>/GetPendingListBooking"><img
					src="././assets/images/IMG20200903161128.jpg"
					class="my-profile-img"></a></li>
			<%
			} else {
			%>
			<li id="login-btn"><a href="Login.jsp"><i
					class="fa-solid fa-user"></i> Login</a></li>
			<%
			}
			%>




		</ul>
	</div>
	<!-- nav bar ends -->


	<div class="upper-form">
		<div class="formm">


			<h3 class="head_start_booking">Choose your place and date of the
				event</h3>
			<!-- <input type="email" id="name" class="date" placeholder="name"> -->
			<!-- <input type="text" id="address" class="date" placeholder="address"> -->


			<form action="getArtistServlet" method="get">
				<input type="date" id="date" class="date" name="date" required>
				<select id="place" class="date" name="city" required>
					<option value="" disabled selected>Choose a city</option>
					<option value="chennai" name="city">Chennai</option>
					<option value="Trichy" name="city">Trichy</option>
					<option value="Tirunelveli" name="city">Tirunelveli</option>
					<option value="namakal" name="city">Namakal</option>
					<option id="city" value="Theni" required name="city">Theni</option>
					<option id="city" value="Madurai" required name="city">Madurai</option>
					<option id="city" value="ramnad" required name="city">Ramanathapuram</option>
					<option id="city" required name="city">Virudhunagar</option>
					<option id="city" required name="city">Dindugal</option>
					<option id="city" required name="city">Chengalpattu</option>
					<option id="city" required name="city">Salem</option>
					<option id="city" required name="city">Kdalur</option>
					<option id="city" required name="city">Nagapatinam</option>
				</select>

				<button type="submit" class="book_now">See Artists</button>
			</form>
		</div>
	</div>

	<div class="div-2">

		<h2>Why Choose Glossybelnds</h2>
		<h2>Get The Royal Treatment Fit For A Queen</h2>
		<div class="boxex">

			<div class="content-box">

				<img src="././assets/images/ribbon.png" class="icon">
				<h3>Top Notch Quality</h3>
				<p>No matter what your vision for your big day, leave it to us
					to bring them to life!</p>

			</div>

			<div class="content-box">
				<img src="././assets/images/Making up.png" class="icon">
				<h3>Personalised Makeup</h3>
				<p>Subtle, glamorous, minimalist or trendy – watch yourself
					transform as our stylists wave their magic wands</p>
			</div>

			<div class="content-box">

				<img src="../../assets/images/rating.png" class="icon">
				<h3>Experienced Stylists</h3>
				<p>Our professionals take care of everything, from makeup, saree
					& dhoti draping to hair styling and pre-bridal makeup services, to
					ensure you sparkle on your big day.</p>
			</div>

			<div class="content-box">

				<img src="././assets/images/family (1).png" class="icon">
				<h3>Include Your Friends and Family</h3>
				<p>Weddings are never just about the bride and groom! Give your
					friends and family their time in the spotlight with our exclusive
					packages for Friends of the Bride and Groom.</p>
			</div>
		</div>
	</div>
	<div class="div-3">

		<div class="rigth">

			<p>NATURALLY, YOU!</p>

			<h2 class="wed">
				Our Wedding Looks Bring All <br>Your Dreams To Life!
			</h2>
			<p>Indian weddings are larger than life! With the number of
				events involved, such as mehendi, cocktail, sangeet, haldi,
				muhurtham, and reception, it is natural for the bride and the groom
				to want the best of looks ranging from traditional to contemporary.
				We make all of your wedding dreams come true with our professional
				groom and bridal makeup services at Naturals.</p>
		</div>
		<div class="left">

			<img src="././assets/images/bridal-1.webp" class="bridal"> <img
				src="././assets/images/bridal-2.webp" class="bridal">
		</div>
	</div>
	<div class="div-4">

		<div class="inner-1">
			<div class="img">
				<img src="././assets/images/bridal-3.webp" class="plans">

			</div>
			<div class="head">
				<h3>Customised Bridal Makeup</h3>
				<p>Our celebrity artists create the bride and groom makeup looks
					depending on different face shapes and complexions to highlight
					their natural features and make them look stellar. With the help of
					professional equipment and techniques, our expert stylists create
					everything from classic, traditional looks to chic, modern looks
					for women and sharp, dapper looks for men.</p>
			</div>
		</div>
		<div class="inner-1">
			<div class="head">
				<h3>Hairstyles</h3>
				<p>Hairstyling is just as important as wedding day makeup. Our
					stylists work magic on your hair to create anything from trendy to
					traditional styles that perfectly complement your outfit and the
					occasion. Not just that, we customize accessories based on your
					outfit and makeup style to tie the whole look together. bridal
					hairstyle</p>
			</div>
			<div class="img">
				<img src="././assets/images/bridal-4.webp" class="plans">
			</div>
		</div>


		<div class="inner-1">
			<div class="img">
				<img src="././assets/images/images (11).jfif" class="plans">
			</div>
			<div class="head">
				<h3>Mehendi</h3>
				<p>Weddings are incomplete without Mehendi. Nowadays, it is more
					than just tradition. Brides and grooms can adorn their hands with
					beautiful visual stories or even abstract art by skilled artists.
					From minimal designs to extravagant artworks, the professional
					Mehendi artists at Naturals will help you achieve the look you want
					for your special day.</p>
			</div>
		</div>
		<div class="inner-1">
			<div class="head">
				<h3>Pre-Wedding Packages</h3>

				<p>We understand that wedding planning is a stressful process.
					That is why at Naturals, we offer pre-bridal packages that consist
					of hair, skin, and body spa services that will help ease the stress
					and bring out your inner glow. To get the best results, you can opt
					for our pre-bridal services 1-3 months before your big day. Bring
					your partner along and enjoy the benefits at discounted prices!</p>
			</div>
			<div class="img">
				<img src="././assets/images/pre-wedding.webp" class="plans">
			</div>
		</div>
	</div>
	<div class="evnt">
		<div class="eventright">

			<div class="iconboxex">
				<img src="././assets/images/baby-shower.png" class="down-icon">
				<p class="para">Baby shower</p>
			</div>

			<div class="iconboxex">
				<img src="././assets/images/drum-set (1).png" class="down-icon">
				<p class="para">Sangeeth</p>
			</div>
			<div class="iconboxex">
				<img src="././assets/images/dance.png" class="down-icon">
				<p class="para">Party</p>
			</div>
			<div class="iconboxex">
				<img src="././assets/images/wedding-couple.png" class="down-icon">
				<p class="para">Wedding</p>
			</div>
		</div>
		<div class="eventleft">

			<img src="././assets/images/3912425.jpg" class="vector">
		</div>

	</div>

	<div class="footer">
		<div class="footer-box">
			<div class="footer-content">
				<h3 class="footer-head">GLOSSY BLENDS</h3>
				<p class="footer-subhead">Contact us</p>
				<div class="footer-icons">
					<i id="insta-icon" class="fa-brands fa-instagram"></i> <i
						id="facebook-icon" class="fa-brands fa-facebook"></i> <i
						id="twiter-icon" class="fa-brands fa-square-twitter"></i> <i
						id="github-icon" class="fa-brands fa-github"></i>
				</div>
			</div>
			<div class="footer-content">
				<div class="links">
					<a href="index.html">
						<p>
							<i class="fa-solid fa-house"></i>HOME
						</p>
					</a> <br> <a href="#feature">
						<p>FEATURES</p>
					</a> <br> <a href="#feature">
						<p>APPOINTMENT</p>
					</a> <br> <a href="#feature">
						<p>MOBILE RESPONSIVE</p>
					</a> <br> <a href="#feature">
						<p>PAYMENT</p>
					</a> <br>
				</div>
			</div>
			<div class="footer-content">
				<a href="./pages/review/">
					<p>REVIEWS</p>
				</a> <a href="./pages/upload/">
					<p>FOR ARTIST</p>
				</a> <a href="./pages/booking/book.html">
					<p>BOOK HERE</p>
				</a> <a href="./pages/Login/login.html">
					<p>LOGIN</p>
				</a> <a href="./pages/signup/">
					<p>SIGN-UP</p>
				</a>
			</div>
			<div class="footer-content">
				<p>DOWNLOAD OUR APP ON:</p>
				<img src="./assets/images/doo.png" class="dooo" alt="app logo">
				<img src="./assets/images/download.png" class="downn" alt="app logo">
			</div>
		</div>

	</div>




	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script>
<%String errorMsg = (String) request.getAttribute("Succses"); // Change "Succses" to "Success" (assuming you want to use the "Success" attribute)

System.out.println("Success message: " + errorMsg + ", Path: ");

if (errorMsg != null) {%>
    console.log("<%=errorMsg%>");
    swal("Success!", "<%=errorMsg%>", "success");
    setTimeout(() => {
        console.log("df");
        window.location.href = "ArtistFeature.jsp";
    }, 4000);
<%}%>

		
		
		
<%String succesMsg = (String) request.getAttribute("SuccessLoggedIn"); // Change "Succses" to "Success" (assuming you want to use the "Success" attribute)

System.out.println("Success message: " + succesMsg + ", Path: ");

if (succesMsg != null) {%>
    console.log("<%=succesMsg%>");
    swal("Success!", "<%=succesMsg%>", "success");
    setTimeout(() => {
        console.log("df");
        window.location.href = "ArtistFeature.jsp";
    }, 4000);
<%}%>
		
		
		
</script>


	<script>
  const dateInput = document.getElementById('date');

  const currentDate = new Date().toISOString().split('T')[0];

  dateInput.min = currentDate;

  dateInput.addEventListener('input', function () {
    if (this.value < currentDate) {
      this.value = currentDate;
    }
  });
</script>






</body>
</html>