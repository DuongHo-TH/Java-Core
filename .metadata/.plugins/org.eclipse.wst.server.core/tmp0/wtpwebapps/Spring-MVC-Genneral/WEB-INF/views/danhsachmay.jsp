<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
	<h1>Danh Sách Máy</h1>
	<nav class="navbar navbar-light bg-light">
		<div class="container-fluid">
			<form class="d-flex"
				action="${pageContext.request.contextPath}/searchmay"
				method="GET">
				<input class="form-control me-2" name="search" type="search"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-success" type="submit">Search</button>
				<h2><a href="${pageContext.request.contextPath}/showmaysudung?page=1&pagemay=2"><span class="badge bg-secondary ms-5"> Máy Đang Sử Dụng</span></a></h2>
				<h2><a href="${pageContext.request.contextPath}//showmaysansang?page=1&pagemay=3"><span class="badge bg-secondary ms-5">Máy Sẵn Sàng</span> </a></h2>
			</form>
		</div>
	</nav>
	<table class="table">
		<thead class="table-dark">
			<tr>
				<th scope="col">ID Máy</th>
				<th scope="col">Số Máy</th>
				<th scope="col">Tình Trạng</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${maylist }" var="may">
				<tr>
					<td>${may.getMamay()}</td>
					<td>${may.getVitri()}</td>
					<td>${may.getTrangthai()}</td>
					<td><c:url value="/deletemay" var="deletemay">
							<c:param name="mayId" value="${may.getMamay()}"></c:param>
						</c:url> <a href="${deletemay}" target="blank"><i
							class="fa-solid fa-trash"></i></a> <c:url value="/editmay"
							var="editmay">
							<c:param name="mayId" value="${may.getMamay()}"></c:param>
						</c:url> <a href="${editmay}" target="blank"><i
							class="fa-solid fa-pen-to-square"></i></a></td>
				</tr>

			</c:forEach>
		</tbody>
	</table>
	<c:if test="${pagemay == 1 }">
	<nav aria-label="...">
		<ul class="pagination">
		
			<li class="page-item ">
			<c:if test="${page >1 }" ><a class="page-link"
				href="${pageContext.request.contextPath}/showmay?page=${page - 1}&pagemay=1"
				tabindex="-1" aria-disabled="true">Previous</a></c:if>
				</li>
				
			<li class="page-item "><a class="page-link"
				href="">${page}</a></li>
				
			<li class="page-item" ><c:if test="${page < total }"><a class="page-link"
				href="${pageContext.request.contextPath}/showmay?page=${page + 1}&pagemay=1">Next</a>
				</c:if>
			</li>
		</ul>
	</nav>
	</c:if>
	<c:if test="${pagemay == 2 }">
	<nav aria-label="...">
		<ul class="pagination">
		
			<li class="page-item ">
			<c:if test="${page >1 }" ><a class="page-link"
				href="${pageContext.request.contextPath}/showmaysudung?page=${page - 1}&pagemay=2"
				tabindex="-1" aria-disabled="true">Previous</a></c:if>
				</li>
				
			<li class="page-item "><a class="page-link"
				href="">${page}</a></li>
				
			<li class="page-item" ><c:if test="${page < total }"><a class="page-link"
				href="${pageContext.request.contextPath}/showmaysudung?page=${page + 1}&pagemay=2">Next</a>
				</c:if>
			</li>
		</ul>
	</nav>
	</c:if>
	<c:if test="${pagemay == 3 }">
	<nav aria-label="...">
		<ul class="pagination">
		
			<li class="page-item ">
			<c:if test="${page >1 }" ><a class="page-link"
				href="${pageContext.request.contextPath}/showmaysansang?page=${page - 1}&pagemay=3"
				tabindex="-1" aria-disabled="true">Previous</a></c:if>
				</li>
				
			<li class="page-item "><a class="page-link"
				href="">${page}</a></li>
				
			<li class="page-item" ><c:if test="${page < total }"><a class="page-link"
				href="${pageContext.request.contextPath}/showmaysansang?page=${page + 1}&pagemay=3">Next</a>
				</c:if>
			</li>
		</ul>
	</nav>
	</c:if>

</body>
