<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link
	href="<c:url value='/resources/bootstrap_5/js/bootstrap.min.js' />"
	rel="stylesheet">
<body>
	<h1>Danh Sách Dịch Vụ</h1>
	<nav class="navbar navbar-light bg-light">
		<div class="container-fluid">
			<form class="d-flex"
				action="${pageContext.request.contextPath}/searchdichvu"
				method="GET">
				<input class="form-control me-2" type="search" name="search"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-success" type="submit">Search</button>
			</form>
		</div>
	</nav>
	<table class="table ">
		<thead class="table-dark">
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Tên Dịch Vụ</th>
				<th scope="col">Đơn Vị Tính</th>
				<th scope="col">Giá Tiền</th>
				<th scope="col">Active</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${dichvulist }" var="dv">
				<tr>
					<td>${dv.getMadv()}</td>
					<td>${dv.getTendv()}</td>
					<td>${dv.getDonvi()}</td>
					<td>${dv.getDongia()}</td>
					<td><c:url value="/deletedichvu" var="deletedichvu">
							<c:param name="dichvuId" value="${dv.getMadv()}"></c:param>
						</c:url>
						<button type="button" class="btn btn-primary"
							data-bs-toggle="modal" data-bs-target="#exampleModal${dv.getMadv()}">
							<i class="fa-solid fa-trash"></i>
						</button> <c:url value="/editdichvu" var="editdichvu">
							<c:param name="dichvuId" value="${dv.getMadv()}"></c:param>
						</c:url> <a href="${editdichvu}" target="blank"><i
							class="fa-solid fa-pen-to-square"></i></a></td>
				</tr>


				<div class="modal fade" id="exampleModal${dv.getMadv()}" tabindex="-1"
					aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">Sử Dụng Dịch Vụ</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body">Bạn Có Chắc Chắn Muốn Xóa Dịch Vụ</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-bs-dismiss="modal">Close</button>
								<a href="${deletedichvu}" target="blank">
									<button type="button" class="btn btn-primary">Yes</button>
								</a>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</tbody>
	</table>
	<nav aria-label="...">
		<ul class="pagination">

			<li class="page-item "><c:if test="${page >1 }">
					<a class="page-link"
						href="${pageContext.request.contextPath}/showdichvu?page=${page - 1}"
						tabindex="-1" aria-disabled="true">Previous</a>
				</c:if></li>

			<li class="page-item "><a class="page-link" href="">${page}</a></li>

			<li class="page-item"><c:if test="${page < total }">
					<a class="page-link"
						href="${pageContext.request.contextPath}/showdichvu?page=${page + 1}">Next</a>
				</c:if></li>
		</ul>
	</nav>

</body>