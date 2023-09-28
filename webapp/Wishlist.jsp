<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="full-content">

		<jsp:include page="./Header.jsp"></jsp:include>

		<div class="main-content-user">
			<div class="header">
				<h3>Profile of the user</h3>
				<hr>
			</div>
			<div class="details">
				<jsp:include page="./Profile.jsp"></jsp:include>

          <div class="content-details5_user" id="cont_push_wishlist">
            <div class="div-of-whish" id="obj_artist">
      <div class="pic-wishlist">
        <img src="${obj.image}" class="pic-img-wish">
      </div>
      <div class="left-content-wishlist">
        <div class="details-artist-wish">
          <h3>${obj.title} Makeover artistry</h3>
        <p>Locality   : ${obj.locality}</p>
          
        </div>
        <i class="fa-solid fa-circle-xmark trash-icon" id="${obj.id_wishlist}"></i>
      </div>
    </div>
            </div>
            </div>
            </div>
            </div>
</body>
</html>