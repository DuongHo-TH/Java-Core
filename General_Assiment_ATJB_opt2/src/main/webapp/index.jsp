<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản Lý Máy Trạm</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/bootstrap_5/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/fontawesome-free-6.5.2-web/css/all.min.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/jquey.js"></script>
</head>
<body>
	<div class="container contaitong">
		<a href="${pageContext.request.contextPath}/themmay"><button class="btn btn-secondary  pb-3">Thêm Máy Mới</button></a> 
		<a href="${pageContext.request.contextPath}/themkhach"><button class="btn btn-secondary  pb-3">Thêm Khách Hàng Mới</button></a>
	    <a href="${pageContext.request.contextPath}/themdichvu"><button class="btn btn-secondary  pb-3">Thêm Dịch Vụ</button></a>
		<a href="${pageContext.request.contextPath}/showalldanhsach"><button class="btn btn-secondary  pb-3">All Danh Sách</button></a> 
		 <a href="http://"><button class="btn btn-secondary  pb-3">Đăng Ký Sử Dụng Máy</button></a> 
         <a href="http://"><button class="btn btn-secondary  pb-3">Đăng Ký Sử Dụng Dịch Vụ</button></a> 
		</div>
	
</body>
</html>
