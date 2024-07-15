<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<body>
<h1>Danh Sách Sử Dụng Dịch Vụ</h1>
			<nav class="navbar navbar-light bg-light">
				<div class="container-fluid">
					<form class="d-flex"
						action="${pageContext.request.contextPath}/searchsudungdichvu" method="GET">
						<input class="form-control me-2" type="search" name="search"
							placeholder="Search" aria-label="Search">
						<button class="btn btn-outline-success" type="submit">Search</button>
					</form>
				</div>
			</nav>
			<table class="table ">
				<thead class="table-dark">
					<tr>
						<th scope="col">ID Dịch Vụ</th>
						<th scope="col">Tên Dịch Vụ</th>
						<th scope="col">ID Khách Hàng</th>
						<th scope="col">Tên Khách Hàng</th>
						<th scope="col">Ngày Sử Dụng</th>
						<th scope="col">Giờ Sử Dụng</th>
						<th scope="col">Số Lượng</th>
						<th scope="col">Active</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listsudungdichvu }" var="sddv">
						<tr>
						    <td>${sddv.getMadv().getMadv()}</td>
							<td>${sddv.getMadv().getTendv()}</td>
							<td>${sddv.getMakh().getMakh()}</td>
							<td>${sddv.getMakh().getTenKH()}</td>
							<td>${sddv.getId().getNgaysudung()}</td>
							<td>${sddv.getId().getGiosudung()}</td>
							<td>${sddv.getSoluong()}</td>
							<td><a
							href="${pageContext.request.contextPath}/deletesudungdichvu?makh=${sddv.id.makh}&madv=${sddv.id.madv}&ngaysudung=${sddv.id.ngaysudung}&giosudung=${sddv.id.giosudung}"><i class="fa-solid fa-trash"></i></a>
							<a
							href="${pageContext.request.contextPath}/editsudungdichvu?makh=${sddv.id.makh}&madv=${sddv.id.madv}&ngaysudung=${sddv.id.ngaysudung}&giosudung=${sddv.id.giosudung}"><i class="fa-solid fa-pen-to-square"></i></a>
							
							</td>
						</tr>

					</c:forEach>
				</tbody>
			</table>
			<nav aria-label="...">
		<ul class="pagination">
		
			<li class="page-item ">
			<c:if test="${page >1 }" ><a class="page-link"
				href="${pageContext.request.contextPath}/showsudungdichvu?page=${page - 1}"
				tabindex="-1" aria-disabled="true">Previous</a></c:if>
				</li>
				
			<li class="page-item "><a class="page-link"
				href="">${page}</a></li>
				
			<li class="page-item" ><c:if test="${page < total }"><a class="page-link"
				href="${pageContext.request.contextPath}/showsudungdichvu?page=${page + 1}">Next</a>
				</c:if>
			</li>
		</ul>
	</nav>
</body>
