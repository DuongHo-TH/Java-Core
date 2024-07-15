<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<body>
	<h1>Update Khách Hàng</h1>
	<form:form action="${pageContext.request.contextPath}/updatekhach"
		class="form-control " method="post" modelAttribute="khach">

		<label for="makh" class="form-check-label">ID Khách Hàng</label>
		<div class="input-group  pb-3">
			<span class="input-group-text" id="addon-wrapping"><i
				class="fa-solid fa-user"></i></span>
			<form:input path="makh" type="text" id="makh" name="makh"
				class="form-control" placeholder="ID Khách Hàng"
				aria-label="Username" aria-describedby="addon-wrapping" />
		</div>
		<form:errors path="makh" cssClass="error text-danger"></form:errors>
		<label for="tenkhach" class="form-check-label">Tên Khách Hàng</label>
		<div class="input-group  pb-3">
			<span class="input-group-text" id="addon-wrapping"><i
				class="fa-solid fa-user"></i></span>
			<form:input path="tenKH" type="text" id="tenKH" name="tenKH"
				class="form-control" placeholder="Tên Khách Hàng"
				aria-label="Username" aria-describedby="addon-wrapping" />
		</div>
		<form:errors path="tenKH" cssClass="error text-danger"></form:errors>
		<label for="diachi" class="form-check-label">Địa Chỉ</label>
		<div class="input-group pb-3">
			<span class="input-group-text" id="addon-wrapping"><i
				class="fa-solid fa-lock"></i></span>
			<form:input path="diachi" type="text" id="diachi" name="diachi"
				class="form-control" placeholder="Địa Chỉ" aria-label="Username"
				aria-describedby="addon-wrapping" />
		</div>
		<form:errors path="diachi" cssClass="error text-danger"></form:errors>
		<label for="sdt" class="form-check-label">Số ĐT</label>
		<div class="input-group pb-3">
			<span class="input-group-text" id="addon-wrapping"><i
				class="fa-solid fa-lock"></i></span>
			<form:input path="phone" type="text" id="phone" name="phone"
				class="form-control" placeholder="Số Điện Thoại"
				aria-label="Username" aria-describedby="addon-wrapping" />
		</div>
		<form:errors path="phone" cssClass="error text-danger"></form:errors>
		<label for="email" class="form-check-label">Email</label>
		<div class="input-group pb-3">
			<span class="input-group-text" id="addon-wrapping"><i
				class="fa-solid fa-lock"></i></span>
			<form:input path="email" type="text" id="email" name="email"
				class="form-control" placeholder="Email" aria-label="Username"
				aria-describedby="addon-wrapping" />
		</div>
		<form:errors path="email" cssClass="error text-danger"></form:errors>
		<button class="btn btn-secondary form-control pb-3">Update</button>
	</form:form>
</body>