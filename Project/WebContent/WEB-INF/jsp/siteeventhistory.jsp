<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>イベント履歴</title>
<jsp:include page="/baselayout/head.jsp" />
</head>
<body class="background-color1">
	<jsp:include page="/baselayout/header.jsp" />
	<div class="container">

	<br>
	<br>
	<h1 class="text-center card">イベント履歴</h1>
	<br>
	<jsp:include page="/baselayout/actionMessage.jsp" />
	<br>


		<div class="row">
			<div class="col  width50">
				<form action="Index" method="get">
					<button class="btn col btncolor1" type="submit">引き続きイベントを探す</button>
				</form>
			</div>
			<span class="col  width50"></span> <span class="col  width50"></span>
			<form action="UserInfoManagementTop" method="get">
				<button class="btn  col btncolor1" type="submit">ユーザー一覧へ</button>
			</form>
		</div>






		<br>
		<br>
		<c:if test="${orderHistory != null}" >
			<div class="card">

				<h1 class="text-center">決済日時</h1>
				<table class="table color-white">
					<thead>
						<tr>
							<th scope="col">決済日時</th>
							<th scope="col">合計金額</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${orderHistory.getStr_order_create_date()}</td>
							<td>${orderHistory.getTotal_fees()}円</td>
						</tr>
					</tbody>
				</table>
			</div>
		</c:if>




		<c:if test="${orderHistoryEventList != null}" >
			<div class="card">
				<h1 class="text-center">決済したイベントリスト</h1>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">イベント名</th>
							<th scope="col">単価</th>
							<th scope="col">小計</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="orderHistoryEventListOne" items="${orderHistoryEventList}" begin="0">
							<tr>
								<th scope="row">${orderHistoryEventListOne.title}</th>
								<td>${orderHistoryEventListOne.fees}円</td>
								<td>${orderHistoryEventListOne.fees}円</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
		</c:if>






		<c:if test="${orderWhereUserBeansList != null}" >
			<div class="card">
				<h1 class="text-center">決済日時リスト</h1>
				<table class="table color-white">
					<thead>
						<tr>
							<th scope="col">リンク</th>
							<th scope="col">決済日時</th>
							<th scope="col">合計金額</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="orderWhereUserBeansListOne" items="${orderWhereUserBeansList}" begin="0" >
							<tr>
								<th scope="row">
									<h5>
										<a href="SiteOneOrderedHistory?order_id=${orderWhereUserBeansListOne.id}"><i class="fas fa-chevron-circle-down"></i></a>
									</h5>
								</th>
								<td>${orderWhereUserBeansListOne.str_order_create_date}</td>
								<td>${orderWhereUserBeansListOne.total_fees}円</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:if>



	</div>

	<jsp:include page="/baselayout/footer.jsp" />
</body>

</html>