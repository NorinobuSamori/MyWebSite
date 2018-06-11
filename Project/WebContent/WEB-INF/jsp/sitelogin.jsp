<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<title>ログインページ</title>
<jsp:include page="/baselayout/head.jsp" />
</head>
<body class="background-color1">
	<jsp:include page="/baselayout/header.jsp" />
	<div class="">
		<br>
		<br>
		<div class="container">
			<div class="text-center card grey lighten-5 width25rem">
				<h1>ログイン</h1>
				<jsp:include page="/baselayout/actionMessage.jsp" />

				<br>




				<form action="SiteLogin" method="POST">

					ログインID <input type="text" class="form-control" placeholder="Enter ID" required name="login_id"> <br>
					<br>
					パスワード <input type="password" class="form-control"
						id="exampleInputPassword1" placeholder="Password" required
						name="password">
					<br>

					<p><button class="btn col btncolor1 " type="submit" name="action">ログイン</button></p>
					<br>
					<div class="row">
						<div class="col">
							<p class="text-right"><a href="UserInfoRegister">新規登録</a></p>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="/baselayout/footer.jsp" />
</body>

</html>