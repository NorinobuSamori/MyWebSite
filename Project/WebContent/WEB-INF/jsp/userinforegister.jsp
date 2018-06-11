<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>ユーザー新規登録</title>
<jsp:include page="/baselayout/head.jsp" />
</head>
<body class="background-color1">
	<jsp:include page="/baselayout/header.jsp" />
	<div class="container center card">


		<h1 class="text-center padding1">ユーザー新規登録</h1>
		<jsp:include page="/baselayout/actionMessage.jsp" />

		<form action="UserInfoRegister" method="post">

			ログインID <input type="text" class="form-control" name="login_id" required>
			<br>
			パスワード <input type="password" class="form-control"
				id="exampleInputPassword2" name="password1" required>
				<br>
			パスワード(確認) <input type="password" class="form-control"
				id="exampleInputPassword2" name="password2" required>
				<br> ユーザー名
			<input type="text" class="form-control" name="name" required>
			<br>
			生年月日 <input type="date" class="form-control" name="birth_date" required>
			<br>
			<br>
			<div class="text-center">
				<button type="submit" class="btn">
					<span class="margin2">登録</span>
				</button>
			</div>

		</form>



		<div class="margin2">
			<a href="UserInfoManagementTop">戻る</a>
		</div>
	</div>
	<jsp:include page="/baselayout/footer.jsp" />
</body>
</html>