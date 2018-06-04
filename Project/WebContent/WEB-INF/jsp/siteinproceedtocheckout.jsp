<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>決済確認ページ</title>
<jsp:include page="/baselayout/head.jsp" />
</head>
<body class="background-color1">
	<jsp:include page="/baselayout/header.jsp" />
	<div class="container">


		<br>
		<br>
		<div class="card">

			<h3 class="text-center">決済確認ページ</h3>
			<br>
			<br>


			<table class="table">
				<thead>
					<tr>
						<th scope="col">イベント名</th>
						<th scope="col">単価</th>
						<th scope="col">小計</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="beansEventDetailInfoListOne" items="${beansEventDetailInfoList}" begin="0">
						<tr>
							<th scope="row">${beansEventDetailInfoListOne.title}</th>
							<td>${beansEventDetailInfoListOne.fees}円</td>
							<td>${beansEventDetailInfoListOne.fees}円</td>
						</tr>
					</c:forEach>
					<tr>
						<th scope="row"></th>
						<td>合計</td>
						<td>${beansEventDetailInfo.total_fees}円</td>
					</tr>
				</tbody>
			</table>

			<form action="SiteInPlaceUsersOrder" method="post">
				<div class="text-center ">
					<button class="btn col btncolor1 " type="submit">
						決済確定
					</button>
				</div>
			</form>
		</div>
	</div>

	<jsp:include page="/baselayout/footer.jsp" />
</body>

</html>