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
		<h1>Thêm Máy Mới</h1>
		<form action="mServices" class="form-control " method="post">
			<label for="vitri" class="form-check-label">Vị Trí Máy</label>
			<div class="input-group pb-3">

				<span class="input-group-text" id="addon-wrapping"><i
					class="fa-solid fa-lock"></i></span> <input type="text" name="vitri"
					name="vitri" class="form-control" placeholder="Vị Trí Máy"
					aria-label="Username" aria-describedby="addon-wrapping">
			</div>
			<label for="trangthai" class="form-check-label">Trạng Thái </label>
			<div class="input-group  pb-3">
				<span class="input-group-text" id="addon-wrapping"><i
					class="fa-solid fa-user"></i></span> <input type="text" name="trangthai"
					id="trangthai" class="form-control" placeholder="Trạng Thái"
					aria-label="Username" aria-describedby="addon-wrapping">
			</div>
			<button class="btn btn-secondary form-control pb-3">Thêm Mới</button>
	</div>
</body>
</html>