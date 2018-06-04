<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<title>イベント削除</title>
<jsp:include page="/baselayout/head.jsp" />
</head>
<body class="background-color1">
	<jsp:include page="/baselayout/header.jsp" />



	<div class="container">
		<br>
		<br>
		<div class="card text-center">
			<h1>イベント削除</h1>
			<br>
			<h3>本当に削除しますか？</h3>
		</div>
		<br>
		<br>
		<div class="row">
			<form action="Index" class="col">
					<button class="btn btn2" type="submit">取りやめる</button>
			</form>
			<form action="MasterEventDelete?event_id=${beansEventDetailInfo.id}" method="post" class="col">
					<button class="btn btncolor1" type="submit">削除する</button>
			</form>
		</div>







		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<h1 class="text-center">削除する概要表</h1>

		<jsp:include page="/event-tables/event-summary-table-list.jsp" />

		<br>
		<br>
		<br>
		<br>
		<br>
		<h1 class="text-center">削除する詳細表</h1>
		<div class="card">
			<jsp:include page="/event-tables/event-detail-table.jsp" />
		</div>
		<br>

	</div>

	<jsp:include page="/baselayout/footer.jsp" />
</body>

</html>