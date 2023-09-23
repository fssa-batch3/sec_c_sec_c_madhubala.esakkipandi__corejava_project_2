


	<div class="sidebar" id="side-bar">
<a href="<%=request.getContextPath() %>/getSuccesFullBookingByArtistID">
        <div class="Appoinment-records" id="option1">
            <div class="border">
                <img src="../assets/images/writing.png" class="icon-appointment">
            </div>
            <h6>Appointment Records</h6>
        </div>
    </a>
    <a href="./schedule.jsp">
        <div class="Schedules-record" id="option2">
            <div class="border">
                <img src="../assets/images/schedule.png" class="icon-appointment">
            </div>
            <h6>Schedules</h6>
        </div>
    </a>
		
		<a href="<%=request.getContextPath()%>/UpdateArtistServlet">


			<div class="Personal-details" id="option3">

				<div class="border">
					<img src=".././assets/images/user.png" class="icon-appoinmnet">
				</div>
				<h6>Personal Details</h6>
			</div>
		</a>
		 <a href="<%=request.getContextPath()%>/getRequestServlet">
		

			<div class="Notification-record" id="option4">

				<div class="border">
					<img src="../assets/images/bell.png" class="icon-appoinmnet">
				</div>
				<h6>Notifications</h6>

			</div>
		</a> <a href="<%=request.getContextPath() %>/Remainder.jsp">

			<div class="Remainder" id="option5">
				<div class="border">
					<img src="../assets/images/contract.png" class="icon-appoinmnet">
				</div>
				<h6>Remainder</h6>
			</div>
		</a> <a href="UploadedWorks.jsp">

			<div class="Yourworks" id="option6">
				<div class="border">
					<img src="../assets/images/makeup-artist.png"
						class="icon-appoinmnet">
				</div>
				<h6>Your works</h6>
			</div>
		</a>

	</div>
