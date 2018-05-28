<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>TOPページ</title>
<jsp:include page="/baselayout/head.jsp" />
</head>
<body class="color-lightgreen">
	<jsp:include page="/baselayout/header.jsp" />


    <br>
    <br>
    <h1 class="text-center">トップページタイトル</h1>
    <br>



	<div class="container">
		<jsp:include page="/event-tables/event-summary-table-list.jsp" />
	</div>

    <jsp:include page="/baselayout/footer.jsp" />
</body>

</html>