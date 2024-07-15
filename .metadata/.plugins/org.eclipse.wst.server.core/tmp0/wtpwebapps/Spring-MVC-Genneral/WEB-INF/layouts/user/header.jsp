<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header>
<div class="Logo">
<h1>AD Gaming Center</h1>
</div>
<nav class="navbar navbar-expand-lg navbar-light">
  <div class="container">
    <div class="collapse navbar-collapse " id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active text-white" aria-current="page" href="${pageContext.request.contextPath}/trang-chu">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link text-white" href="${pageContext.request.contextPath}/addmay">Thêm Máy</a>
        </li>
        <li class="nav-item">
          <a class="nav-link text-white" href="${pageContext.request.contextPath}/addkhach">Thêm Khách Hàng</a>
        </li>
        <li class="nav-item">
          <a class="nav-link text-white" href="${pageContext.request.contextPath}/adddichvu">Thêm Dịch Vụ</a>
        </li>
        <li class="nav-item">
          <a class="nav-link text-white" href="${pageContext.request.contextPath}/addsudungmay">Sử Dụng Máy</a>
        </li>
        <li class="nav-item">
          <a class="nav-link text-white" href="${pageContext.request.contextPath}/addsudungdichvu">Sử Dụng Dịch Vụ</a>
        </li>
      </ul>
    </div>
  </div>
  </nav>
  <nav class="navbar navbar-expand-lg navbar-light">
  <div class="container">
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link text-white" href="${pageContext.request.contextPath}/showmay?page=1&pagemay=1">Show DS Máy</a>
        </li>
        <li class="nav-item">
          <a class="nav-link text-white" href="${pageContext.request.contextPath}/showkhach?page=1">Show DS Khách Hàng</a>
        </li>
        <li class="nav-item">
          <a class="nav-link text-white" href="${pageContext.request.contextPath}/showdichvu?page=1">Show DS Dịch Vụ</a>
        </li>
         <li class="nav-item">
          <a class="nav-link text-white " href="${pageContext.request.contextPath}/showsudungmay?page=1">Show Sử Dụng Máy</a>
        </li>
        <li class="nav-item">
          <a class="nav-link text-white" href="${pageContext.request.contextPath}/showsudungdichvu?page=1">Show Sử Dụng Dịch Vụ</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
</header>