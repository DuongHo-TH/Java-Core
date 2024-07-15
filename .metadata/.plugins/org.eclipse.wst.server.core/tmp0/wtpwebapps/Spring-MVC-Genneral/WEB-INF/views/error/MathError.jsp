<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
<link
	href="<c:url value='/resources/bootstrap_5/css/bootstrap.min.css' />"
	rel="stylesheet">
<link
	href="<c:url value='/resources/fontawesome-free-6.5.2-web/css/all.min.css' />"
	rel="stylesheet">
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f9f9f9;
	margin: 0;
	padding: 0;
}

.header {
	background-color: #3498db;
	color: #ffffff;
	text-align: center;
	padding: 20px;
	border-radius: 35px;
}

.footer {
	background-color: #34495e;
	color: #ffffff;
	text-align: center;
	padding: 10px;
	border-radius: 35px;
	margin-top:190px
}

.content {
	max-width: 800px;
	margin: 0 auto;
	padding: 20px;
	background-color: #f9f9f9;
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
	h1 {color: red;
}
}
.minigame{ margin-left : 450px;
 .giaodien{
        position: relative;
       }
       .khunglong{
        position: absolute;
        bottom: 430px;
        left: 450px;
       }
       .chim1{
        position: absolute;
        left: 700px;
        bottom: 630px;
       }
       .chim2{
        position: absolute;
        left: 1100px;
        bottom: 610px;
       }
       .xuongrong1{
        position: absolute;
        bottom: 430px;
        left: 930px;
       }
       .xuongrong2{
        position: absolute;
         bottom: 430px;
        left: 650px;
       }
       .xuongrong3{
        position: absolute;
        bottom: 430px;
        left: 1300px;
       }
       .may1{
        position: absolute;
         bottom: 640px;
        left: 500px;
       }
       .may2{
        position: absolute;
         bottom: 640px;
        left: 1300px;
       }
       .may3{
       position: absolute;
        left: 1000px;
        bottom: 610px;
       }
       }
</style>
</head>
<body>
	<div class="header">
		<h1>AD Gaming Center</h1>
		<p>Chào mừng bạn đến với trang web AD Gaming</p>
	</div>
	<div class="content">
		<h1>Đã Sảy Ra Lỗi vui lòng thử lại</h1>
		<p>Xin lỗi, trang bạn đang tìm kiếm không tồn tại hoặc đã bị xóa.</p>
		<p>
			Vui lòng kiểm tra lại đường dẫn hoặc quay lại <a
				href="/Spring-MVC-Genneral/"><button type="button" class="btn btn-secondary">trang chủ</button></a>.
		</p>
	</div>
	
	<div class="minigame container">
	<div class="giaodien ">
		<img src="<c:url value='/resources/img/bg.png' />">
			<img src="<c:url value='/resources/img/bg.png' />">
		    </div>
		    <div class="khunglong">
		        <img src="<c:url value='/resources/img/t-rex2.png' />"></div>
		        <div class="chim1">
		        <img src="<c:url value='/resources/img/chim 1.png' />"></div>
		        <div class="chim2">
		            <img src="<c:url value='/resources/img/chim 2.png' />"></div>
		        <div class="xuongrong1">
		        <img src="<c:url value='/resources/img/xuong rong (1).png' />"></div>
		        <div class="xuongrong2">
		        <img src="<c:url value='/resources/img/xuong rong (4).png' />"></div>
		        <div class="xuongrong3">
		            <img src="<c:url value='/resources/img/xuong rong (2).png' />"></div>
		             <div class="may1">
		            <img src="<c:url value='/resources/img/cloud.png' />"></div>
		             <div class="may2">
		            <img src="<c:url value='/resources/img/cloud.png' />"></div>
		             <div class="may3">
		            <img src="<c:url value='/resources/img/cloud.png' />"></div>
		            
		            </div>
		            <div class="footer">
		<p>Bản quyền © 2024. AD Gaming Center.</p>
		<b>Thank you and Best Regards,</b> <br> 
<b>HO SY DUONG</b>​
 <p> +84 96977193            fsoft-academy.edu.vn; FsoftAcademy.DN@fsoft.com.vn   </p> 
	</div>
</body>
</html>
