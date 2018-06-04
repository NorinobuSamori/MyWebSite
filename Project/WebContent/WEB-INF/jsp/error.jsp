<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>エラーページ</title>
<jsp:include page="/baselayout/head.jsp" />
</head>
<body class="color-lightgreen class= background-color1">
	<jsp:include page="/baselayout/header.jsp" />


    <br>
    <br>
    <div class="container">
    	<div class="card grey lighten-5 width1">
    		<h1 class="text-center alert alert-danger">システムエラーが発生しました</h1>
    		<jsp:include page="/baselayout/actionMessage.jsp" />
    		<form action="Index" method ="get">
				<button class="btn  col btncolor1" type="submit">TOPページへ</button>
			</form>
		</div>
	</div>

    <jsp:include page="/baselayout/footer.jsp" />
</body>

</html>