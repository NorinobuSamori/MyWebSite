<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>siteeventhistory</title>
<jsp:include page="/baselayout/head.jsp" />
</head>
<body class="color-lightgreen">
	<jsp:include page="/baselayout/header.jsp" />


	<br>
	<br>
	<h3 class="text-center">siteeventhistory</h3>
	<br>
	actionMessage
	<br>
	<div class="container center">


		<div class="row">
			<div class="col  width50">
				<form action="Index" method="get">
					<button class="btn col btncolor1" type="submit">
						引き続きイベントを探す</button>
				</form>
			</div>
			<span class="col  width50"></span> <span class="col  width50"></span>
			<form action="UserInfoManagementTop" method="get">
				<button class="btn  col btncolor1" type="submit">ユーザー一覧へ</button>
			</form>
		</div>






		<br>
		<br>
		<h5 class="text-center">イベント詳細</h5>
		<br>
		<br>


		<table class="table color-white">
			<thead>
				<tr>
					<th scope="col">イベント名</th>
					<th scope="col">単価</th>
					<th scope="col">小計</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="?????" items="?????"  begin="0">
					<tr>
						<th scope="row">LIKEIT 完全無料で即戦力エンジニアとして今すぐIT企業に正社員就職</th>
						<td>0円</td>
						<td>0円</td>
					</tr>
					<tr>
						<th scope="row">特別講演会「グローバル課題～『人間の安全保障』の役割～」</th>
						<td>1000円</td>
						<td>1000円</td>
					</tr>
					<tr>
						<th scope="row"></th>
						<td>合計</td>
						<td>1000円</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<br>
		<h5 class="text-center">決済履歴</h5>
		<br> <br>
		<h3 class="text-center"></h3>


		<table class="table color-white">
			<thead>
				<tr>
					<th scope="col">イベント詳細</th>
					<th scope="col">決済日時</th>
					<th scope="col">合計金額</th>
				</tr>
			</thead>
			<tbody>

				<tr>
					<th scope="row">
						<h5>
							<a href="url????"><i class="fas fa-chevron-circle-down"></i></a>
						</h5>
					</th>
					<td>2018年04月27日13時56分</td>
					<td>0円</td>
				</tr>
				<tr>
					<th scope="row">
						<h5>
							<a href="url????"><i class="fas fa-chevron-circle-down"></i></a>
						</h5>
					</th>
					<td>2018年05月14日13時56分</td>
					<td>1000円</td>
				</tr>

			</tbody>
		</table>

	</div>

	<jsp:include page="/baselayout/footer.jsp" />
</body>

</html>