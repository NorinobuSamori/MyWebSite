<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
<title>ユーザー情報詳細参照</title>
<jsp:include page="/baselayout/head.jsp" />
</head>
<body>
	<jsp:include page="/baselayout/header.jsp" />


        <br>
        <br>
        <h1 class="text-center">ユーザー情報詳細参照</h1>

        <br>
        <br>



            <div class="text-center">
                ログインID
                <br>
                <c:out value="${BeansUserInfoScope.login_id}"/>
                <br>
                <br>
                ユーザー名
                <br>
                ${BeansUserInfoScope.name}
                <br>
                <br>
                生年月日
                <br>
                ${BeansUserInfoScope.birth_date}
                <br>
                <br>
                登録日時
                <br>
                ${BeansUserInfoScope.create_date}
                <br>
                <br>
                更新日時
                <br>
                ${BeansUserInfoScope.update_date}
            </div>
            <br>
            <br>
            <br>




        <br><br><br>

        <div class="margin2">
            <a href="UserInfoManagementTop">戻る</a>
        </div>


        <br><br><br><br><br><br><br>


        <footer class="footer1">testテスト</footer>
    </body>
</html>