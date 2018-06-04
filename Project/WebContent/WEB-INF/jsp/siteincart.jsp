<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>カートページ</title>
<jsp:include page="/baselayout/head.jsp" />
</head>
<body class="background-color1">
	<jsp:include page="/baselayout/header.jsp" />
	<div class="container ">

	    <br>
	    <br>
	    <div class="text-center card">
	    	<h1 >カートページ</h1>
	    	<jsp:include page="/baselayout/actionMessage.jsp" />
		</div>
	    <br>
		<br>
		<br>



		<c:if test="${cartNullBySiteInCart != null}" >
			<div class="text-center row">

				<a href="Index" class="btn col btn2">引き続きイベントを探す</a>
		        <a href="SiteInProceedToCheckout" class="btn col btncolor1">レジに進む</a>
		    </div>
	    </c:if>
	    <c:if test="${cartNullBySiteInCart == null}" >
			<div class="text-center ">
		        <a href="Index" class="btn col btncolor1 ">
		            <span class="a">トップページに戻る</span>
		        </a>
		    </div>
	    </c:if>


		<jsp:include page="/event-tables/event-summary-table-list.jsp" />





	</div>

    <jsp:include page="/baselayout/footer.jsp" />
</body>

</html>