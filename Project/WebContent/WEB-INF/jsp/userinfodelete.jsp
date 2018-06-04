<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<title>ユーザー情報削除確認</title>
<jsp:include page="/baselayout/head.jsp" />
</head>
<body class="background-color1">
	<jsp:include page="/baselayout/header.jsp" />
	<br>
	<br>
	<div class="container card">

		<h1 class="text-center padding1">ユーザー情報削除確認</h1>
		ログインID：
		<c:out value="${BeansUserInfoScope.login_id}" />
		<br>
		を本当に削除してもよろしいでしょうか。


		<form action="UserInfoManagementTop" method="get">
			<button class="btn  col btncolor1" type="submit">取りやめる</button>
		</form>
		<form action="UserInfoDelete" method="post">
			<input type="hidden" name="id" value="${BeansUserInfoScope.id}">
			<button class="btn col btn2" type="submit">ＯＫ</button>
		</form>


	</div>



	<jsp:include page="/baselayout/footer.jsp" />
</body>

</html>