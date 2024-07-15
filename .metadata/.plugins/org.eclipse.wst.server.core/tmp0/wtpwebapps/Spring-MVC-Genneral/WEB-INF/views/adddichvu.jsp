<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
	<div class="container w-50">
		<h1>Thêm Dịch Vụ</h1>
		<form:form action="${pageContext.request.contextPath}/savedichvu"
			class="form-control" method="post" modelAttribute="dichvu">
			<form:label path="madv" for="madv" class="form-check-label">ID Dich Vu</form:label>
			<div class="input-group  pb-3">
				<span class="input-group-text" id="addon-wrapping"><i
					class="fa-solid fa-user"></i></span>
				<form:input type="text" path="madv" id="madv" class="form-control"
					placeholder="ID Dịch Vụ" aria-label="Username"
					aria-describedby="addon-wrapping" />
			</div>
			<form:errors path="madv" cssClass="error text-danger"></form:errors>
			<br>
			<label for="tendichvu" class="form-check-label">Tên Dịch Vụ</label>
			<div class="input-group  pb-3">
				<span class="input-group-text" id="addon-wrapping"><i
					class="fa-solid fa-user"></i></span>
				<form:input type="text" path="tendv" id="tendv" name="tendv"
					class="form-control" placeholder="Tên Dịch Vụ"
					aria-label="Username" aria-describedby="addon-wrapping" />
			</div>
			<form:errors path="tendv" cssClass="error text-danger"></form:errors><br>
			<label for="donvi" class="form-check-label">Đơn Vị Tính</label>
			<div class="input-group pb-3">
				<span class="input-group-text" id="addon-wrapping"><i
					class="fa-solid fa-lock"></i></span>
				<form:input type="text" path="donvi" id="donvi" name="donvi"
					class="form-control" placeholder="Đơn Vị Tính"
					aria-label="Username" aria-describedby="addon-wrapping" />

			</div>
			<form:errors path="donvi" cssClass="error text-danger"></form:errors> <br>
			<label for="dongia" class="form-check-label">Đơn Giá</label>
			<div class="input-group pb-3">
				<span class="input-group-text" id="addon-wrapping"><i
					class="fa-solid fa-lock"></i></span>
				<form:input type="text" path="dongia" id="dongia" name="dongia"
					class="form-control" placeholder="Đơn Giá" aria-label="Username"
					aria-describedby="addon-wrapping" />

			</div>
			<form:errors path="dongia" cssClass="error text-danger"></form:errors><br>
			<form:button type="submit"
				class="btn btn-secondary form-control pb-3">Thêm Dịch Vụ</form:button>
		</form:form>
	</div>

</body>