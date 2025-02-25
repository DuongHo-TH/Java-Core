<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<body>
	<div class="container w-50">
		<h1>Sử Dụng Máy</h1>
		<form:form
			action="${pageContext.request.contextPath}/updatesudungdichvu"
			class="form-control " method="post" modelAttribute="sudungdichvu">
			<label for="soluong" class="form-check-label">Khách Hàng</label>
			<form:select path="id.makh" items="${khachlist}" name="id.makh"
				id="makh" itemValue="makh" itemLabel="tenKH" class="form-select"
				aria-label="Default select example">
			</form:select>
			<label for="soluong" class="form-check-label">Dịch Vụ</label>
			<form:select path="id.madv" name="madv" items="${dvlist}"
				id="id.madv" itemValue="madv" itemLabel="tendv" class="form-select"
				aria-label="Default select example">
			</form:select>
			<label for="soluong" class="form-check-label">Số Lượng</label>
			<div class="input-group pb-3">
				<span class="input-group-text" id="addon-wrapping"><i
					class="fa-solid fa-lock"></i></span>
				<form:input path="soluong" type="number" min="0" name="soluong"
					class="form-control" placeholder="Số Lượng" aria-label="Username"
					aria-describedby="addon-wrapping" />
			</div>
			<form:label path="id.ngaysudung" class="form-label">Ngày Bắt Đầu</form:label>
			<form:input type="date" path="id.ngaysudung" class="form-control" />


			<form:label path="id.giosudung" class="form-label">Giờ Bắt Đầu</form:label>
			<form:input type="time" path="id.giosudung" class="form-control" />

			<form:button class="btn btn-secondary form-control mt-3">Update Sử Dụng Dịch Vụ</form:button>
		</form:form>
	</div>
</body>
