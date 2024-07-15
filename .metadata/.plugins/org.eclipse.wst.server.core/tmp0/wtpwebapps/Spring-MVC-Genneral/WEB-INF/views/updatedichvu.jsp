<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<body>
	<h1>Update Dịch Vụ</h1>
	<form:form action="${pageContext.request.contextPath}/updatedichvu"
		class="form-control" method="post" modelAttribute="dichvu">
		<label for="madv" class="form-check-label">ID Dịch Vụ</label>
		<div class="input-group  pb-3">
			<span class="input-group-text" id="addon-wrapping"><i
				class="fa-solid fa-user"></i></span>
			<form:input path="madv" type="text" id="madv" name="madv"
				class="form-control" placeholder="ID Dịch Vụ" aria-label="Username"
				aria-describedby="addon-wrapping" />
		</div>
		<form:errors path="madv" cssClass="error text-danger"></form:errors>
		<label for="tendichvu" class="form-check-label">Tên Dịch Vụ</label>
		<div class="input-group  pb-3">
			<span class="input-group-text" id="addon-wrapping"><i
				class="fa-solid fa-user"></i></span>
			<form:input path="tendv" type="text" id="tendv" name="tendv"
				class="form-control" placeholder="Tên Dịch Vụ" aria-label="Username"
				aria-describedby="addon-wrapping" />
		</div>
		<form:errors path="tendv" cssClass="error text-danger"></form:errors>
		<label for="donvi" class="form-check-label">Đơn Vị Tính</label>
		<div class="input-group pb-3">
			<span class="input-group-text" id="addon-wrapping"><i
				class="fa-solid fa-lock"></i></span>
			<form:input path="donvi" type="text" id="donvi" name="donvi"
				class="form-control" placeholder="Đơn Vị Tính" aria-label="Username"
				aria-describedby="addon-wrapping" />
		</div>
		<form:errors path="donvi" cssClass="error text-danger"></form:errors>
		<label for="dongia" class="form-check-label">Đơn Giá</label>
		<div class="input-group pb-3">
			<span class="input-group-text" id="addon-wrapping"><i
				class="fa-solid fa-lock"></i></span>
			<form:input path="dongia" type="number" min="0" id="dongia" name="dongia"
				class="form-control" placeholder="Đơn Giá" aria-label="Username"
				aria-describedby="addon-wrapping" />
		</div>
		<form:errors path="dongia" cssClass="error text-danger"></form:errors>
		<button class="btn btn-secondary form-control pb-3">Update</button>
	</form:form>
</body>
