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
<Style>
h1 {
	text-align: center;
}

.danhsachmay {
	
}

.danhsachkh {
	
}

.danhsachdv {
	
}
</Style>
</head>
<body>
	<div class="container contaitong">
		<button class="btn btn-secondary  pb-3" id="all" >All
			Danh Sách</button>
		<button class="btn btn-secondary  pb-3" id="danhsachmay">Danh
			Sách Máy</button>
		<button class="btn btn-secondary  pb-3" id="danhsachkh">Danh
			Sách Khách Hàng</button>
		<button id="danhsachdv" class="btn btn-secondary  pb-3">Danh
			Sách Dịch Vụ</button>
		<a href="${pageContext.request.contextPath}/themmay"><button
				class="btn btn-secondary  pb-3">Thêm Máy Mới</button></a> <a
			href="${pageContext.request.contextPath}/themkhach"><button
				class="btn btn-secondary  pb-3">Thêm Khách Hàng Mới</button></a> <a
			href="${pageContext.request.contextPath}/themdichvu"><button
				class="btn btn-secondary  pb-3">Thêm Dịch Vụ</button></a>
		<div class="container danhsachmay">
			<h1>Danh Sách Máy</h1>
			<nav class="navbar navbar-light bg-light">
				<div class="container-fluid">
					<form class="d-flex"
						action="${pageContext.request.contextPath}/searchmaytram"
						method="get">
						<input class="form-control me-2" name="seach" type="search"
							placeholder="Search" aria-label="Search">
						<button class="btn btn-outline-success" type="submit">Search</button>
					</form>
				</div>
			</nav>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Vị Trí</th>
						<th scope="col">Trạng Thái</th>
						<th scope="col">Active</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listmay }" var="may">
						<tr>
							<td>${may.getMamay()}</td>
							<td>${may.getVitri()}</td>
							<td>${may.getTrangthai()}</td>
							<td>
						<!-- <a href="${pageContext.request.contextPath}/deletemaytram?mayid=${may.getMamay()}"> </a> -->	
							<button id="buttondelete"><i class="fa-solid fa-trash"
							onclick="deleteData(${may.getMamay()})"></i> </button> 
									 <a href=""><i class="fa-solid fa-pen-to-square"></i></a></td>
						</tr>

					</c:forEach>
				</tbody>
			</table>
			<nav aria-label="...">
				<ul class="pagination">
					<li class="page-item "><a class="page-link"
						href="${pageContext.request.contextPath}/mServices?page=100"
						tabindex="-1" aria-disabled="true">Previous</a></li>
					<li class="page-item "><a class="page-link"
						href="${pageContext.request.contextPath}/mServices?page=1">1</a></li>
					<li class="page-item "><a class="page-link"
						href="${pageContext.request.contextPath}/mServices?page=2">2</a></li>
					<li class="page-item"><a class="page-link"
						href="${pageContext.request.contextPath}/mServices?page=3">3</a></li>
					<li class="page-item"><a class="page-link"
						href="${pageContext.request.contextPath}/mServices?page=99">Next</a>
					</li>
				</ul>
			</nav>
		</div>
		<div class="container danhsachkh">
			<h1>Danh Sách Khách Hàng</h1>
			<nav class="navbar navbar-light bg-light">
				<div class="container-fluid">
					<form class="d-flex"
						action="${pageContext.request.contextPath}/seachkhach"
						method="get">
						<input class="form-control me-2" name="seach" type="search"
							placeholder="Search" aria-label="Search">
						<button class="btn btn-outline-success" type="submit">Search</button>
					</form>
				</div>
			</nav>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Tên Khách</th>
						<th scope="col">Địa Chỉ</th>
						<th scope="col">SĐT</th>
						<th scope="col">Email</th>
						<th scope="col">Active</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listkhach }" var="khach">
						<tr>
							<td>${khach.getMakh()}</td>
							<td>${khach.getTenKH()}</td>
							<td>${khach.getDiachi()}</td>
							<td>${khach.getPhone()}</td>
							<td>${khach.getEmail()}</td>
							<td><a href=""><i class="fa-solid fa-trash"></i></a> <a
								href=""><i class="fa-solid fa-pen-to-square"></i></a></td>
						</tr>

					</c:forEach>
				</tbody>
			</table>
			<nav aria-label="...">
				<ul class="pagination">
					<li class="page-item disabled"><a class="page-link" href="#"
						tabindex="-1" aria-disabled="true">Previous</a></li>
					<li class="page-item "><a class="page-link"
						href="${pageContext.request.contextPath}/khSevices?page=1">1</a></li>
					<li class="page-item "><a class="page-link"
						href="${pageContext.request.contextPath}/khSevices?page=2">2</a></li>
					<li class="page-item"><a class="page-link"
						href="${pageContext.request.contextPath}/khSevices?page=3">3</a></li>
					<li class="page-item"><a class="page-link" href="#">Next</a></li>
				</ul>
			</nav>
		</div>
		<div class="container danhsachdv">
			<h1>Danh Sách Dịch Vụ</h1>
			<nav class="navbar navbar-light bg-light">
				<div class="container-fluid">
					<form class="d-flex"
						action="${pageContext.request.contextPath}/seachdv" method="get">
						<input class="form-control me-2" type="search" name="seach"
							placeholder="Search" aria-label="Search">
						<button class="btn btn-outline-success" type="submit">Search</button>
					</form>
				</div>
			</nav>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Tên Dịch Vụ</th>
						<th scope="col">Đơn Vị Tính</th>
						<th scope="col">Giá Tiền</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listdv }" var="dv">
						<tr>
							<td>${dv.getMadv()}</td>
							<td>${dv.getTendv()}</td>
							<td>${dv.getSoluong()}</td>
							<td>${dv.getDongia()}</td>
							<td><a href=""><i class="fa-solid fa-trash"></i></a> <a
								href=""><i class="fa-solid fa-pen-to-square"></i></a></td>
						</tr>

					</c:forEach>
				</tbody>
			</table>
			<nav aria-label="...">
				<ul class="pagination">
					<li class="page-item disabled"><a class="page-link" href="#"
						tabindex="-1" aria-disabled="true">Previous</a></li>
					<li class="page-item active"><a class="page-link"
						href="${pageContext.request.contextPath}//dvSevices?page=1">1</a></li>
					<li class="page-item " aria-current="page"><a
						class="page-link"
						href="${pageContext.request.contextPath}//dvSevices?page=2">2</a></li>
					<li class="page-item"><a class="page-link"
						href="${pageContext.request.contextPath}//dvSevices?page=3">3</a></li>
					<li class="page-item"><a class="page-link" href="#">Next</a></li>
				</ul>
			</nav>
		</div>
	</div>
	<script src="${pageContext.request.contextPath}/static/qlphongmay.js"></script>
</body>

</html>
