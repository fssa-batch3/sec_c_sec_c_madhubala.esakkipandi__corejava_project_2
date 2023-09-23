<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <link rel="stylesheet" type="text/css"
	href="./../assets/css/ArtistProfile.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="full-content">
		<jsp:include page="HeaderArtist.jsp"></jsp:include>


		<div class="main-content">
			<div class="header">
				<h3>Profile of the artist</h3>
				<hr>
			</div>
			<div class="details">
				<jsp:include page="Profile.jsp"></jsp:include>
<div class="list-of-details6" id="option6Content">

					<h3>Your posts</h3>
					<hr>
					<div class="photo_vedios">
						<h3 id="optionpic" class="pho">Photos</h3>
						<h3 id="optiontvedio" class="ve">videos</h3>

					</div>
					<div class="photos" id="post1Content">
						<div class="content" id="content">
							<div class="pic">
								<div class="pic_container">
									<img src="../assets/images/ellipsis.png" class="elispse">
									<div class="dropdown-content">
										<a href="#">Delete</a>
									</div>
								</div>

								<img src="../assets/images/2c6d92956320f7e479f9833ca579ffd2.jpg"
									class="pic_post">
							</div>

							<div class="pic">

								<img src="../assets/images/ellipsis.png" class="elispse">

								<img src="../assets/images/2c6d92956320f7e479f9833ca579ffd2.jpg"
									class="pic_post">
							</div>
							<div class="pic">
								<img src="../assets/images/ellipsis.png" class="elispse">
								<img src="../assets/images/2c6d92956320f7e479f9833ca579ffd2.jpg"
									class="pic_post">
							</div>
							<div class="pic">
								<img src="../assets/images/ellipsis.png" class="elispse">
								<img src="../assets/images/2c6d92956320f7e479f9833ca579ffd2.jpg"
									class="pic_post">
							</div>

						</div>
					</div>

					<div class="vedios" id="post2Content">
						<div class="content-vedo">
							<div class="vedio">
								<img src="../assets/images/ellipsis.png" class="elispse">
								<img src="../assets/images/2c6d92956320f7e479f9833ca579ffd2.jpg"
									class="pic_post">
							</div>

							<div class="vedio">
								<img src="../assets/images/ellipsis.png" class="elispse">
								<img src="../assets/images/2c6d92956320f7e479f9833ca579ffd2.jpg"
									class="pic_post">
							</div>
							<div class="vedio">
								<img src="../assets/images/ellipsis.png" class="elispse">
								<img src="../assets/images/2c6d92956320f7e479f9833ca579ffd2.jpg"
									class="pic_post">
							</div>

						</div>
					</div>

				</div>
				</div>
				</div>
				</div>
</body>
</html>