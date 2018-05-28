<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<title>ユーザー情報削除確認</title>
<jsp:include page="/baselayout/head.jsp" />
</head>
<body>
	<jsp:include page="/baselayout/header.jsp" />


    <br><br>
    <h3 class="text-center">ユーザー情報削除確認</h3>
    <br><br>
    ログインID：<c:out value="${BeansUserInfoScope.login_id}"/>
    <br>を本当に削除してもよろしいでしょうか。

    <div class="container center">


        <div class="row">
            <div class="col  width50">
				<form action="UserInfoManagementTop" method="get">
                        <button class="btn col btncolor1" type="submit" >
                            取りやめる
                        </button>
                </form>
            </div>
            <span class="col  width50"></span>
            <span class="col  width50"></span>


            <form action="UserInfoDelete" method="post">
                <input type="hidden"  name="id" value="${BeansUserInfoScope.id}">
                <button class="btn  col btncolor1" type="submit" name="action">
                            ＯＫ
                </button>
            </form>






        </div>

    </div>

    <br><br><br><br><br><br><br><br><br><br>


    <footer class="footer1">testテスト</footer>
</body>

</html>