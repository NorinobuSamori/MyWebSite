<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
<title>ユーザー情報更新</title>
<jsp:include page="/baselayout/head.jsp" />
</head>
<body class="background-color1">
	<jsp:include page="/baselayout/header.jsp" />
    <br>
    <br>
	<div class="container card">

        <h1 class="text-center padding1">ユーザー情報更新</h1>
        <jsp:include page="/baselayout/actionMessage.jsp" />

        <form class="container" action="UserInfoUpdate" method="post">
        	<input type="hidden" class="marginall" name="id" value="${BeansUserInfoScope.id}">
			<input type="hidden" class="marginall" name="login_id" value="${BeansUserInfoScope.login_id}">

            ログインID
            <br>
            ${BeansUserInfoScope.login_id}
            <br>
            <br>
            パスワード
            <input type="password" class="form-control" id="exampleInputPassword2" name="password1">
            <br>
            パスワード(確認)
            <input type="password" class="form-control" id="exampleInputPassword2" name="password2">
            <br>
            ユーザー名
            <input type="text" class="form-control" name="name" value="${BeansUserInfoScope.name}">
            <br>
            生年月日
            <input type="date" class="form-control" name="birth_date" value="${BeansUserInfoScope.birth_date}">
            <br>
            <br>
            <div class="text-center">
                <button type="submit" class="btn" >
                    登録
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