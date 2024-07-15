<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<body>


	<h1> Hóa Đơn Thanh Toán</h1>
	<table class="table">
		<thead class="table-dark">
			<tr>
				<th scope="col">Tên Khách</th>
				<th scope="col">ID Khách</th>
				<th scope="col">ID Máy</th>
				<th scope="col">Ngày Sử Dụng</th>
				<th scope="col">Giờ Sử Dụng</th>
				<th scope="col">Thời Gian Sử Dụng</th>
				<th scope="col">ID Dịch Vụ</th>
				<th scope="col">Số Lượng</th>
				<th scope="col">Giá Dịch Vụ</th>
				<th scope="col">Tiền Máy</th>
				<th scope="col">Tiền Dịch Vụ</th>
				<th scope="col">Tổng Tiền</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listbill }" var="khach">
				<tr>
					<td>${khach[0]}</td>
					<td>${khach[1]}</td>
					<td>${khach[2]}</td>
					<td><fmt:formatDate pattern = "dd-MM-yyyy" value = "${khach[3]}" /></td>
					<td><fmt:formatDate pattern = "HH:mm" value = "${khach[4]}" /></td>
					<td>${khach[5]}</td>
					<td>${khach[6]}</td>
					<td>${khach[7]}</td>
					<td>${khach[8]}</td>
					<td>${khach[5]*5000}</td>
					<td>${(khach[7] * khach[8])}</td>
					<td>${((khach[5] * 5000) + (khach[7] * khach[8]))}</td>
				</tr>
			<a href="${pageContext.request.contextPath}/thanhtoanmay?idmay=${khach[2]}"><button type="button" class="btn btn-primary mb-3">Thanh Toán<i class="fa-solid fa-file-invoice-dollar fs-3"> </i></button></a>
			<a href="${pageContext.request.contextPath}/trang-chu"><button type="button" class="btn btn-danger ms-5 mb-3">Quay Lại<i class="fa-solid fa-rectangle-xmark fs-3"></i></button></a>

			</c:forEach>
		</tbody>
	</table>
</body>