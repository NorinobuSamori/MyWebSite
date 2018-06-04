<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>ユーザー管理画面</title>
<jsp:include page="/baselayout/head.jsp" />
</head>
<body class="background-color1">
	<jsp:include page="/baselayout/header.jsp" />
	<div class="container">
		<br>
		<div class="text-center card">
			<h1 class="padding1">ユーザー検索</h1>

			<div class="nav justify-content-end margin2 ">
				<a href="UserInfoRegister">新規登録</a>
			</div>
			<form action="UserInfoManagementTop" method="post">
				<div class="nav justify-content-center">
					<table>
						<tbody>
							<tr>
								<td><div class="marginright120">ログインID</div></td>
								<td>
									<div class="form-group">
										<label for="exampleInputEmail1"></label> <input type="text"
											class="form-control" id="exampleInputEmail1"
											aria-describedby="emailHelp" placeholder="Enter ID"
											name="login_id">
									</div>
								</td>
							</tr>
							<tr>
								<td><div class="marginright120">ユーザ名</div></td>
								<td>
									<div class="form-group">
										<label for="exampleInputEmail1"></label> <input type="text"
											class="form-control" id="exampleInputEmail1"
											aria-describedby="emailHelp" placeholder="Enter NAME"
											name="name">
									</div>
								</td>
							</tr>
							<tr>
								<td>生年月日</td>
								<td>
									<div class="form-group">
										<input type="date" name="calendar1" max="9999-12-31">
										～ <input type="date" name="calendar2" max="9999-12-31">
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<br> <br>
				<div class="text-right margin2">
					<button type="submit">
						<div class="margin2">検索</div>
					</button>
				</div>
			</form>
		</div>
		<hr>
		<!-- ------------------------------------------------------------------------  -->
		<div class="card">
		<h1 class="padding1 text-center">ユーザー一覧</h1>
			<table class="table table-striped ">
				<thead class="thead-dark">
					<tr>
						<th scope="col">login_id</th>
						<th scope="col">name</th>
						<th scope="col">birth_date</th>
						<th scope="col">リンクボタン</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${beansUserInfoAccount.login_id == 'admin'}">
						<c:forEach var="beansUserInfo" items="${beansUserInfoList}"
							begin="0">
							<tr>
								<td>${beansUserInfo.login_id}</td>
								<td>${beansUserInfo.name}</td>
								<td>${beansUserInfo.birth_date}</td>
								<!-- TODO 未実装；ログインボタンの表示制御を行う -->
								<td><a class="btn btn-primary"
									href="UserInfoDetail?id=${beansUserInfo.id}">詳細</a> <a
									class="btn btn-success"
									href="UserInfoUpdate?id=${beansUserInfo.id}">更新</a> <a
									class="btn btn-danger"
									href="UserInfoDelete?id=${beansUserInfo.id}">削除</a></td>
							</tr>
						</c:forEach>
					</c:if>

					<c:if test="${beansUserInfoAccount.login_id != 'admin'}">
						<c:forEach var="beansUserInfo" items="${beansUserInfoList}"
							begin="0">
							<tr>
								<td>${beansUserInfo.login_id}</td>
								<td>${beansUserInfo.name}</td>
								<td>${beansUserInfo.birth_date}</td>
								<!-- TODO 未実装；ログインボタンの表示制御を行う -->
								<td><a class="btn btn-primary"
									href="UserInfoDetail?id=${beansUserInfo.id}">詳細</a> <c:if
										test="${beansUserInfo.login_id == beansUserInfoAccount.login_id}">
										<a class="btn btn-success"
											href="UserInfoUpdate?id=${beansUserInfo.id}">更新</a>
									</c:if></td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
	</div>
	<jsp:include page="/baselayout/footer.jsp" />
</body>

</html>