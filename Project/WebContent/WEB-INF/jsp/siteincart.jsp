<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>カートページ</title>
<jsp:include page="/baselayout/head.jsp" />
</head>
<body class="color-lightgreen">
	<jsp:include page="/baselayout/header.jsp" />
	<div class="container ">

    <br>
    <br>
    <h1 class="text-center">カートページ</h1>
    <br>
	<jsp:include page="/baselayout/actionMessage.jsp" />
	<br>
	<br>
	<p class="align-center ">
        <a href="SiteInProceedToCheckout" class="btn col btncolor1 ">
            <span class="a">レジに進む</span>
        </a>
    </p>


		<c:forEach var="inCartBeansEventDetailInfoListOne" items="${inCartBeansEventDetailInfoList}"  begin="0">
	        <div class="card grey lighten-5 width1">
	            <div class="class-table width2 border-radius ">
	                <div class="class-table-row ">
	                    <div class="class-table-cell class-table-cell-left2">
	                        <img src="img/${inCartBeansEventDetailInfoListOne.img_name}">
	                    </div>
	                    <div class="class-table-cell class-table-cell-right1">
	                        <h5>
	                        	${inCartBeansEventDetailInfoListOne.title}
							</h5>
	                    </div>
	                </div>
	                <div class="class-table-row">
	                    <div class=" class-table-cell class-table-cell-left1">募集分類</div>
	                    <div class="class-table-cell class-table-cell-right1">${inCartBeansEventDetailInfoListOne.event_category}</div>
	                </div>
	                <div class="class-table-row ">
	                    <div class="class-table-cell class-table-cell-left1">日程</div>
	                    <div class="class-table-cell class-table-cell-right1">${inCartBeansEventDetailInfoListOne.schedule}</div>
	                </div>
	                <div class="class-table-row">
	                    <div class="class-table-cell class-table-cell-left1">参加費用</div>
	                    <div class="class-table-cell class-table-cell-right1">
	                        ${inCartBeansEventDetailInfoListOne.fees}円
	                    </div>
	                </div>
	                <div class="class-table-row">
	                    <div class="class-table-cell class-table-cell-left1">参加資格</div>
	                    <div class="class-table-cell class-table-cell-right1">
	                        ${inCartBeansEventDetailInfoListOne.qualification}
	                    </div>
	                </div>
	                <div class="class-table-row">
	                    <div class="class-table-cell class-table-cell-left1">主催</div>
	                    <div class="class-table-cell class-table-cell-right1">
	                        ${inCartBeansEventDetailInfoListOne.organizer}
	                    </div>
	                </div>
	                <div class="class-table-row">
	                    <div class=" class-table-cell class-table-cell-left1"></div>
	                    <div class="class-table-cell class-table-cell-right1">
	                        <div class="a">
	                            <p class="align-center ">
	                                <a href="SiteEventDetailInfo?event_id=${inCartBeansEventDetailInfoListOne.id}" class="btn col btncolor1 ">
	                                        <span class="a">イベント詳細へ</span>
	                                </a>
	                                <a href="SiteInRemoveFromCart?event_id=${inCartBeansEventDetailInfoListOne.id}" class="btn col btncolor1 ">
	                                        <span class="a">カートから削除する</span>
	                                </a>
	                            </p>
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </c:forEach>
	</div>

    <jsp:include page="/baselayout/footer.jsp" />
</body>

</html>