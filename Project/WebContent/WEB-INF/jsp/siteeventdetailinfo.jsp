<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html>
<head>
<title>イベント詳細</title>
<jsp:include page="/baselayout/head.jsp" />
</head>
<body class="background-color1">
	<jsp:include page="/baselayout/header.jsp" />
	<br>
	<br>
	<div class="container ">
		<div class="card grey lighten-5">
			<h1 class="text-center padding1">イベント詳細</h1>
			<jsp:include page="/event-tables/event-detail-table.jsp" />
		</div>
	</div>


	<jsp:include page="/baselayout/footer.jsp" />
</body>

</html>