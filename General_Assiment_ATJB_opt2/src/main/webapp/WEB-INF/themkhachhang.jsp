<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/bootstrap_5/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/fontawesome-free-6.5.2-web/css/all.min.css">
</head>
<body>
	<div class="container w-25">
		<h1>Thêm Khách Hàng</h1>
		<form action="khSevices" class="form-control " method="post">
			<label for="tenkhach" class="form-check-label">Tên Khách
				Hàng</label>
			<div class="input-group  pb-3">
				<span class="input-group-text" id="addon-wrapping"><i
					class="fa-solid fa-user"></i></span> <input type="text" id="tenkhach" name="tenkhach"
					class="form-control" placeholder="Tên Khách Hàng"
					aria-label="Username" aria-describedby="addon-wrapping">
			</div>
			<label for="diachi" class="form-check-label">Địa Chỉ</label>
			<div class="input-group pb-3">
				<span class="input-group-text" id="addon-wrapping"><i
					class="fa-solid fa-lock"></i></span> <input type="text" id="diachi" name="diachi"
					class="form-control" placeholder="Địa Chỉ" aria-label="Username"
					aria-describedby="addon-wrapping">
			</div>
			<label for="sdt" class="form-check-label">Số ĐT</label>
			<div class="input-group pb-3">
				<span class="input-group-text" id="addon-wrapping"><i
					class="fa-solid fa-lock"></i></span> <input type="text" id="sdt" name = "sdt"
					class="form-control" placeholder="Số Điện Thoại"
					aria-label="Username" aria-describedby="addon-wrapping">
			</div>
			<label for="email" class="form-check-label">Email</label>
			<div class="input-group pb-3">
				<span class="input-group-text" id="addon-wrapping"><i
					class="fa-solid fa-lock"></i></span> <input type="text" id="vitri" name ="email"
					class="form-control" placeholder="Email" aria-label="Username"
					aria-describedby="addon-wrapping">
			</div>

			<button class="btn btn-secondary form-control pb-3">Thêm Mới</button>
	</div>
</body>
</html>