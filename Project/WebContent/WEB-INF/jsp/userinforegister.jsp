<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>ユーザー新規登録</title>
<jsp:include page="/baselayout/head.jsp" />
</head>
<body>
	<jsp:include page="/baselayout/header.jsp" />


        <br>
        <br>
        <h1 class="text-center">ユーザー新規登録</h1>
        <jsp:include page="/baselayout/actionMessage.jsp" />
        <br>
        <br>



        <form class="container center" action="UserInfoRegister" method="post">

            ログインID
            <input type="text" class="form-control" name="login_id">
            <br>
            パスワード
            <input type="password" class="form-control" id="exampleInputPassword2" name="password1">
            <br>
            パスワード(確認)
            <input type="password" class="form-control" id="exampleInputPassword2" name="password2">
            <br>
            ユーザー名
            <input type="text" class="form-control" name="name">
            <br>
            生年月日
            <input type="date" class="form-control" name="birth_date">
            <br>
            <br>
            <div class="text-center">
                <button type="submit" class="btn">
                    <span class="margin2">登録</span>
                </button>
            </div>

        </form>

        <br><br><br>

        <div class="margin2">
            <a href="UserInfoManagementTop">戻る</a>
        </div>

        <br><br><br><br><br><br><br>


        <footer class="footer1">testテスト</footer>
    </body>
</html>