<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.fssa.glossyblends.model.Service"%>

<%@ page import="java.util.List"%>
<link rel="stylesheet" type="text/css" href="./assets/css/Payment.css">

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="../../assets/css/book4.css">
<title>Document</title>
</head>
<body>
	<div class="content">
		<div class="payment_method">
			<h2>Select payment method</h2>
			<div class="options">

					<label> <input type="radio" name="paymentMethod"
						value="creditCard" style="width: 10px; height: 10px; color: pink;"
						required> Credit card
					</label> <label> <input type="radio" name="paymentMethod"
						value="paypal" style="width: 10px; height: 10px; color: pink;"
						required> Paypal
					</label> <label> <input type="radio" name="paymentMethod"
						value="qr" style="width: 10px; height: 10px; color: pink;"
						required> Qr
					</label> <label> <input type="radio" name="paymentMethod"
						value="others" style="width: 10px; height: 10px; color: pink;"
						required> Others
					</label>
			</div>

			<p class="heading_options">Pay using credit cards</p>
			<div class="images">
				<img src="././assets/images/payement/visa.png" class="Image_payment">
				<img src="././assets/images/payement/Mastercard_logo.0.jpg"
					class="Image_payment"> <img
					src="././assets/images/payement/stripe.png" class="Image_payment">
			</div>
			<p class="credit_card">Credit cards</p>
			<br>
			<div class="cvv">
				<div class="expiry">


					<label for="expiry_num">Expiration date</label><br> <input
						type="number" id="expiry_num" required>
				</div>
				<div class="cvv_number">
					<label for="cvv_num">CVV</label><br> <input type="number"
						id="cvv_num" required>
				</div>
				<%
				int id = (Integer) request.getAttribute("bookingId");
				%>
				
				
			
			</div>
			<a href="UpdatePaymentStatus?bookingId=<%=id%>">
				<button type="submit" class="paymentButton"
					style="width: 140px; height: 45px; font-family: 'Roboto', sans-serif; font-size: 11px; text-transform: uppercase; letter-spacing: 2.5px; font-weight: 500; color: white; background-color: #fff; border: none; border-radius: 45px; transition: all 0.3s ease 0s; cursor: pointer; background-color: #e6397e; box-shadow: 0px 15px 20px rgba(218, 66, 107, 0.4); outline: none;">
					Proceed to pay</button>
			</a>

		
		</div>


		<div class="booking_list">
			<h1>Total booking</h1>
			<%
			List<Service> services = (List<Service>) request.getAttribute("ServiceSelected");
			double totalCost = 0; // Initialize the total cost

			for (Service ser : services) {
				double cost=ser.getCost();
				totalCost += cost;
			%>
			<div class="savinglist">

				<div class="totalbooking">
					<div class="customer_1">
						<div class="names_total_cost">
							<div class="one">
								<p><%=ser.getName()%></p>
								<p><%=ser.getCost()%></p>
								<img src="<%=ser.getSampleImage()%>" class="image">
							</div>
						</div>
						<hr>
					</div>
				</div>
			</div>
			<%
			}
			%>


			<p class="total_cost">
				Total Cost: ₹
				<%=totalCost%></p>

		</div>
	</div>
	

	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script>
<%String errorMsg = (String) request.getAttribute("error");
String successMsg = (String) request.getAttribute("success");
System.out.println(successMsg + " Succesmsg ----  errormsg " + errorMsg + "path :" );
if (errorMsg != null) {%>
		
		<%System.out.print(errorMsg + "inside");%>
		swal("Failed!","<%=errorMsg%>", "error");
		setTimeout(() => {
			console.log("df");
			window.location.href="UpdatePaymentStatus";
		}, 4000);
		
	<%}%>
		
		<%if (successMsg != null) {%>
		console.log("<%=successMsg%>");
		<%System.out.print(successMsg + "inside");%>
		swal("Success!"," <%=successMsg%>", "success");
		setTimeout(() => {
			console.log("df");
			window.location.href="Home.jsp";
		}, 4000);
		<%}%>
</script>
	
	
</body>
</html>
