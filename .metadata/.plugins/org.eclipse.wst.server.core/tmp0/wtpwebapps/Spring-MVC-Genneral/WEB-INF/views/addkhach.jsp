<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
	<div class="container w-50">
		<h1>Thêm Khách Hàng</h1>
		<form:form action="${pageContext.request.contextPath}/savekhach" class="form-control " method="post" modelAttribute="khach">
			<label for="makh" class="form-check-label">ID Khách Hàng</label>
			<div class="input-group">
				<span class="input-group-text" id="addon-wrapping"><i
					class="fa-solid fa-user"></i></span> <form:input type="text" id="makh" path="makh"
					class="form-control" placeholder="ID Khách Hàng"
					aria-label="Username" aria-describedby="addon-wrapping"/>
			</div>
			<form:errors path="makh" cssClass="error text-danger"></form:errors>
			<br>
			<label for="tenkhach" class="form-check-label">Tên Khách
				Hàng</label>
			<div class="input-group">
				<span class="input-group-text" id="addon-wrapping"><i
					class="fa-solid fa-user"></i></span> <form:input type="text" id="tenKH" path="tenKH"
					class="form-control" placeholder="Tên Khách Hàng"
					aria-label="Username" aria-describedby="addon-wrapping"/>
			</div>
			<form:errors path="tenKH" cssClass="error text-danger"></form:errors>
			<br>
			<label for="diachi" class="form-check-label">Địa Chỉ</label>
			<div class="input-group ">
				<span class="input-group-text" id="addon-wrapping"><i
					class="fa-solid fa-lock"></i></span> <form:input type="text" id="diachi" path="diachi"
					class="form-control" placeholder="Địa Chỉ" aria-label="Username"
					aria-describedby="addon-wrapping"/>
			</div>
			<form:errors path="diachi" cssClass="error text-danger"></form:errors>
			<br>
			<label for="sdt" class="form-check-label">Số ĐT</label>
			<div class="input-group">
				<span class="input-group-text" id="addon-wrapping"><i
					class="fa-solid fa-lock"></i></span> <form:input type="text" id="phone" path = "phone"
					class="form-control" placeholder="Số Điện Thoại"
					aria-label="Username" aria-describedby="addon-wrapping"/>
			</div>
			<form:errors path="phone" cssClass="error text-danger"></form:errors>
			<br>
			<label for="email" class="form-check-label">Email</label>
			<div class="input-group ">
				<span class="input-group-text" id="addon-wrapping"><i
					class="fa-solid fa-lock"></i></span> <form:input type="text" id="email" path="email"
					class="form-control" placeholder="Email" aria-label="Username"
					aria-describedby="addon-wrapping"/>
			</div>
			<form:errors path="email" cssClass="error text-danger"></form:errors>
			<br>

			<button class="btn btn-secondary form-control">Thêm Mới</button>
			</form:form>
	</div>
	<script type="text/javascript" src="<c:url value='/resources/qlphongmay.js' />"></script>
</body>