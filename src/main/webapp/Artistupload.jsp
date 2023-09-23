<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" href="././assets/css/Artistupload.css">

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
</head>

<body>

	<div class="menu-bar">
		<img src="././assets/images/Screenshot__63_-removebg-preview.png"
			alt="logo">
		<ul class="main">
			<li><a href="Home.jsp">Home</a></li>

			<li><a href="ListService">YOUR PACKAGE PLANS</a></li>

			<li><a href="LogoutServlet">Logout</a></li>
			</li>
			<a
				href="<%=request.getContextPath()%>/getSuccesFullBookingByArtistID">

				<img src="././assets/images/IMG20200903161128.jpg"
				class="my-profile-img">
			</a>
		</ul>
	</div>
	<div class="main_div" id="div_main">
		<div class="right">
			<div class="cont_right">
				<h1>Upload Your extraordinary works</h1>
				<p>Showcase your skils</p>
				<div class="wrap">
					<button class="button" id=buton_click>Upload</button>
				</div>
			</div>
			<div class="shape5"></div>
			<div class="shape2"></div>
			<div class="shape3"></div>
			<div class="shape4"></div>
		</div>
		<div class="left">
			<!-- <img src="/assets/images/wepik-export-20230428191433.png"> -->
			<img src="./assets/images/developers-4.png">

		</div>

	</div>
	<div class="wave" id="waves">
		<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1440 320">
            <path fill="#f5bed4" fill-opacity="0.7"
				d="M0,256L120,218.7C240,181,480,107,720,96C960,85,1200,139,1320,165.3L1440,192L1440,320L1320,320C1200,320,960,320,720,320C480,320,240,320,120,320L0,320Z">
            </path>

        </svg>

		<div class="steps">
			<p>Step 1: choose your file</p>
			<p>Step 2: Give a title</p>
			<p>Step 3: upload</p>
		</div>
	</div>


	<
	<form id="upload_form" action="<%=request.getContextPath()%>/AddPost"
		method="post">
		<label for="text" id="tit"> Add a title</label> <br> <input
			id="title" type="text" placeholder="Add a caption" name="title">
		<label for="text" id="tit"> Add a caption</label> <br> <input
			id="textarea" type="textarea" placeholder="Add a description"
			name="description"> <label for="img-url" id="url">Image
			URL</label> <br> <input type="url" id="imgurl" pattern="https?://.+"
			title="Include http://" name="url">
		<button type="submit" class="button btn">Upload</button>
	</form>



	<script>
  

        let maindiv=document.getElementById("div_main")
            let wave=document.getElementById("waves")
            let show=document.getElementById("buton_click")

   let form_filled_form=document.getElementById("upload_form")

       
        
            show.addEventListener('click', () => {
                form_filled_form.style.display = 'block';
                maindiv.classList.toggle('blur');
                wave.classList.toggle('blur')
});

     
    </script>

	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script>
<%String errorMsg = (String) request.getAttribute("errorMsg");
String successMsg = (String) request.getAttribute("successMsg");
String path = (String) request.getAttribute("path");
System.out.println(successMsg + " Succesmsg ----  errormsg " + errorMsg + "path :" + path);
if (errorMsg != null) {%>
		
		<%System.out.print(errorMsg + "inside");%>
		swal("Failed!","<%=errorMsg%>", "error");
		setTimeout(() => {
			console.log("df");
			window.location.href="<%=path%>";
		}, 4000);
		
	<%}%>
		
		<%if (successMsg != null) {%>
		console.log("<%=successMsg%>");
		<%System.out.print(successMsg + "inside");%>
		swal("Success!"," <%=successMsg%>", "success");
		setTimeout(() => {
			console.log("df");
			window.location.href="<%=path%>";
		}, 4000);
		<%}%>
</script>

</body>

</html>