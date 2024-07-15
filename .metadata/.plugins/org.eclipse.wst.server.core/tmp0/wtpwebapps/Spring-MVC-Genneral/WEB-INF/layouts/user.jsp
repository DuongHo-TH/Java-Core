<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>AD Gaming Center</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="<c:url value='/resources/bootstrap_5/css/bootstrap.min.css' />"
	rel="stylesheet">
<link
	href="<c:url value='/resources/fontawesome-free-6.5.2-web/css/all.min.css' />"
	rel="stylesheet">
<script type="text/javascript"
	src="<c:url value='/resources/jquey.js' />"></script>
	
	<script type="text/javascript"
	src="<c:url value='/resources/bootstrap_5/js/bootstrap.min.js' />"></script>
<meta charset="utf-8">
<style>
* {
	box-sizing: border-box;
}

body {
	font-family: Arial, Helvetica, sans-serif;
	body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
           
        }
        .headererr {
            background-color: #3498db;
            color: #ffffff;
            text-align: center;
            padding: 20px;
        }
        .footererr {
            background-color: #34495e;
            color: #ffffff;
            text-align: center;
            padding: 10px;
        }
        .contenterr {
         h1{
            color:red;
            }
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            background-color: #ffffff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
}
error{
color: red;
}

/* Style the header */
header {
	width: 100% align-items: center;
	padding: 30px;
	text-align: center;
	font-size: 15px;
	border-top: 5px solid #17a2b8;
	border-bottom: #17a2b8 solid 5px;
	border-radius: 50px; h1 { font-weight : bold;
	text-decoration: underline;
	color: #ffc107;
}

nav {
	font-weight: bold;
	width: 45%;
	border-top: 5px solid #17a2b8;
	border-radius: 50px;
}

}
li {
	border-radius: 50px;
	background-color: black;
}

/* Create two columns/boxes that floats next to each other */
/* nav { */
/*   float: left; */
/*   width: 30%; */
/*   height: 300px; /* only for demonstration, should be removed */
* /
	/*   background: #ccc; */
	/*   padding: 20px; */
	/* } */
	/* /* Style the list inside the menu */ * /
	/* nav ul { */
	/*   list-style-type: none; */
	/*   padding: 0; */
	/* } */   

article {
	float: left;
	padding: 20px;
	width: 70%;
	background-color: #f1f1f1;
	height: 300px; /* only for demonstration, should be removed */
}

/* Clear floats after the columns */
section::after {
	content: "";
	display: table;
	clear: both;
}

/* Style the footer */
footer {
	bottom: 30px;
	padding: 10px;
	width: 100%;
	position: absolute;
	border-top: 5px solid #17a2b8;
	border-bottom: #17a2b8 solid 5px;
	border-radius: 50px;
	height: 160px;
	padding-left: 50px;
}

container {
	position: rerelative;
}
/* /* Responsive layout - makes the two columns/boxes stack on top of each other instead of next to each other, on small screens */ */
/* @media ( max-width : 600px) { */
/* 	nav, article { */
/* 		width: 100%; */
/* 		height: auto; */
/* 	} */
}
</style>
</head>
<body>

	<%@include file="/WEB-INF/layouts/user/header.jsp"%>
	<div class="container">
		<decorator:body />
	</div>
	<%@include file="/WEB-INF/layouts/user/footer.jsp"%>
	<script type="text/javascript"
		src="<c:url value='/resources/qlphongmay.js' />"></script>
</body>

</html>