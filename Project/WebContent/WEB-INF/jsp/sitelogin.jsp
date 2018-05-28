<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<title>ログインページ</title>
<jsp:include page="/baselayout/head.jsp" />
</head>
<body>
	<jsp:include page="/baselayout/header.jsp" />

	<jsp:include page="/baselayout/actionMessage.jsp" />


    <div class="container">
        <div class="col">
            <div class="card grey lighten-5 width">
                <form action="SiteLogin" method="POST">
                    <p class="red-text align-center"></p>

                    <span class="a">ログインID</span>
                    <div class="a">
                        <input type="text" class="form-control" placeholder="Enter ID" required name="login_id">
                    </div>
                    <br>
                    <br> パスワード
                    <div class="a">
                        <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" required name="password">
                    </div>

                    <br>

                    <div class="a">
                        <p class="align-center ">
                            <button class="btn col btncolor1 " type="submit" name="action">
                                    <span class="a">ログイン</span>
                                </button>
                        </p>
                        <br>
                    </div>
                    <div class="row">
                        <div class="col ">
                            <p class="align-right">
                                <a href="UserInfoRegister">新規登録</a>
                            </p>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <footer class="footer1">testテスト</footer>
</body>

</html>