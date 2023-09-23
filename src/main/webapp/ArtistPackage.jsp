<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.fssa.glossyblends.model.*"%>
<%@ page import="java.util.List"%>
<link rel="stylesheet" type="text/css"
	href="././assets/css/Artistpackage.css">

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="./package_artist.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
	integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
	crossorigin="anonymous" referrerpolicy="no-referrer">
</head>

<body>

	<div class="container" id="container">

		<div class="menu-bar">
			<img src="https://iili.io/J972xwu.png" alt="logo">
			<ul class="main">
				<li><a href="Home.jsp">Home</a></li>



				<li><a href="Artistupload.jsp">Upload works</a></li>

				<li><a href="LogoutServlet">Logout</a></li>
				<a
					href="<%=request.getContextPath()%>/getSuccesFullBookingByArtistID">

					<img src="././assets/images/IMG20200903161128.jpg"
					class="my-profile-img">
				</a>

			</ul>
		</div>

		<div class="content">

			<div class="adding_list">

				<div class="para">
					<h1>Fill Your avliabale services</h1>
					<p>The Lorem ipum filling text is used by graphic designers,
						programmers and printers with the aim of occupying the spaces of a
						website, an advertising product or an editorial production whose
						final text is not yet ready.</p>
					<button class="add_btn" id="btn_add">Add services</button>
					<!-- <button class="edit" id="edit_btn">Edit service</button> -->

				</div>
				<div class="img">
					<img src="./assets/images/6551297.jpg" class="images_title">
				</div>

			</div>
			<div class="steps">

				<h1 class="head_steps">Here the steps to add your services</h1>
				<br>
				<div class="Whole_steps">


					<div class="step_desing">
						<p class="step_para">click the Add button</p>
					</div>
					<div class="step_desing">
						<p class="step_para">Fill the name feild</p>
					</div>
					<div class="step_desing">
						<p class="step_para">select the category</p>
					</div>
					<div class="step_desing">
						<p class="step_para">And your sample image</p>
					</div>
					<div class="step_desing">
						<p class="step_para">Finally submit the felid</p>

					</div>

				</div>
			</div>

		</div>
	</div>

	<div class="form" id="fomr_service">

		<form id="listing" action="AddService" method="post">


			<i class="fa-regular fa-circle-xmark"></i>

			<h3 class="category">choose the category</h3>

			<input type="radio" placeholder="Hair style" name="category"
				value="HAIR_STYLE"> <label>Hair style</label> <input
				type="radio" class="saree" placeholder="saree drapping"
				name="category" value="SAREE_DRAPPING"> <label>saree
				drapping</label> <br> <input type="radio" placeholder="Makeup"
				name="category" value="MAKEUP"> <label>Makeup </label> <input
				type="radio" class="Mehandi" placeholder="Mehandi" name="category"
				value="MEHANDI"> <label>Mehandi</label> <br> <label
				class="name"> Name of category:</label> <input type="text"
				class="name_of_cetegory category_name" id="name_of_cetegory"
				name="nameOfCategory"> <br> <label class="cost">Cost:</label>
			<input type="number" class="number_of_cetegory category_name"
				id="number_for_cetegory" name="cost"> <br> <label
				class="image">Sample Image</label> <input type="url"
				class="url_of_cetegory category_name" id="url_of_cetegory"
				name="url"> <br>

			<button type="submit" class="submit_btn">Submit</button>



		</form>

	</div>

	<div class="artist_pack">
		<h1>Here are your available services</h1>
		<div class="package_div" id="pack">
			<%
			List<Service> services = (List<Service>) request.getAttribute("services");
			if (services != null) {
				for (Service service : services) {
			%>
			<div class="card">
				<img src="<%=service.getSampleImage()%>" class="pic">
				<p class="name_service"><%=service.getName()%></p>
				<p class="cost_service">
					Cost: Rs:<%=service.getCost()%></p>

				<button onclick="showEditDeleteForm(this)"
					data-service-name="<%=service.getName()%>"
					data-service-cost="<%=service.getCost()%>"
					data-service-image="<%=service.getSampleImage()%>"
					data-service-id="<%=service.getId()%>">Edit</button>

				<a
					href="<%=request.getContextPath()%>/DeleteService?serviceId=<%=service.getId()%>&artistId=<%=service.getArtistId()%>">
					<button>Delete</button>
				</a>


			</div>
			<%
			}
			}
			%>
		</div>
	</div>


	<div class="edit_delete">

		<h4>Edit your service image and cost</h4>






		<form id="edit_delete_form" action="UpdateService" method="post">

			<input type="hidden" class="service-id" name="serviceId">
			<!-- Hidden input field for service ID -->

			<p class="show_name">Nayanthara Hairstyle</p>

			<label>Cost</label> <input type="number" class="cost_edit"
				name="cost"> <br> <br> <label>Image</label> <input
				type="url" class="image_edit" name="image"> <br>

			<button type="submit" id="edit_button">Edit</button>
			<br>

		</form>


	</div>







	<script>

const addBtn = document.getElementById('btn_add');
const formService = document.getElementById('fomr_service');
const container = document.getElementById('container');

addBtn.addEventListener('click', () => {
  formService.style.display = 'block';
  container.classList.toggle('blur');
});










        
let close_button=document.querySelector(".fa-circle-xmark");

close_button.addEventListener('click',e=>{
    location.reload()
})










 




 </script>
	<script>
    // Function to show/hide the edit/delete form
   function showEditDeleteForm(button) {
    const editDeleteForm = document.querySelector('.edit_delete');
    editDeleteForm.style.display = 'block'; // Display the form
    
    // Retrieve service information and service ID from data attributes
    const serviceName = button.getAttribute('data-service-name');
    const serviceCost = button.getAttribute('data-service-cost');
    const serviceImage = button.getAttribute('data-service-image');
    const serviceId = button.getAttribute('data-service-id');

    // Populate the edit/delete form fields with the service information
    const serviceNameField = document.querySelector('.show_name');
    const costEditField = document.querySelector('.cost_edit');
    const imageEditField = document.querySelector('.image_edit');
    const serviceIdField = document.querySelector('.service-id'); // Hidden input field for service ID

    serviceNameField.textContent = serviceName;
    costEditField.value = serviceCost;
    imageEditField.value = serviceImage;
    serviceIdField.value = serviceId; // Set the service ID value in the hidden field
}
    

</script>

	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

	<script>
<%String error = (String) request.getAttribute("er");
String success = (String) request.getAttribute("suc");
String paths = (String) request.getAttribute("paths");
if (error != null) {%>
		
		<%System.out.print(error + "inside");%>
		swal("Failed!","<%=error%>", "error");
		setTimeout(() => {
			console.log("df");
			window.location.href="<%=paths%>";
		}, 4000);
		
	<%}%>
		
		<%if (success != null) {%>
		console.log("<%=success%>");
		<%System.out.print(success + "inside");%>
		swal("Success!"," <%=success%>", "success");
		setTimeout(() => {
			console.log("df");
			window.location.href="<%=paths%>";
		}, 4000);
		<%}%>
</script>



	<script>
  <%String erroraddservice = (String) request.getAttribute("errorMessages");
String successaddservice = (String) request.getAttribute("successMessages");
if (erroraddservice != null) {%>
  		
  		<%System.out.print(erroraddservice + "inside");%>
  		swal("Failed!","<%=erroraddservice%>", "error");
  		setTimeout(() => {
  			console.log("df");
  			window.location.href="ListService";
  		}, 4000);
  		
  	<%}%>
  		
  		<%if (successaddservice != null) {%>
  		console.log("<%=successaddservice%>");
  		<%System.out.print(successaddservice + "inside");%>
  		swal("Success!"," <%=successaddservice%>", "success");
  		setTimeout(() => {
  			console.log("df");
  			window.location.href="ListService";
  		}, 4000);
  		<%}%>
  </script>





</body>

</html>