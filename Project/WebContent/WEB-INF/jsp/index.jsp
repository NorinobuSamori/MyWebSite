<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>TOPページ</title>

<jsp:include page="/baselayout/head.jsp" />
</head>
<body class="background-color1">
	<jsp:include page="/baselayout/header.jsp" />
	<div class="container">

	    <br>
	    <br>
	    <div  class="text-center card grey lighten-5">
		    <h1>トップページ </h1>
		    <c:if test="${beansUserInfoAccount.login_id == 'admin'}">
		    	<a href="MasterEventRegister" class="col padding1">イベントを新規登録する</a>
		    </c:if>
		</div>
	    <br>


	    <jsp:include page="/baselayout/actionMessage.jsp" />




		<jsp:include page="/event-tables/event-summary-table-list.jsp" />
	</div>

    <jsp:include page="/baselayout/footer.jsp" />
</body>

</html>