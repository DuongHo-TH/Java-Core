<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<body>
<h1>Danh Sách Sử Dụng May</h1>
			<nav class="navbar navbar-light bg-light">
				<div class="container-fluid">
					<form class="d-flex"
						action="${pageContext.request.contextPath}/searchsudungmay" method="GET">
						<input class="form-control me-2" type="search" name="search"
							placeholder="Search" aria-label="Search">
						<button class="btn btn-outline-success" type="submit">Search</button>
					</form>
				</div>
			</nav>
			<table class="table ">
				<thead class="table-dark">
					<tr>
						<th scope="col">ID Máy</th>
						<th scope="col">Vị Trí</th>
						<th scope="col">ID Khách Hàng</th>
						<th scope="col">Tên Khách Hàng</th>
						<th scope="col">Ngày Sử Dụng</th>
						<th scope="col">Giờ Sử Dụng</th>
						<th scope="col">Thời Gian Sử Dụng</th>
						<th scope="col">Active</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listsudungmay }" var="sddv">
						<tr>
						    <td>${sddv.getMamay().getMamay()}</td>
							<td>${sddv.getMamay().getVitri()}</td>
							<td>${sddv.getMakh().getMakh()}</td>
							<td>${sddv.getMakh().getTenKH()}</td>
							<td>${sddv.getId().getNgayBatDauSuDung()}</td>
							<td>${sddv.getId().getGioBatDauSuDung()}</td>
							<td>${sddv.getThoigiansudung()}</td>
							<td><a
							href="${pageContext.request.contextPath}/deletesudungdichvu?makh=${sddv.id.makh}&mamay=${sddv.id.mamay}&ngayBatDauSuDung=${sddv.id.ngayBatDauSuDung}&gioBatDauSuDung=${sddv.id.gioBatDauSuDung}"><i class="fa-solid fa-trash"></i></a>
							<a
							href="${pageContext.request.contextPath}/deletesudungdichvu?makh=${sddv.id.makh}&mamay=${sddv.id.mamay}&ngayBatDauSuDung=${sddv.id.ngayBatDauSuDung}&gioBatDauSuDung=${sddv.id.gioBatDauSuDung}"><i class="fa-solid fa-pen-to-square"></i></a>
							</td>
						</tr>

					</c:forEach>
				</tbody>
			</table>
			<nav aria-label="...">
		<ul class="pagination">
		
			<li class="page-item ">
			<c:if test="${page >1 }" ><a class="page-link"
				href="${pageContext.request.contextPath}/showsudungmay?page=${page - 1}"
				tabindex="-1" aria-disabled="true">Previous</a></c:if>
				</li>
				
			<li class="page-item "><a class="page-link"
				href="">${page}</a></li>
				
			<li class="page-item" ><c:if test="${page < total }"><a class="page-link"
				href="${pageContext.request.contextPath}/showsudungmay?page=${page + 1}">Next</a>
				</c:if>
			</li>
		</ul>
	</nav>
</body>