<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<body>


	<h1>Danh Sách Khách Hàng Sử Dụng Máy Và Dịch Vụ</h1>
	<nav class="navbar navbar-light bg-light">
		<div class="container-fluid">
			<form class="d-flex"
				action="${pageContext.request.contextPath}/searchtrangchu" method="GET">
				<input class="form-control me-2" name="search" type="search"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-success">Search</button>
			</form>
		</div>
	</nav>
	<table class="table">
		<thead class="table-dark">
			<tr>
				<th scope="col">Tên Khách</th>
				<th scope="col">ID Khách</th>
				<th scope="col">Địa Chỉ</th>
				<th scope="col">Email</th>
				<th scope="col">SĐT</th>
				<th scope="col">Mã Máy</th>
				<th scope="col">Ngày Bắt Đầu</th>
				<th scope="col">Giờ Bắt Đầu</th>
				<th scope="col">TG Sử Dụng</th>
				<th scope="col">Mã Dịch Vụ</th>
				<th scope="col">Số Lượng</th>
				<th scope="col">Thanh Toán</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listkhach }" var="khach">
				<tr>
					<td>${khach[0]}</td>
					<td>${khach[1]}</td>
					<td>${khach[2]}</td>
					<td>${khach[3]}</td>
					<td>${khach[4]}</td>
					<td>${khach[5]}</td>
					<td><fmt:formatDate pattern = "dd-MM-yyyy" value = "${khach[6]}" /></td>
					<td><fmt:formatDate pattern = "HH:mm" value = "${khach[7]}" /></td>
					<td>${khach[8]}</td>
					<td>${khach[9]}</td>
					<td>${khach[10]}</td>
					<td><a href="${pageContext.request.contextPath}/bill?idkhach=${khach[1]}&idmay=${khach[5]}&ngay=${khach[6]}&gio=${khach[7]}&iddv=${khach[9]}"><button class="btn btn-primary fs-4"><i class="fa-solid fa-file-invoice-dollar"></i></button></a> </td>
				
				</tr>

			</c:forEach>
		</tbody>
	</table>
	<nav aria-label="...">
		<ul class="pagination">
		
			<li class="page-item ">
			<c:if test="${page >1 }" ><a class="page-link"
				href="${pageContext.request.contextPath}/trang-chu?page=${page - 1}"
				tabindex="-1" aria-disabled="true">Previous</a></c:if>
				</li>
				
			<li class="page-item "><a class="page-link"
				href="">${page}</a></li>
				
			<li class="page-item" ><c:if test="${page < totaldanhsach }"><a class="page-link"
				href="${pageContext.request.contextPath}/trang-chu?page=${page + 1}">Next</a>
				</c:if>
			</li>
		</ul>
	</nav>

</body>
