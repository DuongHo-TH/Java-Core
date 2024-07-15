<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>
<h1>Danh Sách Khách Hàng </h1>
			<nav class="navbar navbar-light bg-light">
				<div class="container-fluid">
					<form class="d-flex"
						action="${pageContext.request.contextPath}/searchkhach"
						method="GET">
						<input class="form-control me-2" name="search" type="search"
							placeholder="Search" aria-label="Search">
						<button class="btn btn-outline-success" type="submit">Search</button>
					</form>
				</div>
			</nav>
			<table class="table">
				<thead class="table-dark">
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
					<c:forEach items="${khachlist }" var="khach">
						<tr>
							<td>${khach.getMakh()}</td>
							<td>${khach.getTenKH()}</td>
							<td>${khach.getDiachi()}</td>
							<td>${khach.getPhone()}</td>
							<td>${khach.getEmail()}</td>
							<td>
							<c:url value="/deletekhach"
									var="deletekhach">
									<c:param name="khachId" value="${khach.getMakh()}"></c:param>
								</c:url> <a href="${deletekhach}" target="blank"><i class="fa-solid fa-trash"></i></a>
								<c:url value="/editkhach"
									var="editkhach">
									<c:param name="khachId" value="${khach.getMakh()}"></c:param>
								</c:url> <a href="${editkhach}" target="blank"><i class="fa-solid fa-pen-to-square"></i></a>
							</td>
						</tr>

					</c:forEach>
				</tbody>
			</table>
			<nav aria-label="...">
		<ul class="pagination">
		
			<li class="page-item ">
			<c:if test="${page >1 }" ><a class="page-link"
				href="${pageContext.request.contextPath}/showkhach?page=${page - 1}"
				tabindex="-1" aria-disabled="true">Previous</a></c:if>
				</li>
				
			<li class="page-item "><a class="page-link"
				href="">${page}</a></li>
				
			<li class="page-item" ><c:if test="${page < total }"><a class="page-link"
				href="${pageContext.request.contextPath}/showkhach?page=${page + 1}">Next</a>
				</c:if>
			</li>
		</ul>
	</nav>
</body>
