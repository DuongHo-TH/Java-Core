<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<body>
	<div class="container w-50">
		<h1>Sử Dụng Máy</h1>
		<form:form action="${pageContext.request.contextPath}/savesudungmay"
			class="form-control " method="post" modelAttribute="sudungmay">
			<label for="makh" class="form-check-label">Khách Hàng</label>
			<form:select path="id.makh" items="${khachlist}" itemValue="makh"
				itemLabel="tenKH" class="form-select"
				aria-label="Default select example">
			</form:select>
			<form:errors path="id.makh" cssClass="error text-danger"></form:errors><br>
			<label for="soluong" class="form-check-label">Vị Trí Máy</label>
			<form:select path="id.mamay" items="${maylist}" itemValue="mamay"
				itemLabel="vitri" class="form-select"
				aria-label="Default select example">
			</form:select>
			<form:errors path="id.mamay" cssClass="error text-danger"></form:errors><br>
			<form:label path="id.ngayBatDauSuDung" class="form-label">Ngày Bắt Đầu</form:label>
			<form:input type="date" path="id.ngayBatDauSuDung"
				class="form-control" />
			<form:errors path="id.ngayBatDauSuDung" cssClass="error text-danger"></form:errors><br>
			<form:label path="id.gioBatDauSuDung" class="form-label">Giờ Bắt Đầu</form:label>
			<form:input type="time" path="id.gioBatDauSuDung"
				class="form-control" />
			<form:errors path="id.gioBatDauSuDung" cssClass="error text-danger"></form:errors><br>
			<form:label path="thoigiansudung" class="form-label">Thời Gian Sử Dụng</form:label>
			<form:input type="text" min="0" path="thoigiansudung"
				class="form-control" />
			<form:errors path="thoigiansudung" cssClass="error text-danger"></form:errors><br>
			<form:button class="btn btn-secondary form-control pb-3">Thêm Sử Dụng Máy</form:button>
		</form:form>
	</div>
</body>
