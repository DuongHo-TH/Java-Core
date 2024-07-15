<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
	<div class="container w-25">
		<h1>Update Máy</h1>
		<form:form action="${pageContext.request.contextPath}/updatemay" class="form-control " method="post" modelAttribute="may">
			<label for="mamay" class="form-check-label">ID Máy</label>
			<div class="input-group pb-3">
				<span class="input-group-text" id="addon-wrapping"><i class="fa-solid fa-lock"></i></span>
					 <form:input type="text" path="mamay" id="mamay" name="mamay" class="form-control" placeholder="ID Máy"
					aria-label="Username" aria-describedby="addon-wrapping"/>
			</div>
			<form:errors path="mamay" cssClass="error text-danger"></form:errors>
			<label for="vitri" class="form-check-label">Vị Trí Máy</label>
			<div class="input-group pb-3">
				<span class="input-group-text" id="addon-wrapping"><i class="fa-solid fa-lock"></i></span>
					 <form:input type="text" path="vitri" id="vitri" name="vitri" class="form-control" placeholder="Vị Trí Máy"
					aria-label="Username" aria-describedby="addon-wrapping"/>
			</div>
			<form:errors path="vitri" cssClass="error text-danger"></form:errors>
			<label for="trangthai" class="form-check-label">Trạng Thái </label>
			<div class="input-group  pb-3">
				<span class="input-group-text" id="addon-wrapping"><i
					class="fa-solid fa-user"></i></span> <form:input type="text" path="trangthai" name="trangthai"
					id="trangthai" class="form-control" placeholder="Trạng Thái"
					aria-label="Username" aria-describedby="addon-wrapping"/>
			</div>
			<form:errors path="trangthai" cssClass="error text-danger"></form:errors>
			<form:button class="btn btn-secondary form-control pb-3">Update</form:button>
		</form:form>
	</div>
	<script type="text/javascript" src="<c:url value='/resources/qlphongmay.js' />"></script>
</body>
</body>